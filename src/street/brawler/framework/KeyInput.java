
/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Gets key input for the main menu and map selection menu
 */


package street.brawler.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import States.State;
import street.brawler.window.Game;
import street.brawler.window.Game.STATE;
import street.brawler.window.Handler;




public class KeyInput extends KeyAdapter{
	
	//Create Object of Handler Class
	Handler handler;
	
	public static  boolean rematch=false;
	public static boolean quit=false;
	
	

	//Constructor to accept handler as argument
	public KeyInput(Handler handler) {
		this.handler = handler;
		
	}
	
	
	//Method to check if certain keys are pressed and acts accordingly
	public void keyPressed(KeyEvent e) {
		//Get Key Value
		int key = e.getKeyCode();
		
		//If Statement to Check if User is in the Menu
		if(Game.gameState==STATE.MENU) {
			//Check if User pressed space
			if(key == KeyEvent.VK_SPACE) {
				//Change Game State to Map Selection
				Game.gameState=STATE.MAPSELECTION;
			}
		}
				
				
				
		//If Statement to Check if User is in Map Selection
		if(Game.gameState==STATE.MAPSELECTION) {
			//Check what X position the Red Border is
			if(Game.redBorderX==20){
				//Check if user pressed right key
				if(key == KeyEvent.VK_RIGHT) {
					//Move Border to the right
					Game.redBorderX+=450;		
				}
			}
			//Check what X position the Red Border is
			else if(Game.redBorderX==470) {
				//Check if the user pressed the left key
				if(key == KeyEvent.VK_LEFT) {
					//Move border to the Left
					Game.redBorderX-=450;
				}
			}
					
			
					
			//Check what Y position the Red Border is
			if(Game.redBorderY==100) {
				//Check if the user pressed the down key
				if(key == KeyEvent.VK_DOWN) {
					//Move Border Down
					Game.redBorderY+=150;	
				}
			}
			//Check what Y position the Red Border is
			else if(Game.redBorderY==250) {
				//Check if the user pressed the up key
				if(key == KeyEvent.VK_UP) {
					//Move Border Up
					Game.redBorderY-=150;
							
				}
			}
					
			//Check if user pressed enter
			if(key == KeyEvent.VK_ENTER) {
				//Set Game Map according to where the red border was when the user pressed enter
				if(Game.redBorderX==20&&Game.redBorderY==100) {
					Game.gameBackground=Game.stage1;
				}
				else if(Game.redBorderX==20&&Game.redBorderY==250) {
					Game.gameBackground=Game.stage2;
				}
				else if(Game.redBorderX==470&&Game.redBorderY==100) {
					Game.gameBackground=Game.stage3;
				}
				else if(Game.redBorderX==470&&Game.redBorderY==250) {
					Game.gameBackground=Game.stage4;
				}
				
				//Set the game state to GAME
				Game.gameState=STATE.FIGHTSCREEN; 
			}		
		}	
		
		//Once the game is at its end check for user input
		if(Game.gameState==STATE.REALEND) {
			//Check if user pressed enter to quit
			if(key == KeyEvent.VK_ENTER) {
				quit=true;
				Game.gameState=STATE.MENU;
			}
			//Check if the user pressed space for rematch
			if(key == KeyEvent.VK_SPACE) {
				rematch=true;
				Game.gameState=STATE.MAPSELECTION;
				
			}
		}
		
	}
	
	
	//Key Released Method
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();		
	}


	
	
	
	
	
}
