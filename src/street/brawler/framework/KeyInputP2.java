/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Gets key input for player 2 controls
 */
package street.brawler.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import street.brawler.players.Collision;
import street.brawler.window.Game;
import street.brawler.window.Game.STATE;
import street.brawler.window.Handler;



public class KeyInputP2 extends KeyAdapter{
	
	
	//Declaring variables for character actions
	private boolean action2=false,flip2=false,crouch2=false,quickPunch2=false,hardPunch2=false,kick2=false,lowKick2=false;
	private boolean jump2=false;
	
	//Create Variables for keys
	private boolean N0,N1,N2,N3;
	
	
	
	//Create Handler object
	Handler handler;
	
	//Create arrays to check if a key is pressed
	private boolean[] keyDown1 = new boolean[2];
	private boolean[] keyDown2 = new boolean[2];
	
	
	//Constructor 
	public KeyInputP2(Handler handler) {
		this.handler = handler;
	}
	
	
	//Key Pressed Method
	public void keyPressed(KeyEvent e) {
		if(Game.begin==true) {
		int key = e.getKeyCode();
				if(Game.gameState==STATE.GAME) {
					
						
						//=======================================PLAYER 2 ACTIONS==================================================
						
						
					
							//====================================Movement======================================
							
							if(handler.object.get(1).getY()==(450-106)&&action2==false) {
								//Check if Player pressed right arrow to make them move to the right
								if(key == KeyEvent.VK_RIGHT) {
									crouch2=false;
									handler.object.get(1).setVelX(3);
									keyDown2[1]=true;
									
								}
								//Check if Player pressed left arrow to make them move to the left
								else if(key == KeyEvent.VK_LEFT) {
									crouch2=false;
									handler.object.get(1).setVelX(-3);
									keyDown2[0]=true;
									
								}
							}
					
							
							//Check if the Player is on the ground
							if(handler.object.get(1).getY()==(450-106)&&action2==false&&Collision.player2Hit==false) {
								//Check if Player pressed up arrow to make them jump
								if(key == KeyEvent.VK_UP) {
									crouch2=false;
									handler.object.get(1).setVelY(-10);
									//Time Delay
									new Thread(new thread()).start();
									
								}
								
								
								//Check if Player pressed down arrow to crouch
								else if(key == KeyEvent.VK_DOWN&&handler.object.get(1).getVelX()==0) {
									crouch2=true;
									
								}
								
								//If Player is holding right arrow key or left arrow key but presses down arrow key then set crouch to false
								if(crouch2==true&&keyDown2[0]) {
									crouch2=false;
								}
								if(crouch2==true&&keyDown2[1]) {
									crouch2=false;
								}
								
								
								//===========================================Fighting Actions==========================================
								
								//Sets N1 to true if N1 is pressed
								else if(key == KeyEvent.VK_NUMPAD1) {
									N1=true;
								}
								//Sets N0 to true if N0 is pressed
								else if(key == KeyEvent.VK_NUMPAD0) {
									N0=true;
								}
								//Sets N2 to true if N2 is pressed
								else if(key == KeyEvent.VK_NUMPAD2) {
									N2=true;
								}
								//Sets N3 to true if N3 is pressed
								else if(key == KeyEvent.VK_NUMPAD3) {
									N3=true;
								}
								
								//Performs Quick Punch 2 if N0 is true
								if(N0==true) {
									handler.object.get(1).setVelX(0);
									quickPunch2=true;
									action2=true;
								}
								//Performs hard Punch 2 if N1 is true
								if(N1==true) {
									handler.object.get(1).setVelX(0);
									hardPunch2=true;
									action2=true;
								}
								//Performs kick 2 if N2 is true
								if(N2==true) {
									handler.object.get(1).setVelX(0);
									kick2=true;
									action2=true;
								}
								//Performs low kick if N3 is true
								if(N3==true) {
									handler.object.get(1).setVelX(0);
									lowKick2=true;
									action2=true;
								}
							}
							
						}
						
						
						
						
						
						
						
		}				
					
	}
	
	
	//Key Released Method
	public void keyReleased(KeyEvent e) {
		//Checks if game has begun
		if(Game.begin==true) {
		
		//Creates variable to get key code
		int key = e.getKeyCode();
		
		//Checks if game state is game
		if(Game.gameState==STATE.GAME) {
			
								
				//====================================Player2======================================
				
			
					//====================================Movement======================================
					//Checks if right arrow is released 
					if(key == KeyEvent.VK_RIGHT) {
						keyDown2[1]=false;
						
					}
					
					//Checks if left arrow is released 
					else if(key == KeyEvent.VK_LEFT) {
						keyDown2[0]=false;
						
					}
					
					//Checks if down arrow is released 
					else if(key == KeyEvent.VK_DOWN) {
						crouch2=false;
						
					}
					
					//Checks if jump is true
					if(jump2==true) {
						if(key == KeyEvent.VK_UP) {
							handler.object.get(1).setVelY(0);
								
						}
					}
					
					//Checks if N1 is released and sets it back to false
					else if(key == KeyEvent.VK_NUMPAD1) {
						N1=false;
					}
					//Checks if N0 is released and sets it back to false
					else if(key == KeyEvent.VK_NUMPAD0) {
						N0=false;
					}
					//Checks if N2 is released and sets it back to false
					else if(key == KeyEvent.VK_NUMPAD2) {
						N2=false;
					}
					//Checks if N3 is released and sets it back to false
					else if(key == KeyEvent.VK_NUMPAD3) {
						N3=false;
					}
					
					//If KeyDown2[0] is true and KeyDown2[1] is false set velX to -3
					if(keyDown2[0]&&!keyDown2[1]) {
						handler.object.get(1).setVelX(-3);
					}
					//If KeyDown2[0] is true and KeyDown2[1] is true set velX to 3
					if(!keyDown2[0]&&keyDown2[1]) {
						handler.object.get(1).setVelX(3);
					}
					
					//If KeyDown2[0] is false and KeyDown2[1] is true set velX to 0
					if(!keyDown2[0]&&!keyDown2[1]) {
						
						handler.object.get(1).setVelX(0);
					}
				}
				
				
			
		
		}
	}

	//Set and Get Methods for Action 2
	public boolean isAction2() {
		return action2;
	}
	public void setAction2(boolean action2) {
		this.action2 = action2;
	}


	//Set and Get Methods for Crouch 2
	public boolean isCrouch2() {
		return crouch2;
	}
	public void setCrouch2(boolean crouch2) {
		this.crouch2 = crouch2;
	}

	
	//Set and Get Methods for Quick Punch 2
	public boolean isQuickPunch2() {
		return quickPunch2;
	}
	public void setQuickPunch2(boolean quickPunch2) {
		this.quickPunch2 = quickPunch2;
	}


	//Set and Get Methods for Hard Punch 2
	public boolean isHardPunch2() {
		return hardPunch2;
	}
	public void setHardPunch2(boolean hardPunch2) {
		this.hardPunch2 = hardPunch2;
	}


	//Set and Get Methods for Kick 2
	public boolean isKick2() {
		return kick2;
	}
	public void setKick2(boolean kick2) {
		this.kick2 = kick2;
	}


	//Set and Get Methods for Low Kick 2
	public boolean isLowKick2() {
		return lowKick2;
	}
	public void setLowKick2(boolean lowKick2) {
		this.lowKick2 = lowKick2;
	}

	
	
}


