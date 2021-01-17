package UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Button extends UIObject{
	
	private BufferedImage[] images;
	private ClickListener clicker;
	

	public Button(float x, float y, int width, int height,BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images=images;
		this.clicker=clicker;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics graphics) {
		if(hovering) {
			graphics.drawImage(images[1], (int)x, (int)y, width, height, null);
		}
		else {
			graphics.drawImage(images[0], (int)x, (int)y, width, height, null);
		}
	}

	@Override
	public void onClick() {
		clicker.onCLick();		
	}

}
