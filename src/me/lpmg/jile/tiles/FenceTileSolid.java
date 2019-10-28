package me.lpmg.jile.tiles;

import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class FenceTileSolid extends Tile{

	public FenceTileSolid(int id) {
		super(Assets.fence_hz, id);
	}
	
		public FenceTileSolid(BufferedImage image, int id) {
			super(image, id);
		}
		
		@Override
		public boolean isSolid(){
			return true;
		}

	}
