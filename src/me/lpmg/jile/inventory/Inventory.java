package me.lpmg.jile.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import me.lpmg.jile.Handler;
import me.lpmg.jile.buildings.BuildingManager;
import me.lpmg.jile.buildings.HermitHut;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.gfx.Text;
import me.lpmg.jile.items.Item;

public class Inventory {

	private Handler handler;
	private boolean active = false;
	private boolean disabled = false;
	private ArrayList<Item> inventoryItems;
	private BuildingManager buildingManager;

	private int invX = 119, invY = 64, invWidth = 512, invHeight = 384, invListCenterX = invX + 171,
			invListCenterY = invY + invHeight / 2 + 5, invListSpacing = 30;

	private int invImageX = 388 + invX, invImageY = 34 + invY, invImageWidth = 64, invImageHeight = 64;

	private int invCountX = 420 + invX, invCountY = 124 + invY;

	private int selectedItem = 0;

	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
	}

	public void tick() {
		itemActions();
		
		if(disabled) {
			active=false;
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if (!active)
			return;

		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_W))
			selectedItem--;
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_S))
			selectedItem++;

		if (selectedItem < 0)
			selectedItem = inventoryItems.size() - 1;
		else if (selectedItem >= inventoryItems.size())
			selectedItem = 0;

		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_Q)) {

			if (inventoryItems.size()!=0) {
				handler.getWorld().getItemManager().addItem(inventoryItems.get(selectedItem).createNew(
						(int) handler.getWorld().player.getX(), (int) handler.getWorld().player.getY() + 75));

				int itemCount = inventoryItems.get(selectedItem).getCount();
				if (itemCount > 1) {
					inventoryItems.get(selectedItem).setCount(itemCount - 1);
				} else if (itemCount == 1) {
					inventoryItems.remove(selectedItem);
					selectedItem = 0;
				} else {
					// do nothing
				}
			}
		}
	}

	public void render(Graphics g) {
		if (!active)
			return;
		g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);

		int len = inventoryItems.size();
		if (len == 0)
			return;

		for (int i = -5; i < 6; i++) {
			if (selectedItem + i < 0 || selectedItem + i >= len)
				continue;
			if (i == 0) {
				Text.drawString(g, "> " + inventoryItems.get(selectedItem + i).getName() + " <", invListCenterX,
						invListCenterY + i * invListSpacing, true, Color.YELLOW, Assets.font28);
			} else {
				Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX,
						invListCenterY + i * invListSpacing, true, Color.WHITE, Assets.font28);
			}
		}

		Item item = inventoryItems.get(selectedItem);
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
		Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE, Assets.font28);
	}

	// Inventory methods

	public void addItem(Item item) {
		for (Item i : inventoryItems) {
			if (i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	
	private void itemActions() {
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_B)) {
			if (inventoryItems.size()!=0) {
				int itemCount = inventoryItems.get(selectedItem).getCount();
				if (itemCount >= 1&&inventoryItems.get(selectedItem).getId()==Item.woodItem.getId()) {
					buildingManager=handler.getWorld().getBuildingManager();
					if(itemCount>1) {
					inventoryItems.get(selectedItem).setCount(itemCount - 1);
					}else {
					inventoryItems.remove(selectedItem);
					}
					buildingManager.addBuilding(new HermitHut(handler, handler.getWorld().player.getX()-105, handler.getWorld().player.getY()-210));
				}
			}
		}
	}

	// GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public boolean isActive() {
		return active;
	}

	public ArrayList getInventoryItems() {
		return inventoryItems;
	}
	public void setInventoryItems(ArrayList inventoryItems) {
		this.inventoryItems=inventoryItems;
	}

	public void setSelectedItem(int slotID) {
		if (inventoryItems.size() > slotID) {
			selectedItem = slotID;
		}
	}
	
	public void disableInventory(boolean disabled) {
		this.disabled=disabled;
	}

}
