package me.lpmg.jile.tiles;

import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class GrassTile extends Tile {

	public GrassTile(int id) {
		super(Assets.grass_full, id);
	}

	public GrassTile(BufferedImage image, int id) {
		super(image, id);
	}

}
