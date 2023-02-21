package LegendOfZelvi;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputManager extends KeyAdapter {
	
	public static boolean upPressed, downPressed, leftPressed, rightPressed;
	
//	@Override
//	public void keyTyped(KeyEvent e) {
//		
//	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			upPressed = true;
			break;
		case KeyEvent.VK_S:
			downPressed = true;
			break;
		case KeyEvent.VK_A:
			leftPressed = true;
			break;
		case KeyEvent.VK_D:
			rightPressed = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			upPressed = false;
			break;
		case KeyEvent.VK_S:
			downPressed = false;
			break;
		case KeyEvent.VK_A:
			leftPressed = false;
			break;
		case KeyEvent.VK_D:
			rightPressed = false;
			break;
		}
	}


	
}
