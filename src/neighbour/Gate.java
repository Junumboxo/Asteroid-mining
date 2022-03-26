package neighbour;

import traveller.*;

public class Gate implements INeighbour{
	private boolean active = false;
	private Gate pair;
	private INeighbour neighbouringAsteroid;
	
	public void setPair(Gate pair)
	{
		this.pair = pair;
	}
	
	public Gate getPair()
	{
		return pair;
	}
	
	public INeighbour getNeighbour()
	{
		return neighbouringAsteroid;
	}
	
	public void setActive(boolean b)
	{
		active = b;
	}
	
	public void underUse(Traveller t)
	{
		if (active) {
			neighbouringAsteroid.removeTraveller(t);
			Asteroid a2 = (Asteroid) pair.getNeighbour();
			a2.placeTraveller(t);
		}
	}
	
	@Override
	public void placeTraveller(Traveller t)
	{
		neighbouringAsteroid.placeTraveller(t);
	}
	
	@Override
	public void removeTraveller(Traveller t)
	{
		neighbouringAsteroid.removeTraveller(t);
	}

	@Override
	public void addNeighbour(INeighbour a1)
	{
		Asteroid a2 = (Asteroid)pair.getNeighbour();
		if (a2 != null)
		{
			pair.setActive(true);
			this.setActive(true);
		}
	}

	@Override
	public void removeNeighbour(INeighbour a2)
	{
		neighbouringAsteroid = null;
	}
	
}
