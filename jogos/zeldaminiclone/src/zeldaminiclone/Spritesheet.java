package zeldaminiclone;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
	
	private static BufferedImage SPRITESHEET;
	
	private static BufferedImage[] PLAYER_FRONT;
	private static BufferedImage[] INIMIGO_FRONT;

	private static BufferedImage TILEWAll;
	
	public Spritesheet() {
		try {
			SPRITESHEET = ImageIO.read(getClass().getResource("/aula05-spritesheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//	PLAYER
		PLAYER_FRONT = new BufferedImage[2];
		PLAYER_FRONT[0] = Spritesheet.getSprite(1, 11, 16, 16);
		PLAYER_FRONT[1] = Spritesheet.getSprite(19, 11, 16, 16);
		
		// TIJOLO
		TILEWAll = Spritesheet.getSprite(288, 209, 16, 16);
		
		// INIMIGO
		INIMIGO_FRONT = new BufferedImage[2];
		INIMIGO_FRONT[0] = Spritesheet.getSprite(284, 234, 16, 16);
		INIMIGO_FRONT[1] = Spritesheet.getSprite(302, 234, 16, 16);
		
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return Spritesheet.SPRITESHEET.getSubimage(x, y, width, height);
	}

	public static BufferedImage getSPRITESHEET() {
		return Spritesheet.SPRITESHEET;
	}

	public static BufferedImage[] getPLAYER_FRONT() {
		return Spritesheet.PLAYER_FRONT;
	}
	
	public static BufferedImage[] getINIMIGO_FRONT() {
		return Spritesheet.INIMIGO_FRONT;
	}
	
	
	public static BufferedImage getTILEWAll() {
		return Spritesheet.TILEWAll;
	}
	
	

}
