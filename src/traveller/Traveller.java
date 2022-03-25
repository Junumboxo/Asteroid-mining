package traveller;

import java.util.*;
import neighbour.*;



public class traveller {
	private Asteroid currentasteroid;
	protected Game game;
	
	public void drill() {
		this.currentAsteroid.decreaseDepth();
		
	}
	public boolean hide(Asteroid a) {
		if (currentasteroid.isHollow==true) {
			this.currentasteroid.setHollow(false);
			return(true);
		}
		return(false);
	}
	public void die() {
		
	}
	public void teleport(Gate g) {
	
	}
	public void setasteroid(Asteroid a) {
		this.currentAsteroid=a;
		
	}
	public Asteroid getasteroid() {
		return (this.currentAsteroid);
	}

}