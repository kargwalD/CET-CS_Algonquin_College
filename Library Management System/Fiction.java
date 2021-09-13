import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class helps reads information about Fictional books from user as well as from file and prints it
 * @author Dhruv Kargwal
 * @version 1.0
 * @since 1.8
 */
public class Fiction extends Books{
	
	/**
	 * Takes in input from the keyboard for various properties of the Fiction class and its subclass
	 * @param scan Gives the user the ability to enter input in the console
	 */
	@Override	
	protected void readBookInfoFromUser(Scanner scan) {
		
		int loopingTest=0;	//helps run the try catch until valid input has been entered
		
		//runs this loop till correct inputs have been made
		while(loopingTest==0) {
			//try catch block will help us avoid program crashes and identify exceptions
			try {
				
					System.out.print("Enter checkout date(DD): ");	//asks user to enter checkout date
					date=scan.nextInt();
		
					System.out.print("Enter checkout month(MM): ");	//asks user to enter checkout month
					month=scan.nextInt();
					
					System.out.print("Enter checkout year(YYYY): ");	//asks user to enter checkout year
					year=scan.nextInt();
					
					checkoutDate=LocalDate.of(year, month, date);
					
					System.out.print("Enter return date(DD): ");	//asks user to enter return date
					date=scan.nextInt();
		
					System.out.print("Enter return month(MM): ");	//asks user to enter return month
					month=scan.nextInt();
					
					System.out.print("Enter return year(YYYY): ");	//asks user to enter return year
					year=scan.nextInt();
					
					returnDate=LocalDate.of(year, month, date);
				
					loopingTest++; //will help break the while loop
			}
			catch(InputMismatchException e) {
				//tells user that input of invalid data type has been entered
				System.err.println("Input Mismatch Exception while reading dates");
			}
		}
		
		super.readBookInfoFromUser(scan);	//calls the readBookInfoFromUser method of the superclass Books
	}
	
	/**
	 * Takes in input from the file for various properties of the Fiction class and its subclass
	 * @param scan Allows the compiler to read from file
	 */
	@Override
	protected void readBookInfoFromFile(Scanner scan) {
		
		date=scan.nextInt();	//stores the date(DD) in date variable
		month=scan.nextInt();	//stores the month(MM) in month variable
		year=scan.nextInt();	//stores the year(YYYY) in year variable
		
		checkoutDate=LocalDate.of(year, month, date);	//creates the checkout date in correct form for use
		
		
		date=scan.nextInt();	//stores the date(DD) in date variable
		month=scan.nextInt();	//stores the month(MM) in month variable
		year=scan.nextInt();	//stores the year(YYYY) in year variable
		
		returnDate=LocalDate.of(year, month, date);	//creates the return date in correct form for use
		
	}
	
	/**
	 * Prints the checkout and return date in addition to other properties
	 */
	@Override
	protected void printInfo() {
		System.out.print("  "+checkoutDate+" |  "+returnDate+" |");
		
		super.printInfo();	//calls the printInfo method of the superclass Books
	}
}
