import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class and its methods are called in case the user is of type member
 * @author Dhruv Kargwal
 * @version 1.0
 * @since 1.8
 */
public class Member extends User implements Policies{
	
	/**Stores the ID of member**/
	private String memberID;
	
	/**Stores the age of the member**/
	private int age;
	
	/**Stores the amount of books the member has checked out**/
	private int noOfBooks=1;
	
	/**This array contains the information of books checked out by member**/
	protected Books[] b1=null;
	
	/**
	 * Takes in input from the user for various properties of the person class and its subclass
	 * @param scan Gives the user the ability to enter input in the console
	 */
	@Override
	protected void readFromUser(Scanner scan) {
		
		super.readFromUser(scan);	//calls readFromFile method of superclass User
		
		int loopingTest=0;	//helps run the try catch until valid input has been entered
		
		//runs this loop till correct inputs have been made
		while(loopingTest==0) {
			//try catch block will help us avoid program crashes and identify exceptions
			try {
				
					System.out.print("Enter member ID: ");	//asks user to enter Member ID
					memberID=scan.next();
		
					System.out.print("Enter age: ");	//asks user to enter member's age
					age=scan.nextInt();
					
					scan.nextLine();	//Clears the scanner before use to avoid any problems
					
					do {
						System.out.print("Enter number of books: ");	//asks user to enter number of books
						noOfBooks=scan.nextInt();
						
						//This if statement will inform user in case of an invalid input
						if(noOfBooks<=0 || noOfBooks>=5)
							System.out.println("Number of books entered should be between 1 and 4, please try again");
					
					} while(noOfBooks<=0 || noOfBooks>=maxBooks);	//Exits the do-while loop once a positive value between 0 and 5 is entered
					
					scan.nextLine();	//Clears the scanner before use to avoid any problems
					
					b1=new Books[noOfBooks];	//creates the b1 array of data type Books to stores info of all books associated with member
					
					readBookTypes(scan);	//calls readBookTypes method of this class to read book info
				
					loopingTest++; //will help break the while loop
			}
			catch(InputMismatchException e) {
				//tells user that input of invalid data type has been entered
				System.err.println("Input Mismatch Exception while reading properties of member");
			}
		}
		
	}
	
	
	/**
	 * Helps create and store info of correct book type in the b1 array
	 * @param scan Gives the user the ability to enter input in the console 
	 */
	protected void readBookTypes(Scanner scan) {
		
		int type;	//is used in the switch statement to create correct book genre of either fiction or non fiction type
		
		int choice;	//is used to create the correct objects of book type from within either the fiction of the non fiction pool of book types
		
		int loopTest2;	//is used in case an invalid numeric input has been made, i.e. not 1 or 2 in the first switch statement
		
		
		//this for loop runs till all the elements in the b1 array have been entered by the user
		for(int i=0; i<noOfBooks; i++) {
			
			System.out.println("Enter details for book "+(i+1)+":" );	//informs info for which book will be asked for
			
			int loopingTest=0;	//helps run the try catch until valid input has been entered
			
			//runs this loop till correct inputs have been made
			while(loopingTest==0) {
				//try catch block will help us avoid program crashes and identify exceptions
				try {
					
					System.out.print("1. Fiction\n2. Non Fiction\n");	//informs user of the book genre types
					
					System.out.print("Enter type of book: ");	//asks user for which sort of books they want to enter
					type=scan.nextInt();
					
					scan.nextLine();	//clears the input stream to avoid any errors
					
					loopTest2=0;	//initializes the testing variable for the inner while loop
					
					//this switch statement will help create the correct book type
					switch(type){
						case 1: //in case of Fiction book type
								while(loopTest2==0) {	//this while loop will run until correct numerical inputs have been made
							 		
									System.out.print("1. Comic\n2. Fantasy\n");	//informs user of the book types
									
									System.out.print("Enter type of fictional book: ");	//asks user for the book type they desire
									choice=scan.nextInt();
									
									scan.nextLine();	//clears the input stream to avoid any errors
									
										switch(choice) {
											case 1: b1[i]=new Comic();	//creates a Comic book object and adds it to the array
													loopTest2++;
													break;
										
											case 2: b1[i]=new Fantasy();	//creates a Fantasy book object and adds it to the array
													loopTest2++;
													break;
													
											default:System.out.println("Wrong choice entered, please try again");	//informs user that an invalid number has been entered
													break;
										}
								}
								
								loopingTest++;	//helps break out of the while loop
								break;
						
						case 2: //in case of Non fiction book type
								while(loopTest2==0) {	//this while loop will run until correct numerical inputs have been made
								
									System.out.print("1. Science\n2. History\n3. Biography");	//informs user of the book types
									
									System.out.print("Enter type of non-fictional book: ");	//asks user for the book type they desire
									choice=scan.nextInt();
																		
									scan.nextLine();	//clears the input stream to avoid any errors
									
									switch(choice) {
										case 1: b1[i]=new Science();	//creates a Science book object and adds it to the array
												loopTest2++;
												break;
										
										case 2: b1[i]=new History();	//creates a History book object and adds it to the array
												loopTest2++;
												break;
										
										case 3: b1[i]=new Biography();	//creates a Biography book object and adds it to the array
												loopTest2++;
												break;
												
										default:System.out.println("Wrong choice entered, please try again");	//informs user that an invalid number has been entered
												break;
									}
								}
								loopingTest++;	//helps break out of the while loop
								break;
						
						default:System.out.println("Wrong choice entered, please try again");	//informs user that an invalid book genre type was selected
								break;
								
					}
					
				}
				catch(InputMismatchException e) {
					//tells user that input of invalid data type has been entered
					System.err.println("Input Mismatch Exception while reading book type");
				}
			}
			
			b1[i].readBookInfoFromUser(scan);	//calls readBookInfoFromUser of class Books to read information of each book the user wants
			
		}
	}
	
	
	/**
	 * Takes in input from the file for various properties of the member class
	 * @param scan Allows the compiler to read data from file
	 */
	@Override
	protected void readFromFile(Scanner scan) {
		
		super.readFromFile(scan);	//calls readFromFile method of superclass User
		
		memberID=scan.next();	//stores member ID in memberID variable
		
		age=scan.nextInt();	//stores age of user in age variable
		
		noOfBooks=scan.nextInt();	//stores the no of books in noOfBooks variable
		
		b1=new Books[noOfBooks];	//initializes the b1 Books variable to the desired size specified by user
		
		readBooksFromFile(scan);	//calls the readBooksFromFile method of this class to read book info from file
	}
	
	/**
	 * Takes in input from a file for properties of the books the user wants
	 * @param scan Allows the compiler to read data from file
	 */
	protected void readBooksFromFile(Scanner scan) {
		
		String choice;	//is used in creating correct elements in the b1 Books array
		
		//this for loop runs till all b1 elements are created
		for(int i=0; i<noOfBooks; i++) {
			
			choice=scan.next();	//stores the choice of book type in the choice variable
			
			//this switch statement runs till all elements of the array b1 are created
			switch(choice) {
				case "c": b1[i]=new Comic();	//creates a Comic book object and adds it to the array
							break;
						
				case "f": b1[i]=new Fantasy();	//creates a Fantasy book object and adds it to the array
							break;
							
				case "s": b1[i]=new Science();	//creates a Science book object and adds it to the array
							break;
				
				case "h": b1[i]=new History();	//creates a History book object and adds it to the array
							break;
							
				case "b": b1[i]=new Biography();	//creates a Biography book object and adds it to the array
							break;
					
				default: System.out.println("File contains illegal tokens");	//informs user that file contains invalid choices
							break;
			}
			
			b1[i].readBookInfoFromFile(scan);
		}
		
	}
	
	/**
	 * Prints the attributes of Member objects
	 */
	@Override
	protected void printInfo() {
		
		super.printInfo();	//calls the printInfo method of the superclass User
		
		/* 
		 * displays the member ID and age and leaves gap as those columns have the heading as Section and 
		 * floor, both of which are properties of Staff and not Member
		 */
		System.out.printf("%7s|%5s|%10s|%5d|", memberID, " ", " ", age);
		
		b1[0].printInfo();	//calls printInfo method of class Books to print the details of books
		
		//will print in case multiple books exist for the member
		if(noOfBooks>1) {
			for(int i=1; i<noOfBooks; i++) {
				//prints the appropriate blank spaces leading up to the book info printing
				System.out.printf("%15s|%15s|%15s|%7s|%5s|%10s|%5s|", " "," "," "," "," "," "," ");
				
				//will print out any remaining books for member
				b1[i].printInfo();
			}
		}
			
	}
	
}
