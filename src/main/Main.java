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
				switch(input_command) {
				case "Control Asteroids" :
					System.out.println("Control Asteroids command:");
					sun.getAsteroids();
					
					System.out.println("Enter 'p' if you want to set Perihelion on asteroid and 'a' if you want to set Aphelion");
					String answ = in.nextLine();
					if (answ.equals("p"))
						A1.setPerihelion(true);
					else A1.setPerihelion(false);
					break;
					
				case "Settler travels" :
					System.out.println("Settler travels to asteroid A1 command:");
					s.travel(A1);
					break;
					
				case "Traveler drills" :
					System.out.println("Traveler drills command:");
					t.drill();
					break;		
					
				case "Settler mines" :
					System.out.println("Settler mines command:");
					s.mine();
					break;
					
				case "Pick Up Resource" :
					System.out.println("Pick Up Resource command:");
					s.pickUpResource();
					break;
					
				case "Drop Resource" :
					System.out.println("Drop Resource command:");
					s.removeResource(r);
					break;
					
				case "Hide" :
					System.out.println("Hide command:");
					t.hide(A1);
					break;
					
				case "Create Robot" :
					System.out.println("Create Robot:");
					s.createRobot();
					break;
					
				case "Create Gate" :
					System.out.println("Create Gate command:");
					s.createGate();
					break;
					
				case "Install Gate" :
					System.out.println("Install Gate command:");
					s.deployGate(g1);
					break;
					
				case "Traveler Teleports" :
					System.out.println("Traveler Teleports command:");
					t.teleport(g1);
					break;
					
				case "Win Game" :
					System.out.println("Win Game command:");
					game.winGame();
					break;
				case "Lose Game" :
					System.out.println("Lose Game command:");
					game.loseGame();
					break;
					
				case "Sunstorm" :
					System.out.println("Sunstorm command:");
					sun.sunstorm();
					break;
					
				case "Uranium explodes" :
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
					
				case "Water evaporates" :
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