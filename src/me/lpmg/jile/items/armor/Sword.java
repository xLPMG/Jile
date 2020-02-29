package me.lpmg.jile.items.armor;

import java.awt.image.BufferedImage;

import me.lpmg.jile.items.ArmorItem;

public class Sword extends ArmorItem{
	
	public Sword(BufferedImage texture, String name, int id, int buyingPrice, int sellingPrice, String description, int attackDamage) {
		super(texture, name, id, buyingPrice, sellingPrice, description, 0, 0, 0, 0, 0, attackDamage, 0, 0, 0);
	}

}
