import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 * This class helps reads information about books from user as well as from file and performs tasks to calculate fees as well
 * @author Dhruv Kargwal
 * @version 1.0
 * @since 1.8
 */
public class Books extends Member implements Policies{
	
	/**Stores the name of the book**/
	protected String name;
	
	/**Stores the name of the author of book**/
	protected String author;
	
	/**Stores the book check out date**/
	LocalDate checkoutDate=null;
	
	/**Stores the return date of the book**/
	LocalDate returnDate=null;
	
	/**Stores the date in DD format**/
	protected int date;
	
	/**Stores the month in MM format**/
	protected int month;
	
	/**Stores the year in YY format**/
	protected int year;
	
	/**Stores the difference in days between check out and return of a book**/
	private int overallDays;
	
	/**Stores the fine a member has due because of late returning of book**/
	private int actualFine;
	
	/**
	 * Takes in input from the keyboard for various properties of the Book class and its subclass
	 * @param scan Gives the user the ability to enter input in the console
	 */
	protected void readBookInfoFromUser(Scanner scan) {
		
		Period diff=Period.between(checkoutDate, returnDate);	//calculates the days between check out and return date
		
		overallDays= (diff.getMonths() + (diff.getYears()*12))*(30) + diff.getDays();	//calculates the total days in between the two dates
		
		//checks to see if the return was late or not
		if(overallDays > dueDays)
			calculateFine();	//if return was late, fine is calculated which the member has to pay
		else
			actualFine=0;	//if return was in time, the member owes no fine

	}
	
	
	/**
	 * Method to determine how much money is to be charged to person in case of missed due date
	 */
	private void calculateFine() {
		actualFine=overallDays*fine;	//multiplies by days by daily fees to obtain total fine the member owes
		
	}
	
	/**
	 * Takes in input from the file for various properties of the Book class and its subclass
	 * @param scan Allows the compiler to read from file
	 */
	protected void readBookInfoFromFile(Scanner scan) {
		
	}
	
	/**
	 * Prints the fine in addition to other properties
	 */
	protected void printInfo() {
		System.out.printf("%6d$|\n", actualFine);
	}
}
