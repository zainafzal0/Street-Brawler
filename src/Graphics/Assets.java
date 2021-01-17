package Graphics;

import java.awt.image.BufferedImage;

public class Assets {

	//grid size
	private static final int width = 24;
	private static final int height = 24;


	//all assets
	public static BufferedImage playerPick, pkMenu, menu, grass, leaves, leavesRight, leavesLeft, leavesUp, leavesDown, bush,waterTL, waterTM, 
								waterTR, waterML, water, waterMR, waterBL, waterBM, waterBR, leavesTR, leavesTL, leavesBR, leavesBL, brock, battle, versus,
								attacked, hurt,win,lose;
	public static BufferedImage[] mainMenu,girlSelect, boySelect, flash, blank, continueAni, boy_up, boy_down, boy_right, boy_left, boy_standingUp, 
								boy_standingDown, boy_standingLeft, boy_standingRight, girl_up, girl_down, girl_right, girl_left, girl_standingUp, 
								girl_standingDown, girl_standingLeft, girl_standingRight,location, fireBlast, fireFang, fly, dragonClaw, heal,
								team,opponent;
	
	public static void init() {
		SpriteSheet mainMenuSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/mainMenu.png"));
		SpriteSheet floorSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/floors.png"));
		SpriteSheet boySheet = new SpriteSheet(ImageLoader.loadImage("/Textures/Boy.png"));
		SpriteSheet startingSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/menu.png"));
		SpriteSheet menuSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/PKMenu.png"));
		SpriteSheet continueSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/continue.png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/PlayerPick.png"));
		SpriteSheet enemySheet = new SpriteSheet(ImageLoader.loadImage("/Textures/Enemies.png"));
		SpriteSheet locationSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/location.png"));
		SpriteSheet versusSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/versus.png"));
		SpriteSheet attackSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/battle.png"));
		SpriteSheet moveSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/moves.png"));
		SpriteSheet teamSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/team.png"));
		SpriteSheet opponentSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/opponents.png"));
		SpriteSheet attackedSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/attacked.png"));
		SpriteSheet hurtSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/hurt.png"));	
		SpriteSheet winSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/champion.png"));	
		SpriteSheet loseSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/blackedOut.png"));	


		mainMenu = new BufferedImage[12];
		boy_down = new BufferedImage[2];
		boy_up = new BufferedImage[2];
		boy_right = new BufferedImage[2];
		boy_left = new BufferedImage[2];
		boy_standingUp = new BufferedImage[1];
		boy_standingDown = new BufferedImage[1];
		boy_standingLeft = new BufferedImage[1];
		boy_standingRight = new BufferedImage[1];
		continueAni = new BufferedImage[2];
		blank = new BufferedImage[1];
		flash = new BufferedImage[5];
		boySelect = new BufferedImage[2];
		location = new BufferedImage[4];
		fireBlast = new BufferedImage[2];
		fireFang = new BufferedImage[2];
		fly = new BufferedImage[2];
		dragonClaw = new BufferedImage[2];
		heal = new BufferedImage[2];
		team = new BufferedImage[2];
		opponent = new BufferedImage[2];

		
		
		mainMenu[0]=mainMenuSheet.crop(0,0,640,512);
		mainMenu[1]=mainMenuSheet.crop(640,0,640,512);
		mainMenu[2]=mainMenuSheet.crop(1280,0,640,512);
		mainMenu[3]=mainMenuSheet.crop(1920,0,640,512);
		mainMenu[4]=mainMenuSheet.crop(2560,0,640,512);
		mainMenu[5]=mainMenuSheet.crop(3200,0,640,512);
		mainMenu[6]=mainMenuSheet.crop(3840,0,640,512);
		mainMenu[7]=mainMenuSheet.crop(4480,0,640,512);
		mainMenu[8]=mainMenuSheet.crop(5120,0,640,512);
		mainMenu[9]=mainMenuSheet.crop(5760,0,640,512);
		mainMenu[10]=mainMenuSheet.crop(6400,0,640,512);
		mainMenu[11]=mainMenuSheet.crop(7040,0,640,512);
		
		playerPick=playerSheet.crop(0,0,640,480);
		win=winSheet.crop(0,0,640,480);
		lose=loseSheet.crop(0,0,640,480);
		attacked=attackedSheet.crop(0,0,252,46);
		hurt=hurtSheet.crop(0,0,252,46);
		
		team[0]=teamSheet.crop(0, 0, 80, 79);
		team[1]=teamSheet.crop(80, 0, 80, 79);
		
		opponent[0]=opponentSheet.crop(0, 0, 81, 80);
		opponent[1]=opponentSheet.crop(81, 0, 81, 80);
		
		fireBlast[0]=moveSheet.crop(0, 0, 252, 46);
		fireBlast[1]=moveSheet.crop(252, 0, 252, 46);
		fireFang[0]=moveSheet.crop(0, 46, 252, 46);
		fireFang[1]=moveSheet.crop(252, 46, 252, 46);
		fly[0]=moveSheet.crop(0, 92, 252, 46);
		fly[1]=moveSheet.crop(252, 92, 252, 46);
		dragonClaw[0]=moveSheet.crop(0, 138, 252, 46);
		dragonClaw[1]=moveSheet.crop(252, 138, 252, 46);
		heal[0]=moveSheet.crop(0, 184, 252, 46);
		heal[1]=moveSheet.crop(252, 184, 252, 46);

		location[0]=locationSheet.crop(0,0,640,480);
		location[1]=locationSheet.crop(640,0,640,480);
		location[2]=locationSheet.crop(1280,0,640,480);
		location[3]=locationSheet.crop(1920,0,640,480);
		
		versus=versusSheet.crop(0,0,640,480);
		battle=attackSheet.crop(0,0,640,480);

		
		boy_up[0]=boySheet.crop(0,0,21,27);
		boy_up[1]=boySheet.crop(42,0,21,27);

		boy_left[0]=boySheet.crop(0,27,21,27);
		boy_left[1]=boySheet.crop(42,27,21,27);
		
		boy_down[0]=boySheet.crop(0,54,21,27);
		boy_down[1]=boySheet.crop(42,54,21,27);
		
		
		boy_right[0]=boySheet.crop(0,81,21,27);
		boy_right[1]=boySheet.crop(42,81,21,27);
		
		boy_standingUp[0]=boySheet.crop(21,0,21,27);
		boy_standingLeft[0]=boySheet.crop(21,27,21,27);
		boy_standingDown[0]=boySheet.crop(21,54,21,27);
		boy_standingRight[0]=boySheet.crop(21,81,21,27);
		
		continueAni[0] = continueSheet.crop(0,0,480,47);
		continueAni[1] = continueSheet.crop(0,47,480,47);
		

		pkMenu=menuSheet.crop(0,0,640,480);
		menu=startingSheet.crop(0,0,1280,480);
		
		brock=enemySheet.crop(19,0,19,29);
		//Flooring
		// ID 0
		grass=floorSheet.crop(0,0,width,height);
		// ID 1
		leaves=floorSheet.crop(width,0,width,height);
		// ID 2
		leavesUp=floorSheet.crop(width*2,0,width,height);
		// ID 3
		leavesLeft=floorSheet.crop(width*3,0,width,height);
		// ID 4
		leavesRight=floorSheet.crop(width*4,0,width,height);
		// ID 5
		leavesDown=floorSheet.crop(width*5,0,width,height);
		// ID 6
		bush=floorSheet.crop(width*6,0,width,height);
		// ID 7
		leavesBR=floorSheet.crop(width*7,0,width,height);
		//ID 8
		leavesBL=floorSheet.crop(width*8,0,width,height);
		//ID 9
		leavesTL=floorSheet.crop(width*9,0,width,height);
		//ID 10
		leavesTR=floorSheet.crop(0,height,width,height);
		// ID 9
		waterTL=floorSheet.crop(width,height,width,height);
		// ID 10
		waterTM=floorSheet.crop(width*2,height,width,height);
		// ID 11
		waterTR=floorSheet.crop(width*3,height,width,height);
		// ID 12
		waterML=floorSheet.crop(width*4,height,width,height);
		// ID 13
		water=floorSheet.crop(width*5,height,width,height);
		// ID 14
		waterMR=floorSheet.crop(width*6,height,width,height);
		// ID 15
		waterBL=floorSheet.crop(width*7,height,width,height);
		// ID 16
		waterBM=floorSheet.crop(width*8,height,width,height);
		// ID 17
		waterBR=floorSheet.crop(width*9,height,width,height);
		
	}
}
