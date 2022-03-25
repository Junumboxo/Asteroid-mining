package neighbour;

import java.util.*;
import resource.*;

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
	}
	
	public void explode()
	{
		
	}
	
	public void extract()
	{
		
	}
	
	public void removeResource()
	{
		
	}
	
	
	public void underStorm()
	{
		
	}

	@Override
	public void placeTraveller(Traveller t)
	{
		travellers.add(t);
	}
	
	public void removeTraveller(Traveller t)
	{
		travellers.remove(t);
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
	
	
}
