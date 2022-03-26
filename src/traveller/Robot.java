package traveller;

import java.util.*;
import neighbour.*;
public class Robot {
    //robot constructor
    public Robot(Asteorid a;Game game){
        super.game=game;
        super.currentAsteroid=a;
    }
    //travel method
    public void travel(){
        do{
        System.out.println("Enter the direction with number between 1 and 4:\n ");
        Scanner s = new Scanner(System.in);
        i = s.nextInt();
        }while((i>0)&&(i<5))
        Asteorid a= getNeighbour( i);
        currentAsteroid.removeTraveller(Traveller t);
        currentasteroid=a;
        currentAsteroid.placeTraveller(Traveller t);
        
    }
    //for when asteroid explode
    @Override
    public void underexplosion(){
        this.travel();
    }
    //robot dies
    @Override
	public void die() {
        super.game.removeRobot(this);
    }

}
//blablabla