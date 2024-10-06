package com.tools.animations;

import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Timer;

import com.tools.physics.Vector;

import gameObject.Visible;

public abstract class Animatable extends Visible {
	
	private Map<String, Animation> animations;
	
	protected String prevState;
	protected String currentState;
	protected int currentSpriteIndex;
	
	protected boolean stateChanged = false;
	protected Timer timer;
	
	public Animatable(HashMap<String, String[]> urls, HashMap<String, int[][]> sizes, int width, int height) {
		
		super(urls.get(Animation.IDLE)[0], width, height);
		
		animations = new HashMap<>();

		// For each individual Animation
		for(String key:urls.keySet()) {
			Animation animation;
			if(sizes.containsKey(key)) {
				animation = new Animation(urls.get(key), sizes.get(key));
			}
			else {				
				animation = new Animation(urls.get(key));
			}
			animations.put(key, animation);
		}
		
		prevState = Animation.IDLE;
		currentState = Animation.IDLE;
		currentSpriteIndex = 0;
	}
	
	public Animatable(HashMap<String, String[]> urls, HashMap<String, int[][]> sizes, int width, int height, int x, int y) {
		this(urls, sizes, width, height);
		super.setPosition(x, y);
	}
	
	public void setState(String state) {
		this.currentState = state;
		this.currentSpriteIndex = 0;
	}
	
	public void changeSprite() {
		currentSpriteIndex = (currentSpriteIndex + 1)%animations.get(currentState).spriteCount();
		super.setImage(animations.get(currentState).getImage(currentSpriteIndex));
	}
	
	@Override
	public void destroy() {
		super.destroy();
		for(String key:animations.keySet()) {
			animations.get(key).destroy();
		}
		animations.clear();
		
	}
	@Override
	abstract public void update();
	@Override
	abstract public void draw(Graphics g);
	
	abstract public void initAnimation();
	abstract public void animate();
}
