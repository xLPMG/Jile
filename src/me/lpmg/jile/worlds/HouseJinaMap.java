package me.lpmg.jile.worlds;

import java.awt.Graphics;

import me.lpmg.jile.Handler;
import me.lpmg.jile.buildings.HouseJina;
import me.lpmg.jile.tiles.Tile;
import me.lpmg.jile.utils.Utils;

public class HouseJinaMap extends BuildingMap {

	private Handler handler;
	private int width, height;
	private int[][] tiles;
	private int[][] tilesSecondLayer;
	protected int spawnX, spawnY;
	private int mapX;
	private HouseJina houseJina;

	public HouseJinaMap(Handler handler, String firstLayer,  String secondLayer, HouseJina houseJina, int mapX) {
		this.handler = handler;
		this.houseJina = houseJina;
		this.mapX=mapX;
		loadWorld(firstLayer);
		loadSecondLayer(secondLayer);
	}

	@Override
	public void render(Graphics g) {
		int xStart = (int) Math.max(mapX, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(mapX + width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(mapX, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(mapX+height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile((x), y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}
	@Override
	public void renderSecondLayer(Graphics g) {
		int xStart = (int) Math.max(mapX, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(mapX+width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(mapX, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(mapX+height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getSecondLayerTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}

	public Tile getTile(int x, int y) {
		x-=mapX;
		y-=mapX;
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.stoneTile;

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.placeHolderTile;
		if(t==Tile.floor_Tile) {
			return flooring;
		}
		if(t==Tile.wall_Tile_Middle) {
			return wallMiddle;
		}
		if(t==Tile.wall_Tile_Bottom) {
			return wallBottom;
		}
		return t;
	}
	public Tile getSecondLayerTile(int x, int y){
		x-=mapX;
		y-=mapX;
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.placeHolderTile;

		Tile t = Tile.tiles[tilesSecondLayer[x][y]];
		if (t == null)
			return Tile.placeHolderTile;
		return t;
	}
	
	protected void loadWorld(String path) {
		String file = Utils.loadResourceFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = (Utils.parseInt(tokens[2])+mapX)*Tile.TILEWIDTH;
		spawnY = (Utils.parseInt(tokens[3])+mapX)*Tile.TILEHEIGHT;
		System.out.println("width " + width);
		System.out.println("height " + height);
		System.out.println("total tiles  " + tokens.length);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	protected void loadSecondLayer(String path){
		String file = Utils.loadResourceFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		tilesSecondLayer = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tilesSecondLayer[x][y] = Utils.parseInt(tokens[(x + y * width)]);
			}
		}
	}

	public void spawnPlayer() {
		handler.getWorld().player.setY(spawnY);
		handler.getWorld().player.setX(spawnX);
	}
	
	public void checkExit() {
		if(handler.getWorld().player.getX()>=(spawnX-15)&&handler.getWorld().player.getX()<spawnX+64&&handler.getWorld().player.getY()>=spawnY+5) {
			handler.getWorld().player.setY(houseJina.getY()+330);
			handler.getWorld().player.setX(houseJina.getX()+105);
			houseJina.setEntered(false);
		}
	}
	
	public boolean isPlayerInside() {
		if(handler.getWorld().player.getX()>=(mapX*Tile.TILEWIDTH)&&handler.getWorld().player.getX()<=(mapX+width)*Tile.TILEWIDTH) {
			return true;
		}
		return false;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	public int getSpawnX() {
		return spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

}
