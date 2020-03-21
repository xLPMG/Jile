package me.lpmg.jile.tiles;

import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class StoneTile extends Tile {

	public StoneTile(int id) {
		super(Assets.dirt_full, id);
	}

	public StoneTile(BufferedImage image, int id) {
		super(image, id);
	}

}
