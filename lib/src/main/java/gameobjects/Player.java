package gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import LegendOfZelvi.AssetPool;
import LegendOfZelvi.GameObject;
public class Player extends GameObject {

	private BufferedImage source;
	
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
	    	 
	    	source= AssetPool.spritesheets.get("spritesheet1"); 	 
	    	image=source.getSubimage(0, 0, 25, 25);
	    	image.coerceData(false);
	     }catch(Exception e) {
	    	 e.printStackTrace();	     }  
	}
	
	@Override
	public void update() {
		
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
	}

}
