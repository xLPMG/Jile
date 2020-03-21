package me.lpmg.jile.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

	private static final int default_width = 16, default_height = 16;
	private static final int default_big_width = 32, default_big_height = 32;
	private static final int player_sheet_width = 16, player_sheet_height = 32;
	private static final int player_sheet_small_width = 16, player_sheet_small_height = 23;
	private static final int log_sheet_width = 32, log_sheet_height = 32;
	private static final int wall_sheet_width = 16, wall_sheet_height = 16;
	private static final int building_exterior_width = 20, building_exterior_height = 20;
	private static final int healthbar_width = 64, healthbar_height = 10;

	public static Font font9, font14, font16, font28, font32, font48, font96;

	public static BufferedImage parallax_mountain_bg, parallax_mountain_clouds, parallax_mountain_foreground_trees,
			parallax_mountain_mountain_far, parallax_mountain_mountains, parallax_mountain_trees;

	public static BufferedImage placeholder,blackTile,pinkTile,debugTile,stone_wall_top,grass_full,dirt_full,grass_puddle,empty_14,stone_wall_bottom,empty_16,plant_rose,plant_berries,plant_grass_1,plant_grass_2,
	grass_dirt_SR,grass_dirt_ST,grass_dirt_CBR,grass_dirt_CBL,dirt_grass_CTL,dirt_grass_CTR,plant_flower_1,plant_flower_2,plant_flower_3,plant_flower_4,grass_dirt_SL,grass_dirt_SB,grass_dirt_CTR,
	grass_dirt_CTL,dirt_grass_CBL,dirt_grass_CBR,pebble,rock_small,hole,gravestone,darkGrass_full,darkDirt_full,darkGrass_puddle_1,darkGrass_puddle_2,darkGrass_puddle_3,plant_log_stem,grass_darkGrass_CTL,
	grass_darkGrass_CTR,grass_darkGrass_CBL,grass_darkGrass_CBR,darkGrass_dirt_SR,darkGrass_dirt_ST,darkGrass_dirt_CBR,darkGrass_dirt_CBL,darkDirt_darkGrass_CTL,darkDirt_darkGrass_CTR,darkGrass_grass_SR,
	darkGrass_grass_ST,darkGrass_grass_CBR,darkGrass_grass_CBL,darkGrass_darkDirt_SL,darkGrass_darkDirt_SB,darkGrass_darkDirt_CTR,darkGrass_darkDirt_CTL,darkDirt_darkGrass_CBL,darkDirt_darkGrass_CBR,
	darkGrass_grass_SL,darkGrass_grass_SB,darkGrass_grass_CTR,darkGrass_grass_CTL;
	
	public static BufferedImage leaf_1,leaf_2,leaf_3,leaf_4,leaf_5,leaf_6,tree_1_1,tree_1_2,tree_1_3,tree_1_4,leaf_7,leaf_8,leaf_9,leaf_10,log_small,empty_86,
	tree_1_5,tree_1_6,tree_1_7,tree_1_8,leaf_11,leaf_12,leaf_13,leaf_14,empty_95,tree_1_9,tree_1_10,tree_1_11,tree_1_12,tree_1_13,leaf_15,leaf_16,leaf_17,
	leaf_18,leaf_19,leaf_20,tree_1_14,tree_1_15,tree_1_16,tree_1_17,leaf_21,leaf_22,leaf_23,leaf_24,leaf_25,leaf_26,empty_117,empty_118,tree_1_18,tree_1_19,
	leaf_27,leaf_28,leaf_29,leaf_30,leaf_31,empty_126,tree_1_20,tree_1_21,tree_1_22,tree_1_23,leaf_32,leaf_33,leaf_34,leaf_35,leaf_36,empty_136,tree_1_24,
	tree_1_25,tree_1_26,tree_1_27,leaf_37,leaf_38,leaf_39,leaf_40,leaf_41,empty_146,empty_147,empty_148,tree_2_1,empty_150,leaf_42,leaf_43,leaf_44,leaf_45,leaf_46,
	empty_156,empty_157,empty_158,tree_2_2,empty_160,empty_161,leaf_47,leaf_48,leaf_49,leaf_50,empty_166,empty_167,tree_2_3,tree_2_4,tree_2_5,empty_171,
	empty_172,empty_173,empty_174,empty_175,empty_176,empty_177,tree_2_6,tree_2_7,tree_2_8;
	
	public static BufferedImage dirt_wall_left_shadow, dirt_wall_left_bottom, dirt_wall_left_body_low,
			dirt_wall_left_body_high, dirt_wall_left_top_low, dirt_wall_left_top_middle, dirt_wall_left_top_high;
	public static BufferedImage dirt_wall_middle_shadow, dirt_wall_middle_bottom, dirt_wall_middle_body_low,
			dirt_wall_middle_body_high, dirt_wall_middle_top_low, dirt_wall_middle_top_middle,
			dirt_wall_middle_top_high;
	public static BufferedImage dirt_wall_right_shadow, dirt_wall_right_bottom, dirt_wall_right_body_low,
			dirt_wall_right_body_high, dirt_wall_right_top_low, dirt_wall_right_top_middle, dirt_wall_right_top_high;

	public static BufferedImage bush, bush_dmg1, bush_dmg2, bush_dmg3;
	public static BufferedImage rock, rock_dmg1, rock_dmg2, rock_dmg3;

	public static BufferedImage[] player_down, player_up, player_left, player_right, player_idleUp, player_idleDown,
			player_idleLeft, player_idleRight, player_attack_down, player_attack_up, player_attack_left,
			player_attack_right;
	public static BufferedImage[] wizard_down, wizard_up, wizard_left, wizard_right, wizard_idle;
	public static BufferedImage[] jina_down, jina_up, jina_left, jina_right, jina_idleUp, jina_idleDown, jina_idleLeft,
			jina_idleRight;
	public static BufferedImage[] log_down, log_up, log_left, log_right, log_idle;
	public static BufferedImage[] hermit_down, hermit_up, hermit_left, hermit_right, hermit_idle;

	public static BufferedImage fence_hz, fence_vt, fence_hL, fence_hR, fence_CBL, fence_CBR, fence_CTL, fence_CTR;
	public static BufferedImage hedge_hzB, hedge_hzT, hedge_vtL, hedge_vtR, hedge_CBL, hedge_CBR, hedge_CTL, hedge_CTR,
			hedge_plain, hedge_plainCBL, hedge_plainCBR, hedge_plainCTL, hedge_plainCTR;

	public static BufferedImage[] btn_start, btn_buy, btn_sell, btn_remove, btn_build;
	public static BufferedImage btn_equip, btn_unequip;
	public static BufferedImage inventoryScreen, itemBar, itemBar_highlighted, statsGUI_full, statsGUI_prev;
	public static BufferedImage wizardBuyMenu, wizardSellMenu;
	public static BufferedImage healthbar, healthbar_empty, healthbar_health_full, healthbar_mana_full,
			healthbar_corner_full, money_bar, background_plain, background_plain_small, checkbox_off, checkbox_on;
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

		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet_new.png"));

		SpriteSheet player_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player_sheet.png"));
		SpriteSheet wizard_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/wizard_sheet.png"));
		SpriteSheet jina_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/jina_sheet.png"));
		SpriteSheet log_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/log_sheet.png"));
		SpriteSheet hermit_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/hermit_sheet.png"));

		SpriteSheet outdoors_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/outdoors_sheet_2.png"));
		SpriteSheet wall_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/walls_sheet_new.png"));

		SpriteSheet item_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/item_sheet.png"));
		SpriteSheet static_entities_sheet = new SpriteSheet(
				ImageLoader.loadImage("/textures/static_entities_sheet_new.png"));

		SpriteSheet buildings_exterior_sheet = new SpriteSheet(
				ImageLoader.loadImage("/textures/buildings_exterior_sheet.png"));
		SpriteSheet buildings_interior_sheet = new SpriteSheet(
				ImageLoader.loadImage("/textures/buildings_interior_sheet.png"));

		SpriteSheet healthbar_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/healthbar_sheet.png"));
		SpriteSheet startBtn = new SpriteSheet(ImageLoader.loadImage("/textures/button_start.png"));
		SpriteSheet wizardBtn = new SpriteSheet(ImageLoader.loadImage("/textures/button_wizard.png"));
		SpriteSheet itemMenuBtn = new SpriteSheet(ImageLoader.loadImage("/textures/button_itemMenu.png"));
		SpriteSheet equipBtn = new SpriteSheet(ImageLoader.loadImage("/textures/button_Equip.png"));
		
		parallax_mountain_bg = ImageLoader.loadImage("/textures/mountains/parallax-mountain-bg.png");
		parallax_mountain_clouds = ImageLoader.loadImage("/textures/mountains/parallax-mountain-clouds.png");
		parallax_mountain_foreground_trees = ImageLoader.loadImage("/textures/mountains/parallax-mountain-foreground-trees.png");
		parallax_mountain_mountain_far = ImageLoader.loadImage("/textures/mountains/parallax-mountain-mountain-far.png");
		parallax_mountain_mountains = ImageLoader.loadImage("/textures/mountains/parallax-mountain-mountains.png");
		parallax_mountain_trees = ImageLoader.loadImage("/textures/mountains/parallax-mountain-trees.png");
		
		inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");
		itemBar = ImageLoader.loadImage("/textures/item_bar.png");
		itemBar_highlighted = ImageLoader.loadImage("/textures/item_bar_highlighted.png");
		wizardBuyMenu = ImageLoader.loadImage("/textures/wizardBuyMenu.png");
		wizardSellMenu = ImageLoader.loadImage("/textures/wizardSellMenu.png");
		statsGUI_full = ImageLoader.loadImage("/textures/statsGUI_full.png");
		statsGUI_prev = ImageLoader.loadImage("/textures/statsGUI_prev.png");
		coin = ImageLoader.loadImage("/textures/coin.png");
		money_bar = ImageLoader.loadImage("/textures/money_bar.png");
		background_plain = ImageLoader.loadImage("/textures/background_plain.png");
		background_plain_small = ImageLoader.loadImage("/textures/background_plain_small.png");
		checkbox_off = ImageLoader.loadImage("/textures/checkbox_off.png");
		checkbox_on = ImageLoader.loadImage("/textures/checkbox_on.png");
		speechToast = ImageLoader.loadImage("/textures/speechToast.png");
		dialogue_arrow = ImageLoader.loadImage("/textures/dialogue_arrow.png");

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

		player_down = new BufferedImage[4];
		player_up = new BufferedImage[4];
		player_right = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_idleUp = new BufferedImage[1];
		player_idleDown = new BufferedImage[1];
		player_idleLeft = new BufferedImage[1];
		player_idleRight = new BufferedImage[1];

		player_attack_down = new BufferedImage[1];
		player_attack_up = new BufferedImage[1];
		player_attack_left = new BufferedImage[1];
		player_attack_right = new BufferedImage[1];

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

		log_down = new BufferedImage[2];
		log_up = new BufferedImage[2];
		log_right = new BufferedImage[2];
		log_left = new BufferedImage[2];
		log_idle = new BufferedImage[1];

		hermit_down = new BufferedImage[2];
		hermit_up = new BufferedImage[2];
		hermit_right = new BufferedImage[2];
		hermit_left = new BufferedImage[2];
		hermit_idle = new BufferedImage[1];

		player_down[0] = player_sheet.crop(player_sheet_width * 0, 0, player_sheet_width, player_sheet_height);
		player_down[1] = player_sheet.crop(player_sheet_width * 1, 0, player_sheet_width, player_sheet_height);
		player_down[2] = player_sheet.crop(player_sheet_width * 2, 0, player_sheet_width, player_sheet_height);
		player_down[3] = player_sheet.crop(player_sheet_width * 3, 0, player_sheet_width, player_sheet_height);

		player_right[0] = player_sheet.crop(player_sheet_width * 0, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		player_right[1] = player_sheet.crop(player_sheet_width * 1, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		player_right[2] = player_sheet.crop(player_sheet_width * 2, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		player_right[3] = player_sheet.crop(player_sheet_width * 3, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);

		player_up[0] = player_sheet.crop(player_sheet_width * 0, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		player_up[1] = player_sheet.crop(player_sheet_width * 1, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		player_up[2] = player_sheet.crop(player_sheet_width * 2, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		player_up[3] = player_sheet.crop(player_sheet_width * 3, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);

		player_left[0] = player_sheet.crop(player_sheet_width * 0, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		player_left[1] = player_sheet.crop(player_sheet_width * 1, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		player_left[2] = player_sheet.crop(player_sheet_width * 2, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		player_left[3] = player_sheet.crop(player_sheet_width * 3, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);

		player_idleUp[0] = player_sheet.crop(player_sheet_width * 0, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		player_idleDown[0] = player_sheet.crop(player_sheet_width * 0, player_sheet_height * 0, player_sheet_width,
				player_sheet_height);
		player_idleLeft[0] = player_sheet.crop(player_sheet_width * 0, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		player_idleRight[0] = player_sheet.crop(player_sheet_width * 0, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);

//		player_attack_down[0] = player_sheet.crop(player_sheet_width * 0, player_sheet_height * 3, player_sheet_width,
//				player_sheet_height);
//		player_attack_up[0] = player_sheet.crop(player_sheet_width * 1, player_sheet_height * 3, player_sheet_width,
//				player_sheet_height);
//		player_attack_right[0] = player_sheet.crop(player_sheet_width * 2, player_sheet_height * 3, player_sheet_width,
//				player_sheet_height);
//		player_attack_left[0] = player_sheet.crop(player_sheet_width * 3, player_sheet_height * 3, player_sheet_width,
//				player_sheet_height);

		wizard_down[0] = wizard_sheet.crop(player_sheet_width * 0, 0, player_sheet_width, player_sheet_height);
		wizard_down[1] = wizard_sheet.crop(player_sheet_width * 1, 0, player_sheet_width, player_sheet_height);
		wizard_down[2] = wizard_sheet.crop(player_sheet_width * 2, 0, player_sheet_width, player_sheet_height);
		wizard_down[3] = wizard_sheet.crop(player_sheet_width * 3, 0, player_sheet_width, player_sheet_height);

		wizard_right[0] = wizard_sheet.crop(player_sheet_width * 0, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		wizard_right[1] = wizard_sheet.crop(player_sheet_width * 1, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		wizard_right[2] = wizard_sheet.crop(player_sheet_width * 2, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		wizard_right[3] = wizard_sheet.crop(player_sheet_width * 3, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);

		wizard_up[0] = wizard_sheet.crop(player_sheet_width * 0, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		wizard_up[1] = wizard_sheet.crop(player_sheet_width * 1, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		wizard_up[2] = wizard_sheet.crop(player_sheet_width * 2, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		wizard_up[3] = wizard_sheet.crop(player_sheet_width * 3, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);

		wizard_left[0] = wizard_sheet.crop(player_sheet_width * 0, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		wizard_left[1] = wizard_sheet.crop(player_sheet_width * 1, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		wizard_left[2] = wizard_sheet.crop(player_sheet_width * 2, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		wizard_left[3] = wizard_sheet.crop(player_sheet_width * 3, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		wizard_idle[0] = wizard_sheet.crop(player_sheet_width * 0, player_sheet_height * 0, player_sheet_width,
				player_sheet_height);

		jina_down[0] = jina_sheet.crop(player_sheet_width * 0, 0, player_sheet_width, player_sheet_height);
		jina_down[1] = jina_sheet.crop(player_sheet_width * 1, 0, player_sheet_width, player_sheet_height);
		jina_down[2] = jina_sheet.crop(player_sheet_width * 2, 0, player_sheet_width, player_sheet_height);
		jina_down[3] = jina_sheet.crop(player_sheet_width * 3, 0, player_sheet_width, player_sheet_height);
		
		jina_right[0] = jina_sheet.crop(player_sheet_width * 0, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		jina_right[1] = jina_sheet.crop(player_sheet_width * 1, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		jina_right[2] = jina_sheet.crop(player_sheet_width * 2, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		jina_right[3] = jina_sheet.crop(player_sheet_width * 3, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);
		
		jina_up[0] = jina_sheet.crop(player_sheet_width * 0, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		jina_up[1] = jina_sheet.crop(player_sheet_width * 1, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		jina_up[2] = jina_sheet.crop(player_sheet_width * 2, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		jina_up[3] = jina_sheet.crop(player_sheet_width * 3, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		
		jina_left[0] = jina_sheet.crop(player_sheet_width * 0, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		jina_left[1] = jina_sheet.crop(player_sheet_width * 1, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		jina_left[2] = jina_sheet.crop(player_sheet_width * 2, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		jina_left[3] = jina_sheet.crop(player_sheet_width * 3, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		
		jina_idleUp[0] = jina_sheet.crop(player_sheet_width * 0, player_sheet_height * 2, player_sheet_width,
				player_sheet_height);
		jina_idleDown[0] = jina_sheet.crop(player_sheet_width * 0, player_sheet_height * 0, player_sheet_width,
				player_sheet_height);
		jina_idleLeft[0] = jina_sheet.crop(player_sheet_width * 0, player_sheet_height * 3, player_sheet_width,
				player_sheet_height);
		jina_idleRight[0] = jina_sheet.crop(player_sheet_width * 0, player_sheet_height * 1, player_sheet_width,
				player_sheet_height);		
		
		log_down[0] = log_sheet.crop(log_sheet_width * 0, 0, log_sheet_width, log_sheet_height);
		log_down[1] = log_sheet.crop(log_sheet_width * 1, 0, log_sheet_width, log_sheet_height);
		log_up[0] = log_sheet.crop(log_sheet_width * 2, 0, log_sheet_width, log_sheet_height);
		log_up[1] = log_sheet.crop(log_sheet_width * 3, 0, log_sheet_width, log_sheet_height);
		log_right[0] = log_sheet.crop(log_sheet_width * 0, log_sheet_height, log_sheet_width, log_sheet_height);
		log_right[1] = log_sheet.crop(log_sheet_width * 1, log_sheet_height, log_sheet_width, log_sheet_height);
		log_left[0] = log_sheet.crop(log_sheet_width * 2, log_sheet_height, log_sheet_width, log_sheet_height);
		log_left[1] = log_sheet.crop(log_sheet_width * 3, log_sheet_height, log_sheet_width, log_sheet_height);
		log_idle[0] = log_sheet.crop(log_sheet_width * 0, log_sheet_height * 2, log_sheet_width, log_sheet_height);

		hermit_down[0] = hermit_sheet.crop(player_sheet_small_width * 0, 0, player_sheet_small_width,
				player_sheet_small_height);
		hermit_down[1] = hermit_sheet.crop(player_sheet_small_width * 1, 0, player_sheet_small_width,
				player_sheet_small_height);
		hermit_up[0] = hermit_sheet.crop(player_sheet_small_width * 2, 0, player_sheet_small_width,
				player_sheet_small_height);
		hermit_up[1] = hermit_sheet.crop(player_sheet_small_width * 3, 0, player_sheet_small_width,
				player_sheet_small_height);
		hermit_right[0] = hermit_sheet.crop(player_sheet_small_width * 0, player_sheet_small_height,
				player_sheet_small_width, player_sheet_small_height);
		hermit_right[1] = hermit_sheet.crop(player_sheet_small_width * 1, player_sheet_small_height,
				player_sheet_small_width, player_sheet_small_height);
		hermit_left[0] = hermit_sheet.crop(player_sheet_small_width * 2, player_sheet_small_height,
				player_sheet_small_width, player_sheet_small_height);
		hermit_left[1] = hermit_sheet.crop(player_sheet_small_width * 3, player_sheet_small_height,
				player_sheet_small_width, player_sheet_small_height);
		hermit_idle[0] = hermit_sheet.crop(player_sheet_small_width * 0, player_sheet_small_height * 2,
				player_sheet_small_width, player_sheet_small_height);
		
		placeholder = outdoors_sheet.crop(0, 0, default_width, default_height);
		blackTile = outdoors_sheet.crop(default_width, 0, default_width, default_height);
		pinkTile = outdoors_sheet.crop(default_width * 2, 0, default_width, default_height);
		debugTile = outdoors_sheet.crop(default_width * 3, 0, default_width, default_height);
		stone_wall_top = outdoors_sheet.crop(default_width * 4, default_height * 0, default_width, default_height);
		
		grass_full = outdoors_sheet.crop(default_width * 0, default_height, default_width, default_height);
		dirt_full = outdoors_sheet.crop(default_width * 1, default_height, default_width, default_height);
		grass_puddle = outdoors_sheet.crop(default_width * 2, default_height, default_width, default_height);
		empty_14 = outdoors_sheet.crop(default_width * 3, default_height, default_width, default_height);
		stone_wall_bottom = outdoors_sheet.crop(default_width * 4, default_height, default_width, default_height);
		empty_16 = outdoors_sheet.crop(default_width * 5, default_height, default_width, default_height);
		plant_rose = outdoors_sheet.crop(default_width * 6, default_height, default_width, default_height);
		plant_berries = outdoors_sheet.crop(default_width * 7, default_height, default_width, default_height);
		plant_grass_1 = outdoors_sheet.crop(default_width * 8, default_height, default_width, default_height);
		plant_grass_2 = outdoors_sheet.crop(default_width * 9, default_height, default_width, default_height);

		grass_dirt_SR = outdoors_sheet.crop(default_width * 0, default_height * 2, default_width, default_height);
		grass_dirt_ST = outdoors_sheet.crop(default_width * 1, default_height * 2, default_width, default_height);
		grass_dirt_CBR = outdoors_sheet.crop(default_width * 2, default_height * 2, default_width, default_height);
		grass_dirt_CBL = outdoors_sheet.crop(default_width * 3, default_height * 2, default_width, default_height);
		dirt_grass_CTL = outdoors_sheet.crop(default_width * 4, default_height * 2, default_width, default_height);
		dirt_grass_CTR = outdoors_sheet.crop(default_width * 5, default_height * 2, default_width, default_height);
		plant_flower_1 = outdoors_sheet.crop(default_width * 6, default_height * 2, default_width, default_height);
		plant_flower_2 = outdoors_sheet.crop(default_width * 7, default_height * 2, default_width, default_height);
		plant_flower_3 = outdoors_sheet.crop(default_width * 8, default_height * 2, default_width, default_height);
		plant_flower_4 = outdoors_sheet.crop(default_width * 9, default_height * 2, default_width, default_height);
		
		grass_dirt_SL = outdoors_sheet.crop(default_width * 0, default_height * 3, default_width, default_height);
		grass_dirt_SB = outdoors_sheet.crop(default_width * 1, default_height * 3, default_width, default_height);
		grass_dirt_CTR = outdoors_sheet.crop(default_width * 2, default_height * 3, default_width, default_height);
		grass_dirt_CTL = outdoors_sheet.crop(default_width * 3, default_height * 3, default_width, default_height);
		dirt_grass_CBL = outdoors_sheet.crop(default_width * 4, default_height * 3, default_width, default_height);
		dirt_grass_CBR = outdoors_sheet.crop(default_width * 5, default_height * 3, default_width, default_height);
		pebble = outdoors_sheet.crop(default_width * 6, default_height * 3, default_width, default_height);
		rock_small = outdoors_sheet.crop(default_width * 7, default_height * 3, default_width, default_height);
		hole = outdoors_sheet.crop(default_width * 8, default_height * 3, default_width, default_height);
		gravestone = outdoors_sheet.crop(default_width * 9, default_height * 3, default_width, default_height);

		darkGrass_full = outdoors_sheet.crop(default_width * 0, default_height * 4, default_width, default_height);
		darkDirt_full = outdoors_sheet.crop(default_width * 1, default_height * 4, default_width, default_height);
		darkGrass_puddle_1 = outdoors_sheet.crop(default_width * 2, default_height * 4, default_width, default_height);
		darkGrass_puddle_2 = outdoors_sheet.crop(default_width * 3, default_height * 4, default_width, default_height);
		darkGrass_puddle_3 = outdoors_sheet.crop(default_width * 4, default_height * 4, default_width, default_height);
		plant_log_stem = outdoors_sheet.crop(default_width * 5, default_height * 4, default_width, default_height);
		grass_darkGrass_CTL = outdoors_sheet.crop(default_width * 6, default_height * 4, default_width, default_height);
		grass_darkGrass_CTR = outdoors_sheet.crop(default_width * 7, default_height * 4, default_width, default_height);
		grass_darkGrass_CBL = outdoors_sheet.crop(default_width * 8, default_height * 4, default_width, default_height);
		grass_darkGrass_CBR = outdoors_sheet.crop(default_width * 9, default_height * 4, default_width, default_height);

		darkGrass_dirt_SR = outdoors_sheet.crop(default_width * 0, default_height * 5, default_width, default_height);
		darkGrass_dirt_ST = outdoors_sheet.crop(default_width * 1, default_height * 5, default_width, default_height);
		darkGrass_dirt_CBR = outdoors_sheet.crop(default_width * 2, default_height * 5, default_width, default_height);
		darkGrass_dirt_CBL = outdoors_sheet.crop(default_width * 3, default_height * 5, default_width, default_height);
		darkDirt_darkGrass_CTL = outdoors_sheet.crop(default_width * 4, default_height * 5, default_width, default_height);
		darkDirt_darkGrass_CTR = outdoors_sheet.crop(default_width * 5, default_height * 5, default_width, default_height);
		darkGrass_grass_SR = outdoors_sheet.crop(default_width * 6, default_height * 5, default_width, default_height);
		darkGrass_grass_ST = outdoors_sheet.crop(default_width * 7, default_height * 5, default_width, default_height);
		darkGrass_grass_CBR = outdoors_sheet.crop(default_width * 8, default_height * 5, default_width, default_height);
		darkGrass_grass_CBL = outdoors_sheet.crop(default_width * 9, default_height * 5, default_width, default_height);
		
		darkGrass_darkDirt_SL = outdoors_sheet.crop(default_width * 0, default_height * 6, default_width, default_height);
		darkGrass_darkDirt_SB = outdoors_sheet.crop(default_width * 1, default_height * 6, default_width, default_height);
		darkGrass_darkDirt_CTR = outdoors_sheet.crop(default_width * 2, default_height * 6, default_width, default_height);
		darkGrass_darkDirt_CTL = outdoors_sheet.crop(default_width * 3, default_height * 6, default_width, default_height);
		darkDirt_darkGrass_CBL = outdoors_sheet.crop(default_width * 4, default_height * 6, default_width, default_height);
		darkDirt_darkGrass_CBR = outdoors_sheet.crop(default_width * 5, default_height * 6, default_width, default_height);
		darkGrass_grass_SL = outdoors_sheet.crop(default_width * 6, default_height * 6, default_width, default_height);
		darkGrass_grass_SB = outdoors_sheet.crop(default_width * 7, default_height * 6, default_width, default_height);
		darkGrass_grass_CTR = outdoors_sheet.crop(default_width * 8, default_height * 6, default_width, default_height);
		darkGrass_grass_CTL = outdoors_sheet.crop(default_width * 9, default_height * 6, default_width, default_height);
		
		leaf_1 = outdoors_sheet.crop(default_width * 0, default_height * 7, default_width, default_height);
		leaf_2 = outdoors_sheet.crop(default_width * 1, default_height * 7, default_width, default_height);
		leaf_3 = outdoors_sheet.crop(default_width * 2, default_height * 7, default_width, default_height);
		leaf_4 = outdoors_sheet.crop(default_width * 3, default_height * 7, default_width, default_height);
		leaf_5 = outdoors_sheet.crop(default_width * 4, default_height * 7, default_width, default_height);
		leaf_6 = outdoors_sheet.crop(default_width * 5, default_height * 7, default_width, default_height);
		tree_1_1 = outdoors_sheet.crop(default_width * 6, default_height * 7, default_width, default_height);
		tree_1_2 = outdoors_sheet.crop(default_width * 7, default_height * 7, default_width, default_height);
		tree_1_3 = outdoors_sheet.crop(default_width * 8, default_height * 7, default_width, default_height);
		tree_1_4 = outdoors_sheet.crop(default_width * 9, default_height * 7, default_width, default_height);
		
		leaf_7 = outdoors_sheet.crop(default_width * 0, default_height * 8, default_width, default_height);
		leaf_8 = outdoors_sheet.crop(default_width * 1, default_height * 8, default_width, default_height);
		leaf_9 = outdoors_sheet.crop(default_width * 2, default_height * 8, default_width, default_height);
		leaf_10 = outdoors_sheet.crop(default_width * 3, default_height * 8, default_width, default_height);
		log_small = outdoors_sheet.crop(default_width * 4, default_height * 8, default_width, default_height);
		empty_86 = outdoors_sheet.crop(default_width * 5, default_height * 8, default_width, default_height);
		tree_1_5 = outdoors_sheet.crop(default_width * 6, default_height * 8, default_width, default_height);
		tree_1_6 = outdoors_sheet.crop(default_width * 7, default_height * 8, default_width, default_height);
		tree_1_7 = outdoors_sheet.crop(default_width * 8, default_height * 8, default_width, default_height);
		tree_1_8 = outdoors_sheet.crop(default_width * 9, default_height * 8, default_width, default_height);
		
		leaf_11 = outdoors_sheet.crop(default_width * 0, default_height * 9, default_width, default_height);
		leaf_12 = outdoors_sheet.crop(default_width * 1, default_height * 9, default_width, default_height);
		leaf_13 = outdoors_sheet.crop(default_width * 2, default_height * 9, default_width, default_height);
		leaf_14 = outdoors_sheet.crop(default_width * 3, default_height * 9, default_width, default_height);
		empty_95 = outdoors_sheet.crop(default_width * 4, default_height * 9, default_width, default_height);
		tree_1_9 = outdoors_sheet.crop(default_width * 5, default_height * 9, default_width, default_height);
		tree_1_10 = outdoors_sheet.crop(default_width * 6, default_height * 9, default_width, default_height);
		tree_1_11 = outdoors_sheet.crop(default_width * 7, default_height * 9, default_width, default_height);
		tree_1_12 = outdoors_sheet.crop(default_width * 8, default_height * 9, default_width, default_height);
		tree_1_13 = outdoors_sheet.crop(default_width * 9, default_height * 9, default_width, default_height);
		
		leaf_15 = outdoors_sheet.crop(default_width * 0, default_height * 10, default_width, default_height);
		leaf_16 = outdoors_sheet.crop(default_width * 1, default_height * 10, default_width, default_height);
		leaf_17 = outdoors_sheet.crop(default_width * 2, default_height * 10, default_width, default_height);
		leaf_18 = outdoors_sheet.crop(default_width * 3, default_height * 10, default_width, default_height);
		leaf_19 = outdoors_sheet.crop(default_width * 4, default_height * 10, default_width, default_height);
		leaf_20 = outdoors_sheet.crop(default_width * 5, default_height * 10, default_width, default_height);
		tree_1_14 = outdoors_sheet.crop(default_width * 6, default_height * 10, default_width, default_height);
		tree_1_15 = outdoors_sheet.crop(default_width * 7, default_height * 10, default_width, default_height);
		tree_1_16 = outdoors_sheet.crop(default_width * 8, default_height * 10, default_width, default_height);
		tree_1_17 = outdoors_sheet.crop(default_width * 9, default_height * 10, default_width, default_height);
		
		leaf_21 = outdoors_sheet.crop(default_width * 0, default_height * 11, default_width, default_height);
		leaf_22 = outdoors_sheet.crop(default_width * 1, default_height * 11, default_width, default_height);
		leaf_23 = outdoors_sheet.crop(default_width * 2, default_height * 11, default_width, default_height);
		leaf_24 = outdoors_sheet.crop(default_width * 3, default_height * 11, default_width, default_height);
		leaf_25 = outdoors_sheet.crop(default_width * 4, default_height * 11, default_width, default_height);
		leaf_26 = outdoors_sheet.crop(default_width * 5, default_height * 11, default_width, default_height);
		empty_117 = outdoors_sheet.crop(default_width * 6, default_height * 11, default_width, default_height);
		empty_118 = outdoors_sheet.crop(default_width * 7, default_height * 11, default_width, default_height);
		tree_1_18 = outdoors_sheet.crop(default_width * 8, default_height * 11, default_width, default_height);
		tree_1_19 = outdoors_sheet.crop(default_width * 9, default_height * 11, default_width, default_height);
		
		leaf_27 = outdoors_sheet.crop(default_width * 0, default_height * 12, default_width, default_height);
		leaf_28 = outdoors_sheet.crop(default_width * 1, default_height * 12, default_width, default_height);
		leaf_29 = outdoors_sheet.crop(default_width * 2, default_height * 12, default_width, default_height);
		leaf_30 = outdoors_sheet.crop(default_width * 3, default_height * 12, default_width, default_height);
		leaf_31 = outdoors_sheet.crop(default_width * 4, default_height * 12, default_width, default_height);
		empty_126 = outdoors_sheet.crop(default_width * 5, default_height * 12, default_width, default_height);
		tree_1_20 = outdoors_sheet.crop(default_width * 6, default_height * 12, default_width, default_height);
		tree_1_21 = outdoors_sheet.crop(default_width * 7, default_height * 12, default_width, default_height);
		tree_1_22 = outdoors_sheet.crop(default_width * 8, default_height * 12, default_width, default_height);
		tree_1_23 = outdoors_sheet.crop(default_width * 9, default_height * 12, default_width, default_height);
		
		leaf_32 = outdoors_sheet.crop(default_width * 0, default_height * 13, default_width, default_height);
		leaf_33 = outdoors_sheet.crop(default_width * 1, default_height * 13, default_width, default_height);
		leaf_34 = outdoors_sheet.crop(default_width * 2, default_height * 13, default_width, default_height);
		leaf_35 = outdoors_sheet.crop(default_width * 3, default_height * 13, default_width, default_height);
		leaf_36 = outdoors_sheet.crop(default_width * 4, default_height * 13, default_width, default_height);
		empty_136 = outdoors_sheet.crop(default_width * 5, default_height * 13, default_width, default_height);
		tree_1_24 = outdoors_sheet.crop(default_width * 6, default_height * 13, default_width, default_height);
		tree_1_25 = outdoors_sheet.crop(default_width * 7, default_height * 13, default_width, default_height);
		tree_1_26 = outdoors_sheet.crop(default_width * 8, default_height * 13, default_width, default_height);
		tree_1_27 = outdoors_sheet.crop(default_width * 9, default_height * 13, default_width, default_height);
		
		leaf_37 = outdoors_sheet.crop(default_width * 0, default_height * 14, default_width, default_height);
		leaf_38 = outdoors_sheet.crop(default_width * 1, default_height * 14, default_width, default_height);
		leaf_39 = outdoors_sheet.crop(default_width * 2, default_height * 14, default_width, default_height);
		leaf_40 = outdoors_sheet.crop(default_width * 3, default_height * 14, default_width, default_height);
		leaf_41 = outdoors_sheet.crop(default_width * 4, default_height * 14, default_width, default_height);
		empty_146 = outdoors_sheet.crop(default_width * 5, default_height * 14, default_width, default_height);
		empty_147 = outdoors_sheet.crop(default_width * 6, default_height * 14, default_width, default_height);
		empty_148 = outdoors_sheet.crop(default_width * 7, default_height * 14, default_width, default_height);
		tree_2_1 = outdoors_sheet.crop(default_width * 8, default_height * 14, default_width, default_height);
		empty_150 = outdoors_sheet.crop(default_width * 9, default_height * 14, default_width, default_height);
		
		leaf_42 = outdoors_sheet.crop(default_width * 0, default_height * 15, default_width, default_height);
		leaf_43 = outdoors_sheet.crop(default_width * 1, default_height * 15, default_width, default_height);
		leaf_44 = outdoors_sheet.crop(default_width * 2, default_height * 15, default_width, default_height);
		leaf_45 = outdoors_sheet.crop(default_width * 3, default_height * 15, default_width, default_height);
		leaf_46 = outdoors_sheet.crop(default_width * 4, default_height * 15, default_width, default_height);
		empty_156 = outdoors_sheet.crop(default_width * 5, default_height * 15, default_width, default_height);
		empty_157 = outdoors_sheet.crop(default_width * 6, default_height * 15, default_width, default_height);
		empty_158 = outdoors_sheet.crop(default_width * 7, default_height * 15, default_width, default_height);
		tree_2_2 = outdoors_sheet.crop(default_width * 8, default_height * 15, default_width, default_height);
		empty_160 = outdoors_sheet.crop(default_width * 9, default_height * 15, default_width, default_height);
		
		empty_161 = outdoors_sheet.crop(default_width * 0, default_height * 16, default_width, default_height);
		leaf_47 = outdoors_sheet.crop(default_width * 1, default_height * 16, default_width, default_height);
		leaf_48 = outdoors_sheet.crop(default_width * 2, default_height * 16, default_width, default_height);
		leaf_49 = outdoors_sheet.crop(default_width * 3, default_height * 16, default_width, default_height);
		leaf_50 = outdoors_sheet.crop(default_width * 4, default_height * 16, default_width, default_height);
		empty_166 = outdoors_sheet.crop(default_width * 5, default_height * 16, default_width, default_height);
		empty_167 = outdoors_sheet.crop(default_width * 6, default_height * 16, default_width, default_height);
		tree_2_3 = outdoors_sheet.crop(default_width * 7, default_height * 16, default_width, default_height);
		tree_2_4 = outdoors_sheet.crop(default_width * 8, default_height * 16, default_width, default_height);
		tree_2_5 = outdoors_sheet.crop(default_width * 9, default_height * 16, default_width, default_height);
		
		empty_171 = outdoors_sheet.crop(default_width * 0, default_height * 17, default_width, default_height);
		empty_172 = outdoors_sheet.crop(default_width * 1, default_height * 17, default_width, default_height);
		empty_173 = outdoors_sheet.crop(default_width * 2, default_height * 17, default_width, default_height);
		empty_174 = outdoors_sheet.crop(default_width * 3, default_height * 17, default_width, default_height);
		empty_175 = outdoors_sheet.crop(default_width * 4, default_height * 17, default_width, default_height);
		empty_176 = outdoors_sheet.crop(default_width * 5, default_height * 17, default_width, default_height);
		empty_177 = outdoors_sheet.crop(default_width * 6, default_height * 17, default_width, default_height);
		tree_2_6 = outdoors_sheet.crop(default_width * 7, default_height * 17, default_width, default_height);
		tree_2_7 = outdoors_sheet.crop(default_width * 8, default_height * 17, default_width, default_height);
		tree_2_8 = outdoors_sheet.crop(default_width * 9, default_height * 17, default_width, default_height);
		
		dirt_wall_left_shadow = wall_sheet.crop(0, wall_sheet_height * 6, wall_sheet_width, wall_sheet_height);
		dirt_wall_left_bottom = wall_sheet.crop(0, wall_sheet_height * 5, wall_sheet_width, wall_sheet_height);
		dirt_wall_left_body_low = wall_sheet.crop(0, wall_sheet_height * 4, wall_sheet_width, wall_sheet_height);
		dirt_wall_left_body_high = wall_sheet.crop(0, wall_sheet_height * 3, wall_sheet_width, wall_sheet_height);
		dirt_wall_left_top_low = wall_sheet.crop(0, wall_sheet_height * 2, wall_sheet_width, wall_sheet_height);
		dirt_wall_left_top_middle = wall_sheet.crop(0, wall_sheet_height, wall_sheet_width, wall_sheet_height);
		dirt_wall_left_top_high = wall_sheet.crop(0, 0, wall_sheet_height, wall_sheet_height);

		dirt_wall_middle_shadow = wall_sheet.crop(wall_sheet_width, wall_sheet_height * 6, wall_sheet_width,
				wall_sheet_height);
		dirt_wall_middle_bottom = wall_sheet.crop(wall_sheet_width, wall_sheet_height * 5, wall_sheet_width,
				wall_sheet_height);
		dirt_wall_middle_body_low = wall_sheet.crop(wall_sheet_width, wall_sheet_height * 4, wall_sheet_width,
				wall_sheet_height);
		dirt_wall_middle_body_high = wall_sheet.crop(wall_sheet_width, wall_sheet_height * 3, wall_sheet_width,
				wall_sheet_height);
		dirt_wall_middle_top_low = wall_sheet.crop(wall_sheet_width, wall_sheet_height * 2, wall_sheet_width,
				wall_sheet_height);
		dirt_wall_middle_top_middle = wall_sheet.crop(wall_sheet_width, wall_sheet_height, wall_sheet_width,
				wall_sheet_height);
		dirt_wall_middle_top_high = wall_sheet.crop(wall_sheet_width, 0, wall_sheet_height, wall_sheet_height);

		dirt_wall_right_shadow = wall_sheet.crop(wall_sheet_width * 2, wall_sheet_height * 6, wall_sheet_width,
				wall_sheet_height);
		dirt_wall_right_bottom = wall_sheet.crop(wall_sheet_width * 2, wall_sheet_height * 5, wall_sheet_width,
				wall_sheet_height);
		dirt_wall_right_body_low = wall_sheet.crop(wall_sheet_width * 2, wall_sheet_width * 4, wall_sheet_width,
				wall_sheet_height);
		dirt_wall_right_body_high = wall_sheet.crop(wall_sheet_width * 2, wall_sheet_height * 3, wall_sheet_width,
				wall_sheet_height);
		dirt_wall_right_top_low = wall_sheet.crop(wall_sheet_width * 2, wall_sheet_height * 2, wall_sheet_width,
				wall_sheet_height);
		dirt_wall_right_top_middle = wall_sheet.crop(wall_sheet_width * 2, wall_sheet_height, wall_sheet_width,
				wall_sheet_height);
		dirt_wall_right_top_high = wall_sheet.crop(wall_sheet_width * 2, 0, wall_sheet_height, wall_sheet_height);

		fence_hz = sheet.crop(0, default_height * 4, default_width, default_height);
		fence_vt = sheet.crop(default_width, default_height * 4, default_width, default_height);
		fence_hL = sheet.crop(default_width * 2, default_height * 4, default_width, default_height);
		fence_hR = sheet.crop(default_width * 3, default_height * 4, default_width, default_height);
		fence_CBL = sheet.crop(default_width * 4, default_height * 4, default_width, default_height);
		fence_CBR = sheet.crop(default_width * 5, default_height * 4, default_width, default_height);
		fence_CTL = sheet.crop(default_width * 6, default_height * 4, default_width, default_height);
		fence_CTR = sheet.crop(default_width * 7, default_height * 4, default_width, default_height);

		hedge_hzB = sheet.crop(0, default_height * 5, default_width, default_height);
		hedge_hzT = sheet.crop(default_width, default_height * 5, default_width, default_height);
		hedge_vtL = sheet.crop(default_width * 2, default_height * 5, default_width, default_height);
		hedge_vtR = sheet.crop(default_width * 3, default_height * 5, default_width, default_height);
		hedge_CBL = sheet.crop(default_width * 4, default_height * 5, default_width, default_height);
		hedge_CBR = sheet.crop(default_width * 5, default_height * 5, default_width, default_height);
		hedge_CTL = sheet.crop(default_width * 6, default_height * 5, default_width, default_height);
		hedge_CTR = sheet.crop(default_width * 7, default_height * 5, default_width, default_height);
		hedge_plain = sheet.crop(0, default_height * 6, default_width, default_height);
		hedge_plainCBL = sheet.crop(default_width, default_height * 6, default_width, default_height);
		hedge_plainCBR = sheet.crop(default_width * 2, default_height * 6, default_width, default_height);
		hedge_plainCTL = sheet.crop(default_width * 3, default_height * 6, default_width, default_height);
		hedge_plainCTR = sheet.crop(default_width * 4, default_height * 6, default_width, default_height);

		bush = static_entities_sheet.crop(0, 0, default_width, default_height);
		bush_dmg1 = static_entities_sheet.crop(default_width, 0, default_width, default_height);
		bush_dmg2 = static_entities_sheet.crop(default_width * 2, 0, default_width, default_height);
		bush_dmg3 = static_entities_sheet.crop(default_width * 3, 0, default_width, default_height);

		rock = static_entities_sheet.crop(0, default_height, default_width, default_height);
		rock_dmg1 = static_entities_sheet.crop(default_width, default_height, default_width, default_height);
		rock_dmg2 = static_entities_sheet.crop(default_width * 2, default_height, default_width, default_height);
		rock_dmg3 = static_entities_sheet.crop(default_width * 3, default_height, default_width, default_height);

		//pebble = static_entities_sheet.crop(0, default_height * 3, default_width, default_height);

		// BUILDINGS
		hermit_hut = buildings_exterior_sheet.crop(0, 0, building_exterior_width * 4, building_exterior_height * 4);
		house_jina = buildings_exterior_sheet.crop(building_exterior_width * 5, 0, building_exterior_width * 4,
				building_exterior_height * 6);

		floor_1 = buildings_interior_sheet.crop(0, 0, default_width, default_height);
		floor_2 = buildings_interior_sheet.crop(default_width, 0, default_width, default_height);
		floor_3 = buildings_interior_sheet.crop(default_width * 2, 0, default_width, default_height);
		floor_4 = buildings_interior_sheet.crop(default_width * 3, 0, default_width, default_height);
		floor_5 = buildings_interior_sheet.crop(default_width * 4, 0, default_width, default_height);
		floor_6 = buildings_interior_sheet.crop(default_width * 5, 0, default_width, default_height);
		floor_7 = buildings_interior_sheet.crop(default_width * 6, 0, default_width, default_height);
		floor_8 = buildings_interior_sheet.crop(default_width * 7, 0, default_width, default_height);

		floor_9 = buildings_interior_sheet.crop(0, default_height, default_width, default_height);
		floor_10 = buildings_interior_sheet.crop(default_width, default_height, default_width, default_height);
		floor_11 = buildings_interior_sheet.crop(default_width * 2, default_height, default_width, default_height);
		floor_12 = buildings_interior_sheet.crop(default_width * 3, default_height, default_width, default_height);
		floor_13 = buildings_interior_sheet.crop(default_width * 4, default_height, default_width, default_height);
		floor_14 = buildings_interior_sheet.crop(default_width * 5, default_height, default_width, default_height);
		floor_15 = buildings_interior_sheet.crop(default_width * 6, default_height, default_width, default_height);
		floor_16 = buildings_interior_sheet.crop(default_width * 7, default_height, default_width, default_height);

		floor_17 = buildings_interior_sheet.crop(0, default_height * 2, default_width, default_height);
		floor_18 = buildings_interior_sheet.crop(default_width, default_height * 2, default_width, default_height);
		floor_19 = buildings_interior_sheet.crop(default_width * 2, default_height * 2, default_width, default_height);
		floor_20 = buildings_interior_sheet.crop(default_width * 3, default_height * 2, default_width, default_height);

		wooden_wall_1 = buildings_interior_sheet.crop(0, default_height * 5, default_width, default_height);
		white_wall_middle = buildings_interior_sheet.crop(default_width, default_height * 5, default_width,
				default_height);
		white_wall_bottom = buildings_interior_sheet.crop(default_width * 2, default_height * 5, default_width,
				default_height);
		yellowStripes_wall_middle = buildings_interior_sheet.crop(default_width * 3, default_height * 5, default_width,
				default_height);
		yellowStripes_wall_bottom = buildings_interior_sheet.crop(default_width * 4, default_height * 5, default_width,
				default_height);

		room_margin_left = buildings_interior_sheet.crop(0, default_height * 3, default_width, default_height);
		room_margin_right = buildings_interior_sheet.crop(default_width, default_height * 3, default_width,
				default_height);
		room_margin_bottom = buildings_interior_sheet.crop(default_width * 2, default_height * 3, default_width,
				default_height);
		room_margin_top = buildings_interior_sheet.crop(default_width * 3, default_height * 3, default_width,
				default_height);
		room_margin_ctl = buildings_interior_sheet.crop(default_width * 4, default_height * 3, default_width,
				default_height);
		room_margin_ctr = buildings_interior_sheet.crop(default_width * 5, default_height * 3, default_width,
				default_height);
		room_margin_cbl = buildings_interior_sheet.crop(default_width * 6, default_height * 3, default_width,
				default_height);
		room_margin_cbr = buildings_interior_sheet.crop(default_width * 7, default_height * 3, default_width,
				default_height);
		room_margin_bottom_end_left = buildings_interior_sheet.crop(0, default_height * 4, default_width,
				default_height);
		room_margin_bottom_end_right = buildings_interior_sheet.crop(default_width, default_height * 4, default_width,
				default_height);
	}

}
