package gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

import LegendOfZelvi.GameObject;
public class Player extends GameObject {

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
		System.out.println("hi");
		InputStream is=getClass().getResourceAsStream("/Assets/Images/Zelvi.png");
	     try{
	    	 image=ImageIO.read(is);
//	    	 AssetPool.spritesheets.put("spritesheet1",ImageIO.read(is)); 	 
	     }catch(Exception e) {
	    	 System.out.println(e);
	     }  
	}
	
	@Override
	public void update() {
		
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
	}

}
