package game;

import java.util.ArrayList;
import java.util.Scanner;

import traveller.Robot;
import sun.Sun;
import traveller.Settler;
import neighbour.Asteroid;
import resource.*;

public class Game {
	private ArrayList<Robot> robots;
	private ArrayList<Settler> settlers;
	private Sun sun;

	// constructor
	public Game() {
		robots =new ArrayList<Robot>();
		settlers = new ArrayList<Settler>();
	}

	public ArrayList<Robot> getRobots() {
        System.out.println("getRobots()");
		return this.robots;
    }
	public void addRobot(Robot r) {
		System.out.println("addRobot()");
		robots.add(r);
	}
	public void removeRobot(Robot r) {
		System.out.println("removeRobot(r)");
		robots.remove(r);
	}

	public ArrayList<Settler> getSettlers() {
        System.out.println("getSettlers()");
		return this.settlers;
    }
	public void addSettler(Settler s) {
		System.out.println("addSettler(s)");
		settlers.add(s);
	}
	public void removeSettler(Settler s) {
		System.out.println("removeSettler(s)");
		settlers.remove(s);
	}
	
	public Sun getSun() {
		return sun;
	}
	
	/*Method startGame() adds asteroids and positions them on the playing field.
	  Then fills each asteroid with a resource. Settlers are positioned on 
	  arbitrary asteroids by method addTraveller()*/
	public void startGame() {
		System.out.println("startGame()");
		//adding asteroids
		ArrayList<Asteroid> listOfAsteroids = new ArrayList <Asteroid>();
		Asteroid A = new Asteroid ();
		Asteroid A2 = new Asteroid();
		listOfAsteroids.add(A);
		listOfAsteroids.add(A2);
		A.addNeighbour(A2);
		sun = new Sun();
		sun.addAsteroids(listOfAsteroids);

		//adding resources to the asteroids
		/*
		 * Resource r = new Iron(); A.addResource(r);
		 */
		
		//setting asteroids on the playing field and adding settlers on asteroids
		Settler s = new Settler(); // do the extend of settler from traveler!
		s.setGame(this);
		A.addTraveler(s);
		A.placeTraveller(s);
		this.addSettler(s);
	}

	//Requirement R58
	public void winGame() {
		int ironCount = 0;
    	int waterCount = 0;
    	int uraniumCount = 0;
    	int carbonCount = 0;
    	for (Settler s: settlers)
	    	for ( Resource r : s.getResources())
	    	{
	    		if (r instanceof Iron) ironCount++;
	    		if (r instanceof Water) waterCount++;
	    		if (r instanceof Uranium) uraniumCount++;
	    		if (r instanceof Carbon) carbonCount++;
	    	}
		if (ironCount == 3 && waterCount == 3 && uraniumCount == 3 && carbonCount == 3)
			System.out.println("Game won");
		else 
			System.out.println("Game not won yet\r\n");
	}

	//Requirement R56
	public void loseGame() {
		if (settlers.size() == 0)
			System.out.println("Game lost");
		else 
			System.out.println("Game not lost yet");
	}
}