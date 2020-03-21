package me.lpmg.jile.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class Tile {

	// STATIC STUFF HERE

	public static Tile[] tiles = new Tile[1024];

//	public static Tile placeHolderSolidTile = new PlaceHolderSolidTile(99);

	public static Tile placeHolderTile = new PlaceHolderTile(1);
	public static Tile blackTile = new PlaceHolderTile(2);
	public static Tile stoneTile = new PlaceHolderTile(2);
	public static Tile pinkTile = new PlaceHolderTile(3);
	public static Tile debugTile = new PlaceHolderTile(Assets.debugTile, 4);
	public static Tile stone_wall_top = new WallTileCover(Assets.stone_wall_top,5);
	
	public static Tile grass_full = new GrassTile(Assets.grass_full,11);
	public static Tile dirt_full = new GrassTile(Assets.dirt_full, 12);
	public static Tile grass_puddle = new GrassTile(Assets.grass_puddle, 13);
	public static Tile empty_14 = new PlaceHolderTile(Assets.empty_14, 14);
	public static Tile stone_wall_bottom = new WallTileSolid(Assets.stone_wall_bottom, 15);
	public static Tile empty_16 = new PlaceHolderTile(Assets.empty_16, 16);
	public static Tile plant_rose = new GrassTile(Assets.plant_rose, 17);
	public static Tile plant_berries = new GrassTile(Assets.plant_berries, 18);
	public static Tile plant_grass_1 = new GrassTile(Assets.plant_grass_1, 19);
	public static Tile plant_grass_2 = new GrassTile(Assets.plant_grass_2, 20);
	public static Tile grass_dirt_SR = new DirtTile(Assets.grass_dirt_SR,21);
	public static Tile grass_dirt_ST = new GrassTile(Assets.grass_dirt_ST, 22);
	public static Tile grass_dirt_CBR = new GrassTile(Assets.grass_dirt_CBR, 23);
	public static Tile grass_dirt_CBL = new GrassTile(Assets.grass_dirt_CBL, 24);
	public static Tile dirt_grass_CTL = new GrassTile(Assets.dirt_grass_CTL, 25);
	public static Tile dirt_grass_CTR = new GrassTile(Assets.dirt_grass_CTR, 26);
	public static Tile plant_flower_1 = new DecorPlantTile(Assets.plant_flower_1, 27);
	public static Tile plant_flower_2 = new DecorPlantTile(Assets.plant_flower_2, 28);
	public static Tile plant_flower_3 = new DecorPlantTile(Assets.plant_flower_3, 29);
	public static Tile plant_flower_4 = new DecorPlantTile(Assets.plant_flower_4, 30);
	public static Tile grass_dirt_SL = new GrassTile(Assets.grass_dirt_SL, 31);
	public static Tile grass_dirt_SB = new GrassTile(Assets.grass_dirt_SB, 32);
	public static Tile grass_dirt_CTR = new GrassTile(Assets.grass_dirt_CTR, 33);
	public static Tile grass_dirt_CTL = new GrassTile(Assets.grass_dirt_CTL, 34);
	public static Tile dirt_grass_CBL = new GrassTile(Assets.dirt_grass_CBL, 35);
	public static Tile dirt_grass_CBR = new GrassTile(Assets.dirt_grass_CBR, 36);
	public static Tile pebble = new GrassTile(Assets.pebble, 37);
	public static Tile rock_small = new SolidTile(Assets.rock_small, 38);
	public static Tile hole = new SolidTile(Assets.hole, 39);
	public static Tile gravestone = new SolidTile(Assets.gravestone, 40);
	public static Tile darkGrass_full = new GrassTile(Assets.darkGrass_full, 41);
	public static Tile darkDirt_full = new GrassTile(Assets.darkDirt_full, 42);
	public static Tile darkGrass_puddle_1 = new GrassTile(Assets.darkGrass_puddle_1, 43);
	public static Tile darkGrass_puddle_2 = new GrassTile(Assets.darkGrass_puddle_2, 44);
	public static Tile darkGrass_puddle_3 = new GrassTile(Assets.darkGrass_puddle_3, 45);
	public static Tile plant_log_stem = new GrassTile(Assets.plant_log_stem, 46);
	public static Tile grass_darkGrass_CTL = new GrassTile(Assets.grass_darkGrass_CTL, 47);
	public static Tile grass_darkGrass_CTR = new GrassTile(Assets.grass_darkGrass_CTR, 48);
	public static Tile grass_darkGrass_CBL = new GrassTile(Assets.grass_darkGrass_CBL, 49);
	public static Tile grass_darkGrass_CBR = new GrassTile(Assets.grass_darkGrass_CBR, 50);
	public static Tile darkGrass_dirt_SR = new GrassTile(Assets.darkGrass_dirt_SR, 51);
	public static Tile darkGrass_dirt_ST = new GrassTile(Assets.darkGrass_dirt_ST, 52);
	public static Tile darkGrass_dirt_CBR = new GrassTile(Assets.darkGrass_dirt_CBR, 53);
	public static Tile darkGrass_dirt_CBL = new GrassTile(Assets.darkGrass_dirt_CBL, 54);
	public static Tile darkDirt_darkGrass_CTL = new GrassTile(Assets.darkDirt_darkGrass_CTL, 55);
	public static Tile darkDirt_darkGrass_CTR = new GrassTile(Assets.darkDirt_darkGrass_CTR, 56);
	public static Tile darkGrass_grass_SR = new GrassTile(Assets.darkGrass_grass_SR, 57);
	public static Tile darkGrass_grass_ST = new GrassTile(Assets.darkGrass_grass_ST, 58);
	public static Tile darkGrass_grass_CBR = new GrassTile(Assets.darkGrass_grass_CBR, 59);
	public static Tile darkGrass_grass_CBL = new GrassTile(Assets.darkGrass_grass_CBL, 60);
	public static Tile darkGrass_darkDirt_SL = new GrassTile(Assets.darkGrass_darkDirt_SL, 61);
	public static Tile darkGrass_darkDirt_SB = new GrassTile(Assets.darkGrass_darkDirt_SB, 62);
	public static Tile darkGrass_darkDirt_CTR = new GrassTile(Assets.darkGrass_darkDirt_CTR, 63);
	public static Tile darkGrass_darkDirt_CTL = new GrassTile(Assets.darkGrass_darkDirt_CTL, 64);
	public static Tile darkDirt_darkGrass_CBL = new GrassTile(Assets.darkDirt_darkGrass_CBL, 65);
	public static Tile darkDirt_darkGrass_CBR = new GrassTile(Assets.darkDirt_darkGrass_CBR, 66);
	public static Tile darkGrass_grass_SL = new GrassTile(Assets.darkGrass_grass_SL, 67);
	public static Tile darkGrass_grass_SB = new GrassTile(Assets.darkGrass_grass_SB, 68);
	public static Tile darkGrass_grass_CTR = new GrassTile(Assets.darkGrass_grass_CTR, 69);
	public static Tile darkGrass_grass_CTL = new GrassTile(Assets.darkGrass_grass_CTL, 70);
	public static Tile leaf_1 = new TreeLeafTile(Assets.leaf_1, 71);
	public static Tile leaf_2 = new TreeLeafTile(Assets.leaf_2, 72);
	public static Tile leaf_3 = new TreeLeafTile(Assets.leaf_3, 73);
	public static Tile leaf_4 = new TreeLeafTile(Assets.leaf_4, 74);
	public static Tile leaf_5 = new TreeLeafTile(Assets.leaf_5, 75);
	public static Tile leaf_6 = new TreeLeafTile(Assets.leaf_6, 76);
	public static Tile tree_1_1 = new TreeHighStemTile(Assets.tree_1_1, 77);
	public static Tile tree_1_2 = new TreeHighStemTile(Assets.tree_1_2, 78);
	public static Tile tree_1_3 = new TreeHighStemTile(Assets.tree_1_3, 79);
	public static Tile tree_1_4 = new TreeHighStemTile(Assets.tree_1_4, 80);
	public static Tile leaf_7 = new TreeLeafTile(Assets.leaf_7, 81);
	public static Tile leaf_8 = new TreeLeafTile(Assets.leaf_8, 82);
	public static Tile leaf_9 = new TreeLeafTile(Assets.leaf_9, 83);
	public static Tile leaf_10 = new TreeLeafTile(Assets.leaf_10, 84);
	public static Tile log_small = new GrassTile(Assets.log_small, 85);
	public static Tile empty_86 = new PlaceHolderTile(Assets.empty_86, 86);
	public static Tile tree_1_5 = new TreeHighStemTile(Assets.tree_1_5, 87);
	public static Tile tree_1_6 = new TreeHighStemTile(Assets.tree_1_6, 88);
	public static Tile tree_1_7 = new TreeHighStemTile(Assets.tree_1_7, 89);
	public static Tile tree_1_8 = new TreeHighStemTile(Assets.tree_1_8, 90);
	public static Tile leaf_11 = new TreeLeafTile(Assets.leaf_11, 91);
	public static Tile leaf_12 = new TreeLeafTile(Assets.leaf_12, 92);
	public static Tile leaf_13 = new TreeLeafTile(Assets.leaf_13, 93);
	public static Tile leaf_14 = new TreeLeafTile(Assets.leaf_14, 94);
	public static Tile empty_95 = new PlaceHolderTile(Assets.empty_95, 95);
	public static Tile tree_1_9 = new TreeHighStemTile(Assets.tree_1_9, 96);
	public static Tile tree_1_10 = new TreeHighStemTile(Assets.tree_1_10, 97);
	public static Tile tree_1_11 = new TreeHighStemTile(Assets.tree_1_11, 98);
	public static Tile tree_1_12 = new TreeHighStemTile(Assets.tree_1_12, 99);
	public static Tile tree_1_13 = new TreeHighStemTile(Assets.tree_1_13, 100);
	public static Tile leaf_15 = new TreeLeafTile(Assets.leaf_15, 101);
	public static Tile leaf_16 = new TreeLeafTile(Assets.leaf_16, 102);
	public static Tile leaf_17 = new TreeLeafTile(Assets.leaf_17, 103);
	public static Tile leaf_18 = new TreeLeafTile(Assets.leaf_18, 104);
	public static Tile leaf_19 = new TreeLeafTile(Assets.leaf_19, 105);
	public static Tile leaf_20 = new TreeLeafTile(Assets.leaf_20, 106);
	public static Tile tree_1_14 = new TreeHighStemTile(Assets.tree_1_14, 107);
	public static Tile tree_1_15 = new TreeHighStemTile(Assets.tree_1_15, 108);
	public static Tile tree_1_16 = new TreeHighStemTile(Assets.tree_1_16, 109);
	public static Tile tree_1_17 = new TreeHighStemTile(Assets.tree_1_17, 110);
	public static Tile leaf_21 = new TreeLeafTile(Assets.leaf_21, 111);
	public static Tile leaf_22 = new TreeLeafTile(Assets.leaf_22, 112);
	public static Tile leaf_23 = new TreeLeafTile(Assets.leaf_23, 113);
	public static Tile leaf_24 = new TreeLeafTile(Assets.leaf_24, 114);
	public static Tile leaf_25 = new TreeLeafTile(Assets.leaf_25, 115);
	public static Tile leaf_26 = new TreeLeafTile(Assets.leaf_26, 116);
	public static Tile empty_117 = new PlaceHolderTile(Assets.empty_117, 117);
	public static Tile empty_118 = new PlaceHolderTile(Assets.empty_118, 118);
	public static Tile tree_1_18 = new TreeHighStemTile(Assets.tree_1_18, 119);
	public static Tile tree_1_19 = new TreeHighStemTile(Assets.tree_1_19, 120);
	public static Tile leaf_27 = new TreeLeafTile(Assets.leaf_27, 121);
	public static Tile leaf_28 = new TreeLeafTile(Assets.leaf_28, 122);
	public static Tile leaf_29 = new TreeLeafTile(Assets.leaf_29, 123);
	public static Tile leaf_30 = new TreeLeafTile(Assets.leaf_30, 124);
	public static Tile leaf_31 = new TreeLeafTile(Assets.leaf_31, 125);
	public static Tile empty_126 = new PlaceHolderTile(Assets.empty_126, 126);
	public static Tile tree_1_20 = new TreeRootTile(Assets.tree_1_20, 127);
	public static Tile tree_1_21 = new TreeRootTile(Assets.tree_1_21, 128);
	public static Tile tree_1_22 = new TreeStemTile(Assets.tree_1_22, 129);
	public static Tile tree_1_23 = new TreeStemTile(Assets.tree_1_23, 130);
	public static Tile leaf_32 = new TreeLeafTile(Assets.leaf_32, 131);
	public static Tile leaf_33 = new TreeLeafTile(Assets.leaf_33, 132);
	public static Tile leaf_34 = new TreeLeafTile(Assets.leaf_34, 133);
	public static Tile leaf_35 = new TreeLeafTile(Assets.leaf_35, 134);
	public static Tile leaf_36 = new TreeLeafTile(Assets.leaf_36, 135);
	public static Tile empty_136 = new PlaceHolderTile(Assets.empty_136, 136);
	public static Tile tree_1_24 = new TreeRootTile(Assets.tree_1_24, 137);
	public static Tile tree_1_25 = new TreeRootTile(Assets.tree_1_25, 138);
	public static Tile tree_1_26 = new TreeRootTile(Assets.tree_1_26, 139);
	public static Tile tree_1_27 = new TreeRootTile(Assets.tree_1_27, 140);
	public static Tile leaf_37 = new TreeLeafTile(Assets.leaf_37, 141);
	public static Tile leaf_38 = new TreeLeafTile(Assets.leaf_38, 142);
	public static Tile leaf_39 = new TreeLeafTile(Assets.leaf_39, 143);
	public static Tile leaf_40 = new TreeLeafTile(Assets.leaf_40, 144);
	public static Tile leaf_41 = new TreeLeafTile(Assets.leaf_41, 145);
	public static Tile empty_146 = new PlaceHolderTile(Assets.empty_146, 146);
	public static Tile empty_147 = new PlaceHolderTile(Assets.empty_147, 147);
	public static Tile empty_148 = new PlaceHolderTile(Assets.empty_148, 148);
	public static Tile tree_2_1 = new TreeHighStemTile(Assets.tree_2_1, 149);
	public static Tile empty_150 = new PlaceHolderTile(Assets.empty_150, 150);
	public static Tile leaf_42 = new TreeLeafTile(Assets.leaf_42, 151);
	public static Tile leaf_43 = new TreeLeafTile(Assets.leaf_43, 152);
	public static Tile leaf_44 = new TreeLeafTile(Assets.leaf_44, 153);
	public static Tile leaf_45 = new TreeLeafTile(Assets.leaf_45, 154);
	public static Tile leaf_46 = new TreeLeafTile(Assets.leaf_46, 155);
	public static Tile empty_156 = new PlaceHolderTile(Assets.empty_156, 156);
	public static Tile empty_157 = new PlaceHolderTile(Assets.empty_157, 157);
	public static Tile empty_158 = new PlaceHolderTile(Assets.empty_158, 158);
	public static Tile tree_2_2 = new TreeHighStemTile(Assets.tree_2_2, 159);
	public static Tile empty_160 = new PlaceHolderTile(Assets.empty_160, 160);
	public static Tile empty_161 = new PlaceHolderTile(Assets.empty_161, 161);
	public static Tile leaf_47 = new TreeLeafTile(Assets.leaf_47, 162);
	public static Tile leaf_48 = new TreeLeafTile(Assets.leaf_48, 163);
	public static Tile leaf_49 = new TreeLeafTile(Assets.leaf_49, 164);
	public static Tile leaf_50 = new TreeLeafTile(Assets.leaf_50, 165);
	public static Tile empty_166 = new PlaceHolderTile(Assets.empty_166, 166);
	public static Tile empty_167 = new PlaceHolderTile(Assets.empty_167, 167);
	public static Tile tree_2_3 = new TreeRootTile(Assets.tree_2_3, 168);
	public static Tile tree_2_4 = new TreeStemTile(Assets.tree_2_4, 169);
	public static Tile tree_2_5 = new TreeHighStemTile(Assets.tree_2_5, 170);
	public static Tile empty_171 = new PlaceHolderTile(Assets.empty_171, 171);
	public static Tile empty_172 = new PlaceHolderTile(Assets.empty_172, 172);
	public static Tile empty_173 = new PlaceHolderTile(Assets.empty_173, 173);
	public static Tile empty_174 = new PlaceHolderTile(Assets.empty_174, 174);
	public static Tile empty_175 = new PlaceHolderTile(Assets.empty_175, 175);
	public static Tile empty_176 = new PlaceHolderTile(Assets.empty_176, 176);
	public static Tile empty_177 = new PlaceHolderTile(Assets.empty_177, 177);
	public static Tile tree_2_6 = new TreeRootTile(Assets.tree_2_6, 178);
	public static Tile tree_2_7 = new TreeRootTile(Assets.tree_2_7, 179);
	public static Tile tree_2_8 = new TreeRootTile(Assets.tree_2_8, 180);
	
	// WHITE FLOORING

//	public static Tile dirt_wall_left_top_high = new WallTileCover(Assets.dirt_wall_left_top_high, 121);
//	public static Tile dirt_wall_middle_top_high = new WallTileCover(Assets.dirt_wall_middle_top_high, 122);
//	public static Tile dirt_wall_right_top_high = new WallTileCover(Assets.dirt_wall_right_top_high, 123);
//
//	public static Tile dirt_wall_left_top_middle = new WallTileSolid(Assets.dirt_wall_left_top_middle, 131);
//	public static Tile dirt_wall_middle_top_middle = new WallTileCover(Assets.dirt_wall_middle_top_middle, 132);
//	public static Tile dirt_wall_right_top_middle = new WallTileSolid(Assets.dirt_wall_right_top_middle, 133);
//
//	public static Tile dirt_wall_left_top_low = new WallTileSolid(Assets.dirt_wall_left_top_low, 141);
//	public static Tile dirt_wall_middle_top_low = new WallTileCover(Assets.dirt_wall_middle_top_low, 142);
//	public static Tile dirt_wall_right_top_low = new WallTileSolid(Assets.dirt_wall_right_top_low, 143);
//	
//	public static Tile dirt_wall_left_body_high = new WallTileSolid(Assets.dirt_wall_left_body_high, 151);
//	public static Tile dirt_wall_middle_body_high = new WallTileSolid(Assets.dirt_wall_middle_body_high, 152);
//	public static Tile dirt_wall_right_body_high = new WallTileSolid(Assets.dirt_wall_right_body_high, 153);
//	
//	public static Tile dirt_wall_left_body_low = new WallTileSolid(Assets.dirt_wall_left_body_low, 161);
//	public static Tile dirt_wall_middle_body_low = new WallTileSolid(Assets.dirt_wall_middle_body_low, 162);
//	public static Tile dirt_wall_right_body_low = new WallTileSolid(Assets.dirt_wall_right_body_low, 163);
//	
//	public static Tile dirt_wall_left_bottom = new WallTileSolid(Assets.dirt_wall_left_bottom, 171);
//	public static Tile dirt_wall_middle_bottom = new WallTileSolid(Assets.dirt_wall_middle_bottom, 172);
//	public static Tile dirt_wall_right_bottom = new WallTileSolid(Assets.dirt_wall_right_bottom, 173);

//	public static Tile fence_hzTile = new FenceTileSolid(Assets.fence_hz, 70);
//	public static Tile fence_vtTile = new FenceTileSolid(Assets.fence_vt, 71);
//	public static Tile fence_hLTile = new FenceTileSolid(Assets.fence_hL, 72);
//	public static Tile fence_hRTile = new FenceTileSolid(Assets.fence_hR, 73);
//	public static Tile fence_CBLTile = new FenceTileSolid(Assets.fence_CBL, 74);
//	public static Tile fence_CBRTile = new FenceTileSolid(Assets.fence_CBR, 75);
//	public static Tile fence_CTLTile = new FenceTileSolid(Assets.fence_CTL, 76);
//	public static Tile fence_CTRTile = new FenceTileSolid(Assets.fence_CTR, 77);
//
//	public static Tile sign1Tile = new SignTileSolid(Assets.fence_CTR, 78);
//	public static Tile sign2Tile = new SignTileSolid(Assets.fence_CTR, 79);
//
//	public static Tile hedge_hzBTile = new HedgeTileSolid(Assets.hedge_hzB, 80);
//	public static Tile hedge_hzTTile = new HedgeTileSolid(Assets.hedge_hzT, 81);
//	public static Tile hedge_vtLTile = new HedgeTileSolid(Assets.hedge_vtL, 82);
//	public static Tile hedge_vtRile = new HedgeTileSolid(Assets.hedge_vtR, 83);
//	public static Tile hedge_CBLTile = new HedgeTileSolid(Assets.hedge_CBL, 84);
//	public static Tile hedge_CBRTile = new HedgeTileSolid(Assets.hedge_CBR, 85);
//	public static Tile hedge_CTLTile = new HedgeTileSolid(Assets.hedge_CTL, 86);
//	public static Tile hedge_CTRTile = new HedgeTileSolid(Assets.hedge_CTR, 87);
//	public static Tile hedge_plainTile = new HedgeTileSolid(Assets.hedge_plain, 88);
//	public static Tile hedge_plainCBLTile = new HedgeTileSolid(Assets.hedge_plainCBL, 89);
//	public static Tile hedge_plainCBRTile = new HedgeTileSolid(Assets.hedge_plainCBR, 90);
//	public static Tile hedge_plainCTLTile = new HedgeTileSolid(Assets.hedge_plainCTL, 91);
//	public static Tile hedge_plainCTRTile = new HedgeTileSolid(Assets.hedge_plainCTR, 92);

	public static Tile wall_Tile_Bottom = new WallTileSolid(Assets.wooden_wall_1, 500);
	public static Tile wall_Tile_Middle = new WallTileSolid(Assets.wooden_wall_1, 501);

	public static Tile floor_Tile = new FloorTile(Assets.floor_1, 510);
	
	public static Tile roomMarginLeftTile = new RoomMarginTile(Assets.room_margin_left, 520);
	public static Tile roomMarginRightTile = new RoomMarginTile(Assets.room_margin_right, 521);
	public static Tile roomMarginBottomTile = new RoomMarginTile(Assets.room_margin_bottom, 522);
	public static Tile roomMarginTopTile = new RoomMarginTile(Assets.room_margin_top, 523);
	public static Tile roomMarginCTLTile = new RoomMarginTile(Assets.room_margin_ctl, 524);
	public static Tile roomMarginCTRTile = new RoomMarginTile(Assets.room_margin_ctr, 525);
	public static Tile roomMarginCBLTile = new RoomMarginTile(Assets.room_margin_cbl, 526);
	public static Tile roomMarginCBRTile = new RoomMarginTile(Assets.room_margin_cbr, 527);
	public static Tile roomMarginBottomEndLeftTile = new RoomMarginTile(Assets.room_margin_bottom_end_left, 528);
	public static Tile roomMarginBottomEndRightTile = new RoomMarginTile(Assets.room_margin_bottom_end_right, 529);
//	
//	public static Tile treeForest1_TR = new WallTileCover(Assets.treeForest1_TR, 130);
//	public static Tile treeForest1_TL = new WallTileCover(Assets.treeForest1_TL, 131);
//	public static Tile treeForest1_ML = new WallTileSolid(Assets.treeForest1_ML, 132);
//	public static Tile treeForest1_MR = new WallTileSolid(Assets.treeForest1_MR, 133);
//	public static Tile treeForest1_BL = new WallTileSolid(Assets.treeForest1_BL, 134);
//	public static Tile treeForest1_BR = new WallTileSolid(Assets.treeForest1_BR, 135);
//	
//	public static Tile treeForest1_STL = new WallTileSolid(Assets.treeForest1_STL, 136);
//	public static Tile treeForest1_STR = new WallTileCover(Assets.treeForest1_STR, 137);
//	public static Tile treeForest1_SML = new WallTileSolid(Assets.treeForest1_SML, 138);
//	public static Tile treeForest1_SMR = new WallTileSolid(Assets.treeForest1_SMR, 139);
//	public static Tile treeForest1_SBL = new WallTileSolid(Assets.treeForest1_SBL, 140);
//	public static Tile treeForest1_SBR = new WallTileSolid(Assets.treeForest1_SBR, 141);
//	
//	public static Tile treeForest1_TR_Solid = new WallTileSolid(Assets.treeForest1_TR, 142);
	// CLASS

	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	public static final int TILE_BOUND_WIDTH = 4, TILE_BOUND_HEIGHT = 4;
	public static final int[] ALL_TILES = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;

		tiles[id] = this;
	}

	public void tick() {

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public boolean isSolid() {
		return false;
	}

	public boolean isSolidAt(int boundTileId) {
		return false;
	}

	public int getId() {
		return id;
	}

}
