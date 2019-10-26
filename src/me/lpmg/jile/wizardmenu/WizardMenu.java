package me.lpmg.jile.wizardmenu;

import java.awt.Graphics;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Assets;

public class WizardMenu {

	private Handler handler;
	private boolean active = false;
	private int menuX = 119, menuY = 64, menuWidth = 512, menuHeight = 384, menuListCenterX = menuX + 171,
			menuListCenterY = menuY + menuHeight / 2 + 5, menuListSpacing = 30;
	
	public WizardMenu(Handler handler) {
		this.handler=handler;
	}
	
	public void tick() {
		if (handler.getMouseManager().isRightPressed())
			active=false;
		
		if(active) {
			handler.getWorld().player.getInventory().disableInventory(true);
		}else {
			handler.getWorld().player.getInventory().disableInventory(false);
		}
	}
	public void render(Graphics g) {
		if (!active)
			return;
		System.out.println("render");
		g.drawImage(Assets.wizardMenu, menuX, menuY, menuWidth, menuHeight, null);
	}
	
	// GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public void setActive(boolean active) {
		this.active=active;
		
	}
	public boolean isActive() {
		return active;
	}
}
