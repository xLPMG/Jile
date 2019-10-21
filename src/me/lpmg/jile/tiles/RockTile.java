package me.lpmg.jile.tiles;

import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.stone, id);
	}
	
	public RockTile(BufferedImage image, int id) {
		super(image, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
	@Override
	public boolean isSolidAt(int boundTileId){
		if(boundTileId==5|boundTileId==6|boundTileId==9|boundTileId==10) {
			System.out.println("SOLID at "+boundTileId);
			return true;
		}
		return false;
	}

}
