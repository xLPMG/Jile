package me.lpmg.jile.ui;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import me.lpmg.jile.gfx.FontLoader;

public class UISubtitle extends UIObject{

	private String text;
	
	public UISubtitle(float x, float y, int width, int height, String text) {
		super(x, y, width, height);
		this.text = text;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {	
		Font font28 = FontLoader.loadFont("jileresources/fonts/slkscr.ttf", 48);
		Rectangle rect = new Rectangle(width, height);
		FontMetrics metrics = g.getFontMetrics(font28);
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    //int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    g.setFont(font28);
	    g.drawString(text, x, (int) y);
	}

	@Override
	public void onClick() {		
	}

}
