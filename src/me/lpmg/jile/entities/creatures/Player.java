package me.lpmg.jile.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.gfx.Animation;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.healthbar.Healthbar;
import me.lpmg.jile.inventory.Inventory;
import me.lpmg.jile.inventory.ItemBar;
import me.lpmg.jile.states.DeadState;
import me.lpmg.jile.states.MenuState;
import me.lpmg.jile.states.State;

public class Player extends Creature {
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight, animIdle, animAttackDown, animAttackUp, animAttackLeft, animAttackRight;
	// Attack timer
	private long lastAttackTimer, attackCooldown = 100, attackTimer = attackCooldown;
	// Inventory
	private Inventory inventory;
	private ItemBar itemBar;
	private Healthbar healthbar;
	private int attackDirection = 0;
	private int tickCount;
	private float defSpeed;
	private float sprintSpeed;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.PLAYER_WIDTH, Creature.PLAYER_HEIGHT);
		
		bounds.x = 4*3; //4*3
		bounds.y = 18*3; //19*3
		bounds.width = 9*3; //9*3
		bounds.height = 4*3; //4*3
		speed = 2.4f;
		defSpeed = speed;
		sprintSpeed = 3.2f;
		
		//Animatons
		animDown = new Animation(250, Assets.player_down);
		animUp = new Animation(250, Assets.player_up);
		animLeft = new Animation(250, Assets.player_left);
		animRight = new Animation(250, Assets.player_right);
		animIdle = new Animation(500, Assets.player_idle);
		animAttackDown = new Animation(100, Assets.player_attack_down);
		animAttackUp = new Animation(100, Assets.player_attack_up);
		animAttackLeft = new Animation(100, Assets.player_attack_left);
		animAttackRight = new Animation(100, Assets.player_attack_right);
		
		inventory = new Inventory(handler);
		itemBar = new ItemBar(handler, inventory);
		healthbar = new Healthbar(handler, this);
	}

	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		animIdle.tick();
		animAttackDown.tick();
		animAttackUp.tick();
		animAttackLeft.tick();
		animAttackRight.tick();
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		// Attack
		checkAttacks();
		//Health
		regenerate();
		// Inventory
		inventory.tick();
		itemBar.tick();
		healthbar.tick();
	}
	
	private void checkAttacks(){
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown)
			return;
		
		if(inventory.isActive())
			return;
		
		healthbar.hideCorner();
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().up&&handler.getMouseManager().isRightPressed()){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
			attackDirection = 1;
		}else if(handler.getKeyManager().down&&handler.getMouseManager().isRightPressed()){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
			attackDirection = 2;
		}else if(handler.getKeyManager().left&&handler.getMouseManager().isRightPressed()){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
			attackDirection = 3;
		}else if(handler.getKeyManager().right&&handler.getMouseManager().isRightPressed()){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
			attackDirection = 4;
		}else{
			attackDirection = 0;
			return;
		}
		
		attackTimer = 0;
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				healthbar.showCorner();
				e.hurt(2);
				System.out.println("Hitting "+e);
				return;
			}
		}
		
	}
	
	@Override
	public void die(){
		State.setState(new DeadState(handler));
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;

		if(inventory.isActive())
			return;
		
		if(handler.getKeyManager().shift) {
			speed = sprintSpeed;
		}else if(!handler.getKeyManager().shift){
			speed = defSpeed;
		}
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
		
		if(handler.getKeyManager().esc) {
			State.setState(new MenuState(handler));
		}
		if(handler.getKeyManager().h) {
			this.hurt(1 );
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	public void postRender(Graphics g){
		healthbar.render(g);
		itemBar.render(g);
		inventory.render(g);
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
		}else if(attackDirection==1){
			return animAttackUp.getCurrentFrame();
		}else if(attackDirection==2){
			return animAttackDown.getCurrentFrame();
		}else if(attackDirection==3){
			return animAttackLeft.getCurrentFrame();
		}else if(attackDirection==4){
			return animAttackRight.getCurrentFrame();
		}else{
			return animIdle.getCurrentFrame();
		}
	}

	private void regenerate() {
		if(health<maxHealth) {
			tickCount++;
			if(tickCount>=120) {
				health+=1;
				tickCount = 0;
			}
		}
	}
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public ItemBar getItemBar(){
		return itemBar;
	}

}
