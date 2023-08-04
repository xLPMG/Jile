package me.lpmg.jile;

public class Launcher {

	private final static String VERSION = "v0.5-pre1";
	
	public static void main(String[] args){		
		//Game game = new Game("Jile "+VERSION+" | LPMG Game Studios", 750, 600, VERSION);
		Game game = new Game("Jile "+VERSION+" | LPMG Game Studios", 1000, 750, VERSION);
		
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		int screenHeight = screenSize.height;
//		int screenWidth = screenSize.width;
//		Game game = new Game("Jile "+VERSION+" | LPMG Game Studios", screenWidth, screenHeight, VERSION);
		
		game.start();
	}
	
}
