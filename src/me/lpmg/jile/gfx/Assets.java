package me.lpmg.jile.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

import me.lpmg.jile.tiles.Tile;
import me.lpmg.jile.tiles.WallTileSolid;

public class Assets {

	private static final int default_width = 16, default_height = 16;
	private static final int default_big_width = 32, default_big_height = 32;
	private static final int player_sheet_width = 84, player_sheet_height = 84;
	private static final int player_sheet_small_width = 16, player_sheet_small_height = 23;
	private static final int sorcerer_sheet_width = 80, sorcerer_sheet_height = 80;
	private static final int healthbar_width = 64, healthbar_height = 10;

	public static Font font9, font14, font16, font28, font32, font48, font96;

	public static BufferedImage parallax_mountain_bg, parallax_mountain_clouds, parallax_mountain_foreground_trees,
			parallax_mountain_mountain_far, parallax_mountain_mountains, parallax_mountain_trees;

	// TILESHEET
	public static BufferedImage placeholder, blackTile, pinkTile;
	public static BufferedImage wall_topend_corner_TL, wall_topend_hz_T_1, wall_topend_hz_T_2, wall_topend_edge_BR,
			wall_topend_edge_BL, wall_topend_hz_T_3, wall_topend_hz_T_4, wall_topend_corner_TR, wall_topend_vt_L_1,
			wall_topend_vt_L_2, wall_topend_vt_L_3, wall_topend_vt_L_4, wall_topend_vt_L_5, wall_topend_vt_L_6,
			wall_topend_vt_R_1, wall_topend_vt_R_2, wall_topend_vt_R_3, wall_topend_vt_R_4, wall_topend_vt_R_5,
			wall_topend_vt_R_6, wall_topend_corner_BL, wall_topend_hz_B_1, wall_topend_hz_B_2, wall_topend_hz_B_3,
			wall_topend_hz_B_4, wall_topend_hz_B_5, wall_topend_hz_B_6, wall_topend_hz_B_7, wall_topend_hz_B_8,
			wall_topend_corner_BR;
	public static BufferedImage tile_1, tile_2, tile_3, tile_4;
	public static BufferedImage wall_1_1, wall_1_2, wall_1_3, wall_1_4, wall_1_5, wall_1_6, wall_1_7, wall_1_8,
			wall_1_9, wall_1_10, wall_1_11, wall_1_12, wall_1_13, wall_1_14, wall_1_15, wall_1_16;
	public static BufferedImage wall_2_1, wall_2_2, wall_2_3, wall_2_4, wall_2_5, wall_2_6, wall_2_7, wall_2_8,
			wall_2_9, wall_2_10, wall_2_11, wall_2_12, wall_2_13, wall_2_14, wall_2_15, wall_2_16;
	public static BufferedImage wall_3_1, wall_3_2, wall_3_3, wall_3_4, wall_3_5, wall_3_6, wall_3_7, wall_3_8,
			wall_3_9, wall_3_10, wall_3_11, wall_3_12, wall_3_13, wall_3_14, wall_3_15, wall_3_16, wall_3_17, wall_3_18,
			wall_3_19, wall_3_20, wall_3_21, wall_3_22, wall_3_23, wall_3_24, wall_3_25, wall_3_26, wall_3_27,
			wall_3_28, wall_3_29, wall_3_30, wall_3_31, wall_3_32;
	public static BufferedImage wall_4_1, wall_4_2, wall_4_3, wall_4_4, wall_4_5, wall_4_6, wall_4_7, wall_4_8,
			wall_4_9, wall_4_10, wall_4_11, wall_4_12, wall_4_13, wall_4_14, wall_4_15, wall_4_16, wall_4_17, wall_4_18,
			wall_4_19, wall_4_20, wall_4_21, wall_4_22, wall_4_23, wall_4_24, wall_4_25, wall_4_26, wall_4_27,
			wall_4_28, wall_4_29, wall_4_30;
	public static BufferedImage window_1_1, window_1_2, window_1_3, window_1_4, window_1_5, window_1_6, window_1_7,
			window_1_8, window_1_9, window_1_10, window_1_11, window_1_12, window_1_13, window_1_14, window_1_15,
			window_1_16, window_1_17, window_1_18, window_1_19, window_1_20, window_1_21, window_1_22, window_1_23,
			window_1_24, window_1_25, window_1_26;
	public static BufferedImage window_2_1, window_2_2, window_2_3, window_2_4, window_2_5, window_2_6, window_2_7,
			window_2_8;
	public static BufferedImage window_3_1, window_3_2, window_3_3, window_3_4, window_3_5, window_3_6, window_3_7,
			window_3_8;
	public static BufferedImage pillar_1_1, pillar_1_2, pillar_1_3, pillar_1_4, pillar_1_5;
	public static BufferedImage pillar_2_0, pillar_2_1, pillar_2_2, pillar_2_3, pillar_2_4, pillar_2_5, pillar_2_6_1,
			pillar_2_6_2, pillar_2_6_3, pillar_2_7_1, pillar_2_7_2, pillar_2_7_3;
	public static BufferedImage pillar_3_0, pillar_3_1, pillar_3_2, pillar_3_3, pillar_3_4, pillar_3_5, pillar_3_6_1,
			pillar_3_6_2, pillar_3_6_3, pillar_3_6_4, pillar_3_7_1, pillar_3_7_2, pillar_3_7_3, pillar_3_7_4;
	public static BufferedImage wall_botend_edge_TL_1, wall_botend_vt_L_1, wall_botend_vt_L_2, wall_botend_corner_TR_1,
			wall_botend_vt_L_3, wall_botend_vt_L_4, wall_botend_edge_BL_1, wall_botend_hz_B_1, wall_botend_hz_B_2;
	public static BufferedImage wall_botend_edge_TR_1, wall_botend_vt_R_1, wall_botend_vt_R_2, wall_botend_corner_TL_1,
			wall_botend_vt_R_3, wall_botend_vt_R_4, wall_botend_edge_BR_1;
	public static BufferedImage stairs_1, stairs_2, stairs_3, stairs_4, stairs_5, stairs_6, stairs_7, stairs_8;
	public static BufferedImage spikes_1, spikes_2, spikes_3, spikes_4, spikes_5, spikes_6;
	public static BufferedImage entrance_basic_1, entrance_basic_2, entrance_basic_3, entrance_basic_4,
			entrance_basic_5, entrance_basic_6, entrance_basic_7, entrance_basic_8, entrance_basic_9, entrance_basic_10,
			entrance_basic_11, entrance_basic_12, entrance_basic_13, entrance_basic_14, entrance_basic_15,
			entrance_basic_16, entrance_basic_17, entrance_basic_18, entrance_basic_19, entrance_basic_20,
			entrance_basic_21, entrance_basic_22, entrance_basic_23, entrance_basic_24, entrance_basic_25,
			entrance_basic_26, entrance_basic_27, entrance_basic_28, entrance_basic_29, entrance_basic_30;
	public static BufferedImage entrance_inner_1_1, entrance_inner_1_2, entrance_inner_1_3, entrance_inner_1_4,
			entrance_inner_1_5, entrance_inner_1_6, entrance_inner_1_7, entrance_inner_1_8, entrance_inner_1_9;
	public static BufferedImage entrance_inner_2_1, entrance_inner_2_2, entrance_inner_2_3, entrance_inner_2_4,
			entrance_inner_2_5, entrance_inner_2_6, entrance_inner_2_7, entrance_inner_2_8, entrance_inner_2_9,
			entrance_inner_2_10, entrance_inner_2_11, entrance_inner_2_12;
	public static BufferedImage entrance_inner_3_1, entrance_inner_3_2, entrance_inner_3_3, entrance_inner_3_4,
			entrance_inner_3_5, entrance_inner_3_6, entrance_inner_3_7, entrance_inner_3_8, entrance_inner_3_9,
			entrance_inner_3_10, entrance_inner_3_11, entrance_inner_3_12;
	public static BufferedImage blue_border_edge_TL, blue_border_hz_T_1, blue_border_hz_T_2, blue_border_edge_TR,
			blue_border_vt_R_1, blue_border_vt_R_2, blue_border_vt_R_3, blue_border_edge_BR, blue_border_hz_B_1,
			blue_border_hz_B_2, blue_border_edge_BL, blue_border_vt_L_1, blue_border_vt_L_2, blue_border_vt_L_3;
	public static BufferedImage wall_botend_corner_BR_2, wall_botend_corner_BL_2, wall_botend_corner_TL_2,
			wall_botend_corner_TR_2;
	public static BufferedImage floor_1_1, floor_1_2, floor_1_3, floor_1_4;
	public static BufferedImage floor_2_1, floor_2_2, floor_2_3, floor_2_4;

	// END TILESHEET
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_idleUp, player_idleDown,
			player_idleLeft, player_idleRight, player_attack_down, player_attack_up, player_attack_left,
			player_attack_right;
	public static BufferedImage[] wizard_down, wizard_up, wizard_left, wizard_right, wizard_idle;
	public static BufferedImage[] jina_down, jina_up, jina_left, jina_right, jina_idleUp, jina_idleDown, jina_idleLeft,
			jina_idleRight;
	public static BufferedImage[] sorcerer_down, sorcerer_up, sorcerer_left, sorcerer_right, sorcerer_idleDown,
			sorcerer_idleLeft, sorcerer_idleRight, sorcerer_idleUp, sorcerer_death_left, sorcerer_death_right,
			sorcerer_attack_left, sorcerer_attack_right;
	public static BufferedImage[] hermit_down, hermit_up, hermit_left, hermit_right, hermit_idle;

	public static BufferedImage fence_hz, fence_vt, fence_hL, fence_hR, fence_CBL, fence_CBR, fence_CTL, fence_CTR;
	public static BufferedImage hedge_hzB, hedge_hzT, hedge_vtL, hedge_vtR, hedge_CBL, hedge_CBR, hedge_CTL, hedge_CTR,
			hedge_plain, hedge_plainCBL, hedge_plainCBR, hedge_plainCTL, hedge_plainCTR;

	public static BufferedImage[] btn_start, btn_buy, btn_sell, btn_remove, btn_build;
	public static BufferedImage btn_equip, btn_unequip;
	public static BufferedImage inventoryScreen, itemBar, itemBar_highlighted, statsGUI_full, statsGUI_prev;
	public static BufferedImage wizardBuyMenu, wizardSellMenu;
	public static BufferedImage healthbar, healthbar_empty, healthbar_health_full, healthbar_mana_full,
			healthbar_corner_full, money_bar, background_plain, background_plain_small, checkbox_off, checkbox_on,
			xpbar_empty, xpbar_full;
	public static BufferedImage speechToast, dialogue_arrow;
	public static BufferedImage coin;

	// buildings
	public static BufferedImage hermit_hut, house_jina;
	public static BufferedImage floor_1, floor_2, floor_3, floor_4, floor_5, floor_6, floor_7, floor_8, floor_9,
			floor_10, floor_11, floor_12, floor_13, floor_14, floor_15, floor_16, floor_17, floor_18, floor_19,
			floor_20;
	public static BufferedImage wooden_wall_1, white_wall_middle, white_wall_bottom, yellowStripes_wall_middle,
			yellowStripes_wall_bottom;
	public static BufferedImage room_margin_left, room_margin_right, room_margin_bottom, room_margin_top,
			room_margin_ctl, room_margin_ctr, room_margin_cbl, room_margin_cbr, room_margin_bottom_end_left,
			room_margin_bottom_end_right;

	// emotes
	public static BufferedImage emote_exclamations;

	// items
	public static BufferedImage woodItem, rockItem;
	public static BufferedImage sword_normal, sword_common;
	public static BufferedImage chestplate_metal_1;
	public static BufferedImage chain_1;
	public static BufferedImage boots_leather_1;
	public static BufferedImage helmet_metal_1;
	public static BufferedImage ring_metal_1;
	public static BufferedImage shield_metal_1;

	static {
		
		font9 = FontLoader.loadFont("/fonts/slkscr.ttf", 9);
		font14 = FontLoader.loadFont("/fonts/slkscr.ttf", 14);
		font16 = FontLoader.loadFont("/fonts/slkscr.ttf", 16);
		font28 = FontLoader.loadFont("/fonts/slkscr.ttf", 28);
		font32 = FontLoader.loadFont("/fonts/slkscr.ttf", 32);
		font48 = FontLoader.loadFont("/fonts/slkscr.ttf", 48);
		font96 = FontLoader.loadFont("/fonts/slkscr.ttf", 96);
//		font9 = new Font("TimesRoman", Font.PLAIN, 9); 
//		font14 = new Font("TimesRoman", Font.PLAIN, 14); 
//		font16 = new Font("TimesRoman", Font.PLAIN, 16); 
//		font28 = new Font("TimesRoman", Font.PLAIN, 28); 
//		font32 = new Font("TimesRoman", Font.PLAIN, 32); 
//		font48 = new Font("TimesRoman", Font.PLAIN, 48); 
//		font96 = new Font("TimesRoman", Font.PLAIN, 96); 

		SpriteSheet tilesheet = new SpriteSheet(ImageLoader.loadImage("/textures/tilesheet.png"));

		SpriteSheet player_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/knight_sheet_full.png"));
		SpriteSheet wizard_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/wizard_sheet.png"));
		SpriteSheet sorcerer_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sorcerer_sheet.png"));

		SpriteSheet item_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/item_sheet.png"));

		SpriteSheet healthbar_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/UI/healthbar_sheet.png"));
		SpriteSheet xpbar_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/UI/xp_bar.png"));
		SpriteSheet startBtn = new SpriteSheet(ImageLoader.loadImage("/textures/UI/button_start.png"));
		SpriteSheet wizardBtn = new SpriteSheet(ImageLoader.loadImage("/textures/UI/button_wizard.png"));
		SpriteSheet itemMenuBtn = new SpriteSheet(ImageLoader.loadImage("/textures/UI/button_itemMenu.png"));
		SpriteSheet equipBtn = new SpriteSheet(ImageLoader.loadImage("/textures/UI/button_Equip.png"));

		parallax_mountain_bg = ImageLoader.loadImage("/textures/mountains/parallax-mountain-bg.png");
		parallax_mountain_clouds = ImageLoader.loadImage("/textures/mountains/parallax-mountain-clouds.png");
		parallax_mountain_foreground_trees = ImageLoader
				.loadImage("/textures/mountains/parallax-mountain-foreground-trees.png");
		parallax_mountain_mountain_far = ImageLoader
				.loadImage("/textures/mountains/parallax-mountain-mountain-far.png");
		parallax_mountain_mountains = ImageLoader.loadImage("/textures/mountains/parallax-mountain-mountains.png");
		parallax_mountain_trees = ImageLoader.loadImage("/textures/mountains/parallax-mountain-trees.png");

		inventoryScreen = ImageLoader.loadImage("/textures/UI/inventoryScreen.png");
		itemBar = ImageLoader.loadImage("/textures/UI/item_bar.png");
		itemBar_highlighted = ImageLoader.loadImage("/textures/UI/item_bar_highlighted.png");
		wizardBuyMenu = ImageLoader.loadImage("/textures/UI/wizardBuyMenu.png");
		wizardSellMenu = ImageLoader.loadImage("/textures/UI/wizardSellMenu.png");
		statsGUI_full = ImageLoader.loadImage("/textures/UI/statsGUI_full.png");
		statsGUI_prev = ImageLoader.loadImage("/textures/UI/statsGUI_prev.png");
		coin = ImageLoader.loadImage("/textures/UI/coin.png");
		money_bar = ImageLoader.loadImage("/textures/UI/money_bar.png");
		background_plain = ImageLoader.loadImage("/textures/UI/background_plain.png");
		background_plain_small = ImageLoader.loadImage("/textures/UI/background_plain_small.png");
		checkbox_off = ImageLoader.loadImage("/textures/UI/checkbox_off.png");
		checkbox_on = ImageLoader.loadImage("/textures/UI/checkbox_on.png");
		speechToast = ImageLoader.loadImage("/textures/UI/speechToast.png");
		dialogue_arrow = ImageLoader.loadImage("/textures/UI/dialogue_arrow.png");

		emote_exclamations = ImageLoader.loadImage("/textures/emotes/emote_exclamations.png");

		woodItem = item_sheet.crop(0, 0, default_big_width, default_big_height);
		rockItem = item_sheet.crop(default_big_width, 0, default_big_width, default_big_height);

		sword_normal = ImageLoader.loadImage("/textures/items/sword_normal.png");
		sword_common = ImageLoader.loadImage("/textures/items/sword_common.png");

		chestplate_metal_1 = ImageLoader.loadImage("/textures/items/chestplate_metal_1.png");

		chain_1 = ImageLoader.loadImage("/textures/items/chain_1.png");

		boots_leather_1 = ImageLoader.loadImage("/textures/items/boots_leather_1.png");

		helmet_metal_1 = ImageLoader.loadImage("/textures/items/helmet_metal_1.png");

		ring_metal_1 = ImageLoader.loadImage("/textures/items/ring_metal_1.png");

		shield_metal_1 = ImageLoader.loadImage("/textures/items/shield_metal_1.png");

		btn_start = new BufferedImage[2];
		btn_start[0] = startBtn.crop(0, 0, default_big_width * 2, default_big_height);
		btn_start[1] = startBtn.crop(0, default_big_height, default_big_width * 2, default_big_height);

		btn_buy = new BufferedImage[2];
		btn_buy[0] = wizardBtn.crop(0, 0, default_big_width * 2, default_big_height);
		btn_buy[1] = wizardBtn.crop(0, default_big_height, default_big_width * 2, default_big_height);

		btn_sell = new BufferedImage[2];
		btn_sell[0] = wizardBtn.crop(default_big_width * 2, 0, default_big_width * 2, default_big_height);
		btn_sell[1] = wizardBtn.crop(default_big_width * 2, default_big_height, default_big_width * 2,
				default_big_height);

//		btn_remove = new BufferedImage[2];
//		btn_remove[0] = itemMenuBtn.crop(0, 0, default_width * 3, default_height);
//		btn_remove[1] = itemMenuBtn.crop(0, default_height, default_width * 3, default_height);
//
//		btn_build = new BufferedImage[2];
//		btn_build[0] = itemMenuBtn.crop(default_width * 3, 0, default_width * 3, default_height);
//		btn_build[1] = itemMenuBtn.crop(default_width * 3, default_height, default_width * 3, default_height);

		btn_equip = equipBtn.crop(0, 0, default_big_width * 3, default_big_height);
		btn_unequip = equipBtn.crop(default_big_width * 3, 0, default_big_width * 3, default_big_height);

		healthbar_empty = healthbar_sheet.crop(0, 0, healthbar_width, healthbar_height);
		healthbar_health_full = healthbar_sheet.crop(0, healthbar_height, healthbar_width, healthbar_height);
		healthbar_mana_full = healthbar_sheet.crop(0, healthbar_height * 2, healthbar_width, healthbar_height);
		healthbar_corner_full = healthbar_sheet.crop(0, healthbar_height * 3, healthbar_width, healthbar_height);

		xpbar_empty = xpbar_sheet.crop(0, 0, 287, 10);
		xpbar_full = xpbar_sheet.crop(0, 10, 287, 10);

		// tiles
		placeholder = tilesheet.crop(0, 0, default_width, default_height);
		blackTile = tilesheet.crop(default_width * 2, 0, default_width, default_height);
		pinkTile = tilesheet.crop(default_width * 3, 0, default_width, default_height);

		wall_topend_corner_TL = tilesheet.crop(default_width * 6, 0, default_width, default_height);
		wall_topend_hz_T_1 = tilesheet.crop(default_width * 7, 0, default_width, default_height);
		wall_topend_hz_T_2 = tilesheet.crop(default_width * 8, 0, default_width, default_height);
		wall_topend_edge_BR = tilesheet.crop(default_width * 9, 0, default_width, default_height);
		wall_topend_edge_BL = tilesheet.crop(default_width * 12, 0, default_width, default_height);
		wall_topend_hz_T_3 = tilesheet.crop(default_width * 13, 0, default_width, default_height);
		wall_topend_hz_T_4 = tilesheet.crop(default_width * 14, 0, default_width, default_height);
		wall_topend_corner_TR = tilesheet.crop(default_width * 15, 0, default_width, default_height);
		wall_topend_vt_L_1 = tilesheet.crop(default_width * 6, default_height * 1, default_width, default_height);
		wall_topend_vt_L_2 = tilesheet.crop(default_width * 6, default_height * 2, default_width, default_height);
		wall_topend_vt_L_3 = tilesheet.crop(default_width * 6, default_height * 3, default_width, default_height);
		wall_topend_vt_L_4 = tilesheet.crop(default_width * 6, default_height * 4, default_width, default_height);
		wall_topend_vt_L_5 = tilesheet.crop(default_width * 6, default_height * 5, default_width, default_height);
		wall_topend_vt_L_6 = tilesheet.crop(default_width * 6, default_height * 6, default_width, default_height);
		wall_topend_vt_R_1 = tilesheet.crop(default_width * 15, default_height * 1, default_width, default_height);
		wall_topend_vt_R_2 = tilesheet.crop(default_width * 15, default_height * 2, default_width, default_height);
		wall_topend_vt_R_3 = tilesheet.crop(default_width * 15, default_height * 3, default_width, default_height);
		wall_topend_vt_R_4 = tilesheet.crop(default_width * 15, default_height * 4, default_width, default_height);
		wall_topend_vt_R_5 = tilesheet.crop(default_width * 15, default_height * 5, default_width, default_height);
		wall_topend_vt_R_6 = tilesheet.crop(default_width * 15, default_height * 6, default_width, default_height);
		wall_topend_corner_BL = tilesheet.crop(default_width * 6, default_height * 7, default_width, default_height);
		wall_topend_hz_B_1 = tilesheet.crop(default_width * 7, default_height * 7, default_width, default_height);
		wall_topend_hz_B_2 = tilesheet.crop(default_width * 8, default_height * 7, default_width, default_height);
		wall_topend_hz_B_3 = tilesheet.crop(default_width * 9, default_height * 7, default_width, default_height);
		wall_topend_hz_B_4 = tilesheet.crop(default_width * 10, default_height * 7, default_width, default_height);
		wall_topend_hz_B_5 = tilesheet.crop(default_width * 11, default_height * 7, default_width, default_height);
		wall_topend_hz_B_6 = tilesheet.crop(default_width * 12, default_height * 7, default_width, default_height);
		wall_topend_hz_B_7 = tilesheet.crop(default_width * 13, default_height * 7, default_width, default_height);
		wall_topend_hz_B_8 = tilesheet.crop(default_width * 14, default_height * 7, default_width, default_height);
		wall_topend_corner_BR = tilesheet.crop(default_width * 15, default_height * 7, default_width, default_height);

		tile_1 = tilesheet.crop(default_width * 0, default_height * 3, default_width, default_height);
		tile_2 = tilesheet.crop(default_width * 0, default_height * 4, default_width, default_height);
		tile_3 = tilesheet.crop(default_width * 17, default_height * 4, default_width, default_height);
		tile_4 = tilesheet.crop(default_width * 17, default_height * 5, default_width, default_height);

		wall_1_1 = tilesheet.crop(default_width * 2, default_height * 1, default_width, default_height);
		wall_1_2 = tilesheet.crop(default_width * 3, default_height * 1, default_width, default_height);
		wall_1_3 = tilesheet.crop(default_width * 4, default_height * 1, default_width, default_height);
		wall_1_4 = tilesheet.crop(default_width * 5, default_height * 1, default_width, default_height);
		wall_1_5 = tilesheet.crop(default_width * 2, default_height * 2, default_width, default_height);
		wall_1_6 = tilesheet.crop(default_width * 3, default_height * 2, default_width, default_height);
		wall_1_7 = tilesheet.crop(default_width * 4, default_height * 2, default_width, default_height);
		wall_1_8 = tilesheet.crop(default_width * 5, default_height * 2, default_width, default_height);
		wall_1_9 = tilesheet.crop(default_width * 2, default_height * 3, default_width, default_height);
		wall_1_10 = tilesheet.crop(default_width * 3, default_height * 3, default_width, default_height);
		wall_1_11 = tilesheet.crop(default_width * 4, default_height * 3, default_width, default_height);
		wall_1_12 = tilesheet.crop(default_width * 5, default_height * 3, default_width, default_height);
		wall_1_13 = tilesheet.crop(default_width * 2, default_height * 4, default_width, default_height);
		wall_1_14 = tilesheet.crop(default_width * 3, default_height * 4, default_width, default_height);
		wall_1_15 = tilesheet.crop(default_width * 4, default_height * 4, default_width, default_height);
		wall_1_16 = tilesheet.crop(default_width * 5, default_height * 4, default_width, default_height);

		wall_2_1 = tilesheet.crop(default_width * 16, default_height * 0, default_width, default_height);
		wall_2_2 = tilesheet.crop(default_width * 17, default_height * 0, default_width, default_height);
		wall_2_3 = tilesheet.crop(default_width * 18, default_height * 0, default_width, default_height);
		wall_2_4 = tilesheet.crop(default_width * 19, default_height * 0, default_width, default_height);
		wall_2_5 = tilesheet.crop(default_width * 16, default_height * 1, default_width, default_height);
		wall_2_6 = tilesheet.crop(default_width * 17, default_height * 1, default_width, default_height);
		wall_2_7 = tilesheet.crop(default_width * 18, default_height * 1, default_width, default_height);
		wall_2_8 = tilesheet.crop(default_width * 19, default_height * 1, default_width, default_height);
		wall_2_9 = tilesheet.crop(default_width * 16, default_height * 2, default_width, default_height);
		wall_2_10 = tilesheet.crop(default_width * 17, default_height * 2, default_width, default_height);
		wall_2_11 = tilesheet.crop(default_width * 18, default_height * 2, default_width, default_height);
		wall_2_12 = tilesheet.crop(default_width * 19, default_height * 2, default_width, default_height);
		wall_2_13 = tilesheet.crop(default_width * 16, default_height * 3, default_width, default_height);
		wall_2_14 = tilesheet.crop(default_width * 17, default_height * 3, default_width, default_height);
		wall_2_15 = tilesheet.crop(default_width * 18, default_height * 3, default_width, default_height);
		wall_2_16 = tilesheet.crop(default_width * 19, default_height * 3, default_width, default_height);

		wall_3_1 = tilesheet.crop(default_width * 20, default_height * 0, default_width, default_height);
		wall_3_2 = tilesheet.crop(default_width * 21, default_height * 0, default_width, default_height);
		wall_3_3 = tilesheet.crop(default_width * 22, default_height * 0, default_width, default_height);
		wall_3_4 = tilesheet.crop(default_width * 23, default_height * 0, default_width, default_height);
		wall_3_5 = tilesheet.crop(default_width * 24, default_height * 0, default_width, default_height);
		wall_3_6 = tilesheet.crop(default_width * 25, default_height * 0, default_width, default_height);
		wall_3_7 = tilesheet.crop(default_width * 26, default_height * 0, default_width, default_height);
		wall_3_8 = tilesheet.crop(default_width * 27, default_height * 0, default_width, default_height);
		wall_3_9 = tilesheet.crop(default_width * 20, default_height * 1, default_width, default_height);
		wall_3_10 = tilesheet.crop(default_width * 21, default_height * 1, default_width, default_height);
		wall_3_11 = tilesheet.crop(default_width * 22, default_height * 1, default_width, default_height);
		wall_3_12 = tilesheet.crop(default_width * 23, default_height * 1, default_width, default_height);
		wall_3_13 = tilesheet.crop(default_width * 24, default_height * 1, default_width, default_height);
		wall_3_14 = tilesheet.crop(default_width * 25, default_height * 1, default_width, default_height);
		wall_3_15 = tilesheet.crop(default_width * 26, default_height * 1, default_width, default_height);
		wall_3_16 = tilesheet.crop(default_width * 27, default_height * 1, default_width, default_height);
		wall_3_17 = tilesheet.crop(default_width * 20, default_height * 2, default_width, default_height);
		wall_3_18 = tilesheet.crop(default_width * 21, default_height * 2, default_width, default_height);
		wall_3_19 = tilesheet.crop(default_width * 22, default_height * 2, default_width, default_height);
		wall_3_20 = tilesheet.crop(default_width * 23, default_height * 2, default_width, default_height);
		wall_3_21 = tilesheet.crop(default_width * 24, default_height * 2, default_width, default_height);
		wall_3_22 = tilesheet.crop(default_width * 25, default_height * 2, default_width, default_height);
		wall_3_23 = tilesheet.crop(default_width * 26, default_height * 2, default_width, default_height);
		wall_3_24 = tilesheet.crop(default_width * 27, default_height * 2, default_width, default_height);
		wall_3_25 = tilesheet.crop(default_width * 20, default_height * 3, default_width, default_height);
		wall_3_26 = tilesheet.crop(default_width * 21, default_height * 3, default_width, default_height);
		wall_3_27 = tilesheet.crop(default_width * 22, default_height * 3, default_width, default_height);
		wall_3_28 = tilesheet.crop(default_width * 23, default_height * 3, default_width, default_height);
		wall_3_29 = tilesheet.crop(default_width * 24, default_height * 3, default_width, default_height);
		wall_3_30 = tilesheet.crop(default_width * 25, default_height * 3, default_width, default_height);
		wall_3_31 = tilesheet.crop(default_width * 26, default_height * 3, default_width, default_height);
		wall_3_32 = tilesheet.crop(default_width * 27, default_height * 3, default_width, default_height);

		wall_4_1 = tilesheet.crop(default_width * 6, default_height * 8, default_width, default_height);
		wall_4_2 = tilesheet.crop(default_width * 7, default_height * 8, default_width, default_height);
		wall_4_3 = tilesheet.crop(default_width * 8, default_height * 8, default_width, default_height);
		wall_4_4 = tilesheet.crop(default_width * 9, default_height * 8, default_width, default_height);
		wall_4_5 = tilesheet.crop(default_width * 10, default_height * 8, default_width, default_height);
		wall_4_6 = tilesheet.crop(default_width * 11, default_height * 8, default_width, default_height);
		wall_4_7 = tilesheet.crop(default_width * 12, default_height * 8, default_width, default_height);
		wall_4_8 = tilesheet.crop(default_width * 13, default_height * 8, default_width, default_height);
		wall_4_9 = tilesheet.crop(default_width * 14, default_height * 8, default_width, default_height);
		wall_4_10 = tilesheet.crop(default_width * 15, default_height * 8, default_width, default_height);
		wall_4_11 = tilesheet.crop(default_width * 6, default_height * 9, default_width, default_height);
		wall_4_12 = tilesheet.crop(default_width * 7, default_height * 9, default_width, default_height);
		wall_4_13 = tilesheet.crop(default_width * 8, default_height * 9, default_width, default_height);
		wall_4_14 = tilesheet.crop(default_width * 9, default_height * 9, default_width, default_height);
		wall_4_15 = tilesheet.crop(default_width * 10, default_height * 9, default_width, default_height);
		wall_4_16 = tilesheet.crop(default_width * 11, default_height * 9, default_width, default_height);
		wall_4_17 = tilesheet.crop(default_width * 12, default_height * 9, default_width, default_height);
		wall_4_18 = tilesheet.crop(default_width * 13, default_height * 9, default_width, default_height);
		wall_4_19 = tilesheet.crop(default_width * 14, default_height * 9, default_width, default_height);
		wall_4_20 = tilesheet.crop(default_width * 15, default_height * 9, default_width, default_height);
		wall_4_21 = tilesheet.crop(default_width * 6, default_height * 10, default_width, default_height);
		wall_4_22 = tilesheet.crop(default_width * 7, default_height * 10, default_width, default_height);
		wall_4_23 = tilesheet.crop(default_width * 8, default_height * 10, default_width, default_height);
		wall_4_24 = tilesheet.crop(default_width * 9, default_height * 10, default_width, default_height);
		wall_4_25 = tilesheet.crop(default_width * 10, default_height * 10, default_width, default_height);
		wall_4_26 = tilesheet.crop(default_width * 11, default_height * 10, default_width, default_height);
		wall_4_27 = tilesheet.crop(default_width * 12, default_height * 10, default_width, default_height);
		wall_4_28 = tilesheet.crop(default_width * 13, default_height * 10, default_width, default_height);
		wall_4_29 = tilesheet.crop(default_width * 14, default_height * 10, default_width, default_height);
		wall_4_30 = tilesheet.crop(default_width * 15, default_height * 10, default_width, default_height);

		window_1_1 = tilesheet.crop(default_width * 30, default_height * 0, default_width, default_height);
		window_1_2 = tilesheet.crop(default_width * 31, default_height * 0, default_width, default_height);
		window_1_3 = tilesheet.crop(default_width * 28, default_height * 1, default_width, default_height);
		window_1_4 = tilesheet.crop(default_width * 29, default_height * 1, default_width, default_height);
		window_1_5 = tilesheet.crop(default_width * 30, default_height * 1, default_width, default_height);
		window_1_6 = tilesheet.crop(default_width * 31, default_height * 1, default_width, default_height);
		window_1_7 = tilesheet.crop(default_width * 32, default_height * 1, default_width, default_height);
		window_1_8 = tilesheet.crop(default_width * 33, default_height * 1, default_width, default_height);
		window_1_9 = tilesheet.crop(default_width * 28, default_height * 2, default_width, default_height);
		window_1_10 = tilesheet.crop(default_width * 29, default_height * 2, default_width, default_height);
		window_1_11 = tilesheet.crop(default_width * 30, default_height * 2, default_width, default_height);
		window_1_12 = tilesheet.crop(default_width * 31, default_height * 2, default_width, default_height);
		window_1_13 = tilesheet.crop(default_width * 32, default_height * 2, default_width, default_height);
		window_1_14 = tilesheet.crop(default_width * 33, default_height * 2, default_width, default_height);
		window_1_15 = tilesheet.crop(default_width * 29, default_height * 3, default_width, default_height);
		window_1_16 = tilesheet.crop(default_width * 30, default_height * 3, default_width, default_height);
		window_1_17 = tilesheet.crop(default_width * 31, default_height * 3, default_width, default_height);
		window_1_18 = tilesheet.crop(default_width * 32, default_height * 3, default_width, default_height);
		window_1_19 = tilesheet.crop(default_width * 29, default_height * 4, default_width, default_height);
		window_1_20 = tilesheet.crop(default_width * 30, default_height * 4, default_width, default_height);
		window_1_21 = tilesheet.crop(default_width * 31, default_height * 4, default_width, default_height);
		window_1_22 = tilesheet.crop(default_width * 32, default_height * 4, default_width, default_height);
		window_1_23 = tilesheet.crop(default_width * 29, default_height * 5, default_width, default_height);
		window_1_24 = tilesheet.crop(default_width * 30, default_height * 5, default_width, default_height);
		window_1_25 = tilesheet.crop(default_width * 31, default_height * 5, default_width, default_height);
		window_1_26 = tilesheet.crop(default_width * 32, default_height * 5, default_width, default_height);

		// TODO

		wall_botend_edge_TL_1 = tilesheet.crop(default_width * 5, default_height * 5, default_width, default_height);
		wall_botend_vt_L_1 = tilesheet.crop(default_width * 5, default_height * 6, default_width, default_height);
		wall_botend_vt_L_2 = tilesheet.crop(default_width * 5, default_height * 7, default_width, default_height);
		wall_botend_corner_TR_1 = tilesheet.crop(default_width * 5, default_height * 8, default_width, default_height);
		wall_botend_vt_L_3 = tilesheet.crop(default_width * 5, default_height * 9, default_width, default_height);
		wall_botend_vt_L_4 = tilesheet.crop(default_width * 5, default_height * 10, default_width, default_height);
		wall_botend_edge_BL_1 = tilesheet.crop(default_width * 5, default_height * 11, default_width, default_height);
		wall_botend_hz_B_1 = tilesheet.crop(default_width * 6, default_height * 11, default_width, default_height);
		wall_botend_hz_B_2 = tilesheet.crop(default_width * 7, default_height * 11, default_width, default_height);

		wall_botend_edge_TR_1 = tilesheet.crop(default_width * 16, default_height * 5, default_width, default_height);
		wall_botend_vt_R_1 = tilesheet.crop(default_width * 16, default_height * 6, default_width, default_height);
		wall_botend_vt_R_2 = tilesheet.crop(default_width * 16, default_height * 7, default_width, default_height);
		wall_botend_corner_TL_1 = tilesheet.crop(default_width * 16, default_height * 8, default_width, default_height);
		wall_botend_vt_R_3 = tilesheet.crop(default_width * 16, default_height * 9, default_width, default_height);
		wall_botend_vt_R_4 = tilesheet.crop(default_width * 16, default_height * 10, default_width, default_height);
		wall_botend_edge_BR_1 = tilesheet.crop(default_width * 16, default_height * 11, default_width, default_height);

		// TODO

		floor_1_1 = tilesheet.crop(default_width * 0, default_height * 19, default_width, default_height);
		floor_1_2 = tilesheet.crop(default_width * 1, default_height * 19, default_width, default_height);
		floor_1_3 = tilesheet.crop(default_width * 0, default_height * 20, default_width, default_height);
		floor_1_4 = tilesheet.crop(default_width * 1, default_height * 20, default_width, default_height);

		floor_2_1 = tilesheet.crop(default_width * 2, default_height * 19, default_width, default_height);
		floor_2_2 = tilesheet.crop(default_width * 3, default_height * 19, default_width, default_height);
		floor_2_3 = tilesheet.crop(default_width * 2, default_height * 20, default_width, default_height);
		floor_2_4 = tilesheet.crop(default_width * 3, default_height * 20, default_width, default_height);

		player_down = new BufferedImage[5];
		player_up = new BufferedImage[5];
		player_right = new BufferedImage[6];
		player_left = new BufferedImage[6];
		player_idleUp = new BufferedImage[1];
		player_idleDown = new BufferedImage[4];
		player_idleLeft = new BufferedImage[1];
		player_idleRight = new BufferedImage[1];

		player_attack_down = new BufferedImage[3];
		player_attack_up = new BufferedImage[3];
		player_attack_left = new BufferedImage[3];
		player_attack_right = new BufferedImage[3];

		wizard_down = new BufferedImage[4];
		wizard_up = new BufferedImage[4];
		wizard_right = new BufferedImage[4];
		wizard_left = new BufferedImage[4];
		wizard_idle = new BufferedImage[1];

		jina_down = new BufferedImage[4];
		jina_up = new BufferedImage[4];
		jina_right = new BufferedImage[4];
		jina_left = new BufferedImage[4];
		jina_idleUp = new BufferedImage[1];
		jina_idleDown = new BufferedImage[1];
		jina_idleLeft = new BufferedImage[1];
		jina_idleRight = new BufferedImage[1];

		sorcerer_down = new BufferedImage[1];
		sorcerer_up = new BufferedImage[1];
		sorcerer_right = new BufferedImage[3];
		sorcerer_left = new BufferedImage[3];
		sorcerer_idleLeft = new BufferedImage[6];
		sorcerer_idleRight = new BufferedImage[6];

		sorcerer_death_left = new BufferedImage[10];
		sorcerer_death_right = new BufferedImage[10];
		sorcerer_attack_left = new BufferedImage[10];
		sorcerer_attack_right = new BufferedImage[10];

		hermit_down = new BufferedImage[2];
		hermit_up = new BufferedImage[2];
		hermit_right = new BufferedImage[2];
		hermit_left = new BufferedImage[2];
		hermit_idle = new BufferedImage[1];

		player_down[0] = player_sheet.crop(player_sheet_width * 4, 0, player_sheet_width, player_sheet_height);
		player_down[1] = player_sheet.crop(player_sheet_width * 5, 0, player_sheet_width, player_sheet_height);
		player_down[2] = player_sheet.crop(player_sheet_width * 6, 0, player_sheet_width, player_sheet_height);
		player_down[3] = player_sheet.crop(player_sheet_width * 7, 0, player_sheet_width, player_sheet_height);
		player_down[4] = player_sheet.crop(player_sheet_width * 0, player_sheet_height, player_sheet_width,
				player_sheet_height);

		player_right[0] = player_sheet.crop(player_sheet_width * 6, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		player_right[1] = player_sheet.crop(player_sheet_width * 7, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		player_right[2] = player_sheet.crop(player_sheet_width * 0, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		player_right[3] = player_sheet.crop(player_sheet_width * 1, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		player_right[4] = player_sheet.crop(player_sheet_width * 2, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		player_right[5] = player_sheet.crop(player_sheet_width * 3, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);

		player_up[0] = player_sheet.crop(player_sheet_width * 1, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		player_up[1] = player_sheet.crop(player_sheet_width * 2, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		player_up[2] = player_sheet.crop(player_sheet_width * 3, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		player_up[3] = player_sheet.crop(player_sheet_width * 4, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		player_up[4] = player_sheet.crop(player_sheet_width * 5, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);

		player_left[0] = player_sheet.crop(player_sheet_width * 4, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		player_left[1] = player_sheet.crop(player_sheet_width * 5, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		player_left[2] = player_sheet.crop(player_sheet_width * 6, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		player_left[3] = player_sheet.crop(player_sheet_width * 7, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		player_left[4] = player_sheet.crop(player_sheet_width * 0, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		player_left[5] = player_sheet.crop(player_sheet_width * 1, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);

		player_idleUp[0] = player_sheet.crop(player_sheet_width * 6, player_sheet_height * 4, player_sheet_width,
				player_sheet_height);

		player_idleDown[0] = player_sheet.crop(player_sheet_width * 0, player_sheet_height * 0, player_sheet_width,
				player_sheet_height);
		player_idleDown[1] = player_sheet.crop(player_sheet_width * 1, player_sheet_height * 0, player_sheet_width,
				player_sheet_height);
		player_idleDown[2] = player_sheet.crop(player_sheet_width * 2, player_sheet_height * 0, player_sheet_width,
				player_sheet_height);
		player_idleDown[3] = player_sheet.crop(player_sheet_width * 3, player_sheet_height * 0, player_sheet_width,
				player_sheet_height);

		player_idleLeft[0] = player_sheet.crop(player_sheet_width * 4, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		player_idleRight[0] = player_sheet.crop(player_sheet_width * 6, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);

		player_attack_down[0] = player_sheet.crop(player_sheet_width * 2, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		player_attack_down[1] = player_sheet.crop(player_sheet_width * 3, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		player_attack_down[2] = player_sheet.crop(player_sheet_width * 4, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		player_attack_up[0] = player_sheet.crop(player_sheet_width * 5, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		player_attack_up[1] = player_sheet.crop(player_sheet_width * 6, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		player_attack_up[2] = player_sheet.crop(player_sheet_width * 7, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		player_attack_right[0] = player_sheet.crop(player_sheet_width * 0, player_sheet_height * 4, player_sheet_width,
				player_sheet_height);
		player_attack_right[1] = player_sheet.crop(player_sheet_width * 1, player_sheet_height * 4, player_sheet_width,
				player_sheet_height);
		player_attack_right[2] = player_sheet.crop(player_sheet_width * 2, player_sheet_height * 4, player_sheet_width,
				player_sheet_height);
		player_attack_left[0] = player_sheet.crop(player_sheet_width * 3, player_sheet_height * 4, player_sheet_width,
				player_sheet_height);
		player_attack_left[1] = player_sheet.crop(player_sheet_width * 4, player_sheet_height * 4, player_sheet_width,
				player_sheet_height);
		player_attack_left[2] = player_sheet.crop(player_sheet_width * 5, player_sheet_height * 4, player_sheet_width,
				player_sheet_height);

		wizard_down[0] = wizard_sheet.crop(player_sheet_small_width * 0, 0, player_sheet_small_width,
				player_sheet_small_height);
		wizard_down[1] = wizard_sheet.crop(player_sheet_small_width * 1, 0, player_sheet_small_width,
				player_sheet_small_height);
		wizard_up[0] = wizard_sheet.crop(player_sheet_small_width * 2, 0, player_sheet_small_width,
				player_sheet_small_height);
		wizard_up[1] = wizard_sheet.crop(player_sheet_small_width * 3, 0, player_sheet_small_width,
				player_sheet_small_height);

		wizard_right[0] = wizard_sheet.crop(player_sheet_small_width * 0, player_sheet_small_height * 1,
				player_sheet_small_width, player_sheet_small_height);
		wizard_right[1] = wizard_sheet.crop(player_sheet_small_width * 1, player_sheet_small_height * 1,
				player_sheet_small_width, player_sheet_small_height);
		wizard_left[0] = wizard_sheet.crop(player_sheet_small_width * 2, player_sheet_small_height * 1,
				player_sheet_small_width, player_sheet_small_height);
		wizard_left[1] = wizard_sheet.crop(player_sheet_small_width * 3, player_sheet_small_height * 1,
				player_sheet_small_width, player_sheet_small_height);

		wizard_idle[0] = wizard_sheet.crop(player_sheet_small_width * 0, player_sheet_small_height * 2,
				player_sheet_small_width, player_sheet_small_height);

//		jina_down[0] = jina_sheet.crop(player_sheet_width * 0, 0, player_sheet_width, player_sheet_height);
//		jina_down[1] = jina_sheet.crop(player_sheet_width * 1, 0, player_sheet_width, player_sheet_height);
//		jina_down[2] = jina_sheet.crop(player_sheet_width * 2, 0, player_sheet_width, player_sheet_height);
//		jina_down[3] = jina_sheet.crop(player_sheet_width * 3, 0, player_sheet_width, player_sheet_height);
//
//		jina_right[0] = jina_sheet.crop(player_sheet_width * 0, player_sheet_height * 1, player_sheet_width,
//				player_sheet_height);
//		jina_right[1] = jina_sheet.crop(player_sheet_width * 1, player_sheet_height * 1, player_sheet_width,
//				player_sheet_height);
//		jina_right[2] = jina_sheet.crop(player_sheet_width * 2, player_sheet_height * 1, player_sheet_width,
//				player_sheet_height);
//		jina_right[3] = jina_sheet.crop(player_sheet_width * 3, player_sheet_height * 1, player_sheet_width,
//				player_sheet_height);
//
//		jina_up[0] = jina_sheet.crop(player_sheet_width * 0, player_sheet_height * 2, player_sheet_width,
//				player_sheet_height);
//		jina_up[1] = jina_sheet.crop(player_sheet_width * 1, player_sheet_height * 2, player_sheet_width,
//				player_sheet_height);
//		jina_up[2] = jina_sheet.crop(player_sheet_width * 2, player_sheet_height * 2, player_sheet_width,
//				player_sheet_height);
//		jina_up[3] = jina_sheet.crop(player_sheet_width * 3, player_sheet_height * 2, player_sheet_width,
//				player_sheet_height);
//
//		jina_left[0] = jina_sheet.crop(player_sheet_width * 0, player_sheet_height * 3, player_sheet_width,
//				player_sheet_height);
//		jina_left[1] = jina_sheet.crop(player_sheet_width * 1, player_sheet_height * 3, player_sheet_width,
//				player_sheet_height);
//		jina_left[2] = jina_sheet.crop(player_sheet_width * 2, player_sheet_height * 3, player_sheet_width,
//				player_sheet_height);
//		jina_left[3] = jina_sheet.crop(player_sheet_width * 3, player_sheet_height * 3, player_sheet_width,
//				player_sheet_height);
//
//		jina_idleUp[0] = jina_sheet.crop(player_sheet_width * 0, player_sheet_height * 2, player_sheet_width,
//				player_sheet_height);
//		jina_idleDown[0] = jina_sheet.crop(player_sheet_width * 0, player_sheet_height * 0, player_sheet_width,
//				player_sheet_height);
//		jina_idleLeft[0] = jina_sheet.crop(player_sheet_width * 0, player_sheet_height * 3, player_sheet_width,
//				player_sheet_height);
//		jina_idleRight[0] = jina_sheet.crop(player_sheet_width * 0, player_sheet_height * 1, player_sheet_width,
//				player_sheet_height);

		sorcerer_down[0] = sorcerer_sheet.crop(sorcerer_sheet_width * 8, sorcerer_sheet_height*2, sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_up[0] = sorcerer_sheet.crop(sorcerer_sheet_width * 7, sorcerer_sheet_height*2, sorcerer_sheet_width, sorcerer_sheet_height);

		sorcerer_right[0] = sorcerer_sheet.crop(sorcerer_sheet_width * 0, sorcerer_sheet_height * 3,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_right[1] = sorcerer_sheet.crop(sorcerer_sheet_width * 1, sorcerer_sheet_height * 3,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_right[2] = sorcerer_sheet.crop(sorcerer_sheet_width * 2, sorcerer_sheet_height * 3,
				sorcerer_sheet_width, sorcerer_sheet_height);

		sorcerer_left[0] = sorcerer_sheet.crop(sorcerer_sheet_width * 5, sorcerer_sheet_height * 2,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_left[1] = sorcerer_sheet.crop(sorcerer_sheet_width * 4, sorcerer_sheet_height * 2,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_left[2] = sorcerer_sheet.crop(sorcerer_sheet_width * 3, sorcerer_sheet_height * 2,
				sorcerer_sheet_width, sorcerer_sheet_height);

		sorcerer_idleLeft[0] = sorcerer_sheet.crop(sorcerer_sheet_width * 4, sorcerer_sheet_height * 0,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_idleLeft[1] = sorcerer_sheet.crop(sorcerer_sheet_width * 5, sorcerer_sheet_height * 0,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_idleLeft[2] = sorcerer_sheet.crop(sorcerer_sheet_width * 6, sorcerer_sheet_height * 0,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_idleLeft[3] = sorcerer_sheet.crop(sorcerer_sheet_width * 7, sorcerer_sheet_height * 0,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_idleLeft[4] = sorcerer_sheet.crop(sorcerer_sheet_width * 8, sorcerer_sheet_height * 0,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_idleLeft[5] = sorcerer_sheet.crop(sorcerer_sheet_width * 9, sorcerer_sheet_height * 0,
				sorcerer_sheet_width, sorcerer_sheet_height);

		sorcerer_idleRight[0] = sorcerer_sheet.crop(sorcerer_sheet_width * 5, sorcerer_sheet_height * 1,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_idleRight[1] = sorcerer_sheet.crop(sorcerer_sheet_width * 4, sorcerer_sheet_height * 1,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_idleRight[2] = sorcerer_sheet.crop(sorcerer_sheet_width * 3, sorcerer_sheet_height * 1,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_idleRight[3] = sorcerer_sheet.crop(sorcerer_sheet_width * 2, sorcerer_sheet_height * 1,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_idleRight[4] = sorcerer_sheet.crop(sorcerer_sheet_width * 1, sorcerer_sheet_height * 1,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_idleRight[5] = sorcerer_sheet.crop(sorcerer_sheet_width * 0, sorcerer_sheet_height * 1,
				sorcerer_sheet_width, sorcerer_sheet_height);

		sorcerer_attack_left[0] = sorcerer_sheet.crop(sorcerer_sheet_width * 0, sorcerer_sheet_height * 4,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_left[1] = sorcerer_sheet.crop(sorcerer_sheet_width * 1, sorcerer_sheet_height * 4,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_left[2] = sorcerer_sheet.crop(sorcerer_sheet_width * 2, sorcerer_sheet_height * 4,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_left[3] = sorcerer_sheet.crop(sorcerer_sheet_width * 3, sorcerer_sheet_height * 4,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_left[4] = sorcerer_sheet.crop(sorcerer_sheet_width * 4, sorcerer_sheet_height * 4,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_left[5] = sorcerer_sheet.crop(sorcerer_sheet_width * 5, sorcerer_sheet_height * 4,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_left[6] = sorcerer_sheet.crop(sorcerer_sheet_width * 6, sorcerer_sheet_height * 4,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_left[7] = sorcerer_sheet.crop(sorcerer_sheet_width * 7, sorcerer_sheet_height * 4,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_left[8] = sorcerer_sheet.crop(sorcerer_sheet_width * 8, sorcerer_sheet_height * 4,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_left[9] = sorcerer_sheet.crop(sorcerer_sheet_width * 9, sorcerer_sheet_height * 4,
				sorcerer_sheet_width, sorcerer_sheet_height);

		sorcerer_attack_right[0] = sorcerer_sheet.crop(sorcerer_sheet_width * 9, sorcerer_sheet_height * 5,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_right[1] = sorcerer_sheet.crop(sorcerer_sheet_width * 8, sorcerer_sheet_height * 5,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_right[2] = sorcerer_sheet.crop(sorcerer_sheet_width * 7, sorcerer_sheet_height * 5,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_right[3] = sorcerer_sheet.crop(sorcerer_sheet_width * 6, sorcerer_sheet_height * 5,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_right[4] = sorcerer_sheet.crop(sorcerer_sheet_width * 5, sorcerer_sheet_height * 5,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_right[5] = sorcerer_sheet.crop(sorcerer_sheet_width * 4, sorcerer_sheet_height * 5,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_right[6] = sorcerer_sheet.crop(sorcerer_sheet_width * 3, sorcerer_sheet_height * 5,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_right[7] = sorcerer_sheet.crop(sorcerer_sheet_width * 2, sorcerer_sheet_height * 5,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_right[8] = sorcerer_sheet.crop(sorcerer_sheet_width * 1, sorcerer_sheet_height * 5,
				sorcerer_sheet_width, sorcerer_sheet_height);
		sorcerer_attack_right[9] = sorcerer_sheet.crop(sorcerer_sheet_width * 0, sorcerer_sheet_height * 5,
				sorcerer_sheet_width, sorcerer_sheet_height);

//		hermit_down[0] = hermit_sheet.crop(player_sheet_small_width * 0, 0, player_sheet_small_width,
//				player_sheet_small_height);
//		hermit_down[1] = hermit_sheet.crop(player_sheet_small_width * 1, 0, player_sheet_small_width,
//				player_sheet_small_height);
//		hermit_up[0] = hermit_sheet.crop(player_sheet_small_width * 2, 0, player_sheet_small_width,
//				player_sheet_small_height);
//		hermit_up[1] = hermit_sheet.crop(player_sheet_small_width * 3, 0, player_sheet_small_width,
//				player_sheet_small_height);
//		hermit_right[0] = hermit_sheet.crop(player_sheet_small_width * 0, player_sheet_small_height,
//				player_sheet_small_width, player_sheet_small_height);
//		hermit_right[1] = hermit_sheet.crop(player_sheet_small_width * 1, player_sheet_small_height,
//				player_sheet_small_width, player_sheet_small_height);
//		hermit_left[0] = hermit_sheet.crop(player_sheet_small_width * 2, player_sheet_small_height,
//				player_sheet_small_width, player_sheet_small_height);
//		hermit_left[1] = hermit_sheet.crop(player_sheet_small_width * 3, player_sheet_small_height,
//				player_sheet_small_width, player_sheet_small_height);
//		hermit_idle[0] = hermit_sheet.crop(player_sheet_small_width * 0, player_sheet_small_height * 2,
//				player_sheet_small_width, player_sheet_small_height);

	}

}
