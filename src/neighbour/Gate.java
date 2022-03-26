package neighbour;

import traveller.*;

public class Gate implements INeighbour{
	private boolean active = false;
	private Gate pair;
	private INeighbour neighbouringAsteroid;
	
	public void setPair(Gate pair) 		// Sets connection between 2 teleportation gates 
	{
		this.pair = pair;
	}
	
	public Gate getPair() //Gets the pair of the gate
	{
		return pair;
	}
	
	public INeighbour getNeighbour() //returns a neighbouring asteroid
	{
		return neighbouringAsteroid;
	}
	
	public void setActive(boolean b) // enables the usage of the gates
	{
		active = b;
	}
	
	public void underUse(Traveller t) // removes the teleportating unit from the 1st gate and places it to the 2nd gate if the gate is active(in operation)
	{
		if (active) {
			neighbouringAsteroid.removeTraveller(t);
			Asteroid a2 = (Asteroid) pair.getNeighbour();
			a2.placeTraveller(t);
		}
	}
	
	@Override
	public void placeTraveller(Traveller t) //Sets a travelller (settler/robot) on the asteroid
	{
		neighbouringAsteroid.placeTraveller(t);
	}
	
	@Override
	public void removeTraveller(Traveller t) //Removes a traveller from the asteroid
	{
		neighbouringAsteroid.removeTraveller(t);
	}

	@Override
	public void addNeighbour(INeighbour a1) //sets a neighbouring asteroid
	{
		Asteroid a2 = (Asteroid)pair.getNeighbour();
		if (a2 != null)
		{
			pair.setActive(true);
			this.setActive(true);
		}
	}

	@Override
	public void removeNeighbour(INeighbour a2) //removes a gate/asteroid if it is exploded
	{
		neighbouringAsteroid = null;
	}
	
}
