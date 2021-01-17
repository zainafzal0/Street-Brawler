/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: The Purpose of this class is take an image and convert it into a sprite sheet by croping images
 */
package street.brawler.framework;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	//Create BufferedImage variable
	private BufferedImage sheet;
	
	//Constructor that accepts a bufferedImage as parameters
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	//Method to crop the image after the width, height, x, and y values are sent to it
	public BufferedImage grabImage(int width, int height, int x, int y) {
		return sheet.getSubimage(x, y, width, height);
	}
}

