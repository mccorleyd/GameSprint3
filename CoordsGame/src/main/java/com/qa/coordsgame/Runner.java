package com.qa.coordsgame;

public class Runner {

	 public static void main (String[] args) {
		 boolean isPlaying = true;
	     do {
	    	 UserInput input = new UserInput();
			 Game game = new Game(input);
			 System.out.println("Welcome to main menu. Play a game? Type '1' to continue, '0' to terminate.");
			 int userInput = input.readInt();
			 if(userInput == 0) {
				 input.closeStream();
				 isPlaying = false;
			 }
		 } while (isPlaying);
	 }
}
