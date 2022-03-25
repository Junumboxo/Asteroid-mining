package resource;
import neighbour.*;

public class Water extends Resource{
	
	private String type = "water";

	//gets an Asteroid as a parameter and removes water resource from it
	@Override
	public void exposed(Asteroid a)
	{
		a.removeResource();
	}
}
