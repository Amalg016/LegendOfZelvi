package gameobjects;
import LegendOfZelvi.Time;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import LegendOfZelvi.AssetPool;
import LegendOfZelvi.GameObject;

public class Player extends GameObject {

	private BufferedImage source;
	private BufferedImage[] downWalk;
	private float timeTracker;
	private int state=0;
	private int lastState;
	private int currentIndex;
	
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
	     try{
	    	 downWalk=new BufferedImage[8];
	    	
	    	source= AssetPool.spritesheets.get("spritesheet1"); 	 
	    	image=source.getSubimage(3, 1, 16, 22);
	    	
	    		downWalk[1]=source.getSubimage(3,31,16,22);
	    		downWalk[2]=source.getSubimage(33,31,16,22);
	    		downWalk[3]=source.getSubimage(63,30,16,23);
	    		downWalk[4]=source.getSubimage(93,30,16,24);
	    		downWalk[5]=source.getSubimage(123,31,16,22);
	    		downWalk[6]=source.getSubimage(153,30,16,23);
	    		downWalk[7]=source.getSubimage(183,30,16,23);
	    		downWalk[8]=source.getSubimage(213,30,16,24);


	     }catch(Exception e) {
	    	 e.printStackTrace();	     }  
	}
	public void updateAnim() {
		   timeTracker -= Time.dt;
			if(state!=lastState) {currentIndex=0;}
			    if(timeTracker <= 0)
		        {
		          lastState=state;
				if (currentIndex < downWalk.length-1)
		          {
		              currentIndex++;
		          }
		          else if(currentIndex==downWalk.length-1)
		          {
		               currentIndex=(currentIndex+1)%downWalk.length;
		          }
		        timeTracker=10; 
				image= downWalk[currentIndex]; 
				if(state==1&&currentIndex==1) {
					state=0;
				}
		        }    
	  }
	  
	
	@Override
	public void update() {
		updateAnim();
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
	}

}
