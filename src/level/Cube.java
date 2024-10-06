package level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.HashMap;

import com.Constants;
import com.tools.animations.Animatable;
import com.tools.animations.Animation;
import com.tools.physics.Collider;
import com.tools.physics.Vector;

import game.Game;
import game.GameWindow;
import gameObject.Visible;

public class Cube extends Animatable {
	
	private Floor floor; 

	private boolean inAir = true;
	
	private Vector<Double> velocity;
	private double jumpSpeed;
	
	private int highScore = 0, currentScore = 0;
	
	public Cube(HashMap<String, String[]> urls, HashMap<String, int[][]> sizes, int width, int height, Floor floor, double velocityX, double jumpSpeed) {
		super(urls, sizes, width, height);
		super.setPosition((GameWindow.WIDTH * 2)/6, 200);
		
		this.velocity = new Vector<Double>(velocityX, 0.0);
		this.jumpSpeed = jumpSpeed;
		
		this.floor = floor;
	}
	
	public double getVelocityX() {
		return this.velocity.x;
	}
	
	public double getVelocityY() {
		return this.velocity.y;
	}
	
	public void setVelocity(double x, double y) {
		this.velocity.x = x;
		this.velocity.y = y;
	}
	
	public void jump() {
		super.currentState = Animation.JUMP;
		if(!inAir) {
			velocity.y -= jumpSpeed;
		}		
		inAir = true;
	}
	
	@Override
	public void update() {
				
		setPosition(getX(), (int)(getY() + velocity.y));
		animate();
		if(Collider.bottomCollision(this, floor)) {
			inAir = false;
			setPosition(getX(), floor.getY() - getHeight());
			
			super.currentState = Animation.IDLE;
		}
		
		if(inAir) {
			velocity.y += floor.gravity/Game.FPS;
		}
		else {
			velocity.y = 0.0;
		}
		
		if(!super.prevState.equals(super.currentState)) {
			super.stateChanged = true;
			this.initAnimation();
		}
		else {
			super.stateChanged = false;
		}
		super.prevState = super.currentState;
		
		currentScore++;
		if(currentScore > highScore) {
			highScore = currentScore;
		}
	}
	
	public int getcurrentScore() {
        return currentScore;
    }
	
    public int getHighScore() {
    	return highScore;
    }
    
    public void setHighScore(int score) {
    	this.highScore = score;
    }

	@Override
	public void draw(Graphics g) {
		g.drawImage(super.image, getX(), getY(), null);
	}
	
	@Override
	public void initAnimation() {
		if(super.currentState.equals(Animation.IDLE)) {
			super.changeSprite();
		}
	}
	
	@Override
	public void animate() {
		if(super.currentState.equals(Animation.JUMP)) {
			int flyHeight = floor.getY() - (getY() + getHeight());
			if(flyHeight > 0 && flyHeight < 30 && (super.currentSpriteIndex == 0 || super.currentSpriteIndex == 6)) {
				super.changeSprite();
			}
			else if(flyHeight > 30 && flyHeight < 50 && (super.currentSpriteIndex == 1 || super.currentSpriteIndex == 5)) {
				super.changeSprite();
			}
			else if(flyHeight > 50 && flyHeight < 70 &&(super.currentSpriteIndex == 2 || super.currentSpriteIndex == 4)) {
				super.changeSprite();
			}
			else if(flyHeight > 70 && (super.currentSpriteIndex == 3)) {
				super.changeSprite();
			}
		}
		
	}
	
	@Override
	public void destroy() {
		super.destroy();
		velocity = null;
	}
}
