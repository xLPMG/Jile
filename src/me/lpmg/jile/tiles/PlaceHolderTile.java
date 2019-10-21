package me.lpmg.jile.tiles;

import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class PlaceHolderTile extends Tile {

	public PlaceHolderTile(int id) {
		super(Assets.placeholder, id);
	}
	public PlaceHolderTile(int id, BufferedImage image) {
		super(image, id);
	}

}
