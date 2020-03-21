package me.lpmg.jile.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIBackground extends UIObject{

	private BufferedImage image;
	
	public UIBackground(float x, float y, int width, int height, BufferedImage image) {
		super(x, y, width, height);
		this.image = image;

	}

	@Override
	public void tick() {	
	}

	@Override
	public void render(Graphics g) {		
		int scaledImageWidth=(int) (((double)height/(double)image.getHeight())*(double)image.getWidth());
		g.drawImage(image, (int) x, (int) y, scaledImageWidth, height, null);
		System.out.println(height/image.getHeight()+"/"+height);
	}

	@Override
	public void onClick() {	
	}

}
