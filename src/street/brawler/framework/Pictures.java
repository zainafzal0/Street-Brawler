/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Gets every image required for the game
 * Citation: https://www.spriters-resource.com/
 */
package street.brawler.framework;

import java.awt.image.BufferedImage;

import street.brawler.window.BufferedImageLoader;

public class Pictures {
	
	
	//End Screen Background
	SpriteSheet endScreenSheet;
	private BufferedImage endScreen=null;
	public BufferedImage[] endScreenSprites= new BufferedImage[43];
	
	//End Screen Ken Background
	SpriteSheet endScreenKenSheet;
	private BufferedImage endScreenKen=null;
	public BufferedImage[] endScreenKenSprites= new BufferedImage[43];
	
	//KO Ryu Text
	SpriteSheet KORyuSheet;
	private BufferedImage KORyu=null;
	public BufferedImage[] KORyuSprites= new BufferedImage[18];
	
	//KO Ken Text
	SpriteSheet KOKenSheet;
	private BufferedImage KOKen=null;
	public BufferedImage[] KOKenSprites= new BufferedImage[18];
	
	
	//================================PLAYER 1 ANIMATION VARIABLES==================================
	
	//Ryu Idle Variables
	SpriteSheet Player1IdleSheet;
	private BufferedImage Player1Idle=null;
	public BufferedImage[] Player1IdleSprites= new BufferedImage[6];
	
	//Ryu Parry Forward Variables
	SpriteSheet Player1ParryFSheet;
	private BufferedImage Player1ParryF=null;
	public BufferedImage[] Player1ParryFSprites= new BufferedImage[8];
	
	//Ryu Parry Forward Variables
	SpriteSheet Player1ParryBSheet;
	private BufferedImage Player1ParryB=null;
	public BufferedImage[] Player1ParryBSprites= new BufferedImage[8];
	
	//Ryu Crouch Variables
	SpriteSheet Player1CrouchSheet;
	private BufferedImage Player1Crouch=null;
	public BufferedImage[] Player1CrouchSprites= new BufferedImage[1];
	
	//Ryu Jump Up Variables
	SpriteSheet Player1JumpSheet;
	private BufferedImage Player1Jump=null;
	public BufferedImage[] Player1JumpSprites= new BufferedImage[10];
	
	//Ryu Front Flip Variables
	SpriteSheet Player1FFlipSheet;
	private BufferedImage Player1FFlip=null;
	public BufferedImage[] Player1FFlipSprites= new BufferedImage[8];
	
	//Ryu Back Flip Variables
	SpriteSheet Player1BFlipSheet;
	private BufferedImage Player1BFlip=null;
	public BufferedImage[] Player1BFlipSprites= new BufferedImage[8];
	
	//Ryu Quick Punch Variables
	SpriteSheet Player1QPunchSheet;
	private BufferedImage Player1QPunch=null;
	public BufferedImage[] Player1QPunchSprites= new BufferedImage[4];
	
	//Ryu Punch Variables
	SpriteSheet Player1PunchSheet;
	private BufferedImage Player1Punch=null;
	public BufferedImage[] Player1PunchSprites= new BufferedImage[6];
	
	//Ryu Upper Kick Variables
	SpriteSheet Player1UpperKickSheet;
	private BufferedImage Player1UpperKick=null;
	public BufferedImage[] Player1UpperKickSprites= new BufferedImage[9];
	
	//Ryu Low Kick Variables
	SpriteSheet Player1LowKickSheet;
	private BufferedImage Player1LowKick=null;
	public BufferedImage[] Player1LowKickSprites= new BufferedImage[5];
	
	//Ryu Hit Variables
	SpriteSheet Player1HitSheet;
	private BufferedImage Player1Hit=null;
	public BufferedImage[] Player1HitSprites= new BufferedImage[1];
	
	//Ryu Hit Move Right Variables
	SpriteSheet Player1HitMoveRSheet;
	private BufferedImage Player1HitMoveR=null;
	public BufferedImage[] Player1HitMoveRSprites= new BufferedImage[8];
	
	//Ryu Hit Move Left Variables
	SpriteSheet Player1HitMoveLSheet;
	private BufferedImage Player1HitMoveL=null;
	public BufferedImage[] Player1HitMoveLSprites= new BufferedImage[8];
	
	//Ryu Crouch Hit Variables
	SpriteSheet Player1HitCrouchSheet;
	private BufferedImage Player1HitCrouch=null;
	public BufferedImage[] Player1HitCrouchSprites= new BufferedImage[1];
	
	//Ryu Air Punch Variables
	SpriteSheet Player1AirPunchSheet;
	private BufferedImage Player1AirPunch=null;
	public BufferedImage[] Player1AirPunchSprites= new BufferedImage[6];
	
	//Ryu Hit Back Variables
	SpriteSheet Player1HitBackSheet;
	private BufferedImage Player1HitBack=null;
	public BufferedImage[] Player1HitBackSprites= new BufferedImage[4];
	
	//Ryu Dead Variables
	SpriteSheet Player1DeadSheet;
	private BufferedImage Player1Dead=null;
	public BufferedImage[] Player1DeadSprites= new BufferedImage[1];
	
	//Ryu Knockout Variables
	SpriteSheet Player1KOSheet;
	private BufferedImage Player1KO=null;
	public BufferedImage[] Player1KOSprites= new BufferedImage[12];
		
	
	//================================PLAYER 2 ANIMATION VARIABLES==================================
	//Ken Idle Variables
	SpriteSheet Player2IdleSheet;
	private BufferedImage Player2Idle=null;
	public BufferedImage[] Player2IdleSprites= new BufferedImage[6];
		
	//Ken Parry Forward Variables
	SpriteSheet Player2ParryFSheet;
	private BufferedImage Player2ParryF=null;
	public BufferedImage[] Player2ParryFSprites= new BufferedImage[8];
		
	//Ken Parry Forward Variables
	SpriteSheet Player2ParryBSheet;
	private BufferedImage Player2ParryB=null;
	public BufferedImage[] Player2ParryBSprites= new BufferedImage[8];
		
	//Ken Crouch Variables
	SpriteSheet Player2CrouchSheet;
	private BufferedImage Player2Crouch=null;
	public BufferedImage[] Player2CrouchSprites= new BufferedImage[1];
		
	//Ken Jump Up Variables
	SpriteSheet Player2JumpSheet;
	private BufferedImage Player2Jump=null;
	public BufferedImage[] Player2JumpSprites= new BufferedImage[9];
		
	//Ken Front Flip Variables
	SpriteSheet Player2FFlipSheet;
	private BufferedImage Player2FFlip=null;
	public BufferedImage[] Player2FFlipSprites= new BufferedImage[8];
		
	//Ken Back Flip Variables
	SpriteSheet Player2BFlipSheet;
	private BufferedImage Player2BFlip=null;
	public BufferedImage[] Player2BFlipSprites= new BufferedImage[8];
		
	//Ken Quick Punch Variables
	SpriteSheet Player2QPunchSheet;
	private BufferedImage Player2QPunch=null;
	public BufferedImage[] Player2QPunchSprites= new BufferedImage[4];
		
	//Ken Punch Variables
	SpriteSheet Player2PunchSheet;
	private BufferedImage Player2Punch=null;
	public BufferedImage[] Player2PunchSprites= new BufferedImage[8];
		
	//Ken Upper Kick Variables
	SpriteSheet Player2UpperKickSheet;
	private BufferedImage Player2UpperKick=null;
	public BufferedImage[] Player2UpperKickSprites= new BufferedImage[10];
		
	//Ken Lower Kick Variables
	SpriteSheet Player2LowKickSheet;
	private BufferedImage Player2LowKick=null;
	public BufferedImage[] Player2LowKickSprites= new BufferedImage[5];
	
	//Ken Hit Variables
	SpriteSheet Player2HitSheet;
	private BufferedImage Player2Hit=null;
	public BufferedImage[] Player2HitSprites= new BufferedImage[1];
	
	//Ken Hit Move Left Variables
	SpriteSheet Player2HitMoveLSheet;
	private BufferedImage Player2HitMoveL=null;
	public BufferedImage[] Player2HitMoveLSprites= new BufferedImage[8];
	
	//Ken Hit Move Right Variables
	SpriteSheet Player2HitMoveRSheet;
	private BufferedImage Player2HitMoveR=null;
	public BufferedImage[] Player2HitMoveRSprites= new BufferedImage[8];
	
	
	//Ken Dead Variables
	SpriteSheet Player2DeadSheet;
	private BufferedImage Player2Dead=null;
	public BufferedImage[] Player2DeadSprites= new BufferedImage[1];
	
	//Ken Hit Stand Variables
	SpriteSheet Player2HitStandSheet;
	private BufferedImage Player2HitStand=null;
	public BufferedImage[] Player2HitStandSprites= new BufferedImage[4];
	
	//Ken Knockout Variables
	SpriteSheet Player2KnockoutSheet;
	private BufferedImage Player2Knockout=null;
	public BufferedImage[] Player2KnockoutSprites= new BufferedImage[8];
	
	
	//Ken Crouch Hit Variables
	SpriteSheet Player2CrouchHitSheet;
	private BufferedImage Player2CrouchHit=null;
	public BufferedImage[] Player2CrouchHitSprites= new BufferedImage[1];
	
	
	//Default Constructor
	public Pictures() {
		
		//Instantiates Image Loader object
		BufferedImageLoader loader = new BufferedImageLoader();
		
		
		
		//Loads all the images in
		try {
			
			//Load End Screen Sprite Sheet
			endScreen = loader.loadImage("/OtherPictures/endScreen.png");
			//Load End Screen Ken Sprite Sheet
			endScreenKen = loader.loadImage("/OtherPictures/endScreenRed.png");
			//Load Ryu Knockout Sprite Sheet
			KORyu = loader.loadImage("/OtherPictures/KORyu.png");
			//Load Ryu Ken Sprite Sheet
			KOKen = loader.loadImage("/OtherPictures/KOKen.png");
			
			//================================PLAYER 1 LOAD IMAGES==================================
			
			
			//Load Idle Sprite Sheet
			Player1Idle = loader.loadImage("/AnimationRyu/idle.png");
			//Load Parry forward Sprite Sheet
			Player1ParryF = loader.loadImage("/AnimationRyu/parry_f.png");
			//Load Parry forward Sprite Sheet
			Player1ParryB = loader.loadImage("/AnimationRyu/parry_b.png");
			//Load Crouch Sprite Sheet
			Player1Crouch = loader.loadImage("/AnimationRyu/crouch.png");
			//Load Jump Sprite Sheet
			Player1Jump = loader.loadImage("/AnimationRyu/jump.png");
			//Load Front Flip Sprite Sheet
			Player1FFlip = loader.loadImage("/AnimationRyu/front_flip.png");
			//Load Back Flip Sprite Sheet
			Player1BFlip = loader.loadImage("/AnimationRyu/back_flip.png");
			//Load Quick Punch Sprite Sheet
			Player1QPunch = loader.loadImage("/AnimationRyu/quick_punch.png");
			//Load Punch Sprite Sheet
			Player1Punch = loader.loadImage("/AnimationRyu/punch.png");
			//Load Upper Kick Sprite Sheet
			Player1UpperKick = loader.loadImage("/AnimationRyu/upper_kick.png");
			//Load Lower Kick Sprite Sheet
			Player1LowKick = loader.loadImage("/AnimationRyu/kick_low.png");
			//Load Hit Sprite Sheet
			Player1Hit = loader.loadImage("/AnimationRyu/hit_stand.png");
			//Load Hit Move Right Sprite Sheet
			Player1HitMoveR = loader.loadImage("/AnimationRyu/HitRunLeft.png");
			//Load Hit Move Left Sprite Sheet
			Player1HitMoveL = loader.loadImage("/AnimationRyu/HitRunRight.png");
			//Load Air Punch Sprite Sheet
			Player1AirPunch = loader.loadImage("/AnimationRyu/air_punch.png");
			//Load Hit Crouch Sprite Sheet
			Player1HitCrouch = loader.loadImage("/AnimationRyu/crouch_hit.png");
			//Load Hit Back Sprite Sheet
			Player1HitBack = loader.loadImage("/AnimationRyu/hit_stand_b.png");
			//Load Dead Sprite Sheet
			Player1Dead = loader.loadImage("/AnimationRyu/dead.png");
			//Load KO Sprite Sheet
			Player1KO = loader.loadImage("/AnimationRyu/knockout.png");
			
			
			//================================PLAYER 2 LOAD IMAGES==================================
			
			
			//Load Idle Sprite Sheet
			Player2Idle = loader.loadImage("/AnimationKen/idle.png");
			//Load Parry forward Sprite Sheet
			Player2ParryF = loader.loadImage("/AnimationKen/parry_f.png");
			//Load Parry Backwards Sprite Sheet
			Player2ParryB = loader.loadImage("/AnimationKen/parry_b.png");
			//Load Crouch Sprite Sheet
			Player2Crouch = loader.loadImage("/AnimationKen/crouch.png");
			//Load Jump Sprite Sheet
			Player2Jump = loader.loadImage("/AnimationKen/jump.png");
			//Load Front Flip Sprite Sheet
			Player2FFlip = loader.loadImage("/AnimationKen/front_flip.png");
			//Load Back Flip Sprite Sheet
			Player2BFlip = loader.loadImage("/AnimationKen/back_flip.png");
			//Load Quick Punch Sprite Sheet
			Player2QPunch = loader.loadImage("/AnimationKen/quick_punch.png");
			//Load Punch Sprite Sheet
			Player2Punch = loader.loadImage("/AnimationKen/punch.png");
			//Load Upper Kick Sprite Sheet
			Player2UpperKick = loader.loadImage("/AnimationKen/upper_kick.png");
			//Load Back Flip Sprite Sheet
			Player2LowKick = loader.loadImage("/AnimationKen/kick_low.png");
			//Load Back Flip Sprite Sheet
			Player2Hit = loader.loadImage("/AnimationKen/hit_stand.png");
			//Load Back Flip Sprite Sheet
			Player2HitMoveL = loader.loadImage("/AnimationKen/HitRunLeft.png");
			//Load Back Flip Sprite Sheet
			Player2HitMoveR = loader.loadImage("/AnimationKen/HitRunRight.png");
			//Load Back Flip Sprite Sheet
			Player2Dead = loader.loadImage("/AnimationKen/dead.png");
			//Load  Sprite Sheet
			Player2HitStand = loader.loadImage("/AnimationKen/hit_stand_b.png");
			//Load Back Flip Sprite Sheet
			Player2Knockout = loader.loadImage("/AnimationKen/end.png");
			//Load Hit Crouch Sprite Sheet
			Player2CrouchHit = loader.loadImage("/AnimationKen/crouch_hit.png");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
				
		//Create SpriteSheet for End Screen
		endScreenSheet = new SpriteSheet(endScreen);
		//Create SpriteSheet for End Screen Ken
		endScreenKenSheet = new SpriteSheet(endScreenKen);
		//Create SpriteSheet KORyu
		KORyuSheet = new SpriteSheet(KORyu);
		//Create SpriteSheet for KOKen
		KOKenSheet = new SpriteSheet(KOKen);
		
		//================================PLAYER 1 CREATE SPRITESHEET WITH LOADED IMAGE==================================
		
		
		//Create SpriteSheet for Ryu Idle
		Player1IdleSheet = new SpriteSheet(Player1Idle);
		//Creat SpriteSheet for Ryu Parry Forward
		Player1ParryFSheet = new SpriteSheet(Player1ParryF);
		//Creat SpriteSheet for Ryu Parry Forward
		Player1ParryBSheet = new SpriteSheet(Player1ParryB);
		//Creat SpriteSheet for Ryu Crouch
		Player1CrouchSheet = new SpriteSheet(Player1Crouch);
		//Creat SpriteSheet for Ryu Jump
		Player1JumpSheet = new SpriteSheet(Player1Jump);
		//Creat SpriteSheet for Ryu Front Flip
		Player1FFlipSheet = new SpriteSheet(Player1FFlip);
		//Creat SpriteSheet for Ryu Back Flip
		Player1BFlipSheet = new SpriteSheet(Player1BFlip);
		//Creat SpriteSheet for Ryu Quick Punch
		Player1QPunchSheet = new SpriteSheet(Player1QPunch);
		//Creat SpriteSheet for Ryu Upper Kick
		Player1UpperKickSheet = new SpriteSheet(Player1UpperKick);
		//Creat SpriteSheet for Ryu Low Kick
		Player1LowKickSheet = new SpriteSheet(Player1LowKick);
		//Creat SpriteSheet for Ryu Hard Punch
		Player1PunchSheet = new SpriteSheet(Player1Punch);
		//Creat SpriteSheet for Ryu Hit
		Player1HitSheet = new SpriteSheet(Player1Hit);
		//Creat SpriteSheet for Ryu Hit (While Moving Right)
		Player1HitMoveRSheet = new SpriteSheet(Player1HitMoveR);
		//Creat SpriteSheet for Ryu Hit (While Moving Left)
		Player1HitMoveLSheet = new SpriteSheet(Player1HitMoveL);
		//Creat SpriteSheet for Ryu Air Punch
		Player1AirPunchSheet = new SpriteSheet(Player1AirPunch);
		//Creat SpriteSheet for Ryu Hit
		Player1HitCrouchSheet = new SpriteSheet(Player1HitCrouch);
		//Creat SpriteSheet for Ryu Hit Back
		Player1HitBackSheet = new SpriteSheet(Player1HitBack);
		//Creat SpriteSheet for Ryu Dead
		Player1DeadSheet = new SpriteSheet(Player1Dead);
		//Creat SpriteSheet for Ryu KO
		Player1KOSheet = new SpriteSheet(Player1KO);
		
		
		//================================PLAYER 2 CREATE SPRITESHEET WITH LOADED IMAGE==================================
		
		
		//Create SpriteSheet for Ken Idle
		Player2IdleSheet = new SpriteSheet(Player2Idle);
		//Create SpriteSheet for Ken Parry Forward
		Player2ParryFSheet = new SpriteSheet(Player2ParryF);
		//Create SpriteSheet for Ken Parry backwards
		Player2ParryBSheet = new SpriteSheet(Player2ParryB);
		//Create SpriteSheet for Ken Crouch
		Player2CrouchSheet = new SpriteSheet(Player2Crouch);
		//Create SpriteSheet for Ken Jump
		Player2JumpSheet = new SpriteSheet(Player2Jump);
		//Create SpriteSheet for Ken Front flip
		Player2FFlipSheet = new SpriteSheet(Player2FFlip);
		//Create SpriteSheet for Ken Back flip
		Player2BFlipSheet = new SpriteSheet(Player2BFlip);
		//Create SpriteSheet for Ken Quick Punch
		Player2QPunchSheet = new SpriteSheet(Player2QPunch);
		//Create SpriteSheet for Ken Upper kick
		Player2UpperKickSheet = new SpriteSheet(Player2UpperKick);
		//Create SpriteSheet for Ken Low kick
		Player2LowKickSheet = new SpriteSheet(Player2LowKick);
		//Create SpriteSheet for Ken Punch
		Player2PunchSheet = new SpriteSheet(Player2Punch);
		//Create SpriteSheet for Ken Hit
		Player2HitSheet = new SpriteSheet(Player2Hit);
		//Create SpriteSheet for Ken Hit Move Left
		Player2HitMoveLSheet = new SpriteSheet(Player2HitMoveL);
		//Create SpriteSheet for Ken Hit Move Right
		Player2HitMoveRSheet = new SpriteSheet(Player2HitMoveR);
		//Create SpriteSheet for Ken Knockout
		Player2KnockoutSheet = new SpriteSheet(Player2Knockout);
		//Create SpriteSheet for Ken Dead
		Player2DeadSheet = new SpriteSheet(Player2Dead);
		//Create SpriteSheet for Ken Hit Stand
		Player2HitStandSheet = new SpriteSheet(Player2HitStand);
		//Creat SpriteSheet for Ryu Crouch Hit
		Player2CrouchHitSheet = new SpriteSheet(Player2CrouchHit);
		
		//Call Method to cut pictures
		getPicture();
	}
	
	private void getPicture() {
				
		//Blue Background
		endScreenSprites[0]= endScreenSheet.grabImage(640, 480, 640 *0, 0);
		endScreenSprites[1]= endScreenSheet.grabImage(640, 480, 640 *1, 0);
		endScreenSprites[2]= endScreenSheet.grabImage(640, 480, 640 *2, 0);
		endScreenSprites[3]= endScreenSheet.grabImage(640, 480, 640 *3, 0);
		
		
		endScreenSprites[4]= endScreenSheet.grabImage(640, 480, 640 * 0, 480);
		endScreenSprites[5]= endScreenSheet.grabImage(640, 480, 640 * 1, 480);
		endScreenSprites[6]= endScreenSheet.grabImage(640, 480, 640 * 2, 480);
		endScreenSprites[7]= endScreenSheet.grabImage(640, 480, 640 * 3, 480);
		
		endScreenSprites[8]= endScreenSheet.grabImage(640, 480, 640 * 0, 960);
		endScreenSprites[9]= endScreenSheet.grabImage(640, 480, 640 * 1, 960);
		endScreenSprites[10]= endScreenSheet.grabImage(640, 480, 640 * 2, 960);
		endScreenSprites[11]= endScreenSheet.grabImage(640, 480, 640 * 3, 960);
		
		endScreenSprites[12]= endScreenSheet.grabImage(640, 480, 640 * 0, 1440);
		endScreenSprites[13]= endScreenSheet.grabImage(640, 480, 640 * 1, 1440);
		endScreenSprites[14]= endScreenSheet.grabImage(640, 480, 640 * 2, 1440);
		endScreenSprites[15]= endScreenSheet.grabImage(640, 480, 640 * 3, 1440);
		
		endScreenSprites[16]= endScreenSheet.grabImage(640, 480, 640 * 0, 1920);
		endScreenSprites[17]= endScreenSheet.grabImage(640, 480, 640 * 1, 1920);
		endScreenSprites[18]= endScreenSheet.grabImage(640, 480, 640 * 2, 1920);
		endScreenSprites[19]= endScreenSheet.grabImage(640, 480, 640 * 3, 1920);
		
		endScreenSprites[20]= endScreenSheet.grabImage(640, 480, 640 * 0, 2400);
		endScreenSprites[21]= endScreenSheet.grabImage(640, 480, 640 * 1, 2400);
		endScreenSprites[22]= endScreenSheet.grabImage(640, 480, 640 * 2, 2400);
		endScreenSprites[23]= endScreenSheet.grabImage(640, 480, 640 * 3, 2400);
		
		endScreenSprites[24]= endScreenSheet.grabImage(640, 480, 640 * 0, 2880);
		endScreenSprites[25]= endScreenSheet.grabImage(640, 480, 640 * 1, 2880);
		endScreenSprites[26]= endScreenSheet.grabImage(640, 480, 640 * 2, 2880);
		endScreenSprites[27]= endScreenSheet.grabImage(640, 480, 640 * 3, 2880);
		
		endScreenSprites[28]= endScreenSheet.grabImage(640, 480, 640 * 0, 3360);
		endScreenSprites[29]= endScreenSheet.grabImage(640, 480, 640 * 1, 3360);
		endScreenSprites[30]= endScreenSheet.grabImage(640, 480, 640 * 2, 3360);
		endScreenSprites[31]= endScreenSheet.grabImage(640, 480, 640 * 3, 3360);
		
		endScreenSprites[32]= endScreenSheet.grabImage(640, 480, 640 * 0, 3840);
		endScreenSprites[33]= endScreenSheet.grabImage(640, 480, 640 * 1, 3840);
		endScreenSprites[34]= endScreenSheet.grabImage(640, 480, 640 * 2, 3840);
		endScreenSprites[35]= endScreenSheet.grabImage(640, 480, 640 * 3, 3840);
		
		endScreenSprites[36]= endScreenSheet.grabImage(640, 480, 640 * 0, 4320);
		endScreenSprites[37]= endScreenSheet.grabImage(640, 480, 640 * 1, 4320);
		endScreenSprites[38]= endScreenSheet.grabImage(640, 480, 640 * 2, 4320);
		endScreenSprites[39]= endScreenSheet.grabImage(640, 480, 640 * 3, 4320);
		
		endScreenSprites[40]= endScreenSheet.grabImage(640, 480, 640 * 0, 4800);
		endScreenSprites[41]= endScreenSheet.grabImage(640, 480, 640 * 1, 4800);
		endScreenSprites[42]= endScreenSheet.grabImage(640, 480, 640 * 2, 4800);
			
			
			
			
		//Red Background For Ken
		endScreenKenSprites[0]= endScreenKenSheet.grabImage(640, 480, 640 *0, 0);
		endScreenKenSprites[1]= endScreenKenSheet.grabImage(640, 480, 640 *1, 0);
		endScreenKenSprites[2]= endScreenKenSheet.grabImage(640, 480, 640 *2, 0);
		endScreenKenSprites[3]= endScreenKenSheet.grabImage(640, 480, 640 *3, 0);
			
		
		endScreenKenSprites[4]= endScreenKenSheet.grabImage(640, 480, 640 * 0, 480);
		endScreenKenSprites[5]= endScreenKenSheet.grabImage(640, 480, 640 * 1, 480);
		endScreenKenSprites[6]= endScreenKenSheet.grabImage(640, 480, 640 * 2, 480);
		endScreenKenSprites[7]= endScreenKenSheet.grabImage(640, 480, 640 * 3, 480);
			
		endScreenKenSprites[8]= endScreenKenSheet.grabImage(640, 480, 640 * 0, 960);
		endScreenKenSprites[9]= endScreenKenSheet.grabImage(640, 480, 640 * 1, 960);
		endScreenKenSprites[10]= endScreenKenSheet.grabImage(640, 480, 640 * 2, 960);
		endScreenKenSprites[11]= endScreenKenSheet.grabImage(640, 480, 640 * 3, 960);
			
		endScreenKenSprites[12]= endScreenKenSheet.grabImage(640, 480, 640 * 0, 1440);
		endScreenKenSprites[13]= endScreenKenSheet.grabImage(640, 480, 640 * 1, 1440);
		endScreenKenSprites[14]= endScreenKenSheet.grabImage(640, 480, 640 * 2, 1440);
		endScreenKenSprites[15]= endScreenKenSheet.grabImage(640, 480, 640 * 3, 1440);
		
		endScreenKenSprites[16]= endScreenKenSheet.grabImage(640, 480, 640 * 0, 1920);
		endScreenKenSprites[17]= endScreenKenSheet.grabImage(640, 480, 640 * 1, 1920);
		endScreenKenSprites[18]= endScreenKenSheet.grabImage(640, 480, 640 * 2, 1920);
		endScreenKenSprites[19]= endScreenKenSheet.grabImage(640, 480, 640 * 3, 1920);
		
		endScreenKenSprites[20]= endScreenKenSheet.grabImage(640, 480, 640 * 0, 2400);
		endScreenKenSprites[21]= endScreenKenSheet.grabImage(640, 480, 640 * 1, 2400);
		endScreenKenSprites[22]= endScreenKenSheet.grabImage(640, 480, 640 * 2, 2400);
		endScreenKenSprites[23]= endScreenKenSheet.grabImage(640, 480, 640 * 3, 2400);
		
		endScreenKenSprites[24]= endScreenKenSheet.grabImage(640, 480, 640 * 0, 2880);
		endScreenKenSprites[25]= endScreenKenSheet.grabImage(640, 480, 640 * 1, 2880);
		endScreenKenSprites[26]= endScreenKenSheet.grabImage(640, 480, 640 * 2, 2880);
		endScreenKenSprites[27]= endScreenKenSheet.grabImage(640, 480, 640 * 3, 2880);
		
		endScreenKenSprites[28]= endScreenKenSheet.grabImage(640, 480, 640 * 0, 3360);
		endScreenKenSprites[29]= endScreenKenSheet.grabImage(640, 480, 640 * 1, 3360);
		endScreenKenSprites[30]= endScreenKenSheet.grabImage(640, 480, 640 * 2, 3360);
		endScreenKenSprites[31]= endScreenKenSheet.grabImage(640, 480, 640 * 3, 3360);
		
		endScreenKenSprites[32]= endScreenKenSheet.grabImage(640, 480, 640 * 0, 3840);
		endScreenKenSprites[33]= endScreenKenSheet.grabImage(640, 480, 640 * 1, 3840);
		endScreenKenSprites[34]= endScreenKenSheet.grabImage(640, 480, 640 * 2, 3840);
		endScreenKenSprites[35]= endScreenKenSheet.grabImage(640, 480, 640 * 3, 3840);
		
		endScreenKenSprites[36]= endScreenKenSheet.grabImage(640, 480, 640 * 0, 4320);
		endScreenKenSprites[37]= endScreenKenSheet.grabImage(640, 480, 640 * 1, 4320);
		endScreenKenSprites[38]= endScreenKenSheet.grabImage(640, 480, 640 * 2, 4320);
		endScreenKenSprites[39]= endScreenKenSheet.grabImage(640, 480, 640 * 3, 4320);
		
		endScreenKenSprites[40]= endScreenKenSheet.grabImage(640, 480, 640 * 0, 4800);
		endScreenKenSprites[41]= endScreenKenSheet.grabImage(640, 480, 640 * 1, 4800);
		endScreenKenSprites[42]= endScreenKenSheet.grabImage(640, 480, 640 * 2, 4800);
		
		
		//Crop Images of Ryu KO animation
		for(int i=0;i<18;i++) {
			KORyuSprites[i]= KORyuSheet.grabImage(200, 121, 200 * i, 0);
		}
		
		//Crop Images of Ken KO animation
		for(int i=0;i<18;i++) {
			KOKenSprites[i]= KOKenSheet.grabImage(250, 151, 250 * i, 0);
		}
		
		
		//========================================PLAYER 1 CUT IMAGES======================================================
		
		//Crop Images of Ryu idle animation
		for(int i=0;i<Player1IdleSprites.length;i++) {
			Player1IdleSprites[i]= Player1IdleSheet.grabImage(57, 106, 57 * i, 0);
		}
		//Crop Images for Ryu Parry Forward Animation
		for(int i=0;i<Player1ParryFSprites.length;i++) {
			Player1ParryFSprites[i]= Player1ParryFSheet.grabImage(70, 110, 70 * i, 0);
		}
		//Crop Images for Ryu Parry Backwards Animation
		for(int i=0;i<Player1ParryBSprites.length;i++) {
			Player1ParryBSprites[i]= Player1ParryBSheet.grabImage(70, 108, 70 * i, 0);
		}
		//Crop Images for Ryu Crouch Animation
		Player1CrouchSprites[0]=Player1CrouchSheet.grabImage(54, 73, 0, 0);
		//Crop Images for Ryu Jump Animation
		for(int i=0;i<3;i++) {
			Player1JumpSprites[i]= Player1JumpSheet.grabImage(70, 154, 0, 0);
		}
		for(int i=3;i<10;i++) {
			Player1JumpSprites[i]= Player1JumpSheet.grabImage(70, 154, 70 * (i - 2), 0);
		}
		//Crop Images for Ryu Front Flip Animation
		for(int i=0;i<8;i++) {
			Player1FFlipSprites[i]= Player1FFlipSheet.grabImage(88, 129, 88 * i, 0);
		}
		//Crop Images for Ryu Back Flip Animation
		for(int i=0;i<8;i++) {
			Player1BFlipSprites[i]= Player1BFlipSheet.grabImage(88, 129, 88 * i, 0);
		}
		//Crop Images for Ryu Quick Punch Animation
		for(int i=0;i<3;i++) {
			Player1QPunchSprites[i]= Player1QPunchSheet.grabImage(94, 102, 94 * i, 0);
		}
		//Crop Images for Ryu Punch Animation
		for(int i=0;i<6;i++) {
			Player1PunchSprites[i]= Player1PunchSheet.grabImage(101, 102, 101 * i, 0);
		}
		//Crop Images for Ryu Upper Kick Animation
		for(int i=0;i<9;i++) {
			Player1UpperKickSprites[i]= Player1UpperKickSheet.grabImage(110, 111, 110 * i, 0);
		}
		//Crop Images for Ryu Low Kick Animation
		for(int i=0;i<5;i++) {
			Player1LowKickSprites[i]= Player1LowKickSheet.grabImage(115, 111, 115 * i, 0);
		}

		//Crop Images for Ryu Hit Animation
		Player1HitSprites[0]= Player1HitSheet.grabImage(62, 103, 0 , 0);
		
		//Crop Images for Ryu Hit Move Right Animation
		for(int i=0;i<Player1HitMoveRSprites.length;i++) {
			Player1HitMoveRSprites[i]= Player1HitMoveRSheet.grabImage(70, 110, 70 * i, 0);
		}
		//Crop Images for Ryu Hit Move Right Animation
		for(int i=0;i<Player1HitMoveLSprites.length;i++) {
			Player1HitMoveLSprites[i]= Player1HitMoveLSheet.grabImage(70, 108, 70 * i, 0);
		}
		//Crop Images for Ryu Air Punch Animation
		for(int i=0;i<6;i++) {
			Player1AirPunchSprites[i]= Player1AirPunchSheet.grabImage(83, 95, 83 * i, 0);
		}
		
		//Crop Images for Ryu Crouch Hit Animation
		Player1HitCrouchSprites[0]= Player1HitCrouchSheet.grabImage(67, 76, 0 , 0);
		
		//Crop Images for Ryu Hit Back Animation
		for(int i=0;i<4;i++) {
			Player1HitBackSprites[i]= Player1HitBackSheet.grabImage(77, 104, 77 * i, 0);
		}
		
		//Crop Images for Ryu Dead Animation
		Player1DeadSprites[0]= Player1DeadSheet.grabImage(116, 46, 0 , 0);
		
		//Crop Images for Ryu Hit Back Animation
		for(int i=0;i<12;i++) {
			Player1KOSprites[i]= Player1KOSheet.grabImage(130, 130, 130 * i, 0);
		}
		
		//========================================PLAYER 2======================================================
		
		//Crop Images for Player 2 Dead animation
		Player2DeadSprites[0]=Player2DeadSheet.grabImage(116, 125, 0, 0);
		
		//Crop Images of Ken idle animation
		for(int i=0;i<Player2IdleSprites.length;i++) {
			Player2IdleSprites[i]= Player2IdleSheet.grabImage(57, 106, 57 * i, 0);
		}
		//Crop Images for Ken Parry Forward Animation
		for(int i=0;i<Player2ParryFSprites.length;i++) {
			Player2ParryFSprites[i]= Player2ParryFSheet.grabImage(70, 110, 70 * i, 0);
		}
		//Crop Images for Ken Parry Forward Animation
		for(int i=0;i<Player2ParryBSprites.length;i++) {
			Player2ParryBSprites[i]= Player2ParryBSheet.grabImage(70, 108, 70 * i, 0);
		}
		//Crop Images for Ken Crouch AnimationIKR
		Player2CrouchSprites[0]=Player2CrouchSheet.grabImage(54, 73, 0, 0);
		//Crop Images for Ken Parry Forward Animation
		for(int i=0;i<3;i++) {
			Player2JumpSprites[i]= Player2JumpSheet.grabImage(61, 123, 0, 0);
		}
		//Crop Images for Ken Parry Forward Animation
		for(int i=3;i<9;i++) {
			Player2JumpSprites[i]= Player2JumpSheet.grabImage(61, 123, 61 * (i - 2), 0);
		}
		//Crop Images for Ken Front Flip Animation
		for(int i=7;i>=0;i--) {
			Player2FFlipSprites[i]= Player2FFlipSheet.grabImage(83, 125, 83 * i, 0);
		}
		//Crop Images for Ken Back Flip Animation
		for(int i=7;i>=0;i--) {
			Player2BFlipSprites[i]= Player2BFlipSheet.grabImage(83, 125, 83 * i, 0);
		}
		//Crop Images for Ken Quick Punch Animation
		for(int i=0;i<4;i++) {
			Player2QPunchSprites[i]= Player2QPunchSheet.grabImage(95, 101, 95 * (i), 0);
		}
		//Crop Images for Ken Punch Animation
		for(int i=0;i<8;i++) {
			Player2PunchSprites[i]= Player2PunchSheet.grabImage(103, 103, 103 * i, 0);
		}
		//Crop Images for Ken Upper kick Animation
		for(int i=0;i<10;i++) {
			Player2UpperKickSprites[i]= Player2UpperKickSheet.grabImage(135, 108, 135 * i, 0);
		}
		//Crop Images for Ken Low Kick Animation
		for(int i=0;i<5;i++) {
			Player2LowKickSprites[i]= Player2LowKickSheet.grabImage(118, 105, 118 * i, 0);
		}
		//Crop Images for Ken Hit Animation

		Player2HitSprites[0]= Player2HitSheet.grabImage(64, 106, 0 , 0);
		
		//Crop Images for Ken Hit (Moving Left) Animation
		for(int i=0;i<Player2HitMoveLSprites.length;i++) {
			Player2HitMoveLSprites[i]= Player2HitMoveLSheet.grabImage(70, 110, 70 * i, 0);
		}
		//Crop Images for Ken Hit (Moving Right) Animation
		for(int i=0;i<Player2HitMoveRSprites.length;i++) {
			Player2HitMoveRSprites[i]= Player2HitMoveRSheet.grabImage(70, 110, 70 * i, 0);
		}
		//Crop Images for Ken KnockBack Animation
		for(int i=0;i<8;i++) {
			Player2KnockoutSprites[i]= Player2KnockoutSheet.grabImage(330,375, 330 * i, 0);
			
		}
		
		//Crop Images for Ken Crouch Hit Animation
		Player2CrouchHitSprites[0]= Player2CrouchHitSheet.grabImage(67, 76, 0 , 0);
		
		//Crop Images for Ken Hit Stand Animation
		for(int i=0;i<4;i++) {
			Player2HitStandSprites[i]= Player2HitStandSheet.grabImage(79, 104, 79 * i, 0);
		}
		
	}
	
}
