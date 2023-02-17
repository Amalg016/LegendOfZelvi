package LegendOfZelvi;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import level.Level;
import level.LevelManager;

public class Game_Panel extends JPanel implements Runnable { // class for panel
	public static final int maxScreenCol = 18;
	public static final int maxScreenRow = 9;
	Thread gameThread;
	final int FPS = 60;
	public static final int tileSize = 30;
	public Level currentLevel;

	public Game_Panel() {
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.setFocusable(true);

		gameThread = new Thread(); // initializing the thread
		gameThread.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(currentLevel != null) {
			currentLevel.render(g);
		}
		g.dispose();
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000 / FPS;
		long lastTime = System.nanoTime();
		long timer = 0;
		int drawCount = 0;
        LevelManager.loadLevels();
		currentLevel = LevelManager.getLevel(0);
		currentLevel.loadMap();
        start();
        
		while (gameThread != null) {
			Time.time = System.nanoTime();
			Time.dt += (Time.time - lastTime) / drawInterval;
			timer += (Time.time - lastTime);
			lastTime = Time.time;

			if (Time.dt >= 1) {

				update();
				repaint();

				Time.dt--;
				drawCount++;
			}
			if (timer >= 1000000000) {
				// System.out.println("FPS"+drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
		LevelManager.saveLevels();
	}

	public void start() { // here game can be initialized
//		if(currentLevel != null) {
			currentLevel.start();
//		}
		
	}

	public void update() { // here game logic is updated
		if(currentLevel != null) {
			currentLevel.update();
		}
	}
}
