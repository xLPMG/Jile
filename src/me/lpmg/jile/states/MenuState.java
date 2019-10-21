package me.lpmg.jile.states;

import java.awt.Graphics;

import javax.swing.JLabel;

import me.lpmg.jile.Handler;
import me.lpmg.jile.display.Display;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.ui.ClickListener;
import me.lpmg.jile.ui.UIBackground;
import me.lpmg.jile.ui.UIImageButton;
import me.lpmg.jile.ui.UIManager;
import me.lpmg.jile.ui.UISubtitle;
import me.lpmg.jile.ui.UITitle;

public class MenuState extends State {

	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIBackground(0, 0, 640, 480, Assets.grass_full));
		uiManager.addObject(new UITitle(245, 100, 0, 0, "Jile"));
		uiManager.addObject(new UISubtitle(5, 150, 0, 0, "by LPMG Game Studios"));
		uiManager.addObject(new UIImageButton(260, 200, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
		
		// Temporarily just go directly to the GameState, skip the menu state!
		//handler.getMouseManager().setUIManager(null);
		//State.setState(handler.getGame().gameState);
		
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
