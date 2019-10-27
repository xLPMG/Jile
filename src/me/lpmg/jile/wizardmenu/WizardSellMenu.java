package me.lpmg.jile.wizardmenu;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.creatures.Player;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.gfx.Text;
import me.lpmg.jile.items.Item;

public class WizardSellMenu {

	private Handler handler;
	private Player player;
	private boolean active;
	private int menuX = 119, menuY = 64, menuWidth = 512, menuHeight = 384, menuListCenterX = menuX + 171,
			menuListCenterY = menuY + menuHeight / 2 + 5, menuListSpacing = 30,
			menuListItemNameX = menuListCenterX - 100, menuListItemPriceX = menuX + menuWidth - 20, menuCenterX = menuX+(menuWidth/2);

	private int selectedItem = 0;

	private ArrayList<Item> sellingItems;
	private ArrayList<Item> inventoryItems;

	public WizardSellMenu(Handler handler) {
		this.handler = handler;
		sellingItems = new ArrayList<Item>();
		initItems();
	}

	public void tick() {
		if (player == null) {
			player = handler.getWorld().getEntityManager().getPlayer();
		}

		if (handler.getMouseManager().isRightPressed() && active) {
			active = false;
		}
		if (!active) {
			return;
		}else {
			handler.getWorld().player.freeze(true);
		}

		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)&active)
			selectedItem--;
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)&&active)
			selectedItem++;
		if (selectedItem < 0)
			selectedItem = sellingItems.size() - 1;
		else if (selectedItem >= sellingItems.size())
			selectedItem = 0;

		// SELL
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)&&active) {
			Item item = sellingItems.get(selectedItem);
			inventoryItems = player.getInventory().getInventoryItems();
			ArrayList<Item> inventoryItemsCopy = new ArrayList<Item>(inventoryItems);
			
			for (Item it : inventoryItems) {
				if(it.getId()==item.getId()) {
					if(it.getCount()>1) {
					it.setCount(it.getCount()-1);
					}else if(it.getCount()==1) {
					inventoryItemsCopy.remove(inventoryItemsCopy.indexOf(it));
					}
					player.addMoney(it.getSellingPrice());
				}
			}
			
			player.getInventory().setInventoryItems(inventoryItemsCopy);
		}
	}

	public void render(Graphics g) {
		if (!active)
			return;
		g.drawImage(Assets.wizardSellMenu, menuX, menuY, menuWidth, menuHeight, null);

		int len = sellingItems.size();
		if (len == 0)
			return;

		for (int i = -5; i < 6; i++) {
			if (selectedItem + i < 0 || selectedItem + i >= len)
				continue;
			if (i == 0) {
				Text.drawString(g, sellingItems.get(selectedItem + i).getName(), menuListItemNameX,
						menuListCenterY + i * menuListSpacing, true, Color.YELLOW, Assets.font28);
				g.drawImage(sellingItems.get(selectedItem + i).getTexture(), menuCenterX-16, menuListCenterY -16 + i * menuListSpacing,32, 32, null);
				renderMoneySelected(g, sellingItems.get(selectedItem + i).getSellingPrice(), i);
			} else {
				Text.drawString(g, sellingItems.get(selectedItem + i).getName(), menuListItemNameX,
						menuListCenterY + i * menuListSpacing, true, Color.WHITE, Assets.font28);
				g.drawImage(sellingItems.get(selectedItem + i).getTexture(), menuCenterX-16, menuListCenterY -16 + i * menuListSpacing, 32, 32, null);
				renderMoney(g, sellingItems.get(selectedItem + i).getSellingPrice(), i);
			}
		}
	}
	
	private void renderMoney(Graphics g, int money, int i) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setFont(Assets.font28);
		g2.setColor(Color.WHITE);
		FontMetrics fontMetrics = g2.getFontMetrics();
		String moneyString = Integer.toString(money)+"$";
		g2.drawString(moneyString, menuListItemPriceX - fontMetrics.stringWidth(moneyString), 8+menuListCenterY + i * menuListSpacing);
	}
	
	private void renderMoneySelected(Graphics g, int money, int i) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setFont(Assets.font28);
		g2.setColor(Color.YELLOW);
		FontMetrics fontMetrics = g2.getFontMetrics();
		String moneyString = Integer.toString(money)+"$";
		g2.drawString(moneyString, menuListItemPriceX - fontMetrics.stringWidth(moneyString), 8+menuListCenterY + i * menuListSpacing);
	}

	private void initItems() {
		sellingItems.add(Item.woodItem);
		sellingItems.add(Item.rockItem);
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}
}
