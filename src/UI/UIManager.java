package UI;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Game.PocketHandler;

public class UIManager {
	
	private PocketHandler handler;
	private ArrayList<UIObject> objects;
	
	public UIManager(PocketHandler handler) {
		this.handler=handler;
		objects=new ArrayList<UIObject>();
	}
	
	public void tick() {
		//for every UIObject in the objects array
		for (UIObject o : objects) {
			o.tick();
		}
	}
	
	public void render(Graphics graphics) {
		for (UIObject o : objects) {
			o.render(graphics);
		}
	}
	
	public void onMouseMove(MouseEvent e) {
		for (UIObject o : objects) {
			o.onMouseMove(e);
		}
	}
	
	public void onMouseRelease(MouseEvent e) {
		for (UIObject o : objects) {
			o.onMouseRelease(e);
		}
	}
	
	public PocketHandler getHandler() {
		return handler;
	}

	public void setHandler(PocketHandler handler) {
		this.handler = handler;
	}

	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}

	public void addObject(UIObject o) {
		objects.add(o);
	}
	
	public void removeObject(UIObject o) {
		objects.remove(o);
		
	}
}
