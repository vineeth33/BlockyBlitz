package com.tools.physics;

import gameObject.GameObject;

public class Collider {
	// Checks if a point collides with a GameObject
	public static boolean pointCollision(int x, int y, GameObject a) {
		if(x >= a.getX() && x <= a.getX() + a.getWidth()) {
			if(y >= a.getY() && y <= a.getY() + a.getHeight()) {
				return true;
			}
		}
		return false;
	}
	
	// Checks if the top right corner of a collides with b
	public static boolean topRightCollision(GameObject a, GameObject b) {
		int topRightX = a.getX() + a.getWidth();
		int topRightY = a.getY();
		return pointCollision(topRightX, topRightY, b);
	}
	
	// Checks if the top left corner of a collides with b
	public static boolean topLeftCollision(GameObject a, GameObject b) {
		int topLeftX = a.getX();
		int topLeftY = a.getY();
		return pointCollision(topLeftX, topLeftY, b);
	}
	
	// Checks if the bottom left corner of a collides with b
	public static boolean bottomLeftCollision(GameObject a, GameObject b) {
		int bottomLeftX = a.getX();
		int bottomLeftY = a.getY() + a.getHeight();
		return pointCollision(bottomLeftX, bottomLeftY, b);
	}
	
	// Checks if the bottom right corner of a collides with b
	public static boolean bottomRightCollision(GameObject a, GameObject b) {
		int bottomRightX = a.getX();
		int bottomRightY = a.getY() + a.getHeight();
		return pointCollision(bottomRightX, bottomRightY, b);
	}
	
	public static boolean topCollision(GameObject a, GameObject b) {
		return (topRightCollision(a, b) || topLeftCollision(a, b));
	}
	
	public static boolean bottomCollision(GameObject a, GameObject b) {
		return (bottomRightCollision(a, b) || bottomLeftCollision(a, b));
	}
	
	public static boolean leftCollision(GameObject a, GameObject b) {
		return (topLeftCollision(a, b) || bottomLeftCollision(a, b));
	}
	
	public static boolean rightCollision(GameObject a, GameObject b) {
		return (topRightCollision(a, b) || bottomRightCollision(a, b));
	}
	
	public static boolean checkCollision(GameObject a, GameObject b) {
		return (rightCollision(a, b) || leftCollision(a, b));
	}
}