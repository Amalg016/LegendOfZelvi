package LegendOfZelvi;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;


public class AssetPool {
	public static Map<String,BufferedImage> spritesheets=new HashMap();

	public AssetPool() {
		 InputStream is=getClass().getResourceAsStream("/Assets/images/Zelvi1.png");
		 InputStream map=getClass().getResourceAsStream("/Assets/images/map1sp.png");
		 InputStream enemy1=getClass().getResourceAsStream("/Assets/images/enemy1.png");
		 try{
			 AssetPool.spritesheets.put("spritesheet1",ImageIO.read(is)); 	 
			 AssetPool.spritesheets.put("spritesheet2",ImageIO.read(map)); 	 
			 AssetPool.spritesheets.put("spritesheet3",ImageIO.read(enemy1)); 	 
	    	 
	     }catch(Exception e) {
	    	 System.out.println(e);
	     }  

	}

	public static BufferedImage getSpritesheet(String name) {
			if (AssetPool.spritesheets.containsKey(name)) {
			      return AssetPool.spritesheets.get(name);
			  }
			else 
			{
				System.out.println("No sheets with that name");  
			}	
			return null;
	}

}
