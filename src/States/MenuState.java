package States;

import java.awt.Graphics;

import Game.Game;
import Game.PocketHandler;
import Graphics.Assets;
import Graphics.ImageLoader;

public class MenuState extends State{
	
	public MenuState(PocketHandler handler){
		super(handler);

	}

	@Override
	public void tick() {
		if(handler.getKeyManager().enter==true) {
			State.setState(handler.getGame().gameState);
		}
	}

	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.pkMenu,0,0,null);
	}
	

}

