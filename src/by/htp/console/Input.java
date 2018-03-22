package by.htp.console;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Input {
	
	static Scanner reader = new Scanner(System.in);
	
	public String readFName() {
		String firstName; 
		
		System.out.println("Hi my dear, what's your name?");
		firstName = reader.next();
		
		return firstName;
	}
	
	public String readSName() {
		String secondName; 
		
		System.out.println("And what's your second name?");
		secondName = reader.next();
		
		System.out.println("Nice to meet you ");
		
		return secondName;
	}
	
	public String readChoise() {
		String temp = "";
		String choice = "";
		boolean loop = true;

		while (loop) {
			try {
				System.out.println("What topic you will choose? Please select number:\n1.Work\n2.Love\n3.Luck");
				
				temp = reader.next();
				switch(temp) {
				case "1":
					choice = "Work";
					break;
				case "2": 
					choice = "Love";
					break;
				case "3": 
					choice = "Luck";
					break;
				default:
					System.out.println("If you cannot say corect variant, we'll tell you about work");
					choice = "Work";
				}
				loop = false;
			} catch (InputMismatchException e) {
				System.out.println("Please input only digits ... or I will curse you!");
				reader.next(); // this consumes the invalid token
			}

		}
		return choice;
	}
	
	
}
