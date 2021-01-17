/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Makes abstract methods for all objects
 */
package street.brawler.framework;

import java.awt.Graphics;
import java.util.LinkedList;

public interface Objects {
	
	//Abstract Tick Method 
	public abstract void tick(LinkedList<GameObject> object);
	//Abstract Render Method
	public abstract void render(Graphics g,LinkedList<GameObject> object);
}
