// Name:Nicholas Laventis
// VUnetID:laventnc
// Email:nicholas.c.laventis@vanderbilt.edu
// Class:CS101, Vanderbilt University
// Honor statement: I have neither given nor received unauthorized help on this assignment
// Date: 20 October 2014

import java.io.*;
import java.util.*;

public class Fmt {

	public static void main(String[] args) throws FileNotFoundException {
		String FileName = null;
		do {
		Scanner Console = new Scanner (System.in);
		System.out.print("Please enter name of input file or type \"exit\" to leave the program.");
		FileName = Console.nextLine().trim();
		File Checked = Input(FileName, Console);
		Run(Checked);
		System.out.println("");
		System.out.println("");
		} while (FileName != "exit");	
	}
	/**
	 * This method takes the file and scanner as input and checks to see if the
	 * file exists
	 * @param FileName
	 * @param Console
	 * @return
	 * @throws FileNotFoundException
	 */
	public static File Input(String FileName, Scanner Console) throws FileNotFoundException {

		File Contents = new File(FileName);
		while (!Contents.exists()) { // Checks to see if the input file exists
			if (FileName == "exit") {
				System.out.println("Goodbye!");
			}
			System.out.println("File does not exist. Try again.");
			System.out.print("Please enter name of input file.");
			FileName = Console.nextLine().trim();
			Contents = new File(FileName);
		}
		return Contents; // Returns the file
	}
	/**
	 * This method runs the actual program by making sure no line exceedss 72 characters
	 * (including spaces)
	 * @param Checked
	 * @throws FileNotFoundException
	 */
	public static void Run(File Checked) throws FileNotFoundException {
		Scanner Input = new Scanner(Checked); // Opens the file
		int Count = 0;
		do {
			String Word = Input.next();
			int Length = Word.length();
			Count = Count + Length + 1; // Add one to account for space between words
			if (Count > 72) {
				System.out.println("");
				Count = 0;
			}
			System.out.print(Word + " ");
		} while (Input.hasNext());
	}
}
