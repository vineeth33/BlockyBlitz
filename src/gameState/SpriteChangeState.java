package gameState;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import com.Constants;
import com.ui.ImageButton;

import level.BackGround;
import game.GameWindow;

public class SpriteChangeState implements GameState {
	private BackGround bg;
	private ImageButton redCubeButton;
	private ImageButton greenCubeButton;
	private ImageButton yellowCubeButton;
	
	public SpriteChangeState() {
		bg = new BackGround(Constants.bgURL, GameWindow.WIDTH, GameWindow.HEIGHT, 0, 0);
		bg.setScrollSpeed(2);
		
		yellowCubeButton = new ImageButton(Constants.cubeIdle1[0], 100, 100);
		yellowCubeButton.setPosition((GameWindow.WIDTH - yellowCubeButton.getWidth()) / 2, (GameWindow.HEIGHT - yellowCubeButton.getHeight()) / 2);
		
		redCubeButton = new ImageButton(Constants.cubeIdle2[0], 100, 100);
		redCubeButton.setPosition(yellowCubeButton.getX() + yellowCubeButton.getWidth() + 50, yellowCubeButton.getY());

		greenCubeButton = new ImageButton(Constants.cubeIdle3[0], 100, 100);
		greenCubeButton.setPosition(yellowCubeButton.getX() - yellowCubeButton.getWidth() - 50, yellowCubeButton.getY());


	}
	 
	public void update() {
		bg.update();
	}

	@Override
	public void draw(Graphics g) {
		bg.draw(g);
		redCubeButton.draw(g);
		greenCubeButton.draw(g);
		yellowCubeButton.draw(g);

	}

	@Override
	public void keyPressed(int keyCode) {

	}

	@Override
	public void keyReleased(int keyCode) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(yellowCubeButton.checkPressed(e.getX(), e.getY())) {
			GameStateManager.gsm.spriteIndex = 1;
		}
		else if(redCubeButton.checkPressed(e.getX(), e.getY())) {
			GameStateManager.gsm.spriteIndex = 2;
		}
		else if(greenCubeButton.checkPressed(e.getX(), e.getY())) {
			GameStateManager.gsm.spriteIndex = 3;
		}
		this.destroy();
		GameStateManager.gsm.setState(GameStateManager.MENU_STATE);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void destroy() {
		bg.destroy();
		redCubeButton.destroy();
		yellowCubeButton.destroy();
		greenCubeButton.destroy();
	}

}
