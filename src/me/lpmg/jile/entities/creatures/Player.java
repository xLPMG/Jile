package me.lpmg.jile.entities.creatures;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.gfx.Animation;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.gfx.Text;
import me.lpmg.jile.healthbar.Healthbar;
import me.lpmg.jile.inventory.Inventory;
import me.lpmg.jile.inventory.ItemBar;
import me.lpmg.jile.items.Item;
import me.lpmg.jile.items.ItemManager;
import me.lpmg.jile.states.DeadState;
import me.lpmg.jile.states.MenuState;
import me.lpmg.jile.states.State;
import me.lpmg.jile.tiles.Tile;

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
	private int healthTickCount;
	private int manaTickCount;
	private float defSpeed;
	private float sprintSpeed;
	private boolean frozen=false;
	private int damagePerHit = 2;
	
	private int money;
	private int healthRegenSpeed = 200;
	private int manaRegenSpeed = 260;
	private int multiplier = PLAYER_HEIGHT/32;
	private String playerName = "???";
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.PLAYER_WIDTH, Creature.PLAYER_HEIGHT);
		
		bounds.x = 6*multiplier;
		bounds.y = 16*multiplier; //19*3
		bounds.width = 22*multiplier; //9*3
		bounds.height = 16*multiplier; //4*3
		speed = 2.0f;
		defSpeed = speed;
		sprintSpeed = 3.2f;
		money=0;
	
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
		handler.getGame().loadPlayerInventory(this);
		itemBar = new ItemBar(handler, inventory);
		healthbar = new Healthbar(handler, this);
	}

	@Override
	public void tick() {
		//System.out.println(frozen);
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
		if(!frozen) {
		//Movement
		getInput();
		checkInteraction();
		move();
		}
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
				e.hurt(damagePerHit);
				System.out.println("Hitting "+e);
				if(e.getHealth()<=0&&e instanceof Creature) {
					addMoney(((Creature) e).getMoneyOnDeath());
				}
				if(e instanceof Wizard) {
					mana-=1;
				}
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
			healthWithMana(15);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	public void postRender(Graphics g){
		healthbar.render(g);
		itemBar.render(g);
		renderMoney(g);
		inventory.render(g);
	}
	
	private void renderMoney(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setFont(Assets.font48);
		g2.setColor(Color.WHITE);
		FontMetrics fontMetrics = g2.getFontMetrics();
		String moneyString = Integer.toString(money)+"$";
		g2.drawString(moneyString, (handler.getWidth()) - fontMetrics.stringWidth(moneyString), 35);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(frozen) {
			return animIdle.getCurrentFrame();
		}
		
		
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
	
	private void healthWithMana(int amount) {
		if(amount>mana) {
			amount=mana;
		}
		if(health+amount>maxHealth) {
			amount=maxHealth-health;
		}
		if(health<maxHealth&&mana>=amount) {
			health+=amount;
			mana-=amount;
		}
		if(mana>maxMana) {
			mana=maxMana;
		}
		if(health>maxHealth) {
			health=maxHealth;
		}
	}

	private void regenerate() {
		if(health<maxHealth) {
			healthTickCount++;
			if(healthTickCount>=healthRegenSpeed) {
				health+=1;
				healthTickCount = 0;
			}
		}
		if(mana<maxMana) {
			manaTickCount++;
			if(manaTickCount>=manaRegenSpeed) {
				mana+=1;
				manaTickCount = 0;
			}
		}
	}
	
	public void resetPlayer() {
		health=maxHealth;
		mana=maxMana;
		money=0;
		ArrayList<Item> invItems = inventory.getInventoryItems();
		invItems.clear();
		inventory.setInventoryItems(invItems);
	}
	
	private void checkInteraction() {
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().up&&handler.getMouseManager().isLeftPressed()){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		}else if(handler.getKeyManager().down&&handler.getMouseManager().isLeftPressed()){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		}else if(handler.getKeyManager().left&&handler.getMouseManager().isLeftPressed()){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else if(handler.getKeyManager().right&&handler.getMouseManager().isLeftPressed()){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else{
			return;
		}
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)&&e instanceof Wizard){
				((Wizard) e).interact();
				return;
			}
		}
		//TODO
		if(handler.getWorld().getSecondLayerTile(ar.x/64, ar.y/64)==Tile.sign1Tile) {
			
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
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money=money;
	}
	public void addMoney(int money) {
		this.money+=money;
	}
	public void subtractMoney(int money) {
		this.money-=money;
	}
	public void freeze(boolean freeze) {
    frozen=freeze;
	}
	public void setPlayerName(String name) {
		playerName=name;
	}
	public String getPlayerName() {
		return playerName;
	}
}
