package me.lpmg.jile.ingamemenu;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import me.lpmg.jile.Handler;
import me.lpmg.jile.buildings.Building;
import me.lpmg.jile.buildings.BuildingManager;
import me.lpmg.jile.buildings.HermitHut;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.inventory.Inventory;
import me.lpmg.jile.items.Item;
import me.lpmg.jile.tiles.Tile;

public class ItemMenu {

	private Handler handler;
	private boolean active = false;

	private int selectedBtn = 2;
	private int removeBtnX, removeBtnY;
	private int buildBtnX, buildBtnY;
	BuildingManager buildingManager;
	private ArrayList<Item> inventoryItems;
	private int selectedItem = 0;
	private boolean couldNotConstruct = false;
	private int couldNotConstructTimer = 0;

	private boolean canRemoveItem = false;
	private int canRemoveItemTimer = 0;

	public ItemMenu(Handler handler, BuildingManager buildingManager) {
		this.handler = handler;
		this.removeBtnX = (handler.getWidth() / 2) - 212;
		this.removeBtnY = 200;
		this.buildBtnX = (handler.getWidth() / 2) + 20;
		this.buildBtnY = 200;
		this.buildingManager = buildingManager;
	}

	public void tick() {
		if (handler.getMouseManager().isRightPressed() && active) {
			selectedBtn = 2;
			active = false;
			handler.getWorld().player.freeze(false);
		}
		if (active) {
			handler.getWorld().player.getInventory().disableInventory(true);
			handler.getWorld().player.freeze(true);
		} else {
			selectedBtn = 2;
			handler.getWorld().player.getInventory().disableInventory(false);
			// handler.getWorld().player.freeze(false);
		}

		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_A) && active)
			selectedBtn--;
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_D) && active)
			selectedBtn++;

		if (selectedBtn < 0) {
			selectedBtn = 2;
		} else if (selectedBtn > 2) {
			selectedBtn = 0;
		}

		if (handler.getMouseManager().isLeftPressed() && active) {
			if (selectedBtn == 0) {
				removeItem();
			} else if (selectedBtn == 1) {
				build(new HermitHut(handler, handler.getWorld().player.getX() - 105,
						handler.getWorld().player.getY() - 210));
			}
			handler.getWorld().player.freeze(false);
		}

		if (couldNotConstruct) {
			couldNotConstructTimer++;
			if (couldNotConstructTimer >= 90) {
				couldNotConstructTimer = 0;
				couldNotConstruct = false;
			}
		}
		if (!canRemoveItem) {
			canRemoveItemTimer++;
			if (canRemoveItemTimer >= 12) {
				canRemoveItemTimer = 0;
				canRemoveItem = true;
			}
		}
	}

	public void render(Graphics g) {
		if (!active)
			return;
		if (selectedBtn == 0) {
			g.drawImage(Assets.btn_remove[1], (int) removeBtnX, (int) removeBtnY, 192, 64, null);
			g.drawImage(Assets.btn_build[0], (int) buildBtnX, (int) buildBtnY, 192, 64, null);
		} else if (selectedBtn == 1) {
			g.drawImage(Assets.btn_remove[0], (int) removeBtnX, (int) removeBtnY, 192, 64, null);
			g.drawImage(Assets.btn_build[1], (int) buildBtnX, (int) buildBtnY, 192, 64, null);
		} else {
			g.drawImage(Assets.btn_remove[0], (int) removeBtnX, (int) removeBtnY, 192, 64, null);
			g.drawImage(Assets.btn_build[0], (int) buildBtnX, (int) buildBtnY, 192, 64, null);
		}

		if (couldNotConstruct) {
			String text = "Could not construct building";

			Rectangle rect = new Rectangle(handler.getWidth(), handler.getHeight());
			FontMetrics metrics = g.getFontMetrics(Assets.font28);
			int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
			// int y = rect.y + ((rect.height - metrics.getHeight()) / 2) +
			// metrics.getAscent();
			g.setFont(Assets.font28);
			g.drawString(text, x, (int) 500);
		}
	}

	private void build(Building b) {
		if (inventoryItems.size() != 0) {

			int itemCount = inventoryItems.get(selectedItem).getCount();
			//TODO
			int requiredItems = 1;
			
			if (itemCount >= requiredItems && inventoryItems.get(selectedItem).getId() == Item.woodItem.getId()
					&& !isColliding(b)) {
				if (handler.getWorld().player.getX() / Tile.TILEWIDTH < 999) {
					buildingManager = handler.getWorld().getBuildingManager();
					if (itemCount > requiredItems) {
						inventoryItems.get(selectedItem).setCount(itemCount - requiredItems);
					} else if (itemCount == requiredItems) {
						inventoryItems.remove(selectedItem);
					}
					buildingManager.addBuilding(b);
					this.active = false;
				} else {
					System.out.println("Cannot build: Buildings cannot be placed inside buildings.");
				}
			}
		}
	}

	private void removeItem() {
		if (inventoryItems.size() != 0) {

			int itemCount = inventoryItems.get(selectedItem).getCount();
			if (canRemoveItem) {
				if (itemCount >= 1) {
					if (itemCount > 1) {
						inventoryItems.get(selectedItem).setCount(itemCount - 1);
					} else {
						inventoryItems.remove(selectedItem);
					}
				}
				canRemoveItem=false;
			}
		}
	}

	public boolean isColliding(Building b) {
		int tileWidth = b.getTileWidth();
		int tileHeight = b.getTileHeight();
		int x = (int) (b.getX() / Tile.TILEWIDTH) + ((b.getWidth() / Tile.TILEWIDTH) - b.getTileWidth());
		int y = (int) (b.getY() / Tile.TILEHEIGHT) + ((b.getHeight() / Tile.TILEHEIGHT) - b.getTileHeight());

		for (int iY = y; iY <= (tileHeight + y); iY++) {

			for (int iX = x; iX <= (tileWidth + x); iX++) {

				if (handler.getWorld().getTile(iX, iY).isSolid()
						|| handler.getWorld().getSecondLayerTile(iX, iY).isSolid()
						|| handler.getWorld().getThirdLayerTile(iX, iY).isSolid()) {
					System.out.println("Cannot build: Not enough space: " + "X: " + iX + " Y: " + iY);
					System.out.println(
							"player position: " + "X: " + (int) handler.getWorld().player.getX() / Tile.TILEWIDTH
									+ " Y: " + (int) handler.getWorld().player.getY() / Tile.TILEHEIGHT);
					couldNotConstruct = true;
					return true;
				}

				for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
					if (e != handler.getWorld().player) {
						if ((int) (e.getY() / Tile.TILEHEIGHT) == iY && (int) (e.getX() / Tile.TILEWIDTH) == iX) {
							System.out.println(
									"Cannot build: Entity (" + e + ") is in the way: " + "X: " + iX + " Y: " + iY);
							System.out.println("player position: " + "X: "
									+ (int) handler.getWorld().player.getX() / Tile.TILEWIDTH + " Y: "
									+ (int) handler.getWorld().player.getY() / Tile.TILEHEIGHT);
							couldNotConstruct = true;
							return true;
						}
					}
				}

				for (Building building : handler.getWorld().getBuildingManager().getBuildings()) {
					int buildingTileWidth = building.getTileWidth();
					int buildingTileHeight = building.getTileHeight();
					int buildingX = (int) (building.getX() / Tile.TILEWIDTH)
							+ ((building.getWidth() / Tile.TILEWIDTH) - building.getTileWidth());
					int buildingY = (int) (building.getY() / Tile.TILEHEIGHT)
							+ ((building.getHeight() / Tile.TILEHEIGHT) - building.getTileHeight());

					for (int biY = buildingY; biY <= (buildingTileHeight + buildingY); biY++) {

						for (int biX = buildingX; biX <= (buildingTileWidth + buildingX); biX++) {

							if (biY == iY && biX == iX) {
								System.out.println("Cannot build: Building (" + building + ") is in the way: " + "X: "
										+ iX + " Y: " + iY);
								System.out.println("player position: " + "X: "
										+ (int) handler.getWorld().player.getX() / Tile.TILEWIDTH + " Y: "
										+ (int) handler.getWorld().player.getY() / Tile.TILEHEIGHT);
								couldNotConstruct = true;
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	// GETTERS SETTERS

	public void setInventoryItems(ArrayList inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	public void setSelectedItem(int selectedItem) {
		this.selectedItem = selectedItem;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setActive(boolean active) {
		this.active = active;

	}

	public boolean isActive() {
		return active;
	}
}
