package LegendOfZelvi;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Game { // class for window frame
	public static final int maxScreenCol = 29;
	public static final int maxScreenRow = 26;
	public static final int tileSize = 30;
	public Game() {
		JFrame frame = new JFrame();
		frame.setTitle("Legend Of Zelvi");
		frame.setPreferredSize(new Dimension(maxScreenCol*tileSize+15, maxScreenRow*tileSize+40));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		frame.add(new Game_Panel());

		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}
}
