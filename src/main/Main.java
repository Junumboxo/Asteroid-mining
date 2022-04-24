package main;

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
		System.out.println("STARTING THE GAME");
		game.startGame();
		System.out.println("THE GAME HAS STARTED");
		
		Sun sun = game.getSun();
		Asteroid A1 = sun.getAsteroids().get(0);
		Asteroid A2 = sun.getAsteroids().get(1);
		Traveller t = new Traveller();
		t.setGame(game);
		Settler s = game.getSettlers().get(0);
		Resource r = new Carbon();
		Robot robot = new Robot();
		Gate g1 = new Gate();
		Gate g2 = new Gate();
		//setting up Gates for Traveler Teleport!!!
		g1.setPair(g2);
		
		System.out.print("\nEnter the command:");
		Scanner in = new Scanner(System.in);
		// Command inputed must be identical to the one mentioned in the documentation 5.2 !!!
		while (in.hasNext()) {
			while(true) {
				String input_command = in.nextLine();
				switch(input_command.toLowerCase()) {
				case "control asteroids" :
					System.out.println("Control Asteroids command:");
					sun.getAsteroids();
					
					System.out.println("Enter 'p' if you want to set Perihelion on asteroid and 'a' if you want to set Aphelion");
					String answ = in.nextLine();
					if (answ.equals("p"))
						A1.setPerihelion(true);
					else A1.setPerihelion(false);
					break;
					
				case "settler travels" :
					System.out.println("Settler travels to asteroid A1 command:");
					s.travel(A1);
					break;
					
				case "traveler drills" :
					System.out.println("Traveler drills command:");
					A1.setDepth(5);
					//s.drill()
					break;		
					
				case "settler mines" :
					System.out.println("Settler mines command:");
		      //same question as in the pick up
					Carbon c = new Carbon();
					A1.addResource(c);
					s.mine();
					//possible failures are called in mine() method
					break;
					
				case "pick up resource" :
					System.out.println("Pick Up Resource command:");
					//Carbon c = new Carbon();
					//A1.addResource(c);
          //maybe it is a good idea to add a resource
          //because so far we dont initialize resources anywhere
          s.pickUpResource();
					//possible failures are called in pickUpResource() method
					break;
					
				case "drop resource" :
					System.out.println("Drop Resource command:");
					s.removeResource(r);
					//possible failures are called in removeResource() method
					break;
					
				case "hide" :
					System.out.println("Hide command:");
					//s.hide();
					break;
					
				case "create robot" :
					System.out.println("Create Robot:");
					s.createRobot();
					break;
					
				case "create transport gate" :
					s.createGate();
					break;
					
				case "deploy" :
					s.deployGate(g1);
					break;
					
				case "robot teleport" :
					t.teleport(g1);
					break;
					
				case "settler teleport" :
					s.teleport(g1);
					break;	
				case "win game" :
					System.out.println("Win Game command:");
					game.winGame();
					break;
				case "lose game" :
					System.out.println("Lose Game command:");
					game.loseGame();
					break;
					
				case "sunstorm" :
					System.out.println("Sunstorm command:");
					//Sun sun = new Sun();
					sun.sunstorm();
					break;
				case "view inventory":
					s.setInventory();
					for (Resource res : s.getResources()) {
						if (res != null)
							System.out.println(res.getType());
					}
					break;
					
				case "uranium explodes" :
					System.out.println("Uranium explodes command:");
					Uranium u = new Uranium();
					A1.addResource(u);
					Settler s1 = new Settler();
					s1.setGame(game);
					A1.placeTraveller(s1);
					
					Robot r1 = new Robot();
					s1.setGame(game);
					A1.placeTraveller(r1);
					
					A1.setPerihelion(true);
					
					break;
					
				case "water evaporates" :
					System.out.println("Water evaporates command:");
					Water w = new Water();
					A2.addResource(w);
					A2.setPerihelion(true);
					break;
				default:
					System.out.println("The command is invalid!");
					break;
				}
			}
	
		}
		in.close();
	}
}
