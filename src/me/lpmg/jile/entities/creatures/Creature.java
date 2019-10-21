package me.lpmg.jile.entities.creatures;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.tiles.Tile;

public abstract class Creature extends Entity {
	
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	public static final int PLAYER_WIDTH = 48,
			PLAYER_HEIGHT = 69;
	
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
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
//			System.out.println("Bound ID xMoveR "+getBoundId(getBoundXCoord(txExactAndGraphical), getBoundYCoord(tyExactAndGraphical)));
//			System.out.println("xMoveR: "+xMove);
			
//			System.out.println("x "+(int)(x+24) / Tile.TILEWIDTH);
//			System.out.println("y "+(int)y / Tile.TILEHEIGHT);
//			System.out.println("txELoc "+txExactAndGraphical);
//			System.out.println("tyELoc "+tyExactAndGraphical);
//			System.out.println("boundXC "+getBoundXCoord(txExactAndGraphical));
//			System.out.println("boundYC "+getBoundYCoord(tyExactAndGraphical));
//			System.out.println("BOUND ID "+getBoundId(getBoundXCoord(txExactAndGraphical), getBoundYCoord(tyExactAndGraphical)));
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT, txExactAndGraphical, tyExactAndGraphical) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT, txExactAndGraphical, tyExactAndGraphical)){
				x += xMove;
			}else{
				//x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1 + Tile.TILE_BOUND_WIDTH;
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

			int txExactAndGraphical = (int) (x + xMove + bounds.x + (Player.PLAYER_WIDTH/2)) / (Tile.TILE_BOUND_WIDTH*4);
			int tyExactAndGraphical = (int) y / (Tile.TILE_BOUND_HEIGHT*4);
//			System.out.println("Bound ID xMoveL "+getBoundId(getBoundXCoord(txExactAndGraphical), getBoundYCoord(tyExactAndGraphical)));
//			System.out.println("xMoveL: "+xMove);
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT, txExactAndGraphical, tyExactAndGraphical) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT, txExactAndGraphical, tyExactAndGraphical)){
				x += xMove;
			}else{
				//x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x - Tile.TILE_BOUND_WIDTH;
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
			
		}
	}
	
	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			int txExactAndGraphical = (int) (x+Player.PLAYER_WIDTH/2) / (Tile.TILE_BOUND_HEIGHT*4); //+24 to set x to middle of player image (playerwidth = 48px)
			int tyExactAndGraphical = (int) (y + yMove + bounds.y) / Tile.TILE_BOUND_HEIGHT;
//			System.out.println("Bound ID yMoveU "+getBoundId(getBoundXCoord(txExactAndGraphical), getBoundYCoord(tyExactAndGraphical)));
//			System.out.println("yMoveU: "+yMove);
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty, txExactAndGraphical, tyExactAndGraphical) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty, txExactAndGraphical, tyExactAndGraphical)){
				y += yMove;
			}else{
				//y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y - Tile.TILE_BOUND_HEIGHT;
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
			
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			int txExactAndGraphical = (int) (x+Player.PLAYER_WIDTH/2) / (Tile.TILE_BOUND_HEIGHT*4); //+24 to set x to middle of player image (playerwidth = 48px)
			int tyExactAndGraphical = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_BOUND_HEIGHT;
//			System.out.println("Bound ID yMoveD "+getBoundId(getBoundXCoord(txExactAndGraphical), getBoundYCoord(tyExactAndGraphical)));
//			System.out.println("yMoveD: "+yMove);
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty, txExactAndGraphical, tyExactAndGraphical) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty, txExactAndGraphical, tyExactAndGraphical)){
				y += yMove;
			}else{
				//y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1 + Tile.TILE_BOUND_HEIGHT;
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
			
		}
	}
	
	protected boolean collisionWithTile(int x, int y, int txEAGLoc, int tyEAGLoc){
		if(handler.getWorld().getTile(x, y).isSolid()||handler.getWorld().getSecondLayerTile(x, y).isSolid()||handler.getWorld().getThirdLayerTile(x, y).isSolid()) {
			//.isSolidAt(getBoundId(getBoundXCoord(txEAGLoc), getBoundYCoord(tyEAGLoc)))
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
	
	private int getBoundXCoord(int txEAGLoc) {
		if((txEAGLoc) % Tile.TILE_BOUND_WIDTH==0) {
			return 0;
		}else if((txEAGLoc-1) % Tile.TILE_BOUND_WIDTH==0) {
			return 1;
		}else if((txEAGLoc-2) % Tile.TILE_BOUND_WIDTH==0) {
			return 2;
		}
		else if((txEAGLoc-3) % Tile.TILE_BOUND_WIDTH==0) {
			return 3;
		}
		return 0;
	}
	private int getBoundYCoord(int tyEAGLoc) {
		if((tyEAGLoc) % Tile.TILE_BOUND_HEIGHT==0) {
			return 0;
		}else if((tyEAGLoc-1) % Tile.TILE_BOUND_HEIGHT==0) {
			return 1;
		}else if((tyEAGLoc-2) % Tile.TILE_BOUND_HEIGHT==0) {
			return 2;
		}
		else if((tyEAGLoc-3) % Tile.TILE_BOUND_HEIGHT==0) {
			return 3;
		}
		return 0;
	}
	
	private int getBoundId(int boundXCoord, int boundYCoord) {
		int boundId = boundXCoord + boundYCoord * 4;
		return boundId;
	}
	
}
