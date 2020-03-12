package me.lpmg.jile.states;

import java.awt.Color;
import java.awt.Graphics;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.entities.creatures.Merchant;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.gfx.Text;
import me.lpmg.jile.worlds.World;

public class GameState extends State {
	
	private World world;
	
	public GameState(Handler handler, World world){
		super(handler);
		this.world = world;
		handler.setWorld(world);
		world.initOnWorldLoaded();
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		world.renderSecondLayer(g);
		world.renderThirdLayer(g);
		world.player.postRender(g);
		for(Entity e : world.getEntityManager().getEntities()){
			if(e instanceof Merchant) {
			((Merchant) e).renderMenu(g);
			}
		}
		world.getEmoteManager().render(g);
		world.getSpeechToastManager().render(g);
		world.getSpeechDialogueManager().render(g);
		
		Text.drawString(g, Integer.toString(handler.getGame().getFPS())+" FPS", (handler.getWidth()) - 38, (handler.getHeight()) - 14, true, Color.WHITE, Assets.font16);
	}

}
