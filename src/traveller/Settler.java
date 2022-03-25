package traveller;

import java.util.*;
import neighbour.*;
public class Settler {
    Resource[ ] resourceonboard = new Resource[10];
    int resourceonboardsize=0;
        public void travel(Asteroid a){
        
    }
        public void mine(){
        
    }
        public void createRobot(){
        
    }
        public void creatGate(){
        
    }
        public void deployGate(Gate g){
        
    }
        public void removeResource(Resource r){
        
    }
        public void pickUpResource(){
            Resource res =super.currentasteroid.getResource();
            if (resourceonboardsize==10){
                System.out.print("settler is full");
            }
            else{
                resourceonboard[resourceonboardsize]=res;
                resourceonboardsize++;
                super.currentasteroid.removeResource();
            }

        
    }
        public Resource[] getResource(){
            return(resourceonboard);
        
    }
     public void die(){
         resourceonboard=null;
         resourceonboardsize=0;
         super.isalive=false;
        
    }

}