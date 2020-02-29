package me.lpmg.jile.items;

import java.awt.image.BufferedImage;

public class Sword extends Item{

	private int attackDamage;
	
	public Sword(BufferedImage texture, String name, int id, int buyingPrice, int sellingPrice, String description, int attackDamage) {
		super(texture, name, id, buyingPrice, sellingPrice, description);
		this.attackDamage=attackDamage;
	}
	
	public int getAttackDamage() {
	return attackDamage;	
	}
	
	public void takeEffect() {
		
	}

}
