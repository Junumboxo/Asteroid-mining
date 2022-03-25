
public class Asteroid {

	private boolean isPerihelion;
	private boolean isHollow;
	private int depth;
	
	
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
	
	
}
