/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Used to perform all the animations for Player 1
 */
package street.brawler.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import street.brawler.framework.KeyInputP1;
import street.brawler.framework.KeyInputP2;
import street.brawler.players.Collision;
import street.brawler.window.Game.STATE;

public class AnimationP1 extends Animation {
	
	KeyInputP1 keyInputP1;
	
	//Constructor to call the parent class Constructor
	public AnimationP1(int speed,KeyInputP1 keyInputP1, BufferedImage... args) {
		//Call Super Constructor
		super(speed, args);
		this.keyInputP1=keyInputP1;
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
			keyInputP1.setHardPunch1(false);
			keyInputP1.setQuickPunch1(false);
			keyInputP1.setKick1(false);
			keyInputP1.setLowKick1(false);
			keyInputP1.setAction1(false);
			
			
			
			//If the Player is hit deduct health
			if(Collision.player1Hit==true) {
				Collision.Player1Health+=5;
			}
			
			if(Collision.player1Hit==true&&Game.gameState==STATE.ENDING) {
				Collision.player1Hit=false;
			}
			
				
			
		}
		
		
		
	}
	

}
