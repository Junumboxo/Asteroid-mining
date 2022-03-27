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
        deployGate(g);
    }
   
    public void travel(Asteroid a){//Requirement R15 
        currentAsteroid.removeTraveller(this);
        currentAsteroid=a;
        currentAsteroid.placeTraveller(this);
    }

    
    public void mine(){ //Requirement R21 
        System.out.println("mine()");
        System.out.println("Is the capacity reached? yes or no");
       		Scanner in = new Scanner(System.in);
       		String answ = in.nextLine();
       		//checking winning condition
       		if (answ.equals("no")) {
       			currentAsteroid.extract(this);
       		}
       		else { 
       			System.out.println("The capacity is reachd");
       		}
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
            System.out.println("createGate()");
            System.out.println("Are there enough resources? yes or no");
           		Scanner in = new Scanner(System.in);
           		String answ = in.nextLine();
           		//checking winning condition
           		if (answ.equals("yes")) {
           			Gate g1 = new Gate();
           			Gate g2 = new Gate();
           			g1.setPair(g2);
           			g2.setPair(g1);
           		}
           		else { 
           			System.out.println("Not enough resources!");
           		}
        }
        
        
    
    public void removeResource(Resource r){
        System.out.println("removeResource(r)");
        currentAsteroid.addResource(r);
    }
    
    
    public void pickUpResource()         //Requirement R55 - picking the resource
    {
    	System.out.println("pickUpResource()");
        Resource res = currentAsteroid.getResource();
        if (resourcesOnBoardSize==10){
            System.out.print("settler is full");
        }
        else{
            resourcesOnBoard[resourcesOnBoardSize]=res;
            resourcesOnBoardSize++;
            currentAsteroid.removeResource();
        }      
    }

    public Resource[] getResources(){ // gives the current number of resources on board
        System.out.println("getResources()");
    	return(resourcesOnBoard);
        
    }
     public void die(){ 	//Requirement R36
    	 System.out.println("die()");
    	 resourcesOnBoard=null;
         resourcesOnBoardSize=0;
         game.removeSettler(this);
    }

}
