package sun;
import java.util.*;

import neighbour.*;


public class Sun {
	private List<Asteroid> asteroids;
	public Sun() {
		asteroids = new ArrayList<Asteroid>();
	}
	public void sunstorm()  //R28
	{
		System.out.println("sunstorm()");
		for (Asteroid a: asteroids)
			a.underStorm();
	}
	
	public void addAsteroids(List<Asteroid> toAdd)
	{
		System.out.println("addAsteroids(A)");
		for (Asteroid a: toAdd) {
			asteroids.add(a);
		}
		System.out.println("Asteroids added");
	}
	
	public List<Asteroid> getAsteroids()
	{
		System.out.println("getAsteroids()");
		return asteroids;
	}
}
