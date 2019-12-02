package me.lpmg.jile.states;

import java.awt.Graphics;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.creatures.Player;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.ui.ClickListener;
import me.lpmg.jile.ui.UIBackground;
import me.lpmg.jile.ui.UIImageButton;
import me.lpmg.jile.ui.UIManager;
import me.lpmg.jile.ui.UISubtitleWhite;
import me.lpmg.jile.ui.UITitleWhite;

public class DeadState extends State {

	private UIManager uiManager;

	public DeadState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIBackground(0, 0, handler.getWidth(), handler.getHeight(), Assets.black));
		uiManager.addObject(new UISubtitleWhite(0, 180, handler.getWidth(), handler.getHeight(), "Your vision started fading"));
		uiManager.addObject(new UISubtitleWhite(0, 208, handler.getWidth(), handler.getHeight(), "and you blacked out...."));
		uiManager.addObject(new UITitleWhite(5,  handler.getHeight()-50, handler.getWidth(), handler.getHeight(), "Jile", handler.getVersion()));
		uiManager.addObject(new UISubtitleWhite(5,  handler.getHeight()-10, handler.getWidth(), handler.getHeight(), "by LPMG Game Studios"));
		uiManager.addObject(new UIImageButton((handler.getWidth()-128)/2, 400, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				
				Player player = new Player(handler, 300, 300);
				handler.getWorld().setPlayer(player);
				int spawnX = handler.getWorld().getSpawnX();
				int spawnY = handler.getWorld().getSpawnY();
				player.setX(spawnX);
				player.setY(spawnY);
				State.setState(handler.getGame().gameState);
				handler.getWorld().getSpeechToastManager().showToast("!PlayerPassedOut");
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
