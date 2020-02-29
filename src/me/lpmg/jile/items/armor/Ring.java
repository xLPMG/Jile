package me.lpmg.jile.items.armor;

import java.awt.image.BufferedImage;

import me.lpmg.jile.items.ArmorItem;
import me.lpmg.jile.items.Item;

public class Ring extends ArmorItem{

	public Ring(BufferedImage texture, String name, int id, int buyingPrice, int sellingPrice, String description, int manaPoints, int manaRegenerationPoints, int healthRegenerationPoints) {
		super(texture, name, id, buyingPrice, sellingPrice, description, 0, 0, manaPoints, manaRegenerationPoints, healthRegenerationPoints, 0, 0, 0, 0);
	}


}
