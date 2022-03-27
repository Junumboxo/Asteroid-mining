package sun;
import java.util.*;

import neighbour.*;


public class Sun {
	private List<Asteroid> asteroids;
	
	public void sunstorm()  //R28
	{
		for (Asteroid a: asteroids)
			a.underStorm();
	}
	
	public void addAsteroids(List<Asteroid> toAdd)
	{
		for (Asteroid a: toAdd)
			asteroids.add(a);
	}
	
	public List<Asteroid> getAsteroids()
	{
		return asteroids;
	}
}
