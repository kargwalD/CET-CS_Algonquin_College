import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class reads information about user from the keyboard or from file and stores it in appropriate fields. 
 * @author Dhruv Kargwal
 * @version 1.0
 * @since 1.8
 */
public class User extends Person{

	/**
	 * Takes in input from the keyboard for various properties of the person class and its subclass
	 * @param scan Gives the user the ability to enter input in the console
	 */
	protected void readFromUser(Scanner scan) {
		
		int loopingTest=0;	//helps run the try catch until valid input has been entered
		
		//runs this loop till correct inputs have been made
		while(loopingTest==0) {
			//try catch block will help us avoid program crashes and identify exceptions
			try {
				
				System.out.print("Enter first name: ");	//asks for the first name of user
				firstName=scan.next();
				
				System.out.print("Enter last name: ");	//asks for the last name of the user
				lastName=scan.next();
				
				scan.nextLine();	//clears the input stream
				
				System.out.print("Enter email Id: ");	//asks for the email address of the user
				email=scan.nextLine();
				
				System.out.print("Enter phone number: ");	//asks for the phone number of the user
				phoneNumber=scan.nextLong();
				
				loopingTest++; //will help break the while loop
				
				
			}
			catch(InputMismatchException e) {
				//tells user that input of invalid data type has been entered
				System.err.println("Input Mismatch Exception while reading user's properties");
				scan.nextLine();
			}
		}
		
	}
	
	/**
	 * Takes in input from the file for various properties of the person class and its subclass
	 * @param scan Allows the compiler to read data from file
	 */
	protected void readFromFile(Scanner scan) {
		
		firstName=scan.next();	//stores the first name in firstName variable

		lastName=scan.next();	//stores the last name in lastName variable
		
		email=scan.next();	//stores the email address in email variable
		
		phoneNumber=scan.nextLong();	//stores the phone no. in phoneNumber variable
		
	}
	
	/**
	 * Prints the attributes of person class and its subclasses to the user
	 */
	protected void printInfo() {
		
		/*
		 * prints the info of user in a formatted manner for clear understanding
		 */
		System.out.printf("%15s|%15s|%15d|", firstName+" "+lastName, email, phoneNumber);

	}
}
