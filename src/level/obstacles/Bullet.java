package level.obstacles;

import java.awt.Graphics;

import com.tools.physics.Vector;

import gameObject.Visible;
import level.Cube;

public class Bullet extends Visible implements Obstacle{
	
	private Vector<Double> velocity;
	
	public Bullet(String url, int width, int height, double velocityX) {
		super(url, width, height);
		velocity = new Vector<>(velocityX, 0.0);
	}
	
	public Bullet(String url, int width, int height, int x, int y, double velocityX) {
		this(url, width, height, velocityX);
		setPosition(x, y);
		
	}
	
	@Override
	public void update() {
		if(!isDestroyed)
			setPosition((int)(getX() - velocity.x), getY());
	}

	@Override
	public void draw(Graphics g) {
		if(!isDestroyed)
			g.drawImage(image, getX(),getY(), null);
	}

	@Override
	public boolean onPlayerCollision(Cube cube) {
		return false;
	}
	
	@Override
	public void destroy() {
		isDestroyed = true;
	}

}
