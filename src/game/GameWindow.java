package game;

import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.event.ActionEvent;
import java.awt.Graphics;

import gameState.GameStateManager;

public class GameWindow extends JFrame {
	public static final int WIDTH = 780, HEIGHT = 500;
	
	public GameWindow() {
		super();
		this.init();
		
		// Event detection
		GameStateManager.gsm = new GameStateManager();
		this.addKeyListener(GameStateManager.gsm);
		this.addMouseListener(GameStateManager.gsm);

		// Create buffer strategy for smooth rendering
		this.createBufferStrategy(2);
		
		
		// Game Loop
		Timer timer = new Timer(1000/Game.FPS, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});
		timer.start();
	}
	
	public void init() {
		super.setTitle("Geometry Dash");
		super.setSize(WIDTH, HEIGHT);
		super.setResizable(false);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setLocationRelativeTo(null);
		super.setVisible(true);
	}
	
	private void update() {
		GameStateManager.gsm.update();
	}
	
	@Override
	public void paint(Graphics g) {
		// Get the graphics of the buffer display
		Graphics graphics = this.getBufferStrategy().getDrawGraphics();
		super.paint(graphics);
		
		// Rewrite the contents
		graphics.clearRect(0,  0,  WIDTH, HEIGHT);
		GameStateManager.gsm.draw(graphics);
		graphics.dispose();
		
		// Display the content on the current window
		this.getBufferStrategy().show();
	}
}
