package main;

import java.nio.file.FileSystemNotFoundException;
import java.util.*;
import game.Game;
import neighbour.*;
import resource.*;
import sun.*;
import traveller.*;

public class Main {

	public static void main(String[] args) {
		//initiating the game
		Game game = new Game();
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the game! Choose one integer");
		System.out.println("1. Start the game");
		System.out.println("2. Exit the game");
		int input = Integer.parseInt(in.nextLine());
		while (input != 1)
		{
			if (input == 2)
				System.out.println("Exit from the application");
				System.exit(0);
			System.out.println("Invalid option! Try again!");
			input = Integer.parseInt(in.nextLine());
		}
		game.startGame();
		Sun sun = game.getSun();
		
		/*
		 *  Asteroid A1 = sun.getAsteroids().get(0); Asteroid A2
		 * = sun.getAsteroids().get(1); Traveller t = new Traveller(); t.setGame(game);
		 * Settler s = game.getSettlers().get(0); Resource r = new Carbon(); Robot robot
		 * = new Robot(); Gate g1 = new Gate(); Gate g2 = new Gate(); //setting up Gates
		 * for Traveler Teleport!!! g1.setPair(g2);
		 */
		
		
		
		System.out.print("Create Asteroids ");
		ArrayList<Asteroid> asts = new ArrayList<Asteroid>();
		input = Integer.parseInt(in.nextLine());
		System.out.println(input + " Asteroids created");
		for (int i = 0; i < input; i++)
		{
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
			System.out.print("Depth set ");
			asts.get(i).setDepth(Integer.parseInt(in.nextLine()));
		}
		sun.addAsteroids(asts);
		
		System.out.println("Set asteroid neighbours");
		for (int i = 0; i < asts.size(); i++)
		{
			System.out.println("Finish with -1. Add neighbours to " + i);
			input = Integer.parseInt(in.nextLine());
			while (input != -1)
			{
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
		ArrayList<Settler> settlers = new ArrayList<Settler>();
		input = Integer.parseInt(in.nextLine());
		System.out.println(input + " Settlers created");
		for (int i = 0; i < input; i++)
		{
			settlers.add(new Settler());
			game.addSettler(settlers.get(i));
			asts.get(0).placeTraveller(settlers.get(i));
		}
		
		
		System.out.println("All set!");
		Iterator<Settler> it = settlers.iterator();
		
		while(it.hasNext()) {
			  Settler currentSettler = it.next();
			  System.out.println("It is the turn of settler " + settlers.indexOf(currentSettler));
			  if (!it.hasNext())
				  it = settlers.iterator();
		}
		
		/*
		 * // Command inputed must be identical to the one mentioned in the
		 * documentation 5.2 !!! while (in.hasNext()) { while(true) { String
		 * input_command = in.nextLine(); switch(input_command.toLowerCase()) { case
		 * "control asteroids" : System.out.println("Control Asteroids command:");
		 * sun.getAsteroids();
		 * 
		 * System.out.
		 * println("Enter 'p' if you want to set Perihelion on asteroid and 'a' if you want to set Aphelion"
		 * ); String answ = in.nextLine(); if (answ.equals("p")) A1.setPerihelion(true);
		 * else A1.setPerihelion(false); break;
		 * 
		 * case "settler travels" :
		 * System.out.println("Settler travels to asteroid A1 command:"); s.travel(A1);
		 * break;
		 * 
		 * case "traveler drills" : System.out.println("Traveler drills command:");
		 * A1.setDepth(5); //s.drill() break;
		 * 
		 * case "settler mines" : System.out.println("Settler mines command:"); //same
		 * question as in the pick up Carbon c = new Carbon(); A1.addResource(c);
		 * s.mine(); //possible failures are called in mine() method break;
		 * 
		 * case "pick up resource" : System.out.println("Pick Up Resource command:");
		 * //Carbon c = new Carbon(); //A1.addResource(c); //maybe it is a good idea to
		 * add a resource //because so far we dont initialize resources anywhere
		 * s.pickUpResource(); //possible failures are called in pickUpResource() method
		 * break;
		 * 
		 * case "drop resource" : System.out.println("Drop Resource command:");
		 * s.removeResource(r); //possible failures are called in removeResource()
		 * method break;
		 * 
		 * case "hide" : System.out.println("Hide command:"); //s.hide(); break;
		 * 
		 * case "create robot" : System.out.println("Create Robot:"); s.createRobot();
		 * break;
		 * 
		 * case "create transport gate" : s.createGate(); break;
		 * 
		 * case "deploy" : s.deployGate(g1); break;
		 * 
		 * case "robot teleport" : t.teleport(g1); break;
		 * 
		 * case "settler teleport" : s.teleport(g1); break; case "check win" :
		 * game.winGame(); break; case "check lose" : game.loseGame(); break; case
		 * "remove settler" : game.removeSettler(s); break;
		 * 
		 * case "sunstorm" : System.out.println("Sunstorm command:"); //Sun sun = new
		 * Sun(); sun.sunstorm(); break; case "view inventory": s.setInventory(); for
		 * (Resource res : s.getResources()) { if (res != null)
		 * System.out.println(res.getType()); } break;
		 * 
		 * case "uranium explodes" : System.out.println("Uranium explodes command:");
		 * Uranium u1 = new Uranium(); A1.addResource(u1); Settler s1 = new Settler();
		 * s1.setGame(game); A1.placeTraveller(s1);
		 * 
		 * Robot r1 = new Robot(); s1.setGame(game); A1.placeTraveller(r1);
		 * 
		 * A1.setPerihelion(true);
		 * 
		 * break;
		 * 
		 * case "water evaporates" : System.out.println("Water evaporates command:");
		 * Water w = new Water(); A2.addResource(w); A2.setPerihelion(true); break;
		 * 
		 * case "robot under explosion" :
		 * System.out.println("robot under explosion command:"); Uranium u2 = new
		 * Uranium(); A1.addResource(u2); A1.placeTraveller(robot); A1.setDepth(1);
		 * s.drill(); A1.setPerihelion(true); break;
		 * 
		 * default: System.out.println("The command is invalid!"); break; } }
		 * 
		 * }
		 */
		in.close();
	}
}
