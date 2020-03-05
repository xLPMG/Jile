package me.lpmg.jile.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.gfx.Text;
import me.lpmg.jile.items.Item;

public class ItemBar {

	private int barX;
	private int barY;
	private int zoom = 2;

	private int marginWidth = 5 * zoom, marginHeight = 5 * zoom;
	private int barWidth = 297 * zoom, barHeight = 42 * zoom;

	private int itemWidth = 32 * zoom, itemHeight = 32 * zoom;
	private int itemHighlightWidth = 42 * zoom, itemHighlightHeight = 42 * zoom;

	private int itemImageWidth, itemImageHeight;

	private int itemX1, itemX2, itemX3, itemX4, itemX5, itemX6, itemX7, itemX8, itemX9;
	private int itemY;
	private int itemImageX1, itemImageX2, itemImageX3, itemImageX4, itemImageX5, itemImageX6, itemImageX7, itemImageX8,
			itemImageX9;
	private int itemImageY;

	private int itemCountX, itemCountY;

	private int selectedItem = 0;
	private int itemBarSelectedSlot = 0;
	private int inventorySelectedSlot = 0;

	private Handler handler;
	private ArrayList<Item> inventoryItems;
	private Inventory inventory;

	public ItemBar(Handler handler, Inventory inventory) {
		this.handler = handler;
		this.inventory = inventory;
		inventoryItems = inventory.getInventoryItems();

		barX = (handler.getWidth() / 2) - (barWidth / 2);
		barY = handler.getHeight() - barHeight - 10;

		itemX1 = barX + marginWidth;
		itemX2 = barX + marginWidth + itemWidth;
		itemX3 = barX + marginWidth + (itemWidth * 2);
		itemX4 = barX + marginWidth + (itemWidth * 3);
		itemX5 = barX + marginWidth + (itemWidth * 4);
		itemX6 = barX + marginWidth + (itemWidth * 5);
		itemX7 = barX + marginWidth + (itemWidth * 6);
		itemX8 = barX + marginWidth + (itemWidth * 7);
		itemX9 = barX + marginWidth + (itemWidth * 8);

		itemImageWidth = itemWidth - 10;
		itemImageHeight = itemHeight - 10;

		itemImageX1 = itemX1 + 5;
		itemImageX2 = itemX2 + 5;
		itemImageX3 = itemX3 + 5;
		itemImageX4 = itemX4 + 5;
		itemImageX5 = itemX5 + 5;
		itemImageX6 = itemX6 + 5;
		itemImageX7 = itemX7 + 5;
		itemImageX8 = itemX8 + 5;
		itemImageX9 = itemX9 + 5;

		itemY = barY + marginHeight;
		itemImageY = itemY + 5;

		itemCountX = 22 * zoom + 8;
		itemCountY = (26 * zoom) + itemY;
	}

	public void tick() {
		itemBarSelectedSlot=inventory.getSelectedItem();

		if (inventory.getSelectedItem() > 8)
			itemBarSelectedSlot = 9;
		else if (inventorySelectedSlot < 0)
			itemBarSelectedSlot = 8;
		else if (inventorySelectedSlot > 8)
			itemBarSelectedSlot = 0;

		inventoryItems = inventory.getInventoryItems();
	}

	public void render(Graphics g) {
		g.drawImage(Assets.itemBar, barX, barY, barWidth, barHeight, null);
		if (inventoryItems.size() != 0) {
			for (Item item : inventoryItems) {
				// display items
				int itemNumber = inventoryItems.indexOf(item);
				if (itemNumber == 0) {
					g.drawImage(item.getTexture(), itemImageX1, itemImageY, itemImageWidth, itemImageHeight, null);
					Text.drawString(g, Integer.toString(item.getCount()), itemX1 + itemCountX, itemCountY, true,
							Color.WHITE, Assets.font28);
				} else if (itemNumber == 1) {
					g.drawImage(item.getTexture(), itemImageX2, itemImageY, itemImageWidth, itemImageHeight, null);
					Text.drawString(g, Integer.toString(item.getCount()), itemX2 + itemCountX, itemCountY, true,
							Color.WHITE, Assets.font28);
				} else if (itemNumber == 2) {
					g.drawImage(item.getTexture(), itemImageX3, itemImageY, itemImageWidth, itemImageHeight, null);
					Text.drawString(g, Integer.toString(item.getCount()), itemX3 + itemCountX, itemCountY, true,
							Color.WHITE, Assets.font28);
				} else if (itemNumber == 3) {
					g.drawImage(item.getTexture(), itemImageX4, itemImageY, itemImageWidth, itemImageHeight, null);
					Text.drawString(g, Integer.toString(item.getCount()), itemX4 + itemCountX, itemCountY, true,
							Color.WHITE, Assets.font28);
				} else if (itemNumber == 4) {
					g.drawImage(item.getTexture(), itemImageX5, itemImageY, itemImageWidth, itemImageHeight, null);
					Text.drawString(g, Integer.toString(item.getCount()), itemX5 + itemCountX, itemCountY, true,
							Color.WHITE, Assets.font28);
				} else if (itemNumber == 5) {
					g.drawImage(item.getTexture(), itemImageX6, itemImageY, itemImageWidth, itemImageHeight, null);
					Text.drawString(g, Integer.toString(item.getCount()), itemX6 + itemCountX, itemCountY, true,
							Color.WHITE, Assets.font28);
				} else if (itemNumber == 6) {
					g.drawImage(item.getTexture(), itemImageX7, itemImageY, itemImageWidth, itemImageHeight, null);
					Text.drawString(g, Integer.toString(item.getCount()), itemX7 + itemCountX, itemCountY, true,
							Color.WHITE, Assets.font28);
				} else if (itemNumber == 7) {
					g.drawImage(item.getTexture(), itemImageX8, itemImageY, itemImageWidth, itemImageHeight, null);
					Text.drawString(g, Integer.toString(item.getCount()), itemX8 + itemCountX, itemCountY, true,
							Color.WHITE, Assets.font28);
				} else if (itemNumber == 8) {
					g.drawImage(item.getTexture(), itemImageX9, itemImageY, itemImageWidth, itemImageHeight, null);
				}
			}
		}
		if (itemBarSelectedSlot == 0) {
			g.drawImage(Assets.itemBar_highlighted, itemX1 - marginWidth, itemY - marginHeight, itemHighlightWidth,
					itemHighlightHeight, null);
		} else if (itemBarSelectedSlot == 1) {
			g.drawImage(Assets.itemBar_highlighted, itemX2 - marginWidth, itemY - marginHeight, itemHighlightWidth,
					itemHighlightHeight, null);
		} else if (itemBarSelectedSlot == 2) {
			g.drawImage(Assets.itemBar_highlighted, itemX3 - marginWidth, itemY - marginHeight, itemHighlightWidth,
					itemHighlightHeight, null);
		} else if (itemBarSelectedSlot == 3) {
			g.drawImage(Assets.itemBar_highlighted, itemX4 - marginWidth, itemY - marginHeight, itemHighlightWidth,
					itemHighlightHeight, null);
		} else if (itemBarSelectedSlot == 4) {
			g.drawImage(Assets.itemBar_highlighted, itemX5 - marginWidth, itemY - marginHeight, itemHighlightWidth,
					itemHighlightHeight, null);
		} else if (itemBarSelectedSlot == 5) {
			g.drawImage(Assets.itemBar_highlighted, itemX6 - marginWidth, itemY - marginHeight, itemHighlightWidth,
					itemHighlightHeight, null);
		} else if (itemBarSelectedSlot == 6) {
			g.drawImage(Assets.itemBar_highlighted, itemX7 - marginWidth, itemY - marginHeight, itemHighlightWidth,
					itemHighlightHeight, null);
		} else if (itemBarSelectedSlot == 7) {
			g.drawImage(Assets.itemBar_highlighted, itemX8 - marginWidth, itemY - marginHeight, itemHighlightWidth,
					itemHighlightHeight, null);
		} else if (itemBarSelectedSlot == 8) {
			g.drawImage(Assets.itemBar_highlighted, itemX9 - marginWidth - 2, itemY - marginHeight, itemHighlightWidth,
					itemHighlightHeight, null);
		}
	}

	// SCROLL
	public void scrollUpByOne() {
		inventorySelectedSlot += 1;
		itemBarSelectedSlot = inventorySelectedSlot;
		inventory.setSelectedItem(inventorySelectedSlot);
		inventorySelectedSlot = inventory.getSelectedItem();
	}

	public void scrollDownByOne() {
		inventorySelectedSlot -= 1;
		if(inventorySelectedSlot<0) {
			inventorySelectedSlot=0;
		}
		itemBarSelectedSlot = inventorySelectedSlot;
		inventory.setSelectedItem(inventorySelectedSlot);
		inventorySelectedSlot = inventory.getSelectedItem();

	}

	// GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
