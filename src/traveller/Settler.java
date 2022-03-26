package traveller;

import java.util.*;
import neighbour.*;
import resource.*;

public class Settler extends Traveller{
    Resource[] resourcesOnBoard = new Resource[10]; // Requirement R23
    Gate[] gatesOnBoard = new Gate[2]; // Requirement R49
    int resourcesOnBoardSize = 0; // at the start of the game settler has no resources
    
    public void travel(Asteroid a){//Requirement R15 
        
    }
    public void mine(){ //Requirement R21 
        
    }
    public void createRobot(){ //Requirement R38 
        
    }
    public void createGate(){ //Requirement R46
        
    }
    public void deployGate(Gate g){ 
        
    }
    public void removeResource(Resource r){
        
    }
    public void pickUpResource()         //Requirement R55 - picking the resource
    {
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
         return(resourcesOnBoard);
        
    }
     public void die(){ 	//Requirement R36
    	 resourcesOnBoard=null;
         resourcesOnBoardSize=0;
         game.removeSettler(this);
    }

}
