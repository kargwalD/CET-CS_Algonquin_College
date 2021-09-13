import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class creates the formatted table for output, creates user objects(staff or member) based on input, takes in the varisble's input and outputs it to the console as well
 * @author Dhruv Kargwal
 * @version 1.0
 * @since 1.8
 */
public class Library {
	
	/**Contains the name of the library**/
	private String name;
	
	/**Creates the array list of User that will hold the user's information**/
	private ArrayList<User> users=new ArrayList<User>();
	
	/**Used to create staff user element in array list**/
	private final int STAFF=1;
	
	/**Used to create member user element in array list**/
	private final int MEMBER=2;
	
	/**Helps keep track of what the element number for a new User object is**/
	private int userCount=0;
	
	/**
	 * Initializes the of the library name and properties of the users
	 */
	Library(){
	}
	
	/**
	 * Initializes the value of the library name
	 * @param name Contains the name of the library
	 */
	Library(String name){
		this.name=name;
	}
	
	/**
	 * Prints out the formatted title as well as the table headings
	 */
	private void printTitle() {
		
		String title=String.join(" ",name, "-List of users");	//Concatenates name of library and "- List of Students"
		
		int lenght= title.length();
		
		int totalLenght= 170;	//170 is the width of the table and this will be used to run the for loop for display of "="
		
		
		printEqualSign(totalLenght);	//marks the beginning of the table
		
		//following few lines are responsible for making sure that table title is printed in the center of the table
		int space= (totalLenght-lenght)/2;
		
		for(int i=0; i<space; i++)
			System.out.print(" ");
		
		
		System.out.println(title);	//prints the library name in the center of the line
		
		System.out.println();	//an extra line for tidiness
		
		printEqualSign(totalLenght);	//separates the table title from the table headings
		
		/*
		 * prints the headings for the table in a formatted manner for clear understanding
		 */
		System.out.printf("%15s|%15s|%15s|%7s|%5s|%10s|%5s|%20s|%15s|%15s|%13s|%13s|%7s|\n", "Name","Email","Phone No.","ID","Floor","Section","Age","Name of Book","Author","Publisher","Checkout Date","Return Date","Fine");
	}
	
	/**
	 * Prints out "=" symbol as many times as specified by user for visual appeal
	 * @param totalLenght This variable holds the amount of times user wants us to place "=" symbol
	 */
	private void printEqualSign(int totalLenght) {
		
		/*
		 * This for loop displays "=" along the entire width of the table
		 */
		for(int i=0; i<totalLenght; i++) {
			System.out.print("=");
		}
		
		System.out.println();	//moves to the next line for neatness
	} 
	
	/**
	 * Creates user objects(staff or member) based on user input and calls the readFromUser in order to take in the concerned inputs
	 * @param scan Gives the user the ability to enter input in the console
	 */
	public void readInfoFromKeyboard(Scanner scan) {
		//asks user for details of the (userCount+1)th user
		System.out.println("Enter details of user " + (userCount+1) + ":");
		
		printEqualSign(27);	//prints "=" symbol for neatness
		
		int loopingTest=0;	//helps run the try catch until all valid input has been entered
		
		//runs this loop till correct inputs have been made
		while(loopingTest==0) {
			//try catch block will help us avoid program crashes and identify exceptions
			try {
							
				System.out.print("1. Staff\n2. Member\n");	//displays the menu of types of users which can be created
				
				int userType=0;	//initializes userType variable
				
				System.out.print("Enter User type: ");	//prompts user to enter type of user
				userType=scan.nextInt();
				
				scan.nextLine();	//Clears the scanner stream to avoid any problems
				
				
				//this switch statement is responsible for creating appropriate user type and add to the array list users
				switch(userType) {
					case STAFF: User staff1=new Staff();
								users.add(userCount, staff1);	//adds a staff object to the users array list
								loopingTest++; //will help break the while loop
								break;
											
					case MEMBER:User member1=new Member();
								users.add(userCount, member1);	//adds a member object to the users array list
								loopingTest++; //will help break the while loop
								break;
												
					default: System.out.println("Wrong user type");	//informs user that an incorrect numeric input has been entered
								break;
				}
			}
			catch(InputMismatchException e) {
				//tells user that input of invalid data type has been entered
				System.err.print("Input mismatch exception while reading user type\n");
				scan.nextLine();
			}
		}
		
		users.get(userCount).readFromUser(scan);	//calls readFromUser method of users class to read user data
	
		userCount++;	//increments userCount for ease of determining what element we are at
	}
	
	/**
	 * This method helps the compiler read the contents of the file and save them to users array list
	 * @param scan Allows compiler to read info from file
	 */
	public void readInfoFromFile(Scanner scan) {
		
		try {
			scan=new Scanner(Paths.get("C:\\AlgonquinProgramming\\Level 2\\CST 8132 OOPs\\1. Labs Jun 6\\6. Lab 6 Aug 9\\BS Resources\\users.txt"));
		}catch(FileNotFoundException e) {
			//informs user that the file path is either incorrect or that the file is not accessible by the compiler
			System.err.println("File not found or not accessible");
		}
		catch (IOException e) {
			System.err.println(e);
		}
		
		//this while loop runs till each line in the file provided has been read
		while(scan.hasNext()) {
			
			char option = scan.next().charAt(0);	//reads the first character in each line to determine what user type the person is
			
			//this switch statement will help create appropriate user type objects and add them in the users array list
			switch(option) {
				case 's': User staff1=new Staff();
							users.add(userCount, staff1);	//adds a staff object to the users array list
							staff1.readFromFile(scan);	//calls readFromFile method from user class to read staff data
							userCount++;	//increments userCount for ease of determining what element we are at
							break;
				case 'm': User member1=new Member();
							users.add(userCount, member1);	//adds a member object to the users array list
							member1.readFromFile(scan);	//calls readFromFile method from user class to read member data
							userCount++;	//increments userCount for ease of determining what element we are at
							break;
				default: System.out.println("File contains illegal tokens");
							break;
				}
			}
	}
	
	/**
	 * Outputs the user details to the user
	 */
	public void printUserDetails(){
		
		if(users.size()==0)
			System.out.println("\n###### No users to display ######\n");	//this is displayed if no users exist in the users array list
		else {
			printTitle();	//prints the title as well as table headings for ease of understanding
			
			/*
			 * this for loop runs until the info of all the users are displayed to the user
			 */
			for(int i=0; i<users.size(); i++) {
				users.get(i).printInfo();	//calls the printInfo method to display all the details of the users to the console
			}
		}
	}
	
}
