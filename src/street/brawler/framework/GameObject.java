/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Abstract Parent Class that contains all the 
 * required info for the players such as x,y values, velocity values, and abstract tick and render methods.
 */

package street.brawler.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject implements Objects{
	
	//Create protected Variables for Game Object
	protected float x,y;
	protected ObjectId id;
	protected float velX=0, velY=0;
	protected boolean falling = true,jumping = false;
	
	
	//Constructor for class to accept x,y and object id 
	public GameObject(float x,float y,ObjectId id) {
		this.x=x;
		this.y=x;
		this.id=id;
		
	}
	
	

	
	
	
	
	//Set and Get Methods for falling
	public boolean isFalling() {
		return falling;
	}
	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	//Set and Get Methods for Jumping
	public boolean isJumping() {
		return jumping;
	}
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	
	

	//Get Methods for X and Y
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	//Set Methods for X and Y
	public void setX(float x) {
		this.x=x;
	}
	public void setY(float y) {
		this.y=y;
	}
	
	
	//Get Methods for Velocity X and Y
	public float getVelX() {
		return velX;
	}
	public float getVelY() {
		return velY;
	}
	
	//Set Methods for Velocity X and Y
	public void setVelX(float velX) {
		this.velX=velX;
	}
	public void setVelY(float velY) {
		this.velY=velY;
	}
	
	//Abstract Method method for getting object id
	public abstract ObjectId getId();

	

}
