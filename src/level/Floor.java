package level;

import java.awt.Color;
import java.awt.Graphics;

import game.GameWindow;
import gameObject.Visible;

public class Floor extends Visible{
	private int scrollSpeed;
	public double gravity;
	
	public Floor(String url, int width, int height, int x, int y) {
		super(url, width, height, x, y);
		super.setImageSize(width/2, height);
		gravity = 170;
	}
	
	public int getScrollSpeed() {
		return this.scrollSpeed;
	}
	
	public void setScrollSpeed(int scrollSpeed) {
		this.scrollSpeed = scrollSpeed;
	}
	
	public void update() {
		setPosition(getX() - scrollSpeed, getY());
		
		if(getX() < -getImgWidth()) {
			setPosition(0, getY());
		}
	}
	
	public void draw(Graphics g) {
		// Lava Tiles
		g.drawImage(super.image, getX(), getY(), null);
		g.drawImage(super.image, getX() + getImgWidth(), getY(), null);
		
		// Lava Top
		g.setColor(new Color(255, 87, 34));
		g.fillRect(0, getY(), GameWindow.WIDTH, 3);
		g.setColor(new Color(255, 110, 50));
		g.fillRect(0, getY()+3, GameWindow.WIDTH, 2);
		g.setColor(new Color(255, 130, 60));
		g.fillRect(0, getY()+3+2, GameWindow.WIDTH, 1);
		
		// Lava Line
		g.setColor(new Color(0, 0, 0));
		g.drawLine(0, getY(), GameWindow.WIDTH, getY());
	}
	
}
