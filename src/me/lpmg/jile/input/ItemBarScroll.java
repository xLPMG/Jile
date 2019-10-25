package me.lpmg.jile.input;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import me.lpmg.jile.Handler;
import me.lpmg.jile.inventory.ItemBar;

public class ItemBarScroll implements MouseWheelListener{

	private ItemBar itemBar;
	private boolean initializedItemBar = false;
	private Handler handler;
	
	public void transmitHandler(Handler handler) {
		this.handler=handler;
	}
	
	private void initItemBar() {
		System.out.println("about to init");
		if(handler!=null) {
			if(handler.getWorld()!=null) {
			itemBar = handler.getWorld().player.getItemBar();
			System.out.println("itembar: "+itemBar);
			initializedItemBar=true;
			}
		}
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(!initializedItemBar) {
			initItemBar();
		}else {
		
	        if (e.getWheelRotation() > 0) {
	        	itemBar.scrollUpByOne();
	        } else if(e.getWheelRotation() < 0) {
	           itemBar.scrollDownByOne();
	        }  
	}
	}
}
