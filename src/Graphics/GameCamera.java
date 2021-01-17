package Graphics;

import Entity.Entity;
import Game.PocketHandler;
import Tiles.Tile;


public class GameCamera {

	private float xOffset, yOffset;
	
	private PocketHandler handler;
	
	public GameCamera(PocketHandler handler, float xOffset, float yOffset){
		this.xOffset=xOffset;
		this.yOffset=yOffset;
		this.handler=handler;
	}

	//checking if rendering blank space
	public void checkBlankSpace() {
		//checking left side
		if(xOffset < 0) {
			xOffset=0;
		}
		//checking right side
		else if(xOffset > handler.getWorld().getWidth()*Tile.TILE_WIDTH - handler.getWidth()){
			xOffset=handler.getWorld().getWidth()*Tile.TILE_WIDTH - handler.getWidth();
		}
		//checking top
		if(yOffset < 0) {
			yOffset=0;
		}
		//checking bottom
		else if(yOffset > handler.getWorld().getHeight()*Tile.TILE_HEIGHT - handler.getHeight()){
			yOffset = handler.getWorld().getHeight()*Tile.TILE_HEIGHT - handler.getHeight();
		}
	}
	
	//getting center of the screen
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth()/2 + e.getWidth()/2;
		yOffset = e.getY() - handler.getHeight()/2 + e.getHeight()/2;
		checkBlankSpace();
	}
	
	//move method
	public void move(float xAmount, float yAmount) {
		xOffset+= xAmount;
		yOffset+= yAmount;
		checkBlankSpace();

	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
		checkBlankSpace();
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
		checkBlankSpace();
	}
	
}
