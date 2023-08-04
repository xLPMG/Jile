package me.lpmg.jile.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.gfx.Animation;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.items.Item;
import me.lpmg.jile.tiles.Tile;

public class Sorcerer extends Creature {

	// Animations
	private Animation animDown, animUp, animLeft, animRight, animIdleLeft, animIdleRight, animAttackLeft,
			animAttackRight;

	private int walkingDirection;
	private int tickCount;
	private boolean attackMode = false;
	private long lastAttackTimer, attackCooldown = 300, attackTimer = attackCooldown;
	private Entity player;
	private Entity focusedHermit;
	private String focusedEntityName = "";
	private boolean frozen = false;

	public Sorcerer(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_HEIGHT + 16, Creature.DEFAULT_CREATURE_HEIGHT + 16);

		bounds.x = 32;
		bounds.y = 55;
		bounds.width = 64;
		bounds.height = 64;
		speed = 0.5f;
		moneyOnDeath = 5;
		xpOnDeath = 8;

		// Animatons
		animDown = new Animation(200, Assets.sorcerer_down);
		animUp = new Animation(200, Assets.sorcerer_up);
		animLeft = new Animation(200, Assets.sorcerer_left);
		animRight = new Animation(200, Assets.sorcerer_right);
		animIdleLeft = new Animation(200, Assets.sorcerer_idleLeft);
		animIdleRight = new Animation(200, Assets.sorcerer_idleRight);
		animAttackLeft = new Animation(100, Assets.sorcerer_attack_left);
		animAttackRight = new Animation(100, Assets.sorcerer_attack_right);
	}

	@Override
	public void tick() {
		// Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		animIdleLeft.tick();
		animIdleRight.tick();
		animAttackLeft.tick();
		animAttackRight.tick();

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
//		g.setColor(Color.YELLOW);
//		g.drawRect((int) (x - handler.getGameCamera().getxOffset()) + bounds.x,
//				(int) (y - handler.getGameCamera().getyOffset()) + bounds.y, bounds.width, bounds.height);

		g.setColor(Color.GREEN);
		if (attackMode) {
			g.setColor(Color.RED);
		}
		if (player != null) {
			int playerX = (int) ((player.getX() + (player.getWidth() / 2)) - handler.getGameCamera().getxOffset());
			int playerY = (int) ((player.getY() + (player.getHeight() / 2)) - handler.getGameCamera().getyOffset());
			int logX = (int) ((x + (width / 2)) - handler.getGameCamera().getxOffset());
			int logY = (int) ((y + (height / 2)) - handler.getGameCamera().getyOffset());
//			g.drawLine(logX, logY, playerX, playerY);

			// TODO
			g.setColor(Color.BLUE);
			Rectangle cb = getCollisionBounds(0, 0);
			Rectangle searchArea = new Rectangle();
			int searchAreaSize = 200;
			searchArea.width = searchAreaSize;
			searchArea.height = searchAreaSize;
			searchArea.x = cb.x + cb.width / 2 - (searchArea.width / 2);
			searchArea.y = cb.y + cb.height / 2 - (searchArea.height / 2);

//			g.drawRect((int) ((searchArea.x) - handler.getGameCamera().getxOffset()),
//					(int) ((searchArea.y) - handler.getGameCamera().getyOffset()), searchArea.width, searchArea.height);

			g.setColor(Color.RED);
			Rectangle attackArea = new Rectangle();
			int attackAreaSize = 50;
			attackArea.width = (int) (attackAreaSize * 3);
			attackArea.height = attackAreaSize + (attackAreaSize / 2);
			attackArea.x = cb.x + cb.width / 2 - (attackArea.width / 2) + 8;
			attackArea.y = cb.y + cb.height / 2 - (attackArea.height / 2);
//			g.drawRect((int) ((attackArea.x) - handler.getGameCamera().getxOffset()),
//					(int) ((attackArea.y) - handler.getGameCamera().getyOffset()), attackArea.width, attackArea.height);

			
			int tileLeftY = (int) ((int)y- handler.getGameCamera().getyOffset())+Tile.TILEHEIGHT-8;
			int tileRightX = ((int) ((int)x- handler.getGameCamera().getxOffset()+Creature.DEFAULT_CREATURE_WIDTH)+Tile.TILEWIDTH/2);
//			g.drawRect(tileRightX,tileLeftY,Tile.TILEWIDTH,Tile.TILEHEIGHT);
		}
	}

	private BufferedImage getCurrentAnimationFrame() {
		if (xMove != 0 || yMove != 0 && !attackMode) { // =walking
			if (walkingDirection == 1) {
				return animUp.getCurrentFrame();
			} else if (walkingDirection == 2 || walkingDirection == 3 || walkingDirection == 4) {
				return animRight.getCurrentFrame();
			} else if (walkingDirection == 5) {
				return animDown.getCurrentFrame();
			} else if (walkingDirection == 6 || walkingDirection == 7 || walkingDirection == 8) {
				return animLeft.getCurrentFrame();
			}
		} else { // =standing still
			if (!attackMode) {
				if (walkingDirection == 1) {
					return animUp.getCurrentFrame();
				} else if (walkingDirection == 2 || walkingDirection == 3 || walkingDirection == 4) {
					return animIdleRight.getCurrentFrame();
				} else if (walkingDirection == 5) {
					return animDown.getCurrentFrame();
				} else if (walkingDirection == 6 || walkingDirection == 7 || walkingDirection == 8) {
					return animIdleLeft.getCurrentFrame();
				}
			}
		}

		// attacking
		if (attackMode) {
			if (walkingDirection == 1) {
				return animUp.getCurrentFrame();
			} else if (walkingDirection == 2 || walkingDirection == 4) {
				return animRight.getCurrentFrame();
			}else if (walkingDirection == 3) {
				return animAttackRight.getCurrentFrame();
			} else if (walkingDirection == 5) {
				return animDown.getCurrentFrame();
			} else if (walkingDirection == 7) {
				return animAttackLeft.getCurrentFrame();
			}else if (walkingDirection == 6 || walkingDirection == 8) {
				return animLeft.getCurrentFrame();
			}
		}

		return animIdleLeft.getCurrentFrame();
	}

	@Override
	public void die() {
		handler.getWorld().getItemManager()
				.addItem(Item.woodItem.createNew((int) x + bounds.x / 2, (int) y + bounds.y / 2));
		System.out.println("Entity Debug: Log died.");

	}

	private void calculateMovement() {
		xMove = 0;
		yMove = 0;
		if (!attackMode) {
			tickCount++;
			if (tickCount == 240) {
				walkingDirection = (int) (Math.random() * 15) + 1;
				System.out.println("test");
				tickCount = 0;
			}

		} else {
			int xDiff = 0;
			int yDiff = 0;

			if (focusedEntityName.equalsIgnoreCase("player")) {
				float playerX = player.getX() + (player.getWidth() / 2);
				float playerY = player.getY() + (player.getHeight() / 2);
				xDiff = (int) (playerX - (x + (width / 2)));
				yDiff = (int) (playerY - (y + (height / 2)));
			} else if (focusedEntityName.equalsIgnoreCase("hermit")) {
				float hermitX = focusedHermit.getX();
				float hermitY = focusedHermit.getY();
				xDiff = (int) (hermitX - x);
				yDiff = (int) (hermitY - y);
			}

			//standard walking
			if (yDiff > 0) {
				walkingDirection = 5;
				yMove = 2 * speed;
			} else if (yDiff < 0) {
				walkingDirection = 1;
				yMove = -2 * speed;
			} else if (yDiff == 0) {
				if (xDiff > 0) {
					walkingDirection = 3;
					xMove = 2 * speed;
				} else if (xDiff < 0) {
					walkingDirection = 7;
					xMove = -2 * speed;
				}
			}
			// blocked way up and down
			int tyUp = (int) (y + bounds.y-2*speed) / Tile.TILEHEIGHT;
			int tyDown = (int) (y + bounds.y+2*speed) / Tile.TILEHEIGHT;

			int txExactAndGraphical = (int) (x + Creature.DEFAULT_CREATURE_WIDTH / 2) / (Tile.TILE_BOUND_HEIGHT * 4);
			int tyExactAndGraphicalUp = (int) (y + -2 * speed + bounds.y) / Tile.TILE_BOUND_HEIGHT;
			int tyExactAndGraphicalDown = (int) (y + 2 * speed + bounds.y) / Tile.TILE_BOUND_HEIGHT;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, tyUp)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, tyUp)
					&& !collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, tyDown)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, tyDown)) {
				if (xDiff > 0) {
					walkingDirection = 3;
					xMove = 2 * speed;
				} else if (xDiff < 0) {
					walkingDirection = 7;
					xMove = -2 * speed;
				}
			}

			// blocked way left and right
			int txLeft = (int) ((int)x-Tile.TILEWIDTH/2);
			int txRight = ((int) ((int)x+Creature.DEFAULT_CREATURE_WIDTH)+Tile.TILEWIDTH/2);
			
			int tileSideY = (int) ((int)y)+Tile.TILEHEIGHT-8;

			System.out.println(handler.getWorld().getTile(txRight/ Tile.TILEWIDTH, tileSideY/Tile.TILEHEIGHT));
			System.out.println(txRight/ Tile.TILEWIDTH+":"+tileSideY/Tile.TILEHEIGHT);
			
			if (!collisionWithTile(txLeft/ Tile.TILEWIDTH, tileSideY/Tile.TILEHEIGHT)
					&& !collisionWithTile(txRight/ Tile.TILEWIDTH, tileSideY/Tile.TILEHEIGHT)) {
				if (yDiff > 0) {
					walkingDirection = 5;
					yMove = 2 * speed;
				} else if (yDiff < 0) {
					walkingDirection = 1;
					yMove = -2 * speed;
				}
			}else {
				//TODO
				//move around
			}

			if (Math.abs(xDiff) == 100) {
				xMove = 0;
			} else if (xDiff > 0 && xDiff < 100) {
				walkingDirection = 7;
				xMove = -5 * speed;
			} else if (xDiff < 0 && xDiff > -100) {
				walkingDirection = 3;
				xMove = 5 * speed;
			}

			if (Math.abs(xDiff) > 800 || Math.abs(yDiff) > 800) {
				attackMode = false;
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
		if (!attackMode) {
			if (walkingDirection == up) {
				yMove = -1 * speed;
			} else if (walkingDirection == up_right) {
				yMove = -1 * speed;
				xMove = 1 * speed;
			} else if (walkingDirection == right) {
				xMove = 1 * speed;
			} else if (walkingDirection == down_right) {
				yMove = 1 * speed;
				xMove = 1 * speed;
			} else if (walkingDirection == down) {
				yMove = 1 * speed;
			} else if (walkingDirection == down_left) {
				yMove = 1 * speed;
				xMove = -1 * speed;
			} else if (walkingDirection == left) {
				xMove = -1 * speed;
			} else if (walkingDirection == up_left) {
				yMove = -1 * speed;
				xMove = -1 * speed;
			}
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
		attackArea.width = (int) (attackAreaSize * 3);
		attackArea.height = attackAreaSize + (attackAreaSize / 2);
		attackArea.x = cb.x + cb.width / 2 - (attackArea.width / 2) + 8;
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
