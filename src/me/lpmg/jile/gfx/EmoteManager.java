package me.lpmg.jile.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.lpmg.jile.Handler;

public class EmoteManager {
	
	private BufferedImage image; 
	private int x; 
	private int y; 
	private int width; 
	private int height;
	private Handler handler;
	
	private boolean draw=false;
	
	public EmoteManager(Handler handler) {
		this.handler=handler;
	}
	
	public void showEmote(BufferedImage image, int x, int y, int width, int height) {
		this.image=image;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		draw=true;
	}
	
	public void render(Graphics g) {
		if(!draw) {
			return;
		}
		g.drawImage(image, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	public void stopShowingEmote() {
		draw=false;
	}
	
}
