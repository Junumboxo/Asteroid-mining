package traveller;

import java.util.*;
import neighbour.*;
import resource.*;

public class Settler extends Traveller{
    List<Resource> resourcesOnBoard = new ArrayList<Resource>(); // Requirement R23
    boolean current = false;
    Gate g1=null;
    Gate g2=null; // Requirement R49
  

    public void deployGate(){
    	if (g1 != null)
    	{
    		g1.addNeighbour(currentAsteroid);
    		g1 = null;
    		System.out.println("Deployed");
    	}
    	else if (g2 != null)
    	{
    		g2.addNeighbour(currentAsteroid);
    		g2 = null;
    		System.out.println("Deployed");
    	} else System.out.println("no gates to deploy");
   
    }
    public void travel(Asteroid a){//Requirement R15 
        currentAsteroid.removeTraveller(this);
        a.placeTraveller(this);
        System.out.println("Travelled successfully");
    }
    
    public void setCurrent(boolean c)
    {
    	current = c;
    }
    
    public void setInventory()
    {
    	resourcesOnBoard.clear();
    	resourcesOnBoard.add(new Iron());
    	resourcesOnBoard.add(new Iron());
    	resourcesOnBoard.add(new Carbon());
    	resourcesOnBoard.add(new Uranium());
    	resourcesOnBoard.add(new Water());
    }

    
    public void mine(){ //Requirement R21 
        //System.out.println("mine()");
       	currentAsteroid.extract(this);
       	System.out.println("Settler mined");
    }

        
        public void createRobot(){ //Requirement R38 
        	setInventory();
        	int ironCount = 0;
        	int carbonCount = 0;
        	int uraniumCount = 0;
        	for ( Resource r : this.getResources())
        	{
        		if (r instanceof Iron) ironCount++;
        		if (r instanceof Water) carbonCount++;
        		if (r instanceof Uranium) uraniumCount++;
        	}
        	if (ironCount>= 1 && carbonCount >= 1 && uraniumCount>= 1) {
        		Robot robot = new Robot();
        		currentAsteroid.placeTraveller(robot);
        		game.addRobot(robot);
        		System.out.println("Robot created");
            	for ( Resource r : this.getResources())
            		if (r instanceof Iron) {resourcesOnBoard.remove(r); break;}
            	for ( Resource r : this.getResources())
            		if (r instanceof Carbon) {resourcesOnBoard.remove(r); break;}
            	for ( Resource r : this.getResources())
            		if (r instanceof Uranium) {resourcesOnBoard.remove(r); break;}
        	}
        	else 
        		System.out.println("Not enough resources to create Robot");
        }
        public void createGate(){ //Requirement R46
        	setInventory();
        	
        	int ironCount = 0;
        	int waterCount = 0;
        	int uraniumCount = 0;
        	for ( Resource r : this.getResources())
        	{
        		if (r instanceof Iron) ironCount++;
        		if (r instanceof Water) waterCount++;
        		if (r instanceof Uranium) uraniumCount++;
        	}
        	if (ironCount>= 2 && waterCount >= 1 && uraniumCount>= 1) {
        		g1 = new Gate();
        		g2 = new Gate();
        		g1.setPair(g2);
        		g2.setPair(g1);
        		for ( Resource r : this.getResources())
            		if (r instanceof Iron) {resourcesOnBoard.remove(r); break;}
        		for ( Resource r : this.getResources())
            		if (r instanceof Iron) {resourcesOnBoard.remove(r); break;}
            	for ( Resource r : this.getResources())
            		if (r instanceof Water) {resourcesOnBoard.remove(r); break;}
            	for ( Resource r : this.getResources())
            		if (r instanceof Uranium) {resourcesOnBoard.remove(r); break;}
        		System.out.println("Transport Gate created");
        	}
        	else 
        		System.out.println("Not enough resources to create Transport Gate");
        } 
    
    public void removeResource(Resource r){
   		if (currentAsteroid.addResource(r)) {
   			resourcesOnBoard.remove(r);
   			System.out.println("Resource dropped");
   		}  else System.out.println("Resource cannot be dropped");
    }
    
    
    public void pickUpResource()         //Requirement R55 - picking the resource
    {
    	//System.out.println("pickUpResource()");
        Resource res = currentAsteroid.getResource();
   
        if (res == null) {
        	System.out.println("Resource cannot be picked up");
        	return;
        }
   		if (resourcesOnBoard.size() < 10) {
   			resourcesOnBoard.add(res);
   			currentAsteroid.removeResource();
   			System.out.println("Resource picked up: " + res.getType());
   		}
   		else { 
   			System.out.println("The capacity is reached");
   		}    
    }

    public List<Resource> getResources(){ // gives the current number of resources on board
        //System.out.println("getResources()");
    	return(resourcesOnBoard);
        
    }
    
    public void underExplosion(){
    	die();
    }
    
     public void die(){ 	//Requirement R36
    	 resourcesOnBoard=null;
         currentAsteroid.removeTraveller(this);
         game.removeSettler(this);
         System.out.println("Settler died");
    }

}
