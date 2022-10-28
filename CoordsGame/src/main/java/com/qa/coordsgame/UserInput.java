package com.qa.coordsgame;

import java.util.Scanner;

public class UserInput {
	Scanner scan = new Scanner(System.in);
	int intinput;
	String stringinput;

	public int readInt() {
		System.out.println("Please enter a number:");
		while (true) {

			if (scan.hasNextInt()) {
				intinput = scan.nextInt();
				return intinput;
			} else {
				System.out.println("Invalid input");
				scan.next();
			}
		}

	}

	public String readString() {
		stringinput = scan.nextLine().toLowerCase();
		while (true) {

			if (stringinput.equals("up") || stringinput.equals("down") || stringinput.equals("left")
					|| stringinput.equals("right") || stringinput.equals("exit")) {
				return stringinput;
			} else {
				System.out.println("Invalid input");
				stringinput = scan.nextLine();
			}

		}

	}
	
	public void closeStream() {
		scan.close();
	}
 
}
