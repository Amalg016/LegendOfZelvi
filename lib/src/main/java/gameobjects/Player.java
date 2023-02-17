package gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
	
	}
	
	@Override
	public void update() {
		
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
	}

}
