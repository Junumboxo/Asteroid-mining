package neighbour;

import java.util.*;
import resource.*;
import traveller.*;

public class Asteroid implements INeighbour{

	private boolean isPerihelion;
	private boolean isHollow; //Requirement R08
	private int depth;
	private List<Traveller> travellers;
	private List<INeighbour> neighbours; //Requirement R16
	private Resource resource; //Requirement R08,09
	
	
	public void setPerihelion(boolean b)    //Sets the location of the perihelion
	{
		isPerihelion = b;
		if (b)
			resource.exposed(this);
	}
	
	public void setHollow(boolean b)  //Sets the core  of the asteroid hollow.
	{
		isHollow = b;
	}
	
	public void setDepth(int depth)  //Sets the depth of an asteroid to the extent it can be drilled.
	{
		if (depth > 0)
			this.depth = depth;
	}
	
	public void decreaseDepth()  //Depth function that is reposible for changing the depth of the asteroid to ensure that it can be drilled.
	{
		if (depth > 0)
			depth--;
		else
			System.out.print("The asteroid is already drilled");
	}
	
	public void explode()   //Provides the functionalities for the explosion of the asteroid.
	{
		for (Traveller t: travellers)
			t.underExplosion();
	}

	public void extract(Settler s)  //Function responsible for mining/picking up the resource.
	{
		s.pickUpResource();
	}
	
	public void addResource(Resource r)  //Ensures that a dropped resource by the settler is kept in the asteroid.
	{
		resource = r;
	}
	
	public Resource getResource()  
	{
		return resource;
	}
	
	public void removeResource()   //This function checks if an asteroid is being picked by the settler or exploded and the core is set to hollow.
	{ 
		resource = null;
		isHollow = true;
	}
	
	
	public void underStorm()  //Provides functionalities for hiding of player under the sunstorm, also responsible for its behavior under the sunstorm.
	{
		for (Traveller t: travellers)
		{
			if (isHollow)
			{
				t.hide(this);
			}
			else
				t.die();
				
		}
		isHollow = true;
	}

	@Override
	public void placeTraveller(Traveller t)     //Sets a travelller (settler/robot) on the asteroid
	{
		travellers.add(t);
		t.setasteroid(this);
	}
	
	@Override
	public void removeTraveller(Traveller t) //Removes a traveller from the asteroid
	{
		travellers.remove(t);
		t.setasteroid(null);
	}

	@Override
	public void addNeighbour(INeighbour n) //sets a neighbouring asteroid
	{
		neighbours.add(n);
	}

	@Override
	public void removeNeighbour(INeighbour n) //removes an asteroid if it is exploded
	{
		neighbours.remove(n);
	}
	
	public INeighbour getNeighbour(int i) 
	{
		return neighbours.get(i);
	}
}
