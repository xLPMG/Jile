package me.lpmg.jile.items.armor;

import java.awt.image.BufferedImage;

import me.lpmg.jile.items.ArmorItem;
import me.lpmg.jile.items.Item;

public class Boots extends ArmorItem {
	
	public Boots(BufferedImage texture, String name, int id, int buyingPrice, int sellingPrice, String description,
			int armorPoints, float speedPoints) {
		super(texture, name, id, buyingPrice, sellingPrice, description, 0, speedPoints, 0, 0, 0, 0, 0, 0, 0);
	}

}
