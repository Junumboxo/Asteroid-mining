package neighbour;

public class Gate {
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
		neighbouringAsteroid.removeTraveller(t);
		Asteroid a2 = (Asteroid) pair.getNeighbour();
		a2.addTraveller(t);
	}
}
