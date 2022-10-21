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
		System.out.println("Please enter a string:");
		stringinput = scan.nextLine();
		while (true) {

			if (stringinput.equals("w") || stringinput.equals("a") || stringinput.equals("s")
					|| stringinput.equals("d")) {
				return stringinput;
			} else {
				System.out.println("Invalid input");
				stringinput = scan.nextLine();
			}

		}

	}

}
