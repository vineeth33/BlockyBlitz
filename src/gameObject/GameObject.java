package gameObject;

import com.tools.physics.Vector;

public abstract class GameObject {
	private Vector<Integer> pos;
	private Vector<Integer> size;
	
	public GameObject() {
		size = new Vector<>(0, 0);
		pos = new Vector<>(0, 0);
	}
	
	public GameObject(int width, int height) {
		this();
		this.setSize(width, height);
	}
	
	public GameObject(int width, int height, int x, int y) {
		this(width, height);
		this.setPosition(x, y);
	}
	
	public int getX() {
		return this.pos.x;
	}
	public int getY() {
		return this.pos.y;
	}
	
	public void setPosition(int x, int y) {
		this.pos.x =  x;
		this.pos.y = y;
	}
	
	public int getWidth() {
		return this.size.x;
	}
	public int getHeight() {
		return this.size.y;
	}
	
	public void setSize(int width, int height) {
		this.size.x = width;
		this.size.y = height;
	}
	
	public void destroy() {
		pos = null;
		size = null;
	}
}
