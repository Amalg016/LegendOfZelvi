package level;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import LegendOfZelvi.Game_Panel;

public class Level {
	private int[][] map;
	public String mapLocation;

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
