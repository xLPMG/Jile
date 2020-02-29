package me.lpmg.jile.items;

import java.awt.image.BufferedImage;

public class ArmorItem extends Item {

	private int armorPoints;
	private float speedPoints;
	private int manaPoints;
	private int manaRegenerationPoints;
	private int healthRegenerationPoints;
	private int attackDamage;
	private int usedManaPoints;
	private int ignitionDuration;
	private int slownessDuration;

	public ArmorItem(BufferedImage texture, String name, int id, int buyingPrice, int sellingPrice, String description,
			int armorPoints, float speedPoints, int manaPoints, int manaRegenerationPoints, int healthRegenerationPoints,
			int attackDamage, int usedManaPoints, int ignitionDuration, float f) {
		super(texture, name, id, buyingPrice, sellingPrice, description);
		this.armorPoints = armorPoints;
		this.speedPoints = speedPoints;
		this.manaPoints = manaPoints;
		this.manaRegenerationPoints = manaRegenerationPoints;
		this.healthRegenerationPoints = healthRegenerationPoints;
		this.attackDamage = attackDamage;
		this.usedManaPoints = usedManaPoints;
		this.ignitionDuration = ignitionDuration;
		this.slownessDuration = slownessDuration;

	}

	public int getArmorPoints() {
		return armorPoints;
	}

	public float getSpeedPoints() {
		return speedPoints;
	}

	public int getManaPoints() {
		return manaPoints;
	}

	public int getManaRegenerationPoints() {
		return manaRegenerationPoints;
	}

	public int getHealthRegenerationPoints() {
		return healthRegenerationPoints;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public int getUsedManaPoints() {
		return usedManaPoints;
	}

	public int getIgnitionDuration() {
		return ignitionDuration;
	}

	public int getSlownessDuration() {
		return slownessDuration;
	}

}
