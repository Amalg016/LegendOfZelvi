package LegendOfZelvi;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Game { // class for window frame
	public Game() {
		JFrame frame = new JFrame();
		frame.setTitle("Legend Of Zelvi");
		frame.setPreferredSize(new Dimension(800, 800));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		frame.add(new Game_Panel());

		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}
}
