package traveller;

import java.util.*;
import neighbour.*;
public class Traveller {
	protected Asteroid currentAsteroid;
	protected Game game;
	
	public void drill() {
		this.currentAsteroid.decreaseDepth();
		
	}
	public void hide(Asteroid a) {
		a.setHollow(false);
	}
	public void die() {
		
	}
	public void setasteroid(Asteroid a) {
		this.currentAsteroid=a;
		
	}
	public Asteroid getasteroid() {
		return (this.currentAsteroid);
	}
	public void teleport(Gate g) {
	}


}