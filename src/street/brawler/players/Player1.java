/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Does all the animations and movement for player 1
 */

package street.brawler.players;



import java.awt.Graphics;
import java.util.LinkedList;

import street.brawler.framework.GameObject;
import street.brawler.framework.KeyInputP1;
import street.brawler.framework.KeyInputP2;
import street.brawler.framework.ObjectId;
import street.brawler.framework.Objects;
import street.brawler.framework.Pictures;
import street.brawler.window.AnimationP1;
import street.brawler.window.Game;
import street.brawler.window.Handler;

public class Player1 extends GameObject implements Objects{
	
	//Create variables for width and for height of the player
	private double width = 114, height = 212;
	
	//Create boolean variable for falling
	private boolean falling = true;
	
	//Create variables for gravity
	private double gravity =0.3f;
	private final float MAXSPEED=10;
	
	//Create Handler Object
	private Handler handler;
	
	//Create Collision Object
	Collision collisions;
	
	//Create variables to make sure specific things only run once
	private int num=1;
	private int num1=1;
	
	//Create Object of Picture Class
	Pictures picture= Game.getInstance();
	
	//===========================PLAYER 1 ANIMATION VARIABLES==========================
	private AnimationP1 Player1Idle;
	private AnimationP1 Player1ParryF;
	private AnimationP1 Player1ParryB;
	private AnimationP1 Player1Crouch;
	private AnimationP1 Player1Jump;
	private AnimationP1 Player1FFlip;
	private AnimationP1 Player1BFlip;
	private AnimationP1 Player1Punch;
	private AnimationP1 Player1QPunch;
	private AnimationP1 Player1UpperKick;
	private AnimationP1 Player1LowKick;
	private AnimationP1 Player1Hit;
	private AnimationP1 Player1HitMoveR;
	private AnimationP1 Player1HitMoveL;
	private AnimationP1 Player1AirPunch;
	private AnimationP1 Player1CrouchHit;
	
	
	//Create Object of KeyInputP1 Class
	KeyInputP1 keyInputP1;
	
	
	//Constructor with x,y,handler,keyInputP1,keyInputP2,id
	public Player1(float x, float y,Handler handler, KeyInputP1 keyInputP1,KeyInputP2 keyInputP2, ObjectId id) {
		//Call Super Class Constructor
		super(x, y, id);
		
		//Set Objects Accordingly
		this.keyInputP1=keyInputP1;
		this.handler = handler;
		
		//Instantiate Collision Object
		collisions = new Collision(handler,keyInputP1,keyInputP2);
		
		//Instantiate All Animations for PLAYER 1
		Player1Idle = new AnimationP1(5,keyInputP1, picture.Player1IdleSprites[0],picture.Player1IdleSprites[1],picture.Player1IdleSprites[2],picture.Player1IdleSprites[3],picture.Player1IdleSprites[4],picture.Player1IdleSprites[5]);
		Player1ParryF = new AnimationP1(3,keyInputP1, picture.Player1ParryFSprites[0],picture.Player1ParryFSprites[1],picture.Player1ParryFSprites[2],picture.Player1ParryFSprites[3],picture.Player1ParryFSprites[4],picture.Player1ParryFSprites[5],picture.Player1ParryFSprites[6],picture.Player1ParryFSprites[7]);
		Player1ParryB = new AnimationP1(3, keyInputP1,picture.Player1ParryBSprites[0],picture.Player1ParryBSprites[1],picture.Player1ParryBSprites[2],picture.Player1ParryBSprites[3],picture.Player1ParryBSprites[4],picture.Player1ParryBSprites[5],picture.Player1ParryBSprites[6],picture.Player1ParryBSprites[7]);
		Player1Crouch = new AnimationP1(5,keyInputP1, picture.Player1CrouchSprites[0]);
		Player1Jump = new AnimationP1(5, keyInputP1,picture.Player1JumpSprites[0], picture.Player1JumpSprites[1], picture.Player1JumpSprites[2], picture.Player1JumpSprites[3], picture.Player1JumpSprites[4], picture.Player1JumpSprites[5], picture.Player1JumpSprites[6], picture.Player1JumpSprites[7], picture.Player1JumpSprites[8], picture.Player1JumpSprites[9]);
		Player1FFlip = new AnimationP1(7,keyInputP1, picture.Player1FFlipSprites[0],picture.Player1FFlipSprites[1],picture.Player1FFlipSprites[2],picture.Player1FFlipSprites[3],picture.Player1FFlipSprites[4],picture.Player1FFlipSprites[5],picture.Player1FFlipSprites[6],picture.Player1FFlipSprites[7]);
		Player1BFlip = new AnimationP1(7, keyInputP1,picture.Player1BFlipSprites[0],picture.Player1BFlipSprites[1],picture.Player1BFlipSprites[2],picture.Player1BFlipSprites[3],picture.Player1BFlipSprites[4],picture.Player1BFlipSprites[5],picture.Player1BFlipSprites[6],picture.Player1BFlipSprites[7]);
		Player1QPunch = new AnimationP1(3,keyInputP1,picture.Player1QPunchSprites[0],picture.Player1QPunchSprites[1],picture.Player1QPunchSprites[2]);
		Player1Punch = new AnimationP1(3, keyInputP1,picture.Player1PunchSprites[0],picture.Player1PunchSprites[1],picture.Player1PunchSprites[2],picture.Player1PunchSprites[3],picture.Player1PunchSprites[4]);
		Player1UpperKick = new AnimationP1(2,keyInputP1, picture.Player1UpperKickSprites[0],picture.Player1UpperKickSprites[1],picture.Player1UpperKickSprites[2],picture.Player1UpperKickSprites[3],picture.Player1UpperKickSprites[4],picture.Player1UpperKickSprites[5],picture.Player1UpperKickSprites[6],picture.Player1UpperKickSprites[7],picture.Player1UpperKickSprites[8]);
		Player1LowKick = new AnimationP1(4,keyInputP1, picture.Player1LowKickSprites[0],picture.Player1LowKickSprites[1],picture.Player1LowKickSprites[2],picture.Player1LowKickSprites[3],picture.Player1LowKickSprites[4]);
		Player1Hit = new AnimationP1(6, keyInputP1,picture.Player1HitSprites[0]);
		Player1HitMoveL = new AnimationP1(3, keyInputP1,picture.Player1HitMoveLSprites[0],picture.Player1HitMoveLSprites[1],picture.Player1HitMoveLSprites[2],picture.Player1HitMoveLSprites[3],picture.Player1HitMoveLSprites[4],picture.Player1HitMoveLSprites[5],picture.Player1HitMoveLSprites[6],picture.Player1HitMoveLSprites[7]);
		Player1HitMoveR = new AnimationP1(3, keyInputP1,picture.Player1HitMoveRSprites[0],picture.Player1HitMoveRSprites[1],picture.Player1HitMoveRSprites[2],picture.Player1HitMoveRSprites[3],picture.Player1HitMoveRSprites[4],picture.Player1HitMoveRSprites[5],picture.Player1HitMoveRSprites[6],picture.Player1HitMoveRSprites[7]);
		Player1AirPunch = new AnimationP1(3, keyInputP1,picture.Player1AirPunchSprites[0],picture.Player1AirPunchSprites[1],picture.Player1AirPunchSprites[2],picture.Player1AirPunchSprites[3],picture.Player1AirPunchSprites[4],picture.Player1AirPunchSprites[5]);
		Player1CrouchHit = new AnimationP1(6,keyInputP1, picture.Player1HitCrouchSprites[0]);

	
		
		

	
	}
	
	//Tick method to update all variables
	public void tick(LinkedList<GameObject> object) {
		
		
		//Call Collsions Tick Method
		collisions.tick(object);
		
		//Add the velX to the x position of player
		x+=velX;
		//Add the velY to the y position of player
		y+=velY;
		
		
		//Check if player is falling or jumping
		if((falling||jumping)) {
			velY+=gravity;
			if(velY>MAXSPEED) {
				velY=MAXSPEED;
			}
		}
			
		
		//Check if player is outside of bounds and set movement to zero
		if(x<=0) {
			x=0;
		}
		else if(x>=640-114) {
			x=640-114;
		}
		//Check if user if outbounds when not crouching
		if(keyInputP1.isCrouch1()==false) {
			if(y<=0) {
				y=0;
			}
			else if(y>450-106) {
				y=450-106;
			}
		}
		//Check if user is out of bounds when crouching
		else if(keyInputP1.isCrouch1()==true) {
			if(y<=0) {
				y=0;
			}
			else if(y>450-106) {
				y=490-106;
			}
		}
		
		
		
		//Call Player1RunAnimation Method to run the animations
		Player1RunAnimation();
	}

	
	//Render method that renders all graphics for player 1
	public void render(Graphics g,LinkedList<GameObject> object) {
		//Call Collision Render method
		collisions.render(g,object);
		//Call Player1DrawAnimation to draw all animations for Player 1
		Player1DrawAnimation(g);
				
				
	}

	//Player 1 Animation Method
	private void Player1RunAnimation() {
		//Run the animations to safeguard from any bugs
		if(num1<60) {
			Player1Idle.runAnimation();
			Player1ParryF.runAnimation();
			Player1ParryB.runAnimation();
			Player1Crouch.runAnimation();
			Player1Jump.runAnimation();
			Player1FFlip.runAnimation();
			Player1BFlip.runAnimation();
			Player1Hit.runAnimation();
			Player1HitMoveR.runAnimation();
			Player1HitMoveL.runAnimation();
			Player1AirPunch.runAnimation();
			num1++;
		}
		
		//Initilize each action animation once
		if(num==1) {
			Player1Punch.runAnimation();		
			num++;
		}
		else if(num==2) {
			Player1QPunch.runAnimation();
			num++;
		}
		else if(num==3) {
			Player1UpperKick.runAnimation();
			num++;
		}
		else if(num==4) {
			Player1LowKick.runAnimation();
			num++;
		}
				
		//Check if Player 1 is jumping		
		if(Collision.player1Hit==true&&velX==0&&y!=344&&keyInputP1.isCrouch1()==false) {
			//Run Jump Animation
			Player1Jump.runAnimation();
		}
		//Check if Player 1 is performing front flip	
		else if(Collision.player1Hit==true&&velX>0&&y!=344&&keyInputP1.isCrouch1()==false) {
			//Run Front Flip Animation
			Player1FFlip.runAnimation();
		}
		//Check if Player 1 is performing Back flip	
		else if(Collision.player1Hit==true&&velX<0&&y!=344&&keyInputP1.isCrouch1()==false) {
			//Run Front Flip Animation
			Player1BFlip.runAnimation();
		}
		//Check if Player 1 is getting hit
		if(Collision.player1Hit==true&&velX==0&&y==344) {
			//Run Hit Animation
			Player1Hit.runAnimation();
		}
		//Check if Player 1 is getting hit while moving left
		else if(Collision.player1Hit==true&&velX>0&&y==344) {
			//Run Hit Move Left Animation
			Player1HitMoveL.runAnimation();
		}
		//Check if Player 1 is getting hit while moving Right
		else if(Collision.player1Hit==true&&velX<0&&y==344) {
			//Run Hit Move Right Animation
			Player1HitMoveR.runAnimation();
		}
		//Check if Player 1 is getting hit while crouching
		else if(Collision.player1Hit==true&&velX==0&&keyInputP1.isCrouch1()==true) {
			//Run Crouch Hit Animation
			Player1CrouchHit.runAnimation();
		}
		
		//Check if no fighting actions are being performed and if player is not being hit
		if(keyInputP1.isAction1()==false&&Collision.player1Hit==false) {
			//Idle Animation
			if(velX==0&&keyInputP1.isCrouch1()==false&&y==344) {
				Player1Idle.runAnimation();
			}
			//Moving Right Animation
			if(velX>0&&keyInputP1.isCrouch1()==false&&y==344) {
				Player1ParryF.runAnimation();
			}
			//Moving Left Animation
			if(velX<0&&keyInputP1.isCrouch1()==false&&y==344) {
				Player1ParryB.runAnimation();
			}
			//Crouch Animation
			if(keyInputP1.isCrouch1()==true&&velX==0) {
				Player1Crouch.runAnimation();
			}
			//Jump Straight Animation
			if(velX==0&&y!=344&&keyInputP1.isCrouch1()==false) {
				Player1Jump.runAnimation();
			}	
			//Front Flip Animation
			if(velX>0&&y!=344&&keyInputP1.isCrouch1()==false) {
				Player1FFlip.runAnimation();
			}	
			//Back Flip Animation
			if(velX<0&&y!=344&&keyInputP1.isCrouch1()==false) {
				Player1BFlip.runAnimation();
			}
		}
		
		//Check if fighting actions are being performed and if player is not being hit
		else if(keyInputP1.isAction1()==true&&Collision.player1Hit==false) {
			//Quick Punch Animation
			if(y==344&&keyInputP1.isQuickPunch1()==true&&keyInputP1.isCrouch1()==false) {
				Player1QPunch.runAnimation();
				velX=0;
						
			}
			//Punch Animation
			if(y==344&&keyInputP1.isHardPunch1()==true&&keyInputP1.isCrouch1()==false) {
				Player1Punch.runAnimation();
				velX=0;
						
			}
			//Kick Animation
			if(y==344&&keyInputP1.isKick1()==true&&keyInputP1.isCrouch1()==false) {
				Player1UpperKick.runAnimation();
				velX=0;
			}
			//Lower Kick Animation
			if(y==344&&keyInputP1.isLowKick1()==true&&keyInputP1.isCrouch1()==false) {
				Player1LowKick.runAnimation();
				velX=0;
			}
			
					
		}
	}
	
	//This method draws all the animations
	private void Player1DrawAnimation(Graphics g) {
		//Draw the animations atleast once to safeguard from bugs
		if(num==1) {
			Player1Punch.drawAnimation(g, (int)x-300, (int)y,202,204);		
			
		}
		else if(num==2) {
			Player1QPunch.drawAnimation(g, (int)x-300, (int)y,188,204);		
		
		}
		else if(num==3) {
			Player1UpperKick.drawAnimation(g, (int)x-300, (int)y,220,222);
			
		}
		else if(num==4) {
			Player1LowKick.drawAnimation(g, (int)x-300, (int)y,230,222);
			
		}
				
		//==================================Animations======================================
		
		//Draw Jump Animation
		if(Collision.player1Hit==true&&velX==0&&y!=344&&keyInputP1.isCrouch1()==false) {
			Player1Jump.drawAnimation(g, (int)x, (int)y,140,308);
		}
		//Draw Front Flip Animation
		else if(Collision.player1Hit==true&&velX>0&&y!=344&&keyInputP1.isCrouch1()==false) {
			Player1FFlip.drawAnimation(g, (int)x, (int)y,176,258);
		}
		//Draw Back Flip Animation
		else if(Collision.player1Hit==true&&velX<0&&y!=344&&keyInputP1.isCrouch1()==false) {
			Player1BFlip.drawAnimation(g, (int)x, (int)y,176,258);
		}
		//Draw Hit Animation
		if(Collision.player1Hit==true&&velX==0&&y==344) {
			Player1Hit.drawAnimation(g, (int)x, (int)y,124,206);
		}
		//Draw Hit Move Left Animation
		else if(Collision.player1Hit==true&&velX>0&&y==344) {
			Player1HitMoveL.drawAnimation(g, (int)x, (int)y, 140,220);
		}
		//Draw Hit Move Right Animation
		else if(Collision.player1Hit==true&&velX<0&&y==344) {
			Player1HitMoveR.drawAnimation(g, (int)x, (int)y, 140,220);
		}
		//Draw Crouch Hit Animation
		else if(Collision.player1Hit==true&&velX==0&&keyInputP1.isCrouch1()==true) {
			Player1CrouchHit.drawAnimation(g, (int)x, (int)y+30, 134,156);
		}
		
		//Check if no fighting action is being performed and player is not being hit
		if(keyInputP1.isAction1()==false&&Collision.player1Hit==false) {
			//Idle Animation
			if(velX==0&&keyInputP1.isCrouch1()==false&&y==344) {
				Player1Idle.drawAnimation(g, (int)x, (int)y, 114,212);
			}
			//Moving Right Animation
			if(velX>0&&keyInputP1.isCrouch1()==false&&y==344) {
				Player1ParryF.drawAnimation(g, (int)x, (int)y, 140,220);
			}
			//Moving Left Animation
			if(velX<0&&keyInputP1.isCrouch1()==false&&y==344) {
				Player1ParryB.drawAnimation(g, (int)x, (int)y, 140, 216);
			}
			//Crouch Animation
			if(keyInputP1.isCrouch1()==true&&velX==0) {
				Player1Crouch.drawAnimation(g, (int)x, (int)y+40, 108, 146);
			}
			//Jump Straight Animation
			if(velX==0&&y!=344&&keyInputP1.isCrouch1()==false) {
				Player1Jump.drawAnimation(g, (int)x, (int)y,140,308);
			}	
			//Front Flip Animation
			if(velX>0&&y!=344&&keyInputP1.isCrouch1()==false) {
				Player1FFlip.drawAnimation(g, (int)x, (int)y,176,258);
			}	
			//Back Flip Animation
			if(velX<0&&y!=344&&keyInputP1.isCrouch1()==false) {
				Player1BFlip.drawAnimation(g, (int)x, (int)y,176,258);
			}
			
		}
		//Check if  fighting action is being performed and player is not being hit	
		else if(keyInputP1.isAction1()==true&&Collision.player1Hit==false) {
			//Quick Punch Animation
			if(y==344&&keyInputP1.isQuickPunch1()==true&&keyInputP1.isCrouch1()==false) {
				Player1QPunch.drawAnimation(g, (int)x, (int)y,188,204);		
			}
			//Punch Animation
			if(y==344&&keyInputP1.isHardPunch1()==true&&keyInputP1.isCrouch1()==false) {
				Player1Punch.drawAnimation(g, (int)x, (int)y,202,204);		
			}
			//Upper Kick Animation
			if(y==344&&keyInputP1.isKick1()==true&&keyInputP1.isCrouch1()==false) {
				Player1UpperKick.drawAnimation(g, (int)x, (int)y,220,222);
			}
			//Lower Kick Animation
			if(y==344&&keyInputP1.isLowKick1()==true&&keyInputP1.isCrouch1()==false) {
				Player1LowKick.drawAnimation(g, (int)x, (int)y,230,222);
			}
			
		}
	}

	
	//Method to get the id of the object
	public ObjectId getId() {
		return id;
	}


	
	

}
