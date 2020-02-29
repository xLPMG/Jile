package me.lpmg.jile;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import me.lpmg.jile.display.Display;
import me.lpmg.jile.display.LogoScreen;
import me.lpmg.jile.entities.creatures.Player;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.gfx.GameCamera;
import me.lpmg.jile.input.ItemBarScroll;
import me.lpmg.jile.input.KeyManager;
import me.lpmg.jile.input.MouseManager;
import me.lpmg.jile.inventory.Inventory;
import me.lpmg.jile.items.Item;
import me.lpmg.jile.items.ItemManager;
import me.lpmg.jile.states.DeadState;
import me.lpmg.jile.states.GameState;
import me.lpmg.jile.states.MenuState;
import me.lpmg.jile.states.State;
import me.lpmg.jile.utils.Utils;
import me.lpmg.jile.worlds.World;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;
	private String version;
	private int FPS;

	private boolean running = false;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	// States
	public State gameState;
	public State deadState;
	public State menuState;

	// Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	private ItemBarScroll itembarScroll;

	// Camera
	private GameCamera gameCamera;

	// Handler
	private Handler handler;

	// stored data
	private World world;
	private Map<String, String> playerData = new HashMap<>();
	private Map<String, String> eventData = new HashMap<>();
	private Map<String, String> savedEntities = new HashMap<>();
	// save files
	private File playerDataFile;
	private File eventDataFile;
	private File entitiesFile;
	private File playerInventoryFile;

	private String orgWorldFirstLayer = "/worlds/world1-firstLayer.txt";
	private String orgWorldSecondLayer = "/worlds/world1-secondLayer.txt";
	private String orgWorldThirdLayer = "/worlds/world1-thirdLayer.txt";
	
	private File worldFirstLayerFile;
	private File worldSecondLayerFile;
	private File worldThirdLayerFile;

	public Game(String title, int width, int height, String version) {
		this.width = width;
		this.height = height;
		this.title = title;
		this.version = version;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		itembarScroll = new ItemBarScroll();
	}

	private void init() {
		LogoScreen logoScreen = new LogoScreen();

		display = new Display(title, width, height);
		handler = new Handler(this, display);
		
		handler.addKeyListener(keyManager);
		handler.addMouseListener(mouseManager);
		handler.addMouseMotionListener(mouseManager);
		handler.addMouseListener(mouseManager);
		handler.addMouseMotionListener(mouseManager);

		itembarScroll.transmitHandler(handler);
		gameCamera = new GameCamera(handler, 0, 0);

		display.getCanvas().addMouseWheelListener(itembarScroll);

		loadGameFolder();
		loadGameData();
		world = new World(handler, worldFirstLayerFile.getAbsolutePath(),  worldSecondLayerFile.getAbsolutePath(),  worldThirdLayerFile.getAbsolutePath());

		gameState = new GameState(handler, world);
		deadState = new DeadState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);
	}

	private void tick() {
		keyManager.tick();

		if (State.getState() != null)
			State.getState().tick();
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		// Draw Here!

		if (State.getState() != null)
			State.getState().render(g);

		// End Drawing!
		bs.show();
		g.dispose();
	}

	public void run() {

		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("FPS: " + ticks);
				FPS=ticks;
				ticks = 0;
				timer = 0;
			}
		}

		stop();

	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getFPS() {
		return FPS;
	}

	public String getVersion() {
		return version;
	}

	public Map<String, String> getPlayerData() {
		return playerData;
	}

	public void setPlayerData(Map<String, String> playerData) {
		this.playerData = playerData;
	}
	
	public Map<String, String> getEventData() {
		return eventData;
	}

	public void setEventData(Map<String, String> eventData) {
		this.eventData = eventData;
	}

	public Map<String, String> getSavedEntities() {
		return savedEntities;
	}

	public void setSavedEntities(Map<String, String> savedEntities) {
		this.savedEntities = savedEntities;
	}

	private void loadGameFolder() {
		String[] options = new String[] { "New Game", "Load Game" };
		int response = JOptionPane.showOptionDialog(null, "Do you want to load a game folder or create a new one?",
				"Jile " + version, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		if (response == 1) {
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setCurrentDirectory(new java.io.File("."));

			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jfc.setDialogTitle("Select a game folder");
			jfc.setAcceptAllFileFilterUsed(false);

			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				System.out.println(jfc.getSelectedFile());
				playerDataFile = new File(jfc.getSelectedFile().getAbsolutePath() + "/playerData.dat");
				eventDataFile = new File(jfc.getSelectedFile().getAbsolutePath() + "/eventData.dat");
				entitiesFile = new File(jfc.getSelectedFile().getAbsolutePath() + "/entityData.dat");
				playerInventoryFile = new File(jfc.getSelectedFile().getAbsolutePath() + "/playerInventoryData.dat");
				
				worldFirstLayerFile = new File(jfc.getSelectedFile().getAbsolutePath() + "/world1.dat");
				worldSecondLayerFile = new File(jfc.getSelectedFile().getAbsolutePath() + "/world2.dat");
				worldThirdLayerFile = new File(jfc.getSelectedFile().getAbsolutePath() + "/world3.dat");
				try {
					if (!playerDataFile.exists()) {
						System.exit(0);
					} else if (!eventDataFile.exists()) {
						createEventDataFile(jfc.getSelectedFile().getAbsolutePath());
					} else if (!entitiesFile.exists()) {
						entitiesFile.createNewFile();
					} else if (!playerInventoryFile.exists()) {
						playerInventoryFile.createNewFile();
					}
					else if (!worldFirstLayerFile.exists()||!worldSecondLayerFile.exists()||!worldThirdLayerFile.exists()) {
						createWorldFiles(jfc.getSelectedFile().getAbsolutePath());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.exit(0);
			}
		} else {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new java.io.File("."));

			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setDialogTitle("Select a directory and create a new game folder");
			fileChooser.setAcceptAllFileFilterUsed(false);

			int returnValue = fileChooser.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				try {
					fileChooser.getSelectedFile().mkdir();

					playerDataFile = new File(fileChooser.getSelectedFile().getAbsolutePath() + "/playerData.dat");	
					createEventDataFile(fileChooser.getSelectedFile().getAbsolutePath());
					entitiesFile = new File(fileChooser.getSelectedFile().getAbsolutePath() + "/entityData.dat");
					playerInventoryFile = new File(
							fileChooser.getSelectedFile().getAbsolutePath() + "/playerInventoryData.dat");
					playerDataFile.createNewFile();
					eventDataFile.createNewFile();
					entitiesFile.createNewFile();
					playerInventoryFile.createNewFile();
					createWorldFiles(fileChooser.getSelectedFile().getAbsolutePath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.exit(0);
			}
		}
	}
	
	private void createWorldFiles(String path){
		worldFirstLayerFile = new File(path + "/world1.dat");
		worldSecondLayerFile = new File(path + "/world2.dat");
		worldThirdLayerFile = new File(path + "/world3.dat");
		String firstLayer = Utils.loadResourceFileAsString(orgWorldFirstLayer);
		String secondLayer = Utils.loadResourceFileAsString(orgWorldSecondLayer);
		String thirdLayer = Utils.loadResourceFileAsString(orgWorldThirdLayer);
		try {
			worldFirstLayerFile.createNewFile();
			worldSecondLayerFile.createNewFile();
			worldThirdLayerFile.createNewFile();
			FileWriter writer1 = new FileWriter(worldFirstLayerFile.getAbsolutePath());
			FileWriter writer2 = new FileWriter(worldSecondLayerFile.getAbsolutePath());
			FileWriter writer3 = new FileWriter(worldThirdLayerFile.getAbsolutePath());
			writer1.write(firstLayer);
			writer2.write(secondLayer);
			writer3.write(thirdLayer);
			writer1.close();
			writer2.close();
			writer3.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createEventDataFile(String path){
		eventDataFile = new File(path + "/eventData.dat");
		try {
			eventDataFile.createNewFile();
			FileWriter writer = new FileWriter(eventDataFile.getAbsolutePath());
			writer.write("encounteredJina:false,");
			writer.write("placeholderkey:placeholderValue");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadGameData() {
		loadPlayerData();
		loadEventData();
		loadEntityData();
	}

	private void loadPlayerData() {
		playerData.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(playerDataFile.getAbsolutePath()));
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String data[] = line.split("[|]");
					for (String singleData : data) {
						String singleInfo[] = singleData.split(":");
						playerData.put(singleInfo[0], singleInfo[1]);
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void savePlayerData() {
		try {
			FileWriter writer = new FileWriter(playerDataFile.getAbsolutePath());
			writer.write("");
			playerData.remove("placeholder");
			for (Entry<String, String> entry : playerData.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				writer.write(key + ":" + value + "|");
			}
			writer.write("placeholderkey:placeholderValue");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done saving player data.");
		loadPlayerData();
	}
	
	private void loadEventData() {
		eventData.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(eventDataFile.getAbsolutePath()));
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String eventDataObject[] = line.split("[,]");
					for (String singleData : eventDataObject) {
						String singleInfo[] = singleData.split(":");
						eventData.put(singleInfo[0], singleInfo[1]);
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveEventData() {
		try {
			FileWriter writer = new FileWriter(eventDataFile.getAbsolutePath());
			writer.write("");
			for (Entry<String, String> entry : eventData.entrySet()) {
				String eventName = entry.getKey();
				Object eventBoolean = entry.getValue();
				writer.write(eventName + ":" + eventBoolean + ",");
			}
			writer.write("placeholderkey:placeholderValue");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done saving event data.");
		loadEntityData();
	}

	private void loadEntityData() {
		savedEntities.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(entitiesFile.getAbsolutePath()));
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String entityData[] = line.split("[|]");
					savedEntities.put(entityData[0], entityData[1]);
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveEntityData() {
		try {
			FileWriter writer = new FileWriter(entitiesFile.getAbsolutePath());
			writer.write("");
			for (Entry<String, String> entry : savedEntities.entrySet()) {
				String coordinates = entry.getKey();
				Object entityType = entry.getValue();
				writer.write(coordinates + "|" + entityType + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done saving entity data.");
		loadEntityData();
	}

	public void loadPlayerInventory(Player player) {
		// loaded after inventory creation in player class
		Inventory playerInventory = player.getInventory();
		ArrayList<Item> inventoryItems = playerInventory.getInventoryItems();
		HashMap<String, Integer> equippedItems = playerInventory.getEquippedItems();
		inventoryItems.clear();
		equippedItems.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(playerInventoryFile.getAbsolutePath()));
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					String itemData[] = line.split("[:]");
					if(itemData[0].startsWith("equipped")) {
						System.out.println("loading a sword");
						String itemType = itemData[0];
						int itemID = Utils.parseInt(itemData[1]);
						equippedItems.put(itemType, itemID);
					}else {
					int itemID = Utils.parseInt(itemData[0]);
					int itemCount = Utils.parseInt(itemData[1]);
					ItemManager itM = new ItemManager(handler);
					Item item = itM.getItemByID(itemID);
					item.setCount(itemCount);
					playerInventory.addItem(item);
					itM = null;
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		player.getInventory().setEquippedItems(equippedItems);
		player.getInventory().loadEquippedItems();
		player.setInventory(playerInventory);
	}

	public void savePlayerInventory(Player player) {
		Inventory playerInventory = player.getInventory();
		ArrayList<Item> inventoryItems = playerInventory.getInventoryItems();
		HashMap<String, Integer> equippedItems = playerInventory.getEquippedItems();
		try {
			FileWriter writer = new FileWriter(playerInventoryFile.getAbsolutePath());
			writer.write("");
			for (Item item : inventoryItems) {
				writer.write(item.getId() + ":" + item.getCount() + "\n");
			}
			Iterator it = equippedItems.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        writer.write(pair.getKey() + ":" + pair.getValue() + "\n");
		        it.remove();
		    }
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done saving inventory data.");
		loadPlayerInventory(player);
	}

}
