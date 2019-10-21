package me.lpmg.jile.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class Tile {
	
	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[256];
	
	public static Tile placeHolderTile = new PlaceHolderTile(0);
	public static Tile debugTile = new PlaceHolderTile(98, Assets.debug);
	public static Tile placeHolderSolidTile = new PlaceHolderSolidTile(99);
	
	public static Tile grassTile = new GrassTile(1);

	public static Tile grassTileDirtBottom = new GrassTile(Assets.grass_dirtBottom, 11);
	public static Tile grassTileDirtTop = new GrassTile(Assets.grass_dirtTop, 12);
	public static Tile grassTileDirtLeft = new GrassTile(Assets.grass_dirtLeft, 13);
	public static Tile grassTileDirtRight = new GrassTile(Assets.grass_dirtRight, 14);

	public static Tile dirtTile = new DirtTile(2);
	public static Tile rockTile = new RockTile(3);
	public static Tile pebbleTile = new RockTile(Assets.pebble, 31);
	
	public static Tile wallLeftShadowTile = new WallTileCover(Assets.wall_left_shadow, 40);
	public static Tile wallLeftBottomTile = new WallTileSolid(Assets.wall_left_bottom, 41);
	public static Tile wallLeftBodyLowTile = new WallTileSolid(Assets.wall_left_body_low, 42);
	public static Tile wallLeftBodyHighTile = new WallTileSolid(Assets.wall_left_body_high, 43);
	public static Tile wallLeftTopLowTile = new WallTileSolid(Assets.wall_left_top_low, 44);
	public static Tile wallLeftTopMiddleTile = new WallTileSolid(Assets.wall_left_top_middle, 45);
	public static Tile wallLeftTopHighTile = new WallTileSolid(Assets.wall_left_top_high, 46);
	
	public static Tile wallMiddleShadowTile = new WallTileCover(Assets.wall_middle_shadow, 50);
	public static Tile wallMiddleBottomTile = new WallTileSolid(Assets.wall_middle_bottom, 51);
	public static Tile wallMiddleBodyLowTile = new WallTileSolid(Assets.wall_middle_body_low, 52);
	public static Tile wallMiddleBodyHighTile = new WallTileSolid(Assets.wall_middle_body_high, 53);
	public static Tile wallMiddleTopLowTile = new WallTileSolid(Assets.wall_middle_top_low, 54);
	public static Tile wallMiddleTopMiddleTile = new WallTileSolid(Assets.wall_middle_top_middle, 55);
	public static Tile wallMiddleTopHighTile = new WallTileSolid(Assets.wall_middle_top_high, 56);
	
	public static Tile wallRightShadowTile = new WallTileCover(Assets.wall_right_shadow, 60);
	public static Tile wallRightBottomTile = new WallTileSolid(Assets.wall_right_bottom, 61);
	public static Tile wallRightBodyLowTile = new WallTileSolid(Assets.wall_right_body_low, 62);
	public static Tile wallRightBodyHighTile = new WallTileSolid(Assets.wall_right_body_high, 63);
	public static Tile wallRightTopLowTile = new WallTileSolid(Assets.wall_right_top_low, 64);
	public static Tile wallRightTopMiddleTile = new WallTileSolid(Assets.wall_right_top_middle, 65);
	public static Tile wallRightTopHighTile = new WallTileSolid(Assets.wall_right_top_high, 66);
	
	//CLASS
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	public static final int TILE_BOUND_WIDTH = 4, TILE_BOUND_HEIGHT = 4;
	public static final int[] ALL_TILES = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	public boolean isSolid(){
		return false;
	}
	
	public boolean isSolidAt(int boundTileId){
		return false;
	}
	
	public int getId(){
		return id;
	}
	
}
