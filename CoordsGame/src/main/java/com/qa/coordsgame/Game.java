package com.qa.coordsgame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Game {
	 private int playerPositionX, playerPositionY;
	 private treasure gameTreasure;
	 private boolean isRunning;
	 private UserInput inputStream;
	 private ArrayList<monster> gameMonsters = new ArrayList<monster> ();
	 
	 public void monsterGen(int numberOfMonsters) {
		 for(int i = 0; i < numberOfMonsters; i++) {
			 gameMonsters.add(new monster());
		 }
	 }
	 
	 public Game(UserInput inputStream) {
		 this.playerPositionX = ThreadLocalRandom.current().nextInt(0, 20);
		 this.playerPositionY = ThreadLocalRandom.current().nextInt(0, 20);
		 this.gameTreasure = new treasure();
		 monsterGen(3);
		 this.inputStream = inputStream;
		 this.isRunning = true;
		 startGame();
	 }
	 
	 public void outputNewPlayerPosition(){
		 System.out.println("Your new position is: (" 
		            + this.playerPositionX + ", "  
			        + this.playerPositionY + ")");
	 }
	 
	 
	 public void checkLocation() {
		 if(playerReachedTheGoal()) {
	 			System.out.println("You reached the goal!");
	 			isRunning = false;
	 		}
		 else if(playerReachedMonster()) {
			    System.out.println("Roar!"); //Access from object if we have time.
	 			System.out.println("The Monster has eaten you!");
	 			isRunning = false;
	 		}
		 
	 }
	 
	 public boolean playerReachedTheGoal() {
		 int[] treasurePosition = gameTreasure.getPosition();
		 if (this.playerPositionX == treasurePosition[0] && 
		     this.playerPositionY == treasurePosition[1]) {
			 return true;
		 }
		 return false;
	 }
	 
	 
	 public boolean playerReachedMonster() {
		 for (monster monsters: gameMonsters) {
			 int[] monsterPosition = monsters.getPosition();
			 if (this.playerPositionX == monsterPosition[0] && 
			     this.playerPositionY == monsterPosition[1]) {
				 return true;
			 }
			 
		 }

		 return false;
	 }
	 
	 public void startGame() {
		 int[] treasurePosition = gameTreasure.getPosition();
		 System.out.println("Welcome to our Coordinate Game!");
		 System.out.println("Your starting position is (" + 
		                     this.playerPositionX + ", " + 
				             this.playerPositionY + ")");
		 System.out.println("The treasure can be found at position (" +
		                     treasurePosition[0] + ", " 
				           + treasurePosition[1] + ")");
		 if (!gameMonsters.isEmpty()) {
			 System.out.println("Beware the monsters are at the following positions:");
				 for (monster monsters: gameMonsters) {
					 int[] monsterPosition = monsters.getPosition();
					 System.out.println("(" + monsterPosition[0] + "," + monsterPosition[1] + ")");
					 }
		 }
		 System.out.println("You can move arround by using the commands LEFT, RIGHT, UP, DOWN.");
		 System.out.println("You can terminate the game by typing EXIT.");
		 System.out.println();
		 
		 do {
			 String input = inputStream.readString();
			 switch(input.toLowerCase()) {
			 	case "left":
			 		if(this.playerPositionX-1 < 0) {
			 			System.out.println("Can't move any further left");
			 		}
			 		else {
				 		this.playerPositionX--;
				 		outputNewPlayerPosition();
				 		checkLocation();
			 		}
			 		
			 		break;
			 	case "right":
			 		if(this.playerPositionX+1 > 20) {
			 			System.out.println("Can't move any further right");
			 		}
			 		else {
				 		this.playerPositionX++;
				 		outputNewPlayerPosition();
				 		checkLocation();
			 		}
			
			 		break;
			 	case "up":
			 		if(this.playerPositionY+1 > 20) {
			 			System.out.println("Can't move up any further!");
			 			// Create custom message
			 		}
			 		else {
				 		this.playerPositionY++;
				 		outputNewPlayerPosition();
				 		checkLocation();
			 		}
			 		
			 		break;
			 	case "down":
			 		if(this.playerPositionY-1 < 0) {
			 			System.out.println("Can't move down any further!");
			 		}
			 		else {
				 		this.playerPositionY--;
				 		outputNewPlayerPosition();
				 		checkLocation();
			 		}
			 		
			 		break;
			 	case "exit":
			 		this.isRunning = false;
			 		break;
			 	default:
					System.out.println("Invalid command.");
					break;
			 }
		 } while (isRunning);
	 }
}
