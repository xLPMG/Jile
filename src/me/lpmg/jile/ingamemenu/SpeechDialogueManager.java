package me.lpmg.jile.ingamemenu;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.lpmg.jile.Handler;
import me.lpmg.jile.utils.Utils;

public class SpeechDialogueManager {

	private int width = 700;
	private int height = 150;
	private Handler handler;
	private String speechFolderPath;

	ArrayList<File> speechFiles = new ArrayList<File>();
	HashMap<String, String> speechTexts = new HashMap<String, String>();

	public SpeechDialogueManager(Handler handler, String speechFolderPath) {
		this.handler = handler;
		this.speechFolderPath = speechFolderPath;
	}

	public void init() {
		speechFiles.clear();
		speechTexts.clear();

		loadSpeechFiles();

		for (File speechFile : speechFiles) {
			try {
				String[] resourcePath = speechFile.getAbsolutePath().split("(?=[\\\\]text)");
				resourcePath[1] = resourcePath[1].replaceAll("[\\\\]", "/");
				System.out.println("READING FILE: " + resourcePath[1]);
				loadSpeechText(resourcePath[1]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("--FINAL SPEECH TEXTS--");
		for (String key : speechTexts.keySet()) {
			System.out.println(key + ": " + "\n" + speechTexts.get(key));
		}
	}

	public void render(Graphics g) {

	}

	private void loadSpeechFiles() {
		File folder;
		URL url = this.getClass().getClassLoader().getResource(speechFolderPath);
		File file = null;
		try {
			file = new File(url.toURI());
		} catch (URISyntaxException e) {
			file = new File(url.getPath());
		} finally {
			folder = file;
		}

		File[] listOfCharacterFolders = folder.listFiles();

		for (File characterFolder : listOfCharacterFolders) {
			if (characterFolder.isDirectory()) {
				File[] listOfFiles = characterFolder.listFiles();
				for (File speechFile : listOfFiles) {
					speechFiles.add(speechFile);
				}
			}
		}
	}

	private void loadSpeechText(String speechFile) throws IOException {
		StringBuilder builder = new StringBuilder();
		BufferedReader speechReader = new BufferedReader(
				new InputStreamReader(Utils.class.getClass().getResourceAsStream(speechFile)));
		try {
			String line;
			while ((line = speechReader.readLine()) != null) {
				if (line.startsWith("!")) {
					String textID = line;

					line = speechReader.readLine();
					while (line != null && !line.startsWith("!") && !line.startsWith("//")) {
						builder.append(line + " ");
						line = speechReader.readLine();
					}
					// variables
					String speech = builder.toString();
					if (speech.contains("~playerName")) {
						speech = speech.replace("~playerName", handler.getWorld().player.getPlayerName());
					}

					// format speech
					speech = formatSpeech(speech);
					// add speech
					System.out.println("FORMATTED SPEECH:\n" + textID + ":\n" + speech);
					speechTexts.put(textID, speech);
					builder.setLength(0);
				}
			}
		} finally {
			speechReader.close();
		}
	}

	private String formatSpeech(String inputString) {
		StringBuilder builder = new StringBuilder();
		int lineSize = 30;

		Pattern pColon = Pattern.compile("([?~a-zA-Z\\d])+:");
		Matcher mColon = pColon.matcher(inputString);

		// line break after colon (for names)
		while (mColon.find()) {
			System.out.println("FORMATTING TITLE: " + mColon.group().trim()); // Debug
			builder.append(mColon.group() + "\n");
			String match = mColon.group();
			inputString = inputString.replace(match, "");
		}
		// line break after max 30 chars
		Pattern p = Pattern.compile("\\b.{1," + (lineSize - 1) + "}\\b\\W?");
		Matcher m = p.matcher(inputString);
		while (m.find()) {
			System.out.println("FORMATTING: " + m.group().trim()); // Debug
			builder.append(m.group() + "\n");
		}
															
		return builder.toString();
	}
}
