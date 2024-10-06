package level.obstacles;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Timer;

import com.Constants;
import com.tools.animations.Animation;

import java.util.Random;

import game.Game;
import gameObject.Entity;
import gameObject.GameObject;
import level.Cube;

public class ObstacleGenerator extends GameObject implements Entity{
	
	private List<Obstacle> obstacles;
	private Random random;
	private int duration;
	private double velocityX;
	private Timer shootTimer;
	public ObstacleGenerator(int width, int height, int x, int y, double velocityX, double duration) {
		super(width, height);
		setPosition(x, y);
		
		this.velocityX = velocityX;
		obstacles = new ArrayList<>();
		random = new Random();
		this.duration = (int)(Game.FPS * duration);
		shootTimer = new Timer(1000/Game.FPS * this.duration, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				generate();
			}
		});
		shootTimer.start();
		
	}
	
	public ObstacleGenerator(int width, int height, double velocityX, double duration) {
		this(width, height, 0, 0, duration, velocityX);
	}
	
	public void generate() {
		int no = random.nextInt(20);
		if(no > 10) {
			VerticalLaser vl = new VerticalLaser(new HashMap<String, String[]>(Map.of(Animation.IDLE, Constants.vLaserIdle1)), 
					new HashMap<String, int[][]>(Map.of(Animation.IDLE, Constants.vLaserIdleSizes)), 
					Constants.vLaserIdleSizes[0][0], Constants.vLaserIdleSizes[0][1], getX(), getY() - 75, velocityX);
			obstacles.add(vl);
		}
		else if(no > 5) {
			Gun gun = new Gun(new HashMap<String, String[]>(Map.of(Animation.IDLE, Constants.gunIdle)), 
					new HashMap<String, int[][]>(Map.of(Animation.IDLE, Constants.gunIdleSizes)), 
					Constants.gunIdleSizes[0][0], Constants.gunIdleSizes[0][1], getX(), getY() - 45, velocityX);
			obstacles.add(gun);
		}
	}

	@Override
	public void update() {
		// Destroy obstacles
		List<Integer> toDestroy = new ArrayList<>();
		for(int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();
			if(obstacles.get(i).getX() < -50) {
				toDestroy.add(i);
			}
		}
		for(int i:toDestroy) {
			obstacles.get(i).destroy();
			obstacles.set(i, null);
		}
		toDestroy.clear();
		while(obstacles.contains(null)) {
			obstacles.remove(null);
		}
		
	}

	@Override
	public void draw(Graphics g) {
		for(Obstacle obs:obstacles) {
			obs.draw(g);
		}
		
	}
	
	public boolean checkCubeDead(Cube cube) {
		for(Obstacle i:obstacles) {
			boolean playerIsDead = i.onPlayerCollision(cube);
			if(playerIsDead) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void destroy() {
		super.destroy();
		shootTimer.stop();
		for(Obstacle obs:obstacles) {
			obs.destroy();
		}
		obstacles.clear();
	}
}
