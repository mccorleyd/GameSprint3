package com.qa.coordsgame;

public class Runner {

	 public static void main (String[] args) {
		 UserInput input = new UserInput();
		 Game game = new Game(input);
		 input.closeStream();
	 }
}
