package Entity.Statics;

import java.awt.Graphics;

import Game.PocketHandler;
import Graphics.Assets;

public class Brock extends StaticEntity {

	public Brock(PocketHandler handler, float x, float y) {
		super(handler, x, y, 57, 87);
		
		//boundaries
		bounds.x = 6;
		bounds.y = 29;
		bounds.width = 51;
		bounds.height = 44;
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.brock,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
	}
}