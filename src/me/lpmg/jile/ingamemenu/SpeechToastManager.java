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
	private String textToShow;
	private Handler handler;

	private boolean writing;
	private boolean stop = false;
	private boolean requested = false;
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
		if (requested) {
			showToastRequestCounter++;
		}
		if (showToastRequestCounter >= 120) {
			showToastRequestCounter = 0;
			requested = false;
		}

		if (handler.getMouseManager().isRightPressed()) {
			if (writing) {
				stop = true;
			}
			writing = false;
			textToShow = "";
		}
	}

	public void render(Graphics g) {
		g.setFont(Assets.font32);
		String line1 = "";
		String line2 = "";
		String line3 = "";
		String line4 = "";
		String line5 = "";

		if (writing) {
			if (textToShow.contains(":") && !textToShow.endsWith(":")) {
				String[] lines = textToShow.split(":");
				int count = textToShow.length() - textToShow.replaceAll(":", "").length();
				line1 = lines[0];

				if (count == 1) {
					line2 = lines[1];
				} else if (count == 2) {
					line2 = lines[1];
					line3 = lines[2];
				} else if (count == 3) {
					line2 = lines[1];
					line3 = lines[2];
					line4 = lines[3];
				} else if (count == 4) {
					line2 = lines[1];
					line3 = lines[2];
					line4 = lines[3];
					line5 = lines[4];
				}
			} else {
				line1 = textToShow;
			}

			g.drawImage(Assets.speechToast, (handler.getWidth() - width) / 2, (handler.getHeight() - height) - 25,
					width, height, null);
			g.setColor(Color.CYAN);
			g.drawString(line1+":", ((handler.getWidth() - width) / 2) + 10, (handler.getHeight() - height) + 5);
			g.setColor(Color.WHITE);
			g.drawString(line2, ((handler.getWidth() - width) / 2) + 10, (handler.getHeight() - height) + 33);
			g.drawString(line3, ((handler.getWidth() - width) / 2) + 10, (handler.getHeight() - height) + 61);
			g.drawString(line4, ((handler.getWidth() - width) / 2) + 10, (handler.getHeight() - height) + 89);
			g.drawString(line5, ((handler.getWidth() - width) / 2) + 10, (handler.getHeight() - height) + 117);
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
