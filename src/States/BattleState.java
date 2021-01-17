package States;

import java.awt.Graphics;

import Game.Game;
import Game.PocketHandler;
import Graphics.Assets;
import Graphics.ImageLoader;

public class BattleState extends State{
	
	private int index, battle;
	private long lastTime, timer;
	
	public BattleState(PocketHandler handler){
		super(handler);
		index=0;
		timer=0;
		battle=0;
		
	}

	@Override
	public void tick() {
		//timer
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > 500) {
			index++;
			timer=0;
			if (index >= 8) {
				battle=1;
			}
		}
		if(battle==1) {
			State.setState(handler.getGame().attackState);
		}
	}

	@Override
	public void render(Graphics graphics) {
		if(index<8) {
			graphics.drawImage(Assets.versus,0,0,null);
		}
		
	}
	

}

