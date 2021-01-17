package Entity.Creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Entity.Entity;
import Game.PocketHandler;
import Graphics.Animation;
import Graphics.Assets;
import States.State;

public class Player extends Creature{

	//animations
	private Animation aniDown, aniUp, aniLeft, aniRight, standingUp, standingDown, standingLeft, standingRight;
	private int direction;
	
	public Player(PocketHandler handler,float x, float y) {
		super (handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//boundaries
		bounds.x = 6;
		bounds.y = 0;
		bounds.width = 51;
		bounds.height = 55;
		
		direction=3;
		
		//animations Boy
		aniDown = new Animation(250,Assets.boy_down);
		aniUp = new Animation(250,Assets.boy_up);
		aniLeft = new Animation(250,Assets.boy_left);
		aniRight = new Animation(250,Assets.boy_right);
		standingDown = new Animation(250,Assets.boy_standingDown);
		standingUp = new Animation(250,Assets.boy_standingUp);
		standingLeft = new Animation(250,Assets.boy_standingLeft);
		standingRight = new Animation(250,Assets.boy_standingRight);
		direction=3;
		
	}

	@Override
	public void tick() {
		//animations
		aniDown.tick();
		aniUp.tick();
		aniLeft.tick();
		aniRight.tick();
		//getting keystrokes
		getInput();
		
		//moving
		move();
		
		//centering camera 
		handler.getGameCamera().centerOnEntity(this);
		
		//interact
		checkInteract();
	}
	
	public void checkInteract() {
		Rectangle position = getCollisionBounds(-25,-25);
		Rectangle interact = new Rectangle();
		int range = 100;
		interact.width=range;
		interact.height=range;
		if(handler.getKeyManager().interact) {
			interact.x=position.x;
			interact.y=position.y;

		}
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0,0).intersects(interact)) {
				State.setState(handler.getGame().fightingState);
			}
			
		}
	}
	private void getInput() {
		xMove=0;
		yMove=0;
		
		//movement handling
		if (handler.getKeyManager().up) {
			yMove=-speed;
		}
		if (handler.getKeyManager().down) {
			yMove=speed;
		}
		if (handler.getKeyManager().left) {
			xMove=-speed;
		}
		if (handler.getKeyManager().right) {
			xMove=speed;
		}
	}

	@Override
	public void render(Graphics graphics) {
		//casting x and y from float to int
		graphics.drawImage(getCurrentAnimationFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width, height, null);
		
		//graphics.setColor(Color.red);
		//graphics.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove > 0) {
			direction=1;
			return aniRight.getCurrentFrame();
		}
		else if(xMove < 0) {
			direction=2;
			return aniLeft.getCurrentFrame();
		}
		else if(yMove > 0) {
			direction=3;
			return aniUp.getCurrentFrame();
		}
		else if(yMove < 0) {
			direction=4;
			return aniDown.getCurrentFrame();
		}
		else {
			if (direction==1) {
				return standingRight.getCurrentFrame();
			}
			if (direction==2) {
				return standingLeft.getCurrentFrame();
			}
			if (direction==3) {
				return standingUp.getCurrentFrame();
			}
			if (direction==4) {
				return standingDown.getCurrentFrame();
			}
			else {
				return standingUp.getCurrentFrame();
			}
		}
	}

}
