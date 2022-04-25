package neighbour;

import java.util.*;
import resource.*;
import traveller.*;

public class Asteroid implements INeighbour{

	private boolean isPerihelion;
	private boolean isHollow = true; //Requirement R08
	private int depth;
	private List<Traveller> travellers;
	private List<INeighbour> neighbours; //Requirement R16
	private Resource resource; //Requirement R08,09
	
	public Asteroid() {
		travellers = new ArrayList<Traveller>();
		neighbours = new ArrayList<INeighbour>();
	}
	public void setPerihelion(boolean b)    //Sets the location of the perihelion
	{ // pass true as parameter if Perihelion, false if Aphelion
		isPerihelion = b;
		if (b) {
			System.out.println("Current asteroid is in Perihelion phase");
	   		if (depth == 0)
	   			resource.exposed(this);
		}
		else {
			System.out.println("Current asteroid is in Aphelion phase");
		}
			
	}
	
	public void setHollow(boolean b)  //Sets the core  of the asteroid hollow.
	{
		System.out.println("setHollow(b)");
		isHollow = b;
	}
	
	public void setDepth(int depth)  //Sets the depth of an asteroid to the extent it can be drilled.
	{
		if (depth > 0)
		{
			this.depth = depth;
			System.out.println("Depth set " + depth);
		}
		else
			System.out.println("Depth cannot be negative");
	}
	
	public void decreaseDepth()  //Depth function that is reposible for changing the depth of the asteroid to ensure that it can be drilled.
	{
		if (depth > 0)
		{
			depth--;
			System.out.println("Depth decreased by 1");
		}
		else
			System.out.print("The asteroid is fully drilled");
	}
	
	public void explode()   //Provides the functionalities for the explosion of the asteroid.
	{
		System.out.println("explode()");
		for (int i = 0; i < travellers.size(); i++)
			travellers.get(i).underExplosion();
	}

	public void extract(Settler s)  //Function responsible for mining/picking up the resource.
	{
		//System.out.println("extract(s)");
		s.pickUpResource();
	}
	
	public boolean addResource(Resource r)  //Ensures that a dropped resource by the settler is kept in the asteroid.
	{
		if (isHollow) {
			resource = r;
			isHollow = false;
			System.out.println("Resources set " + r.getType());
		return true;
		}
		return false;
	}
	
	public Resource getResource()  
	{
		//System.out.println("getResource()");
		return resource;
	}
	
	public void removeResource()   //This function checks if an asteroid is being picked by the settler or exploded and the core is set to hollow.
	{ 
		//System.out.println("removeResource()");
		resource = null;
		isHollow = true;
	}
	
	
	public void underStorm()  //Provides functionalities for hiding of player under the sunstorm, also responsible for its behavior under the sunstorm.
	{
		System.out.println("underStorm()");
		for (int i = 0; i < travellers.size(); i++)
		{
			if (isHollow)
			{
				travellers.get(i).hide(this);
			}
			else
				travellers.get(i).die();
				
		}
		isHollow = true;
	}
	
	@Override
	public void placeTraveller(Traveller t)     //Sets a travelller (settler/robot) on the asteroid
	{
		//System.out.println("placeTraveller(t)");
		travellers.add(t);
		t.setAsteroid(this);
	}
	
	@Override
	public void removeTraveller(Traveller t) //Removes a traveller from the asteroid
	{
		//System.out.println("removeTraveller(t)");
		travellers.remove(t);
		t.setAsteroid(null);
	}

	@Override
	public void addNeighbour(INeighbour n) //sets a neighbouring asteroid
	{
		if (!neighbours.contains(n))
		{
			neighbours.add(n);
			n.addNeighbour(this);
			System.out.println("Neighbour added");
		}
		else 
			System.out.println("This neighbour already added");
	}

	@Override
	public void removeNeighbour(INeighbour n) //removes an asteroid if it is exploded
	{
		neighbours.remove(n);
		System.out.println("Neighbour removed");
	}
	
	public INeighbour getNeighbour(int i) 
	{
		System.out.println("getNeighbour()");
		return neighbours.get(i);
	}
	
	public List<INeighbour> getNeighbours() 
	{
		return neighbours;
	}

	public int getDepth() {
		// TODO Auto-generated method stub
		return depth;
	}
}
