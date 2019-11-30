package me.lpmg.jile.buildings;

import java.awt.Graphics;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.worlds.HermitHutMap;

public class HermitHut extends Building {

	private HermitHutMap hHM;
	private boolean initialized = false;
	
	public HermitHut(Handler handler, float x, float y) {
		super(handler, x, y, 256, 256, 90, 180, 30, 40, 5, 3);
		bounds.x = 25;
		bounds.y = 64;
		bounds.width = 205;
		bounds.height = 182;
	}

	@Override
	public void onEnter() {
		if(!initialized) {
		hHM = new HermitHutMap(handler, "/worlds/buildings/hermit-hut.txt","/worlds/buildings/hermit-hut-secondLayer.txt", this, getIndex());
		int floorID = (int) (Math.random() * 18) + 1;
		hHM.setFlooring(getRandomFlooring(floorID));
		int wallID = (int) (Math.random() * 3) + 1;
		hHM.setWallMiddle(getWallMiddle(wallID));
		hHM.setWallBottom(getWallBottom(wallID));
		map = hHM;
		System.out.println("map creation");
		initialized=true;
		}
		entered=true;
		hHM.spawnPlayer();
	}
	
	@Override
	public void render(Graphics g) {
		if(!entered) {
		g.drawImage(Assets.hermit_hut, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else {
			hHM.render(g);
		}
		
	}
	
	@Override
	public void renderSecondLayer(Graphics g) {
		if(entered) {
		hHM.renderSecondLayer(g);
		}
	}

	@Override
	public void renderOverlay(Graphics g) {
		//overlay = Assets.hermit_hut.getSubimage(0, 0, 80, 30);
		overlay = Assets.hermit_hut.getSubimage(0, 0, 80, 50);
		
		//g.drawImage(overlay, (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), 256, 96, null);
		g.drawImage(overlay, (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), 256, 160, null);
		
	}

	@Override
	public void checker() {
		if(initialized) {
		hHM.checkExit();
		}
	}
}
