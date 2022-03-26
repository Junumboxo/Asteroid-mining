package traveller;
import java.util.*;
import neighbour.*;
import game.*;

public class Traveller {
	protected Asteroid currentAsteroid;
	protected Game game;
	
	public void drill() { // traveller drills 
		this.currentAsteroid.decreaseDepth();
		
	}
	public void hide(Asteroid a) { // traveller hides
		a.setHollow(false);
	}
	public void teleport(Gate g) { // traveller teleports
		g.underUse(this);
	}
	public void setAsteroid(Asteroid a) {
		this.currentAsteroid=a;
		
	}
	public Asteroid getAsteroid() {
		return (this.currentAsteroid);
	}
	public void underExplosion(){} // traveller is under exlosion
	public void die() {} // traveller dies
}