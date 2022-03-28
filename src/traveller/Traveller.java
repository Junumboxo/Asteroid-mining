package traveller;
import java.util.*;
import neighbour.*;
import game.*;

public class Traveller {
	protected Asteroid currentAsteroid;
	protected Game game;
	
	public Traveller(){
		currentAsteroid = new Asteroid();
		//game = new Game(); // !!!!!!!!
	}
	public void drill() { // R20, R41, R31, traveller drills 
		System.out.println("drill()");
        System.out.println("What is the depth of the mantle? Enter number between 1 and 3");
   		Scanner in = new Scanner(System.in);
   		String answ = in.nextLine();
   		//checking winning condition
   		this.currentAsteroid.setDepth(Integer.parseInt(answ));
		this.currentAsteroid.decreaseDepth();
		System.out.println("The remaining rock depth is " + currentAsteroid.getDepth());
		
	}
	public void hide(Asteroid a) { // R29, R32, R45, traveller hides
		System.out.println("hide(a)");
		currentAsteroid.setHollow(false);
		System.out.println("Traveller has been hidden");
	}
	public void teleport(Gate g) { // traveller teleports
		System.out.println("teleport(g)");
		g.underUse(this);
	
	}
	public void setAsteroid(Asteroid a) {     //R05 
		System.out.println("setAsteroid()");
		this.currentAsteroid=a;
		
	}
	public Asteroid getAsteroid() {
		System.out.println("getAsteroid()");
		return (this.currentAsteroid);
	}
	
	public void setGame(Game g){
		game = g;
	}
	
	public void underExplosion(){System.out.println("underExplosion()");} // R34, R35,  traveller is under exlosion
	public void die() {System.out.println("die()");} // traveller dies
}
