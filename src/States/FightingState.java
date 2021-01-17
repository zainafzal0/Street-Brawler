package States;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Game.PocketHandler;
import Graphics.Animation;
import Graphics.Assets;

public class FightingState extends State{
	
	private Animation location;
	private int index;
	private long lastTime, timer;
	
	public FightingState(PocketHandler handler){
		super(handler);
		location = new Animation(500,Assets.location);
		index=0;
		timer=0;
	}

	@Override
	public void tick() {
		location.tick();
		
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > 500) {
			index++;
			timer=0;
			if (index == 4) {
				State.setState(handler.getGame().battleState);
				index=0;
			}
		}
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(getCurrentAnimationFrame(),0,0,null);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(index!=4) {
			return location.getCurrentFrame();
		}
		return null;
	}

}