package me.lpmg.jile.ui;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class UIParallaxBGhz extends UIObject {

	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;

	private int tickCount;

	public UIParallaxBGhz(float x, float y, int width, int height, BufferedImage image1, BufferedImage image2,
			BufferedImage image3, BufferedImage image4, BufferedImage image5) {
		super(x, y, width, height);
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
	}

	@Override
	public void tick() {

		if (tickCount < 1500) {
			tickCount++;
		} else {
			tickCount = 0;
		}
	}

	@Override
	public void render(Graphics g) {
		int scaledImage1Width = (int) (((double) height / (double) image1.getHeight()) * (double) image1.getWidth());
		g.drawImage(image1, (int) x, (int) y, scaledImage1Width, height, null);

		if (image2 != null) {
			BufferedImage subImage2 = image2.getSubimage(tickCount / 80, 0, image2.getWidth() - (tickCount / 80),
					image2.getHeight());
			g.drawImage(subImage2, (int) x, (int) y, width, height, null);
		}
		if (image3 != null) {
			BufferedImage subImage3 = image3.getSubimage(tickCount / 40, 0, (image3.getWidth() / 2) + (tickCount / 40),
					image3.getHeight());
			int scaledImage3Width = (height / subImage3.getHeight()) * subImage3.getWidth();
			g.drawImage(subImage3, (int) x, (int) y, scaledImage3Width, height, null);
		}
		if (image4 != null) {
			BufferedImage subImage4 = image4.getSubimage(tickCount / 20, 0, (image4.getWidth() / 2) + (tickCount / 20),
					image4.getHeight());
			int scaledImage4Width = (height / subImage4.getHeight()) * subImage4.getWidth();
			g.drawImage(subImage4, (int) x, (int) y, scaledImage4Width, height, null);
		}
		if (image5 != null) {
			BufferedImage subImage5 = image5.getSubimage(tickCount / 10, 0, (image5.getWidth() / 2) + (tickCount / 10),
					image5.getHeight());
			int scaledImage5Width = (height / subImage5.getHeight()) * subImage5.getWidth();
			g.drawImage(subImage5, (int) x, (int) y, scaledImage5Width, height, null);
		}


	}

	@Override
	public void onClick() {
	}

}
