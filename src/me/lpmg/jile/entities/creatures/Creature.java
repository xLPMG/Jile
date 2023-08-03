package me.lpmg.jile.entities.creatures;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.tiles.Tile;

public abstract class Creature extends Entity {
	
	public static final float DEFAULT_SPEED = 3.0f;
//	public static final int DEFAULT_CREATURE_WIDTH = 64,
//							DEFAULT_CREATURE_HEIGHT = 64;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
			DEFAULT_CREATURE_HEIGHT = 128;
//	public static final int PLAYER_WIDTH = 64,
//			PLAYER_HEIGHT = 64;
	public static final int PLAYER_WIDTH = 128,
			PLAYER_HEIGHT = 128;
	
	protected float speed;
	protected float xMove, yMove;
	protected int moneyOnDeath;
	protected int xpOnDeath;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		moneyOnDeath=5;
		xpOnDeath=1;
	}
	
	public void move(){
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
	}
	
	public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			int txExactAndGraphical = (int) (x + xMove + bounds.x + bounds.width + (Player.PLAYER_WIDTH/2)) / (Tile.TILE_BOUND_WIDTH*4);
			int tyExactAndGraphical = (int) y / (Tile.TILE_BOUND_HEIGHT*4);
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

			int txExactAndGraphical = (int) (x + xMove + bounds.x + (Player.PLAYER_WIDTH/2)) / (Tile.TILE_BOUND_WIDTH*4);
			int tyExactAndGraphical = (int) y / (Tile.TILE_BOUND_HEIGHT*4);
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
			
		}
	}
	
	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			int txExactAndGraphical = (int) (x+Player.PLAYER_WIDTH/2) / (Tile.TILE_BOUND_HEIGHT*4);
			int tyExactAndGraphical = (int) (y + yMove + bounds.y) / Tile.TILE_BOUND_HEIGHT;
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
			
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			int txExactAndGraphical = (int) (x+Player.PLAYER_WIDTH/2) / (Tile.TILE_BOUND_HEIGHT*4);
			int tyExactAndGraphical = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_BOUND_HEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
			
		}
	}
	
	protected boolean collisionWithTile(int x, int y){
		if(handler.getWorld().getTile(x, y).isSolid()||handler.getWorld().getSecondLayerTile(x, y).isSolid()||handler.getWorld().getThirdLayerTile(x, y).isSolid()) {
			return true;
		}
		return false;
	}
	
	//GETTERS SETTERS

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public int getMoneyOnDeath() {
		return moneyOnDeath;
	}

	public void setMoneyOnDeath(int moneyOnDeath) {
		this.moneyOnDeath = moneyOnDeath;
	}
	
	public int getXPOnDeath() {
		return moneyOnDeath;
	}

	public void setXPOnDeath(int xpOnDeath) {
		this.xpOnDeath = xpOnDeath;
	}
	
}
