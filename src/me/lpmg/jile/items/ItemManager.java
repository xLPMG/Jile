package me.lpmg.jile.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import me.lpmg.jile.Handler;

public class ItemManager {
	
	private Handler handler;
	private ArrayList<Item> items;
	
	public ItemManager(Handler handler){
		this.handler = handler;
		items = new ArrayList<Item>();
	}
	
	public void tick(){
		Iterator<Item> it = items.iterator();
		while(it.hasNext()){
			Item i = it.next();
			i.tick();
			if(i.isPickedUp())
				it.remove();
		}
	}
	
	public void render(Graphics g){
		for(Item i : items)
			i.render(g);
	}
	
	public void addItem(Item i){
		i.setHandler(handler);
		items.add(i);
	}
	
	public Item getItemByID(int id) {
		if(id==0) {
			return Item.woodItem;
		}else if(id==1) {
			return Item.rockItem;
		}else if(id==11) {
			return Item.swordNormal;
		}else if(id==12) {
			return Item.swordCommon;
		}
		return null;
	}
	
	// Getters and Setters

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

}
