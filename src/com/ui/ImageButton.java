package com.ui;

import java.awt.Graphics;

import com.tools.physics.Collider;

import gameObject.Visible;

public class ImageButton extends Visible{
	
	public ImageButton(String url, int width, int height) {
		super(url, width, height);
	}
	
	public ImageButton(String url, int width, int height, int x, int y) {
		super(url, width, height, x, y);
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(super.image, getX(), getY(), null);
	}
	
	public boolean checkPressed(int x, int y) {
		return Collider.pointCollision(x, y, this);
	}
}
