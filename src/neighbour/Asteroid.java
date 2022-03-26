package neighbour;

import java.util.*;
import resource.*;
import traveller.*;

public class Asteroid implements INeighbour{

	private boolean isPerihelion;
	private boolean isHollow;
	private int depth;
	private List<Traveller> travellers;
	private List<INeighbour> neighbours;
	private Resource resource;
	
	
	public void setPerihelion(boolean b)
	{
		isPerihelion = b;
		if (b)
			resource.exposed(this);
	}
	
	public void setHollow(boolean b)
	{
		isHollow = b;
	}
	
	public void setDepth(int depth)
	{
		if (depth > 0)
			this.depth = depth;
	}
	
	public void decreaseDepth()
	{
		if (depth > 0)
			depth--;
		else
			System.out.print("The asteroid is already drilled");
	}
	
	public void explode()
	{
		for (Traveller t: travellers)
			t.underExplosion();
	}
	
	public void extract(Settler s)
	{
		s.pickUpResource(resource);
	}
	
	public void addResource(Resource r)
	{
		resource = r;
	}
	
	public void removeResource()
	{
		resource = null;
		isHollow = true;
	}
	
	
	public void underStorm()
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
	public void placeTraveller(Traveller t)
	{
		travellers.add(t);
		t.setasteroid(this);
	}
	
	@Override
	public void removeTraveller(Traveller t)
	{
		travellers.remove(t);
		t.setasteroid(null);
	}

	@Override
	public void addNeighbour(INeighbour n)
	{
		neighbours.add(n);
	}

	@Override
	public void removeNeighbour(INeighbour n)
	{
		neighbours.remove(n);
	}
	
	public INeighbour getNeighbour(int i)
	{
		return neighbours.get(i);
	}
}
