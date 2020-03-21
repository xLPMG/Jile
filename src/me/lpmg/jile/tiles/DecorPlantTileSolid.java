package me.lpmg.jile.tiles;

import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class DecorPlantTileSolid extends Tile {

	public DecorPlantTileSolid(int id) {
		super(Assets.plant_flower_1, id);
	}
	
	public DecorPlantTileSolid(BufferedImage image, int id) {
		super(image, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}