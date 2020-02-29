package me.lpmg.jile.items.armor;

import java.awt.image.BufferedImage;

import me.lpmg.jile.items.ArmorItem;
import me.lpmg.jile.items.Item;

public class Shield extends ArmorItem{

	public Shield(BufferedImage texture, String name, int id, int buyingPrice, int sellingPrice, String description, int armorPoints) {
		super(texture, name, id, buyingPrice, sellingPrice, description, armorPoints, 0, 0, 0, 0, 0, 0, 0, 0);
	}

}
