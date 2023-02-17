package LegendOfZelvi;

import level.LevelManager;

public class Program {

	public static void main(String[] args) {
		new Game();
		LevelManager.saveLevel();
     	LevelManager.loadLevels();
	}

}
