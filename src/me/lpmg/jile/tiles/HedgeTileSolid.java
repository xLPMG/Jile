package me.lpmg.jile.tiles;

import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class HedgeTileSolid extends Tile{

	public HedgeTileSolid(int id) {
		super(Assets.fence_hz, id);
	}
	
		public HedgeTileSolid(BufferedImage image, int id) {
			super(image, id);
		}
		
		@Override
		public boolean isSolid(){
			return true;
		}

	}
