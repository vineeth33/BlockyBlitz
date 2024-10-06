package gameState;

import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import com.Constants;
import com.ui.ImageButton;

import game.Game;
import game.GameWindow;
import level.BackGround;

public class MenuState implements GameState {
	private BackGround bg;
	private ImageButton playButton, changeSpriteButton, changeSpriteButton1, titleLogo;
	
	public MenuState() {
		// Set Background
		bg = new BackGround(Constants.bgURL, GameWindow.WIDTH, GameWindow.HEIGHT);
		
		bg.setScrollSpeed(2);
		
		// UI
		playButton = new ImageButton(Constants.playButtonURL, 150, 150);
		playButton.setPosition((GameWindow.WIDTH - playButton.getWidth()) / 2, (GameWindow.HEIGHT - playButton.getHeight()) / 2);
	
		changeSpriteButton = new ImageButton(Constants.helpButtonURL, (int) (playButton.getWidth() * 0.7), (int) (playButton.getHeight() * 0.7));
		changeSpriteButton.setPosition(playButton.getX() - changeSpriteButton.getWidth() - 60, playButton.getY() + 15);

		changeSpriteButton1 = new ImageButton(Constants.helpButtonURL, (int) (playButton.getWidth() * 0.7), (int) (playButton.getHeight() * 0.7));
		changeSpriteButton1.setPosition(playButton.getX() + playButton.getWidth() + 60, playButton.getY() + 15);

		titleLogo = new ImageButton(Constants.titleURL, 350, 50);
		titleLogo.setPosition((GameWindow.WIDTH - titleLogo.getWidth()) / 2, playButton.getY() - titleLogo.getHeight()*2);
	
	}

	@Override
	public void update() {
		bg.update();
	}

	@Override
	public void draw(Graphics g) {
		bg.draw(g);
		titleLogo.draw(g);
		playButton.draw(g);
		changeSpriteButton.draw(g);
		changeSpriteButton1.draw(g);
		
	}

	@Override
	public void destroy() {
		bg.destroy();
		playButton.destroy();
		changeSpriteButton.destroy();
		changeSpriteButton1.destroy();
	}
	
	@Override
	public void keyPressed(int keyCode) {
		if(keyCode == KeyEvent.VK_SPACE) {
			GameStateManager.gsm.getCurrentState().destroy();
			GameStateManager.gsm.setState(GameStateManager.GAME_PLAY_STATE);
		}
	}

	@Override
	public void keyReleased(int keyCode) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(playButton.checkPressed(e.getX(), e.getY())) {
			GameStateManager.gsm.getCurrentState().destroy();
			GameStateManager.gsm.setState(GameStateManager.GAME_PLAY_STATE);
		}
		else if(changeSpriteButton.checkPressed(e.getX(), e.getY())) {
			GameStateManager.gsm.setState(GameStateManager.CHANGE_SPRITE_STATE);
		}
		else if(changeSpriteButton1.checkPressed(e.getX(), e.getY())) {
			GameStateManager.gsm.setState(GameStateManager.CHANGE_SPRITE_STATE);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
