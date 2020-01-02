package me.lpmg.jile;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import me.lpmg.jile.display.Display;
import me.lpmg.jile.gfx.GameCamera;
import me.lpmg.jile.input.KeyManager;
import me.lpmg.jile.input.MouseManager;
import me.lpmg.jile.worlds.World;

public class Handler {
	
	private Game game;
	private Display display;
	private World world;
	
	public Handler(Game game, Display display){
		this.game = game;
		this.display=display;
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public String getVersion() {
		return game.getVersion();
	}
	
	public void addMouseListener(MouseListener mouseListener) {
		display.getFrame().addMouseListener(mouseListener);
		display.getCanvas().addMouseListener(mouseListener);
	}
	public void addMouseMotionListener(MouseMotionListener mouseMotionListener) {
		display.getFrame().addMouseMotionListener(mouseMotionListener);
		display.getCanvas().addMouseMotionListener(mouseMotionListener);
	}
	public void addKeyListener(KeyListener keyListener) {
		display.getFrame().addKeyListener(keyListener);
	}

}
