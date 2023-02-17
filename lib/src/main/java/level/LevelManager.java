package level;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Type;

import com.google.common.io.FileWriteMode;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LevelManager {
	public static Map<String, Level> levels = new HashMap<String, Level>();

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
            Level j=levels.get("Level 1");
			String g=j.mapLocation;
			System.out.println(g);
		}
	}

	public static void saveLevel() {
		Level level1 = new Level();
		level1.mapLocation = "/Assets/maps/level1.txt";
		level1.loadMap();
		levels.put("Level 1", level1);
    	
		String json=new Gson().toJson(levels);
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
