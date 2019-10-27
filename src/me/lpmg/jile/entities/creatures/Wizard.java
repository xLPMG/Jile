package me.lpmg.jile.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Animation;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.items.Item;
import me.lpmg.jile.wizardmenu.WizardMenu;

public class Wizard extends Creature {
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight, animIdle;
	private WizardMenu wizardMenu; 
	private int walkingDirection;
	private int tickCount;
	private float defspeed;
	
	public Wizard(Handler handler, float x, float y) {
		super(handler, x, y, Creature.PLAYER_WIDTH, Creature.PLAYER_HEIGHT);
		
		bounds.x = 3*3;
		bounds.y = 22*3; //19*3
		bounds.width = 11*3; //9*3
		bounds.height = 8*3; //4*3
		speed = 0.5f;
		defspeed = speed;
		
		//Animatons
		animDown = new Animation(250, Assets.wizard_down);
		animUp = new Animation(250, Assets.wizard_up);
		animLeft = new Animation(250, Assets.wizard_left);
		animRight = new Animation(250, Assets.wizard_right);
		animIdle = new Animation(500, Assets.wizard_idle);
		
		wizardMenu = new WizardMenu(handler);
	}

	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		animIdle.tick();

		regenerate();
		calculateMovement();
		move();
		wizardMenu.tick();

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	public void renderMenu(Graphics g) {
		wizardMenu.render(g);
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
		System.out.println("Entity Debug: Wizard died.");
		
	}
	
	private void calculateMovement() {		
		xMove = 0;
		yMove = 0;

        tickCount++;
        if(tickCount>=200) {
		walkingDirection = (int)(Math.random() * 15) + 1; 
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
		
		if(walkingDirection==up) {
			yMove = 1*speed;
		}else if(walkingDirection==up_right) {
			yMove = 1*speed;
			xMove = 1*speed;
		}else if(walkingDirection==right) {
			xMove = 1*speed;
		}else if(walkingDirection==down_right) {
			yMove = -1*speed;
			xMove = 1*speed;
		}else if(walkingDirection==down) {
			yMove = -1*speed; 
		}else if(walkingDirection==down_left) {
			yMove = -1*speed;
			xMove = -1*speed;
		}else if(walkingDirection==left) {
			xMove = -1*speed;
		}else if(walkingDirection==up_left) {
			yMove = 1*speed;
			xMove = -1*speed;
		}

		if(wizardMenu.isActive()||wizardMenu.wBM.isActive()||wizardMenu.wSM.isActive()) {
			speed=0;
		}else {
			speed=defspeed;
		}
	}
	
	private void regenerate() {
		if(health<maxHealth) {
			health=maxHealth;
		}
	}
	
	public void interact() {
		wizardMenu.setActive(true);
	}

}
