package gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import LegendOfZelvi.AssetPool;
import LegendOfZelvi.GameObject;
import LegendOfZelvi.Time;

public class enemy1 extends GameObject {

	

	public enemy1(int x, int y) {
		super(x, y);
		
	}

	private BufferedImage[] currentAnim;
	private BufferedImage source;
	
	private float animTimeTracker;
	private float posTimeTracker;
	private boolean canChange=false;
	private int currentIndex;
	
	@Override
	public void start() {
		source =AssetPool.getSpritesheet("spritesheet3");
    currentAnim=new BufferedImage[3];
    currentAnim[0]=source.getSubimage(208, 222, 24, 17);
    currentAnim[1]=source.getSubimage(248, 223, 24, 15);
    currentAnim[2]=source.getSubimage(290, 222, 20, 17);
	}

	@Override
	public void update() {
		 updateAnim();
		 updatePos();
	}
	
    void updatePos() {
    	posTimeTracker -= Time.dt;
		

		   if(posTimeTracker <= 0)
		   {
			   	canChange=!canChange;
		          posTimeTracker=200; 
		   }  
		   if(canChange) {
			   y+=1;
		   }
		   else {
			   y-=1;
		   }
    }
    
	void updateAnim() {
		 animTimeTracker -= Time.dt;
			

		   if(animTimeTracker <= 0)
		   {
			   if (currentIndex < currentAnim.length-1)
		       {
		              currentIndex++;
		       }
			   else if(currentIndex==currentAnim.length-1)
			   {
		               currentIndex=(currentIndex+1)%currentAnim.length;
			   }
		          animTimeTracker=8; 
		          image= currentAnim[currentIndex]; 
		   }  
	}
 
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		super.render(g);
	}

}
