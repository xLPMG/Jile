package me.lpmg.jile.entities.statics;

import java.awt.Graphics;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.items.Item;
import me.lpmg.jile.tiles.Tile;

public class Rock extends StaticEntity {

	public Rock(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		maxHealth = 50;
		health = 50;
		
		bounds.x = 0;
		bounds.y = 12;
		bounds.width = width-10;
		bounds.height = 50;
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die(){
		handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		if(health>(maxHealth/4)*3) {
		g.drawImage(Assets.rock, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else if(health>(maxHealth/4)*2) {
		g.drawImage(Assets.rock_dmg1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else if(health>(maxHealth/4)*1) {
		g.drawImage(Assets.rock_dmg2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else if(health>(maxHealth/4)*0) {
		g.drawImage(Assets.rock_dmg3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}
	}

}
