// Name:Nicholas Laventis
// VUnetID:laventnc
// Email:nicholas.c.laventis@vanderbilt.edu
// Class:CS101, Vanderbilt University
// Honor statement: I have neither given nor received unauthorized help on this assignment
// Date: 20 October 2014

import java.io.*;
import java.util.*;

public class NumberStats {

	public static void main(String[] args) throws FileNotFoundException {
		Run();
	}
	/**
	 * This method runs the program as it first asks the use for a file to run.
	 * It then processes the file and prints a cumulative sum as each new term is added.
	 * Finally it prints some interesting statistics.
	 * @throws FileNotFoundException
	 */
	public static void Run() throws FileNotFoundException {
		Scanner Console = new Scanner (System.in);
		System.out.print("Please enter name of input file.");
		String FileName = Console.nextLine().trim();
		File Contents = new File(FileName);
		while (!Contents.exists()) { // Checks to see if the input file exists
			System.out.println("File does not exist. Try again.");
			System.out.print("Please enter name of input file.");
			FileName = Console.nextLine().trim();
			Contents = new File(FileName);
		}
		int i = 0;
		int Sum = 0;
		int Multiple = 0;
		int Prime = 0;
		int Max = 0;
		
		Scanner Input = new Scanner(Contents); // Opens the file	
		
		do {
			i++;
			int Number = Input.nextInt();
			if (Number%7 == 0) { // Checks to see if number is multiple of 7
				Multiple++;
			}
			if(Prime(Number) == true) { // Checks to see if number is prime
				Prime++;
			}
			if (Number > Max) { // Checks to see if the number is a new maximum
				Max = Number;
			}
			Sum = Sum + Number;
			System.out.println("Sum of "+ i + " = " + Sum);
		} while (Input.hasNextInt());
		double Average = (double) Sum / (int) i;
		
		System.out.println("");
		System.out.println("The count is " + (i-1));
		System.out.println(Multiple + " value is a multiple of 7");
		System.out.println(Prime + " values are prime");
		System.out.println("Maximum is " + Max);
		System.out.printf("Average is %.2f", Average);
	}
	/**
	 * This method takes the number from the file as a parameter, and then tests to see if 
	 * the number is prime
	 * @param Number
	 * @returns either true or false
	 */
	public static boolean Prime(int Number) {
	    for(int i = 2; i <= Math.sqrt(Number); i++) {
	        if((Number % i) == 0)
	        	return false;
	    	}
	     return true;
	}

}
