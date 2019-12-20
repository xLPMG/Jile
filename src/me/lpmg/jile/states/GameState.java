package me.lpmg.jile.states;

import java.awt.Graphics;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.entities.creatures.Wizard;
import me.lpmg.jile.worlds.World;

public class GameState extends State {
	
	private World world;
	
	public GameState(Handler handler, World world){
		super(handler);
		this.world = world;
		handler.setWorld(world);
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
			if(e instanceof Wizard) {
			((Wizard) e).renderMenu(g);
			}
		}
		world.getEmoteManager().render(g);
		world.getSpeechToastManager().render(g);
	}

}
