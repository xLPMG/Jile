package me.lpmg.jile.entities.creatures;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.gfx.Animation;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.inventory.Inventory;
import me.lpmg.jile.inventory.ItemBar;
import me.lpmg.jile.items.Item;
import me.lpmg.jile.miscgui.Healthbar;
import me.lpmg.jile.miscgui.StatsGUI;
import me.lpmg.jile.states.DeadState;
import me.lpmg.jile.states.MenuState;
import me.lpmg.jile.states.OptionsState;
import me.lpmg.jile.states.State;
import me.lpmg.jile.tiles.Tile;

public class Player extends Creature {

	// Animations
	private Animation animDown, animDownNormal, animDownFast, animUp, animUpNormal, animUpFast, animLeft,
			animLeftNormal, animLeftFast, animRight, animRightNormal, animRightFast, animIdleUp, animIdleDown,
			animIdleLeft, animIdleRight, animAttackDown, animAttackUp, animAttackLeft, animAttackRight;
	// Attack timer
	private long lastAttackTimer, attackCooldown = 100, attackTimer = attackCooldown;
	// Inventory
	private Inventory inventory;
	private ItemBar itemBar;

	private Healthbar healthbar;
	private StatsGUI statsGUI;

	private int attackDirection = 0;
	private int healthTickCount;
	private int defaultMaxHealth = maxHealth;
	private int defaultMaxMana = maxMana;
	private int manaTickCount;
	private float defaultSpeed;
	private float sprintSpeed;
	private boolean frozen = false;

	private int damagePerHit = 2;
	private int defaultDamagePerHit = damagePerHit;

	private int money;
	private int totalEarnedMoney;
	private int deathCount;
	private int healthRegenSpeed = 200;
	private int defaultHealthRegenSpeed = healthRegenSpeed;
	private int manaRegenSpeed = 260;
	private int defaultManaRegenSpeed = manaRegenSpeed;

	private int multiplierVT= PLAYER_HEIGHT / 32;
	private int multiplierHZ = PLAYER_WIDTH / 32;
	private String playerName = "???";
	private int walkingDirection = 2;
	private boolean invincible = false;

	private boolean isSprinting = false;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.PLAYER_WIDTH, Creature.PLAYER_HEIGHT);

		bounds.x = 6 * multiplierHZ;
		bounds.y = 16 * multiplierVT; // 19*3
		bounds.width = 22 * multiplierHZ; // 9*3
		bounds.height = 16 * multiplierVT; // 4*3
		speed = 1.5f;
		defaultSpeed = speed;
		sprintSpeed = 3.0f;
		money = 0;

		// Animatons
		animDownNormal = new Animation(200, Assets.player_down);
		animDownFast = new Animation(150, Assets.player_down);
		animDown = animDownNormal;

		animUpNormal = new Animation(200, Assets.player_up);
		animUpFast = new Animation(150, Assets.player_up);
		animUp = animUpNormal;

		animLeftNormal = new Animation(200, Assets.player_left);
		animLeftFast = new Animation(150, Assets.player_left);
		animLeft = animLeftNormal;

		animRightNormal = new Animation(200, Assets.player_right);
		animRightFast = new Animation(150, Assets.player_right);
		animRight = animRightNormal;

		animIdleUp = new Animation(500, Assets.player_idleUp);
		animIdleDown = new Animation(500, Assets.player_idleDown);
		animIdleLeft = new Animation(500, Assets.player_idleLeft);
		animIdleRight = new Animation(500, Assets.player_idleRight);

		animAttackDown = new Animation(100, Assets.player_attack_down);
		animAttackUp = new Animation(100, Assets.player_attack_up);
		animAttackLeft = new Animation(100, Assets.player_attack_left);
		animAttackRight = new Animation(100, Assets.player_attack_right);

		inventory = new Inventory(handler, this);
		handler.getGame().loadPlayerInventory(this);
		itemBar = new ItemBar(handler, inventory);
		healthbar = new Healthbar(handler, this);
		statsGUI = new StatsGUI(handler, this);

		KeyAdapter kA = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (inventory.isActive())
					return;

				if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
					speed = sprintSpeed;
					animDown = animDownFast;
					animUp = animUpFast;
					animLeft = animLeftFast;
					animRight = animRightFast;
					isSprinting = true;
				}

				else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (State.getState() instanceof OptionsState) {
						State.setState(handler.getGame().gameState);
					} else {
						State.setState(new OptionsState(handler));
					}

				} else if (e.getKeyCode() == KeyEvent.VK_H) {
					healthWithMana(15);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (inventory.isActive())
					return;

				if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
					speed = defaultSpeed;
					animDown = animDownNormal;
					animUp = animUpNormal;
					animLeft = animLeftNormal;
					animRight = animRightNormal;
					isSprinting = false;
				}
			}
		};
		handler.addKeyListener(kA);

	}

	@Override
	public void tick() {
		// System.out.println(frozen);
		// Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		animIdleUp.tick();
		animIdleDown.tick();
		animIdleLeft.tick();
		animIdleRight.tick();
		animAttackDown.tick();
		animAttackUp.tick();
		animAttackLeft.tick();
		animAttackRight.tick();
		if (!frozen) {
			// Movement
			getInput();
			checkInteraction();
		}
		move();
		handler.getGameCamera().centerOnEntity(this);
		// Attack
		checkAttacks();
		// Health
		regenerate();
		// Inventory
		inventory.tick();
		itemBar.tick();
		healthbar.tick();
		statsGUI.tick();
		if (invincible) {
			health = maxHealth;
		}

		if (totalEarnedMoney < money) {
			totalEarnedMoney = money;
		}
	}

	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCooldown)
			return;

		if (inventory.isActive())
			return;

		healthbar.hideCorner();
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;

		if (handler.getKeyManager().up && handler.getMouseManager().isRightPressed()) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
			attackDirection = 1;
		} else if (handler.getKeyManager().down && handler.getMouseManager().isRightPressed()) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
			attackDirection = 2;
		} else if (handler.getKeyManager().left && handler.getMouseManager().isRightPressed()) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
			attackDirection = 3;
		} else if (handler.getKeyManager().right && handler.getMouseManager().isRightPressed()) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
			attackDirection = 4;
		} else {
			attackDirection = 0;
			return;
		}

		attackTimer = 0;

		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0, 0).intersects(ar)) {
				healthbar.showCorner();
				e.hurt(damagePerHit);
				// System.out.println("Hitting " + e);
				if (e.getHealth() <= 0 && e instanceof Creature) {
					addMoney(((Creature) e).getMoneyOnDeath());
				}
				if (e instanceof Merchant) {
					mana -= 1;
				}
				return;
			}
		}

	}

	@Override
	public void die() {
		deathCount += 1;
		State.setState(new DeadState(handler));
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (inventory.isActive())
			return;

		if (handler.getKeyManager().up) {
			yMove = -speed;
			walkingDirection = 0;
		}
		if (handler.getKeyManager().down) {
			yMove = speed;
			walkingDirection = 2;
		}
		if (handler.getKeyManager().left) {
			xMove = -speed;
			walkingDirection = 3;
		}
		if (handler.getKeyManager().right) {
			xMove = speed;
			walkingDirection = 1;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	public void postRender(Graphics g) {
		healthbar.render(g);
		itemBar.render(g);
		statsGUI.render(g);
		renderMoney(g);
		inventory.render(g);
	}

	private void renderMoney(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(Assets.font48);
		g2.setColor(Color.WHITE);
		FontMetrics fontMetrics = g2.getFontMetrics();
		String moneyString = Integer.toString(money);
		// g2.drawImage(Assets.money_bar, (handler.getWidth()-32) -
		// (fontMetrics.stringWidth(moneyString)+4), 0, 256, 39,null);

		g2.drawString(moneyString, (handler.getWidth() - 32) - fontMetrics.stringWidth(moneyString), 35);

		g.drawImage(Assets.coin, handler.getWidth() - 32, 4, 32, 32, null);
	}

	private BufferedImage getCurrentAnimationFrame() {
		if (frozen) {
			if (walkingDirection == 0) {
				return animIdleUp.getCurrentFrame();
			} else if (walkingDirection == 1) {
				return animIdleRight.getCurrentFrame();
			} else if (walkingDirection == 2) {
				return animIdleDown.getCurrentFrame();
			} else if (walkingDirection == 3) {
				return animIdleLeft.getCurrentFrame();
			}
		}

		if (xMove < 0) {
			return animLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return animRight.getCurrentFrame();
		} else if (yMove < 0) {
			return animUp.getCurrentFrame();
		} else if (yMove > 0) {
			return animDown.getCurrentFrame();
		} else if (attackDirection == 1) {
			return animAttackUp.getCurrentFrame();
		} else if (attackDirection == 2) {
			return animAttackDown.getCurrentFrame();
		} else if (attackDirection == 3) {
			return animAttackLeft.getCurrentFrame();
		} else if (attackDirection == 4) {
			return animAttackRight.getCurrentFrame();
		} else {
			if (walkingDirection == 0) {
				return animIdleUp.getCurrentFrame();
			} else if (walkingDirection == 1) {
				return animIdleRight.getCurrentFrame();
			} else if (walkingDirection == 2) {
				return animIdleDown.getCurrentFrame();
			} else if (walkingDirection == 3) {
				return animIdleLeft.getCurrentFrame();
			}
		}
		return animIdleDown.getCurrentFrame();
	}

	private void healthWithMana(int amount) {
		if (amount > mana) {
			amount = mana;
		}
		if (health + amount > maxHealth) {
			amount = maxHealth - health;
		}
		if (health < maxHealth && mana >= amount) {
			health += amount;
			mana -= amount;
		}
		if (mana > maxMana) {
			mana = maxMana;
		}
		if (health > maxHealth) {
			health = maxHealth;
		}
	}

	private void regenerate() {
		if (health < maxHealth) {
			healthTickCount++;
			if (healthTickCount >= healthRegenSpeed) {
				health += 1;
				healthTickCount = 0;
			}
		} else if (health > maxHealth) {
			health = maxHealth;
		}

		if (mana < maxMana) {
			manaTickCount++;
			if (manaTickCount >= manaRegenSpeed) {
				mana += 1;
				manaTickCount = 0;
			}
		} else if (mana > maxMana) {
			mana = maxMana;
		}
	}

	public void resetPlayer() {
		health = maxHealth;
		mana = maxMana;
		money = 0;
		ArrayList<Item> invItems = inventory.getInventoryItems();
		invItems.clear();
		inventory.setInventoryItems(invItems);

		HashMap<String, Integer> equippedItems = inventory.getEquippedItems();
		equippedItems.clear();
		inventory.setEquippedItems(equippedItems);
	}

	private void checkInteraction() {
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;

		if (handler.getKeyManager().up && handler.getMouseManager().isLeftPressed()) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		} else if (handler.getKeyManager().down && handler.getMouseManager().isLeftPressed()) {
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		} else if (handler.getKeyManager().left && handler.getMouseManager().isLeftPressed()) {
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else if (handler.getKeyManager().right && handler.getMouseManager().isLeftPressed()) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		} else {
			return;
		}

		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0, 0).intersects(ar) && e instanceof Merchant) {
				((Merchant) e).interact();
				return;
			}
		}
		// TODO
//		if (handler.getWorld().getSecondLayerTile(ar.x / 64, ar.y / 64) == Tile.sign1Tile) {
//
//		}
	}

	public int getDefaultMaxHealth() {
		return defaultMaxHealth;
	}

	public int getDefaultMaxMana() {
		return defaultMaxMana;
	}

	public int getDefaultDamagePerHit() {
		return defaultDamagePerHit;
	}

	public int getDamagePerHit() {
		return damagePerHit;
	}

	public void setDamagePerHit(int damagePerHit) {
		this.damagePerHit = damagePerHit;
	}

	public float getDefaultSpeed() {
		return defaultSpeed;
	}

	public float getSprintSpeed() {
		return sprintSpeed;
	}

	public int getHealthRegenSpeed() {
		return healthRegenSpeed;
	}

	public void setHealthRegenSpeed(int healthRegenSpeed) {
		this.healthRegenSpeed = healthRegenSpeed;
	}

	public int getDefaultHealthRegenSpeed() {
		return defaultHealthRegenSpeed;
	}

	public int getManaRegenSpeed() {
		return manaRegenSpeed;
	}

	public void setManaRegenSpeed(int manaRegenSpeed) {
		this.manaRegenSpeed = manaRegenSpeed;
	}

	public int getDefaultManaRegenSpeed() {
		return defaultManaRegenSpeed;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public ItemBar getItemBar() {
		return itemBar;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void addMoney(int money) {
		totalEarnedMoney += money;
		this.money += money;
	}

	public void subtractMoney(int money) {
		this.money -= money;
	}

	public int getTotalEarnedMoney() {
		return totalEarnedMoney;
	}

	public void setTotalEarnedMoney(int totalEarnedMoney) {
		this.totalEarnedMoney = totalEarnedMoney;
	}

	public void freeze(boolean freeze) {
		frozen = freeze;
		xMove = 0;
		yMove = 0;
	}

	public void setPlayerName(String name) {
		playerName = name;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setWalkingDirection(int direction) {
		walkingDirection = direction;
	}

	public void setInvincible(boolean invincible) {
		this.invincible = invincible;
	}

	public boolean isSprinting() {
		return isSprinting;
	}

	public int getDeathCount() {
		return deathCount;
	}

	public void setDeathCount(int deathCount) {
		this.deathCount = deathCount;
	}
}
