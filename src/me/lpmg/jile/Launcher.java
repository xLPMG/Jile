package me.lpmg.jile;

public class Launcher {

	private final static String VERSION = "v0.5-pre1";
	
	public static void main(String[] args){		
		Game game = new Game("Jile "+VERSION+" | LPMG Game Studios", 750, 600, VERSION);
		game.start();
	}
	
}
