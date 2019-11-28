package me.lpmg.jile.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.gfx.FontLoader;

public class UISubtitleWhite extends UIObject{

	private String text;
	
	public UISubtitleWhite(float x, float y, int width, int height, String text) {
		super(x, y, width, height);
		this.text = text;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {	
		Rectangle rect = new Rectangle(width, height);
		FontMetrics metrics = g.getFontMetrics(Assets.font28);
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    //int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    g.setColor(Color.white);
	    g.setFont(Assets.font28);
	    g.drawString(text, x, (int) y);
	}

	@Override
	public void onClick() {		
	}

}
