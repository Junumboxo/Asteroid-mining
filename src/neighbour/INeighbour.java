package neighbour;

public interface INeighbour {
	public void placeTraveller(Traveller t);
	public void addNeighbour(INeighbour n);
	public void removeNeighbour(INeighbour n);
}
