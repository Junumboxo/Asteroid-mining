package controller;

import java.nio.file.FileSystemNotFoundException;
import java.util.*;
import game.Game;
import neighbour.*;
import resource.*;
import sun.*;
import traveller.*;

public class Controller {

	private Game game;
	private Sun sun;
	private List<Asteroid> asts;
	private List<Settler> settlers;
	private Iterator<Settler> it;
	private Gate g1, g2;
	private Scanner in;
	int input;
	
	public Controller() {
		// initiating the game
		game = new Game();
		in = new Scanner(System.in);
		System.out.println("Welcome to the game! Choose one integer");
		System.out.println("1. Start the game");
		System.out.println("2. Exit the game");
		input = Integer.parseInt(in.nextLine());
		while (input != 1) {
			if (input == 2)
				System.out.println("Exit from the application");
			System.exit(0);
			System.out.println("Invalid option! Try again!");
			input = Integer.parseInt(in.nextLine());
		}
		game.startGame();
		sun = game.getSun();

		System.out.print("Create Asteroids ");
		asts = new ArrayList<Asteroid>();
		input = Integer.parseInt(in.nextLine());
		System.out.println(input + " Asteroids created");
		for (int i = 0; i < input; i++) {
			asts.add(new Asteroid());
			System.out.print("Set Resource ");
			switch (in.nextLine()) {
			case "Iron":
				asts.get(i).addResource(new Iron());
				break;
			case "Water":
				asts.get(i).addResource(new Water());
				break;
			case "Uranium":
				asts.get(i).addResource(new Uranium());
				break;
			case "Carbon":
				asts.get(i).addResource(new Carbon());
				break;
			default:
				System.out.println("Resource could not be added!");
			}
			System.out.print("Set Depth ");
			asts.get(i).setDepth(Integer.parseInt(in.nextLine()));
		}
		sun.addAsteroids(asts);

		System.out.println("Set asteroid neighbours");
		for (int i = 0; i < asts.size(); i++) {
			System.out.println("Finish with -1. Add neighbours to Asteroid " + i);
			input = Integer.parseInt(in.nextLine());
			while (input != -1) {
				if (input < asts.size())
					asts.get(i).addNeighbour(asts.get(input));
				else
					System.out.println("Invalid index");
				input = Integer.parseInt(in.nextLine());
			}
			System.out.println("Neighbours of " + i);
			for (int j = 0; j < asts.get(i).getNeighbours().size(); j++)
				System.out.println(asts.indexOf(asts.get(i).getNeighbours().get(j)) + " ");
		}

		System.out.print("Create Settlers ");
		settlers = new ArrayList<Settler>();
		input = Integer.parseInt(in.nextLine());
		System.out.println(input + " Settlers created");
		for (int i = 0; i < input; i++) {
			settlers.add(new Settler());
			game.addSettler(settlers.get(i));
			asts.get(0).placeTraveller(settlers.get(i));
		}

		System.out.println("All set!");
		it = settlers.iterator();
		
		g1 = new Gate(); g2 = new Gate();
		g1.setPair(g2);
		g2.setPair(g1);
		g1.addNeighbour(asts.get(0));
		g2.addNeighbour(asts.get(1));
		
	}
	
	public void takeAction(String action) {
		while (it.hasNext()) {
			Settler currentSettler = it.next();
			System.out.println("It is the turn of settler " + settlers.indexOf(currentSettler));
			Asteroid currentAsteroid = currentSettler.getAsteroid();

			switch(action) {
			  case "travel" :
				  System.out.println("Choose a neighbour to travel to:");
				  for (int j = 0; j < currentAsteroid.getNeighbours().size(); j++)
						System.out.println(asts.indexOf(currentAsteroid.getNeighbours().get(j)) + " ");
				  input = Integer.parseInt(in.nextLine());
				  if (currentAsteroid.getNeighbours().contains(asts.get(input)))
					  currentSettler.travel(asts.get(input));
				  break;
			  
			  case "drill" : 
				  currentSettler.drill();
				  break;
			
			  case "mine" :
				  currentSettler.mine();
				  break;
			  
			  case "pick up" :
				  currentSettler.pickUpResource(); //possible failures are called in pickUpResource() method
				  break;
			  
			  case "drop" :
				  input = Integer.parseInt(in.nextLine()); //index of the resource to drop
				  currentSettler.removeResource(currentSettler.getResources().get(input)); //possible failures are called in removeResource()
				  break;
			  
			  case "settler hide" :
				  currentSettler.hide(currentAsteroid);
				  break;
			  
			  case "build robot" :
				  currentSettler.createRobot();
				  break;
			  
			  case "build gate" :
				  currentSettler.createGate();
				  break;
			  
			  case "deploy gate" :
				  currentSettler.deployGate();
				  break;
			  
			  case "robot teleport" :
				  Robot r1 = new Robot();
				  game.addRobot(r1);
				  asts.get(0).placeTraveller(r1);
				  r1.teleport(g1);
				  break;
			  
			  case "settler teleport" :
				  currentSettler.setAsteroid(asts.get(0));
				  currentSettler.teleport(g1);
				  break;
			  case "check win" :
				  game.winGame();
				  break;
			  case "check lose" : 
				  game.loseGame();
				  break;
			  case "remove settler" :
				  game.removeSettler(currentSettler);
				  break;
			  case "sunstorm" :
				  sun.sunstorm();
				  break;
			  case "view inventory":
				  //currentSettler.setInventory();
				  for (Resource res : currentSettler.getResources())
				  { if (res != null)
					  System.out.println(res.getType()); }
				  break;
			  
			  case "uranium explodes" :
				  Robot r = new Robot();
				  game.addRobot(r);
				  currentAsteroid.placeTraveller(r);
				  Uranium u1 = new Uranium();
				  currentAsteroid.removeResource();
				  currentAsteroid.addResource(u1);
				  currentAsteroid.setDepth(1);
				  currentAsteroid.setPerihelion(true);
				  currentSettler.drill();
				  break;
			  
			  case "water evaporates" : 
				  Water w = new Water();
				  currentAsteroid.removeResource();
				  currentAsteroid.addResource(w);
				  currentAsteroid.setDepth(1);
				  currentAsteroid.setPerihelion(true);
				  currentSettler.drill();
				  break;
			  
			  default:
				  System.out.println("The command is invalid!"); 
				  break;
				}  
			
			if (!it.hasNext())
				it = settlers.iterator();
		}

		in.close();
	}
}
