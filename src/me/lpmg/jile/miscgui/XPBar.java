package me.lpmg.jile.miscgui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.lpmg.jile.Handler;
import me.lpmg.jile.entities.creatures.Player;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.gfx.Text;

public class XPBar {

	private Handler handler;
	private Player player;
	private int xp;
	private int lvl;
	private int maxXP;
	private BufferedImage xpBar;
	private int x;
	private int y;
	private int zoom = 2;
	private int barWidth = 287 * zoom, barHeight = 10 * zoom;
	private boolean levelUpAnim;
	
	public XPBar(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		x = (handler.getWidth() / 2) - (barWidth / 2);
		y = handler.getHeight() - barHeight - (48 * zoom);
	}
	
	public void tick(){
		maxXP = player.getMaxXP();
		xp = player.getXp();
		lvl=player.getLvl();
		if(xp>maxXP) {
			xp=maxXP;
		}
	}
	public void render(Graphics g) {
		g.drawImage(Assets.xpbar_empty, x,y, barWidth, barHeight, null);
		if(maxXP>0) {
		}
		if(xp>0) {
			xpBar = Assets.xpbar_full.getSubimage(0, 0, (int) (287 * ((float)xp / maxXP)), 10);
		g.drawImage(xpBar, x,y, (int) (barWidth * ((float)xp / maxXP)), barHeight,  null);
		}
		
		int lvlWidth = g.getFontMetrics().stringWidth(lvl+"");
		Text.drawString(g, lvl+"", handler.getWidth()/2-(lvlWidth/2), y-4, false, Color.WHITE, Assets.font28);

	}
	
	// GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
