package States;

import java.awt.Graphics;

import Game.Game;
import Game.PocketHandler;
import Graphics.Assets;
import Graphics.ImageLoader;

public class LosingState extends State{
	
	public LosingState(PocketHandler handler){
		super(handler);

	}

	@Override
	public void tick() {
		if(handler.getKeyManager().enter==true) {
			State.setState(handler.getGame().startingState);
		}
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.lose,0,0,null);
	}
	

}

