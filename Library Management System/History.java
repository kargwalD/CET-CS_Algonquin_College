import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class helps reads information about Historic books from user as well as from file and prints it
 * @author Dhruv Kargwal
 * @version 1.0
 * @since 1.8
 */
public class History extends NonFiction{
	
	/**
	 * Takes in input from the keyboard for various properties of the History class and its subclass
	 * @param scan Gives the user the ability to enter input in the console
	 */
	@Override
	protected void readBookInfoFromUser(Scanner scan) {
		
		int loopingTest=0;	//helps run the try catch until valid input has been entered
		
		//runs this loop till correct inputs have been made
		while(loopingTest==0) {
			//try catch block will help us avoid program crashes and identify exceptions
			try {
				
					System.out.print("Enter historic novel name: ");	//asks user to enter historic novel name
					name=scan.next();
		
					System.out.print("Enter author name: ");	//asks user to enter author name
					author=scan.nextLine();
					
					scan.nextLine();
					
					loopingTest++; //will help break the while loop
			}
			catch(InputMismatchException e) {
				//tells user that input of invalid data type has been entered
				System.err.println("Input Mismatch Exception while reading novel properties");
			}
		}
		
		super.readBookInfoFromUser(scan);	//calls the readBookInfoFromUser method of the superclass NonFiction
		
	}
	
	/**
	 * Takes in input from the file for various properties of the History class and its subclass
	 * @param scan Allows the compiler to read from file
	 */
	@Override
	protected void readBookInfoFromFile(Scanner scan) {
		name=scan.next();	//stores the name in name variable
		
		author=scan.next();	//stores the author in author variable
		
		super.readBookInfoFromFile(scan);	//calls the readBookInfoFromFile method of the superclass NonFiction
	}
	
	/**
	 * Prints the name and author name in addition to other properties
	 */
	@Override
	protected void printInfo() {
		System.out.printf("%20s|%15s|%15s|", name, author, " ");
		
		super.printInfo();	//calls the printInfo method of the superclass Non fiction
	}
}
