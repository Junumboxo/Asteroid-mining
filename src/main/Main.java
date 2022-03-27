package main;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		System.out.print("Enter the command:");
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String input_command = in.nextLine();
			switch(input_command) {
			case "Control Asteroids" :
				System.out.println("Control Asteroids");
				break;
			case "Settler travels" :
				System.out.println();
				break;
			case "Traveler drills" :
				System.out.println("Traveler drills");
				break;		
			case "Settler mines" :
				System.out.println("Traveler mines");
				break;
			case "Pick Up Resource" :
				System.out.println("Pick Up Resource");
				break;
			case "Drop Resource" :
				System.out.println("Drop Resource");
				break;
			case "Hide" :
				System.out.println("Hide");
				break;
			case "Create Robot" :
				System.out.println("Create Robot");
				break;
			case "Create Gate" :
				System.out.println("Create Gate");
				break;
			case "Install Gate" :
				System.out.println("Install Gate");
				break;
			case "Traveler Teleports" :
				System.out.println("Traveler Teleports");
				break;
			case "Win Game" :
				System.out.println("Win Game");
				break;
			case "Lose Game" :
				System.out.println("Lose Game");
				break;
			case "Sunstorm" :
				System.out.println("Sunstorm");
				break;
			case "Uranium explodes" :
				System.out.println("Uranium explodes");
				break;
			case "Water evaporates" :
				System.out.println("Water evaporates");
				break;
			}
	
		}

	}
}