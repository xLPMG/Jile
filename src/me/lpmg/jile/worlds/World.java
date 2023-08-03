package me.lpmg.jile.worlds;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.entities.EntityManager;
import me.lpmg.jile.entities.creatures.Hermit;
import me.lpmg.jile.entities.creatures.Jina;
import me.lpmg.jile.entities.creatures.Sorcerer;
import me.lpmg.jile.entities.creatures.Merchant;
import me.lpmg.jile.entities.creatures.Player;
import me.lpmg.jile.entities.statics.Bush;
import me.lpmg.jile.entities.statics.Rock;
import me.lpmg.jile.gfx.EmoteManager;
import me.lpmg.jile.ingamemenu.SpeechDialogueManager;
import me.lpmg.jile.items.ItemManager;
import me.lpmg.jile.states.OptionsState;
import me.lpmg.jile.states.State;
import me.lpmg.jile.tiles.Tile;
import me.lpmg.jile.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	private int[][] tilesSecondLayer;
	private int[][] tilesThirdLayer;
	private int[][] tilesFourthLayer;

	private HashMap<String, Integer> worldFirstLayer = new HashMap<>();
	private HashMap<String, Integer> worldSecondLayer = new HashMap<>();
	private HashMap<String, Integer> worldThirdLayer = new HashMap<>();
	private HashMap<String, Integer> worldFourthLayer = new HashMap<>();
	// Entities
	private EntityManager entityManager;
	// Item
	private ItemManager itemManager;
	public Player player;
	private SpeechDialogueManager sDM;
	private int spawnTicker;
	private int savedTicker;
	private boolean justSaved = false;
	// emote
	private EmoteManager eM;

	private int timePlayed;
	long timeStart;
	long timeEnd;
	long timeDelta;

	private int iTick;

	private final int SPAWN_CHANCE_LOG_DEFAULT = 195;
	private final int SPAWN_CHANCE_HERMIT_DEFAULT = 90;

	Map<String, String> eventData;

	public World(Handler handler, String world) {
		this.handler = handler;
		timeStart = System.currentTimeMillis();

		itemManager = new ItemManager(handler);
		player = new Player(handler, 100, 100);
		sDM = new SpeechDialogueManager(handler, "text");
		entityManager = new EntityManager(handler);
		eM = new EmoteManager(handler);
		loadWorld(world);

		loadGameData();

		spawnEntities();
		initEvents();

		KeyAdapter kA = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_G) {
					justSaved = true;
					if (savedTicker == 0) {
						System.out.println("Saving game...");
						saveEntities();
						saveGameData();
						handler.getGame().savePlayerInventory(player);
					}
				}
			}

		};
		handler.addKeyListener(kA);
	}

	public void initOnWorldLoaded() {
		sDM.init();
	}

	private void initEvents() {
	}

	public void tick() {
		spawnTicker++;
		itemManager.tick();
		entityManager.tick();
		iTick++;

		if (iTick >= 60 * 30) {
			// once per 30 second
			calcTime();
			iTick = 0;
		}

		if (spawnTicker > 3000) {
//			System.out.println("Spawning new entities...");
//			spawnRandomLogs();
//			spawnHermits();
			spawnTicker = 0;
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
		// Items
		itemManager.render(g);
		// Entities
		entityManager.render(g);
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

	public void renderFourthLayer(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getFourthLayerTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.blackTile;

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) {
			System.out.println("t is null");
			return Tile.placeHolderTile;
		}
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

	public Tile getFourthLayerTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.placeHolderTile;
		Tile t = Tile.tiles[tilesFourthLayer[x][y]];
		if (t == null)
			return Tile.placeHolderTile;
		return t;
	}

	private void loadWorld(String world) {
		try {
			File file = new File(world);

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document xmlFile = dBuilder.parse(file);
			xmlFile.getDocumentElement().normalize();

			Element map = xmlFile.getDocumentElement();
			width = Utils.parseInt(map.getAttribute("width"));
			height = Utils.parseInt(map.getAttribute("height"));

			Node layer1Node = xmlFile.getElementsByTagName("layer").item(0);
			Node layer2Node = xmlFile.getElementsByTagName("layer").item(1);
			Node layer3Node = xmlFile.getElementsByTagName("layer").item(2);
			Node layer4Node = xmlFile.getElementsByTagName("layer").item(3);

			String layer1Data = layer1Node.getTextContent();
			String layer2Data = layer2Node.getTextContent();
			String layer3Data = layer3Node.getTextContent();
			String layer4Data = layer4Node.getTextContent();

			loadFirstLayer(layer1Data);
			loadSecondLayer(layer2Data);
			loadThirdLayer(layer3Data);
			loadFourthLayer(layer4Data);

		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	private void loadFirstLayer(String layerData) {
//		String file = Utils.loadFileAsString(path);
		layerData = layerData.replace("\n", "");
		layerData = layerData.replace(" ", "");
		String[] tokens = layerData.split(",");
//		width = Utils.parseInt(tokens[0]);
//		height = Utils.parseInt(tokens[1]);
//		spawnX = Utils.parseInt(tokens[2]);
//		spawnY = Utils.parseInt(tokens[3]);
//		System.out.println("width " + width);
//		System.out.println("height " + height);
//		System.out.println("total tiles  " + tokens.length);
		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width)]);
				worldFirstLayer.put(x + ":" + y, tiles[x][y]);
			}
		}
	}

	private void loadSecondLayer(String layerData) {
		layerData = layerData.replace("\n", "");
		layerData = layerData.replace(" ", "");
		String[] tokens = layerData.split(",");
		tilesSecondLayer = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tilesSecondLayer[x][y] = Utils.parseInt(tokens[(x + y * width)]);
				worldSecondLayer.put(x + ":" + y, tilesSecondLayer[x][y]);
				// System.out.println(x + ":" + y +", id: "+ tiles[x][y]);
			}

		}
	}

	private void loadThirdLayer(String layerData) {
		layerData = layerData.replace("\n", "");
		layerData = layerData.replace(" ", "");
		String[] tokens = layerData.split(",");
		tilesThirdLayer = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tilesThirdLayer[x][y] = Utils.parseInt(tokens[(x + y * width)]);
				worldThirdLayer.put(x + ":" + y, tilesThirdLayer[x][y]);
			}
		}
	}

	private void loadFourthLayer(String layerData) {
		layerData = layerData.replace("\n", "");
		layerData = layerData.replace(" ", "");
		String[] tokens = layerData.split(",");
		tilesFourthLayer = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tilesFourthLayer[x][y] = Utils.parseInt(tokens[(x + y * width)]);
				worldFourthLayer.put(x + ":" + y, tilesFourthLayer[x][y]);
			}
		}
	}

	private void spawnEntities() {
		entityManager.setPlayer(player);
		entityManager.addEntity(new Merchant(handler, 200, 300));
		if (handler.getGame().getSavedEntities().isEmpty()) {
			loadStandardEntities();
		} else {
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
				if (getTile(x, y) == Tile.blackTile && getSecondLayerTile(x, y) == Tile.placeHolderTile
						&& getThirdLayerTile(x, y) == Tile.placeHolderTile) {
					int spawnChance = (int) (Math.random() * 200) + 1;
					if (spawnChance > SPAWN_CHANCE_LOG_DEFAULT) {
						System.out.println("spawnChance log: " + spawnChance);
						entityManager.addEntity(new Sorcerer(handler, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT));
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
				if (getTile(x, y) == Tile.blackTile && getSecondLayerTile(x, y) == Tile.placeHolderTile
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
	}

	private void loadGameData() {
		Map<String, String> playerData = handler.getGame().getPlayerData();
		if (playerData.containsKey("player_name")) {
			player.setPlayerName(playerData.get("player_name"));
		}
		if (playerData.containsKey("player_money")) {
			player.setMoney(Utils.parseInt(playerData.get("player_money")));
		}
		if (playerData.containsKey("player_totalEarnedMoney")) {
			player.setTotalEarnedMoney(Utils.parseInt(playerData.get("player_totalEarnedMoney")));
		}
		if (playerData.containsKey("player_health")) {
			player.setHealth(Utils.parseInt(playerData.get("player_health")));
		}
		if (playerData.containsKey("player_deaths")) {
			player.setDeathCount(Utils.parseInt(playerData.get("player_deaths")));
		}
		if (playerData.containsKey("player_mana")) {
			player.setMana(Utils.parseInt(playerData.get("player_mana")));
		}
		if (playerData.containsKey("player_xp")) {
			player.setXp(Utils.parseInt(playerData.get("player_xp")));
		}
		if (playerData.containsKey("player_lvl")) {
			player.setLvl(Utils.parseInt(playerData.get("player_lvl")));
			player.setMaxXP(
					Utils.parseInt(playerData.get("player_lvl")) * Utils.parseInt(playerData.get("player_lvl")));
		}
		if (playerData.containsKey("player_timePlayed")) {
			timePlayed = Utils.parseInt(playerData.get("player_timePlayed"));
		}
		if (playerData.containsKey("player_x")) {
			player.setX(Utils.parseFloat(playerData.get("player_x")));
			System.out.println("setting player x to " + Utils.parseFloat(playerData.get("player_x")));
		} else {
			player.setX(spawnX);
			player.setY(spawnY);
		}
		if (playerData.containsKey("player_y")) {
			player.setY(Utils.parseFloat(playerData.get("player_y")));
		} else {
			player.setX(spawnX);
			player.setY(spawnY);
		}

		eventData = handler.getGame().getEventData();
	}

	private void saveGameData() {
		calcTime();

		Map<String, String> playerData = handler.getGame().getPlayerData();
		playerData.put("player_name", player.getPlayerName());
		playerData.put("player_money", player.getMoney() + "");
		playerData.put("player_totalEarnedMoney", player.getTotalEarnedMoney() + "");
		playerData.put("player_health", player.getHealth() + "");
		playerData.put("player_deaths", player.getDeathCount() + "");
		playerData.put("player_mana", player.getMana() + "");
		playerData.put("player_xp", player.getXp() + "");
		playerData.put("player_lvl", player.getLvl() + "");
		playerData.put("player_timePlayed", timePlayed + "");
		playerData.put("player_x", player.getX() + "");
		playerData.put("player_y", player.getY() + "");
		handler.getGame().setPlayerData(playerData);
		handler.getGame().savePlayerData();

		handler.getGame().saveWorldFiles(worldFirstLayer, worldSecondLayer, worldThirdLayer, worldFourthLayer);

	}

	private void calcTime() {
		timeEnd = System.currentTimeMillis();
		long tDelta = timeEnd - timeStart;
		int elapsedSeconds = (int) (tDelta / 1000.0);
		timePlayed += elapsedSeconds;
		timeStart = System.currentTimeMillis();
	}

	private void loadStandardEntities() {
		spawnRandomLogs();
//		entityManager.addEntity(new Rock(handler, 8 * Tile.TILEWIDTH, 4 * Tile.TILEHEIGHT));
//		entityManager.addEntity(new Bush(handler, 4 * Tile.TILEWIDTH, 13 * Tile.TILEHEIGHT));
//		entityManager.addEntity(new Bush(handler, 6 * Tile.TILEWIDTH, 13 * Tile.TILEHEIGHT));
	}

	private void loadEntities() {
		Map<String, String> savedEntities = handler.getGame().getSavedEntities();
		for (String entity : savedEntities.keySet()) {
			if (savedEntities.get(entity).equalsIgnoreCase("Bush")) {
				String coordinates[] = entity.split("/");
				entityManager.addEntity(
						new Bush(handler, Utils.parseFloat(coordinates[0]), Utils.parseFloat(coordinates[1])));
			} else if (savedEntities.get(entity).equalsIgnoreCase("Rock")) {
				String coordinates[] = entity.split("/");
				entityManager.addEntity(
						new Rock(handler, Utils.parseFloat(coordinates[0]), Utils.parseFloat(coordinates[1])));
			} else if (savedEntities.get(entity).equalsIgnoreCase("Log")) {
				String coordinates[] = entity.split("/");
				entityManager.addEntity(
						new Sorcerer(handler, Utils.parseFloat(coordinates[0]), Utils.parseFloat(coordinates[1])));
			} else if (savedEntities.get(entity).equalsIgnoreCase("Jina")) {
				String coordinates[] = entity.split("/");
				entityManager.addEntity(
						new Jina(handler, Utils.parseFloat(coordinates[0]), Utils.parseFloat(coordinates[1])));
			}
		}
	}

	private void saveEntities() {
		Map<String, String> savedEntities = handler.getGame().getSavedEntities();
		savedEntities.clear();
		for (Entity entity : entityManager.getEntities()) {
			if (entity instanceof Bush) {
				savedEntities.put(entity.getX() + "/" + entity.getY(), "Bush");
			} else if (entity instanceof Rock) {
				savedEntities.put(entity.getX() + "/" + entity.getY(), "Rock");
			} else if (entity instanceof Sorcerer) {
				savedEntities.put(entity.getX() + "/" + entity.getY(), "Log");
			} else if (entity instanceof Jina) {
				savedEntities.put(entity.getX() + "/" + entity.getY(), "Jina");
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

	public EmoteManager getEmoteManager() {
		return eM;
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

	public SpeechDialogueManager getSpeechDialogueManager() {
		return sDM;
	}

	public int getTimePlayed() {
		return timePlayed;
	}

	public void setTimePlayed(int timePlayed) {
		this.timePlayed = timePlayed;
	}

}
