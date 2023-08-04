package me.lpmg.jile.items.armor;

import java.awt.image.BufferedImage;

import me.lpmg.jile.items.ArmorItem;
import me.lpmg.jile.items.Item;

public class Chestplate extends ArmorItem {
	
	public Chestplate(BufferedImage texture, String name, int id, int buyingPrice, int sellingPrice, String description,
			int armorPoints, float speedPoints) {
		super(texture, name, id, buyingPrice, sellingPrice, description, armorPoints, speedPoints, 0, 0, 0, 0, 0, 0, 0);
	}

}
