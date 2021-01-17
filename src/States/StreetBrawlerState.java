/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: This is class is the class that runs the actual street brawler game when the user presses space to play Street Brawler
 */
package States;

import java.awt.Graphics;

import Display.Display;
import Game.PocketHandler;
import Graphics.Assets;
import street.brawler.framework.KeyInput;
import street.brawler.framework.KeyInputP1;
import street.brawler.framework.KeyInputP2;
import street.brawler.window.Game;
import street.brawler.window.Handler;
import street.brawler.window.Game.STATE;

public class StreetBrawlerState extends State{
	  
	//Create Object for Street Brawler Game Class
	Game game;
	//Create Variable to make sure specific things run only once
	private int runOnce=1;
	
	//Constructor with handler as parameter
	public StreetBrawlerState(PocketHandler handler){
		super(handler);

	}
	
	//Tick method to upgrade all the variables
	public void tick() {
		//If Statement to make sure this section of the code only runs once using the runOnce variable
		if(runOnce==1) {
			//Set the game state for street fighter to menu
			Game.gameState=STATE.MENU;
			//Instantiante Game class object
			game = new Game();
			runOnce=2;
		} 
		
		//If Statement to make sure this section of the code only runs once using the runOnce variable
		if(runOnce==2) {
			//Call the game class tick method
			game.tick();
		}
		
		
		//Checks if the user quit the game
		if(KeyInput.quit==true) {
			//Call the resetVariables method to reset all the important variables 
			game.resetVariables();
			runOnce=1;
			
			//Set the game state to the arcade menu state
			State.setState(handler.getGame().startingState);
		}
	}

	//Render all the graphics for the street brawler game
	public void render(Graphics g) {
		if(runOnce==2) {
			game.render(g);
		}
		
	}
	

}

