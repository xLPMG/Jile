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
		//return true;
		return false;
	}

}
