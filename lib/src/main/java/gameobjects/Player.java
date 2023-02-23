package gameobjects;
import LegendOfZelvi.Time;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Animations.Animation;
import LegendOfZelvi.AssetPool;
import LegendOfZelvi.Game;
import LegendOfZelvi.GameObject;
import LegendOfZelvi.InputManager;


public class Player extends GameObject {

	private BufferedImage source;
	private Animation currentAnim;
	private Animation lastAnim;
	private BufferedImage[] downWalk;
	private BufferedImage[] upWalk;
	private BufferedImage[] leftWalk;
	private BufferedImage[] rightWalk;
	
	private BufferedImage[] downAttack;
	Animation downWalkAnim;
	Animation upWalkAnim;
	Animation leftWalkAnim;
	Animation rightWalkAnim;
	Animation downAttackAnim;
	
	int currentDir=down;
	int currentState=idle;
	
	Animation[] walkAnims;
	Animation[] attackAnims;
	
	ArrayList<Animation[]> animations=new ArrayList<Animation[]>();
	private float timeTracker;
	private int state=0;
	private int lastState=0;
	private int currentIndex;
	public int speed = 2;
	
	public Player() {
		super();
	}

	public Player(int x, int y, BufferedImage image) {
		super(x, y, image);
	}

	public Player(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void start() {
		loadImages();
	}
	public void loadImages() {
	     try{
	    	 downWalk=new BufferedImage[8];
	    	 upWalk=new BufferedImage[8];
	    	 rightWalk=new BufferedImage[6];
	    	 leftWalk=new BufferedImage[6];
	    	 downAttack=new BufferedImage[6];
	    	source= AssetPool.spritesheets.get("spritesheet1"); 	 
	    	image=source.getSubimage(3, 1, 16, 22);
	  
	    //Walking down
	    		downWalk[0]=source.getSubimage(3,31,16,22);
	    		downWalk[1]=source.getSubimage(33,31,16,22);
	    		downWalk[2]=source.getSubimage(63,30,16,23);
	    		downWalk[3]=source.getSubimage(93,30,16,24);
	    		downWalk[4]=source.getSubimage(123,31,16,22);
	    		downWalk[5]=source.getSubimage(153,30,16,23);
	    		downWalk[6]=source.getSubimage(183,30,16,23);
	    		downWalk[7]=source.getSubimage(213,30,16,24);
	     //Walking up
	    		upWalk[0]=source.getSubimage(2, 120, 17, 23);
	    		upWalk[1]=source.getSubimage(32, 120, 17, 24);
	    		upWalk[2]=source.getSubimage(62, 121, 17, 22);
	    		upWalk[3]=source.getSubimage(92, 121, 17, 22);
	    		upWalk[4]=source.getSubimage(122, 120, 17, 23);
	    		upWalk[5]=source.getSubimage(152, 120, 17, 24);
	    		upWalk[6]=source.getSubimage(182, 121, 17, 22);
	    		upWalk[7]=source.getSubimage(212, 121, 17, 22);
       //rightwalk
	    		rightWalk[0]=source.getSubimage(241, 120, 19, 24);
	    		rightWalk[1]=source.getSubimage(272, 120, 18, 24);
	    		rightWalk[2]=source.getSubimage(301, 120, 19, 23);
	    		rightWalk[3]=source.getSubimage(331, 120, 19, 23);
	    		rightWalk[4]=source.getSubimage(361, 120, 19, 24);
	    		rightWalk[5]=source.getSubimage(392, 120, 18, 24);
		//lefttwalk
		        leftWalk[0]=source.getSubimage(241, 30, 19, 24);
		        leftWalk[1]=source.getSubimage(272, 30, 18, 24);
	        	leftWalk[2]=source.getSubimage(301, 30, 19, 23);
		        leftWalk[3]=source.getSubimage(331, 30, 19, 23);
		        leftWalk[4]=source.getSubimage(361, 30, 19, 24);
		        leftWalk[5]=source.getSubimage(392, 30, 18, 24);

		        //downAttack
		        downAttack[0]=source.getSubimage(0,85,28 ,31);
		        downAttack[1]=source.getSubimage(27,85,28 ,31);
		        downAttack[2]=source.getSubimage(58,86, 28,31);
		        downAttack[3]=source.getSubimage(87,86, 28,31);
		        downAttack[4]=source.getSubimage(115,86,28 ,31);
		        downAttack[5]=source.getSubimage(146,86,28 ,31);
		        
		       
		     
		     walkAnims=new Animation[4];
		     
		     upWalkAnim=new Animation();
		     upWalkAnim.clip=upWalk;
		     walkAnims[up]=upWalkAnim;
		  
		     downWalkAnim=new Animation();
		     downWalkAnim.clip=downWalk;
		     walkAnims[down]=downWalkAnim;
		     
		     rightWalkAnim=new Animation();
		     rightWalkAnim.clip=rightWalk;
		     walkAnims[right]=rightWalkAnim;
		     
		     leftWalkAnim=new Animation();
		     leftWalkAnim.clip=leftWalk;
		     walkAnims[left]=leftWalkAnim;
		     
		     
		     attackAnims=new Animation[1];
		     downAttackAnim=new Animation();
		     downAttackAnim.clip=downAttack;
		     //downAttackAnim.time=;  
		     downAttackAnim.loop=false;
		     
		     attackAnims[down]=downAttackAnim;
		     
		     
		     animations.add(walkAnims); 
		     animations.add(attackAnims); 

		         currentState=attack;
		        
	     }catch(Exception e) {
	    	 e.printStackTrace();	     }  
	}
	
	public void updateAnim() {
		currentAnim=animations.get(currentState)[currentDir];
		if(currentAnim==null)return;
		   timeTracker -= Time.dt;
			
		   if(currentAnim!=lastAnim) {currentIndex=0;}

		   if(timeTracker <= 0)
		   {
			   lastAnim=currentAnim;
			   if (currentIndex < currentAnim.clip.length-1)
		       {
		              currentIndex++;
		       }
			   else if(currentIndex==currentAnim.clip.length-1)
			   {
		               currentIndex=(currentIndex+1)%currentAnim.clip.length;
			   }
		          timeTracker=currentAnim.time; 
		        
		          image= currentAnim.clip[currentIndex]; 

		          if(!currentAnim.loop&&currentIndex==currentAnim.clip.length-1) {
		          currentState=idle;
		       }
		   }     
	  }
	  
	
	@Override
	public void update() {
		
//		if(!InputManager.upPressed || !InputManager.downPressed || 
//				!InputManager.rightPressed || !InputManager.leftPressed) {
//			currentIndex = 0;
//		}
		
//		if(InputManager.upPressed || InputManager.downPressed || 
//				InputManager.rightPressed || InputManager.leftPressed) {
			updateAnim();
//		}
			
			if(InputManager.spacePressed) {
				currentState=attack;
			}
		if(InputManager.upPressed) {
			y -= speed;
			//currentAnim = upWalkAnim;
			currentDir=up;		
			state = 1;
		}
		
		else if(InputManager.downPressed) {
			y += speed;
			//currentAnim = downWalkAnim;
			currentDir=down;
			state = 2;
		}
		
		else if(InputManager.rightPressed) {
			x += speed;
			//currentAnim = rightWalkAnim;
			currentDir=right;
			state = 3;
		}
		
		else if(InputManager.leftPressed) {
			x -= speed;
		//	currentAnim = leftWalkAnim;
			currentDir=left;
			state = 4;
		}
		
		
		
		if(y>Game.maxScreenRow*30) {
			y=0;
		}
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
	}

}
