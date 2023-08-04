package me.lpmg.jile.ui;

import java.awt.Graphics;

import me.lpmg.jile.gfx.Assets;

public class UICheckbox extends UIObject {

	public UICheckbox(float x, float y, int width, int height, boolean active) {
		super(x, y, width, height);
		this.active = active;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		if (active) {
			g.drawImage(Assets.checkbox_on, (int) x, (int) y, width, height, null);
		} else {
			g.drawImage(Assets.checkbox_off, (int) x, (int) y, width, height, null);
		}
	}

	protected void activated() {}

	protected void deactivated() {}

	@Override
	public void onClick() {
		if (active) {
			activated();
		} else {
			deactivated();
		}
	}

}
