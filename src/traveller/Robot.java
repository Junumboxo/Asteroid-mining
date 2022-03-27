package traveller;

import java.util.*;
import neighbour.*;

public class Robot extends Traveller{
    //robot constructor
    public Robot(Asteorid a;Game game){
        super.game=game;
        super.currentAsteroid=a;
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
    public void travel(){ //Requirement R40, R39
    	System.out.println("travel()");
        int i = 0;
        Asteroid a2 = (Asteroid) currentAsteroid.getNeighbour(i);
        currentAsteroid.removeTraveller(this);
        a2.placeTraveller(this);
    }
}

