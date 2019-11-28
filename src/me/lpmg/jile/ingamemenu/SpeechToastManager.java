package me.lpmg.jile.ingamemenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Assets;

public class SpeechToastManager {

	private int width = 700;
	private int height = 150;
	private int charIndex;
	private int active;
	private String textToShow;
	private Handler handler;

	private boolean writing;
	private boolean stop = false;
	private boolean requested = false;
	private int showToastCounter;
	private int showToastRequestCounter = 0;

	public SpeechToastManager(Handler handler) {
		this.handler = handler;
	}

	public void showToast(String textInput) {
		requested = true;
		if (showToastRequestCounter == 0) {
			if (writing) {
				stop = true;
				System.out.println("already writing");
			}
			writing = false;
			textToShow = "";
			write(textInput);
		}
	}

	public void tick() {
		System.out.println(writing);
		if (writing) {
			showToastCounter++;
			if (showToastCounter >= 210) {
				writing = false;
				showToastCounter = 0;
			}
		} else {
			showToastCounter = 0;
		}

		if (requested) {
			showToastRequestCounter++;
		}
		if (showToastRequestCounter >= 120) {
			showToastRequestCounter = 0;
			requested = false;
		}
	}

	public void render(Graphics g) {
		g.setFont(Assets.font48);
		String line1 = "";
		String line2 = "";
		String line3 = "";

		if (writing) {
			if (textToShow.contains(":") && !textToShow.endsWith(":")) {
				String[] lines = textToShow.split(":");
				line1 = lines[0];
				line2 = lines[1];
				int count = textToShow.length() - textToShow.replaceAll(":", "").length();
				if (count == 2) {
					line3 = lines[2];
				}
			} else {
				line1 = textToShow;
			}

			g.drawImage(Assets.speechToast, (handler.getWidth() - width) / 2, (handler.getHeight() - height) - 25,
					width, height, null);
			g.setColor(Color.black);
			g.drawString(line1, ((handler.getWidth() - width) / 2) + 10, (handler.getHeight() - height) + 15);
			g.drawString(line2, ((handler.getWidth() - width) / 2) + 10, (handler.getHeight() - height) + 65);
			g.drawString(line3, ((handler.getWidth() - width) / 2) + 10, (handler.getHeight() - height) + 115);
		}
	}

	private void write(String textInput) {
		writing = true;
		Timer timer = new Timer(45, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (stop) {
					((Timer) e.getSource()).stop();
					System.out.println("Stop Timer");
					stop = false;
					writing = false;
				}
				
				String writtenText = textToShow;
				writtenText += textInput.charAt(charIndex);
				textToShow = writtenText;
				charIndex++;
				if (charIndex >= textInput.length()) {
					((Timer) e.getSource()).stop();
					charIndex = 0;
				}
			}
		});
		timer.start();
	}
}
