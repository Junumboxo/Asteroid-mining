package resource;
import neighbour.*;

public class Water extends Resource{ //R10
	
	private String type = "water";

	//gets an Asteroid as a parameter and removes water resource from it, R10
	@Override
	public void exposed(Asteroid a)
	{
		System.out.println("Water exposed");
		a.removeResource();
	}
}
