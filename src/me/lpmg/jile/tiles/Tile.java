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
	public static Tile dirtTile = new DirtTile(2);
	public static Tile rockTile = new RockTile(3);
	public static Tile stoneTile = new StoneTile(4);

	public static Tile grassTileDirtBottom = new GrassTile(Assets.grass_dirtBottom, 11);
	public static Tile grassTileDirtTop = new GrassTile(Assets.grass_dirtTop, 12);
	public static Tile grassTileDirtLeft = new GrassTile(Assets.grass_dirtLeft, 13);
	public static Tile grassTileDirtRight = new GrassTile(Assets.grass_dirtRight, 14);
	public static Tile grassTileDirtCBL = new GrassTile(Assets.grass_dirtCBL, 15);
	public static Tile grassTileDirtCBR = new GrassTile(Assets.grass_dirtCBR, 16);
	public static Tile grassTileDirtCTL = new GrassTile(Assets.grass_dirtCTL, 17);
	public static Tile grassTileDirtCTR = new GrassTile(Assets.grass_dirtCTR, 18);
	public static Tile grassTileRamp = new GrassTile(Assets.grass_ramp, 19);

	public static Tile pebbleTile = new RockTile(Assets.pebble, 31);
	
	public static Tile dirtWallLeftShadowTile = new WallTileCover(Assets.dirt_wall_left_shadow, 40);
	public static Tile dirtWallLeftBottomTile = new WallTileSolid(Assets.dirt_wall_left_bottom, 41);
	public static Tile dirtWallLeftBodyLowTile = new WallTileSolid(Assets.dirt_wall_left_body_low, 42);
	public static Tile dirtWallLeftBodyHighTile = new WallTileSolid(Assets.dirt_wall_left_body_high, 43);
	public static Tile dirtWallLeftTopLowTile = new WallTileSolid(Assets.dirt_wall_left_top_low, 44);
	public static Tile dirtWallLeftTopMiddleTile = new WallTileSolid(Assets.dirt_wall_left_top_middle, 45);
	public static Tile dirtWallLeftTopHighTile = new WallTileCover(Assets.dirt_wall_left_top_high, 46);
	
	public static Tile dirtWallMiddleShadowTile = new WallTileCover(Assets.dirt_wall_middle_shadow, 50);
	public static Tile dirtWallMiddleBottomTile = new WallTileSolid(Assets.dirt_wall_middle_bottom, 51);
	public static Tile dirtWallMiddleBodyLowTile = new WallTileSolid(Assets.dirt_wall_middle_body_low, 52);
	public static Tile dirtWallMiddleBodyHighTile = new WallTileSolid(Assets.dirt_wall_middle_body_high, 53);
	public static Tile dirtWallMiddleTopLowTile = new WallTileSolid(Assets.dirt_wall_middle_top_low, 54);
	public static Tile dirtWallMiddleTopMiddleTile = new WallTileCover(Assets.dirt_wall_middle_top_middle, 55);
	public static Tile dirtWallMiddleTopHighTile = new WallTileCover(Assets.dirt_wall_middle_top_high, 56);
	
	public static Tile dirtWallRightShadowTile = new WallTileCover(Assets.dirt_wall_right_shadow, 60);
	public static Tile dirtWallRightBottomTile = new WallTileSolid(Assets.dirt_wall_right_bottom, 61);
	public static Tile dirtWallRightBodyLowTile = new WallTileSolid(Assets.dirt_wall_right_body_low, 62);
	public static Tile dirtWallRightBodyHighTile = new WallTileSolid(Assets.dirt_wall_right_body_high, 63);
	public static Tile dirtWallRightTopLowTile = new WallTileSolid(Assets.dirt_wall_right_top_low, 64);
	public static Tile dirtWallRightTopMiddleTile = new WallTileSolid(Assets.dirt_wall_right_top_middle, 65);
	public static Tile dirtWallRightTopHighTile = new WallTileCover(Assets.dirt_wall_right_top_high, 66);
	
	public static Tile fence_hzTile = new FenceTileSolid(Assets.fence_hz, 70);
	public static Tile fence_vtTile = new FenceTileSolid(Assets.fence_vt, 71);
	public static Tile fence_hLTile = new FenceTileSolid(Assets.fence_hL, 72);
	public static Tile fence_hRTile = new FenceTileSolid(Assets.fence_hR, 73);
	public static Tile fence_CBLTile = new FenceTileSolid(Assets.fence_CBL, 74);
	public static Tile fence_CBRTile = new FenceTileSolid(Assets.fence_CBR, 75);
	public static Tile fence_CTLTile = new FenceTileSolid(Assets.fence_CTL, 76);
	public static Tile fence_CTRTile = new FenceTileSolid(Assets.fence_CTR, 77);
	
	public static Tile hedge_hzBTile = new HedgeTileSolid(Assets.hedge_hzB, 80);
	public static Tile hedge_hzTTile = new HedgeTileSolid(Assets.hedge_hzT, 81);
	public static Tile hedge_vtLTile = new HedgeTileSolid(Assets.hedge_vtL, 82);
	public static Tile hedge_vtRile = new HedgeTileSolid(Assets.hedge_vtR, 83);
	public static Tile hedge_CBLTile = new HedgeTileSolid(Assets.hedge_CBL, 84);
	public static Tile hedge_CBRTile = new HedgeTileSolid(Assets.hedge_CBR, 85);
	public static Tile hedge_CTLTile = new HedgeTileSolid(Assets.hedge_CTL, 86);
	public static Tile hedge_CTRTile = new HedgeTileSolid(Assets.hedge_CTR, 87);
	public static Tile hedge_plainTile = new HedgeTileSolid(Assets.hedge_plain, 88);
	public static Tile hedge_plainCBLTile = new HedgeTileSolid(Assets.hedge_plainCBL, 89);
	public static Tile hedge_plainCBRTile = new HedgeTileSolid(Assets.hedge_plainCBR, 90);
	public static Tile hedge_plainCTLTile = new HedgeTileSolid(Assets.hedge_plainCTL, 91);
	public static Tile hedge_plainCTRTile = new HedgeTileSolid(Assets.hedge_plainCTR, 92);
	
	public static Tile wall_Tile_Bottom = new WallTileSolid(Assets.wooden_wall_1, 100);
	public static Tile wall_Tile_Middle = new WallTileSolid(Assets.wooden_wall_1, 101);
	
	public static Tile floor_Tile = new FloorTile(Assets.floor_1, 110);
	
	public static Tile roomMarginLeftTile = new RoomMarginTile(Assets.room_margin_left, 120);
	public static Tile roomMarginRightTile = new RoomMarginTile(Assets.room_margin_right, 121);
	public static Tile roomMarginBottomTile = new RoomMarginTile(Assets.room_margin_bottom, 122);
	public static Tile roomMarginTopTile = new RoomMarginTile(Assets.room_margin_top, 123);
	public static Tile roomMarginCTLTile = new RoomMarginTile(Assets.room_margin_ctl, 124);
	public static Tile roomMarginCTRTile = new RoomMarginTile(Assets.room_margin_ctr, 125);
	public static Tile roomMarginCBLTile = new RoomMarginTile(Assets.room_margin_cbl, 126);
	public static Tile roomMarginCBRTile = new RoomMarginTile(Assets.room_margin_cbr, 127);
	public static Tile roomMarginBottomEndLeftTile = new RoomMarginTile(Assets.room_margin_bottom_end_left, 128);
	public static Tile roomMarginBottomEndRightTile = new RoomMarginTile(Assets.room_margin_bottom_end_right, 129);
	
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
