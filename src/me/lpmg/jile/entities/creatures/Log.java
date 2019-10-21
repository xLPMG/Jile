package me.lpmg.jile.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Animation;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.items.Item;

public class Log extends Creature {
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight, animIdle;
	
	int randomDirection;
	int tickCount;
	
	public Log(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 22;
		bounds.y = 44;
		bounds.width = 19;
		bounds.height = 19;
		speed = 0.5f;
		
		//Animatons
		animDown = new Animation(250, Assets.log_down);
		animUp = new Animation(250, Assets.log_up);
		animLeft = new Animation(250, Assets.log_left);
		animRight = new Animation(250, Assets.log_right);
		animIdle = new Animation(500, Assets.log_idle);
	}

	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		animIdle.tick();

		calculateMovement();
		move();

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			return animUp.getCurrentFrame();
		}else if(yMove > 0){
			return animDown.getCurrentFrame();
		}else{
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
        tickCount++;
        if(tickCount==120) {
		randomDirection = (int)(Math.random() * 15) + 1; 
		tickCount = 0;
        }
		int up = 1;
		int up_right = 2;
		int right = 3;
		int down_right = 4;
		int down = 5;
		int down_left = 6;
		int left = 7;
		int up_left = 8;
		
		if(randomDirection==up) {
			yMove = 1*speed;
		}else if(randomDirection==up_right) {
			yMove = 1*speed;
			xMove = 1*speed;
		}else if(randomDirection==right) {
			xMove = 1*speed;
		}else if(randomDirection==down_right) {
			yMove = -1*speed;
			xMove = 1*speed;
		}else if(randomDirection==down) {
			yMove = -1*speed; 
		}else if(randomDirection==down_left) {
			yMove = -1*speed;
			xMove = -1*speed;
		}else if(randomDirection==left) {
			xMove = -1*speed;
		}else if(randomDirection==up_left) {
			yMove = 1*speed;
			xMove = -1*speed;
		}

	}

}
