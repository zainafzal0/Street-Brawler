/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: End Screen Class to tick and display all the End Screen graphics
 * Citation: https://www.spriters-resource.com/
 */
package street.brawler.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import street.brawler.framework.KeyInputP1;
import street.brawler.framework.KeyInputP2;
import street.brawler.framework.Pictures;
import street.brawler.players.Collision;
import street.brawler.window.Game.STATE;

public class GameEndScreen {

	//Create Picture Class Object
	Pictures picture= Game.getInstance();
	
	//Create BufferedImageLoader Class Object
	BufferedImageLoader loader;
	
	
	//Create Player 1 Animations
	private AnimationP1 Player1UpperKick;
	private AnimationP1 Player1Idle;
	private AnimationP1 Player1Hit;
	private AnimationP1 Player1Knockout;
	private AnimationP1 Player1Dead;
	
	//Create Player 2 Animations
	private AnimationP2 Player2Punch;
	private AnimationP2 Player2Hit;
	private AnimationP2 Player2Knockout;
	private AnimationP2 Player2Dead;
	private AnimationP2 Player2Idle;
	
	//Create End Screen Background Animations
	private Animation EndScreen;
	private Animation EndScreenRed;	
	
	//Create KO Text Animation
	private Animation KORyu;	
	private Animation KOKen;	
	
	//Create variable to make sure specific tasks only run once
	public int runOnce=1;
	
	//Create EndScreenTimer Object
	EndScreenTimer endScreenTimer = new EndScreenTimer();
	
	//Create Variables for All Text Images
	private BufferedImage ryuWinText=null;
	private BufferedImage kenWinText=null;
	private BufferedImage spaceText=null;
	private BufferedImage enterText=null;
	private BufferedImage blackScreen=null;
	private BufferedImage quitRed=null;
	private BufferedImage quitBlue=null;
	private BufferedImage rematchBlue=null;
	private BufferedImage rematchRed=null;
	private BufferedImage border=null;
	
	
	//Create KeyInput Objects
	KeyInputP1 keyInputP1;
	KeyInputP2 keyInputP2;
	
	
	//Constructor with KeyInputP1,KeyInputP2 as parameters
	public GameEndScreen(KeyInputP1 keyInputP1, KeyInputP2 keyInputP2) {
		
		//Sets objects accordingly
		this.keyInputP1=keyInputP1;
		this.keyInputP2=keyInputP2;
		
		//Instantiate Loader Object
		loader = new BufferedImageLoader();
		
		//Load in all text images
		try {
			ryuWinText=loader.loadImage("/OtherPictures/RyuWins.png");
			kenWinText=loader.loadImage("/OtherPictures/KenWins.png");
			spaceText=loader.loadImage("/OtherPictures/Space Text.png");
			enterText=loader.loadImage("/OtherPictures/Enter Text.png");
			blackScreen=loader.loadImage("/OtherPictures/BlackTranslucent.png");
			quitRed=loader.loadImage("/OtherPictures/Quit Red.png");
			quitBlue=loader.loadImage("/OtherPictures/Quit Blue.png");
			rematchRed=loader.loadImage("/OtherPictures/Rematch Red.png");
			rematchBlue=loader.loadImage("/OtherPictures/Rematch Blue.png");
			border=loader.loadImage("/OtherPictures/Border.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}
	
	//Method to Reinitilize Objects once the game is played again
	public void reInitilizeObjects() {
		
			
		
		//Call Animation Constructor for End Screen Background  Animation
				EndScreen = new Animation(3, picture.endScreenSprites[0],picture.endScreenSprites[1],picture.endScreenSprites[2],picture.endScreenSprites[3],picture.endScreenSprites[4],picture.endScreenSprites[5],picture.endScreenSprites[6],picture.endScreenSprites[7],picture.endScreenSprites[8],picture.endScreenSprites[9],picture.endScreenSprites[10],picture.endScreenSprites[11],picture.endScreenSprites[12],picture.endScreenSprites[13]
						,picture.endScreenSprites[14],picture.endScreenSprites[15],picture.endScreenSprites[16],picture.endScreenSprites[17],picture.endScreenSprites[18],picture.endScreenSprites[19],picture.endScreenSprites[20],picture.endScreenSprites[21],picture.endScreenSprites[22],picture.endScreenSprites[23],picture.endScreenSprites[24],picture.endScreenSprites[25],picture.endScreenSprites[26],picture.endScreenSprites[27],picture.endScreenSprites[28]
								,picture.endScreenSprites[29],picture.endScreenSprites[30],picture.endScreenSprites[31],picture.endScreenSprites[32],picture.endScreenSprites[33],picture.endScreenSprites[34],picture.endScreenSprites[35],picture.endScreenSprites[36],picture.endScreenSprites[37],picture.endScreenSprites[38],picture.endScreenSprites[39],picture.endScreenSprites[40],picture.endScreenSprites[41],picture.endScreenSprites[42]);
				
				
				//Call Animation Constructor for End Screen Red Background  Animation
				EndScreenRed = new Animation(3, picture.endScreenKenSprites[0],picture.endScreenKenSprites[1],picture.endScreenKenSprites[2],picture.endScreenKenSprites[3],picture.endScreenKenSprites[4],picture.endScreenKenSprites[5],picture.endScreenKenSprites[6],picture.endScreenKenSprites[7],picture.endScreenKenSprites[8],picture.endScreenKenSprites[9],picture.endScreenKenSprites[10],picture.endScreenKenSprites[11],picture.endScreenKenSprites[12],picture.endScreenKenSprites[13]
						,picture.endScreenKenSprites[14],picture.endScreenKenSprites[15],picture.endScreenKenSprites[16],picture.endScreenKenSprites[17],picture.endScreenKenSprites[18],picture.endScreenKenSprites[19],picture.endScreenKenSprites[20],picture.endScreenKenSprites[21],picture.endScreenKenSprites[22],picture.endScreenKenSprites[23],picture.endScreenKenSprites[24],picture.endScreenKenSprites[25],picture.endScreenKenSprites[26],picture.endScreenKenSprites[27],picture.endScreenKenSprites[28]
								,picture.endScreenKenSprites[29],picture.endScreenKenSprites[30],picture.endScreenKenSprites[31],picture.endScreenKenSprites[32],picture.endScreenKenSprites[33],picture.endScreenKenSprites[34],picture.endScreenKenSprites[35],picture.endScreenKenSprites[36],picture.endScreenKenSprites[37],picture.endScreenKenSprites[38],picture.endScreenKenSprites[39],picture.endScreenKenSprites[40],picture.endScreenKenSprites[41],picture.endScreenKenSprites[42]);
				
				//Call Animation Constructor for KO Ryu Text Animation
				KORyu = new Animation(5, picture.KORyuSprites[0],picture.KORyuSprites[1],picture.KORyuSprites[2],picture.KORyuSprites[3],picture.KORyuSprites[4],picture.KORyuSprites[5],picture.KORyuSprites[6],picture.KORyuSprites[6],picture.KORyuSprites[7],picture.KORyuSprites[8],picture.KORyuSprites[9],picture.KORyuSprites[10],picture.KORyuSprites[11]
						,picture.KORyuSprites[12], picture.KORyuSprites[13], picture.KORyuSprites[14], picture.KORyuSprites[15], picture.KORyuSprites[16], picture.KORyuSprites[17]);
				
				//Call Animation Constructor for KO Ken Text Animation
				KOKen = new Animation(5, picture.KOKenSprites[0],picture.KOKenSprites[1],picture.KOKenSprites[2],picture.KOKenSprites[3],picture.KOKenSprites[4],picture.KOKenSprites[5],picture.KOKenSprites[6],picture.KOKenSprites[6],picture.KOKenSprites[7],picture.KOKenSprites[8],picture.KOKenSprites[9],picture.KOKenSprites[10],picture.KOKenSprites[11]
						,picture.KOKenSprites[12], picture.KOKenSprites[13], picture.KOKenSprites[14], picture.KOKenSprites[15], picture.KOKenSprites[16], picture.KOKenSprites[17]);
				
				//===========================================PLAYER 1 ANIMATIONS===========================================
				
				
				//Call AnimationP1 Constructor for Player 1 Upper Kick Animation
				Player1UpperKick = new AnimationP1(10,keyInputP1, picture.Player1UpperKickSprites[0],picture.Player1UpperKickSprites[1],picture.Player1UpperKickSprites[2],picture.Player1UpperKickSprites[3],picture.Player1UpperKickSprites[4],picture.Player1UpperKickSprites[5],picture.Player1UpperKickSprites[6],picture.Player1UpperKickSprites[7],picture.Player1UpperKickSprites[8]);
				
				//Call AnimationP1 Constructor for Player 1 idle Animation
				Player1Idle = new AnimationP1(10, keyInputP1,picture.Player1IdleSprites[0],picture.Player1IdleSprites[1],picture.Player1IdleSprites[2],picture.Player1IdleSprites[3],picture.Player1IdleSprites[4],picture.Player1IdleSprites[5]);

				//Call AnimationP1 Constructor for Player 1 Hit Animation
				Player1Hit = new AnimationP1(15,keyInputP1, picture.Player1HitBackSprites[0],picture.Player1HitBackSprites[1],picture.Player1HitBackSprites[2],picture.Player1HitBackSprites[3]);
				
				//Call AnimationP1 Constructor for Player 1 KO Animation
				Player1Knockout = new AnimationP1(8,keyInputP1, picture.Player1KOSprites[0],picture.Player1KOSprites[1],picture.Player1KOSprites[2],picture.Player1KOSprites[3],picture.Player1KOSprites[4],picture.Player1KOSprites[5],picture.Player1KOSprites[6],picture.Player1KOSprites[7],picture.Player1KOSprites[8],picture.Player1KOSprites[9],picture.Player1KOSprites[10],picture.Player1KOSprites[11]);
				
				//Call AnimationP2 Constructor for Player 2 Dead Animation
				Player1Dead = new AnimationP1(1,keyInputP1, picture.Player1DeadSprites[0]);
				
				//===========================================PLAYER 2 ANIMATIONS===========================================
				
				
				
				//Call AnimationP2 Constructor for Player 2 Punch Animation
				Player2Punch = new AnimationP2(10,keyInputP2, picture.Player2PunchSprites[7],picture.Player2PunchSprites[6],picture.Player2PunchSprites[5],picture.Player2PunchSprites[4],picture.Player2PunchSprites[3],picture.Player2PunchSprites[2],picture.Player2PunchSprites[6],picture.Player2PunchSprites[1]);

				//Call AnimationP2 Constructor for Player 2 Idle Animation
				Player2Idle = new AnimationP2(11, keyInputP2,picture.Player2IdleSprites[5],picture.Player2IdleSprites[4],picture.Player2IdleSprites[3],picture.Player2IdleSprites[2],picture.Player2IdleSprites[1],picture.Player2IdleSprites[0]);
				
				//Call AnimationP2 Constructor for Player 2 Hit Animation
				Player2Hit = new AnimationP2(15,keyInputP2, picture.Player2HitStandSprites[3],picture.Player2HitStandSprites[2],picture.Player2HitStandSprites[1],picture.Player2HitStandSprites[0]);
				
				//Call AnimationP2 Constructor for Player 2 Knockout Animation
				Player2Knockout = new AnimationP2(10,keyInputP2, picture.Player2KnockoutSprites[0],picture.Player2KnockoutSprites[1],picture.Player2KnockoutSprites[2],picture.Player2KnockoutSprites[3],picture.Player2KnockoutSprites[4],picture.Player2KnockoutSprites[5],picture.Player2KnockoutSprites[6],picture.Player2KnockoutSprites[7]);
				
				//Call AnimationP2 Constructor for Player 2 Dead Animation
				Player2Dead = new AnimationP2(15,keyInputP2, picture.Player2DeadSprites[0]);
	}
	
	public void tick() {
		
		//Begin Timer
		if(runOnce==1) {
			endScreenTimer.start();
			reInitilizeObjects();
			endScreenTimer.setSecondsPassed(0);
			//Make sure this only runs once
			runOnce=2;
		}
		
		//Player 1 is Dead, displays Ken Win Screen
		if(Collision.player1Dead==true) {
			EndScreenRed.runAnimation();
			
			//Runs Player 2 Punch Animation in a specific time frame
			if(endScreenTimer.getSecondsPassed()<=1.8) {
				Player2Punch.runAnimation();
				
			}
			//Runs Player 1 Idle Animation in a specific time frame
			if(endScreenTimer.getSecondsPassed()<=0.9) {
				Player1Idle.runAnimation();
			}
			
			//Runs Player 1 Hit Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>0.9&&endScreenTimer.getSecondsPassed()<1.9) {
				Player1Hit.runAnimation();
			}
			
			
			//Runs Player 1 Knockout and Player 2 idle Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>=1.9&&endScreenTimer.getSecondsPassed()<3.7) {
				Player1Knockout.runAnimation();
				Player2Idle.runAnimation();
			}
			
			//Runs Player 1 Dead and Player 2 Idle Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>=3.7) {
				Player1Dead.runAnimation();
				Player2Idle.runAnimation();
			}
			//Runs KO Text Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>=2.5&&endScreenTimer.getSecondsPassed()<=4.5) {
				KOKen.runAnimation();
			}
			

		}
		
		
		//Player 2 is Dead, displays Ken Win Screen
		if(Collision.player2Dead==true) {
			EndScreen.runAnimation();
			
			//Runs Player 1 UpperKick and Player 2 Idle Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()<=1.8) {
				Player1UpperKick.runAnimation();
				Player2Idle.runAnimation();
				
			}
			//Runs Player 2 Hit Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>0.9&&endScreenTimer.getSecondsPassed()<1.9) {
				Player2Hit.runAnimation();
			}
			
			//Runs Player 2 idle Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()<=0.9) {
				Player2Idle.runAnimation();
			}
			//Runs Player 1 idle and Player 2 KO Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>=1.9&&endScreenTimer.getSecondsPassed()<3.7) {
				Player2Knockout.runAnimation();
				Player1Idle.runAnimation();
			}
			//Runs Player 1 Hit Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>=3.7) {
				Player2Dead.runAnimation();
				Player1Idle.runAnimation();
			}
			//Runs KO Ryu Text Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>=2.5&&endScreenTimer.getSecondsPassed()<=4.5) {
				KORyu.runAnimation();
			}
		}
		
	}
	
	//Render Method to render graphics
	public void render(Graphics g) {
		
		
		//Player 1 is Dead, displays Ken Win Screen
		if(Collision.player1Dead==true) {
			EndScreenRed.drawAnimation(g, 0, 95, 640, 480);
			
			//Runs Player 2 Punch Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()<=1.8) {
				Player2Punch.drawAnimation(g, 220, 200,303,306);
				
			}
			
			//Runs Player 1 Idle Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()<=0.9) {
				Player1Idle.drawAnimation(g, 100, 200, 171,318);
			}
			
			//Runs Player 1 Hit Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>0.9&&endScreenTimer.getSecondsPassed()<1.9) {
				Player1Hit.drawAnimation(g, 50, 200,231,312);
			}
		
			//Runs Player 1 KO and Player 2 Idle Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>=1.9&&endScreenTimer.getSecondsPassed()<3.7) {
				Player2Idle.drawAnimation(g, 370, 200,171,318);
				Player1Knockout.drawAnimation(g, 20,  150, 390, 390);
			}
			
			//Runs Player 1 Dead, Player 2 idle Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>=3.7) {
				Player1Dead.drawAnimation(g, 10, 400,348,138);
				Player2Idle.drawAnimation(g, 370, 200,171,318);
			}
			
			//Runs KO Text Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>=2.5&&endScreenTimer.getSecondsPassed()<=4.5) {
				KOKen.drawAnimation(g, 190, 230,250,151);
			}
			
			//Draws RYU Win Text for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>=4.7) {
				g.drawImage(kenWinText, 20, 10, null);
			}
			
			//Draws the Real End Screen 
			if(endScreenTimer.getSecondsPassed()>=6) {
				//Changes state to REALEND
				if(runOnce==2) {
					Game.gameState=STATE.REALEND;
					runOnce=3;
				}
				
				//Draws all the text and elements for the real end screen
				g.drawImage(blackScreen, 0, 0, null);
				g.drawImage(kenWinText, 20, 10, null);
				
				g.drawImage(rematchRed, 170, 200,300,62, null);
				g.drawImage(quitRed, 145, 320,350,73, null);
				
				
				g.drawImage(border, 270, 260,100,39, null);
				g.drawImage(border, 270, 388,100,39, null);
				
				g.drawImage(spaceText, 270, 260,100,39, null);
				g.drawImage(enterText, 270, 388,100,39, null);
				
			}
		}
		
		
		//Checks if player 2 is dead
		if(Collision.player2Dead==true) {
			EndScreen.drawAnimation(g, 0, 95, 640, 480);
			
			//Runs Player 1 Upper Kick Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()<=1.8) {
				Player1UpperKick.drawAnimation(g, 100, 200,330,333);
				
			}
			
			//Runs Player 2 idle Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()<=0.9) {
				Player2Idle.drawAnimation(g, 300, 200, 171,318);
			}
			
			//Runs Player 2 Hit Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>0.9&&endScreenTimer.getSecondsPassed()<1.9) {
				Player2Hit.drawAnimation(g, 300, 200,237,314);
			}
			
			//Runs Player 1 idle and Player 2 KO Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>=1.9&&endScreenTimer.getSecondsPassed()<3.7) {
				Player1Idle.drawAnimation(g, 100, 200,171,318);
				Player2Knockout.drawAnimation(g, 300,  150, 330, 375);
			}
			
			//Runs Player 1 Idle and Player 2 Dead Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>=3.7) {
				Player2Dead.drawAnimation(g, 300, 150,348,375);
				Player1Idle.drawAnimation(g, 100, 200,171,318);
			}
			
			//Runs KO Ryu Text Animation for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>=2.5&&endScreenTimer.getSecondsPassed()<=4.5) {
				KORyu.drawAnimation(g, 240, 260,200,121);
			}
			
			//Draws Win Text for a specific amount of seconds
			if(endScreenTimer.getSecondsPassed()>=4.7) {
				g.drawImage(ryuWinText, 20, 10, null);
			}
			
			//Draws the Real End Screen 
			if(endScreenTimer.getSecondsPassed()>=6) {
				//Sets the game state to REALEND
				if(runOnce==2) {
					Game.gameState=STATE.REALEND;
					runOnce=3;
				}
				
				//Draws all the text elements and images
				g.drawImage(blackScreen, 0, 0, null);
				g.drawImage(ryuWinText, 20, 10, null);
				g.drawImage(rematchBlue, 170, 200,300,62, null);
				g.drawImage(quitBlue, 145, 320,350,63, null);
				g.drawImage(border, 270, 260,100,39, null);
				g.drawImage(border, 270, 380,100,39, null);
				g.drawImage(spaceText, 270, 260,100,39, null);
				g.drawImage(enterText, 270, 380,100,39, null);
			}
		}
		
		
	}
}

