package traveller;

import java.util.*;
import neighbour.*;
public class Robot extends Traveller{
	
    public void travel(){
        int i = 0;
        Asteroid a2 = (Asteroid) currentAsteroid.getNeighbour(i);
        currentAsteroid.removeTraveller(this);
        a2.placeTraveller(this);
    }
    
    public void die() {
    	game.removeRobot(this);
    }

}