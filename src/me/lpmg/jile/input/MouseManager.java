package me.lpmg.jile.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.Timer;

import me.lpmg.jile.ui.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener, MouseWheelListener {

	private boolean leftPressed, rightPressed;
	private boolean scrolledUp, scrolledDown;
	private int mouseX, mouseY;
	private UIManager uiManager;
	public static final int TIMER_DELAY = 10;
	private Timer wheelMovementTimer;
	
	public MouseManager(){
		
	}
	
	public void setUIManager(UIManager uiManager){
		this.uiManager = uiManager;
	}
	
	// Getters
	
	public boolean isLeftPressed(){
		return leftPressed;
	}
	
	public boolean isRightPressed(){
		return rightPressed;
	}
	
	public boolean didScrollUp(){
		return scrolledUp;
	}
	
	public boolean didScrollDown(){
		return scrolledDown;
	}
	
	
	public int getMouseX(){
		return mouseX;
	}
	
	public int getMouseY(){
		return mouseY;
	}
	
	// Implemented methods
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
		
		if(uiManager != null)
			uiManager.onMouseRelease(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		if(uiManager != null)
			uiManager.onMouseMove(e);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
    	if(e.getWheelRotation()>0) {
    		scrolledUp=true;
    	}else if(e.getWheelRotation()<0) {
    		scrolledDown=true;
    	}
    	
        if (wheelMovementTimer != null && wheelMovementTimer.isRunning()) {
            wheelMovementTimer.stop();
        }
        wheelMovementTimer = new Timer(TIMER_DELAY, new WheelMovementTimerActionListener());
        wheelMovementTimer.setRepeats(false);
        wheelMovementTimer.start();
    }
    private class WheelMovementTimerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	scrolledUp=false;
        	scrolledDown=false;
        }
    }
	


}
