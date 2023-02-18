package level;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import LegendOfZelvi.AssetPool;
import LegendOfZelvi.Game;
import LegendOfZelvi.Game_Panel;
import gameobjects.Player;

public class Level {
	private transient int[][] map;
	public String mapLocation;
    transient Player p1;
	
   transient BufferedImage image1;
   transient BufferedImage image2;
   
	public void start() {
		p1 = new Player(200,200);
		p1.start();
		

		BufferedImage source= AssetPool.spritesheets.get("spritesheet2"); 	 
//		image=source.getSubimage(100,1200, 25, 25);
		image1=source.getSubimage(125,1245, 25, 25);
		image2=source.getSubimage(180,1350, 25, 25);
  
		
		int col =0;
		int row=0;
						
		while(col<Game.maxScreenCol&&row<Game.maxScreenRow) {
		
			while(col<Game.maxScreenCol) {
					 
				int worldX=col*30;
				int worldY=row*30;
				
					//  g.drawImage(tiles[map[col][row]].image, worldX, worldY, 30, 30,  null); 	
				col++;
			}
				
			if(col==Game.maxScreenCol) {
				col=0;
				row++;
			}			
		}
	}
	
	public void update() {
		p1.update();
	}
		
	public void render(Graphics g) {

		
		if(image1==null)return;
		int col =0;
		int row=0;
						
		while(col<Game.maxScreenCol&&row<Game.maxScreenRow) {
		
			while(col<Game.maxScreenCol) {					 
				int worldX=col*30;
				int worldY=row*30;
				if(map[col][row]==0) {
					g.drawImage(image1, worldX, worldY, 30, 30,  null); 					
				}
				else {
					g.drawImage(image2, worldX, worldY, 30, 30,  null); 				
				}
				//	  g.drawImage(tiles[map[col][row]].image, worldX, worldY, 30, 30,  null); 
				col++;
			}
				
			if(col==Game.maxScreenCol) {
				col=0;
				row++;
			}			
		}
		if(p1!=null) {
			p1.render(g);	
		}
	}	
	
	public void loadMap() {
		try {
			map = new int[Game.maxScreenCol][Game.maxScreenRow];
			InputStream is = getClass().getResourceAsStream(mapLocation);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int row = 0;

			while (col < Game.maxScreenCol && row < Game.maxScreenRow) {

				String line = br.readLine();

				while (col < Game.maxScreenCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					map[col][row] = num;
					col++;
				}
				if (col == Game.maxScreenCol) {
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
