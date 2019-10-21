package me.lpmg.jile.states;

import java.awt.Graphics;

import me.lpmg.jile.Handler;
import me.lpmg.jile.worlds.World;

public class GameState extends State {
	
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "jileresources/worlds/world1-firstLayer.txt", "jileresources/worlds/world1-secondLayer.txt", "jileresources/worlds/world1-thirdLayer.txt");
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
	}

}
