package me.lpmg.jile.entities.statics;

import java.awt.Graphics;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.items.Item;
import me.lpmg.jile.tiles.Tile;

public class Bush extends StaticEntity {

	public Bush(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		maxHealth = 50;
		health = 50;
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die(){
		handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		if(health>(maxHealth/4)*3) {
			g.drawImage(Assets.bush, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}else if(health>(maxHealth/4)*2) {
			g.drawImage(Assets.bush_dmg1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}else if(health>(maxHealth/4)*1) {
			g.drawImage(Assets.bush_dmg2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}else if(health>(maxHealth/4)*0) {
			g.drawImage(Assets.bush_dmg3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			}
	}

}
