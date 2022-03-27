package traveller;

import java.util.*;
import neighbour.*;
import resource.*;

public class Settler extends Traveller{
    Resource[] resourcesOnBoard = new Resource[10]; // Requirement R23
    gate g1=null;
    gate g2=null; // Requirement R49
    int resourcesOnBoardSize = 0; // at the start of the game settler has no resources
    
    public void travel(Asteroid a){//Requirement R15 
        currentAsteroid.removeTraveller(Traveller t);
        currentasteroid=a;
        currentAsteroid.placeTraveller(Traveller t);
    }
    public void mine(){ //Requirement R21 
        System.out.println("mine()");
         Resource res =super.currentasteroid.getResource();
            if (resourceonboardsize==10){
                System.out.print("settler is full");
            }
            else{
                resourceonboard[resourceonboardsize]=res;
                resourceonboardsize++;
                super.currentasteroid.removeResource();
    }
    public void createRobot(){ //Requirement R38 
        System.out.println("createRobot()");
        int nbiron=0;int nbcarbon=0;int nburanieum=0;
            boolean check=false;
            for(int i=0;i<resourceonboardsize;i++){
                if resourceonboard[i].type.equals("Iron"){
                nbiron++;}
                else if resourceonboard[i].type.equals("carbon"){
                nbcarbon++;}
                else if resourceonboard[i].type.equals("uranium"){
                nburanieum++;}
            }
            if((nbcarbon>1)&&(nbiron>1)&&(nburanieum>1)){
                super.game.addRobot(new Robot(super.currentAsteroid,super.game));
                for(int i=0;i<resourceonboardsize;i++){
                 check=false;
                 if resourceonboard[i].type.equals("Iron"){
                 for(int y=i;y<resourceonboardsize-1;y++){
                 resourceonboard[y]=resourceonboard[y+1];
                 }
                 resourceonboard[resourceonboardsize-1]=null;
                 resourceonboardsize--;
                }
                if (check=true)break;
                }
                for(int i=0;i<resourceonboardsize;i++){
                  check=false;
                 if resourceonboard[i].type.equals("carbon"){
                 for(int y=i;y<resourceonboardsize-1;y++){
                 resourceonboard[y]=resourceonboard[y+1];
                 }
                 resourceonboard[resourceonboardsize-1]=null;
                 resourceonboardsize--;
                }
                if (check=true)break;
                }
                for(int i=0;i<resourceonboardsize;i++){
                 check=false;
                 if resourceonboard[i].type.equals("uranium"){
                 for(int y=i;y<resourceonboardsize-1;y++){
                 resourceonboard[y]=resourceonboard[y+1];
                 }
                 resourceonboard[resourceonboardsize-1]=null;
                 resourceonboardsize--;
                }
                if (check=true)break;
                }
            }
    }
    public void createGate(){ //Requirement R46
        System.out.println("createGate()");
         int nbiron=0;int nbwater=0;int nburanieum=0;
            boolean check=false;
            for(int i=0;i<resourceonboardsize;i++){
                if resourceonboard[i].type.equals("Iron"){
                nbiron++;}
                else if resourceonboard[i].type.equals("water"){
                nbcarbon++;}
                else if resourceonboard[i].type.equals("uranium"){
                nburanieum++;}
            }
            if((nbwater>1)&&(nbiron>2)&&(nburanieum>1)){
                this.g1=new Gate();
                this.g2=new Gate();
                this.g1.setPair(g2);
                this.g2.setPair(g1);
               for(int w=0;w<2;w++){
                for(int i=0;i<resourceonboardsize;i++){
                 check=false;
                 if resourceonboard[i].type.equals("Iron"){
                 for(int y=i;y<resourceonboardsize-1;y++){
                 resourceonboard[y]=resourceonboard[y+1];
                 }
                 resourceonboard[resourceonboardsize-1]=null;
                 resourceonboardsize--;
                }
                if (check=true)break;
                }}
                for(int i=0;i<resourceonboardsize;i++){
                  check=false;
                 if resourceonboard[i].type.equals("water"){
                 for(int y=i;y<resourceonboardsize-1;y++){
                 resourceonboard[y]=resourceonboard[y+1];
                 }
                 resourceonboard[resourceonboardsize-1]=null;
                 resourceonboardsize--;
                }
                if (check=true)break;
                }
                for(int i=0;i<resourceonboardsize;i++){
                 check=false;
                 if resourceonboard[i].type.equals("uranium"){
                 for(int y=i;y<resourceonboardsize-1;y++){
                 resourceonboard[y]=resourceonboard[y+1];
                 }
                 resourceonboard[resourceonboardsize-1]=null;
                 resourceonboardsize--;
                }
                if (check=true)break;
                }
    }
    public void deployGate(Gate g){ 
        System.out.println("deployGate(g)");
        g.addNeighbour(super.currentAsteroid)
            Asteroid a=g.getPair().getNeighbour();
            if(a){g.setActive(true);g.getPair().setActive(true);}
    }
    public void removeResource(Resource r){
        System.out.println("removeResource(r)");
         if( super.currentAsteroid.isHollow){
            boolean check=false;
            for(int i=0;i<resourceonboardsize;i++){
                 if resourceonboard[i].type.equals(r.type){
                 for(int y=i;y<resourceonboardsize-1;y++){
                 resourceonboard[y]=resourceonboard[y+1];
                 }
                 resourceonboard[resourceonboardsize-1]=null;
                 resourceonboardsize--;
                }
                if (check=true)break;
                }
             super.currentAsteroid.addResource(r);
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
    	return(resourcesOnBoards);
        
    }
     public void die(){ 	//Requirement R36
    	 System.out.println("die()");
    	 resourcesOnBoard=null;
         resourcesOnBoardSize=0;
         game.removeSettler(this);
    }

}
