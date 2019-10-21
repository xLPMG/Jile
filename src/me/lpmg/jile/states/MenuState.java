package me.lpmg.jile.states;

import java.awt.Graphics;

import me.lpmg.jile.Handler;
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
		
		uiManager.addObject(new UIBackground(0, 0, handler.getWidth(), handler.getHeight(), Assets.grass_dirtBottom));
		uiManager.addObject(new UITitle(0, 180, handler.getWidth(), handler.getHeight(), "Jile", handler.getVersion()));
		uiManager.addObject(new UISubtitle(5,  handler.getHeight()-10, handler.getWidth(), handler.getHeight(), "by LPMG Game Studios"));
		uiManager.addObject(new UIImageButton((handler.getWidth()-128)/2, 200, 128, 64, Assets.btn_start, new ClickListener() {
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
