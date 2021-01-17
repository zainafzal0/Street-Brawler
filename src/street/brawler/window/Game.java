/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Main Game Class that runs the tick and render method for the game
 * Citation: https://www.spriters-resource.com/
 */
package street.brawler.window;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import Display.Display;
import street.brawler.framework.KeyInput;
import street.brawler.framework.KeyInputP1;
import street.brawler.framework.KeyInputP2;
import street.brawler.framework.ObjectId;
import street.brawler.framework.Pictures;
import street.brawler.players.Collision;
import street.brawler.players.Player1;
import street.brawler.players.Player2;
import street.brawler.window.Game.STATE;


public class Game{

	//Create variable to make specific things run only once
	private int num1=1;
	private int wait=1;
	
	//Create Variables for Game Loop
	private boolean running = false;
	private Thread thread;
	
	
	//Create variable for countdown
	public static boolean begin=false;
	
	private boolean addKeyListener=false;
	
	MenuTimer menuTimer;
	
	//Create Menu Background Variable
	public BufferedImage menuBackground=null;
	//Create Menu Text Variable
	public BufferedImage menuText=null;
		
	//Create Map Selection Screen Variables
	public BufferedImage mapSelectionBackground=null,map1=null,map2=null,map3=null,map4=null,mapSelectionText=null,text1=null,text2=null,text3=null,text4=null;
	public BufferedImage redBorder=null;
	//Create X and Y Coordinates for Red Border in Map Selection
	public static int redBorderX=20;
	public static int redBorderY=100;
		
	//Create Game Background
	public static BufferedImage gameBackground = null;
	//Create Different Stages
	public static BufferedImage stage1=null;
	public static BufferedImage stage2=null;
	public static BufferedImage stage3=null;
	public static BufferedImage stage4=null;
	
	//Create Fight Screen image
	private BufferedImage FightScreen=null;
	//Create Loading text
	private BufferedImage loadingText=null;
	//Create Fight Text
	private BufferedImage FightText=null;
	//Create Countdown Variables
	private BufferedImage count1,count2,count3;
	
	private BufferedImage KO=null;
	
	
	//Create Different States of Game
	public enum STATE{
		MENU,
		MAPSELECTION,
		FIGHTSCREEN,
		GAME,
		ENDING,
		REALEND
	};
	//Create game state variable and 
	public static STATE gameState = STATE.MENU;
	
	
	//Create handler object
	Handler handler;
	
	//Create End Screen Object
	GameEndScreen endScreen;
	
	//Create Objects for all keyInputs
	KeyInput keyInput;
	KeyInputP1 keyInputP1;
	KeyInputP2 keyInputP2;
	
	//Create Object of Picture Class
	static Pictures pic;
	
	
	//Method to Initialize all objects and variables
	private void init() {
		
		//State Game State
		gameState=STATE.MENU;
		BufferedImageLoader loader= new BufferedImageLoader();
		
		//Try and catch statement to make sure when loading the image, an error isn't thrown
		try {
			//--------------------------------------------Menu Pictures-----------------------------------------------------
			
			//Load Menu Background
			menuBackground=loader.loadImage("/OtherPictures/Menu Background.jpg");
			//Load Menu Text
			menuText=loader.loadImage("/OtherPictures/Menu Text.png");
			
			
			//==============================================================================================================
			
			
			
			
			//-----------------------------------------Map Selection Pictures----------------------------------------------
			
			//Load Map Selection Background
			mapSelectionBackground=loader.loadImage("/OtherPictures/Map Selection Background.jpg");
			//Load Map 1 Image
			map1=loader.loadImage("/OtherPictures/Map1.png");
			//Load Map 2 Image
			map2=loader.loadImage("/OtherPictures/Map2.png");
			//Load Map 3 Image
			map3=loader.loadImage("/OtherPictures/Map3.png");
			//Load Map 4 Image
			map4=loader.loadImage("/OtherPictures/Map4.png");
			//Load Map Selection Text Image
			mapSelectionText=loader.loadImage("/OtherPictures/Map Selection Text.png");
			//Load Red Border
			redBorder=loader.loadImage("/OtherPictures/Red Border.png");
			
			//=============================================================================================================
	
			
			//Load All Stages
			stage1=loader.loadImage("/OtherPictures/greenStage.gif");
			stage2=loader.loadImage("/OtherPictures/caveStage.gif");
			stage3=loader.loadImage("/OtherPictures/RedForestStage.png");
			stage4=loader.loadImage("/OtherPictures/SunnyStage.png");
			
			//Load Fight Screen Image
			FightScreen=loader.loadImage("/OtherPictures/VS Screen.jpg");
			KO=loader.loadImage("/OtherPictures/KO.png");
			FightText=loader.loadImage("/OtherPictures/FightText.png");
			loadingText=loader.loadImage("/OtherPictures/Loading.png");
			count1=loader.loadImage("/OtherPictures/1.png");
			count2=loader.loadImage("/OtherPictures/2.png");
			count3=loader.loadImage("/OtherPictures/3.png");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//Instantiate Picture Object
		pic = new Pictures();
		
		//Instantiate Handler Object
		handler=new Handler();
		
		
		
			
			
			
		
		//Add Player 1 to GameObject Array
		handler.addObject(new Player1(40, 600, handler,keyInputP1 = new KeyInputP1(handler),keyInputP2 = new KeyInputP2(handler), ObjectId.Player1));
		//Add Player 2 to GameObject Array
		handler.addObject(new Player2(500, 344, handler,keyInputP2, ObjectId.Player2));
		
		//Instantiate KeyInput Object
		keyInput = new KeyInput(handler);
		
		//Make sure to add keyListeners only once
		if(addKeyListener==false) {
			//Add keyListener for keyInput class
			Display.getFrame().addKeyListener(keyInput);
			//Add keyListener for keyInputP1 class
			Display.getFrame().addKeyListener(keyInputP1);
			//Add keyListener for keyInputP2 class
			Display.getFrame().addKeyListener(keyInputP2);
			addKeyListener=true;
		}
		//Instantiate EndScreen Object
		endScreen=new GameEndScreen(keyInputP1,keyInputP2);
		
		//Instantiate Menu Timer Object
		menuTimer = new MenuTimer();
		
		//Start menu timer thread
		menuTimer.start();
		//Set loading x to 0
		menuTimer.setLoadingx(0);
		//Set secondsPassed to 0
		menuTimer.setSecondsPassed(0);
		
		
		
	}
	
	//Method to reset all important Variables
	public void resetVariables() {
		//Set All Variables back to default
		endScreen.endScreenTimer.stop();
		menuTimer.stop();
		wait=1;
		menuTimer.setSecondsPassed(0);
		menuTimer.setLoadingx(0);
		begin=false;
		endScreen.runOnce=1;
		Collision.Player1Health=0;
		Collision.Player2Health=0;
		Collision.player1Dead=false;
		Collision.player2Dead=false;
		KeyInput.rematch=false;
		gameState=STATE.MENU;
		num1=1;
		KeyInput.quit=false;
		
		
	}
	
	
	//Tick Method to update all game variables
	public void tick() {
		//Run init method only once
		if(num1==1) {
			init();
			num1=2;
		}
		
		//Call the handler tick method
		handler.tick();
		
		//If Game state is ending or real end then call the endScreen tick method
		if(gameState==STATE.ENDING||gameState==STATE.REALEND) {
			endScreen.tick();
		}
		
		
		//If Rematch is true, reset all Variables
		if(KeyInput.rematch==true) {
			wait=1;
			menuTimer.setSecondsPassed(0);
			menuTimer.setLoadingx(0);
			begin=false;
			endScreen.runOnce=1;
			Collision.Player1Health=0;
			Collision.Player2Health=0;
			Collision.player1Dead=false;
			Collision.player2Dead=false;
			gameState=STATE.MAPSELECTION;
			KeyInput.rematch=false;
		}
		
		
	}
	
	//Render Method to draw all game graphics
	public void render(Graphics g) {
		
		
		
		//Check if game state is menu
		if(gameState==STATE.MENU) {
			//Draw Menu background
			g.drawImage(menuBackground,0, 0, null);
			//Draw menu Text
			g.drawImage(menuText, 35, 400, null);
		}
		
		
		//If User is in Map Selection Page
		else if(gameState==STATE.MAPSELECTION) {
			
			//Draw all images for map selection 
			g.drawImage(mapSelectionBackground, -55, 0, null);
			g.drawImage(mapSelectionText, 70, 10, null);
			g.drawImage(map1,20,100,null);
			g.drawImage(map2,20,250,null);
			g.drawImage(map3,470,100,null);
			g.drawImage(map4,470,250,null);
			g.drawImage(redBorder,redBorderX,redBorderY,null);
			
		}
		
		//Checks if game state is Fight screen(loading screen)
		else if(gameState==STATE.FIGHTSCREEN) {
			//Wait variable makes sure this code only runs once
			if(wait==1) {
				//Set secondsPassed to 0
				menuTimer.setSecondsPassed(0);
				//Set loadingX to 0
				menuTimer.setLoadingx(0);
				wait=2;
			}
			
			//Draw all fight screen elements and pictures
			g.drawImage(FightScreen,0,0,null);
			g.setColor(Color.black);
			g.fillRect(0, 450, 640, 20);
			g.setColor(new Color(0,204,51));
			g.fillRect(0, 450, menuTimer.getLoadingx(), 20);
			g.setColor(new Color(41,116,71));
			g.drawRect(0, 450, 640, 20);
			g.drawImage(loadingText,265, 440,null);
			
			//Once the loading bar is full set gamestate to game
			if(menuTimer.getLoadingx()>=640) {
				gameState=STATE.GAME;
			}
			
			
		}
		
		//If Game state is game(fighting state)
		else if(gameState==STATE.GAME) {
			//Call the handlers render method which will render both players
			handler.render(g);
			//Draw KO Text
			g.drawImage(KO,263,-10,null);
			
			//Wait Variable makes sure this only runs once
			if(wait==2) {
				//Set Player 1 X Position to starting position
				handler.object.get(0).setX(40);
				//Set Player 2 X Position to starting position
				handler.object.get(1).setX(500);
				
				//Set SecondsPassed to 0 again
				menuTimer.setSecondsPassed(0);
				wait=3;
			}
			
			//Draw the countdown images before the fight starts
			if(menuTimer.getSecondsPassed()<1) {
				g.drawImage(count3,280,180,null);
			}
			else if(menuTimer.getSecondsPassed()>1&&menuTimer.getSecondsPassed()<2) {
				g.drawImage(count2,280,180,null);
			}
			else if(menuTimer.getSecondsPassed()>2&&menuTimer.getSecondsPassed()<3) {
				g.drawImage(count1,280,180,null);
			}
			else if(menuTimer.getSecondsPassed()>3&&menuTimer.getSecondsPassed()<4) {
				g.drawImage(FightText,135,150,null);
				//Once the countdown is finished, sets begin to true so that the program can start getting user key input
				begin=true;
			}	
		}
		
		//Checks if game state is ending or real end 
		else if(gameState==STATE.ENDING||gameState==STATE.REALEND) {
			//Call EndScreen render method
			endScreen.render(g);
		}
		
		
	}
	
	//Static method to get the picture class object from different classes
	public static Pictures getInstance() {
		return pic;
	}
	
	

}





