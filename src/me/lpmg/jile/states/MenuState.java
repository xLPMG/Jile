package me.lpmg.jile.states;

import java.awt.Graphics;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.ui.ClickListener;
import me.lpmg.jile.ui.UIImageButton;
import me.lpmg.jile.ui.UIManager;
import me.lpmg.jile.ui.UIParallaxBGvt;
import me.lpmg.jile.ui.UIParallaxBGvtBTN;
import me.lpmg.jile.ui.UISubtitle;

public class MenuState extends State {

	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		handler.getGame().loadSettings();
		handler.getAudioHandler().playSound("/audio/loops/69_Forest_Night.mp3", true);
		handler.getAudioHandler().mute(!handler.getSettings().MUSIC_ON);
		
//		uiManager.addObject(new UIBackground(0, 0, handler.getWidth(), handler.getHeight(), Assets.parallax_mountain_bg));
//		uiManager.addObject(new UIBackground(0, 0, handler.getWidth(), handler.getHeight(), Assets.parallax_mountain_mountain_far));
//		uiManager.addObject(new UIBackground(0, 0, handler.getWidth(), handler.getHeight(), Assets.parallax_mountain_mountains));
//		uiManager.addObject(new UIBackground(0, 0, handler.getWidth(), handler.getHeight(), Assets.parallax_mountain_trees));
//		uiManager.addObject(new UIBackground(0, 0, handler.getWidth(), handler.getHeight(), Assets.parallax_mountain_foreground_trees));
		
//		uiManager.addObject(new UIParallaxBGvt(0, 0, handler.getWidth(), handler.getHeight(), "Jile", handler.getVersion(), Assets.parallax_mountain_bg,Assets.parallax_mountain_clouds,
//				Assets.parallax_mountain_mountain_far, Assets.parallax_mountain_mountains,
//				Assets.parallax_mountain_trees, Assets.parallax_mountain_foreground_trees));
		
		uiManager.addObject(new UIParallaxBGvtBTN(0, 0, handler.getWidth(), handler.getHeight(), "Jile", handler.getVersion(), Assets.parallax_mountain_bg,Assets.parallax_mountain_clouds,
				Assets.parallax_mountain_mountain_far, Assets.parallax_mountain_mountains,
				Assets.parallax_mountain_trees, Assets.parallax_mountain_foreground_trees, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				handler.getAudioHandler().playSound("/audio/loops/202_Heart_Drowned.mp3", true);
			}
		}));
		
//		uiManager.addObject(new UITitle(0, 300, handler.getWidth(), handler.getHeight(), "Jile", handler.getVersion()));
		uiManager.addObject(new UISubtitle(5, handler.getHeight() - 10, handler.getWidth(), handler.getHeight(),
				"by LPMG Game Studios"));
//		uiManager.addObject(
//				new UIImageButton((handler.getWidth() - 128) / 2, 350, 128, 64, Assets.btn_start, new ClickListener() {
//					@Override
//					public void onClick() {
//						handler.getMouseManager().setUIManager(null);
//						State.setState(handler.getGame().gameState);
//						handler.getAudioHandler().playSound("/audio/ost/Spring Walk.mp3", true);
//					}
//				}));
	}

	@Override
	public void tick() {
		uiManager.tick();

		// Temporarily just go directly to the GameState, skip the menu state!
		// handler.getMouseManager().setUIManager(null);
		// State.setState(handler.getGame().gameState);

		// uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
