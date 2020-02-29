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
import me.lpmg.jile.items.armor.Sword;

public class WizardBuyMenu {

	private Handler handler;
	private Player player;
	private boolean active;
	private int menuX = 119, menuY = 64, menuWidth = 512, menuHeight = 384, menuListCenterX = menuX + 171,
			menuListCenterY = menuY + menuHeight / 2 + 5, menuListSpacing = 30,
			menuListItemNameX = menuListCenterX - 100, menuListItemPriceX = menuX + menuWidth - 20,
			menuCenterX = menuX + (menuWidth / 2);

	private int selectedItem = 0;

	private ArrayList<Item> buyingItems;
	private ArrayList<Item> inventoryItems;

	public WizardBuyMenu(Handler handler) {
		this.handler = handler;
		buyingItems = new ArrayList<Item>();
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
				if (e.getKeyCode() == KeyEvent.VK_W && active)
					selectedItem--;
				if (e.getKeyCode() == KeyEvent.VK_S && active)
					selectedItem++;
				// BUY
				if (e.getKeyCode() == KeyEvent.VK_ENTER && active) {
					Item item = buyingItems.get(selectedItem);
					item.setCount(1);
//					inventoryItems = player.getInventory().getInventoryItems();
					if (player.getMoney() >= item.getBuyingPrice()) {
						player.subtractMoney(item.getBuyingPrice());
						player.getInventory().addItem(item);
					}

				}
			}
		};
		handler.addKeyListener(kA);
	}

	public void tick() {
		if (player == null) {
			player = handler.getWorld().getEntityManager().getPlayer();
		}
		if (!active) {
			return;
		} else {
			handler.getWorld().player.freeze(true);
		}
		if (selectedItem < 0)
			selectedItem = buyingItems.size() - 1;
		else if (selectedItem >= buyingItems.size())
			selectedItem = 0;
	}

	public void render(Graphics g) {
		if (!active)
			return;
		g.drawImage(Assets.wizardBuyMenu, menuX, menuY, menuWidth, menuHeight, null);

		int len = buyingItems.size();
		if (len == 0)
			return;

		for (int i = -5; i < 6; i++) {
			if (selectedItem + i < 0 || selectedItem + i >= len)
				continue;
			if (i == 0) {
				Text.drawString(g, buyingItems.get(selectedItem + i).getName(), menuListItemNameX,
						menuListCenterY + i * menuListSpacing, true, Color.YELLOW, Assets.font28);
				g.drawImage(buyingItems.get(selectedItem + i).getTexture(), menuCenterX - 16,
						menuListCenterY - 16 + i * menuListSpacing, 32, 32, null);
				renderMoneySelected(g, buyingItems.get(selectedItem + i).getBuyingPrice(), i);
			} else {
				Text.drawString(g, buyingItems.get(selectedItem + i).getName(), menuListItemNameX,
						menuListCenterY + i * menuListSpacing, true, Color.WHITE, Assets.font28);
				g.drawImage(buyingItems.get(selectedItem + i).getTexture(), menuCenterX - 16,
						menuListCenterY - 16 + i * menuListSpacing, 32, 32, null);
				renderMoney(g, buyingItems.get(selectedItem + i).getBuyingPrice(), i);
			}
		}
	}

	private void renderMoney(Graphics g, int money, int i) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(Assets.font28);
		g2.setColor(Color.WHITE);
		FontMetrics fontMetrics = g2.getFontMetrics();
		String moneyString = Integer.toString(money) + "$";
		g2.drawString(moneyString, menuListItemPriceX - fontMetrics.stringWidth(moneyString),
				8 + menuListCenterY + i * menuListSpacing);
	}

	private void renderMoneySelected(Graphics g, int money, int i) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(Assets.font28);
		g2.setColor(Color.YELLOW);
		FontMetrics fontMetrics = g2.getFontMetrics();
		String moneyString = Integer.toString(money) + "$";
		g2.drawString(moneyString, menuListItemPriceX - fontMetrics.stringWidth(moneyString),
				8 + menuListCenterY + i * menuListSpacing);
	}

	private void initItems() {
		buyingItems.add(Item.woodItem);
		buyingItems.add(Item.rockItem);
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}
}
