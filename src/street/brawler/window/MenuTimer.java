/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Used in the Main Menu as a timer to do specific animations at specific times
 */
package street.brawler.window;

import java.util.Timer;
import java.util.TimerTask;

public class MenuTimer implements Runnable{
	//Create variable for secondsPassed
	private double secondsPassed=0;
	private int loadingx;
	//Create a timer object
	Timer timer = new Timer();
	
	//Create a timer task
	TimerTask task = new TimerTask() {
		public void run() {
			//Add 0.1 to secondsPassed every 0.1 seconds
			secondsPassed=secondsPassed+0.1;
			loadingx=loadingx+20;
			
		}
	};
	
	//Create a thread 
	Thread thread;
	
	//Create variable to see if thread is running or not
	private boolean running=false;
	
	//Start method to start the thread
	public synchronized void start() {
		if(running) {
			return;
		}
		
		//Set Running to true
		running = true;
		
		//Start the thread
		thread = new Thread(this);
		thread.start();
		
	}
	
	
	//Stop Method to stop the thread
	public synchronized void stop() {
		if(!running) {
			return;
		}
		//Set Running to false
		running = false;
		
		//Stop Thread
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Run Method to keep running the method
	public void run() {
		try {
			//Start the timer using the timer task created and have it set to tick every 10 milli seconds
			timer.scheduleAtFixedRate(task, 0, 100);
		}catch(Exception e) {
			new Thread(this).start();
			System.exit(0);
		}
		
	}

	//Get and Set Method for Seconds Passed
	public double getSecondsPassed() {
		return secondsPassed;
	}
	public void setSecondsPassed(double secondsPassed) {
		this.secondsPassed = secondsPassed;
	}
	
	
	//Get and set Methos for loadingx
	public int getLoadingx() {
		return loadingx;
	}

	public void setLoadingx(int loadingx) {
		this.loadingx = loadingx;
	}

	
	
	
}