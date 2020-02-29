package me.lpmg.jile.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.items.armor.Boots;
import me.lpmg.jile.items.armor.Chain;
import me.lpmg.jile.items.armor.Chestplate;
import me.lpmg.jile.items.armor.Helmet;
import me.lpmg.jile.items.armor.Ring;
import me.lpmg.jile.items.armor.Shield;
import me.lpmg.jile.items.armor.Sword;

public class Item {
	
	// Handler
	
	public static Item[] items = new Item[256];
	
	//Assets, Item Name, ID, buyingPrice,sellingPrice
	public static Item woodItem = new Item(Assets.woodItem, "Wood", 0, 2, 2, "Ordinary piece of wood.");
	public static Item rockItem = new Item(Assets.rockItem, "Rock", 1, 3, 3, "A hard and round rock.");
	
	//public static Item swordJinaOld = new Sword(Assets.rockItem, "Old Sword", 1, 0, 0, "An old sword which was use by Jina for many years.", 10);
	public static Item swordNormal = new Sword(Assets.sword_normal, "Normal Sword", 11, 0, 0, "Just a normal sword.", 9);
	public static Item swordCommon = new Sword(Assets.sword_common, "Common Sword", 12, 0, 0, "Just a common sword.", 10);
	
	public static Item chestplate_metal_1 = new Chestplate(Assets.chestplate_metal_1, "Metal Chestplate", 21, 0, 0, "x", 10, -1.0f);
	
	public static Item chain_1 = new Chain(Assets.chain_1, "Common Chain", 31, 0, 0, "x", 10, 2, 4);
	
	public static Item boots_leather_1 = new Boots(Assets.boots_leather_1, "Ordinary Leather Boots", 41, 0, 0, "x", 5, 1.0f);
	
	public static Item helmet_metal_1 = new Helmet(Assets.helmet_metal_1, "Metal Helmet", 51, 0, 0, "x", 4);
	
	public static Item ring_metal_1 = new Ring(Assets.ring_metal_1, "Common Metal Ring", 61, 0, 0, "x", 5, 3, 3);
	
	public static Item shield_metal_1 = new Shield(Assets.shield_metal_1, "Metal Shield", 71, 0, 0, "x", 10);
	
	// Class
	
	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
	
	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;
	protected int sellingPrice;
	protected int buyingPrice;
	protected String description;
	
	protected Rectangle bounds;
	
	protected int x, y, count;
	protected boolean pickedUp = false;
	
	public Item(BufferedImage texture, String name, int id, int buyingPrice, int sellingPrice, String description){
		this.texture = texture;
		this.name = name;
		this.id = id;
		this.buyingPrice=buyingPrice;
		this.sellingPrice=sellingPrice;
		this.description=description;
		count = 1;
		
		bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);
		
		System.out.println("ID "+id);
		items[id] = this;
	}

	public void tick(){
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)){
			pickedUp = true;
			handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
		}
	}
	
	public void render(Graphics g){
		if(handler == null)
			return;
		render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}
	
	public Item createNew(int count){
		Item i = new Item(texture, name, id, buyingPrice, sellingPrice, description);
		i.setPickedUp(true);
		i.setCount(count);
		return i;
	}
	
	public Item createNew(int x, int y){
		Item i = new Item(texture, name, id, buyingPrice, sellingPrice, description);
		i.setPosition(x, y);
		return i;
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}
	
	// Getters and Setters
	
	public Handler getHandler() {
		return handler;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}
	
	public int getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(int buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}

}
