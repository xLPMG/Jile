package me.lpmg.jile.miscgui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.creatures.Player;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.gfx.Text;

public class StatsGUI {

	private Handler handler;
	private Player player;
	private Graphics g;

	private int iTick;

	private int prevX;
	private int fullX;
	private int y;

	private int prevWidth = 8, height = 384;
	private int fullWidth = 200;

	private int drawX = 8;
	private int lastDrawnX = 0;

	private Rectangle triggerArea;

	private boolean isShowing = false;
	private boolean movingToPrev = false;

	public StatsGUI(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		prevX = handler.getWidth() - prevWidth;
		y = handler.getHeight()/2-height/2;
		fullX = handler.getWidth() - fullWidth;
		triggerArea = new Rectangle(prevX, y, prevWidth, height);

		MouseAdapter mA = new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (triggerArea.contains(e.getPoint())) {
					if (!isShowing) {
						showFull();
					}
				} else {
					if (isShowing) {
						showPrev();
					}
				}
			}
		};
		handler.addMouseListener(mA);
		handler.addMouseMotionListener(mA);
	}

	public void tick() {		
		iTick += 10;
	}

	public void render(Graphics g) {
		this.g = g;

		if (!isShowing && !movingToPrev) {
			g.drawImage(Assets.statsGUI_prev, prevX, y, prevWidth, height, null);
			iTick = 0;
		} else {
			if (!movingToPrev) {
				if (iTick <= fullWidth) {
					drawX = handler.getWidth() - iTick;
					lastDrawnX=drawX;
					g.drawImage(Assets.statsGUI_full, drawX, y, fullWidth, height, null);
				} else {
					g.drawImage(Assets.statsGUI_full, fullX, y, fullWidth, height, null);
				}
			}
		}

		if (movingToPrev) {
			isShowing = false;

			if (iTick <= fullWidth&&drawX<=prevX) {
				drawX = lastDrawnX + iTick;
				g.drawImage(Assets.statsGUI_full, drawX, y, fullWidth, height, null);
			} else {
				movingToPrev = false;
			}
		}
		
		if(isShowing||movingToPrev) {
			Text.drawString(g, "Stats:", drawX+8, y+24, false, Color.WHITE, Assets.font28);
			
			int marginTop = 48;
			int spacing = 20;
			
			Text.drawString(g, "Health: "+player.getHealth()+"/"+player.getMaxHealth(), drawX+10, y+marginTop, false, Color.WHITE, Assets.font16);
			Text.drawString(g, "Mana: "+player.getMana()+"/"+player.getMaxMana(), drawX+10, y+marginTop+spacing, false, Color.WHITE, Assets.font16);
			Text.drawString(g, "XP: "+player.getXp()+"/"+player.getMaxXP(), drawX+10, y+marginTop+spacing*2, false, Color.WHITE, Assets.font16);
			Text.drawString(g, "Level: "+player.getLvl(), drawX+10, y+marginTop+spacing*3, false, Color.WHITE, Assets.font16);
			Text.drawString(g, "Speed: "+player.getSpeed(), drawX+10, y+marginTop+spacing*4, false, Color.WHITE, Assets.font16);
			
			Text.drawString(g, "Deaths: "+player.getDeathCount(), drawX+10, y+marginTop+spacing*6, false, Color.WHITE, Assets.font16);
			Text.drawString(g, "Total Earned   :", drawX+10, y+marginTop+spacing*7, false, Color.WHITE, Assets.font16);
			g.drawImage(Assets.coin, drawX+142, (y+marginTop+spacing*7)-12, 16,16,null);
			Text.drawString(g, player.getTotalEarnedMoney()+"", drawX+10, y+marginTop+spacing*8, false, Color.WHITE, Assets.font16);
			Text.drawString(g, "Total Time Played: ", drawX+10, y+marginTop+spacing*9, false, Color.WHITE, Assets.font16);
			int time = handler.getWorld().getTimePlayed();
			int numberOfDays = time / 86400;
			int numberOfHours = (time % 86400 ) / 3600 ;
			int numberOfMinutes = ((time % 86400 ) % 3600 ) / 60;
			int numberOfSeconds = ((time % 86400 ) % 3600 ) % 60  ;
			Text.drawString(g, numberOfDays+"d "+numberOfHours+"h "+numberOfMinutes+"m "+numberOfSeconds+"s ", drawX+10, y+marginTop+spacing*10, false, Color.WHITE, Assets.font16);
		}
//		else {
//			g.drawImage(Assets.statsGUI_full, fullX, y, fullWidth, height, null);
//		}
	}

	private void showFull() {
		iTick = 0;
		drawX = 8;
		isShowing = true;
	}

	private void showPrev() {
		iTick = 0;
		movingToPrev = true;
	}

	// GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
