package States;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import Game.Game;
import Game.PocketHandler;
import Graphics.Animation;
import Graphics.Assets;
import Graphics.ImageLoader;
import UI.Button;
import UI.ClickListener;
import UI.UIManager;

public class AttackState extends State{
	
	private Animation team, opponent;
	private UIManager uiManager;
	private int tHealth, oHealth;
	private boolean hurt,battle,count=false;
	private boolean attacking=true;
	private int index;
	private long lastTime, timer;
	
	public AttackState(PocketHandler handler){
		super(handler);
		tHealth=273;
		oHealth=273;
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		//Adding button
		uiManager.addObject(new Button(5,5,252,46,Assets.fireBlast,new ClickListener() {

			@Override
			public void onCLick() {
				if(attacking) {
				attacking=false;
				oHealth=oHealth-(int)((Math.random()*((150-0)+1))+0);
				}
			}}));
		uiManager.addObject(new Button(5,56,252,46,Assets.fireFang,new ClickListener() {

			@Override
			public void onCLick() {
				if(attacking) {
					attacking=false;
					oHealth=oHealth-(int)((Math.random()*((60-40)+1))+40);
					}
				}}));
		uiManager.addObject(new Button(5,107,252,46,Assets.fly,new ClickListener() {

			@Override
			public void onCLick() {
				if(attacking) {
					attacking=false;
					oHealth=oHealth-50;
					}
				}}));
		uiManager.addObject(new Button(5,158,252,46,Assets.dragonClaw,new ClickListener() {

			@Override
			public void onCLick() {
				if(attacking) {
					attacking=false;
					oHealth=oHealth-(int)((Math.random()*((25-100)+1))+25);
					}
				}}));
		uiManager.addObject(new Button(5,209,252,46,Assets.heal,new ClickListener() {

			@Override
			public void onCLick() {
				if(attacking) {
					attacking=false;
					oHealth=oHealth+50;
					}
				}}));
		team= new Animation(1500,Assets.team);
		opponent= new Animation(2500,Assets.opponent);

	}

	@Override
	public void tick() {
		team.tick();
		opponent.tick();
		//timer
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		if(!attacking) {
			if(timer > 500) {
				index++;
				timer=0;
				if (index >= 8) {
					battle=true;
				}
			}
			if(battle) {
				hurt=true;
				tHealth=tHealth-(int)((Math.random()*((150-25)+1))+25);	
				battle=false;
				index=0;
			}

		}
		
		if(hurt) {
			if(timer > 500) {
				index++;
				timer=0;
				if (index >= 8) {
					count=true;
				}
			}
			if(count) {
				hurt=false;
				count=false;
				index=0;
			}

		}
		
		if(oHealth<=0) {
			State.setState(handler.getGame().winningState);
		}
		else if(oHealth<=0) {
			State.setState(handler.getGame().losingState);

		}
	}


	@Override
	public void render(Graphics graphics) {
		graphics.drawImage(Assets.battle,0,0,null);
		uiManager.render(graphics);
		graphics.drawImage(getTeamAnimationFrame(), 100, 243,240, 237,null);
		graphics.drawImage(getOpponentAnimationFrame(), 320, 80,200, 192,null);
		graphics.setColor(Color.green);
		graphics.fillRect(534, 48, (int)oHealth/3, 8);
		graphics.fillRect(534, 444, (int)tHealth/3, 8);
		if(!attacking) {
			graphics.drawImage(Assets.attacked, 0, 411,378,69,null);

		}
		if(hurt) {
			graphics.drawImage(Assets.hurt, 0, 411,378,69,null);
			attacking=true;
		}
	}
	
	private BufferedImage getTeamAnimationFrame() {
		return team.getCurrentFrame();

	}
	private BufferedImage getOpponentAnimationFrame() {
		return opponent.getCurrentFrame();
	}

}

