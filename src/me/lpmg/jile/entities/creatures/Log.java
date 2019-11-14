package me.lpmg.jile.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.gfx.Animation;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.items.Item;

public class Log extends Creature {

	// Animations
	private Animation animDown, animUp, animLeft, animRight, animIdle;

	private int walkingDirection;
	private int tickCount;
	private boolean attackMode = false;
	private long lastAttackTimer, attackCooldown = 300, attackTimer = attackCooldown;
	private Entity player;
	private Entity focusedHermit;
	private String focusedEntityName = "";
	private boolean frozen = false;

	public Log(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.x = 22;
		bounds.y = 44;
		bounds.width = 19;
		bounds.height = 19;
		speed = 0.5f;

		// Animatons
		animDown = new Animation(250, Assets.log_down);
		animUp = new Animation(250, Assets.log_up);
		animLeft = new Animation(250, Assets.log_left);
		animRight = new Animation(250, Assets.log_right);
		animIdle = new Animation(500, Assets.log_idle);

	}

	@Override
	public void tick() {
		// Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		animIdle.tick();

		checkAttacks();
		if (!frozen) {
			calculateMovement();
			move();
		} else {

		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0) {
			return animLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return animRight.getCurrentFrame();
		} else if (yMove < 0) {
			return animUp.getCurrentFrame();
		} else if (yMove > 0) {
			return animDown.getCurrentFrame();
		} else {
			return animIdle.getCurrentFrame();
		}
	}

	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int) x, (int) y));
		System.out.println("Entity Debug: Log died.");

	}

	private void calculateMovement() {
		xMove = 0;
		yMove = 0;

		if (!attackMode) {
			tickCount++;
			if (tickCount == 120) {
				walkingDirection = (int) (Math.random() * 15) + 1;
				tickCount = 0;
			}

		} else {
			int xDiff = 0;
			int yDiff = 0;

			if (focusedEntityName.equalsIgnoreCase("player")) {
				float playerX = player.getX();
				float playerY = player.getY();
				xDiff = (int) (playerX - x);
				yDiff = (int) (playerY - y);
			} else if (focusedEntityName.equalsIgnoreCase("hermit")) {
				float hermitX = focusedHermit.getX();
				float hermitY = focusedHermit.getY();
				xDiff = (int) (hermitX - x);
				yDiff = (int) (hermitY - y);
			}

			if (xDiff == 0 && yDiff > 0) {
				walkingDirection = 1;
			} else if (xDiff > 0 && yDiff > 0) {
				walkingDirection = 2;
			} else if (xDiff > 0 && yDiff == 0) {
				walkingDirection = 3;
			} else if (xDiff > 0 && yDiff < 0) {
				walkingDirection = 4;
			} else if (xDiff == 0 && yDiff < 0) {
				walkingDirection = 5;
			} else if (xDiff < 0 && yDiff < 0) {
				walkingDirection = 6;
			} else if (xDiff < 0 && yDiff == 0) {
				walkingDirection = 7;
			} else if (xDiff < 0 && yDiff > 0) {
				walkingDirection = 8;
			}

		}

		int up = 1;
		int up_right = 2;
		int right = 3;
		int down_right = 4;
		int down = 5;
		int down_left = 6;
		int left = 7;
		int up_left = 8;

		if (walkingDirection == up) {
			yMove = 1 * speed;
		} else if (walkingDirection == up_right) {
			yMove = 1 * speed;
			xMove = 1 * speed;
		} else if (walkingDirection == right) {
			xMove = 1 * speed;
		} else if (walkingDirection == down_right) {
			yMove = -1 * speed;
			xMove = 1 * speed;
		} else if (walkingDirection == down) {
			yMove = -1 * speed;
		} else if (walkingDirection == down_left) {
			yMove = -1 * speed;
			xMove = -1 * speed;
		} else if (walkingDirection == left) {
			xMove = -1 * speed;
		} else if (walkingDirection == up_left) {
			yMove = 1 * speed;
			xMove = -1 * speed;
		}

	}

	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCooldown)
			return;

		Rectangle cb = getCollisionBounds(0, 0);

		Rectangle searchArea = new Rectangle();
		int searchAreaSize = 200;
		searchArea.width = searchAreaSize;
		searchArea.height = searchAreaSize;
		searchArea.x = cb.x + cb.width / 2 - (searchArea.width / 2);
		searchArea.y = cb.y + cb.height / 2 - (searchArea.height / 2);

		Rectangle attackArea = new Rectangle();
		int attackAreaSize = 50;
		attackArea.width = attackAreaSize;
		attackArea.height = attackAreaSize;
		attackArea.x = cb.x + cb.width / 2 - (attackArea.width / 2);
		attackArea.y = cb.y + cb.height / 2 - (attackArea.height / 2);

		attackTimer = 0;

		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			// search
			if (e.getCollisionBounds(0, 0).intersects(searchArea)
					&& e.equals(handler.getWorld().getEntityManager().getPlayer())) {
				player = handler.getWorld().getEntityManager().getPlayer();
				focusedEntityName = "player";
				attackMode = true;
			} else if (e.getCollisionBounds(0, 0).intersects(searchArea) && e instanceof Hermit) {
				focusedHermit = e;
				focusedEntityName = "hermit";
				attackMode = true;
			} else {
				tickCount++;
				if (tickCount == 120) {
					attackMode = false;
					frozen = false;
					tickCount = 0;
				}
			}
			// attack
			if (e.getCollisionBounds(0, 0).intersects(attackArea)
					&& e.equals(handler.getWorld().getEntityManager().getPlayer())) {
				player = handler.getWorld().getEntityManager().getPlayer();
				focusedEntityName = "player";
				e.hurt(1);
				frozen = false;
			} else if (e.getCollisionBounds(0, 0).intersects(attackArea) && e instanceof Hermit) {
				focusedHermit = e;
				focusedEntityName = "hermit";
				e.hurt(1);
				frozen = true;
			}
		}
	}

}
