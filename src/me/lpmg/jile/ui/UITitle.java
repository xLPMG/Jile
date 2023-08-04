package me.lpmg.jile.ui;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import me.lpmg.jile.gfx.Assets;

public class UITitle extends UIObject{

	private String text;
	private String version="";
	
	public UITitle(float x, float y, int width, int height, String text) {
		super(x, y, width, height);
		this.text = text;
	}
	public UITitle(float x, float y, int width, int height, String text, String version) {
		super(x, y, width, height);
		this.text = text;
		this.version = version;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {	
		Rectangle rect = new Rectangle(width, height);
		FontMetrics metrics = g.getFontMetrics(Assets.font96);
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    //int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    g.setFont(Assets.font96);
	    g.drawString(text, x, (int) y);
	    
	    Graphics g2 = g;
	    g2.setFont(Assets.font28);
	    g2.drawString(version, x+metrics.stringWidth(text), (int) y);
	}

	@Override
	public void onClick() {		
	}

}
