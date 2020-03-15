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
	public static Tile stoneTile = new StoneTile(3);
	public static Tile bushTile = new PlaceHolderTile(4);
	public static Tile rockTile = new PlaceHolderTile(5);

	public static Tile grassTileDirtBottom = new GrassTile(Assets.grass_dirtBottom, 11);
	public static Tile grassTileDirtTop = new GrassTile(Assets.grass_dirtTop, 12);
	public static Tile grassTileDirtLeft = new GrassTile(Assets.grass_dirtLeft, 13);
	public static Tile grassTileDirtRight = new GrassTile(Assets.grass_dirtRight, 14);
	public static Tile grassTileDirtCBL = new GrassTile(Assets.grass_dirtCBL, 15);
	public static Tile grassTileDirtCBR = new GrassTile(Assets.grass_dirtCBR, 16);
	public static Tile grassTileDirtCTL = new GrassTile(Assets.grass_dirtCTL, 17);
	public static Tile grassTileDirtCTR = new GrassTile(Assets.grass_dirtCTR, 18);
	public static Tile grassTileRamp = new GrassTile(Assets.grass_ramp, 19);
	public static Tile grassTileRampShadowless = new GrassTile(Assets.grass_ramp_shadowless, 20);
	public static Tile grassTileRampShadowHalf = new GrassTile(Assets.grass_ramp_shadowHalf, 21);

	public static Tile dirtTileGrassCTR = new GrassTile(Assets.dirt_grassCTR, 22);
	public static Tile dirtTileGrassCBL = new GrassTile(Assets.dirt_grassCBL, 23);
	public static Tile dirtTileGrassCBR = new GrassTile(Assets.dirt_grassCBR, 24);
	public static Tile dirtTileGrassCTL = new GrassTile(Assets.dirt_grassCTL, 25);
	
	public static Tile pebbleTile = new StoneTile(Assets.pebble, 31);
	public static Tile plant1Tile = new DecorPlantTile(Assets.plant1, 32);
	public static Tile plant2Tile = new DecorPlantTileSolid(Assets.plant2, 33);
	public static Tile plant3Tile = new DecorPlantTile(Assets.plant3, 34);
	public static Tile plant4Tile = new DecorPlantTile(Assets.plant4, 35);
	public static Tile tallGrassTileTop = new TallGrassTile(Assets.tall_grass_top, 36);
	public static Tile tallGrassTileBottom = new TallGrassTile(Assets.tall_grass_bottom, 37);
	
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
	
	public static Tile sign1Tile = new SignTileSolid(Assets.fence_CTR, 78);
	public static Tile sign2Tile = new SignTileSolid(Assets.fence_CTR, 79);
	
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
	
	public static Tile treeForest1_TR = new WallTileCover(Assets.treeForest1_TR, 130);
	public static Tile treeForest1_TL = new WallTileCover(Assets.treeForest1_TL, 131);
	public static Tile treeForest1_ML = new WallTileSolid(Assets.treeForest1_ML, 132);
	public static Tile treeForest1_MR = new WallTileSolid(Assets.treeForest1_MR, 133);
	public static Tile treeForest1_BL = new WallTileSolid(Assets.treeForest1_BL, 134);
	public static Tile treeForest1_BR = new WallTileSolid(Assets.treeForest1_BR, 135);
	
	public static Tile treeForest1_STL = new WallTileSolid(Assets.treeForest1_STL, 136);
	public static Tile treeForest1_STR = new WallTileCover(Assets.treeForest1_STR, 137);
	public static Tile treeForest1_SML = new WallTileSolid(Assets.treeForest1_SML, 138);
	public static Tile treeForest1_SMR = new WallTileSolid(Assets.treeForest1_SMR, 139);
	public static Tile treeForest1_SBL = new WallTileSolid(Assets.treeForest1_SBL, 140);
	public static Tile treeForest1_SBR = new WallTileSolid(Assets.treeForest1_SBR, 141);
	
	public static Tile treeForest1_TR_Solid = new WallTileSolid(Assets.treeForest1_TR, 142);
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
