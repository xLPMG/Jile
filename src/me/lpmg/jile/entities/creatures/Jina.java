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
	private Animation animDown, animUp, animLeft, animRight, animIdleUp, animIdleDown, animIdleLeft, animIdleRight, animAttackDown, animAttackUp, animAttackLeft,
			animAttackRight;
	
	private int tickCount;
	private boolean attackMode = false;
	private long lastAttackTimer, attackCooldown = 300, attackTimer = attackCooldown;
	private boolean frozen = false;
	private int multiplier = PLAYER_HEIGHT / 32;
	private EmoteManager eM;
	private int walkingDirection = 2;

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
		animIdleUp = new Animation(500, Assets.jina_idleUp);
		animIdleDown = new Animation(500, Assets.jina_idleDown);
		animIdleLeft = new Animation(500, Assets.jina_idleLeft);
		animIdleRight = new Animation(500, Assets.jina_idleRight);
	}

	@Override
	public void tick() {
		// Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		animIdleUp.tick();
		animIdleDown.tick();
		animIdleLeft.tick();
		animIdleRight.tick();

		checkAttacks();
		if (!frozen) {
			move();
		}
		
		if(health<maxHealth) {
			health=maxHealth;
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

	@Override
	public void die() {
	}

	private void checkAttacks() {
	}

	public void firstEncounter() {
//		meetplayerThread.start();
		handler.getWorld().getSpeechDialogueManager().showDialog("!JinaFirstEncounter");
	}
	
	Thread meetplayerThread = new Thread() {
		public void run() {
			// get and freeze player
			Player player = handler.getWorld().player;
			player.freeze(true);
			player.setInvincible(true);
			player.setWalkingDirection(0);
			float playerY = player.getY();
			// shows exclamation emote
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
//			handler.getWorld().getSpeechToastManager().showToast("!JinaFirstEncounter");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// ask for name
//			handler.getWorld().getSpeechToastManager().showToast("!JinaFirstEncounter2");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String name = JOptionPane.showInputDialog(null, "How would you like to be called?", "Jile "+handler.getGame().getVersion(),
					JOptionPane.QUESTION_MESSAGE);
			if (name == null || name.equalsIgnoreCase("")) {
				name = "Luca";
			}
			handler.getWorld().player.setPlayerName(name);
//			handler.getWorld().getSpeechToastManager().showToast("!JinaFirstEncounterPlayerName");
			try {
				Thread.sleep(10100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//go outside
			player.yMove=1*speed;
			player.setWalkingDirection(2);
			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			x=player.getX();
			y=player.getY()-64;
			xMove=-1*speed;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			xMove=0;
			player.yMove=0*player.speed;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			yMove=1*speed;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			yMove=0;
			walkingDirection=1;
			player.setWalkingDirection(3);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			handler.getWorld().getSpeechToastManager().showToast("!JinaLogs");
			try {
				Thread.sleep(12500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			handler.getWorld().getSpeechToastManager().showToast("!JinaLogsPlayerResponse");
			try {
				Thread.sleep(9600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			handler.getWorld().getSpeechToastManager().showToast("!JinaLogs2");
			try {
				Thread.sleep(14000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			handler.getWorld().getSpeechToastManager().showToast("!JinaLogsPlayerResponse2");
			try {
				Thread.sleep(5800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			handler.getWorld().getSpeechToastManager().showToast("!JinaLogs3");
			try {
				Thread.sleep(13600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			handler.getWorld().getSpeechToastManager().showToast("!JinaLogsPlayerResponse3");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			handler.getWorld().getSpeechToastManager().showToast("!JinaLogs4");
		}
	};
}
