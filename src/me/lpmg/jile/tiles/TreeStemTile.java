package me.lpmg.jile.tiles;

import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class TreeStemTile extends Tile {

//	public TreeStemTile(int id) {
//		super(Assets.tree, id);
//	}
	
	public TreeStemTile(BufferedImage image, int id) {
		super(image, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
}
