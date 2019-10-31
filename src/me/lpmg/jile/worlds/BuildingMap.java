package me.lpmg.jile.worlds;

import java.awt.Graphics;

import me.lpmg.jile.tiles.Tile;

public abstract class BuildingMap {

	public abstract void render(Graphics g);
	public abstract Tile getTile(int x, int y);
	protected abstract void loadWorld(String path);
	public abstract void spawnPlayer();
	public abstract void checkExit();	
}
