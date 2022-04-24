package traveller;

import java.util.*;
import neighbour.*;
import resource.*;

public class Settler extends Traveller{
    Resource[] resourcesOnBoard = new Resource[10]; // Requirement R23
    Gate g1=null;
    Gate g2=null; // Requirement R49
    int resourcesOnBoardSize = 0; // at the start of the game settler has no resources  

    public void deployGate(Gate g){ 
        System.out.println("deployGate(g)");
        g.addNeighbour(currentAsteroid);
    }
   
    public void travel(Asteroid a){//Requirement R15 
        currentAsteroid.removeTraveller(this);
        currentAsteroid=a;
        currentAsteroid.placeTraveller(this);
    }

    
    public void mine(){ //Requirement R21 
        System.out.println("mine()");
       	currentAsteroid.extract(this);
    }

        
        public void createRobot(){ //Requirement R38 
            System.out.println("createRobot()");
            System.out.println("Are there enough resources? yes or no");
           		Scanner in = new Scanner(System.in);
           		String answ = in.nextLine();
           		//checking winning condition
           		if (answ.equals("yes")) {
           			Robot r = new Robot();
           			currentAsteroid.placeTraveller(r);
           			game.addRobot(r);
           		}
           		else { 
           			System.out.println("Not enough resources!");
           		}
        }
        public void createGate(){ //Requirement R46
        	resourcesOnBoard[0]= new Iron();//To be removed
        	resourcesOnBoard[1]= new Iron(); // comment to check not enough resources
        	resourcesOnBoard[2]= new Water();
        	resourcesOnBoard[3]= new Uranium();
        	
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
        		// ??????????????????????????????????????????????????????????
        		//Iron r1, r2; Water w; Uranium u;
        		//this.removeResource(r1);
        		System.out.println("Transport Gate created");
        	}
        	else 
        		System.out.println("Not enough resources to create Transport Gate");
        } 
    
    public void removeResource(Resource r){
        System.out.println("removeResource(r)");
        System.out.println("Enter the current capacity of the settler. Enter number between 0 and 10.");
   		Scanner in = new Scanner(System.in);
   		String answ = in.nextLine();
   		//checking winning condition
   		if (Integer.parseInt(answ) < 10) {
   			currentAsteroid.removeResource();
   		}
   		else { 
   			System.out.println("The capacity is reached");
   		}    
        currentAsteroid.addResource(r);
    }
    
    
    public void pickUpResource()         //Requirement R55 - picking the resource
    {
    	System.out.println("pickUpResource()");
        Resource res = currentAsteroid.getResource();
        System.out.println("Enter the current capacity of the settler. Enter number between 0 and 10.");
   		Scanner in = new Scanner(System.in);
   		String answ = in.nextLine();
   		//checking winning condition
   		if (Integer.parseInt(answ) < 10) {
   			currentAsteroid.removeResource();
   		}
   		else { 
   			System.out.println("The capacity is reached");
   		}    
    }

    public Resource[] getResources(){ // gives the current number of resources on board
        //System.out.println("getResources()");
    	return(resourcesOnBoard);
        
    }
    
    public void underExplosion(){
    	die();
    }
    
     public void die(){ 	//Requirement R36
    	 System.out.println("die()");
    	 resourcesOnBoard=null;
         resourcesOnBoardSize=0;
         currentAsteroid.removeTraveller(this);
         game.removeSettler(this);
    }

}
