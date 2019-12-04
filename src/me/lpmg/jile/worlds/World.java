package me.lpmg.jile.worlds;

import java.awt.Graphics;
import java.util.Map;

import me.lpmg.jile.Handler;
import me.lpmg.jile.buildings.Building;
import me.lpmg.jile.buildings.BuildingManager;
import me.lpmg.jile.buildings.HermitHut;
import me.lpmg.jile.buildings.HouseJina;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.entities.EntityManager;
import me.lpmg.jile.entities.creatures.Hermit;
import me.lpmg.jile.entities.creatures.Log;
import me.lpmg.jile.entities.creatures.Player;
import me.lpmg.jile.entities.creatures.Wizard;
import me.lpmg.jile.entities.statics.Bush;
import me.lpmg.jile.entities.statics.Rock;
import me.lpmg.jile.ingamemenu.SpeechToastManager;
import me.lpmg.jile.input.MouseManager;
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
	// Entities
	private EntityManager entityManager;
	// Buildings
	private BuildingManager buildingManager;
	// Item
	private ItemManager itemManager;
	public Player player;
	private SpeechToastManager sTM;
	private int spawnTicker;
	private int savedTicker;
	private boolean justSaved = false;

	private final int SPAWN_CHANCE_LOG_DEFAULT = 96;
	private final int SPAWN_CHANCE_HERMIT_DEFAULT = 90;

	public World(Handler handler, String firstLayer, String secondLayer, String thirdLayer) {
		this.handler = handler;
		itemManager = new ItemManager(handler);
		player = new Player(handler, 100, 100);
		sTM = new SpeechToastManager(handler, "/text/speech_en.txt");
		entityManager = new EntityManager(handler);

		loadWorld(firstLayer);
		loadSecondLayer(secondLayer);
		loadThirdLayer(thirdLayer);
		spawnBuildings();
		spawnEntities();

		loadGameData();
	}

	public void tick() {
		spawnTicker++;
		itemManager.tick();
		buildingManager.tick();
		entityManager.tick();
		sTM.tick();

		if (spawnTicker > 3000) {
			System.out.println("Spawning new entities...");
			spawnRandomLogs();
			spawnHermits();
			spawnTicker = 0;
		}

		if (handler.getKeyManager().g) {
			justSaved = true;
			if (savedTicker == 0) {
				System.out.println("Saving game...");
				saveEntities();
				saveGameData();
				handler.getGame().savePlayerInventory(player);
			}
		}

		if (justSaved) {
			savedTicker++;
		}
		if (savedTicker >= 90) {
			justSaved = false;
			savedTicker = 0;
		}
	}

	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}

	public void renderSecondLayer(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getSecondLayerTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		// Buildings
		buildingManager.render(g);
		// Items
		itemManager.render(g);
		// Entities
		entityManager.render(g);
		// Buildings 2
		buildingManager.renderOverlay(g);
		// Buildings 3
		buildingManager.renderSecondLayer(g);
	}

	public void renderThirdLayer(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getThirdLayerTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.placeHolderTile;
		return t;
	}

	public Tile getSecondLayerTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.placeHolderTile;

		Tile t = Tile.tiles[tilesSecondLayer[x][y]];
		if (t == null)
			return Tile.placeHolderTile;
		return t;
	}

	public Tile getThirdLayerTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.placeHolderTile;
		Tile t = Tile.tiles[tilesThirdLayer[x][y]];
		if (t == null)
			return Tile.placeHolderTile;
		return t;
	}

	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
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

	private void loadSecondLayer(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");

		tilesSecondLayer = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tilesSecondLayer[x][y] = Utils.parseInt(tokens[(x + y * width)]);
			}

		}
	}

	private void loadThirdLayer(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");

		tilesThirdLayer = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tilesThirdLayer[x][y] = Utils.parseInt(tokens[(x + y * width)]);
			}
		}
	}

	private void spawnBuildings() {
		buildingManager = new BuildingManager(handler, player);
		buildingManager.addBuilding(new HouseJina(handler, 1000, 840));
	}

	private void spawnEntities() {
		entityManager.setPlayer(player);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		entityManager.addEntity(new Wizard(handler, 200, 300));
		if(handler.getGame().getSavedEntities().isEmpty()) {
			loadStandardEntities();
		}else {
			loadEntities();
		}
		
		spawnHermits();
	}

	private void spawnRandomLogs() {
		System.out.println("Spawning random logs...");
//		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
//		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
//		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
//		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		int xStart = 0;
		int xEnd = width;
		int yStart = 0;
		int yEnd = height;

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				if (getTile(x, y) == Tile.grassTile && getSecondLayerTile(x, y) == Tile.placeHolderTile
						&& getThirdLayerTile(x, y) == Tile.placeHolderTile) {
					int spawnChance = (int) (Math.random() * 100) + 1;
					if (spawnChance > SPAWN_CHANCE_LOG_DEFAULT) {
						System.out.println("spawnChance log: " + spawnChance);
						entityManager.addEntity(new Log(handler, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
					}
				}
			}
		}
	}

	private void spawnRandomHermits() {
		System.out.println("Spawning random hermits...");
//		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
//		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
//		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
//		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		int xStart = 0;
		int xEnd = width;
		int yStart = 0;
		int yEnd = height;

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				if (getTile(x, y) == Tile.dirtTile && getSecondLayerTile(x, y) == Tile.placeHolderTile
						&& getThirdLayerTile(x, y) == Tile.placeHolderTile) {
					int spawnChance = (int) (Math.random() * 100) + 1;
					if (spawnChance > SPAWN_CHANCE_HERMIT_DEFAULT) {
						System.out.println("spawnChance hermit: " + spawnChance);
						entityManager.addEntity(new Hermit(handler, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
					}
				}
			}
		}
	}

	private void spawnHermits() {
		System.out.println("Spawning hermits...");
		for (Building b : buildingManager.getBuildings()) {
			if (b instanceof HermitHut) {
				entityManager
						.addEntity(new Hermit(handler, b.getX() + b.getDoorX() + 15, b.getY() + b.getDoorY() + 64));
			}
		}
	}

	private void loadGameData() {
		Map<String, String> playerData = handler.getGame().getPlayerData();
		if (playerData.containsKey("player_name")) {
			player.setPlayerName(playerData.get("player_name"));
		}
		if (playerData.containsKey("player_money")) {
			player.setMoney(Utils.parseInt(playerData.get("player_money")));
		}
		if (playerData.containsKey("player_health")) {
			player.setHealth(Utils.parseInt(playerData.get("player_health")));
		}
		if (playerData.containsKey("player_mana")) {
			player.setMana(Utils.parseInt(playerData.get("player_mana")));
		}
	}

	private void saveGameData() {
		Map<String, String> playerData = handler.getGame().getPlayerData();
		playerData.put("player_name", player.getPlayerName());
		playerData.put("player_money", player.getMoney() + "");
		playerData.put("player_health", player.getHealth() + "");
		playerData.put("player_mana", player.getMana() + "");
		handler.getGame().setPlayerData(playerData);
		handler.getGame().savePlayerData();
	}

	private void loadStandardEntities() {
		spawnRandomLogs();
		entityManager.addEntity(new Rock(handler, 8 * Tile.TILEWIDTH, 4 * Tile.TILEHEIGHT));
		entityManager.addEntity(new Bush(handler, 4 * Tile.TILEWIDTH, 13 * Tile.TILEHEIGHT));
		entityManager.addEntity(new Bush(handler, 6 * Tile.TILEWIDTH, 13 * Tile.TILEHEIGHT));
	}

	private void loadEntities() {
		Map<String, String> savedEntities = handler.getGame().getSavedEntities();
		for (String entity : savedEntities.keySet()) {
			if(savedEntities.get(entity).equalsIgnoreCase("Bush")) {
				String coordinates[] = entity.split("/");
				entityManager
						.addEntity(new Bush(handler, Utils.parseFloat(coordinates[0]), Utils.parseFloat(coordinates[1])));
			}else if(savedEntities.get(entity).equalsIgnoreCase("Rock")) {
				String coordinates[] = entity.split("/");
				entityManager
						.addEntity(new Rock(handler, Utils.parseFloat(coordinates[0]), Utils.parseFloat(coordinates[1])));
			}else if(savedEntities.get(entity).equalsIgnoreCase("Log")) {
				String coordinates[] = entity.split("/");
				entityManager
						.addEntity(new Log(handler, Utils.parseFloat(coordinates[0]), Utils.parseFloat(coordinates[1])));
			}
		}
	}

	private void saveEntities() {
		Map<String, String> savedEntities = handler.getGame().getSavedEntities();
		savedEntities.clear();
		for (Entity entity : entityManager.getEntities()) {
			if (entity instanceof Bush) {
				savedEntities.put(entity.getX()+"/"+entity.getY(), "Bush");
			}
			else if (entity instanceof Rock) {
				savedEntities.put(entity.getX()+"/"+entity.getY(), "Rock");
			}
			else if (entity instanceof Log) {
				savedEntities.put(entity.getX()+"/"+entity.getY(), "Log");
			}
		}
		handler.getGame().setSavedEntities(savedEntities);
		handler.getGame().saveEntityData();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public BuildingManager getBuildingManager() {
		return buildingManager;
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

	public int getSpawnX() {
		return spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public void setPlayer(Player player) {
		this.player = player;
		entityManager.setPlayer(player);
	}

	public SpeechToastManager getSpeechToastManager() {
		return sTM;
	}
}
