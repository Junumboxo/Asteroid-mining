package traveller;

import java.util.*;
import neighbour.*;
public class traveller {
	private asteroid currentasteroid;
	boolean isalive;
	public void drill() {
		if (currentasteroid.depth==0) {
			System.out.print("asteroid already drilled");
		}
		else {
			this.currentasteroid.decreaseDepth();
		}
	}
	public boolean hide(asteroid a) {
		if (currentasteroid.isHollow==true) {
			this.currentasteroid.setHollow(false);
			return(true);
		}
		return(false);
	}
	public void die() {
		this.isalive=false;
	}
	public void setasteroid(asteroid a) {
		this.currentasteroid=a;
		
	}
	public asteroid getasteroid() {
		return (this.currentasteroid);
	}
	public void teleport(gate g) {
		
		
	}


}