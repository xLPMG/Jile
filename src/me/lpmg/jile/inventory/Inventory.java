package me.lpmg.jile.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import me.lpmg.jile.Handler;
import me.lpmg.jile.buildings.BuildingManager;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.gfx.Text;
import me.lpmg.jile.ingamemenu.ItemMenu;
import me.lpmg.jile.input.MouseManager;
import me.lpmg.jile.items.Item;
import me.lpmg.jile.items.Sword;

public class Inventory {

	private Handler handler;
	private boolean active = false;
	private boolean disabled = false;
	private ArrayList<Item> inventoryItems;
	private BuildingManager buildingManager;
	private ItemMenu itM;

	private Sword equippedSword;

	private int equipWidth = 173;

	private int invX = 32, invY = 64, invWidth = 512 + equipWidth, invHeight = 384,
			invListCenterX = invX + equipWidth + 171, invListCenterY = invY + invHeight / 2 + 5, invListSpacing = 30;

	private int invImageX = 384 + equipWidth + invX, invImageY = 34 + invY, invImageWidth = 64, invImageHeight = 64;

	private int invCountX = 416 + equipWidth + invX, invCountY = 124 + invY;

	private int equipButtonX = invX + 506, equipButtonY = invY + 182;
	private int equipButtonWidth = 96, equipButtonHeight = 32;
	private Rectangle equipButtonBounds = new Rectangle(equipButtonX, equipButtonY, equipButtonWidth,
			equipButtonHeight);

	private int equipSlotImageWidth = 64, equipSlotImageHeight = 64;
	
	private int equipSlotWidth = 66, equipSlotHeight = 66;
	private int equipSlotSpacingX = (equipSlotWidth - equipSlotImageWidth) / 2;
	private int equipSlotSpacingY = (equipSlotHeight - equipSlotImageHeight) / 2;

	private int equipSlotX1 = invX + 12 + equipSlotSpacingX, equipSlotY1 = invY + 39 + equipSlotSpacingY;
	private int equipSlotX2 = invX + 12 + equipSlotSpacingX, equipSlotY2 = invY + 118 + equipSlotSpacingY;
	private int equipSlotX3 = invX + 12 + equipSlotSpacingX, equipSlotY3 = invY + 197 + equipSlotSpacingY;
	private int equipSlotX4 = invX + 12 + equipSlotSpacingX, equipSlotY4 = invY + 276 + equipSlotSpacingY;
	private int equipSlotX5 = invX + 91 + equipSlotSpacingX, equipSlotY5 = invY + 39 + equipSlotSpacingY;
	private int equipSlotX6 = invX + 91 + equipSlotSpacingX, equipSlotY6 = invY + 118 + equipSlotSpacingY;
	private int equipSlotX7 = invX + 91 + equipSlotSpacingX, equipSlotY7 = invY + 197 + equipSlotSpacingY;
	private int equipSlotX8 = invX + 91 + equipSlotSpacingX, equipSlotY8 = invY + 276 + equipSlotSpacingY;

	private int selectedItem = 0;

	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
		itM = new ItemMenu(handler, buildingManager);
	}

	public void tick() {
		itM.tick();
		itM.setInventoryItems(inventoryItems);
		itM.setSelectedItem(selectedItem);

		itemActions();

		if (disabled) {
			active = false;
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

			if (inventoryItems.size() != 0) {
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
		if (handler.getMouseManager().isLeftPressed()) {
			if (equipButtonBounds.contains(handler.getMouseManager().getClickedPoint())) {
				if (selectedItem <= inventoryItems.size()) {
					Item item = inventoryItems.get(selectedItem);
					if (item instanceof Sword/* or Shield, Ring, etc */) {
							if (equippedSword != null) {
								inventoryItems.add(equippedSword);
								equippedSword = null;
							}
							equippedSword = (Sword) item;
							removeItem(item,1);
					}
				}
			}
		}
	}

	public void render(Graphics g) {
		itM.render(g);
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
		if (selectedItem < inventoryItems.size()) {
			Item item = inventoryItems.get(selectedItem);
			g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
			Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE,
					Assets.font28);
			// show equip button
			if (item instanceof Sword/* or Shield, Ring, etc */) {
				if (item != equippedSword) {
					g.drawImage(Assets.btn_equip, equipButtonX, equipButtonY, equipButtonWidth, equipButtonHeight,
							null);
				} else {
					g.drawImage(Assets.btn_unequip, equipButtonX, equipButtonY, equipButtonWidth, equipButtonHeight,
							null);
				}
			}
		}
		// EQUIPMENT
		if (equippedSword != null) {
			g.drawImage(equippedSword.getTexture(), equipSlotX2, equipSlotY2, equipSlotImageWidth, equipSlotImageHeight,
					null);
			equippedSword.takeEffect();
		}

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

	private void removeItem(Item item, int amount) {
		for (Item i : inventoryItems) {
			if (i.getId() == item.getId()) {
				if (i.getCount() >= 1) {
					if (i.getCount() > 1) {
						i.setCount(i.getCount() - amount);
					} else {
						System.out.println("count: "+i.getCount()+", item: "+i.getName()+","+i.getId());
						inventoryItems.remove(i);
					}
				}
				return;
			}
		}
	}

	private void itemActions() {
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_B)) {
			itM.setActive(true);
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
		this.inventoryItems = inventoryItems;
	}

	public void setSelectedItem(int slotID) {
		if (inventoryItems.size() > slotID) {
			selectedItem = slotID;
		}
	}

	public void disableInventory(boolean disabled) {
		this.disabled = disabled;
	}

}
