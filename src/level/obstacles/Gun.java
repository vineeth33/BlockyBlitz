package level.obstacles;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.Constants;
import com.tools.animations.Animatable;
import com.tools.physics.Collider;
import com.tools.physics.Vector;

import game.Game;
import level.Cube;

public class Gun extends Animatable implements Obstacle{
	
	private Vector<Double> velocity;
	
	private List<Bullet> bullets;
	
	public Gun(HashMap<String, String[]> urls, HashMap<String, int[][]> sizes, int width, int height, double velocityX) {
		super(urls, sizes, width, height);
		
		this.velocity = new Vector<Double>(velocityX, 0.0);
		this.bullets = new ArrayList<>();
		
		timer = new Timer((int)(1000/Game.FPS * 80), (ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shoot();
			}
		});
		timer.start();
		
		this.initAnimation();
	}
	
	public Gun(HashMap<String, String[]> urls, HashMap<String, int[][]> sizes, int width, int height, int x, int y, double velocityX) {
		this(urls, sizes, width, height, velocityX);
		super.setPosition(x, y);
	}
	
	@Override
	public void update() {
		if(!isDestroyed) {
			super.setPosition((int)(getX() - this.velocity.x), getY());
			for(Bullet bullet:bullets) {
				bullet.update();
			}
		}

	}

	@Override
	public void draw(Graphics g) {
		if(!isDestroyed) {
			g.drawImage(super.image, getX(), getY(), null);
			for(Bullet bullet:bullets) {
				bullet.draw(g);
			}
		}
	}
	@Override
	public void animate() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void initAnimation() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void shoot() {
		bullets.add(new Bullet(Constants.blueBullet, Constants.bulletSize[0], Constants.bulletSize[1], getX(), getY(), velocity.x + 7));
	}

	@Override
	public boolean onPlayerCollision(Cube cube) {
		for(Bullet i:bullets) {
			if(Collider.checkCollision(i, cube)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void destroy() {
		isDestroyed = true;
		timer.stop();
		for(Bullet i:bullets) {
			i.destroy();
		}
		bullets.clear();
		
	}
}
