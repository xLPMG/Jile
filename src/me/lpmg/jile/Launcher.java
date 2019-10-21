package me.lpmg.jile;

public class Launcher {

	private final static String VERSION = "v0.1";
	
	public static void main(String[] args){		
		Game game = new Game("Jile "+VERSION+" | LPMG Game Studios", 640, 480);
		game.start();
	}
	
}
