package traveller;

import java.util.*;
import neighbour.*;
import resource.*;

public class Settler extends Traveller{
    Resource[] resourcesOnBoard = new Resource[10]; // Requirement R23
    Gate[] gatesOnBoard = new Gate[2]; // Requirement R49
    int resourcesOnBoardSize = 0; // at the start of the game settler has no resources
    
    public void travel(Asteroid a){//Requirement R15 
        System.out.println("travel(a)");
    }
    public void mine(){ //Requirement R21 
        System.out.println("mine()");
    }
    public void createRobot(){ //Requirement R38 
        System.out.println("createRobot()");
    }
    public void createGate(){ //Requirement R46
        System.out.println("createGate()");
    }
    public void deployGate(Gate g){ 
        System.out.println("deployGate(g)");
    }
    public void removeResource(Resource r){
        System.out.println("removeResource(r)");
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
