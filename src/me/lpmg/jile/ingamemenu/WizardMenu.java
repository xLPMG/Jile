package me.lpmg.jile.ingamemenu;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.items.Item;
import me.lpmg.jile.items.Sword;

public class WizardMenu {

	private Handler handler;
	private boolean active = false;
	public WizardBuyMenu wBM;
	public WizardSellMenu wSM;

	private int selectedBtn = 2;
	private int buyBtnX, buyBtnY;
	private int sellBtnX, sellBtnY;
	private Rectangle buyButtonBounds;
	private Rectangle sellButtonBounds;

	public WizardMenu(Handler handler) {
		this.handler = handler;
		this.buyBtnX = (handler.getWidth() / 2) - 148;
		this.buyBtnY = 200;
		this.sellBtnX = (handler.getWidth() / 2) + 20;
		this.sellBtnY = 200;
		buyButtonBounds = new Rectangle(buyBtnX, buyBtnY, 128, 64);
		sellButtonBounds = new Rectangle(sellBtnX, sellBtnY, 128, 64);

		wBM = new WizardBuyMenu(handler);
		wSM = new WizardSellMenu(handler);

		MouseAdapter mA = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON3) {
					selectedBtn = 2;
					active = false;
					handler.getWorld().player.freeze(false);
				}

				if (e.getButton() == MouseEvent.BUTTON1 && active) {
					if (buyButtonBounds.contains(e.getPoint()) && !wBM.isActive() && !wSM.isActive()) {
						wBM.setActive(true);
						active = false;
					} else if (sellButtonBounds.contains(e.getPoint()) && !wBM.isActive() && !wSM.isActive()) {
						wSM.setActive(true);
						active = false;
					}
					handler.getWorld().player.freeze(false);
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				if (active) {
					if (buyButtonBounds.contains(e.getPoint())) {
						selectedBtn = 0;
					} else if (sellButtonBounds.contains(e.getPoint())) {
						selectedBtn = 1;
					} else {
						selectedBtn = 2;
					}
				}
			}
		};
		handler.addMouseListener(mA);
		handler.addMouseMotionListener(mA);
	}

	public void tick() {

		if (active) {
			handler.getWorld().player.getInventory().disableInventory(true);
			handler.getWorld().player.freeze(true);
		} else {
			selectedBtn = 2;
			handler.getWorld().player.getInventory().disableInventory(false);
			// handler.getWorld().player.freeze(false);
		}

		wBM.tick();
		wSM.tick();
	}

	public void render(Graphics g) {
		wBM.render(g);
		wSM.render(g);

		if (!active)
			return;

		if (selectedBtn == 0) {
			g.drawImage(Assets.btn_buy[1], (int) buyBtnX, (int) buyBtnY, 128, 64, null);
			g.drawImage(Assets.btn_sell[0], (int) sellBtnX, (int) sellBtnY, 128, 64, null);
		} else if (selectedBtn == 1) {
			g.drawImage(Assets.btn_buy[0], (int) buyBtnX, (int) buyBtnY, 128, 64, null);
			g.drawImage(Assets.btn_sell[1], (int) sellBtnX, (int) sellBtnY, 128, 64, null);
		} else {
			g.drawImage(Assets.btn_buy[0], (int) buyBtnX, (int) buyBtnY, 128, 64, null);
			g.drawImage(Assets.btn_sell[0], (int) sellBtnX, (int) sellBtnY, 128, 64, null);
		}
	}

	// GETTERS SETTERS

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
