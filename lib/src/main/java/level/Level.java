package level;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import LegendOfZelvi.Game_Panel;
import gameobjects.Player;

public class Level {
	private transient int[][] map;
	public String mapLocation;
    transient Player p1;
	
	
	public void start() {
		p1 = new Player(400,400);
		p1.start();
		int col =0;
		int row=0;
						
		while(col<Game_Panel.maxScreenCol&&row<Game_Panel.maxScreenRow) {
		
			while(col<Game_Panel.maxScreenCol) {
					 
				int worldX=col*30;
				int worldY=row*30;
				//	  g.drawImage(tiles[map[col][row]].image, worldX, worldY, 30, 30,  null); 	
				col++;
			}
				
			if(col==Game_Panel.maxScreenCol) {
				col=0;
				row++;
			}			
		}
	}
	
	public void update() {
		p1.update();
	}
		
	public void render(Graphics g) {
	    
		p1.render(g);
		int col =0;
		int row=0;
						
		while(col<Game_Panel.maxScreenCol&&row<Game_Panel.maxScreenRow) {
		
			while(col<Game_Panel.maxScreenCol) {					 
				int worldX=col*30;
				int worldY=row*30;
				//	  g.drawImage(tiles[map[col][row]].image, worldX, worldY, 30, 30,  null); 
				col++;
			}
				
			if(col==Game_Panel.maxScreenCol) {
				col=0;
				row++;
			}			
		}
	}	
	
	public void loadMap() {
		try {
			map = new int[Game_Panel.maxScreenCol][Game_Panel.maxScreenRow];
			InputStream is = getClass().getResourceAsStream(mapLocation);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int row = 0;

			while (col < Game_Panel.maxScreenCol && row < Game_Panel.maxScreenRow) {

				String line = br.readLine();

				while (col < Game_Panel.maxScreenCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					map[col][row] = num;
					col++;
				}
				if (col == Game_Panel.maxScreenCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
