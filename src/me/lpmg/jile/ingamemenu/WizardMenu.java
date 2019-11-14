package me.lpmg.jile.ingamemenu;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Assets;

public class WizardMenu {

	private Handler handler;
	private boolean active = false;
	public WizardBuyMenu wBM;
	public WizardSellMenu wSM;

	private int selectedBtn = 2;
	private int buyBtnX, buyBtnY;
	private int sellBtnX, sellBtnY;
	
	public WizardMenu(Handler handler) {
		this.handler=handler;
		this.buyBtnX=(handler.getWidth()/2)-148;
		this.buyBtnY = 200;
		this.sellBtnX=(handler.getWidth()/2)+20;
		this.sellBtnY = 200;
		
		wBM = new WizardBuyMenu(handler);
		wSM = new WizardSellMenu(handler);
	}
	
	public void tick() {
		if (handler.getMouseManager().isRightPressed() && active) {
			selectedBtn = 2;
			active = false;
			handler.getWorld().player.freeze(false);
		}
		if(active) {
			handler.getWorld().player.getInventory().disableInventory(true);
			handler.getWorld().player.freeze(true);
		}else {
			selectedBtn = 2;
			handler.getWorld().player.getInventory().disableInventory(false);
			//handler.getWorld().player.freeze(false);
		}
		
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)&&active)
			selectedBtn--;
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_D)&&active)
			selectedBtn++;
		
		if(selectedBtn<0) {
			selectedBtn=2;
		}else if(selectedBtn>2) {
			selectedBtn=0;
		}
		
		if (handler.getMouseManager().isLeftPressed()&&active) {
			if(selectedBtn==0&&!wBM.isActive()&&!wSM.isActive()) {
				wBM.setActive(true);
				this.active=false;
			}else if(selectedBtn==1&&!wBM.isActive()&&!wSM.isActive()){
				wSM.setActive(true);
				this.active=false;
			}
			handler.getWorld().player.freeze(false);
		}
		
		wBM.tick();
		wSM.tick();
	}
	public void render(Graphics g) {
		wBM.render(g);
		wSM.render(g);
		
		if (!active)
			return;
		
		if(selectedBtn==0) {
			g.drawImage(Assets.btn_buy[1], (int) buyBtnX, (int) buyBtnY, 128, 64, null);
			g.drawImage(Assets.btn_sell[0], (int) sellBtnX, (int) sellBtnY, 128, 64, null);
		}else if(selectedBtn==1){
			g.drawImage(Assets.btn_buy[0], (int) buyBtnX, (int) buyBtnY, 128, 64, null);
			g.drawImage(Assets.btn_sell[1], (int) sellBtnX, (int) sellBtnY, 128, 64, null);
		}else {
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
		this.active=active;
		
	}
	public boolean isActive() {
		return active;
	}
}
