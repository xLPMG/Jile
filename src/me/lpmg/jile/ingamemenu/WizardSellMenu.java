package me.lpmg.jile.ingamemenu;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private int menuWidth = 685, menuHeight = 384, menuX = (1000/2)-menuWidth/2, menuY = 128, menuListCenterX = menuX + 216,
			menuListCenterY = menuY + menuHeight / 2 + 5, menuListSpacing = 30,
			menuListItemNameX = menuX + 22, menuListItemPriceX = menuX + menuWidth - 22,
			menuCenterX = menuX + (menuWidth / 2);
	private int iTick;

	private int selectedItem = 0;

	private ArrayList<Item> sellingItems;
	private ArrayList<Item> inventoryItems;

	public WizardSellMenu(Handler handler) {
		this.handler = handler;
		sellingItems = new ArrayList<Item>();
		initItems();
		
		MouseAdapter mA = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3 && active) {
					active = false;
					handler.getWorld().player.freeze(false);
				}
			}
		};
		handler.addMouseListener(mA);
		
		KeyAdapter kA = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_W&&active)
					selectedItem--;
				if (e.getKeyCode()==KeyEvent.VK_S&&active)
					selectedItem++;
				// SELL
				if (e.getKeyCode()==KeyEvent.VK_ENTER&&active) {
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
		};
		handler.addKeyListener(kA);
	}

	public void tick() {
		iTick++;
		
		if (player == null) {
			player = handler.getWorld().getEntityManager().getPlayer();
		}
		if (!active) {
			return;
		}else {
			handler.getWorld().player.freeze(true);
		}
		if (selectedItem < 0)
			selectedItem = sellingItems.size() - 1;
		else if (selectedItem >= sellingItems.size())
			selectedItem = 0;
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
			String itemName = sellingItems.get(selectedItem + i).getName();

			if (itemName.length() <= 15) {
				if (i == 0) {
					Text.drawString(g, sellingItems.get(selectedItem + i).getName(), menuListItemNameX,
							menuListCenterY + i * menuListSpacing, false, true, Color.YELLOW, Assets.font28);
					g.drawImage(sellingItems.get(selectedItem + i).getTexture(), menuCenterX - 16,
							menuListCenterY - 16 + i * menuListSpacing, 32, 32, null);
					renderMoneySelected(g, sellingItems.get(selectedItem + i).getBuyingPrice(), i);
				} else {
					Text.drawString(g, sellingItems.get(selectedItem + i).getName(), menuListItemNameX,
							menuListCenterY + i * menuListSpacing, true, true, Color.WHITE, Assets.font28);
					g.drawImage(sellingItems.get(selectedItem + i).getTexture(), menuCenterX - 16,
							menuListCenterY - 16 + i * menuListSpacing, 32, 32, null);
					renderMoney(g, sellingItems.get(selectedItem + i).getBuyingPrice(), i);
				}
			} else {
				if (iTick >= 1800) {
					iTick = 0;
					// to stop iTick getting extremely high to prevent lags or errors
				}
				int charCounter = 0;
				int lettersToShift = itemName.length() - 15;

				// IGNORE
				charCounter = (iTick / 20) % (lettersToShift + 1 + 2 + 1);
				if (charCounter < 3) {
					charCounter = 0;

				} else {
					charCounter -= 2;
				}
				// This algorithm does: 0,1,2,3,4,5,6,7,8,9 -> 0,0,0,1,2,3,4,5,6,7,8,9 which
				// makes the name move only after a few secs of standing still
				// The following algorithm does: 0,0,0,1,2,3,4,5,6,7,8,9 ->
				// 0,0,0,1,2,3,4,5,6,7,8,9,9,9 to make the name stay a bit longer after moving
				if (charCounter >= lettersToShift) {
					charCounter = lettersToShift;
				}
				// END IGNORE

				String fittedItemName = itemName.substring(0, 15);
				String charsToAppend = itemName.substring(15, 15 + charCounter);
				String newItemName = fittedItemName.substring(charCounter) + charsToAppend;
				if (i == 0) {
					Text.drawString(g, newItemName, menuListItemNameX, menuListCenterY + i * menuListSpacing, true,
							true, Color.YELLOW, Assets.font28);
					g.drawImage(sellingItems.get(selectedItem + i).getTexture(), menuCenterX - 16,
							menuListCenterY - 16 + i * menuListSpacing, 32, 32, null);
					renderMoneySelected(g, sellingItems.get(selectedItem + i).getBuyingPrice(), i);
				} else {
					Text.drawString(g, newItemName, menuListItemNameX, menuListCenterY + i * menuListSpacing, true,
							true, Color.WHITE, Assets.font28);
					g.drawImage(sellingItems.get(selectedItem + i).getTexture(), menuCenterX - 16,
							menuListCenterY - 16 + i * menuListSpacing, 32, 32, null);
					renderMoney(g, sellingItems.get(selectedItem + i).getBuyingPrice(), i);
				}
			}

		}
//		if (!active)
//			return;
//		g.drawImage(Assets.wizardSellMenu, menuX, menuY, menuWidth, menuHeight, null);
//
//		int len = sellingItems.size();
//		if (len == 0)
//			return;
//
//		for (int i = -5; i < 6; i++) {
//			if (selectedItem + i < 0 || selectedItem + i >= len)
//				continue;
//			if (i == 0) {
//				Text.drawString(g, sellingItems.get(selectedItem + i).getName(), menuListItemNameX,
//						menuListCenterY + i * menuListSpacing, true, Color.YELLOW, Assets.font28);
//				g.drawImage(sellingItems.get(selectedItem + i).getTexture(), menuCenterX-16, menuListCenterY -16 + i * menuListSpacing,32, 32, null);
//				renderMoneySelected(g, sellingItems.get(selectedItem + i).getSellingPrice(), i);
//			} else {
//				Text.drawString(g, sellingItems.get(selectedItem + i).getName(), menuListItemNameX,
//						menuListCenterY + i * menuListSpacing, true, Color.WHITE, Assets.font28);
//				g.drawImage(sellingItems.get(selectedItem + i).getTexture(), menuCenterX-16, menuListCenterY -16 + i * menuListSpacing, 32, 32, null);
//				renderMoney(g, sellingItems.get(selectedItem + i).getSellingPrice(), i);
//			}
//		}
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
