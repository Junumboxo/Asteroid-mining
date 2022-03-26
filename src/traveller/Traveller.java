package traveller;
import java.util.*;
import neighbour.*;
import game.*;

public class Traveller {
	protected Asteroid currentAsteroid;
	protected Game game;
	
	public void drill() {
		this.currentAsteroid.decreaseDepth();
		
	}
	public void hide(Asteroid a) {
		a.setHollow(false);
	}
	public void teleport(Gate g) {
		g.underUse(this);
	}
	public void setAsteroid(Asteroid a) {
		this.currentAsteroid=a;
		
	}
	public Asteroid getAsteroid() {
		return (this.currentAsteroid);
	}
	public void underExplosion(){}
	public void die() {}
}