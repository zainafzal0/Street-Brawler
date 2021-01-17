package Game.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right, space,enter,interact;
	
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		//movement key inputs
		up = keys[KeyEvent.VK_W];
		left = keys[KeyEvent.VK_A];
		down = keys[KeyEvent.VK_S];
		right = keys[KeyEvent.VK_D];
		
		interact= keys[KeyEvent.VK_E];
		space= keys[KeyEvent.VK_SPACE];
		enter= keys[KeyEvent.VK_ENTER];

	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Key is being Pressed
		keys[e.getKeyCode()]=true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//Key in not being Pressed
		keys[e.getKeyCode()]=false;		
	}
	
}
