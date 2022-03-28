package resource;
import neighbour.*;


public abstract class Resource {
	
	protected String type;
	
	public abstract void exposed(Asteroid a);
	
	public String getType()
	{
		return type;
	}
}