package me.lpmg.jile.tiles;

import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class FloorTile extends Tile {

	public FloorTile(int id) {
		super(Assets.floor_1, id);
	}

	public FloorTile(BufferedImage image, int id) {
		super(image, id);
	}

}
