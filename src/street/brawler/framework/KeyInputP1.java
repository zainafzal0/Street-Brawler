
/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Gets key input for player 1 controls
 */
package street.brawler.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import street.brawler.players.Collision;
import street.brawler.window.Game;
import street.brawler.window.Game.STATE;
import street.brawler.window.Handler;



public class KeyInputP1 extends KeyAdapter{
	
	
	//Declaring variables for character actions
	private boolean action1=false,flip1=false,crouch1=false,quickPunch1=false,hardPunch1=false,kick1=false,lowKick1=false,movingLeft=false,movingRight=false
			,airPunch1=false;
	private boolean jump1=false;
	
	//Create Variables for keys
	private boolean F,G,H,J,A,D,W;
	
	//Create handler object
	Handler handler;
	
	//Create arrays to check if keys are pressed or not
	public boolean[] keyDown1 = new boolean[2];
	public boolean[] keyDown2 = new boolean[2];
	
	
	//Constructor with handler as parameter
	public KeyInputP1(Handler handler) {
		//Sets handler created in this class to handler sent by the parameter
		this.handler = handler;
	}
	
	
	//Method to check if any keys are pressed
	public void keyPressed(KeyEvent e) {
		//If the game begins then start checking for input
		if(Game.begin==true) {
			
		//Create a variable for key
		int key = e.getKeyCode();
		
				
			if(Game.gameState==STATE.GAME) {
					jump1=false;
					
				//=======================================PLAYER 1 ACTIONS==================================================
				
			
				//====================================Movement======================================
			
			
			
				if(handler.object.get(0).getY()==(450-106)&&action1==false) {
					//Check if Player pressed D to make them move to the right
					if(key == KeyEvent.VK_D) {
						movingRight=true;
						D=true;
						
					}
					//Check if Player pressed A to make them move to the left
					else if(key == KeyEvent.VK_A) {
						movingLeft=true;
						A=true;
						
					}
					if(A==true) {
						crouch1=false;
						handler.object.get(0).setVelX(-3);
					}
					if(D==true) {
						crouch1=false;
						handler.object.get(0).setVelX(3);
					}
				}
				
				
				//Check if the Player is on the ground
				if(handler.object.get(0).getY()==(450-106)&&action1==false&&Collision.player1Hit==false) {
					//Check if Player pressed W to make them jump
					if(key == KeyEvent.VK_W) {
						crouch1=false;
						handler.object.get(0).setVelY(-10);
						//Time Delay
						new Thread(new thread()).start();
					}
					
					
					//Check if Player pressed S to crouch
					else if(key == KeyEvent.VK_S&&handler.object.get(0).getVelX()==0) {
						crouch1=true;
						
					}
					
					//If Player is holding A or D but presses S then set crouch to false
					if(crouch1==true&&keyDown1[0]) {
						crouch1=false;
					}
					if(crouch1==true&&keyDown1[1]) {
						crouch1=false;
					}
					
					
					//===========================================Fighting Actions==========================================
					
						else if(key == KeyEvent.VK_F) {
							F=true;
						}
						//Check if User pressed G to perform a quick punch
						else if(key == KeyEvent.VK_G) {
							G=true;
						}
						//Performs a upper kick if H is pressed 
						else if(key == KeyEvent.VK_H) {
							H=true;
						}
						//Performs a low kick is J is pressed
						else if(key == KeyEvent.VK_J) {
							J=true;
						}
						
						//Check if F is true
						if(F==true) {
							handler.object.get(0).setVelX(0);
							hardPunch1=true;
							action1=true;
						}
						//Check if G is true
						if(G==true) {
							handler.object.get(0).setVelX(0);
							quickPunch1=true;
							action1=true;
						}
						//Check if H is true
						if(H==true) {
							handler.object.get(0).setVelX(0);
							kick1=true;
							action1=true;
						}
						//Check if J is true
						if(J==true) {
							handler.object.get(0).setVelX(0);
							lowKick1=true;
							action1=true;
						}
					}
				}		
		}			
				
	}
	
	
	//Key Released Method
	public void keyReleased(KeyEvent e) {
		//Checks if the game has begun
		if(Game.begin==true) {
		
		//Creates variable to get key code
		int key = e.getKeyCode();
		
		//Checks if the game state is game
		if(Game.gameState==STATE.GAME) {
			
				
				//====================================Player1======================================
				
				
					//====================================Movement======================================
					//Checks if D is released and acts accordingly
					if(key == KeyEvent.VK_D) {
						D=false;
						keyDown1[1]=false;
						
					}
					//Checks if A is released and acts accordingly
					else if(key == KeyEvent.VK_A) {
						A=false;
						keyDown1[0]=false;
						
					}
					//Checks if S is released and acts accordingly
					else if(key == KeyEvent.VK_S) {
						crouch1=false;
						
					}
					
					//Checks if jump is true and acts accordingly
					if(jump1==true) {
						if(key == KeyEvent.VK_W) {
							handler.object.get(0).setVelY(0);
								
						}
					}
					
					//Checks if F is released and acts accordingly
					else if(key == KeyEvent.VK_F) {
						F=false;
					
					}
					//Check if User released G to perform a quick punch
					else if(key == KeyEvent.VK_G) {
						G=false;
						
					}
					//Performs a upper kick if H is released 
					else if(key == KeyEvent.VK_H) {
						H=false;
					}
					//Performs a low kick is J is released
					else if(key == KeyEvent.VK_J) {
						J=false;

					}
					
					//Checks if A is true and if D is true and sets velocityX to 3 to the right
					if(A==false&&D==true){ 
						handler.object.get(0).setVelX(3);
					}
					//Checks if A is true and if D is false and sets velocityX to 3 to the left
					if(A==true&&D==false){ 
						handler.object.get(0).setVelX(-3);
					}
					//Checks if A is false and if D is false and sets velocityX to 0
					if(A==false&&D==false){ 
						handler.object.get(0).setVelX(0);
					}
						
					
					
				}
		
		}
	}

	//Set and get Methods for Action 1
	public boolean isAction1() {
		return action1;
	}
	public void setAction1(boolean action1) {
		this.action1 = action1;
	}


	//Set and get Methods for Flip 1
	public boolean isFlip1() {
		return flip1;
	}
	public void setFlip1(boolean flip1) {
		this.flip1 = flip1;
	}
	

	//Set and get Methods for Crouch 1
	public boolean isCrouch1() {
		return crouch1;
	}
	public void setCrouch1(boolean crouch1) {
		this.crouch1 = crouch1;
	}

	
	//Set and get Methods for Quick Punch 1
	public boolean isQuickPunch1() {
		return quickPunch1;
	}
	public void setQuickPunch1(boolean quickPunch1) {
		this.quickPunch1 = quickPunch1;
	}

	
	//Set and get Methods for Hard Punch 1
	public boolean isHardPunch1() {
		return hardPunch1;
	}
	public void setHardPunch1(boolean hardPunch1) {
		this.hardPunch1 = hardPunch1;
	}


	//Set and get Methods for Kick 1
	public boolean isKick1() {
		return kick1;
	}
	public void setKick1(boolean kick1) {
		this.kick1 = kick1;
	}


	//Set and get Methods for Low Kick 1
	public boolean isLowKick1() {
		return lowKick1;
	}
	public void setLowKick1(boolean lowKick1) {
		this.lowKick1 = lowKick1;
	}


	//Set and get Methods for Air Punch 1
	public boolean isAirPunch1() {
		return airPunch1;
	}
	public void setAirPunch1(boolean airPunch1) {
		this.airPunch1 = airPunch1;
	}


	//Set and get Methods for Jump 1
	public boolean isJump1() {
		return jump1;
	}
	public void setJump1(boolean jump1) {
		this.jump1 = jump1;
	}

	
	
}


//Thread Class to set a delay when the players jump
class thread implements Runnable{

	public void run() {
		try {
			Thread.sleep(600);
		}catch(Exception e) {
			new Thread(this).start();
			System.exit(0);
		}
		
	}
	
}
