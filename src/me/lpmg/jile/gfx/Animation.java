package me.lpmg.jile.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	
	private int speed, index;
	private long lastTime, timer, timeOut;
	private BufferedImage[] frames;
	private boolean running = false;
	private boolean first = true;
	private boolean ended = false;
	
	public Animation(int speed, BufferedImage[] frames){
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		timeOut=0;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick(){
		if(!running) return;
		if(timeOut>5000) reset();
		if(first) {first=false;lastTime = System.currentTimeMillis();}
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		timeOut++;
		if(timer > speed){
			index++;
			timer = 0;
			ended=false;
			if(index >= frames.length) {
				ended=true;
				index = 0;
			}
		}
	}
	
	public BufferedImage getCurrentFrame(){
		running=true;
		timeOut=0;
		return frames[index];
	}
	
	public void reset() {
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
		timeOut=0;
		running=false;
		ended=false;
	}
	
	public boolean animEnd() {
		return ended;
	}

}
