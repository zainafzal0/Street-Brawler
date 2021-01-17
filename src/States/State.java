package States;

import java.awt.Graphics;
import Game.PocketHandler;

public abstract class State {

	public abstract void tick(); 

	public abstract void render(Graphics graphics);
	protected PocketHandler handler;
	
	//Constructor
	public State(PocketHandler handler) {
		this.handler=handler;
	}
	
	//Game State manager
		private static State currentState=null;

		public static void setState(State State) {
			currentState = State;
		}
		 
		public static State getState() {
			return currentState;
		}
	
}
