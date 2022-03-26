package traveller;

import java.util.*;
import neighbour.*;
public class Settler {
    Resource[ ] resourceonboard = new Resource[10];
    int resourceonboardsize=0;
    gate g1=null;
    gate g2=null;
        public void travel(Asteroid a){
        Random rand = new Random();
        int i = rand.nextInt(5);
        Asteorid a= getNeighbour( i);
        currentAsteroid.removeTraveller(Traveller t);
        currentasteroid=a;
        currentAsteroid.placeTraveller(Traveller t);
    }
    //mine method
        public void mine(){
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
    //createRobot method
        public void createRobot(){
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
    //creatGate method
        public void creatGate(){
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
    //deployGate method
        public void deployGate(Gate g){
            g.addNeighbour(super.currentAsteroid)
            Asteroid a=g.getPair().getNeighbour();
            if(a){g.setActive(true);g.getPair().setActive(true);}

    }
    //removeResource method
        public void removeResource(Resource r){
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
             super.currentAsteroid.addResource(r); }
    }
    //pickUpResource method
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
    //getResource method
        public Resource[] getResource(){
            return(resourceonboard);
        
    }
    //settler dies
    @Override
     public void die(){
         resourceonboard=null;
         resourceonboardsize=0;
         super.game.removeSettler(this);
        
    }
    //for when asteroid explode
    @Override
    public void underexplosion(){
        this.die();
    }

}
//blablabla