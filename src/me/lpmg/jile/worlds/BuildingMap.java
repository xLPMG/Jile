package me.lpmg.jile.worlds;

import java.awt.Graphics;

import me.lpmg.jile.tiles.FloorTile;
import me.lpmg.jile.tiles.Tile;
import me.lpmg.jile.tiles.WallTileSolid;

public abstract class BuildingMap {

	protected FloorTile flooring;	
	protected WallTileSolid wall;
	
	public abstract void render(Graphics g);
	public abstract void renderSecondLayer(Graphics g);
	public abstract Tile getTile(int x, int y);
	protected abstract void loadWorld(String path);
	protected abstract void loadSecondLayer(String path);
	public abstract void spawnPlayer();
	public abstract void checkExit();	
	
	public void setFlooring(FloorTile flooring) {
		this.flooring=flooring;
	}
	public FloorTile getFlooring() {
		return flooring;
	}
	public void setWall(WallTileSolid wall) {
		this.wall=wall;
	}
	public WallTileSolid getWall() {
		return wall;
	}
}
