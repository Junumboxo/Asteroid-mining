package resource;
import neighbour.*;

public class Water extends Resource{

	//gets an Asteroid as a parameter and removes water resource from it
	public void exposed(Asteroid a)
	{
		a.removeResource();
	}
}
