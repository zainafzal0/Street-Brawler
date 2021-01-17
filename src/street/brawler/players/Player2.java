/*
 * Name: Zain Afzal
 * Date: 1/14/2020
 * Purpose: Does all the animations and movement for player 2
 */
package street.brawler.players;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import street.brawler.framework.GameObject;
import street.brawler.framework.KeyInputP1;
import street.brawler.framework.Pictures;
import street.brawler.framework.KeyInputP2;
import street.brawler.framework.ObjectId;
import street.brawler.framework.Objects;
import street.brawler.window.AnimationP1;
import street.brawler.window.AnimationP2;
import street.brawler.window.Game;
import street.brawler.window.Handler;

public class Player2 extends GameObject implements Objects{
	

	//Create variable for player width and height
	private double width = 114, height = 212;
	
	//Create boolean for falling
	private boolean falling = true;
	
	//Create variables for gravity
	private double gravity =0.3;
	private final float MAXSPEED=10;
	
	//Create Object for handler
	private Handler handler;
	
	//Create object of picture class
	Pictures picture= Game.getInstance();
	
	
	//Create variables to make sure specific things only run once
	private int num1=1;
	private int num2=1;
	
	
	//===========================PLAYER 2 ANIMATION VARIABLES==========================
	private AnimationP2 Player2Idle;
	private AnimationP2 Player2ParryF;
	private AnimationP2 Player2ParryB;
	private AnimationP2 Player2Crouch;
	private AnimationP2 Player2Jump;
	private AnimationP2 Player2FFlip;
	private AnimationP2 Player2BFlip;
	private AnimationP2 Player2Punch;
	private AnimationP2 Player2QPunch;
	private AnimationP2 Player2UpperKick;
	private AnimationP2 Player2LowKick;
	private AnimationP2 Player2Hit;
	private AnimationP2 Player2HitMoveL;
	private AnimationP2 Player2HitMoveR;
	private AnimationP2 Player2CrouchHit;

	
	//Create Object of keyInputP2 class
	KeyInputP2 keyInputP2;

	//Constructor with parameters of x,y,handler,keyInputP2, and object Id
	public Player2(float x, float y,Handler handler,KeyInputP2 keyInputP2, ObjectId id) {
		//Call Super Class Constructor
		super(x, y, id);
		
		//Set Objects Accordingly
		this.handler = handler;
		this.keyInputP2=keyInputP2;
		
		
		//Instantiate All Animations for PLAYER 2
		Player2Idle = new AnimationP2(11, keyInputP2, picture.Player2IdleSprites[5],picture.Player2IdleSprites[4],picture.Player2IdleSprites[3],picture.Player2IdleSprites[2],picture.Player2IdleSprites[1],picture.Player2IdleSprites[0]);
		Player2ParryF = new AnimationP2(8,keyInputP2, picture.Player2ParryFSprites[0],picture.Player2ParryFSprites[1],picture.Player2ParryFSprites[2],picture.Player2ParryFSprites[3],picture.Player2ParryFSprites[4],picture.Player2ParryFSprites[5],picture.Player2ParryFSprites[6],picture.Player2ParryFSprites[7]);
		Player2ParryB = new AnimationP2(8, keyInputP2,picture.Player2ParryBSprites[0],picture.Player2ParryBSprites[1],picture.Player2ParryBSprites[2],picture.Player2ParryBSprites[3],picture.Player2ParryBSprites[4],picture.Player2ParryBSprites[5],picture.Player2ParryBSprites[6],picture.Player2ParryBSprites[7]);
		Player2Crouch = new AnimationP2(8,keyInputP2, picture.Player2CrouchSprites[0]);
		Player2Jump = new AnimationP2(8, keyInputP2,picture.Player2JumpSprites[8], picture.Player2JumpSprites[7], picture.Player2JumpSprites[6], picture.Player2JumpSprites[5], picture.Player2JumpSprites[4], picture.Player2JumpSprites[3], picture.Player2JumpSprites[2], picture.Player2JumpSprites[1], picture.Player2JumpSprites[0]);
		Player2FFlip = new AnimationP2(14, keyInputP2,picture.Player2FFlipSprites[0],picture.Player2FFlipSprites[1],picture.Player2FFlipSprites[2],picture.Player2FFlipSprites[3],picture.Player2FFlipSprites[4],picture.Player2FFlipSprites[5],picture.Player2FFlipSprites[6],picture.Player2FFlipSprites[7]);
		Player2BFlip = new AnimationP2(14, keyInputP2,picture.Player2BFlipSprites[0],picture.Player2BFlipSprites[1],picture.Player2BFlipSprites[2],picture.Player2BFlipSprites[3],picture.Player2BFlipSprites[4],picture.Player2BFlipSprites[5],picture.Player2BFlipSprites[6],picture.Player2BFlipSprites[7]);
		Player2QPunch = new AnimationP2(6,keyInputP2, picture.Player2QPunchSprites[3],picture.Player2QPunchSprites[2],picture.Player2QPunchSprites[1],picture.Player2QPunchSprites[0]);
		Player2Punch = new AnimationP2(6, keyInputP2,picture.Player2PunchSprites[7],picture.Player2PunchSprites[6],picture.Player2PunchSprites[5],picture.Player2PunchSprites[4],picture.Player2PunchSprites[3],picture.Player2PunchSprites[2],picture.Player2PunchSprites[6],picture.Player2PunchSprites[1]);
		Player2UpperKick = new AnimationP2(6, keyInputP2,picture.Player2UpperKickSprites[8],picture.Player2UpperKickSprites[7],picture.Player2UpperKickSprites[6],picture.Player2UpperKickSprites[5],picture.Player2UpperKickSprites[4],picture.Player2UpperKickSprites[3],picture.Player2UpperKickSprites[2],picture.Player2UpperKickSprites[1],picture.Player2UpperKickSprites[0]);
		Player2LowKick = new AnimationP2(10, keyInputP2,picture.Player2LowKickSprites[4],picture.Player2LowKickSprites[3],picture.Player2LowKickSprites[2],picture.Player2LowKickSprites[1],picture.Player2LowKickSprites[0]);
		Player2Hit = new AnimationP2(12, keyInputP2,picture.Player2HitSprites[0]);
		Player2HitMoveL = new AnimationP2(8, keyInputP2,picture.Player2HitMoveLSprites[7],picture.Player2HitMoveLSprites[6],picture.Player2HitMoveLSprites[5],picture.Player2HitMoveLSprites[4],picture.Player2HitMoveLSprites[3],picture.Player2HitMoveLSprites[2],picture.Player2HitMoveLSprites[1],picture.Player2HitMoveLSprites[0]);
		Player2HitMoveR = new AnimationP2(8, keyInputP2,picture.Player2HitMoveRSprites[7],picture.Player2HitMoveRSprites[6],picture.Player2HitMoveRSprites[5],picture.Player2HitMoveRSprites[4],picture.Player2HitMoveRSprites[3],picture.Player2HitMoveRSprites[2],picture.Player2HitMoveRSprites[1],picture.Player2HitMoveRSprites[0]);
		Player2CrouchHit = new AnimationP2(8,keyInputP2, picture.Player2CrouchHitSprites[0]);

	}

	//Tick Method to update all variables
	public void tick(LinkedList<GameObject> object) {
		
		//Add the velX to the x position of player
		x+=velX;
		//Add the velY to the y position of player
		y+=velY;
		
		
		//Check if player is falling jumping
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
		if(keyInputP2.isCrouch2()==false) {
			if(y<=0) {
				y=0;
			}
			else if(y>450-106) {
				y=450-106;
			}
		}
		//Check if user is out of bounds when crouching
		else if(keyInputP2.isCrouch2()==true) {
			if(y<=0) {
				y=0;
			}
			else if(y>450-106) {
				y=490-106;
			}
		}
		
		
		
		//==================================Animations======================================
		
		
		for(int i=0;i<handler.object.size();i++) {
				//Calls Player2RunAnimation Method to run animations
				Player2RunAnimation();
			
			
		}
		
	}


	//Render Method to Render all graphics
	public void render(Graphics g, LinkedList<GameObject> object) {
		//Calls Player2DrawAnimation Method
		Player2DrawAnimation(g);
			
				
		
	}

	
	//Run Animation method
	private void Player2RunAnimation() {
		//Runs the animations a few times to safeguard from bugs
		if(num1<60) {
			Player2Idle.runAnimation();
			Player2ParryF.runAnimation();
			Player2ParryB.runAnimation();
			Player2Crouch.runAnimation();
			Player2Jump.runAnimation();
			Player2FFlip.runAnimation();
			Player2BFlip.runAnimation();
			Player2Hit.runAnimation();
			Player2HitMoveL.runAnimation();
			Player2HitMoveR.runAnimation();
			Player2CrouchHit.runAnimation();
			num1++;
		}
		
		//Runs the fighting animations a few times to safeguard from bugs
		if(num1==1) {
			Player2Punch.runAnimation();		
			num1++;
		}
		else if(num1==2) {
			Player2QPunch.runAnimation();
			num1++;
		}
		else if(num1==3) {
			Player2UpperKick.runAnimation();
			num1++;
		}
		else if(num1==4) {
			Player2LowKick.runAnimation();
			num1++;
		}
		
		//Jump Animation
		if(Collision.player2Hit==true&&velX==0&&y!=344&&keyInputP2.isCrouch2()==false) {
			Player2Jump.runAnimation();
		}
		//Front Flip Animation
		else if(Collision.player2Hit==true&&velX>0&&y!=344&&keyInputP2.isCrouch2()==false) {
			Player2FFlip.runAnimation();
		}
		//Back Flip Animation
		else if(Collision.player2Hit==true&&velX<0&&y!=344&&keyInputP2.isCrouch2()==false) {
			Player2BFlip.runAnimation();
		}
		//Hit Animation
		if(Collision.player2Hit==true&&velX==0) {
			Player2Hit.runAnimation();
		}
		//Hit Move Left Animation
		else if(Collision.player2Hit==true&&velX>0) {
			Player2HitMoveL.runAnimation();
		}
		//Hit Move Right Animation
		else if(Collision.player2Hit==true&&velX<0) {
			Player2HitMoveR.runAnimation();
		}
		//Crouch Hit  Animation
		else if(Collision.player2Hit==true&&velX==0&&keyInputP2.isCrouch2()==true) {
			Player2CrouchHit.runAnimation();
		}
		
		//Checks if no fighting action is being performed and if player is not being hit
		if(keyInputP2.isAction2()==false&&Collision.player2Hit==false) {
			//Idle Animation
			if(velX==0&&keyInputP2.isCrouch2()==false&&y==344) {
				Player2Idle.runAnimation();
			}
			//Moving Right Animation
			if(velX>0&&keyInputP2.isCrouch2()==false&&y==344) {
				Player2ParryF.runAnimation();
			}
			//Moving Left Animation
			if(velX<0&&keyInputP2.isCrouch2()==false&&y==344) {
				Player2ParryB.runAnimation();
			}
			//Crouch Animation
			if(keyInputP2.isCrouch2()==true&&velX==0) {
				Player2Crouch.runAnimation();
			}
			//Jump Straight Animation
			if(velX==0&&y!=344&&keyInputP2.isCrouch2()==false) {
				Player2Jump.runAnimation();
			}	
			//Front Flip Animation
			if(velX>0&&y!=344&&keyInputP2.isCrouch2()==false) {
				Player2FFlip.runAnimation();
			}	
			//Back Flip Animation
			if(velX<0&&y!=344&&keyInputP2.isCrouch2()==false) {
				Player2BFlip.runAnimation();
			}
		}
		
		//Checks if fighting action is being performed and if player is not being hit
		else if(keyInputP2.isAction2()==true&&Collision.player2Hit==false) {
			//Quick Punch Animation
			if(y==344&&keyInputP2.isQuickPunch2()==true&&keyInputP2.isCrouch2()==false) {
				Player2QPunch.runAnimation();
				velX=0;
				
			}
			//Punch Animation
			if(y==344&&keyInputP2.isHardPunch2()==true&&keyInputP2.isCrouch2()==false) {
				Player2Punch.runAnimation();
				velX=0;
				
			}
			//Upper Kick Animation
			if(y==344&&keyInputP2.isKick2()==true&&keyInputP2.isCrouch2()==false) {
				Player2UpperKick.runAnimation();
				velX=0;
			}
			//Low Kick Animation
			if(y==344&&keyInputP2.isLowKick2()==true&&keyInputP2.isCrouch2()==false) {
				Player2LowKick.runAnimation();
				velX=0;
			}
		}
	}
	
	
	//Draw Animation Method
	private void Player2DrawAnimation(Graphics g) {
		
		
		//Draws the Fighting actions once at first to safeguard from bugs
		if(num1==1) {
			Player2Punch.drawAnimation(g, (int)x, (int)y,202,204);		
			
		}
		else if(num1==2) {
			Player2QPunch.drawAnimation(g, (int)x, (int)y,188,204);		
			
		}
		else if(num1==3) {
			Player2UpperKick.drawAnimation(g, (int)x, (int)y,220,222);
			
		}
		else if(num1==4) {
			Player2LowKick.drawAnimation(g, (int)x, (int)y,230,222);
			
		}
		
		
		//Draw Jump Animation
		if(Collision.player2Hit==true&&velX==0&&y!=344&&keyInputP2.isCrouch2()==false) {
			Player2Jump.drawAnimation(g, (int)x, (int)y,122,246);
		}
		//Draw Front Flip Animation
		else if(Collision.player2Hit==true&&velX>0&&y!=344&&keyInputP2.isCrouch2()==false) {
			Player2FFlip.drawAnimation(g, (int)x, (int)y,176,258);
		}
		//Draw Back Flip Animation
		else if(Collision.player2Hit==true&&velX<0&&y!=344&&keyInputP2.isCrouch2()==false) {
			Player2BFlip.drawAnimation(g, (int)x, (int)y,176,258);
		}

		//Draw Hit Animation
		if(Collision.player2Hit==true&&velX==0&&y==344) {
			Player2Hit.drawAnimation(g, (int)x, (int)y,128,212);;
		}
		
		//Draw Hit Move Left Animation
		else if(Collision.player2Hit==true&&velX>0&&y==344) {
			Player2HitMoveL.drawAnimation(g, (int)x, (int)y, 140,220);
		}
		//Draw Hit Move Right Animation
		else if(Collision.player2Hit==true&&velX<0&&y==344) {
			Player2HitMoveR.drawAnimation(g, (int)x, (int)y, 140,220);
		}
		//Draw Crouch Hit Animation
		else if(Collision.player2Hit==true&&velX==0&&keyInputP2.isCrouch2()==true) {
			Player2CrouchHit.drawAnimation(g, (int)x, (int)y+30, 134,156);
		}
		
		//==================================Animations======================================
		//Checks if no fighting action is being performed and if player is not being hit
		if(keyInputP2.isAction2()==false&&Collision.player2Hit==false) {
			//Idle Animation
			if(velX==0&&keyInputP2.isCrouch2()==false&&y==344) {
				Player2Idle.drawAnimation(g, (int)x, (int)y, 114,212);
			}
			//Moving Right Animation
			if(velX>0&&keyInputP2.isCrouch2()==false&&y==344) {
				Player2ParryF.drawAnimation(g, (int)x, (int)y, 140,220);
			}
			//Moving Left Animation
			if(velX<0&&keyInputP2.isCrouch2()==false&&y==344) {
				Player2ParryB.drawAnimation(g, (int)x, (int)y, 140, 216);
			}
			//Crouch Animation
			if(keyInputP2.isCrouch2()==true&&velX==0) {
				Player2Crouch.drawAnimation(g, (int)x, (int)y+40, 108, 146);
			}
			//Jump Straight Animation
			if(velX==0&&y!=344&&keyInputP2.isCrouch2()==false) {
				Player2Jump.drawAnimation(g, (int)x, (int)y,122,246);
			}	
			//Front Flip Animation
			if(velX>0&&y!=344&&keyInputP2.isCrouch2()==false) {
				Player2FFlip.drawAnimation(g, (int)x, (int)y,176,258);
			}	
			//Back Flip Animation
			if(velX<0&&y!=344&&keyInputP2.isCrouch2()==false) {
				Player2BFlip.drawAnimation(g, (int)x, (int)y,176,258);
			}
		}
		//Checks if fighting action is being performed and if player is not being hit
		else if(keyInputP2.isAction2()==true&&Collision.player2Hit==false) {
			//Quick Punch Animation
			if(y==344&&keyInputP2.isQuickPunch2()==true&&keyInputP2.isCrouch2()==false) {
				Player2QPunch.drawAnimation(g, (int)x-65, (int)y,190,202);		
			}
			//Punch Animation
			if(y==344&&keyInputP2.isHardPunch2()==true&&keyInputP2.isCrouch2()==false) {
				Player2Punch.drawAnimation(g, (int)x-85, (int)y,202,204);		
			}
			//Upper Kick Animation
			if(y==344&&keyInputP2.isKick2()==true&&keyInputP2.isCrouch2()==false) {
				Player2UpperKick.drawAnimation(g, (int)x-140, (int)y,270,216);
			}
			//Low Kick Animation
			if(y==344&&keyInputP2.isLowKick2()==true&&keyInputP2.isCrouch2()==false) {
				Player2LowKick.drawAnimation(g, (int)x-85, (int)y,236,210);
			}
		}
	}

	
	


	//Method to get the object id
	public ObjectId getId() {
		return id;
	}

	
	
	
	
}
