package me.lpmg.jile.ingamemenu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.Timer;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.utils.Utils;

public class SpeechToastManager {

	private int width = 700;
	private int height = 150;
	private Handler handler;

	private boolean requested = false;
	private int showToastRequestCounter = 0;
	private int charIndex;
	private String textToShow = "";

	private String speechPath;
	private String speechText;
	private boolean isWriting;

	private boolean stopWriting = false;

	private boolean showText = false;

	public SpeechToastManager(Handler handler, String speechPath) {
		this.handler = handler;
		this.speechPath = speechPath;
	}

	public void showToast(String textID) {
		requested = true;
		if (showToastRequestCounter == 0) {
			if (isWriting) {
				stopWriting = true;
			}else {
				stopWriting = false;
			}
			try {
				String speechText = getSpeech(textID);
				System.out.println(speechText);
				write(speechText);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void tick() {
		if (requested) {
			showToastRequestCounter++;
		}
		if (showToastRequestCounter >= 90) {
			showToastRequestCounter = 0;
			requested = false;
		}

		if (handler.getMouseManager().isRightPressed()) {
			showText = false;
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

		if (showText) {
			if (textToShow.contains("#")) {
				String textToShowNew = textToShow;
				if (textToShow.endsWith("#")) {
					if ((textToShow != null) && (textToShow.length() > 0)) {
						textToShowNew = textToShow.substring(0, textToShow.length() - 1);
					}
				}
				String[] lines = textToShowNew.split("#");
				int count = textToShowNew.length() - textToShowNew.replaceAll("#", "").length();
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
				} else if (count == 5) {
					line2 = lines[2];
					line3 = lines[3];
					line4 = lines[4];
					line5 = lines[5];
				} else if (count == 6) {
					line2 = lines[3];
					line3 = lines[4];
					line4 = lines[5];
					line5 = lines[6];
				} else if (count == 7) {
					line2 = lines[4];
					line3 = lines[5];
					line4 = lines[6];
					line5 = lines[7];
				} else if (count == 8) {
					line2 = lines[5];
					line3 = lines[6];
					line4 = lines[7];
					line5 = lines[8];
				} else if (count == 9) {
					line2 = lines[6];
					line3 = lines[7];
					line4 = lines[8];
					line5 = lines[9];
				}
			} else {
				line1 = textToShow;
			}

			g.drawImage(Assets.speechToast, (handler.getWidth() - width) / 2, (handler.getHeight() - height) - 25,
					width, height, null);
			//colors
			if (line1.startsWith("~c")) {

				line1 = line1.replace("~c", "");
				g.setColor(Color.CYAN);

			} else if (line1.startsWith("~b")) {

				line1 = line1.replace("~b", "");
				g.setColor(Color.BLACK);

			} else if (line1.startsWith("~g")) {

				line1 = line1.replace("~g", "");
				g.setColor(Color.DARK_GRAY);

			} else if (line1.startsWith("~r")) {

				line1 = line1.replace("~r", "");
				g.setColor(Color.RED);

			}else {
				g.setColor(Color.WHITE);
			}
			
			g.drawString(line1, ((handler.getWidth() - width) / 2) + 10, (handler.getHeight() - height) + 4);
			g.setColor(Color.WHITE);
			g.drawString(line2, ((handler.getWidth() - width) / 2) + 10, (handler.getHeight() - height) + 32);
			g.drawString(line3, ((handler.getWidth() - width) / 2) + 10, (handler.getHeight() - height) + 60);
			g.drawString(line4, ((handler.getWidth() - width) / 2) + 10, (handler.getHeight() - height) + 88);
			g.drawString(line5, ((handler.getWidth() - width) / 2) + 10, (handler.getHeight() - height) + 116);
		}
	}

	private void write(String textInput) {
		textToShow = "";
		showText = true;
		isWriting = true;
		Timer timer = new Timer(65, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (stopWriting) {
					((Timer) e.getSource()).stop();
					
					stopWriting = false;
					System.out.println("STOP");
					charIndex = 0;
					textToShow = "";
					isWriting = false;
				}
				String writtenText = textToShow;
				writtenText += textInput.charAt(charIndex);
				textToShow = writtenText;
				charIndex++;
				if (charIndex >= textInput.length()) {
					((Timer) e.getSource()).stop();
					charIndex = 0;
					isWriting = false;
				}
			}
		});
		timer.start();
	}

	private String getSpeech(String textID) throws IOException {
		StringBuilder builder = new StringBuilder();
		BufferedReader speechReader = new BufferedReader(
				new InputStreamReader(Utils.class.getClass().getResourceAsStream(speechPath)));
		try {
			String line;
			while ((line = speechReader.readLine()) != null) {
				if (line.equalsIgnoreCase(textID)) {
					while (!(line = speechReader.readLine()).startsWith("!")) {
						builder.append(line + "#");
					}
				}
			}
		} finally {
			speechReader.close();
		}		
		String speech=builder.toString();
		//variables
		System.out.println(speech);
		if(speech.contains("~playerName")) {
			speech=speech.replace("~playerName", handler.getWorld().player.getPlayerName());
		}
		return speech;
	}
}
