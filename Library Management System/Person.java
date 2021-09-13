import java.util.Scanner;

/**
 *  This class contains the methods and attributes pertaining to a person that a class can inherit.
 * @author Dhruv Kargwal
 * @version 1.0
 * @since 1.8
 */
public class Person {
	
	/**Stores the first name of the person**/
	protected String firstName;
	
	/**Stores the last name of the person**/
	protected String lastName;
	
	/**Stores the email address of the person**/
	protected String email;
	
	/**Stores the phone number of the person**/
	protected long phoneNumber;
	
	/**
	 * Takes in input from the user for various properties of the person class and its subclass
	 * @param scan Gives the user the ability to enter input in the console
	 */
	protected void readFromUser(Scanner scan) {}
	
	/**
	 * Takes in input from the file for various properties of the person class and its subclass
	 * @param scan Allows the compiler to read data from file
	 */
	protected void readFromFile(Scanner scan) {}
	
	
	/**
	 * Prints the attributes of person class and its subclasses to the user
	 */
	protected void printInfo() {}
}
