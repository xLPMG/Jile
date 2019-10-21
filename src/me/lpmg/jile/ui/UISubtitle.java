package me.lpmg.jile.ui;

import java.awt.Font;
import java.awt.Graphics;

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
		g.setFont(font28); 
		g.drawString(text, (int) x, (int) y);
	}

	@Override
	public void onClick() {		
	}

}
