package com.qa.coordsgame;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Game {
	 private int goalPositionX, goalPositionY, playerPositionX, playerPositionY;
	 private boolean isRunning;
	 private UserInput inputStream;
	 
	 public Game(UserInput inputStream) {
		 this.playerPositionX = ThreadLocalRandom.current().nextInt(0, 20);
		 this.playerPositionY = ThreadLocalRandom.current().nextInt(0, 20);
		 this.goalPositionX = ThreadLocalRandom.current().nextInt(0, 20);
		 this.goalPositionY = ThreadLocalRandom.current().nextInt(0, 20);
		 this.inputStream = inputStream;
		 this.isRunning = true;
		 startGame();
	 }
	 
	 public void outputNewPlayerPosition(){
		 System.out.println("Your new position is: (" 
		            + this.playerPositionX + ", "  
			        + this.playerPositionY + ")");
	 }
	 
	 public boolean playerReachedTheGoal() {
		 if (this.playerPositionX == this.goalPositionX && 
		     this.playerPositionY == this.goalPositionY) {
			 return true;
		 }
		 return false;
	 }
	 
	 public void startGame() {
		 System.out.println("Welcome to our Coordinate Game!");
		 System.out.println("Your starting position is (" + 
		                     this.playerPositionX + ", " + 
				             this.playerPositionY + ")");
		 System.out.println("The goal can be found at position (" +
		                     this.goalPositionX + ", " 
				           + this.goalPositionY + ")");
		 System.out.println("You can move arround by using the commands LEFT, RIGHT, UP, DOWN.");
		 System.out.println("You can terminate the game by typing EXIT.");
		 System.out.println();
		 
		 do {
			 String input = inputStream.readString();
			 switch(input.toLowerCase()) {
			 	case "left":
			 		this.playerPositionX--;
			 		outputNewPlayerPosition();
			 		if(playerReachedTheGoal()) {
			 			System.out.println("You reached the goal!");
			 		}
			 		break;
			 	case "right":
			 		this.playerPositionX++;
			 		outputNewPlayerPosition();
			 		if(playerReachedTheGoal()) {
			 			System.out.println("You reached the goal!");
			 		}
			 		break;
			 	case "up":
			 		this.playerPositionY++;
			 		outputNewPlayerPosition();
			 		if(playerReachedTheGoal()) {
			 			System.out.println("You reached the goal!");
			 		}
			 		break;
			 	case "down":
			 		this.playerPositionY--;
			 		outputNewPlayerPosition();
			 		if(playerReachedTheGoal()) {
			 			System.out.println("You reached the goal!");
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
