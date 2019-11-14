package me.lpmg.jile.tiles;

import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class RoomMarginTile extends Tile {

	public RoomMarginTile(int id) {
		super(Assets.room_margin_left, id);
	}

	public RoomMarginTile(BufferedImage image, int id) {
		super(image, id);
	}
	@Override
	public boolean isSolid(){
		return true;
	}

}
