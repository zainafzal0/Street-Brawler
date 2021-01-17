/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Used to perform all the animations for Player 2
 */
package street.brawler.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import street.brawler.framework.KeyInput;
import street.brawler.framework.KeyInputP2;
import street.brawler.players.Collision;

public class AnimationP2 extends Animation{
	
	KeyInputP2 keyInputP2;
	
	//Constructor to call the parent class Constructor
	public AnimationP2(int speed, KeyInputP2 keyInputP2,BufferedImage... args) {
		//Call Super Constructor
		
		super(speed,args);
		this.keyInputP2=keyInputP2;
	}
		
	
	//Override Run Animation Method from parent class
	public void runAnimation() {
		
		index++;
		if(index>speed) {
			index = 0;
			nextFrame();
		}
	}
	
	//Override nextFrame Method from Parent Class
	private void nextFrame() {
		for(int i = 0; i<frames; i++) {
			if(count == i) {
				currentImg = images[i];
			}
		}
		count++;
		
		//Check If the Animation is done
		if(count > frames) {
			count=0;
			
			//Set Action Variables back to false after the Player has finished performing the action
			
			keyInputP2.setHardPunch2(false);
			keyInputP2.setQuickPunch2(false);
			keyInputP2.setAction2(false);
			keyInputP2.setKick2(false);
			keyInputP2.setLowKick2(false);
			
		
			
			//If the Player is hit deduct health
			if(Collision.player2Hit==true) {
				Collision.Player2Health+=5;
			}
			
			
		}
		
	}
	
	
	
}
