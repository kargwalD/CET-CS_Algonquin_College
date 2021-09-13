import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the driver class that takes in the name of the library, no of users and calls appropriate methods that reads inputs(from user as well as from file), and display this information in a formatted and neat manner to the user
 * @author Dhruv Kargwal
 * @version 1.0
 * @since 1.8
 */
public class LibraryManagementClass {
	
	/**
	 * This main method takes in the name of the library, no of users and calls appropriate methods that reads inputs(from user as well as from file), and display this information in a formatted and neat manner to the user
	 * @param args Stores the Java command line arguments and is an array of the type String
	 */
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);	//declaring the scanner that will take in all the input from the user when called
		
		int noOfUsers=0;	//initializing the number of users to 0 as default
		
		int option=0;	//initializing the option variable to 0 as default
		
		int loopingTest=0;	//helps run the try catch until valid input has been entered
		
		System.out.print("Enter name of library: ");	//asks user for the college name
		String name= scan.nextLine();
		
		//runs this loop till correct inputs have been made
		while(loopingTest==0) {
			//try catch block will help us avoid program crashes and identify exceptions
			try {
				do {
					System.out.print("Enter number of users: ");	//asks user for number of users
					 noOfUsers= scan.nextInt();	
					
					 //this if loop makes sure that number of users entered are more than zero
					if(noOfUsers<=0)
						System.out.println("Number of users should be positive... please try again!");	
					
				}while(noOfUsers<=0);	//breaks loop as soon as an integer greater than 0 has been entered
				
				loopingTest++; //will help break the while loop
			}
			catch(InputMismatchException e) {
				//tells user that input of invalid data type has been entered
				System.err.println("Input mismatch exception while reading number of users... please try again!\n");
				scan.nextLine();
			}
		}
		
		Library l1= new Library(name);	//declares a variable and initializes it using the parameterized constructor with the help of passing name
		
		while(option !=4){
			try {
				System.out.println("1. Read user info from keyboard");
				System.out.println("2. Read user info from file");
				System.out.println("3. Print details of all users");
				System.out.println("4. Exit");
				
				System.out.print("Enter your option: ");	//asks user for option input
				option=scan.nextInt();
				
				scan.nextLine();	//clears input stream to avoid any errors
				
				switch(option) {
				case 1: l1.readInfoFromKeyboard(scan);;	//calls method to read user details from user
						break;
				case 2: l1.readInfoFromFile(scan);	//calls method to read user details from file
						break;
				case 3: l1.printUserDetails();	//calls method to print user information
						break;
				case 4: System.out.println("Goodbye... Have a nice day");	//exits the loop and ends the code
						break;
				default:System.out.println("Invalid entry... selection options 1-4... please try again!"); //tells user that an invalid menu option has been selected
						break;
				}
			}
			catch(InputMismatchException e) {
				//tells user that input of invalid data type has been entered
				System.err.print("Input mismatch exception while reading choice in main menu... please try again!\n");
				scan.nextLine();
			}
		}
		
		scan.close();	//closing the scanner to ensure no resources are leaked
	
	}
}
