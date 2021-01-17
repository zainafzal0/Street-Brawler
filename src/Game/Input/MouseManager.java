package Game.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import UI.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener{
	
	private boolean rightClick, leftClick;
	private int mouseX, mouseY;
	private UIManager uiManager;
	public MouseManager(){
		
	}
	
	public void setUIManager(UIManager uiManager) {
		this.uiManager=uiManager;
	}
	
	//getters
	
	public boolean isRightClick() {
		return rightClick;
	}

	public boolean isLeftClick() {
		return leftClick;
	}
	
	
	
	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		if(uiManager!=null) {
			uiManager.onMouseMove(e);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			leftClick=true;
		}
		else if(e.getButton()==MouseEvent.BUTTON3) {
			rightClick=true;
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			leftClick=false;
		}
		else if(e.getButton()==MouseEvent.BUTTON3) {
			rightClick=false;
		}
		if(uiManager!=null) {
			uiManager.onMouseRelease(e);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
