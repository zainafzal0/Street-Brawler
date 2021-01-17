
/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Checks all the Collision bounds for the players
 */
package street.brawler.players;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import street.brawler.framework.GameObject;
import street.brawler.framework.KeyInputP1;
import street.brawler.framework.KeyInputP2;
import street.brawler.window.BufferedImageLoader;
import street.brawler.window.Game;
import street.brawler.window.Game.STATE;
import street.brawler.window.Handler;

public class Collision {
	
	//Create variables for if the player is hit
	public static boolean player1Hit;
	public static boolean player2Hit;
	
	//Create variables for Players health
	public static int Player1Health=0;
	public static int Player2Health=0;
	
	//Create variables for if the player is dead or not
	public static boolean player1Dead=false;
	public static boolean player2Dead=false;
	
	
	//Create Handler Object
	Handler handler;

	//Create Objects for both players keyInput
	KeyInputP1 keyInputP1;
	KeyInputP2 keyInputP2;
	
	//Constructor for Collision Class with Handler, KeyInputP1, and KeyInputP2 as parameters
	public Collision(Handler handler, KeyInputP1 keyInputP1, KeyInputP2 keyInputP2) {
		//Sets Objects accordingly
		this.handler=handler;		
		this.keyInputP1=keyInputP1;
		this.keyInputP2=keyInputP2;
	}
	
	
	//Tick Method to Update all variables
	public void tick(LinkedList<GameObject> object) {
		//Check if Player 1 health is at 250(Player 1 is dead)
		if(Player1Health>=250) {
			//Set player 1 to dead
			player1Dead=true;
			//Set Game state to ending
			Game.gameState=STATE.ENDING;
			//Set player 1 health back to full
			Player1Health=0;
		}
		
		//Check if Player 2 health is at 250(Player 2 is dead)
		if(Player2Health>=250) {
			//Set player 2 to dead
			player2Dead=true;
			//Set Game state to ending
			Game.gameState=STATE.ENDING;
			//Set player 2 health back to full
			Player2Health=0;
		}
		//==================================PLAYER 1 COLLISIONS=======================================

		//Check if player 1 did a quick punch
		if(keyInputP1.isQuickPunch1()==true) {
			//Check if Player 1 quick punch hit player 2
			if(getQPunch1Bounds().intersects(getPlayer2Bounds())) {
				//Set player 2 hit variable to true
				player2Hit=true;
			}
			
		}
		//Check if player 1 did a hard punch
		else if(keyInputP1.isHardPunch1()==true) {
			//Check if the Player 1 hard punch hit player 2 
			if(getPunch1Bounds().intersects(getPlayer2Bounds())) {
				//Set player 2 hit variable to true
				player2Hit=true;
			}
		}
		//Check if player 1 did a low kick
		else if(keyInputP1.isLowKick1()==true) {
			//Check if the Player 1 low kick hit player 2
			if(getLowKick1Bounds().intersects(getPlayer2Bounds())) {
				//Set player 2 hit variable to true
				player2Hit=true;
			}
		}
		//Check if player 1 did a upper kick
		else if(keyInputP1.isKick1()==true) {
			//Check if the Player 1 upper kick hit player 2
			if(getUpperKick1Bounds().intersects(getPlayer2Bounds())) {
				//Set player 2 hit variable to true
				player2Hit=true;
			}
		}
		//If none of player 1 actions hit player 2
		else {
			//Set player 2 hit variable to false
			player2Hit=false;
		}
		
		
		//==================================PLAYER 2 COLLISIONS=======================================
		
		//Check if player 2 did a quick punch
		if(keyInputP2.isQuickPunch2()==true) {
			//Check if Player 2 quick punch hit player 1
			if(getQPunch2Bounds().intersects(getPlayer1Bounds())) {
				//Set player 1 hit variable to false
				player1Hit=true;
			}
		}
		//Check if player 2 did a hard punch
		else if(keyInputP2.isHardPunch2()==true) {
			//Check if Player 2 hard punch hit player 1
			if(getPunch2Bounds().intersects(getPlayer1Bounds())) {
				//Set player 1 hit variable to false
				player1Hit=true;
			}
		}
		//Check if player 2 did a low kick
		else if(keyInputP2.isLowKick2()==true) {
			//Check if Player 2 low kick hit player 1
			if(getLowKick2Bounds().intersects(getPlayer1Bounds())) {
				//Set player 1 hit variable to false
				player1Hit=true;
			}
		}
		//Check if player 2 did a upper kick
		else if(keyInputP2.isKick2()==true) {
			//Check if Player 2 upper kick hit player 1
			if(getUpperKick2Bounds().intersects(getPlayer1Bounds())) {
				//Set player 1 hit variable to false
				player1Hit=true;
			}
		}
		
		else {
			//Set player 1 hit variable to true
			player1Hit=false;
		}
		
		
	}
	
	//Render Method to render all graphics
	public void render(Graphics g, LinkedList<GameObject> object) {
		Graphics2D g2d =(Graphics2D)g;
		
		//Set Color to red
		g.setColor(Color.red);
		
		//Fill Health Bars
		g2d.fill(HealthBar1());
		g2d.fill(HealthBar2());
		
		
		//Draw White Outline of health bars
		g.setColor(Color.white);
		g.drawRect(10, 10, 250, 30);
		g.drawRect(380, 10, 250, 30);
		
		
		//Draw Health Bars
		g.setColor(Color.yellow);
		g2d.fill(PlayerHealthBar1());
		g2d.fill(PlayerHealthBar2());
		
		
		
		
		
		
		
		
	}
	
	
	//Health Bar Methods that return the health bar rectangle
	public Rectangle HealthBar1() {
		return new Rectangle(10, 10, 250, 30);
	}
	public Rectangle HealthBar2() {
		return new Rectangle(380, 10, 250, 30);
	}
	public Rectangle PlayerHealthBar1() {
		return new Rectangle(10+Player1Health, 10, 250-Player1Health, 30);
	}
	public Rectangle PlayerHealthBar2() {
		return new Rectangle(380, 10, 250-Player2Health, 30);
	}
	
	
	//==================================PLAYER 1 COLLISIONS=======================================
	
	//This Method gets the player 1 rectangle bounds when called
	public Rectangle getPlayer1Bounds() {
		
		//Change the Bounds if player is crouching
		if(keyInputP1.isCrouch1()==true) {
			return new Rectangle((int)handler.object.get(0).getX(), (int)handler.object.get(0).getY()-50, (int)90, (int)212);
		}
		//Change the Bounds if player is not crouching
		else {
			return new Rectangle((int)handler.object.get(0).getX(), (int)handler.object.get(0).getY()-95, (int)90, (int)212);
		}
	}
	
	//This Method gets the player 1 Quick Punch bounds when called
	public Rectangle getQPunch1Bounds() {
		return new Rectangle((int)handler.object.get(0).getX()+90, (int)handler.object.get(0).getY()-80, 100, 30);
	}
	
	//This Method gets the player 1 Punch bounds when called
	public Rectangle getPunch1Bounds() {
		return new Rectangle((int)handler.object.get(0).getX()+100, (int)handler.object.get(0).getY()-72, 100, 30);
	}
	
	//This Method gets the player 1 Low kick bounds when called
	public Rectangle getLowKick1Bounds() {
		return new Rectangle((int)handler.object.get(0).getX()+100, (int)handler.object.get(0).getY()+45, 130, 30);
	}
	
	//This Method gets the player 1 Upper Kick bounds when called
	public Rectangle getUpperKick1Bounds() {
		return new Rectangle((int)handler.object.get(0).getX()+90, (int)handler.object.get(0).getY()-100, 130, 30);
	}
	
	
	//==================================PLAYER 2 COLLISIONS=======================================
	
	//This Method gets the player 2 rectangle bounds when called
	public Rectangle getPlayer2Bounds() {
		
		//Change the Bounds if player is crouching
		if(keyInputP2.isCrouch2()==true) {
			return new Rectangle((int)handler.object.get(1).getX()+15, (int)handler.object.get(1).getY()-50, (int)90, (int)212);
		}
		//Change the Bounds if player is not crouching
		else {
			return new Rectangle((int)handler.object.get(1).getX()+15, (int)handler.object.get(1).getY()-95, (int)90, (int)212);
		}
		
	}
	
	//This Method gets the player 2 Quick Punch bounds when called
	public Rectangle getQPunch2Bounds() {
		return new Rectangle((int)handler.object.get(1).getX()-60, (int)handler.object.get(1).getY()-80, 100, 30);
	}
	
	//This Method gets the player 2 Punch bounds when called
	public Rectangle getPunch2Bounds() {
		return new Rectangle((int)handler.object.get(1).getX()-80, (int)handler.object.get(1).getY()-82, 100, 30);
	}
	
	//This Method gets the player 2 Low Kick bounds when called
	public Rectangle getLowKick2Bounds() {
		return new Rectangle((int)handler.object.get(1).getX()-85, (int)handler.object.get(1).getY()-27, 130, 30);
	}
	
	//This Method gets the player 2 Upper Kick bounds when called
	public Rectangle getUpperKick2Bounds() {
		return new Rectangle((int)handler.object.get(1).getX()-135, (int)handler.object.get(1).getY()-10, 130, 30);
	}
	
	
	
	
}


