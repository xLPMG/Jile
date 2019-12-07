package me.lpmg.jile.tiles;

import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class SignTileSolid extends Tile{
	
	public SignTileSolid(int id) {
		super(Assets.fence_hz, id);
	}
	
		public SignTileSolid(BufferedImage image, int id) {
			super(image, id);
		}
		
		@Override
		public boolean isSolid(){
			return true;
		}	

	}
