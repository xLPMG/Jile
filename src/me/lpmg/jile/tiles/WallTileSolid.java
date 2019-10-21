package me.lpmg.jile.tiles;

import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class WallTileSolid extends Tile{

	public WallTileSolid(int id) {
		super(Assets.stone, id);
	}
	
		public WallTileSolid(BufferedImage image, int id) {
			super(image, id);
		}
		
		@Override
		public boolean isSolid(){
			return true;
		}

	}
