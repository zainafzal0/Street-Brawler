/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Used to load in images
 */
package street.brawler.window;



import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BufferedImageLoader {
	
	//Create variable for buffered image
	private BufferedImage image;
	
	//Method to loadImage and return the bufferedImage
	public BufferedImage loadImage(String path) throws IOException {
		//Load Image
		image = ImageIO.read(getClass().getResource(path));
		return image;
	}
	
	

}
