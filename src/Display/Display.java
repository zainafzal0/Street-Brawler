package Display;

import java.awt.*;

import javax.swing.JFrame;

public class Display {

	private static JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	//Display constructor
	public Display(String title, int width, int height) {
		this.title=title;
		this.width=width;
		this.height=height;
		
		createDisplay();
	}
	
	//creating display
	private void createDisplay() {
		//creating JFrame
		frame = new JFrame(title);
		
		//setting window size
		frame.setSize(640,480);
		
		//setting close window to exit JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//locking window size
		frame.setResizable(false);
		
		//setting anchor point
		frame.setLocationRelativeTo(null);
		
		//Making jframe visible
		frame.setVisible(true);
		
		//Creating Canvas
		canvas = new Canvas();
		
		//Setting Canvas Size
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));

		//adding canvas to JFrame
		frame.add(canvas);
		
		//resizing window to fit canvas fully
		frame.pack();
		
		//Only JFrame can be focused on
		canvas.setFocusable(false);
		
		
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
}
