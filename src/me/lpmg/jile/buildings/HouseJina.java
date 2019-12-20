package me.lpmg.jile.buildings;

import java.awt.Graphics;
import java.util.Map;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.Entity;
import me.lpmg.jile.entities.creatures.Jina;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.worlds.HermitHutMap;
import me.lpmg.jile.worlds.HouseJinaMap;

public class HouseJina extends Building {

	private HouseJinaMap hJM;
	private boolean initialized = false;
	
	public HouseJina(Handler handler, float x, float y) {
		super(handler, x, y, 256, 384, 90, 290, 30, 40, 4, 6);
		bounds.x = 25;
		bounds.y = 192;
		bounds.width = 205;
		bounds.height = 165;
	}

	@Override
	public void onEnter() {
		Map<String, String> eventData = handler.getGame().getEventData();
		if(!initialized) {
		hJM = new HouseJinaMap(handler, "/worlds/buildings/house_jina.txt","/worlds/buildings/house_jina-secondLayer.txt", this, getIndex());
		hJM.setFlooring(getRandomFlooring(3));
		hJM.setWallMiddle(getWallMiddle(2));
		hJM.setWallBottom(getWallBottom(2));
		map = hJM;
		System.out.println("map creation");
		initialized=true;
		hJM.spawnPlayer();
		
		if(eventData.containsKey("encounteredJina")) {
			if(eventData.get("encounteredJina").equalsIgnoreCase("false")) {	
				Entity jina = new Jina(handler, hJM.getSpawnX(),hJM.getSpawnY()-225);
				handler.getWorld().getEntityManager().addEntity(jina);
				((Jina)jina).firstEncounter();
			}
		}
		}
		entered=true;

	}
	
	@Override
	public void render(Graphics g) {
		if(!entered) {
		g.drawImage(Assets.house_jina, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else {
			hJM.render(g);
		}
		
	}
	
	@Override
	public void renderSecondLayer(Graphics g) {
		if(entered) {
		hJM.renderSecondLayer(g);
		}
	}

	@Override
	public void renderOverlay(Graphics g) {
		//overlay = Assets.hermit_hut.getSubimage(0, 0, 80, 30);
		overlay = Assets.house_jina.getSubimage(0, 0, 80, 100);
		
		//g.drawImage(overlay, (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), 256, 96, null);
		g.drawImage(overlay, (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), 256, 320, null);
		
	}

	@Override
	public void checker() {
		if(initialized) {
		hJM.checkExit();
		}
	}
}
