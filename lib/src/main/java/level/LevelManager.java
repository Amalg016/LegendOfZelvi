package level;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class LevelManager {
	public static Map<String, Level> levels = new HashMap<String, Level>();

	public void loadLevels() {

	}

	public static void saveLevel() {
		Level level1 = new Level();
		level1.mapLocation = "/Assets/maps/level1.txt";
		level1.loadMap();
		levels.put("Level 1", level1);
		String json = new Gson().toJson(levels);
		System.out.println(json);
	}
}
