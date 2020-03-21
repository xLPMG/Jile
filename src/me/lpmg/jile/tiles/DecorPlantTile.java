package me.lpmg.jile.tiles;

import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class DecorPlantTile extends Tile {

	public DecorPlantTile(int id) {
		super(Assets.plant_flower_1, id);
	}
	
	public DecorPlantTile(BufferedImage image, int id) {
		super(image, id);
	}
	
	@Override
	public boolean isSolid(){
		return false;
	}

}