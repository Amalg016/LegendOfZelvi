package level;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Type;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class LevelManager {
	public static Map<String, Level> levels = new HashMap<String, Level>();

	
	
	public static Level getLevel(int i) {
		int c=0;
		for(Map.Entry<String,Level> e:levels.entrySet()) {
			if(c==i) {
				return e.getValue();
			}
			c++;
		}
		return null;
	}
	public static Level getLevel(String i) {
		if(levels.containsKey(i)) {
			return levels.get(i);
		}
		return null;
	}
	
	
	
	public static void loadLevels() {
        String json="";
		try {
			json=new String(Files.readAllBytes(Paths.get("Game.txt")));			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!json.equals("")) {
            Type type = new TypeToken<HashMap<String, Level>>(){}.getType();
            levels= new Gson().fromJson(json,type);
            Level j=levels.get("Level 2");
			String g=j.mapLocation;
			System.out.println(g);
		}
	}

	public static void saveLevels() {
		Level level1 = new Level();
		level1.mapLocation = "/Assets/maps/level1.txt";
		level1.loadMap();
		levels.put("Level 2", level1);
    	
		Gson gson=new GsonBuilder().setPrettyPrinting().create();
//		String json=new Gson().toJson(levels);
		String json=gson.toJson(levels);
		System.out.println(json);
		try {
			FileWriter writer=new FileWriter("Game.txt");
			writer.write(json);
			writer.close();
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
}
