package traveller;

import java.util.*;
import neighbour.*;
import game.*;

public class Robot extends Traveller{
    //for when asteroid explode
    @Override
    public void underExplosion(){
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

