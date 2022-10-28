package com.qa.coordsgame;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Game {
	 private int playerPositionX, playerPositionY;
	 private treasure gameTreasure;
	 private monster gameMonster;
	 private boolean isRunning;
	 private UserInput inputStream;
	 
	 public Game(UserInput inputStream) {
		 this.playerPositionX = ThreadLocalRandom.current().nextInt(0, 20);
		 this.playerPositionY = ThreadLocalRandom.current().nextInt(0, 20);
		 this.gameTreasure = new treasure();
		 this.gameMonster = new monster();
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
			    gameMonster.output(gameMonster.sound);
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
		 int[] monsterPosition = gameMonster.getPosition();
		 if (this.playerPositionX == monsterPosition[0] && 
		     this.playerPositionY == monsterPosition[1]) {
			 return true;
		 }
		 return false;
	 }
	 
	 public void startGame() {
		 int[] treasurePosition = gameTreasure.getPosition();
		 int[] monsterPosition = gameMonster.getPosition();
		 System.out.println("Welcome to our Coordinate Game!");
		 System.out.println("Your starting position is (" + 
		                     this.playerPositionX + ", " + 
				             this.playerPositionY + ")");
		 System.out.println("The treasure can be found at position (" +
		                     treasurePosition[0] + ", " 
				           + treasurePosition[1] + ")");
		 System.out.println("Beware the monster is at position (" +
                 monsterPosition[0] + ", " 
	           + monsterPosition[1] + ")");
		 System.out.println("You can move arround by using the commands LEFT, RIGHT, UP, DOWN.");
		 System.out.println("You can terminate the game by typing EXIT.");
		 System.out.println();
		 
		 do {
			 String input = inputStream.readString();
			 switch(input.toLowerCase()) {
			 	case "left":
			 		this.playerPositionX--;
			 		outputNewPlayerPosition();
			 		checkLocation();
			 		
			 		break;
			 	case "right":
			 		this.playerPositionX++;
			 		outputNewPlayerPosition();
			 		checkLocation();
			
			 		break;
			 	case "up":
			 		this.playerPositionY++;
			 		outputNewPlayerPosition();
			 		checkLocation();
			 		
			 		break;
			 	case "down":
			 		this.playerPositionY--;
			 		outputNewPlayerPosition();
			 		checkLocation();
			 		
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
