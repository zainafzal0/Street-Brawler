package Entity.Creatures;

import Entity.Entity;
import Game.PocketHandler;
import Tiles.Tile;

public abstract class Creature extends Entity{
	
	//Stats
	protected int health;
	protected float speed;
	protected float xMove;
	protected float yMove;
	
	//Default Stats
	public static final int DEFAULT_HEALTH=100;
	public static final float DEFAULT_SPEED=4.0f;
	public static final int DEFAULT_CREATURE_WIDTH=63;
	public static final int DEFAULT_CREATURE_HEIGHT=81;

	public Creature(PocketHandler handler, float x, float y,int widht, int hieght) {
		super(handler, x, y,widht,hieght);
		health=DEFAULT_HEALTH;
		speed=DEFAULT_SPEED;
		xMove=0;
		yMove=0;
	}
	
	//moving
	public void move() {
		if(!checkEntityCollisions(xMove,0f)) {
			moveX();
		}
		if(!checkEntityCollisions(0f,yMove)) {
			moveY();
		}
	}
	
	public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
				x += xMove;
			}
			
			//fixing boundary gap 
			else {
				x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
			}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
				x += xMove;
			}
			
			//fixing boundary gap
			else {
				x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
			}
		}
	}
	
	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)){
				y += yMove;
			}
			//fixing boundary gap
			else {
				y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
			}
			
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)){
				y += yMove;
			}
			
			//fixing boundary gap
			else {
				y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}
	
	//collision
	public boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x,y).isSolid();
	}

	//Getters and Setters
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
	
	
}
