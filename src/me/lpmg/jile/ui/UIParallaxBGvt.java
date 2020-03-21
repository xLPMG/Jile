package me.lpmg.jile.ui;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class UIParallaxBGvt extends UIObject {

	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;
	private String text;
	private String version;

	private int tickCount=0;
	private int tickCountNoWait=0;
	private int waitCount=0;

	public UIParallaxBGvt(float x, float y, int width, int height, String text, String version,BufferedImage image1, BufferedImage image2,
			BufferedImage image3, BufferedImage image4, BufferedImage image5,BufferedImage image6) {
		super(x, y, width, height);
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		this.image6 = image6;
		this.text = text;
		this.version = version;
	}

	@Override
	public void tick() {

		if(waitCount<250) {
			waitCount++;
		}
		if(waitCount>=250) {
		if (tickCount < 3000) {
			tickCount++;
		} else {
			tickCount = 0;
		}
		}
		if (tickCountNoWait < 2729) {
			tickCountNoWait++;
		} else {
			tickCountNoWait = 0;
		}
	}

	@Override
	public void render(Graphics g) {
		int scaledImage1Width = (int) (((double) height / (double) image1.getHeight()) * (double) image1.getWidth());
		g.drawImage(image1, (int) x, (int) y, scaledImage1Width, height, null);

		if (image2 != null) {
			//horizontal movement
			BufferedImage subImage2 = image2.getSubimage(tickCountNoWait / 10, 0, (image2.getWidth() / 2) + (tickCountNoWait / 10),
					image2.getHeight());
			int scaledImage2Width = (height / subImage2.getHeight()) * subImage2.getWidth();
			g.drawImage(subImage2, (int) x, (int) y, scaledImage2Width, height, null);
		}
		if (image3 != null) {

			int scaledImage3Width = (int) (((double) height / (double) image3.getHeight())
					* (double) image3.getWidth());
			g.drawImage(image3, (int) x, (int) y + tickCount / 15, scaledImage3Width, height, null);
		}
		if (image4 != null) {

			int scaledImage4Width = (int) (((double) height / (double) image4.getHeight())
					* (double) image4.getWidth());
			g.drawImage(image4, (int) x, (int) y + tickCount / 10, scaledImage4Width, height, null);
		}
		if (image5 != null) {

			int scaledImage5Width = (int) (((double) height / (double) image5.getHeight())
					* (double) image5.getWidth());
			g.drawImage(image5, (int) x, (int) y + tickCount/5, scaledImage5Width, height, null);
		}
		if (image6 != null) {
			int scaledImage6Width = (int) (((double) height / (double) image6.getHeight())
					* (double) image6.getWidth());
			g.drawImage(image6, (int) x, (int) y + tickCount, scaledImage6Width, height, null);
		}

		Rectangle rect = new Rectangle(width, height);
		FontMetrics metrics = g.getFontMetrics(Assets.font96);
		int drawX = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
		int drawY = (int) (y + tickCount) - 200;
		if (drawY <= height / 3+(height/8)) {
			g.setFont(Assets.font96);
			g.drawString(text, drawX, drawY);
			Graphics g2 = g;
			g2.setFont(Assets.font28);
			g2.drawString(version, drawX + metrics.stringWidth(text), drawY);
		} else {
			g.setFont(Assets.font96);
			g.drawString(text, drawX,  height / 3+(height/8));
			Graphics g2 = g;
			g2.setFont(Assets.font28);
			g2.drawString(version, drawX + metrics.stringWidth(text),  height / 3+(height/8));
		}
	}

	@Override
	public void onClick() {
	}

}
