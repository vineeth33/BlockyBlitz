package level;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

import gameObject.Visible;

public class BackGround extends Visible{
	private int scrollSpeed;
	
	public BackGround(String url, int width, int height) {
		super(url, width, height);
		setPosition(0, 0);
	}
	
	public BackGround(String url, int width, int height, int x, int y) {
		this(url, width, height);
		setPosition(x, y);
	}
	
	public int getScrollSpeed() {
		return this.scrollSpeed;
	}
	
	public void setScrollSpeed(int scrollSpeed) {
		this.scrollSpeed = scrollSpeed;
	}
	
	public void update() {
		setPosition(getX() - scrollSpeed, getY());
		
		if(getX() < -getWidth()) {
			setPosition(0, getY());
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(super.image, getX(), getY(), null);
		g.drawImage(super.image, getX() + getWidth(), getY(), null);
	}
}
