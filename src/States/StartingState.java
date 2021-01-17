package States;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Game.PocketHandler;
import Graphics.Animation;
import Graphics.Assets;
import Graphics.ImageLoader;

public class StartingState extends State{
	
	private int x=-320;
	private Animation aniContinue, blank;
	
	public StartingState(PocketHandler handler){
		super(handler);
		
		aniContinue = new Animation(500,Assets.continueAni);
		blank = new Animation(500,Assets.blank);
		
	}

	@Override
	public void tick() {
		aniContinue.tick();
		
		if (handler.getKeyManager().space) {
			if (x<=0 && x>=-40) {
				State.setState(handler.getGame().menuState);
			}
			else if (x<=-260 && x>=-380) {
				State.setState(handler.getGame().zFighterRunState);
			}
			else if (x>=-640 && x<=-600) {
				State.setState(handler.getGame().streetFighter);
			}
		}
		
		if (handler.getKeyManager().left) {
			x=x+5;
			if (x>0) {
				x=0;
			}
		}
		if (handler.getKeyManager().right) {
			x=x-5;
			if (x<-640) {
				x=-640;
			}
		}

	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.menu,x,0,null);
		graphics.drawImage(getCurrentAnimationFrame(),80,430,null);
		
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if (x<=0 && x>=-40) {
			return aniContinue.getCurrentFrame();
		}
		else if (x<=-260 && x>=-380) {
			return aniContinue.getCurrentFrame();
		}
		else if (x>=-640 && x<=-600) {
			return aniContinue.getCurrentFrame();
		}
		else {
			return blank.getCurrentFrame();
		}
		
	}
}
