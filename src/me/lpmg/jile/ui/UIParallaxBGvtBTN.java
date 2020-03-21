package me.lpmg.jile.ui;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import me.lpmg.jile.gfx.Assets;

public class UIParallaxBGvtBTN extends UIObject {

	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;
	private BufferedImage[] buttonImages;
	private ClickListener clicker;
	private String text;
	private String version;
	private String hint;

	private int tickCount=0;
	private int tickCountNoWait=0;
	private int waitCount=0;

	public UIParallaxBGvtBTN(float x, float y, int width, int height, String text, String version,BufferedImage image1, BufferedImage image2,
			BufferedImage image3, BufferedImage image4, BufferedImage image5,BufferedImage image6, BufferedImage[] buttonImages, ClickListener clicker) {
		super(x, y, width, height);
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		this.image6 = image6;
		this.buttonImages=buttonImages;
		this.text = text;
		this.version = version;
		this.clicker=clicker;
		hint="(click to play)";
	}

	@Override
	public void tick() {

		if(waitCount<200) {
			waitCount++;
		}
		if(waitCount>=200) {
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
			g.drawImage(image3, (int) x, (int) y + tickCount / 20, scaledImage3Width, height, null);
		}
		if (image4 != null) {

			int scaledImage4Width = (int) (((double) height / (double) image4.getHeight())
					* (double) image4.getWidth());
			g.drawImage(image4, (int) x, (int) y + tickCount / 5, scaledImage4Width, height, null);
		}
		if (image5 != null) {

			int scaledImage5Width = (int) (((double) height / (double) image5.getHeight())
					* (double) image5.getWidth());
			g.drawImage(image5, (int) x, (int) y + tickCount/2, scaledImage5Width, height, null);
		}
		if (image6 != null) {
			int scaledImage6Width = (int) (((double) height / (double) image6.getHeight())
					* (double) image6.getWidth());
			g.drawImage(image6, (int) x, (int) y + tickCount, scaledImage6Width, height, null);
		}

		Rectangle rect = new Rectangle(width, height);
		FontMetrics metrics96 = g.getFontMetrics(Assets.font96);
		FontMetrics metrics14 = g.getFontMetrics(Assets.font14);
		FontMetrics metrics16 = g.getFontMetrics(Assets.font16);
		
		int drawXTitle = rect.x + (rect.width - metrics96.stringWidth(text)) / 2;
		int drawY = (int) (y + tickCount) - 200;
		Graphics g2 = g;
		
		if (drawY <= height / 3+(height/8)) {
			g.setFont(Assets.font96);
			g.drawString(text, drawXTitle, drawY);
		} else {
			g.setFont(Assets.font96);
			g.drawString(text, drawXTitle,  height / 3+(height/8));
			g2.setFont(Assets.font14);
			
			int drawXSubtitle = rect.x + (rect.width - metrics14.stringWidth(hint)) / 2;
			g2.drawString(hint, drawXSubtitle,  (height/3+(height/8))+16);
		}
		
		g2.setFont(Assets.font16);
		g2.drawString(version, width - metrics16.stringWidth(version), height-8);

	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}
