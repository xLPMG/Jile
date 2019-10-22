package me.lpmg.jile.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int default_width = 32, default_height = 32;
	private static final int player_sheet_width = 16, player_sheet_height = 23;
	private static final int log_sheet_width = 32, log_sheet_height = 32;
	private static final int wall_sheet_width = 16, wall_sheet_height = 16;
	private static final int healthbar_width = 64, healthbar_height = 10;
	
	public static Font font28;
	
	public static BufferedImage placeholder, debug;
	
	public static BufferedImage wall_left_shadow, wall_left_bottom, wall_left_body_low, wall_left_body_high, wall_left_top_low, wall_left_top_middle, wall_left_top_high;
	public static BufferedImage wall_middle_shadow, wall_middle_bottom, wall_middle_body_low, wall_middle_body_high, wall_middle_top_low, wall_middle_top_middle, wall_middle_top_high;
	public static BufferedImage wall_right_shadow, wall_right_bottom, wall_right_body_low, wall_right_body_high, wall_right_top_low, wall_right_top_middle, wall_right_top_high;
	
	public static BufferedImage dirt_full, stone;
	public static BufferedImage grass_full, grass_dirtBottom, grass_dirtTop, grass_dirtLeft, grass_dirtRight;
	public static BufferedImage tree, rock, pebble;
	public static BufferedImage woodItem, rockItem;
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_idle, player_attack_down, player_attack_up, player_attack_left, player_attack_right;
	public static BufferedImage[] log_down, log_up, log_left, log_right, log_idle;
	
	public static BufferedImage[] btn_start;
	public static BufferedImage inventoryScreen;
	public static BufferedImage healthbar, healthbar_empty, healthbar_health_full, healthbar_mana_full;
	
	public static void init(){
		font28 = FontLoader.loadFont("jileresources/fonts/slkscr.ttf", 28);

		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		SpriteSheet player_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player_sheet.png"));
		SpriteSheet log_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/log_sheet.png"));
		SpriteSheet floor_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/floor_sheet.png"));
		SpriteSheet static_entities_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/static_entities_sheet.png"));
		SpriteSheet wall_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/walls_sheet.png"));
		SpriteSheet healthbar_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/healthbar_sheet.png"));
		
		inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");
		
		woodItem = sheet.crop(default_width, default_height, default_width, default_height);
		rockItem = sheet.crop(default_width, default_height*2, default_width, default_height);
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(default_width * 6, default_height * 4, default_width * 2, default_height);
		btn_start[1] = sheet.crop(default_width * 6, default_height * 5, default_width * 2, default_height);
		
		healthbar_empty = healthbar_sheet.crop(0, 0, healthbar_width, healthbar_height);
		healthbar_health_full = healthbar_sheet.crop(0, healthbar_height, healthbar_width, healthbar_height);
		healthbar_mana_full = healthbar_sheet.crop(0, healthbar_height*2, healthbar_width, healthbar_height);
		
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_idle = new BufferedImage[1];
		player_attack_down = new BufferedImage[1];
		player_attack_up = new BufferedImage[1];
		player_attack_left = new BufferedImage[1];
		player_attack_right = new BufferedImage[1];
		
		log_down = new BufferedImage[2];
		log_up = new BufferedImage[2];
		log_right = new BufferedImage[2];
		log_left = new BufferedImage[2];
		log_idle = new BufferedImage[1];

		player_down[0] = player_sheet.crop(player_sheet_width * 0, 0, player_sheet_width, player_sheet_height);
		player_down[1] = player_sheet.crop(player_sheet_width * 1, 0, player_sheet_width, player_sheet_height);
		player_up[0] = player_sheet.crop(player_sheet_width * 2, 0, player_sheet_width, player_sheet_height);
		player_up[1] = player_sheet.crop(player_sheet_width * 3, 0, player_sheet_width, player_sheet_height);
		player_right[0] = player_sheet.crop(player_sheet_width * 0, player_sheet_height, player_sheet_width, player_sheet_height);
		player_right[1] = player_sheet.crop(player_sheet_width * 1, player_sheet_height, player_sheet_width, player_sheet_height);
		player_left[0] = player_sheet.crop(player_sheet_width * 2, player_sheet_height, player_sheet_width, player_sheet_height);
		player_left[1] = player_sheet.crop(player_sheet_width * 3, player_sheet_height, player_sheet_width, player_sheet_height);
		player_idle[0] = player_sheet.crop(player_sheet_width * 0, player_sheet_height * 2, player_sheet_width, player_sheet_height);
		player_attack_down[0] = player_sheet.crop(player_sheet_width * 0, player_sheet_height * 3, player_sheet_width, player_sheet_height);
		player_attack_up[0] = player_sheet.crop(player_sheet_width * 1, player_sheet_height * 3, player_sheet_width, player_sheet_height);
		player_attack_right[0] = player_sheet.crop(player_sheet_width * 2, player_sheet_height * 3, player_sheet_width, player_sheet_height);
		player_attack_left[0] = player_sheet.crop(player_sheet_width * 3, player_sheet_height * 3, player_sheet_width, player_sheet_height);
		
		log_down[0] = log_sheet.crop(log_sheet_width * 0, 0, log_sheet_width, log_sheet_height);
		log_down[1] = log_sheet.crop(log_sheet_width * 1, 0, log_sheet_width, log_sheet_height);
		log_up[0] = log_sheet.crop(log_sheet_width * 2, 0, log_sheet_width, log_sheet_height);
		log_up[1] = log_sheet.crop(log_sheet_width * 3, 0, log_sheet_width, log_sheet_height);
		log_right[0] = log_sheet.crop(log_sheet_width * 0, log_sheet_height, log_sheet_width, log_sheet_height);
		log_right[1] = log_sheet.crop(log_sheet_width * 1, log_sheet_height, log_sheet_width, log_sheet_height);
		log_left[0] = log_sheet.crop(log_sheet_width * 2, log_sheet_height, log_sheet_width, log_sheet_height);
		log_left[1] = log_sheet.crop(log_sheet_width * 3, log_sheet_height, log_sheet_width, log_sheet_height);
		log_idle[0] = log_sheet.crop(log_sheet_width * 0, log_sheet_height * 2, log_sheet_width, log_sheet_height);
		
		dirt_full = floor_sheet.crop(default_width * 0, default_height, default_width, default_height);
		
		grass_full = floor_sheet.crop(default_width * 0, 0, default_width, default_height);
		grass_dirtBottom = floor_sheet.crop(default_width * 1, 0, default_width, default_height);
		grass_dirtTop = floor_sheet.crop(default_width * 2, 0, default_width, default_height);
		grass_dirtLeft = floor_sheet.crop(default_width * 3, 0, default_width, default_height);
		grass_dirtRight = floor_sheet.crop(default_width * 4, 0, default_width, default_height);
		
		placeholder = sheet.crop(0, 0, default_width, default_height);
		debug = sheet.crop(0, default_width * 3, default_width, default_height);
		
		wall_left_shadow = wall_sheet.crop(0, wall_sheet_height * 6, wall_sheet_width, wall_sheet_height);
		wall_left_bottom = wall_sheet.crop(0, wall_sheet_height * 5, wall_sheet_width, wall_sheet_height);
		wall_left_body_low = wall_sheet.crop(0, wall_sheet_height * 4, wall_sheet_width, wall_sheet_height);
		wall_left_body_high = wall_sheet.crop(0, wall_sheet_height * 3, wall_sheet_width, wall_sheet_height);
		wall_left_top_low = wall_sheet.crop(0, wall_sheet_height * 2, wall_sheet_width, wall_sheet_height);
		wall_left_top_middle = wall_sheet.crop(0, wall_sheet_height, wall_sheet_width, wall_sheet_height);
		wall_left_top_high = wall_sheet.crop(0, 0, wall_sheet_height, wall_sheet_height);		
		
		wall_middle_shadow = wall_sheet.crop(wall_sheet_width, wall_sheet_height * 6, wall_sheet_width, wall_sheet_height);
		wall_middle_bottom = wall_sheet.crop(wall_sheet_width, wall_sheet_height * 5, wall_sheet_width, wall_sheet_height);
		wall_middle_body_low = wall_sheet.crop(wall_sheet_width, wall_sheet_height * 4, wall_sheet_width, wall_sheet_height);
		wall_middle_body_high = wall_sheet.crop(wall_sheet_width, wall_sheet_height * 3, wall_sheet_width, wall_sheet_height);
		wall_middle_top_low = wall_sheet.crop(wall_sheet_width, wall_sheet_height * 2, wall_sheet_width, wall_sheet_height);
		wall_middle_top_middle = wall_sheet.crop(wall_sheet_width, wall_sheet_height, wall_sheet_width, wall_sheet_height);
		wall_middle_top_high = wall_sheet.crop(wall_sheet_width, 0, wall_sheet_height, wall_sheet_height);
		
		wall_right_shadow = wall_sheet.crop(wall_sheet_width * 2, wall_sheet_height * 6, wall_sheet_width, wall_sheet_height);
		wall_right_bottom = wall_sheet.crop(wall_sheet_width * 2, wall_sheet_height * 5, wall_sheet_width, wall_sheet_height);
		wall_right_body_low = wall_sheet.crop(wall_sheet_width *2, wall_sheet_width * 4, wall_sheet_width, wall_sheet_height);
		wall_right_body_high = wall_sheet.crop(wall_sheet_width * 2, wall_sheet_height * 3, wall_sheet_width, wall_sheet_height);
		wall_right_top_low = wall_sheet.crop(wall_sheet_width * 2, wall_sheet_height * 2, wall_sheet_width, wall_sheet_height);
		wall_right_top_middle = wall_sheet.crop(wall_sheet_width* 2, wall_sheet_height, wall_sheet_width, wall_sheet_height);
		wall_right_top_high = wall_sheet.crop(wall_sheet_width * 2, 0, wall_sheet_height, wall_sheet_height);
		
		stone = sheet.crop(default_width * 3, 0, default_width, default_height);
		tree = sheet.crop(0, 0, default_width, default_height * 2);
		rock = sheet.crop(0, default_height * 2, default_width, default_height);
		pebble = static_entities_sheet.crop(0, default_height * 3, default_width, default_height);
	}
	
}
