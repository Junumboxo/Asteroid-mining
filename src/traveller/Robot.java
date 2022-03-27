package traveller;

import java.util.*;
import neighbour.*;
public class Robot extends Traveller{
	
    public void travel(){ //Requirement R40, R39
    	System.out.println("travel()");
        int i = 0;
        Asteroid a2 = (Asteroid) currentAsteroid.getNeighbour(i);
        currentAsteroid.removeTraveller(this);
        a2.placeTraveller(this);
    }
    
    public void die() { // robot dies
    	System.out.println("die()");
    	game.removeRobot(this);
    }

}