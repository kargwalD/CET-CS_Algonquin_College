import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class and its methods are called in case the user is of type staff
 * @author Dhruv Kargwal
 * @version 1.0
 * @since 1.8
 */
public class Staff extends User{
	
	/**Stores the ID of staff user**/
	private String staffID;
	
	/**Stores the floor number of staff user**/
	private int floor;
	
	/**Stores the section(eg. science, etc.) of staff user**/
	private String section;
	
	/**
	 * Takes in input from the user for various properties of the person class and its subclass
	 * @param scan Gives the user the ability to enter input in the console
	 */
	@Override
	protected void readFromUser(Scanner scan) {
		
		super.readFromUser(scan);	//calls readFromUser method of superclass User
		
		int loopingTest=0;	//helps run the try catch until valid input has been entered
		
		//runs this loop till correct inputs have been made
		while(loopingTest==0) {
			//try catch block will help us avoid program crashes and identify exceptions
			try {
				
					System.out.print("Enter staff ID: ");	//asks to enter Staff ID
					staffID=scan.next();
		
					System.out.print("Enter floor: ");	//asks to enter floor
					floor=scan.nextInt();
					
					scan.nextLine();	//Clears the scanner before use to avoid any problems
					
					System.out.print("Enter section: ");	//asks to enter section
					section=scan.next();
				
					loopingTest++; //will help break the while loop
			}
			catch(InputMismatchException e) {
				//tells user that input of invalid data type has been entered
				System.err.println("Input Mismatch Exception while reading staff properties");
			}
		}
	}
	
	/**
	 * Takes in input from the file for various properties of the staff class and its subclass
	 * @param scan Allows the compiler to read data from file
	 */
	@Override
	protected void readFromFile(Scanner scan) {
		
		super.readFromFile(scan);	//calls readFromFile method of superclass User
		
		staffID=scan.next();	//Stores staff ID in staffID variable
		
		floor=scan.nextInt();	//Stores floor number in floor variable
		
		section=scan.next();	//Stores section in section variable
		
	}
	
	/**
	 * Prints the attributes of person class and its subclasses to the user
	 */
	@Override
	protected void printInfo() {
		super.printInfo();
		
		System.out.printf("%7s|%5d|%10s|\n", staffID, floor, section);
	}
}
