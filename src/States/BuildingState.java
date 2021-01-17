/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: This class is what runs the first time the user runs the program. It displays the arcade building and prompts the user to enter it
 */

package States;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Game.PocketHandler;
import Graphics.Animation;
import Graphics.Assets;
import street.brawler.framework.Pictures;
import street.brawler.window.BufferedImageLoader;
import street.brawler.window.Game;
import street.brawler.window.MenuTimer;

public class BuildingState extends State{
	//Create variable to make sure specific things only run one time
	private int runOnce=1;
	
	//Create Variable to check if space bar is pressed
	private boolean spacePressed=false;
	
	//Create Object of MenuTimer Class
	MenuTimer menuTimer;
	
	//Create Object of Picture class
	Pictures picture= Game.getInstance();
	
	//Create Main Menu Animation
	private Animation mainMenuAnimation;
	
	//Create Images of MainMenu, and text 
	private BufferedImage mainMenu=null;
	private BufferedImage text=null;
	private BufferedImage spaceText=null;
	private BufferedImage border=null;
	
	//Create Object of BufferedImageLoader Class
	BufferedImageLoader loader;
	
	
	//Constructor with Handler as parameter
	public BuildingState(PocketHandler handler){
		//Calls parent class
		super(handler);
		
		//Instantiate Objects
		loader = new BufferedImageLoader();
		menuTimer = new MenuTimer();
		
		
		//Loads in images required for the main menu
		try {
			text = loader.loadImage("/OtherPictures/enterArcade.png");
			mainMenu = loader.loadImage("/OtherPictures/mainMenu.png");
			spaceText=loader.loadImage("/OtherPictures/Space Text.png");
			border=loader.loadImage("/OtherPictures/Border.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	//This method initializes the timer and also the animation
	public void init() {
		menuTimer.start();
		mainMenuAnimation = new Animation(100,Assets.mainMenu);
	}

	//Tick method to update all game variables 
	public void tick() {
		//If Statement to make sure this section of the code only runs once using the runOnce variable
		if(runOnce==1) {
			//Call initialize method
			init();
			runOnce=2;
		}
		
		
		//If statement to check if the user presses the space button
		if(handler.getKeyManager().space==true) {
			spacePressed=true;
		}
		
		//If space pressed is true the program runs the animation
		if(spacePressed==true) {
			
			//If Statement to make sure this section of the code only runs once using the runOnce variable
			if(runOnce==2) {
				//Sets the secondPassed Variable to 0
				menuTimer.setSecondsPassed(0);
				runOnce=3;
			}
			
			//Runs the main menu animation for a specific time
			if(menuTimer.getSecondsPassed()>=0&&menuTimer.getSecondsPassed()<=1.2) {
				mainMenuAnimation.tick();
			}
			
			//Sets the game state to the starting arcade state after the animation finishes
			if(menuTimer.getSecondsPassed()>=1.1) {
				State.setState(handler.getGame().startingState);
			}
			
			
		}
			
		
		
		
	}

	//Render method to render all the main menu graphics
	public void render(Graphics graphics) {
		graphics.drawImage(mainMenu, 0, 0, null);
		graphics.drawImage(text, 90, 360, null);
		graphics.drawImage(border, 270, 420,100,39, null);
		graphics.drawImage(spaceText, 270, 420,100,39, null);
		
		//Check if space was pressed
		if(spacePressed==true) {
			//Draws the main menu animation for a specific time frame
			if(menuTimer.getSecondsPassed()>=0&&menuTimer.getSecondsPassed()<=1.2) {
				graphics.drawImage(getCurrentAnimationFrame(),0,0,null);
			}
		}
		
		
	}
	
	//Method to get the current animation frame
	private BufferedImage getCurrentAnimationFrame() {
		return mainMenuAnimation.getCurrentFrame();
		
	}

}