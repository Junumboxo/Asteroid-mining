package traveller;
import java.util.*;
import neighbour.*;
import game.*;

public class Traveller {
	protected Asteroid currentAsteroid;
	protected Game game;
	
	public void drill() { // traveller drills 
		System.out.println("drill()");
		this.currentAsteroid.decreaseDepth();
		
	}
	public void hide(Asteroid a) { // traveller hides
		System.out.println("hide(a)");
		a.setHollow(false);
	}
	public void teleport(Gate g) { // traveller teleports
		System.out.println("teleport(g)");
		g.underUse(this);
	}
	public void setAsteroid(Asteroid a) {
		System.out.println("setAsteroid()");
		this.currentAsteroid=a;
		
	}
	public Asteroid getAsteroid() {
		System.out.println("getAsteroid()");
		return (this.currentAsteroid);
	}
	public void underExplosion(){System.out.println("underExplosion()");} // traveller is under exlosion
	public void die() {System.out.println("die()");} // traveller dies
}