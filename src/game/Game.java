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


	public ArrayList<Robot> getRobots() {
        System.out.println("getRobots");
		return this.robots;
    }
	public void addRobot(Robot r) {
		System.out.println("addRobot()");
		robots.add(r);
	}
	public void removeRobot(Robot r) {
		System.out.println("removeRobot()");
		robots.remove(r);
	}

	public ArrayList<Settler> getSettlers() {
        System.out.println("getSettlers");
		return this.settlers;
    }
	public void addSettler(Settler s) {
		System.out.println("addSettler()");
		settlers.add(s);
	}
	public void removeSettler(Settler s) {
		System.out.println("removeSettler()");
		settlers.remove(s);
	}

	/*Method startGame() adds asteroids and positions them on the playing field.
	  Then fills each asteroid with a resource. Settlers are positioned on 
	  arbitrary asteroids by method addTraveller()*/
	public void startGame() {
		System.out.println("startGame()");
		//adding asteroids
		ArrayList<Asteroid> listOfAsteroids = new ArrayList <Asteroid>();
		Asteroid A = new Asteroid ();
		listOfAsteroids.add(A);
		sun = new Sun();
		sun.addAsteroids(listOfAsteroids);
		System.out.println("addAsteroids()");

		//adding resources to the asteroids
		Resource r = new Resource();
		A.addResource(r);
		System.out.println("addResource()");

		//setting asteroids on the playing field and adding settlers on asteroids
		Settler s = new Settler(); // do the extend of settler from traveler!
		s.setasteroid(A);
		System.out.println("setAsteroid(A)");
		A.placeTraveller(s);
		System.out.println("addTraveller(s)");
	}

	//Requirement R58
	public void winGame() {
		System.out.println("Are the resources collected enough for building space station?\n answer yes or no");
		//reading user's input from the console
		Scanner in = new Scanner(System.in);
		String answ = in.nextLine();
		//checking winning condition
		if (answ.equals("yes")) {
			System.out.println("winGame");
		}
		else { 
			System.out.println("Game not won yet");
		}
	}

	//Requirement R56
	public void loseGame() {
		System.out.println("How many settlers are alive?");
		//reading user's input from the console
		Scanner in = new Scanner(System.in);
		int answ = in.nextInt();
		//Checking losing condition
		if (answ == 0) {
			System.out.println("loseGame()");
		}
		else { 
			System.out.println("Game isn't lost");
		}
	}
}