package me.lpmg.jile.healthbar;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.creatures.Player;
import me.lpmg.jile.gfx.Assets;

public class Healthbar {

	private Handler handler;
	private Player player;
	private float health;
	private float maxHealth;
	private BufferedImage healthBar;
	private int x;
	private int y;
	
	private boolean showCorner=false;
	
	public Healthbar(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		maxHealth = player.getMaxHealth();
		x = 10;
		y = 10;
	}
	
	public void tick(){
		health = player.getHealth();
	}
	public void render(Graphics g) {
		g.drawImage(Assets.healthbar_empty, x,y, 320, 50, null);
		healthBar = Assets.healthbar_health_full.getSubimage(0, 0, (int) (64 * (health / maxHealth)), 10);
		g.drawImage(healthBar, x,y, (int) (320 * (health / maxHealth)), 50,  null);
		
		g.drawImage(Assets.healthbar_mana_full, x,y, 320, 50, null);
		
		if(showCorner) {
			g.drawImage(Assets.healthbar_corner_full, x,y, 320, 50, null);
		}
	}
	
	// GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	public void showCorner() {
		showCorner=true;
	}
	
	public void hideCorner() {
		showCorner=false;
	}
}
