package me.lpmg.jile.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.input.MouseManager;
import me.lpmg.jile.items.Item;
import me.lpmg.jile.ui.ClickListener;
import me.lpmg.jile.ui.UIBackground;
import me.lpmg.jile.ui.UICheckbox;
import me.lpmg.jile.ui.UIManager;
import me.lpmg.jile.ui.UIObject;
import me.lpmg.jile.utils.AudioHandler;

public class OptionsState extends State {

	private UIManager uiManager;

	public OptionsState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UICheckbox(64, 100, 32, 32, handler.getSettings().MUSIC_ON) {

			protected void activated() {
				handler.getSettings().MUSIC_ON = true;
				handler.getAudioHandler().mute(false);
			}

			protected void deactivated() {
				handler.getSettings().MUSIC_ON = false;
				handler.getAudioHandler().mute(true);
			}
		});
//		uiManager.addObject(new UICheckbox(64, 200, 32, 32, handler.getSettings().SFX_ON) {
//
//			protected void activated() {
//				handler.getSettings().SFX_ON = true;
//				handler.getSfxHandler().mute(false);
//			}
//
//			protected void deactivated() {
//				handler.getSettings().SFX_ON = false;
//				handler.getSfxHandler().mute(true);
//			}
//		});

	}

	@Override
	public void tick() {
		uiManager.tick();
		// Temporarily just go directly to the GameState, skip the menu state!
		// handler.getMouseManager().setUIManager(null);
		// State.setState(handler.getGame().gameState);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.blackTile, 0, 0, handler.getWidth(), handler.getHeight(), null);
		g.drawImage(Assets.background_plain, 50, 50, 900, 650, null);
		g.drawImage(Assets.background_plain_small, 344, 25, 312, 50, null);

		g.setColor(Color.decode("#FFDAB5"));
		g.setFont(Assets.font48);
		g.drawString("Options", 390, 64);

		g.setFont(Assets.font32);
		g.drawString("MUSIC", 104, 124);
		
//		g.setFont(Assets.font32);
//		g.drawString("SOUND EFFECTS", 104, 248);

		uiManager.render(g);
	}

}
