package traveller;

import java.util.*;
import neighbour.*;


public class traveller {
	private Asteroid currentasteroid;
	boolean isalive=true;
	public void drill() {
		if (currentasteroid.depth==0) {
			System.out.print("asteroid already drilled");
		}
		else {
			this.currentasteroid.decreaseDepth();
		}
	}
	public boolean hide(Asteroid a) {
		if (currentasteroid.isHollow==true) {
			this.currentasteroid.setHollow(false);
			return(true);
		}
		return(false);
	}
	public void die() {
		this.isalive=false;
	}
	public void setAsteroid(Asteroid a) {
		this.currentasteroid=a;
		
	}
	public Asteroid getAsteroid() {
		return (this.currentasteroid);
	}
	public void teleport(Gate g) {
		
		
	}


}