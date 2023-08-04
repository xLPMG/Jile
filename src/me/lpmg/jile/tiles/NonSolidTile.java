package me.lpmg.jile.tiles;

import java.awt.image.BufferedImage;

public class NonSolidTile extends Tile{
		
		public NonSolidTile(BufferedImage image, int id) {
			super(image, id);
		}
		
		@Override
		public boolean isSolid(){
			return false;
		}	

	}
