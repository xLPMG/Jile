package me.lpmg.jile.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.gfx.Animation;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.gfx.EmoteManager;
import me.lpmg.jile.items.Item;

public class Jina extends Creature {

	// Animations
	private Animation animDown, animUp, animLeft, animRight, animIdle, animAttackDown, animAttackUp, animAttackLeft,
			animAttackRight;

	private int walkingDirection;
	private int tickCount;
	private boolean attackMode = false;
	private long lastAttackTimer, attackCooldown = 300, attackTimer = attackCooldown;
	private boolean frozen = false;
	private int multiplier = PLAYER_HEIGHT / 32;
	private EmoteManager eM;

	public Jina(Handler handler, float x, float y) {
		super(handler, x, y, Creature.PLAYER_WIDTH, Creature.PLAYER_HEIGHT);

		bounds.x = 6 * multiplier;
		bounds.y = 16 * multiplier; // 19*3
		bounds.width = 22 * multiplier; // 9*3
		bounds.height = 16 * multiplier; // 4*3
		speed = 2.0f;

		// Animatons
		animDown = new Animation(250, Assets.jina_down);
		animUp = new Animation(250, Assets.jina_up);
		animLeft = new Animation(250, Assets.jina_left);
		animRight = new Animation(250, Assets.jina_right);
		animIdle = new Animation(500, Assets.jina_idle);

		eM = handler.getWorld().getEmoteManager();

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
	}

	private void calculateMovement() {
		xMove = 0;
		yMove = 0;

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
	}

	public void firstEncounter() {
		meetplayerThread.start();
	}

	Thread meetplayerThread = new Thread() {
		public void run() {
			// get and freeze player
			Player player = handler.getWorld().player;
			player.freeze(true);
			player.setWalkingDirection(0);
			float playerY = player.getY();
			// shoe exclamation emote
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			eM.showEmote(Assets.emote_exclamations, (int) x + player.getWidth() / 4, (int) y - 40, 32, 32);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			eM.stopShowingEmote();
			// walk towards player
			while ((int) (playerY - y) > 75) {
				System.out.println((int) (playerY - y));
				yMove = 1 * speed;
			}
			yMove = 0;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// say hi to player
			handler.getWorld().getSpeechToastManager().showToast("!JinaFirstEncounter");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// ask for name
			handler.getWorld().getSpeechToastManager().showToast("!JinaFirstEncounter2");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String name = JOptionPane.showInputDialog(null, "How would you like to be called?", "Jile "+handler.getGame().getVersion(),
					JOptionPane.QUESTION_MESSAGE);
			if (name == null || name.equalsIgnoreCase("")) {
				name = "Luca";
			}
			handler.getWorld().player.setPlayerName(name);
			handler.getWorld().getSpeechToastManager().showToast("!JinaFirstEncounterPlayerName");
		}
	};
}
