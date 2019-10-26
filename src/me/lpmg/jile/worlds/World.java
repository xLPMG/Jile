package me.lpmg.jile.worlds;

import java.awt.Graphics;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.EntityManager;
import me.lpmg.jile.entities.creatures.Log;
import me.lpmg.jile.entities.creatures.Player;
import me.lpmg.jile.entities.creatures.Wizard;
import me.lpmg.jile.entities.statics.Rock;
import me.lpmg.jile.entities.statics.Bush;
import me.lpmg.jile.items.ItemManager;
import me.lpmg.jile.tiles.Tile;
import me.lpmg.jile.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	private int[][] tilesSecondLayer;
	private int[][] tilesThirdLayer;
	//Entities
	private EntityManager entityManager;
	// Item
	private ItemManager itemManager;
	public Player player;
	
	private final int SPAWN_CHANCE_LOG_DEFAULT = 85;
	
//	public World(Handler handler, String firstLayer){
//		this.handler = handler;
//		itemManager = new ItemManager(handler);
//		
//		loadWorld(firstLayer);
//		spawnEntities();
//	}
//	public World(Handler handler, String firstLayer, String secondLayer){
//		this.handler = handler;
//		itemManager = new ItemManager(handler);
//		loadWorld(firstLayer);
//		loadSecondLayer(secondLayer);
//		spawnEntities();
//	}
	public World(Handler handler, String firstLayer, String secondLayer, String thirdLayer){
		this.handler = handler;
		itemManager = new ItemManager(handler);
		player = new Player(handler, 100, 100);
		loadWorld(firstLayer);
		loadSecondLayer(secondLayer);
		loadThirdLayer(thirdLayer);
		spawnEntities();
	}
	
	public void tick(){
		itemManager.tick();
		entityManager.tick();
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}
	public void renderSecondLayer(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getSecondLayerTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		// Items
		itemManager.render(g);
		//Entities
		entityManager.render(g);
	}
	public void renderThirdLayer(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getThirdLayerTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.placeHolderTile;
		return t;
	}
	
	public Tile getSecondLayerTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.placeHolderTile;
		
		Tile t = Tile.tiles[tilesSecondLayer[x][y]];
		if(t == null)
			return Tile.placeHolderTile;
		return t;
	}
	public Tile getThirdLayerTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.placeHolderTile;
		Tile t = Tile.tiles[tilesThirdLayer[x][y]];
		if(t == null)
			return Tile.placeHolderTile;
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		System.out.println("width "+width);
		System.out.println("height "+height);
		System.out.println("total tiles  "+tokens.length);

		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){	
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);	
			}
		}
	}
	
	private void loadSecondLayer(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		tilesSecondLayer = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tilesSecondLayer[x][y] = Utils.parseInt(tokens[(x + y * width)]);
			}
		}
	}
	
	private void loadThirdLayer(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		tilesThirdLayer = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tilesThirdLayer[x][y] = Utils.parseInt(tokens[(x + y * width)]);
			}
		}
	}
	
	private void spawnEntities(){
		entityManager = new EntityManager(handler, player);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		entityManager.addEntity(new Rock(handler, 350, 300));
		entityManager.addEntity(new Bush(handler, 200, 500));
		
	int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
	int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
	int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
	int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
	
	for(int y = yStart;y < yEnd;y++){
		for(int x = xStart;x < xEnd;x++){
			if(getTile(x, y) == Tile.grassTile&&getSecondLayerTile(x, y)==Tile.placeHolderTile&&getThirdLayerTile(x, y)==Tile.placeHolderTile) {
				int spawnChance = (int)(Math.random() * 100) + 1; 
				if(spawnChance>SPAWN_CHANCE_LOG_DEFAULT) {
					System.out.println("spawnChance: "+spawnChance);
				    entityManager.addEntity(new Log(handler, x*100, y*100));
				}
			}
		}
	}
	entityManager.addEntity(new Wizard(handler, 200, 300));	
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
}








