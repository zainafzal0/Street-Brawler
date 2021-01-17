/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Used in the End Screen as a timer to do specific animations at specific times
 */
package street.brawler.window;

import java.util.Timer;
import java.util.TimerTask;

public class EndScreenTimer implements Runnable{
	//Create variable for secondsPassed
	private double secondsPassed=0;
	
	//Create a timer object
	Timer timer = new Timer();
	
	//Create a timer task
	TimerTask task = new TimerTask() {
		public void run() {
			//Add 0.01 to secondsPassed every 0.01 seconds
			secondsPassed=secondsPassed+0.01;
			
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
			timer.scheduleAtFixedRate(task, 0, 10);
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
	
	
	
}