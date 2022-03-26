package traveller;

import java.util.*;
import neighbour.*;
import resource.*;

public class Settler extends Traveller{
    Resource[] resourcesOnBoard = new Resource[10];
    Gate[] gatesOnBoard = new Gate[2];
    int resourcesOnBoardSize = 0;
    
    public void travel(Asteroid a){
        
    }
    public void mine(){
        
    }
    public void createRobot(){
        
    }
    public void createGate(){
        
    }
    public void deployGate(Gate g){
        
    }
    public void removeResource(Resource r){
        
    }
    public void pickUpResource()         //picking the resource
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
    public Resource[] getResources(){
         return(resourcesOnBoard);
        
    }
     public void die(){
    	 resourcesOnBoard=null;
         resourcesOnBoardSize=0;
         game.removeSettler(this);
    }

}
