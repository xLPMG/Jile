package me.lpmg.jile.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class Tile {

	// STATIC STUFF HERE

	public static Tile[] tiles = new Tile[2048];

//	public static Tile placeHolderSolidTile = new PlaceHolderSolidTile(99);

	public static Tile placeHolderTile = new PlaceHolderTile(0);
	public static Tile placeHolderTileSolid = new PlaceHolderTile(1);
	public static Tile blackTile = new PlaceHolderTile(Assets.blackTile, 2);
	public static Tile pinkTile = new PlaceHolderTile(Assets.pinkTile, 3);

	public static Tile wall_topend_corner_TL = new WallTileCover(Assets.wall_topend_corner_TL, 6);
	public static Tile wall_topend_hz_T_1 = new WallTileCover(Assets.wall_topend_hz_T_1, 7);
	public static Tile wall_topend_hz_T_2 = new WallTileCover(Assets.wall_topend_hz_T_2, 8);
	public static Tile wall_topend_edge_BR = new WallTileSolid(Assets.wall_topend_edge_BR, 9);
	public static Tile wall_topend_edge_BL = new WallTileSolid(Assets.wall_topend_edge_BL, 12);
	public static Tile wall_topend_hz_T_3 = new WallTileCover(Assets.wall_topend_hz_T_3, 13);
	public static Tile wall_topend_hz_T_4 = new WallTileCover(Assets.wall_topend_hz_T_4, 14);
	public static Tile wall_topend_corner_TR = new WallTileCover(Assets.wall_topend_corner_TR, 15);
	public static Tile wall_topend_vt_L_1 = new WallTileSolid(Assets.wall_topend_vt_L_1, 43);
	public static Tile wall_topend_vt_L_2 = new WallTileSolid(Assets.wall_topend_vt_L_2, 80);
	public static Tile wall_topend_vt_L_3 = new WallTileSolid(Assets.wall_topend_vt_L_3, 117);
	public static Tile wall_topend_vt_L_4 = new WallTileSolid(Assets.wall_topend_vt_L_4, 154);
	public static Tile wall_topend_vt_L_5 = new WallTileSolid(Assets.wall_topend_vt_L_5, 191);
	public static Tile wall_topend_vt_L_6 = new WallTileSolid(Assets.wall_topend_vt_L_6, 228);
	public static Tile wall_topend_vt_R_1 = new WallTileSolid(Assets.wall_topend_vt_R_1, 52);
	public static Tile wall_topend_vt_R_2 = new WallTileSolid(Assets.wall_topend_vt_R_2, 89);
	public static Tile wall_topend_vt_R_3 = new WallTileSolid(Assets.wall_topend_vt_R_3, 126);
	public static Tile wall_topend_vt_R_4 = new WallTileSolid(Assets.wall_topend_vt_R_4, 163);
	public static Tile wall_topend_vt_R_5 = new WallTileSolid(Assets.wall_topend_vt_R_5, 200);
	public static Tile wall_topend_vt_R_6 = new WallTileSolid(Assets.wall_topend_vt_R_6, 237);
	public static Tile wall_topend_corner_BL = new WallTileSolid(Assets.wall_topend_corner_BL, 265);
	public static Tile wall_topend_hz_B_1 = new WallTileSolid(Assets.wall_topend_hz_B_1, 266);
	public static Tile wall_topend_hz_B_2 = new WallTileSolid(Assets.wall_topend_hz_B_2, 267);
	public static Tile wall_topend_hz_B_3 = new WallTileSolid(Assets.wall_topend_hz_B_3, 268);
	public static Tile wall_topend_hz_B_4 = new WallTileSolid(Assets.wall_topend_hz_B_4, 269);
	public static Tile wall_topend_hz_B_5 = new WallTileSolid(Assets.wall_topend_hz_B_5, 270);
	public static Tile wall_topend_hz_B_6 = new WallTileSolid(Assets.wall_topend_hz_B_6, 271);
	public static Tile wall_topend_hz_B_7 = new WallTileSolid(Assets.wall_topend_hz_B_7, 272);
	public static Tile wall_topend_hz_B_8 = new WallTileSolid(Assets.wall_topend_hz_B_8, 273);
	public static Tile wall_topend_corner_BR = new WallTileSolid(Assets.wall_topend_corner_BR, 274);

	public static Tile tile_1 = new WallTileSolid(Assets.tile_1, 111);
	public static Tile tile_2 = new WallTileSolid(Assets.tile_2, 148);
	public static Tile tile_3 = new WallTileSolid(Assets.tile_3, 165);
	public static Tile tile_4 = new WallTileSolid(Assets.tile_4, 202);

	public static Tile wall_1_1 = new WallTileSolid(Assets.wall_1_1, 39);
	public static Tile wall_1_2 = new WallTileSolid(Assets.wall_1_2, 40);
	public static Tile wall_1_3 = new WallTileSolid(Assets.wall_1_3, 41);
	public static Tile wall_1_4 = new WallTileSolid(Assets.wall_1_4, 42);
	public static Tile wall_1_5 = new WallTileSolid(Assets.wall_1_5, 76);
	public static Tile wall_1_6 = new WallTileSolid(Assets.wall_1_6, 77);
	public static Tile wall_1_7 = new WallTileSolid(Assets.wall_1_7, 78);
	public static Tile wall_1_8 = new WallTileSolid(Assets.wall_1_8, 79);
	public static Tile wall_1_9 = new WallTileSolid(Assets.wall_1_9, 113);
	public static Tile wall_1_10 = new WallTileSolid(Assets.wall_1_10, 114);
	public static Tile wall_1_11 = new WallTileSolid(Assets.wall_1_11, 115);
	public static Tile wall_1_12 = new WallTileSolid(Assets.wall_1_12, 116);
	public static Tile wall_1_13 = new WallTileSolid(Assets.wall_1_13, 150);
	public static Tile wall_1_14 = new WallTileSolid(Assets.wall_1_14, 151);
	public static Tile wall_1_15 = new WallTileSolid(Assets.wall_1_15, 152);
	public static Tile wall_1_16 = new WallTileSolid(Assets.wall_1_16, 153);

	public static Tile wall_2_1 = new WallTileSolid(Assets.wall_2_1, 16);
	public static Tile wall_2_2 = new WallTileSolid(Assets.wall_2_2, 17);
	public static Tile wall_2_3 = new WallTileSolid(Assets.wall_2_3, 18);
	public static Tile wall_2_4 = new WallTileSolid(Assets.wall_2_4, 19);
	public static Tile wall_2_5 = new WallTileSolid(Assets.wall_2_5, 53);
	public static Tile wall_2_6 = new WallTileSolid(Assets.wall_2_6, 54);
	public static Tile wall_2_7 = new WallTileSolid(Assets.wall_2_7, 55);
	public static Tile wall_2_8 = new WallTileSolid(Assets.wall_2_8, 56);
	public static Tile wall_2_9 = new WallTileSolid(Assets.wall_2_9, 90);
	public static Tile wall_2_10 = new WallTileSolid(Assets.wall_2_10, 91);
	public static Tile wall_2_11 = new WallTileSolid(Assets.wall_2_11, 92);
	public static Tile wall_2_12 = new WallTileSolid(Assets.wall_2_12, 93);
	public static Tile wall_2_13 = new WallTileSolid(Assets.wall_2_13, 127);
	public static Tile wall_2_14 = new WallTileSolid(Assets.wall_2_14, 128);
	public static Tile wall_2_15 = new WallTileSolid(Assets.wall_2_15, 129);
	public static Tile wall_2_16 = new WallTileSolid(Assets.wall_2_16, 130);

	public static Tile wall_3_1 = new WallTileSolid(Assets.wall_3_1, 20);
	public static Tile wall_3_2 = new WallTileSolid(Assets.wall_3_2, 21);
	public static Tile wall_3_3 = new WallTileSolid(Assets.wall_3_3, 22);
	public static Tile wall_3_4 = new WallTileSolid(Assets.wall_3_4, 23);
	public static Tile wall_3_5 = new WallTileSolid(Assets.wall_3_5, 24);
	public static Tile wall_3_6 = new WallTileSolid(Assets.wall_3_6, 25);
	public static Tile wall_3_7 = new WallTileSolid(Assets.wall_3_7, 26);
	public static Tile wall_3_8 = new WallTileSolid(Assets.wall_3_8, 27);
	public static Tile wall_3_9 = new WallTileSolid(Assets.wall_3_9, 57);
	public static Tile wall_3_10 = new WallTileSolid(Assets.wall_3_10, 58);
	public static Tile wall_3_11 = new WallTileSolid(Assets.wall_3_11, 59);
	public static Tile wall_3_12 = new WallTileSolid(Assets.wall_3_12, 60);
	public static Tile wall_3_13 = new WallTileSolid(Assets.wall_3_13, 61);
	public static Tile wall_3_14 = new WallTileSolid(Assets.wall_3_14, 62);
	public static Tile wall_3_15 = new WallTileSolid(Assets.wall_3_15, 63);
	public static Tile wall_3_16 = new WallTileSolid(Assets.wall_3_16, 64);
	public static Tile wall_3_17 = new WallTileSolid(Assets.wall_3_17, 94);
	public static Tile wall_3_18 = new WallTileSolid(Assets.wall_3_18, 95);
	public static Tile wall_3_19 = new WallTileSolid(Assets.wall_3_19, 96);
	public static Tile wall_3_20 = new WallTileSolid(Assets.wall_3_20, 97);
	public static Tile wall_3_21 = new WallTileSolid(Assets.wall_3_21, 98);
	public static Tile wall_3_22 = new WallTileSolid(Assets.wall_3_22, 99);
	public static Tile wall_3_23 = new WallTileSolid(Assets.wall_3_23, 100);
	public static Tile wall_3_24 = new WallTileSolid(Assets.wall_3_24, 101);
	public static Tile wall_3_25 = new WallTileSolid(Assets.wall_3_25, 131);
	public static Tile wall_3_26 = new WallTileSolid(Assets.wall_3_26, 132);
	public static Tile wall_3_27 = new WallTileSolid(Assets.wall_3_27, 133);
	public static Tile wall_3_28 = new WallTileSolid(Assets.wall_3_28, 134);
	public static Tile wall_3_29 = new WallTileSolid(Assets.wall_3_29, 135);
	public static Tile wall_3_30 = new WallTileSolid(Assets.wall_3_30, 136);
	public static Tile wall_3_31 = new WallTileSolid(Assets.wall_3_31, 137);
	public static Tile wall_3_32 = new WallTileSolid(Assets.wall_3_32, 138);
	
	public static Tile wall_4_1 = new WallTileSolid(Assets.wall_4_1, 302);
	public static Tile wall_4_2 = new WallTileSolid(Assets.wall_4_2, 303);
	public static Tile wall_4_3 = new WallTileSolid(Assets.wall_4_3, 304);
	public static Tile wall_4_4 = new WallTileSolid(Assets.wall_4_4, 305);
	public static Tile wall_4_5 = new WallTileSolid(Assets.wall_4_5, 306);
	public static Tile wall_4_6 = new WallTileSolid(Assets.wall_4_6, 307);
	public static Tile wall_4_7 = new WallTileSolid(Assets.wall_4_7, 308);
	public static Tile wall_4_8 = new WallTileSolid(Assets.wall_4_8, 309);
	public static Tile wall_4_9 = new WallTileSolid(Assets.wall_4_9, 310);
	public static Tile wall_4_10 = new WallTileSolid(Assets.wall_4_10, 311);
	public static Tile wall_4_11 = new WallTileSolid(Assets.wall_4_11, 339);
	public static Tile wall_4_12 = new WallTileSolid(Assets.wall_4_12, 340);
	public static Tile wall_4_13 = new WallTileSolid(Assets.wall_4_13, 341);
	public static Tile wall_4_14 = new WallTileSolid(Assets.wall_4_14, 342);
	public static Tile wall_4_15 = new WallTileSolid(Assets.wall_4_15, 343);
	public static Tile wall_4_16 = new WallTileSolid(Assets.wall_4_16, 344);
	public static Tile wall_4_17 = new WallTileSolid(Assets.wall_4_17, 345);
	public static Tile wall_4_18 = new WallTileSolid(Assets.wall_4_18, 346);
	public static Tile wall_4_19 = new WallTileSolid(Assets.wall_4_19, 347);
	public static Tile wall_4_20 = new WallTileSolid(Assets.wall_4_20, 348);
	public static Tile wall_4_21 = new WallTileSolid(Assets.wall_4_21, 376);
	public static Tile wall_4_22 = new WallTileSolid(Assets.wall_4_22, 377);
	public static Tile wall_4_23 = new WallTileSolid(Assets.wall_4_23, 378);
	public static Tile wall_4_24 = new WallTileSolid(Assets.wall_4_24, 379);
	public static Tile wall_4_25 = new WallTileSolid(Assets.wall_4_25, 380);
	public static Tile wall_4_26 = new WallTileSolid(Assets.wall_4_26, 381);
	public static Tile wall_4_27 = new WallTileSolid(Assets.wall_4_27, 382);
	public static Tile wall_4_28 = new WallTileSolid(Assets.wall_4_28, 383);
	public static Tile wall_4_29 = new WallTileSolid(Assets.wall_4_29, 384);
	public static Tile wall_4_30 = new WallTileSolid(Assets.wall_4_29, 385);

	public static Tile window_1_1 = new WallTileCover(Assets.window_1_1, 30);
	public static Tile window_1_2 = new WallTileCover(Assets.window_1_2, 31);
	public static Tile window_1_3 = new WallTileSolid(Assets.window_1_3, 65);
	public static Tile window_1_4 = new WallTileSolid(Assets.window_1_4, 66);
	public static Tile window_1_5 = new WallTileSolid(Assets.window_1_5, 67);
	public static Tile window_1_6 = new WallTileSolid(Assets.window_1_6, 68);
	public static Tile window_1_7 = new WallTileSolid(Assets.window_1_7, 69);
	public static Tile window_1_8 = new WallTileSolid(Assets.window_1_8, 70);
	public static Tile window_1_9 = new WallTileSolid(Assets.window_1_9, 102);
	public static Tile window_1_10 = new WallTileSolid(Assets.window_1_10, 103);
	public static Tile window_1_11 = new WallTileSolid(Assets.window_1_11, 104);
	public static Tile window_1_12 = new WallTileSolid(Assets.window_1_12, 105);
	public static Tile window_1_13 = new WallTileSolid(Assets.window_1_13, 106);
	public static Tile window_1_14 = new WallTileSolid(Assets.window_1_14, 107);
	public static Tile window_1_15 = new WallTileSolid(Assets.window_1_15, 140);
	public static Tile window_1_16 = new WallTileSolid(Assets.window_1_16, 141);
	public static Tile window_1_17 = new WallTileSolid(Assets.window_1_17, 142);
	public static Tile window_1_18 = new WallTileSolid(Assets.window_1_18, 143);
	public static Tile window_1_19 = new WallTileSolid(Assets.window_1_19, 177);
	public static Tile window_1_20 = new WallTileSolid(Assets.window_1_20, 178);
	public static Tile window_1_21 = new WallTileSolid(Assets.window_1_21, 179);
	public static Tile window_1_22 = new WallTileSolid(Assets.window_1_22, 180);
	public static Tile window_1_23 = new WallTileSolid(Assets.window_1_23, 214);
	public static Tile window_1_24 = new WallTileSolid(Assets.window_1_24, 215);
	public static Tile window_1_25 = new WallTileSolid(Assets.window_1_25, 216);
	public static Tile window_1_26 = new WallTileSolid(Assets.window_1_26, 217);

	public static Tile window_2_1 = new WallTileSolid(Assets.window_2_1, 222);
	public static Tile window_2_2 = new WallTileSolid(Assets.window_2_2, 223);
	public static Tile window_2_3 = new WallTileSolid(Assets.window_2_3, 259);
	public static Tile window_2_4 = new WallTileSolid(Assets.window_2_4, 260);
	public static Tile window_2_5 = new WallTileSolid(Assets.window_2_5, 296);
	public static Tile window_2_6 = new WallTileSolid(Assets.window_2_6, 297);
	public static Tile window_2_7 = new WallTileSolid(Assets.window_2_7, 333);
	public static Tile window_2_8 = new WallTileSolid(Assets.window_2_8, 334);

	public static Tile window_3_1 = new WallTileSolid(Assets.window_3_1, 204);
	public static Tile window_3_2 = new WallTileSolid(Assets.window_3_2, 205);
	public static Tile window_3_3 = new WallTileSolid(Assets.window_3_3, 241);
	public static Tile window_3_4 = new WallTileSolid(Assets.window_3_4, 242);
	public static Tile window_3_5 = new WallTileSolid(Assets.window_3_5, 278);
	public static Tile window_3_6 = new WallTileSolid(Assets.window_3_6, 279);
	public static Tile window_3_7 = new WallTileSolid(Assets.window_3_7, 315);
	public static Tile window_3_8 = new WallTileSolid(Assets.window_3_8, 316);

	public static Tile pillar_1_1 = new WallTileSolid(Assets.pillar_1_1, 225);
	public static Tile pillar_1_2 = new WallTileSolid(Assets.pillar_1_2, 262);
	public static Tile pillar_1_3 = new WallTileSolid(Assets.pillar_1_3, 299);
	public static Tile pillar_1_4 = new WallTileSolid(Assets.pillar_1_4, 336);
	public static Tile pillar_1_5 = new WallTileSolid(Assets.pillar_1_5, 373);

	public static Tile pillar_2_0 = new WallTileSolid(Assets.pillar_2_0, 166);
	public static Tile pillar_2_1 = new WallTileSolid(Assets.pillar_2_1, 203);
	public static Tile pillar_2_2 = new WallTileSolid(Assets.pillar_2_2, 240);
	public static Tile pillar_2_3 = new WallTileSolid(Assets.pillar_2_3, 277);
	public static Tile pillar_2_4 = new WallTileSolid(Assets.pillar_2_4, 314);
	public static Tile pillar_2_5 = new WallTileSolid(Assets.pillar_2_5, 351);
	public static Tile pillar_2_6_1 = new WallTileSolid(Assets.pillar_2_6_1, 325);
	public static Tile pillar_2_6_2 = new WallTileSolid(Assets.pillar_2_6_2, 326);
	public static Tile pillar_2_6_3 = new WallTileSolid(Assets.pillar_2_6_3, 327);
	public static Tile pillar_2_7_1 = new WallTileSolid(Assets.pillar_2_7_1, 362);
	public static Tile pillar_2_7_2 = new WallTileSolid(Assets.pillar_2_7_2, 363);
	public static Tile pillar_2_7_3 = new WallTileSolid(Assets.pillar_2_7_3, 364);

	public static Tile pillar_3_0 = new WallTileSolid(Assets.pillar_3_0, 169);
	public static Tile pillar_3_1 = new WallTileSolid(Assets.pillar_3_1, 206);
	public static Tile pillar_3_2 = new WallTileSolid(Assets.pillar_3_2, 243);
	public static Tile pillar_3_3 = new WallTileSolid(Assets.pillar_3_3, 280);
	public static Tile pillar_3_4 = new WallTileSolid(Assets.pillar_3_4, 317);
	public static Tile pillar_3_5 = new WallTileSolid(Assets.pillar_3_5, 354);
	public static Tile pillar_3_6_1 = new WallTileSolid(Assets.pillar_3_6_1, 251);
	public static Tile pillar_3_6_2 = new WallTileSolid(Assets.pillar_3_6_2, 252);
	public static Tile pillar_3_6_3 = new WallTileSolid(Assets.pillar_3_6_3, 253);
	public static Tile pillar_3_6_4 = new WallTileSolid(Assets.pillar_3_6_4, 254);
	public static Tile pillar_3_7_1 = new WallTileSolid(Assets.pillar_3_7_1, 288);
	public static Tile pillar_3_7_2 = new WallTileSolid(Assets.pillar_3_7_2, 289);
	public static Tile pillar_3_7_3 = new WallTileSolid(Assets.pillar_3_7_3, 290);
	public static Tile pillar_3_7_4 = new WallTileSolid(Assets.pillar_3_7_4, 291);

	public static Tile wall_botend_edge_TL_1 = new NonSolidTile(Assets.wall_botend_edge_TL_1, 190);
	public static Tile wall_botend_vt_L_1 = new NonSolidTile(Assets.wall_botend_vt_L_1, 227);
	public static Tile wall_botend_vt_L_2 = new NonSolidTile(Assets.wall_botend_vt_L_2, 264);
	public static Tile wall_botend_corner_TR_1 = new NonSolidTile(Assets.wall_botend_corner_TR_1, 301);
	public static Tile wall_botend_vt_L_3 = new NonSolidTile(Assets.wall_botend_vt_L_3, 338);
	public static Tile wall_botend_vt_L_4 = new NonSolidTile(Assets.wall_botend_vt_L_4, 375);
	public static Tile wall_botend_edge_BL_1 = new NonSolidTile(Assets.wall_botend_edge_BL_1, 412);
	public static Tile wall_botend_hz_B_1 = new NonSolidTile(Assets.wall_botend_hz_B_1, 413);
	public static Tile wall_botend_hz_B_2 = new NonSolidTile(Assets.wall_botend_hz_B_2, 414);

	public static Tile wall_botend_edge_TR_1 = new NonSolidTile(Assets.wall_botend_edge_TR_1, 201);
	public static Tile wall_botend_vt_R_1 = new NonSolidTile(Assets.wall_botend_vt_R_1, 238);
	public static Tile wall_botend_vt_R_2 = new NonSolidTile(Assets.wall_botend_vt_R_2, 275);
	public static Tile wall_botend_corner_TL_1 = new NonSolidTile(Assets.wall_botend_corner_TL_1, 312);
	public static Tile wall_botend_vt_R_3 = new NonSolidTile(Assets.wall_botend_vt_R_3, 349);
	public static Tile wall_botend_vt_R_4 = new NonSolidTile(Assets.wall_botend_vt_R_4, 386);
	public static Tile wall_botend_edge_BR_1 = new NonSolidTile(Assets.wall_botend_edge_BR_1, 423);

	public static Tile stairs_1 = new WallTileSolid(Assets.stairs_1, 390);
	public static Tile stairs_2 = new WallTileSolid(Assets.stairs_2, 391);
	public static Tile stairs_3 = new WallTileSolid(Assets.stairs_3, 392);
	public static Tile stairs_4 = new WallTileSolid(Assets.stairs_4, 393);
	public static Tile stairs_5 = new WallTileSolid(Assets.stairs_5, 427);
	public static Tile stairs_6 = new WallTileSolid(Assets.stairs_6, 428);
	public static Tile stairs_7 = new WallTileSolid(Assets.stairs_7, 429);
	public static Tile stairs_8 = new WallTileSolid(Assets.stairs_8, 430);

	public static Tile spikes_1 = new WallTileSolid(Assets.spikes_1, 323);
	public static Tile spikes_2 = new WallTileSolid(Assets.spikes_2, 360);
	public static Tile spikes_3 = new WallTileSolid(Assets.spikes_3, 361);
	public static Tile spikes_4 = new WallTileSolid(Assets.spikes_4, 396);
	public static Tile spikes_5 = new WallTileSolid(Assets.spikes_5, 397);
	public static Tile spikes_6 = new WallTileSolid(Assets.spikes_6, 398);

	public static Tile entrance_basic_1 = new WallTileSolid(Assets.entrance_basic_1, 462);
	public static Tile entrance_basic_2 = new WallTileSolid(Assets.entrance_basic_2, 463);
	public static Tile entrance_basic_3 = new WallTileSolid(Assets.entrance_basic_3, 464);
	public static Tile entrance_basic_4 = new WallTileSolid(Assets.entrance_basic_4, 465);
	public static Tile entrance_basic_5 = new WallTileSolid(Assets.entrance_basic_5, 466);
	public static Tile entrance_basic_6 = new WallTileSolid(Assets.entrance_basic_6, 499);
	public static Tile entrance_basic_7 = new WallTileSolid(Assets.entrance_basic_7, 500);
	public static Tile entrance_basic_8 = new WallTileSolid(Assets.entrance_basic_8, 501);
	public static Tile entrance_basic_9 = new WallTileSolid(Assets.entrance_basic_9, 502);
	public static Tile entrance_basic_10 = new WallTileSolid(Assets.entrance_basic_10, 503);
	public static Tile entrance_basic_11 = new WallTileSolid(Assets.entrance_basic_11, 536);
	public static Tile entrance_basic_12 = new WallTileSolid(Assets.entrance_basic_12, 537);
	public static Tile entrance_basic_13 = new WallTileSolid(Assets.entrance_basic_13, 538);
	public static Tile entrance_basic_14 = new WallTileSolid(Assets.entrance_basic_14, 539);
	public static Tile entrance_basic_15 = new WallTileSolid(Assets.entrance_basic_15, 540);
	public static Tile entrance_basic_16 = new WallTileSolid(Assets.entrance_basic_16, 573);
	public static Tile entrance_basic_17 = new WallTileSolid(Assets.entrance_basic_17, 574);
	public static Tile entrance_basic_18 = new WallTileSolid(Assets.entrance_basic_18, 575);
	public static Tile entrance_basic_19 = new WallTileSolid(Assets.entrance_basic_19, 576);
	public static Tile entrance_basic_20 = new WallTileSolid(Assets.entrance_basic_20, 577);
	public static Tile entrance_basic_21 = new WallTileSolid(Assets.entrance_basic_21, 610);
	public static Tile entrance_basic_22 = new WallTileSolid(Assets.entrance_basic_22, 611);
	public static Tile entrance_basic_23 = new WallTileSolid(Assets.entrance_basic_23, 612);
	public static Tile entrance_basic_24 = new WallTileSolid(Assets.entrance_basic_24, 613);
	public static Tile entrance_basic_25 = new WallTileSolid(Assets.entrance_basic_25, 614);
	public static Tile entrance_basic_26 = new WallTileSolid(Assets.entrance_basic_26, 647);
	public static Tile entrance_basic_27 = new WallTileSolid(Assets.entrance_basic_27, 648);
	public static Tile entrance_basic_28 = new WallTileSolid(Assets.entrance_basic_28, 649);
	public static Tile entrance_basic_29 = new WallTileSolid(Assets.entrance_basic_29, 650);
	public static Tile entrance_basic_30 = new WallTileSolid(Assets.entrance_basic_30, 651);
	
	public static Tile entrance_inner_1_1 = new WallTileSolid(Assets.entrance_inner_1_1,208);
	public static Tile entrance_inner_1_2 = new WallTileSolid(Assets.entrance_inner_1_2,209);
	public static Tile entrance_inner_1_3 = new WallTileSolid(Assets.entrance_inner_1_3,210);
	public static Tile entrance_inner_1_4 = new WallTileSolid(Assets.entrance_inner_1_4,245);
	public static Tile entrance_inner_1_5 = new WallTileSolid(Assets.entrance_inner_1_5,246);
	public static Tile entrance_inner_1_6 = new WallTileSolid(Assets.entrance_inner_1_6,247);
	public static Tile entrance_inner_1_7 = new WallTileSolid(Assets.entrance_inner_1_7,282);
	public static Tile entrance_inner_1_8 = new WallTileSolid(Assets.entrance_inner_1_8,283);
	public static Tile entrance_inner_1_9 = new WallTileSolid(Assets.entrance_inner_1_9,284);
	
	public static Tile entrance_inner_2_1 = new WallTileSolid(Assets.entrance_inner_2_1,174);
	public static Tile entrance_inner_2_2 = new WallTileSolid(Assets.entrance_inner_2_2,175);
	public static Tile entrance_inner_2_3 = new WallTileSolid(Assets.entrance_inner_2_3,176);
	public static Tile entrance_inner_2_4 = new WallTileSolid(Assets.entrance_inner_2_4,211);
	public static Tile entrance_inner_2_5 = new WallTileSolid(Assets.entrance_inner_2_5,212);
	public static Tile entrance_inner_2_6 = new WallTileSolid(Assets.entrance_inner_2_6,213);
	public static Tile entrance_inner_2_7 = new WallTileSolid(Assets.entrance_inner_2_7,248);
	public static Tile entrance_inner_2_8 = new WallTileSolid(Assets.entrance_inner_2_8,249);
	public static Tile entrance_inner_2_9 = new WallTileSolid(Assets.entrance_inner_2_9,250);
	public static Tile entrance_inner_2_10 = new WallTileSolid(Assets.entrance_inner_2_10,285);
	public static Tile entrance_inner_2_11 = new WallTileSolid(Assets.entrance_inner_2_11,286);
	public static Tile entrance_inner_2_12 = new WallTileSolid(Assets.entrance_inner_2_12,287);
	
	public static Tile entrance_inner_3_1 = new WallTileSolid(Assets.entrance_inner_3_1,108);
	public static Tile entrance_inner_3_2 = new WallTileSolid(Assets.entrance_inner_3_2,108);
	public static Tile entrance_inner_3_3 = new WallTileSolid(Assets.entrance_inner_3_3,108);
	public static Tile entrance_inner_3_4 = new WallTileSolid(Assets.entrance_inner_3_4,145);
	public static Tile entrance_inner_3_5 = new WallTileSolid(Assets.entrance_inner_3_5,145);
	public static Tile entrance_inner_3_6 = new WallTileSolid(Assets.entrance_inner_3_6,145);
	public static Tile entrance_inner_3_7 = new WallTileSolid(Assets.entrance_inner_3_7,182);
	public static Tile entrance_inner_3_8 = new WallTileSolid(Assets.entrance_inner_3_8,182);
	public static Tile entrance_inner_3_9 = new WallTileSolid(Assets.entrance_inner_3_9,182);
	public static Tile entrance_inner_3_10 = new WallTileSolid(Assets.entrance_inner_3_10,219);
	public static Tile entrance_inner_3_11 = new WallTileSolid(Assets.entrance_inner_3_11,219);
	public static Tile entrance_inner_3_12 = new WallTileSolid(Assets.entrance_inner_3_12,219);

	public static Tile blue_border_edge_TL = new WallTileSolid(Assets.blue_border_edge_TL,255);
	public static Tile blue_border_hz_T_1 = new WallTileSolid(Assets.blue_border_hz_T_1,256);
	public static Tile blue_border_hz_T_2 = new WallTileSolid(Assets.blue_border_hz_T_2,257);
	public static Tile blue_border_edge_TR = new WallTileSolid(Assets.blue_border_edge_TR,258);
	public static Tile blue_border_vt_R_1 = new WallTileSolid(Assets.blue_border_vt_R_1,295);
	public static Tile blue_border_vt_R_2 = new WallTileSolid(Assets.blue_border_vt_R_2,332);
	public static Tile blue_border_vt_R_3 = new WallTileSolid(Assets.blue_border_vt_R_3,369);
	public static Tile blue_border_edge_BR = new WallTileSolid(Assets.blue_border_edge_BR,406);
	public static Tile blue_border_hz_B_1 = new WallTileSolid(Assets.blue_border_hz_B_1,405);
	public static Tile blue_border_hz_B_2 = new WallTileSolid(Assets.blue_border_hz_B_2,404);
	public static Tile blue_border_edge_BL = new WallTileSolid(Assets.blue_border_edge_BL,403);
	public static Tile blue_border_vt_L_1 = new WallTileSolid(Assets.blue_border_vt_L_1,366);
	public static Tile blue_border_vt_L_2 = new WallTileSolid(Assets.blue_border_vt_L_2,329);
	public static Tile blue_border_vt_L_3 = new WallTileSolid(Assets.blue_border_vt_L_3,292);
	
	public static Tile wall_botend_corner_BR_2 = new WallTileSolid(Assets.wall_botend_corner_BR_2,34);
	public static Tile wall_botend_corner_BL_2 = new WallTileSolid(Assets.wall_botend_corner_BL_2,36);
	public static Tile wall_botend_corner_TL_2 = new WallTileSolid(Assets.wall_botend_corner_TL_2,73);
	public static Tile wall_botend_corner_TR_2 = new WallTileSolid(Assets.wall_botend_corner_TR_2,71);
	
	public static Tile floor_1_1 = new FloorTile(Assets.floor_1_1,703);
	public static Tile floor_1_2 = new FloorTile(Assets.floor_1_2,704);
	public static Tile floor_1_3 = new FloorTile(Assets.floor_1_3,740);
	public static Tile floor_1_4 = new FloorTile(Assets.floor_1_4,741);
	
	public static Tile floor_2_1 = new FloorTile(Assets.floor_2_1,705);
	public static Tile floor_2_2 = new FloorTile(Assets.floor_2_2,706);
	public static Tile floor_2_3 = new FloorTile(Assets.floor_2_3,742);
	public static Tile floor_2_4 = new FloorTile(Assets.floor_2_4,743);
	// CLASS

	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	public static final int TILE_BOUND_WIDTH = 4, TILE_BOUND_HEIGHT = 4;
	public static final int[] ALL_TILES = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		System.out.println("Read Tile: " + (id + 1));
		tiles[id + 1] = this;
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
