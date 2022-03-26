package traveller;
import java.util.*;
import neighbour.*;

public class traveller {
	private Asteroid currentasteroid;
	protected Game game;
	
	//drill method
	public void drill() {
		this.currentAsteroid.decreaseDepth();
		
	}
	//hide method
	public boolean hide(Asteroid a) {
		if (currentasteroid.isHollow==true) {
			this.currentasteroid.setHollow(false);
			return(true);
		}
		return(false);
	}
	//teleport method
	public void teleport(Gate g) {
		g.underUse(this);
	
	}
	//setasteroid method
	public void setasteroid(Asteroid a) {
		this.currentAsteroid=a;
		
	}
	//getasteroid method
	public Asteroid getasteroid() {
		return (this.currentAsteroid);
	}
	public void underexplosion(){}
	
	public void die() {}
	

}
//blablabla