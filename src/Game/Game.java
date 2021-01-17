package Game;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import Display.Display;
import Game.Input.KeyManager;
import Game.Input.MouseManager;
import Graphics.Assets;
import Graphics.GameCamera;
import Graphics.ImageLoader;
import Graphics.SpriteSheet;
import States.AttackState;
import States.BattleState;
import States.BuildingState;
import States.FightingState;
import States.GameState;
import States.LosingState;
import States.MenuState;
import States.StartingState;
import States.State;
import States.StreetBrawlerState;
import States.WinningState;
import States.ZFighterRunState;
import street.brawler.framework.KeyInput;
import street.brawler.framework.KeyInputP1;
import street.brawler.framework.KeyInputP2;
import street.brawler.framework.ObjectId;
import street.brawler.players.Player1;
import street.brawler.window.Handler;

public class Game extends Canvas implements Runnable{

	//Display Variables
	private Display display;
	private int width, height;
	public String title;
	
	//Thread Variables
	private Thread threadOne;
	private boolean running= false;
	
	private BufferStrategy bufferStrategy;
	private Graphics graphics;
	
	//initializing states
	public State buildingState;
	public State gameState;
	public State menuState;
	public State startingState;
	public State streetFighter;
	public State zFighterRunState;
	public State fightingState;
	public State battleState;
	public State attackState;
	public State losingState;
	public State winningState;

	
	//Managers
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Game Camera
	private GameCamera gameCamera;
	
	//Handler
	private PocketHandler handler;
	Handler streetHandler;
	
	//game constructor 
	public Game(String title, int width, int height) {
		this.width=width;
		this.height=height;
		this.title=title;
		keyManager=new KeyManager();
		mouseManager=new MouseManager();
		
	}

	//init Method
	public void init() {
		this.display = new Display(title,width,height);
		
		//Key Inputs
		display.getFrame().addKeyListener(keyManager);
		
		
		
		
		
		
		//Mouse Inputs
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		
		//importing assets
		Assets.init();
		
		//Handler
		handler = new PocketHandler(this);
		streetHandler = new Handler();
		
		//Initializing camera
		gameCamera = new GameCamera(handler,0,0);
		
		//State objects
		buildingState = new BuildingState(handler);
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		startingState = new StartingState(handler);
		streetFighter = new StreetBrawlerState(handler);
		zFighterRunState = new ZFighterRunState(handler);
		fightingState = new FightingState(handler);
		battleState = new BattleState(handler);
		attackState = new AttackState(handler);
		winningState = new WinningState(handler);
		losingState = new LosingState(handler);

		State.setState(buildingState);
		
		
	}
		
	//Tick Speed Method ( Update Speed )
	private void tick() {
		
		keyManager.tick();
		if (State.getState() != null) {
			State.getState().tick();
		}
 	}
	
	//Render Method
	private void render() {
		bufferStrategy = display.getCanvas().getBufferStrategy();
		if (bufferStrategy == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
	
		graphics = bufferStrategy.getDrawGraphics();
		
		//clear screen
		graphics.clearRect(0, 0, width, height);
		
		//drawing Game State
		if (State.getState() != null) {
			State.getState().render(graphics);
		}
		
		//end drawing
		bufferStrategy.show();
		graphics.dispose();
		
	}
	
	//Run Thread Method
	public void run() {
		init();
		
		//Initializing Variables for FPS Limiter and Counter
		int fps=60;
		//maximum amount of time allowed to run render and tick methods in nanoseconds
		double timePerTick= 1000000000 / fps;
		double delta=0;
		long now;
		long lastTime = System.nanoTime();
		long timer=0;
		int ticks=0;
		
		//Game Loop
		while(running) {
			//Current time of system clock
			now = System.nanoTime();
			
			//divides time since code was last called by maximum allowed time for tick and render methods
			//Adds to delta to measure how much time remains before tick and render must rerun
			delta += (now - lastTime) / timePerTick;
			
			//adding amount of time since code last ran to timer
			timer+= now - lastTime;
			
			//restarts time measure from last recorded time
			lastTime=now;
		
			//checking if tick and render need to be run
			if(delta>=1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			//Printing FPS
			if(timer >= 1000000000) {
				System.out.println("FPS: " + ticks);
				ticks=0;
				timer=0;
			}
		}
		
		//Failsafe Stop
		stop();
	}
	
	//KeyManager Method
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	//MouseManager Method
		public MouseManager getMouseManager() {
			return mouseManager;
		}
		
	//Game Camera Method
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	//Width and Height
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	
	//Start Thread Method
	public synchronized void start() {
		//Setting Game Loop to True
		if(running) {
			return;
		}
		running=true;
		
		//Initializing Thread
		threadOne = new Thread(this);
		
		//Starting thread
		threadOne.start();
	}
	
	//Stop Thread Method
	public synchronized void stop() {
		//Ending Game Loop
				if(!running) {
					return;
				}
				running=false;
				
		//Close Thread
		try {
			threadOne.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
