package me.lpmg.jile.tiles;

import me.lpmg.jile.gfx.Assets;

public class PlaceHolderSolidTile extends Tile {

	public PlaceHolderSolidTile(int id) {
		super(Assets.placeholder, id);
	}

	@Override
	public boolean isSolid(){
		return true;
	}
}
