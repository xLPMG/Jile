package me.lpmg.jile.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {
	
	public static Font loadFont(String path, float size){
		try {
			InputStream stream = FontLoader.class.getResourceAsStream(path);		
			if(stream==null) System.out.println("nay");
			return Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(Font.PLAIN, size);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

}

