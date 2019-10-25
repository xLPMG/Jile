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
	
	private int marginWidth = 5*zoom, marginHeight=5*zoom;
	private int barWidth = 297*zoom, barHeight = 42*zoom;
	
	private int itemWidth = 32*zoom, itemheight = 32*zoom;
	private int itemHighlightWidth = 42*zoom, itemHighlightHeight = 42*zoom;
	
	private int itemX1, itemX2, itemX3, itemX4, itemX5, itemX6, itemX7, itemX8, itemX9;
	private int itemY;
	
	private int itemCountX, itemCountY;
	
	private int selectedItem = 0;
	private int selectedSlot = 0;
	
	private Handler handler;
	private ArrayList<Item> inventoryItems;
	
	public ItemBar(Handler handler, Inventory inventory) {
		this.handler = handler;
		inventoryItems = inventory.getInventoryItems();
		
		barX = (handler.getWidth()/2)-(barWidth/2);
		barY = handler.getHeight()-barHeight-10;
		
		itemX1 = barX+marginWidth; 
		itemX2 = barX+marginWidth+itemWidth; 
		itemX3 = barX+marginWidth+(itemWidth*2);
		itemX4 = barX+marginWidth+(itemWidth*3);
		itemX5 = barX+marginWidth+(itemWidth*4);
		itemX6 = barX+marginWidth+(itemWidth*5);
		itemX7 = barX+marginWidth+(itemWidth*6);
		itemX8 = barX+marginWidth+(itemWidth*7);
		itemX9 = barX+marginWidth+(itemWidth*8);
		
		itemY = barY+marginHeight;
		
		itemCountX = 26*zoom;
		itemCountY = (26*zoom)+itemY;
	}
	
	public void tick(){		
		if(selectedSlot < 0)
			selectedSlot = 8;
		else if(selectedSlot > 8)
			selectedSlot = 0;
	}
	public void render(Graphics g) {		
		g.drawImage(Assets.itemBar, barX,barY, barWidth, barHeight, null);
		if(selectedSlot==0) {
		g.drawImage(Assets.itemBar_highlighted, itemX1-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);
	}else if(selectedSlot==1) {
		g.drawImage(Assets.itemBar_highlighted, itemX2-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
	}else if(selectedSlot==2) {
		g.drawImage(Assets.itemBar_highlighted, itemX3-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
	}else if(selectedSlot==3) {
		g.drawImage(Assets.itemBar_highlighted, itemX4-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
	}else if(selectedSlot==4) {
		g.drawImage(Assets.itemBar_highlighted, itemX5-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
	}else if(selectedSlot==5) {
		g.drawImage(Assets.itemBar_highlighted, itemX6-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
	}else if(selectedSlot==6) {
		g.drawImage(Assets.itemBar_highlighted, itemX7-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
	}else if(selectedSlot==7) {
		g.drawImage(Assets.itemBar_highlighted, itemX8-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
	}else if(selectedSlot==8) {
		g.drawImage(Assets.itemBar_highlighted, itemX9-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
	}
		
		
		if(inventoryItems.size()!=0) {		
		for(Item item : inventoryItems) {
		//mark selected item
		if(item == inventoryItems.get(selectedItem)) {
//			int itemNumberSelected = inventoryItems.indexOf(item);
//			if(itemNumberSelected==0) {
//				g.drawImage(Assets.itemBar_highlighted, itemX1-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);
//			}else if(itemNumberSelected==1) {
//				g.drawImage(Assets.itemBar_highlighted, itemX2-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
//			}else if(itemNumberSelected==2) {
//				g.drawImage(Assets.itemBar_highlighted, itemX3-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
//			}else if(itemNumberSelected==3) {
//				g.drawImage(Assets.itemBar_highlighted, itemX4-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
//			}else if(itemNumberSelected==4) {
//				g.drawImage(Assets.itemBar_highlighted, itemX5-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
//			}else if(itemNumberSelected==5) {
//				g.drawImage(Assets.itemBar_highlighted, itemX6-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
//			}else if(itemNumberSelected==6) {
//				g.drawImage(Assets.itemBar_highlighted, itemX7-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
//			}else if(itemNumberSelected==7) {
//				g.drawImage(Assets.itemBar_highlighted, itemX8-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
//			}else if(itemNumberSelected==8) {
//				g.drawImage(Assets.itemBar_highlighted, itemX9-marginWidth, itemY-marginHeight, itemHighlightWidth, itemHighlightHeight, null);	
//			}
		}
		//display items
		int itemNumber = inventoryItems.indexOf(item);
		if(itemNumber==0) {
			g.drawImage(item.getTexture(), itemX1, itemY, itemWidth, itemheight, null);
			Text.drawString(g, Integer.toString(item.getCount()), itemX1+itemCountX, itemCountY, true, Color.WHITE, Assets.font28);
		}else if(itemNumber==1) {
			g.drawImage(item.getTexture(), itemX2, itemY, itemWidth, itemheight, null);	
			Text.drawString(g, Integer.toString(item.getCount()), itemX2+itemCountX, itemCountY, true, Color.WHITE, Assets.font28);
		}else if(itemNumber==2) {
			g.drawImage(item.getTexture(), itemX3, itemY, itemWidth, itemheight, null);	
			Text.drawString(g, Integer.toString(item.getCount()), itemX3+itemCountX, itemCountY, true, Color.WHITE, Assets.font28);
		}else if(itemNumber==3) {
			g.drawImage(item.getTexture(), itemX4, itemY, itemWidth, itemheight, null);	
			Text.drawString(g, Integer.toString(item.getCount()), itemX4+itemCountX, itemCountY, true, Color.WHITE, Assets.font28);
		}else if(itemNumber==4) {
			g.drawImage(item.getTexture(), itemX5, itemY, itemWidth, itemheight, null);	
			Text.drawString(g, Integer.toString(item.getCount()), itemX5+itemCountX, itemCountY, true, Color.WHITE, Assets.font28);
		}else if(itemNumber==5) {
			g.drawImage(item.getTexture(), itemX6, itemY, itemWidth, itemheight, null);	
			Text.drawString(g, Integer.toString(item.getCount()), itemX6+itemCountX, itemCountY, true, Color.WHITE, Assets.font28);
		}else if(itemNumber==6) {
			g.drawImage(item.getTexture(), itemX7, itemY, itemWidth, itemheight, null);	
			Text.drawString(g, Integer.toString(item.getCount()), itemX7+itemCountX, itemCountY, true, Color.WHITE, Assets.font28);
		}else if(itemNumber==7) {
			g.drawImage(item.getTexture(), itemX8, itemY, itemWidth, itemheight, null);	
			Text.drawString(g, Integer.toString(item.getCount()), itemX8+itemCountX, itemCountY, true, Color.WHITE, Assets.font28);
		}else if(itemNumber==8) {
			g.drawImage(item.getTexture(), itemX9, itemY, itemWidth, itemheight, null);	
		}
		}
		}
	}
	
	//SCROLL
	public void scrollUpByOne() {
		selectedSlot+=1;
	}
public void scrollDownByOne() {
	selectedSlot-=1;
	}
	
	// GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
