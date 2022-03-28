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
		
		
		Sun sun = new Sun();
		Asteroid A1 = new Asteroid();
		Traveller t = new Traveller();
		Settler s = new Settler();
		Resource r = new Resource();
		Gate g = new Gate();
		
		System.out.print("\nEnter the command:");
		Scanner in = new Scanner(System.in); // Command inputed must be identical to the one mentioned in the documentation 5.2
		while (in.hasNext()) {
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
				System.out.println("Traveller mines command:");
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
				s.deployGate(g);
				break;
				
			case "Traveler Teleports" :
				System.out.println("Traveler Teleports command:");
				//t.teleport(g);
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
				break;
				
			case "Uranium explodes" :
				System.out.println("Uranium explodes command:");
				break;
				
			case "Water evaporates" :
				System.out.println("Water evaporates command:");
				break;
			}
	
		}
		in.close();
	}
}