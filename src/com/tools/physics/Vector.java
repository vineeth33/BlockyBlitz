package com.tools.physics;

public class Vector<T extends Number> {
	public T x;
	public T y;
	
	public Vector(T x, T y) {
		set(x, y);
	}
	
	public void set(T x, T y) {
		this.x = x;
		this.y = y;
	}
}