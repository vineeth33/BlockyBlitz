package level.obstacles;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.Timer;

import com.tools.animations.Animatable;
import com.tools.physics.Collider;
import com.tools.physics.Vector;

import game.Game;
import level.Cube;

public class VerticalLaser extends Animatable implements Obstacle{
	
	private Vector<Double> velocity;
	
	public VerticalLaser(HashMap<String, String[]> urls, HashMap<String, int[][]> sizes, int width, int height, double velocityX) {
		super(urls, sizes, width, height);
		
		this.velocity = new Vector<Double>(velocityX, 0.0);
		this.initAnimation();
		
	}
	
	public VerticalLaser(HashMap<String, String[]> urls, HashMap<String, int[][]> sizes, int width, int height, int x, int y, double velocityX) {
		this(urls, sizes, width, height, velocityX);
		super.setPosition(x, y);
		
		
	}
	
	@Override
	public void update() {
		// Update Position
		if(!isDestroyed)
			super.setPosition((int)(getX() - this.velocity.x), getY());
		
	}

	@Override
	public void draw(Graphics g) {
		if(!isDestroyed)
			g.drawImage(super.image, getX(), getY(), null);
		
	}
	
	@Override
	public void initAnimation() {
		// Initialize animation
		timer = new Timer(1000 / Game.FPS * 4, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				animate();
			}
			
		});
		timer.start();
	}

	@Override
	public void animate() {
		super.changeSprite();
	}

	@Override
	public boolean onPlayerCollision(Cube cube) {
		return Collider.checkCollision(cube, this);
	}
	
	public int getX() {
		return super.getX();
	}
	
	@Override
	public void destroy() {
		isDestroyed = true;
		timer.stop();
	}
	

}
