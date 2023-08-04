package me.lpmg.jile.miscgui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.creatures.Player;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.gfx.Text;

public class Healthbar {

	private Handler handler;
	private Player player;
	private float health;
	private float maxHealth;
	private float mana;
	private float maxMana;
	private BufferedImage healthBar;
	private BufferedImage manaBar;
	private int x;
	private int y;
	
	private boolean showCorner=false;
	
	public Healthbar(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		x = 10;
		y = 10;
	}
	
	public void tick(){
		maxHealth = player.getMaxHealth();
		maxMana = player.getMaxMana();
		
		health = player.getHealth();
		mana = player.getMana();
		if(health>maxHealth) {
			health=maxHealth;
		}
		if(mana>maxMana) {
			mana=maxMana;
		}
	}
	public void render(Graphics g) {
		g.drawImage(Assets.healthbar_empty, x,y, 320, 50, null);
		
		if(health>0) {
		healthBar = Assets.healthbar_health_full.getSubimage(0, 0, (int) (64 * (health / maxHealth)), 10);
		g.drawImage(healthBar, x,y, (int) (320 * (health / maxHealth)), 50,  null);
		}
		
		if(mana>0) {
		manaBar = Assets.healthbar_mana_full.getSubimage(0, 0, (int) (64 * (mana / maxMana)), 10);
		g.drawImage(manaBar, x,y, (int) (320 * (mana / maxMana)), 50,  null);
		}
		
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
