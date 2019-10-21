package me.lpmg.jile.healthbar;

import java.awt.Color;
import java.awt.Graphics;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.creatures.Player;

public class Healthbar {

	private Handler handler;
	private Player player;
	private float health;
	private float maxHealth;
	
	public Healthbar(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		maxHealth = player.getMaxHealth();
	}
	
	public void tick(){
		health = player.getHealth();
	}
	public void render(Graphics g) {

		 g.setColor(Color.black);
		 g.fillRect(5, 200, (int)maxHealth*5, 5);
		 g.setColor(Color.red);
		 g.fillRect(5, 200, (int) (maxHealth * (health / maxHealth))*5, 5); 
	}
	
	// GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
