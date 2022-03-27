package neighbour;

import traveller.*;

public class Gate implements INeighbour{
	private boolean active = false;
	private Gate pair;
	private INeighbour neighbouringAsteroid;
	
	public void setPair(Gate pair) 		// Sets connection between 2 teleportation gates 
	{
		System.out.println("setPair(pair)");
		this.pair = pair;
	}
	
	public Gate getPair() //Gets the pair of the gate
	{
		System.out.println("getPair()");
		return pair;
	}
	
	public INeighbour getNeighbour() //returns a neighbouring asteroid
	{
		System.out.println("getNeighbour()");
		return neighbouringAsteroid;
	}
	
	public void setActive(boolean b) // enables the usage of the gates
	{
		System.out.println("setActive(b)");
		active = b;
	}
	
	public void underUse(Traveller t) // removes the teleportating unit from the 1st gate and places it to the 2nd gate if the gate is active(in operation)
	{
		System.out.println("underUse(t)");
		if (active) {
			neighbouringAsteroid.removeTraveller(t);
			Asteroid a2 = (Asteroid) pair.getNeighbour();
			a2.placeTraveller(t);
		}
	}
	
	@Override
	public void placeTraveller(Traveller t) //Sets a travelller (settler/robot) on the asteroid
	{
		System.out.println("placeTraveller(t)");
		neighbouringAsteroid.placeTraveller(t);
	}
	
	@Override
	public void removeTraveller(Traveller t) //Removes a traveller from the asteroid
	{
		System.out.println("removeTraveller(t)");
		neighbouringAsteroid.removeTraveller(t);
	}

	@Override
	public void addNeighbour(INeighbour a1) //sets a neighbouring asteroid
	{
		System.out.println("addNeighbour(a1)");
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
		System.out.println("removeNeighbour(a2)");
		neighbouringAsteroid = null;
	}
	
}
