package level.obstacles;

import gameObject.Entity;
import level.Cube;

public interface Obstacle extends Entity {
	public boolean onPlayerCollision(Cube cube);
	public int getX();
	public void destroy();
}
