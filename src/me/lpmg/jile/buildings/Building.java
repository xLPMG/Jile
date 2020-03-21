package me.lpmg.jile.buildings;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.tiles.FloorTile;
import me.lpmg.jile.tiles.Tile;
import me.lpmg.jile.tiles.WallTileSolid;
import me.lpmg.jile.worlds.BuildingMap;

public abstract class Building {

	protected float x, y;
	protected int tileWidth, tileHeight;
	protected int width, height;
	protected int doorX, doorY, doorWidth, doorHeight;
	protected Handler handler;
	protected Rectangle bounds;
	protected BufferedImage overlay;
	protected int index;
	protected boolean entered = false;
	protected BuildingMap map;
	protected int mapX;

	public Building(Handler handler, float x, float y, int width, int height, int doorX, int doorY, int doorWidth,
			int doorHeight, int tileWidth, int tileHeight) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.doorX = doorX;
		this.doorY = doorY;
		this.doorWidth = doorWidth;
		this.doorHeight = doorHeight;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;

		bounds = new Rectangle(0, 0, width, height);
	}

	public void tick() {
		checkForEntrance();
		checker();
	}

	public abstract void checker();

	public abstract void render(Graphics g);

	public abstract void renderSecondLayer(Graphics g);

	public abstract void renderOverlay(Graphics g);

	public abstract void onEnter();
	
	public abstract void init();

	public abstract void checkEntered();
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width,
				bounds.height);
	}

	private void checkForEntrance() {
		if (handler.getKeyManager().up && handler.getWorld().player.getX() > (x + doorX)
				&& handler.getWorld().player.getX() < (x + doorX + doorWidth)
				&& handler.getWorld().player.getY() > (y + doorY)
				&& handler.getWorld().player.getY() < (y + doorY + doorHeight)) {
			onEnter();
		}
	}

	public void setEntered(boolean entered) {
		this.entered = entered;
	}

	public FloorTile getRandomFlooring(int floorID) {
		// TODO
		if (floorID == 1) {
			return new FloorTile(Assets.floor_1, 510);
		} else if (floorID == 2) {
			return new FloorTile(Assets.floor_2, 510);
		} else if (floorID == 3) {
			return new FloorTile(Assets.floor_3, 510);
		} else if (floorID == 4) {
			return new FloorTile(Assets.floor_4, 510);
		} else if (floorID == 5) {
			return new FloorTile(Assets.floor_5, 510);
		} else if (floorID == 6) {
			return new FloorTile(Assets.floor_6, 510);
		} else if (floorID == 7) {
			return new FloorTile(Assets.floor_7, 510);
		} else if (floorID == 8) {
			return new FloorTile(Assets.floor_8, 510);
		} else if (floorID == 9) {
			return new FloorTile(Assets.floor_9, 510);
		} else if (floorID == 10) {
			return new FloorTile(Assets.floor_10, 510);
		} else if (floorID == 11) {
			return new FloorTile(Assets.floor_11, 510);
		} else if (floorID == 12) {
			return new FloorTile(Assets.floor_12, 510);
		} else if (floorID == 13) {
			return new FloorTile(Assets.floor_13, 510);
		} else if (floorID == 14) {
			return new FloorTile(Assets.floor_14, 510);
		} else if (floorID == 15) {
			return new FloorTile(Assets.floor_15, 510);
		} else if (floorID == 16) {
			return new FloorTile(Assets.floor_16, 510);
		} else if (floorID == 17) {
			return new FloorTile(Assets.floor_17, 510);
		} else if (floorID == 18) {
			return new FloorTile(Assets.floor_18, 510);
		} else if (floorID == 19) {
			return new FloorTile(Assets.floor_19, 510);
		} else if (floorID == 20) {
			return new FloorTile(Assets.floor_20, 510);
		}
		return null;
	}

	public WallTileSolid getWallMiddle(int wallID) {
		// TODO
		if (wallID == 1) {
			return new WallTileSolid(Assets.wooden_wall_1, 501);
		} else if (wallID == 2) {
			return new WallTileSolid(Assets.white_wall_middle, 501);
		} else if (wallID == 3) {
			return new WallTileSolid(Assets.yellowStripes_wall_middle, 501);
		} else if (wallID == 4) {
		} else if (wallID == 5) {
		} else if (wallID == 6) {
		} else if (wallID == 7) {
		} else if (wallID == 8) {
		} else if (wallID == 9) {
		} else if (wallID == 10) {
		} else if (wallID == 11) {
		} else if (wallID == 12) {
		} else if (wallID == 13) {
		} else if (wallID == 14) {
		} else if (wallID == 15) {
		} else if (wallID == 16) {
		} else if (wallID == 17) {
		} else if (wallID == 18) {
		} else if (wallID == 19) {
		} else if (wallID == 20) {
		}
		return null;
	}
	public WallTileSolid getWallBottom(int wallID) {
		// TODO
		if (wallID == 1) {
			return new WallTileSolid(Assets.wooden_wall_1, 500);
		} else if (wallID == 2) {
			return new WallTileSolid(Assets.white_wall_bottom, 500);
		} else if (wallID == 3) {
			return new WallTileSolid(Assets.yellowStripes_wall_bottom, 500);
		} else if (wallID == 4) {
		} else if (wallID == 5) {
		} else if (wallID == 6) {
		} else if (wallID == 7) {
		} else if (wallID == 8) {
		} else if (wallID == 9) {
		} else if (wallID == 10) {
		} else if (wallID == 11) {
		} else if (wallID == 12) {
		} else if (wallID == 13) {
		} else if (wallID == 14) {
		} else if (wallID == 15) {
		} else if (wallID == 16) {
		} else if (wallID == 17) {
		} else if (wallID == 18) {
		} else if (wallID == 19) {
		} else if (wallID == 20) {
		}
		return null;
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
		System.out.println("setindex " + index);
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
	
	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}
	
	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}

	public BuildingMap getMap() {
		return map;
	}
	
	public void setMapX(int mapX) {
		this.mapX=mapX;
	}

	public int getDoorX() {
		return doorX;
	}

	public int getDoorY() {
		return doorY;
	}

}
