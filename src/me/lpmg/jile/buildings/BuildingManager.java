package me.lpmg.jile.buildings;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.creatures.Player;

public class BuildingManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Building> buildings;
	private Comparator<Building> renderSorter = new Comparator<Building>(){
		@Override
		public int compare(Building a, Building b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
	};
	
	public BuildingManager(Handler handler, Player player){
		this.handler = handler;
		this.player = player;
		buildings = new ArrayList<Building>();
	}
	
	public void tick(){
		Iterator<Building> it = buildings.iterator();
		while(it.hasNext()){
			Building b = it.next();
			b.tick();
		}
		buildings.sort(renderSorter);
	}
	
	public void render(Graphics g){
		for(Building b : buildings){
			b.render(g);
		}
	}
	public void renderOverlay(Graphics g){
		for(Building b : buildings){
			b.renderOverlay(g);
		}
	}
	
	public void addBuilding(Building b){
		buildings.add(b);
		b.setIndex(buildings.indexOf(b));
	}
	
	//GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(ArrayList<Building> buildings) {
		this.buildings = buildings;
	}

}
