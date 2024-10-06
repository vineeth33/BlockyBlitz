package game;

import javax.swing.SwingUtilities;

public class Game {
	public static final int FPS = 60;
	private static GameWindow window;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				window = new GameWindow();
			}
		});
		
	}

}
