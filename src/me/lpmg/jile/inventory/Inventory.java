package me.lpmg.jile.inventory;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.Timer;

import me.lpmg.jile.Handler;
import me.lpmg.jile.buildings.BuildingManager;
import me.lpmg.jile.entities.creatures.Player;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.gfx.Text;
import me.lpmg.jile.ingamemenu.ItemMenu;
import me.lpmg.jile.items.ArmorItem;
import me.lpmg.jile.items.Item;
import me.lpmg.jile.items.ItemManager;
import me.lpmg.jile.items.armor.Boots;
import me.lpmg.jile.items.armor.Chain;
import me.lpmg.jile.items.armor.Chestplate;
import me.lpmg.jile.items.armor.Helmet;
import me.lpmg.jile.items.armor.Leggins;
import me.lpmg.jile.items.armor.Ring;
import me.lpmg.jile.items.armor.Shield;
import me.lpmg.jile.items.armor.Sword;

public class Inventory {

	private Handler handler;
	private boolean active = false;
	private boolean disabled = false;
	private ArrayList<Item> inventoryItems;
	private HashMap<String, Integer> equippedItems;
	private BuildingManager buildingManager;
	private ItemMenu itMenu;
	private Player player;

	private Boots equippedBoots;
	private Chain equippedChain;
	private Chestplate equippedChestplate;
	private Helmet equippedHelmet;
	private Leggins equippedLeggins;
	private Ring equippedRing;
	private Shield equippedShield;
	private Sword equippedSword;

	private int equipWidth = 173;

	private int invX = 32, invY = 64, invWidth = 512 + equipWidth, invHeight = 458,
			invListCenterX = invX + equipWidth + 171, invListCenterY = invY + (invHeight - 74) / 2 + 5,
			invListSpacing = 30;

	private int invImageX = 384 + equipWidth + invX, invImageY = 34 + invY, invImageWidth = 64, invImageHeight = 64;

	private int invCountX = 416 + equipWidth + invX, invCountY = 124 + invY;

	private int itemDescX = 513 + invX + 8, itemDescY = 225 + invY + 16, itemDescWidth = 151 - 8,
			itemDescHeight = 142 - 8;

	private int equipButtonX = invX + 506, equipButtonY = invY + 182;
	private int equipButtonWidth = 96, equipButtonHeight = 32;
	private Rectangle equipButtonBounds = new Rectangle(equipButtonX, equipButtonY, equipButtonWidth,
			equipButtonHeight);

	private int equipSlotImageWidth = 64, equipSlotImageHeight = 64;

	private int equipSlotWidth = 66, equipSlotHeight = 66;
	private int equipSlotSpacingX = (equipSlotWidth - equipSlotImageWidth) / 2;
	private int equipSlotSpacingY = (equipSlotHeight - equipSlotImageHeight) / 2;

	private int equipSlotX1 = invX + 12 + equipSlotSpacingX, equipSlotY1 = invY + 39 + equipSlotSpacingY;
	private int equipSlotX2 = invX + 12 + equipSlotSpacingX, equipSlotY2 = invY + 118 + equipSlotSpacingY;
	private int equipSlotX3 = invX + 12 + equipSlotSpacingX, equipSlotY3 = invY + 197 + equipSlotSpacingY;
	private int equipSlotX4 = invX + 12 + equipSlotSpacingX, equipSlotY4 = invY + 276 + equipSlotSpacingY;
	private int equipSlotX5 = invX + 91 + equipSlotSpacingX, equipSlotY5 = invY + 39 + equipSlotSpacingY;
	private int equipSlotX6 = invX + 91 + equipSlotSpacingX, equipSlotY6 = invY + 118 + equipSlotSpacingY;
	private int equipSlotX7 = invX + 91 + equipSlotSpacingX, equipSlotY7 = invY + 197 + equipSlotSpacingY;
	private int equipSlotX8 = invX + 91 + equipSlotSpacingX, equipSlotY8 = invY + 276 + equipSlotSpacingY;

	private Rectangle equipSlot1 = new Rectangle(equipSlotX1, equipSlotY1, equipSlotWidth, equipSlotHeight);
	private Rectangle equipSlot2 = new Rectangle(equipSlotX2, equipSlotY2, equipSlotWidth, equipSlotHeight);
	private Rectangle equipSlot3 = new Rectangle(equipSlotX3, equipSlotY3, equipSlotWidth, equipSlotHeight);
	private Rectangle equipSlot4 = new Rectangle(equipSlotX4, equipSlotY4, equipSlotWidth, equipSlotHeight);
	private Rectangle equipSlot5 = new Rectangle(equipSlotX5, equipSlotY5, equipSlotWidth, equipSlotHeight);
	private Rectangle equipSlot6 = new Rectangle(equipSlotX6, equipSlotY6, equipSlotWidth, equipSlotHeight);
	private Rectangle equipSlot7 = new Rectangle(equipSlotX7, equipSlotY7, equipSlotWidth, equipSlotHeight);
	private Rectangle equipSlot8 = new Rectangle(equipSlotX8, equipSlotY8, equipSlotWidth, equipSlotHeight);

	private int effectsX = 4 + invX + 100, effectsY = 390 + invY + 16;
	private int effectsWidth = 677, effectsHeight = 64;

	private int effectWidth = 225, effectHeight = 30;

	private int effect1X = effectsX, effect1Y = effectsY;
	private int effect2X = effectsX + effectWidth, effect2Y = effectsY;
	private int effect3X = effectsX + effectWidth * 2, effect3Y = effectsY;
	private int effect4X = effectsX, effect4Y = effectsY + effectHeight;
	private int effect5X = effectsX + effectWidth, effect5Y = effectsY + effectHeight;
	private int effect6X = effectsX + effectWidth * 2, effect6Y = effectsY + effectHeight;

	private int selectedItem = 0;

	private int armorPointsB;
	private float speedPointsB;
	private int manaPointsB;
	private int manaRegenerationPointsB;
	private int healthRegenerationPointsB;
	private int attackDamageB;
	private int usedManaPointsB;
	private int ignitionDurationB;
	private int slownessDurationB;

	private int iTick;
	
	public Inventory(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		inventoryItems = new ArrayList<Item>();
		equippedItems = new HashMap<String, Integer>();
		itMenu = new ItemMenu(handler, buildingManager);

		MouseAdapter mA = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON1) {

					if (equipButtonBounds.contains(e.getPoint())) {
						if (selectedItem <= inventoryItems.size()) {
							Item item = inventoryItems.get(selectedItem);
							if (item instanceof Ring) {
								if (equippedRing != null) {
									inventoryItems.add(equippedRing);
									equippedRing = null;
									equippedItems.remove("equippedRing");
								}
								equippedRing = (Ring) item;
								equippedItems.put("equippedRing", item.getId());
								removeItem(item, 1);
							} else if (item instanceof Sword) {
								if (equippedSword != null) {
									inventoryItems.add(equippedSword);
									equippedSword = null;
									equippedItems.remove("equippedSword");
								}
								equippedSword = (Sword) item;
								equippedItems.put("equippedSword", item.getId());
								removeItem(item, 1);
							} else if (item instanceof Shield) {
								if (equippedShield != null) {
									inventoryItems.add(equippedShield);
									equippedShield = null;
									equippedItems.remove("equippedShield");
								}
								equippedShield = (Shield) item;
								equippedItems.put("equippedShield", item.getId());
								removeItem(item, 1);
							} else if (item instanceof Chain) {
								if (equippedChain != null) {
									inventoryItems.add(equippedChain);
									equippedChain = null;
									equippedItems.remove("equippedChain");
								}
								equippedChain = (Chain) item;
								equippedItems.put("equippedChain", item.getId());
								removeItem(item, 1);
							} else if (item instanceof Helmet) {
								if (equippedHelmet != null) {
									inventoryItems.add(equippedHelmet);
									equippedHelmet = null;
									equippedItems.remove("equippedHelmet");
								}
								equippedHelmet = (Helmet) item;
								equippedItems.put("equippedHelmet", item.getId());
								removeItem(item, 1);
							} else if (item instanceof Chestplate) {
								if (equippedChestplate != null) {
									inventoryItems.add(equippedChestplate);
									equippedChestplate = null;
									equippedItems.remove("equippedChestplate");
								}
								equippedChestplate = (Chestplate) item;
								equippedItems.put("equippedChestplate", item.getId());
								removeItem(item, 1);
							} else if (item instanceof Leggins) {
								if (equippedLeggins != null) {
									inventoryItems.add(equippedLeggins);
									equippedLeggins = null;
									equippedItems.remove("equippedLeggins");
								}
								equippedLeggins = (Leggins) item;
								equippedItems.put("equippedLeggins", item.getId());
								removeItem(item, 1);
							} else if (item instanceof Boots) {
								if (equippedBoots != null) {
									inventoryItems.add(equippedBoots);
									equippedBoots = null;
									equippedItems.remove("equippedBoots");
								}
								equippedBoots = (Boots) item;
								equippedItems.put("equippedBoots", item.getId());
								removeItem(item, 1);
							}
						}
					}
					if (equipSlot1.contains(e.getPoint())) {
						if (equippedRing != null) {
							inventoryItems.add(equippedRing);
							equippedRing = null;
							equippedItems.remove("equippedRing");
						}
					} else if (equipSlot2.contains(e.getPoint())) {
						if (equippedSword != null) {
							inventoryItems.add(equippedSword);
							equippedSword = null;
							equippedItems.remove("equippedSword");
						}
					} else if (equipSlot3.contains(e.getPoint())) {
						if (equippedShield != null) {
							inventoryItems.add(equippedShield);
							equippedShield = null;
							equippedItems.remove("equippedShield");
						}
					} else if (equipSlot4.contains(e.getPoint())) {
						if (equippedChain != null) {
							inventoryItems.add(equippedChain);
							equippedChain = null;
							equippedItems.remove("equippedChain");
						}
					} else if (equipSlot5.contains(e.getPoint())) {
						if (equippedHelmet != null) {
							inventoryItems.add(equippedHelmet);
							equippedHelmet = null;
							equippedItems.remove("equippedHelmet");
						}
					} else if (equipSlot6.contains(e.getPoint())) {
						if (equippedChestplate != null) {
							inventoryItems.add(equippedChestplate);
							equippedChestplate = null;
							equippedItems.remove("equippedChestplate");
						}
					} else if (equipSlot7.contains(e.getPoint())) {
						if (equippedLeggins != null) {
							inventoryItems.add(equippedLeggins);
							equippedLeggins = null;
							equippedItems.remove("equippedLeggins");
						}
					} else if (equipSlot8.contains(e.getPoint())) {
						if (equippedBoots != null) {
							inventoryItems.add(equippedBoots);
							equippedBoots = null;
							equippedItems.remove("equippedBoots");
						}
					}
				}
			}
		};
		handler.addMouseListener(mA);

		KeyAdapter kA = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_E)
					active = !active;
				if (e.getKeyCode() == KeyEvent.VK_W)
					selectedItem--;
				if (e.getKeyCode() == KeyEvent.VK_S)
					selectedItem++;
				if (e.getKeyCode() == KeyEvent.VK_Q) {

					if (inventoryItems.size() != 0) {
						handler.getWorld().getItemManager().addItem(inventoryItems.get(selectedItem).createNew(
								(int) handler.getWorld().player.getX(), (int) handler.getWorld().player.getY() + 75));

						int itemCount = inventoryItems.get(selectedItem).getCount();
						if (itemCount > 1) {
							inventoryItems.get(selectedItem).setCount(itemCount - 1);
						} else if (itemCount == 1) {
							inventoryItems.remove(selectedItem);
							selectedItem = 0;
						} else {
							// do nothing
						}
					}
				}
			}
		};
		handler.addKeyListener(kA);
	}

	public void tick() {
		itMenu.tick();
		itMenu.setInventoryItems(inventoryItems);
		itMenu.setSelectedItem(selectedItem);

		updateItemEffects();

		iTick++;
		// itemActions();
		if (disabled) {
			active = false;
		}
		if (!active)
			return;

		if (selectedItem < 0)
			selectedItem = inventoryItems.size() - 1;
		else if (selectedItem >= inventoryItems.size())
			selectedItem = 0;
	}

	public void render(Graphics g) {
		itMenu.render(g);
		if (!active)
			return;
		g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);

		int len = inventoryItems.size();
		if (len == 0)
			return;

		for (int i = -5; i < 6; i++) {
			if (selectedItem + i < 0 || selectedItem + i >= len)
				continue;
			
		String itemName = inventoryItems.get(selectedItem + i).getName();
		if(itemName.length()<=13) {
			if (i == 0) {
				Text.drawString(g, "> " + itemName + " <", invListCenterX,
						invListCenterY + i * invListSpacing, true, Color.YELLOW, Assets.font28);
			} else {
				Text.drawString(g, itemName, invListCenterX,
						invListCenterY + i * invListSpacing, true, Color.WHITE, Assets.font28);
			}
		}else {
			String newItemName = itemName;
			//every second
			int iCharCounter=0;
				if(iTick==60) {
					iTick=0;
					if(iCharCounter<=itemName.length()-13) {
						System.out.println("iCharCounter"+iCharCounter);
					iCharCounter++;
					newItemName=itemName.substring(iCharCounter);
					}else {
						iCharCounter=0;
						newItemName=itemName;
					}
				}
			if (i == 0) {
				Text.drawString(g, "> " + newItemName + " <", invListCenterX,
						invListCenterY + i * invListSpacing, true, Color.YELLOW, Assets.font28);
			} else {
				Text.drawString(g, newItemName, invListCenterX,
						invListCenterY + i * invListSpacing, true, Color.WHITE, Assets.font28);
			}
		}
		}if(selectedItem<inventoryItems.size()&&selectedItem>=0)

	{
		Item item = inventoryItems.get(selectedItem);
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
		Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE, Assets.font28);
		g.setFont(Assets.font14);
		Text.drawStringMultiLine(g, item.getDescription(), itemDescWidth, itemDescX, itemDescY);
		// show equip button
		if (item instanceof ArmorItem) {
			if (item != equippedRing && item != equippedSword && item != equippedShield && item != equippedChain
					&& item != equippedHelmet && item != equippedChestplate && item != equippedLeggins
					&& item != equippedBoots) {
				g.drawImage(Assets.btn_equip, equipButtonX, equipButtonY, equipButtonWidth, equipButtonHeight, null);
			} else {
				g.drawImage(Assets.btn_unequip, equipButtonX, equipButtonY, equipButtonWidth, equipButtonHeight, null);
			}
		}
	}
	// EQUIPMENT
	if(equippedRing!=null)
	{
		g.drawImage(equippedRing.getTexture(), equipSlotX1, equipSlotY1, equipSlotImageWidth, equipSlotImageHeight,
				null);
	}if(equippedSword!=null)
	{
		g.drawImage(equippedSword.getTexture(), equipSlotX2, equipSlotY2, equipSlotImageWidth, equipSlotImageHeight,
				null);
	}if(equippedShield!=null)
	{
		g.drawImage(equippedShield.getTexture(), equipSlotX3, equipSlotY3, equipSlotImageWidth, equipSlotImageHeight,
				null);
	}if(equippedChain!=null)
	{
		g.drawImage(equippedChain.getTexture(), equipSlotX4, equipSlotY4, equipSlotImageWidth, equipSlotImageHeight,
				null);
	}if(equippedHelmet!=null)
	{
		g.drawImage(equippedHelmet.getTexture(), equipSlotX5, equipSlotY5, equipSlotImageWidth, equipSlotImageHeight,
				null);
	}if(equippedChestplate!=null)
	{
		g.drawImage(equippedChestplate.getTexture(), equipSlotX6, equipSlotY6, equipSlotImageWidth,
				equipSlotImageHeight, null);
	}if(equippedLeggins!=null)
	{
		g.drawImage(equippedLeggins.getTexture(), equipSlotX7, equipSlotY7, equipSlotImageWidth, equipSlotImageHeight,
				null);
	}if(equippedBoots!=null)
	{
		g.drawImage(equippedBoots.getTexture(), equipSlotX8, equipSlotY8, equipSlotImageWidth, equipSlotImageHeight,
				null);
	}
	// EFFECTS
	Text.drawString(g,"+"+armorPointsB+" Armor Points",effect1X,effect1Y,true,Color.GREEN,Assets.font16);Text.drawString(g,"+"+speedPointsB+" Speed Points",effect2X,effect2Y,true,Color.GREEN,Assets.font16);Text.drawString(g,"+"+manaPointsB+" Mana Points",effect3X,effect3Y,true,Color.GREEN,Assets.font16);Text.drawString(g,"+"+manaRegenerationPointsB+" Mana Reg. Points",effect4X,effect4Y,true,Color.GREEN,Assets.font16);Text.drawString(g,"+"+healthRegenerationPointsB+" Health Reg. Points",effect5X,effect5Y,true,Color.GREEN,Assets.font16);Text.drawString(g,"+"+attackDamageB+" Attack Damage",effect6X,effect6Y,true,Color.GREEN,Assets.font16);

	}
	// Inventory methods

	public void addItem(Item item) {
		debugItems();
		System.out.println("Add item(" + item.getId() + ") count: " + item.getCount());
		for (Item i : inventoryItems) {
			if (i.getId() == item.getId()) {
				System.out.println("exis item(" + item.getId() + ") count: " + i.getCount());
				int count = i.getCount() + item.getCount();
				System.out.println("set count: " + i.getCount() + "+" + item.getCount() + "=" + count);
				i.setCount(i.getCount() + item.getCount());
				System.out.println("final count: " + i.getCount());
				debugItems();
				return;
			}
		}
		inventoryItems.add(item);
	}

	private void debugItems() {
		System.out.println("ITEM DEBUG");
		for (Item i : inventoryItems) {
			System.out.println(i.getName() + "(" + i.getId() + "): " + i.getCount());
		}
		System.out.println("DEBUG END");
	}

	private void removeItem(Item item, int amount) {
		for (Item i : inventoryItems) {
			if (i.getId() == item.getId()) {
				if (i.getCount() >= 1) {
					if (i.getCount() > 1) {
						i.setCount(i.getCount() - amount);
					} else {
						System.out.println("count: " + i.getCount() + ", item: " + i.getName() + "," + i.getId());
						inventoryItems.remove(i);
					}
				}
				return;
			}
		}
	}

	private void updateItemEffects() {
		armorPointsB = 0;
		speedPointsB = 0.0f;
		manaPointsB = 0;
		manaRegenerationPointsB = 0;
		healthRegenerationPointsB = 0;
		attackDamageB = 0;
		usedManaPointsB = 0;
		ignitionDurationB = 0;
		slownessDurationB = 0;
		if (equippedBoots != null) {
			armorPointsB = armorPointsB + equippedBoots.getArmorPoints();
			speedPointsB = speedPointsB + equippedBoots.getSpeedPoints();
			manaPointsB = manaPointsB + equippedBoots.getManaPoints();
			manaRegenerationPointsB = manaRegenerationPointsB + equippedBoots.getManaRegenerationPoints();
			healthRegenerationPointsB = healthRegenerationPointsB + equippedBoots.getHealthRegenerationPoints();
			attackDamageB = attackDamageB + equippedBoots.getAttackDamage();
			usedManaPointsB = usedManaPointsB + equippedBoots.getUsedManaPoints();
			ignitionDurationB = ignitionDurationB + equippedBoots.getIgnitionDuration();
			slownessDurationB = slownessDurationB + equippedBoots.getSlownessDuration();
		}
		if (equippedChain != null) {
			armorPointsB = armorPointsB + equippedChain.getArmorPoints();
			speedPointsB = speedPointsB + equippedChain.getSpeedPoints();
			manaPointsB = manaPointsB + equippedChain.getManaPoints();
			manaRegenerationPointsB = manaRegenerationPointsB + equippedChain.getManaRegenerationPoints();
			healthRegenerationPointsB = healthRegenerationPointsB + equippedChain.getHealthRegenerationPoints();
			attackDamageB = attackDamageB + equippedChain.getAttackDamage();
			usedManaPointsB = usedManaPointsB + equippedChain.getUsedManaPoints();
			ignitionDurationB = ignitionDurationB + equippedChain.getIgnitionDuration();
			slownessDurationB = slownessDurationB + equippedChain.getSlownessDuration();
		}
		if (equippedChestplate != null) {
			armorPointsB = armorPointsB + equippedChestplate.getArmorPoints();
			speedPointsB = speedPointsB + equippedChestplate.getSpeedPoints();
			manaPointsB = manaPointsB + equippedChestplate.getManaPoints();
			manaRegenerationPointsB = manaRegenerationPointsB + equippedChestplate.getManaRegenerationPoints();
			healthRegenerationPointsB = healthRegenerationPointsB + equippedChestplate.getHealthRegenerationPoints();
			attackDamageB = attackDamageB + equippedChestplate.getAttackDamage();
			usedManaPointsB = usedManaPointsB + equippedChestplate.getUsedManaPoints();
			ignitionDurationB = ignitionDurationB + equippedChestplate.getIgnitionDuration();
			slownessDurationB = slownessDurationB + equippedChestplate.getSlownessDuration();
		}
		if (equippedHelmet != null) {
			armorPointsB = armorPointsB + equippedHelmet.getArmorPoints();
			speedPointsB = speedPointsB + equippedHelmet.getSpeedPoints();
			manaPointsB = manaPointsB + equippedHelmet.getManaPoints();
			manaRegenerationPointsB = manaRegenerationPointsB + equippedHelmet.getManaRegenerationPoints();
			healthRegenerationPointsB = healthRegenerationPointsB + equippedHelmet.getHealthRegenerationPoints();
			attackDamageB = attackDamageB + equippedHelmet.getAttackDamage();
			usedManaPointsB = usedManaPointsB + equippedHelmet.getUsedManaPoints();
			ignitionDurationB = ignitionDurationB + equippedHelmet.getIgnitionDuration();
			slownessDurationB = slownessDurationB + equippedHelmet.getSlownessDuration();
		}
		if (equippedLeggins != null) {
			armorPointsB = armorPointsB + equippedLeggins.getArmorPoints();
			speedPointsB = speedPointsB + equippedLeggins.getSpeedPoints();
			manaPointsB = manaPointsB + equippedLeggins.getManaPoints();
			manaRegenerationPointsB = manaRegenerationPointsB + equippedLeggins.getManaRegenerationPoints();
			healthRegenerationPointsB = healthRegenerationPointsB + equippedLeggins.getHealthRegenerationPoints();
			attackDamageB = attackDamageB + equippedLeggins.getAttackDamage();
			usedManaPointsB = usedManaPointsB + equippedLeggins.getUsedManaPoints();
			ignitionDurationB = ignitionDurationB + equippedLeggins.getIgnitionDuration();
			slownessDurationB = slownessDurationB + equippedLeggins.getSlownessDuration();
		}
		if (equippedRing != null) {
			armorPointsB = armorPointsB + equippedRing.getArmorPoints();
			speedPointsB = speedPointsB + equippedRing.getSpeedPoints();
			manaPointsB = manaPointsB + equippedRing.getManaPoints();
			manaRegenerationPointsB = manaRegenerationPointsB + equippedRing.getManaRegenerationPoints();
			healthRegenerationPointsB = healthRegenerationPointsB + equippedRing.getHealthRegenerationPoints();
			attackDamageB = attackDamageB + equippedRing.getAttackDamage();
			usedManaPointsB = usedManaPointsB + equippedRing.getUsedManaPoints();
			ignitionDurationB = ignitionDurationB + equippedRing.getIgnitionDuration();
			slownessDurationB = slownessDurationB + equippedRing.getSlownessDuration();
		}
		if (equippedShield != null) {
			armorPointsB = armorPointsB + equippedShield.getArmorPoints();
			speedPointsB = speedPointsB + equippedShield.getSpeedPoints();
			manaPointsB = manaPointsB + equippedShield.getManaPoints();
			manaRegenerationPointsB = manaRegenerationPointsB + equippedShield.getManaRegenerationPoints();
			healthRegenerationPointsB = healthRegenerationPointsB + equippedShield.getHealthRegenerationPoints();
			attackDamageB = attackDamageB + equippedShield.getAttackDamage();
			usedManaPointsB = usedManaPointsB + equippedShield.getUsedManaPoints();
			ignitionDurationB = ignitionDurationB + equippedShield.getIgnitionDuration();
			slownessDurationB = slownessDurationB + equippedShield.getSlownessDuration();
		}
		if (equippedSword != null) {
			armorPointsB = armorPointsB + equippedSword.getArmorPoints();
			speedPointsB = speedPointsB + equippedSword.getSpeedPoints();
			manaPointsB = manaPointsB + equippedSword.getManaPoints();
			manaRegenerationPointsB = manaRegenerationPointsB + equippedSword.getManaRegenerationPoints();
			healthRegenerationPointsB = healthRegenerationPointsB + equippedSword.getHealthRegenerationPoints();
			attackDamageB = attackDamageB + equippedSword.getAttackDamage();
			usedManaPointsB = usedManaPointsB + equippedSword.getUsedManaPoints();
			ignitionDurationB = ignitionDurationB + equippedSword.getIgnitionDuration();
			slownessDurationB = slownessDurationB + equippedSword.getSlownessDuration();
		}

		player.setMaxHealth(player.getDefaultMaxHealth() + armorPointsB);
		player.setSpeed(player.getDefaultSpeed() + speedPointsB);
		player.setMaxMana(player.getDefaultMaxMana() + manaPointsB);
		player.setManaRegenSpeed(player.getDefaultManaRegenSpeed() + manaRegenerationPointsB);
		player.setHealthRegenSpeed(player.getDefaultHealthRegenSpeed() + healthRegenerationPointsB);
		player.setDamagePerHit(player.getDefaultDamagePerHit() + attackDamageB);

	}

	public void loadEquippedItems() {
		System.out.println("Loading Equipped Items");
		Iterator it = equippedItems.entrySet().iterator();
		ItemManager itManager = new ItemManager(handler);
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (pair.getKey().equals("equippedRing")) {
				equippedRing = (Ring) itManager.getItemByID((int) pair.getValue());
			}
			if (pair.getKey().equals("equippedSword")) {
				equippedSword = (Sword) itManager.getItemByID((int) pair.getValue());
			}
			if (pair.getKey().equals("equippedShield")) {
				equippedShield = (Shield) itManager.getItemByID((int) pair.getValue());
			}
			if (pair.getKey().equals("equippedChain")) {
				equippedChain = (Chain) itManager.getItemByID((int) pair.getValue());
			}
			if (pair.getKey().equals("equippedHelmet")) {
				equippedHelmet = (Helmet) itManager.getItemByID((int) pair.getValue());
			}
			if (pair.getKey().equals("equippedChestplate")) {
				equippedChestplate = (Chestplate) itManager.getItemByID((int) pair.getValue());
			}
			if (pair.getKey().equals("equippedLeggins")) {
				equippedLeggins = (Leggins) itManager.getItemByID((int) pair.getValue());
			}
			if (pair.getKey().equals("equippedBoots")) {
				equippedBoots = (Boots) itManager.getItemByID((int) pair.getValue());
			}
			it.remove();
		}
		itManager = null;
	}

//	private void itemActions() {
//		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_B)) {
//			itM.setActive(true);
//		}
//	}
	// GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public boolean isActive() {
		return active;
	}

	public ArrayList getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(ArrayList inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	public void setSelectedItem(int slotID) {
		if (inventoryItems.size() > slotID) {
			selectedItem = slotID;
		}
	}

	public void disableInventory(boolean disabled) {
		this.disabled = disabled;
	}

	public HashMap<String, Integer> getEquippedItems() {
		return equippedItems;
	}

	public void setEquippedItems(HashMap<String, Integer> equippedItems) {
		this.equippedItems = equippedItems;
	}
}
