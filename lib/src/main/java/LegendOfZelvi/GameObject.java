package LegendOfZelvi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class GameObject {
	public int x,y;
	protected BufferedImage image;
	Rectangle collider;
	
	public GameObject() {
		x = 0;
		y = 0;
	}

	public GameObject(int x, int y, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.image = image;
	}

	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public void start() {
		
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		if(image != null) {
			g.drawImage(image, x, y, Game.tileSize, Game.tileSize, null);
		}
		else {
			g.setColor(Color.BLUE);
			g.fillRect(400, 400, 50, 50);
		}
	}
}
