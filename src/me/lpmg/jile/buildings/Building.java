package me.lpmg.jile.buildings;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.tiles.Tile;
import me.lpmg.jile.worlds.BuildingMap;

public abstract class Building {

	protected float x, y;
	protected int width, height;
	protected int doorX, doorY, doorWidth, doorHeight;
	protected Handler handler;
	protected Rectangle bounds;
	protected BufferedImage overlay;
	protected int index;
	protected boolean entered=false;
	protected BuildingMap map;
	 
	public Building(Handler handler, float x, float y, int width, int height, int doorX, int doorY, int doorWidth, int doorHeight){
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.doorX = doorX;
		this.doorY = doorY;
		this.doorWidth = doorWidth;
		this.doorHeight = doorHeight;

		
		bounds = new Rectangle(0, 0, width, height);
	}
	
	public void tick(){
		checkForEntrance();
		checker();
	}	
	public abstract void checker();
	public abstract void render(Graphics g);
	public abstract void renderOverlay(Graphics g);
	public abstract void onEnter();
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	private void checkForEntrance() {
		if(handler.getMouseManager().isRightPressed()&&handler.getWorld().player.getX()>(x+doorX)&&handler.getWorld().player.getX()<(x+doorX+doorWidth)&&handler.getWorld().player.getY()>(y+doorY)&&handler.getWorld().player.getY()<(y+doorY+doorHeight)) {
			onEnter();
		}
	}
	
	public void setEntered(boolean entered) {
		this.entered=entered;
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
		System.out.println("setindex "+index);
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
	
	public BuildingMap getMap() {
		return map;
	}
	
	public int getDoorX() {
		return doorX;
	}
	public int getDoorY() {
		return doorY;
	}

}
