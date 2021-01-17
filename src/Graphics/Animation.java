package Graphics;

import java.awt.image.BufferedImage;

public class Animation {

	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	
	public Animation(int speed, BufferedImage[] frames) {
		this.speed=speed;
		this.frames=frames;
		index=0;
		timer=0;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick() {
		//timer
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed) {
			index++;
			timer=0;
			//resetting index to 0 after animation ( looping animation ) 
			if (index >= frames.length) {
				index=0;
			}
		}
	}
	
	//getting frame at specific index
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
}
