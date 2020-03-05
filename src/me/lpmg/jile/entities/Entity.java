package me.lpmg.jile.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import me.lpmg.jile.Handler;
import me.lpmg.jile.buildings.Building;
import me.lpmg.jile.buildings.BuildingManager;

public abstract class Entity {

	public static final int DEFAULT_HEALTH = 30;
	public static final int DEFAULT_MAX_HEALTH = 30;
	public static final int DEFAULT_MANA = 30;
	public static final int DEFAULT_MAX_MANA = 30;
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected int health;
	protected int maxHealth;
	protected int mana;
	protected int maxMana;
	protected boolean active = true;
	protected Rectangle bounds;
	
	public Entity(Handler handler, float x, float y, int width, int height){
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		health = DEFAULT_HEALTH;
		maxHealth = DEFAULT_MAX_HEALTH;
		mana = DEFAULT_MANA;
		maxMana = DEFAULT_MAX_MANA;
		bounds = new Rectangle(0, 0, width, height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void die();
	
	public void hurt(int amt){
		health -= amt;
		if(health <= 0){
			active = false;
			die();
		}
	}
	
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		for(Building b : handler.getWorld().getBuildingManager().getBuildings()){
			if(b.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	//mana
	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
	
	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int mana) {
		this.maxMana = maxMana;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
