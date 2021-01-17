/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Parent Class for both player animation classes. Performs all the animations
 */
package street.brawler.window;



import java.awt.Graphics;
import java.awt.image.BufferedImage;

import street.brawler.framework.KeyInputP1;
import street.brawler.framework.KeyInputP2;
import street.brawler.players.Collision;

public class Animation {
	
	//Create Protected Variables for Animation
	protected int speed;
	protected int frames;
	protected int index=0;
	protected int count=0;	
	protected BufferedImage[] images;
	protected BufferedImage currentImg;
	
	
	KeyInputP2 keyInputP2;
	//Super Class Constructor to accept speed and BufferedImage Array as parameters 	
	public Animation(int speed, BufferedImage... args) {
		//Set Variables to the values sent by different class
		this.speed = speed;
		images = new BufferedImage[args.length];
		
		//Set the Images in the sent BufferedImage Array in the images array
		for(int i=0;i<args.length;i++) {
			images[i] = args[i];
		}
		frames = args.length;
		
	}
	
	
	//Run Animation Method to run through the image array according to the speed
	public void runAnimation() {
			//Add to the index
			index++;
			//Set the index to 0 and call the nextFrame method if the index is greater then the speed set by user
			if(index>speed) {
				index = 0;
				nextFrame();
			}
		
		
	}
	
	//Method to get the next frame in the image array
	private void nextFrame() {		
		
		//For Loop to get the images in the array
		for(int i = 0; i<frames; i++) {
			if(count == i) {
				currentImg = images[i];
			}
		}
		
		count++;
		
		//If the animation is finished, reset the counter
		if(count > frames) {
			count=0;			
		}
	}
	

	//Method to draw the animation in the window
	public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY) {
			//Draw the Current Image in the Image Array
			g.drawImage(currentImg, x, y-95, scaleX, scaleY, null);
	}

}
