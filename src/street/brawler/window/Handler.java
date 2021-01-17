/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Used to render and tick the two players
 */
package street.brawler.window;

import java.awt.Graphics;
import java.util.LinkedList;

import street.brawler.framework.GameObject;
import street.brawler.window.Game.STATE;

public class Handler {
	
	//Create LinkedList to store all the objects in the game
	public LinkedList<GameObject> object =new LinkedList<GameObject>();
	
	//Create Variable for tempObject
	private GameObject tempObject;
	
	
	//Tick method to update variables
	public void tick() {
		
		//For Loop to cycle through both players
		for(int i=0;i<object.size();i++) {
			tempObject=object.get(i);
			
			tempObject.tick(object);
		}
	}
	
	
	//Render Method to render player graphics
	public void render(Graphics g) {
		//Checks if the game state is game
		if(Game.gameState==STATE.GAME) {
			//Draws game background chosen by user
			g.drawImage(Game.gameBackground, 0, 0, null);
			
			//For Loop to cycle through the players
			for(int i=0;i<object.size();i++) {
				tempObject=object.get(i);
				
				tempObject.render(g,object);
			}
			
			
		}
		
		
	}
	
	//Method to add object in the Linked List
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	//Method to remove object in the Linked List
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

}
