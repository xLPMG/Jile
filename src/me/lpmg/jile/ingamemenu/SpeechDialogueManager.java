package me.lpmg.jile.ingamemenu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.lpmg.jile.Handler;
import me.lpmg.jile.gfx.Assets;
import me.lpmg.jile.utils.Utils;

public class SpeechDialogueManager {

	private int width = 700;
	private int height = 182;
	private Handler handler;
	private String speechFolderPath;

	private int tickCount = 1;
	private int tickTrigger = 2;

	private int currentLine = 0;
	private int currentLineMax = 0;
	private int currentChar = 0;

	private int displayedLines = 0;
	private String[] display = new String[5];

	private String[] textToDisplay;

	private boolean lastPage = false;
	private boolean finished = false;

	private boolean keyPressed = false;
	private boolean waitingForPress = false;

	private String speakerName = "???";

	int i = 0;

	List<File> speechFiles = new ArrayList<>();
	Map<String, String[]> speechTexts = new HashMap<>();

	public SpeechDialogueManager(Handler handler, String speechFolderPath) {
		this.handler = handler;
		this.speechFolderPath = speechFolderPath;

		handler.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (waitingForPress) {
					keyPressed = true;
				}
			}
		});
	}

	private void consumeKeyPress() {
		keyPressed = false;
	}

	public void init() {
		// TODO
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
//		System.out.println("--FINAL SPEECH TEXTS--");
		for (String key : speechTexts.keySet()) {
//			System.out.println(key + ": " + "\n" + speechTexts.get(key));
		}
	}

	public void render(Graphics g) {
		boolean updateTrigger = (tickCount % tickTrigger == 0);
		g.setFont(Assets.font32);

		if (textToDisplay != null && textToDisplay.length > 0 && !finished) {
			g.drawImage(Assets.speechToast, (handler.getWidth() - width) / 2, (handler.getHeight() - height) - 25,
					width, height, null);
			g.setColor(Color.decode("#302922"));
			g.drawString(speakerName, ((handler.getWidth() - width) / 2) + 32, (handler.getHeight() - height) + 1);
		}
		if (waitingForPress) {
			g.drawImage(Assets.dialogue_arrow, ((handler.getWidth() - width) / 2) + width - 28,
					(handler.getHeight() - 52), 16, 16, null);
		}

		if (!finished) {
//			g.setColor(Color.BLACK);
			g.setColor(Color.decode("#FFDAB5"));

			renderLine(g, 0, 4 + 30, updateTrigger);
			renderLine(g, 1, 32 + 30, updateTrigger);
			renderLine(g, 2, 60 + 30, updateTrigger);
			renderLine(g, 3, 88 + 30, updateTrigger);
			renderLine(g, 4, 116 + 30, updateTrigger);
		}

		if (updateTrigger) {
			tickCount = 1;
		} else {
			tickCount++;
		}

		// System.out.println("Tickcount: " + tickCount + " UpdateTrigger: " +
		// updateTrigger);
	}

	private void renderLine(Graphics g, int index, int heightIndex, boolean updateTrigger) {
		String text = display[index];
		if (text != null && !text.isEmpty()) {
			if (index == currentLine && currentChar < text.length()) {

				text = text.substring(0, currentChar);
				if (updateTrigger) {
					currentChar++;
				}
			}

			if (index <= currentLine) {
				String newText = text.replaceAll("[|]", "");
				g.drawString(newText, ((handler.getWidth() - width) / 2) + 10,
						(handler.getHeight() - height) + heightIndex);
			}

			if (updateTrigger && index == currentLine && currentChar == text.length()) {

				if (currentLine < 4 && currentLine != currentLineMax) {
					currentChar = 0;
					currentLine++;
				} else if (lastPage) {
					waitingForPress = true;
					if (keyPressed) {
						finished = true;
						consumeKeyPress();
						waitingForPress = false;
					}
				} else {
					waitingForPress = true;
					if (keyPressed) {
						// Wait for Enter
						currentChar = 0;
						currentLine = 0;
						lastPage = refreshDialog();
						consumeKeyPress();
						waitingForPress = false;
					}
				}
			}

		}
		// farb code
//			g.drawString(displayedText.length > 0 && displayedText[0] != null ? displayedText[0] : "", ((handler.getWidth() - width) / 2) + 10, (handler.getHeight() - height) + heightIndex);

//		System.out.println("CurrentLine: " + currentLine + " CurrentChar: " + currentChar + " UpdateTrigger: " + updateTrigger + " Finished: " + finished);

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
		FileInputStream file = new FileInputStream(speechFile);
		BufferedReader speechReader = new BufferedReader(
				new InputStreamReader(file));
		try {
			String line;
			while ((line = speechReader.readLine()) != null) {
				if (line.startsWith("!")) {
					String textID = line;

					StringBuilder builder = new StringBuilder();
					line = speechReader.readLine();
					while (line != null && !line.startsWith("!") && !line.startsWith("//")) {
						builder.append(line + "\n");
						line = speechReader.readLine();
					}
					// variables
					String speech = builder.toString();
					if (speech.contains("~playerName")) {
						speech = speech.replace("~playerName", handler.getWorld().player.getPlayerName());
					}
//					System.out.println("SPEECH: " + speech);
					// format speech
					String[] formattedSpeech = formatSpeech(speech);
					// add speech
					speechTexts.put(textID, formattedSpeech);
				}
			}
		} finally {
			speechReader.close();
		}
	}

	private String[] formatSpeech(String inputString) {
		// StringBuilder builder = new StringBuilder();
		List<String> lines = new ArrayList<>();
		int lineSize = 30;

		Pattern pColon = Pattern.compile("([?~a-zA-Z\\d])+:");
		Matcher mColon = pColon.matcher(inputString);

		// line break after colon (for names)
		while (mColon.find()) {
//			System.out.println("FORMATTING TITLE: " + mColon.group().trim()); // Debug
			// builder.append(mColon.group() + "\n");
			lines.add(mColon.group());
			String match = mColon.group();
			inputString = inputString.replace(match, "");
		}
		// line break after max 30 chars
		Pattern p = Pattern.compile("[|]|\\b.{1," + (lineSize - 1) + "}\\b\\W?");
		Matcher m = p.matcher(inputString);
		while (m.find()) {
//			System.out.println("FORMATTING: " + m.group().trim()); // Debug
			// builder.append(m.group() + "\n");
			lines.add(m.group());
		}

		return lines.toArray(new String[lines.size()]);
	}

	public void showDialog(String textID) {
		System.out.println("Dialog Showed with ID: " + textID);
		textToDisplay = speechTexts.get(textID);
		initDialog();
		loadSpeakerName();
		lastPage = refreshDialog();
	}

	private void initDialog() {
		currentLine = 0;
		currentChar = 0;
		displayedLines = 0;
		currentLineMax = 0;
		consumeKeyPress();
		waitingForPress = false;
		lastPage = false;
		finished = false;
	}

	private void loadSpeakerName() {
		List<String> newLines = new ArrayList<>();

		for (String line : textToDisplay) {
			if (line.contains("~") && line.contains(":")) {
				line = line.replace("~", "");
				line = line.replace(":", "");
				speakerName = line;
			} else {
				newLines.add(line);
			}
		}
		textToDisplay = newLines.toArray(new String[newLines.size()]);
	}

	private boolean refreshDialog() {
		int lines = 0;
		boolean lastPage = false;
		for (int i = 0; i < 5; i++) {
			if (i + displayedLines < textToDisplay.length) {
				display[i] = textToDisplay[i + displayedLines];
				currentLineMax = i;
				lines++;
			} else {
				display[i] = "";
				lastPage = true;
			}
		}
		displayedLines += lines;
		return lastPage;
	}

}
