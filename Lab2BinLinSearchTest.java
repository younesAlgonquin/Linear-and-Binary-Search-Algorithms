
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * This class tests the program by displaying a menu of options and prompts users to choose one of them.
 * then it displays an array of integers and performs binary and iterative search
 * Section #: 303
 * Course: CST8130 - Data Structures
 * @version 1.0
 * 
 */
public class Lab2BinLinSearchTest {

	/**
	 * This is the method main where we test our program
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Scanner object used to get the user's inputs
		Scanner input = new Scanner(System.in).useDelimiter("\r\n");
		//BinaryLinearSearch object used to declare an array and call search methods
		BinaryLinearSearch demo = new BinaryLinearSearch(30);
		//this array will store the element of the generated array
		int[] randomArr = null;
		//This is the menu option that will be entered by users
		int option =0;
		//The while loop display the menu and executes the chosen option in each iteration until the Exit option is chosen 
		while(option !=4) {
			
			//this formats and prints the options menu
			String formatString = "\n\nSelect your option in the menu:\n";
			formatString += "%d. Initialize and populate an array of 30 random integers.\n";
			formatString += "%d. Perform recursive binary and linear search.\n";
			formatString += "%d. Perform iterative binary and linear search.\n";
			formatString += "%d. Exit.\n";
			System.out.print(String.format(formatString, 1, 2, 3, 4));
		
			//checks for integer input
			try {
				option = input.nextInt();
				
				//This is the switch statement  that executes the user's choice
				switch(option) {
				//in this case it generates an array of random integers, sorts it, and prints it
				case 1: 
					randomArr= (demo.generateRandomInts()).clone();
					break;
			
				//in this case the program prompts users to enter the value to search then displays the recursive binary & linear search results and timing
				case 2:
					//checks for integer input
					try {
						System.out.print("Please enter an integer value to search: ");
						int key = input.nextInt();
						//calls the recursive search methods
						demo.recursiveBinarySearchTiming(randomArr, 0, randomArr.length-1, key);
						demo.recursiveLinearSearchTiming(randomArr, randomArr.length, key);
					//it outputs an error message in case of non-integer input
					}catch (InputMismatchException ex) {
						System.out.printf("*****Input Mismatch Exception*****", ex);
						input.nextLine();
					}//end try & catch
					//ends the switch statement 
					break;
			
				//in this case the program prompts users to enter the value to search then displays the iterative binary & linear search results and timing
				case 3:
					//checks for integer input
					try {
						System.out.print("Please enter an integer value to search: ");
						int key = input.nextInt();
						//calls the recursive search methods
						demo.iterativeBinarySearchTiming(randomArr, key);
						demo.iterativeLinearSearchTiming(randomArr, key);
					//it outputs an error message in case of non-integer input
					}catch (InputMismatchException ex) {
						System.out.printf("*****Input Mismatch Exception*****", ex);
						input.nextLine();
					}//end try & catch
					//ends the switch statement 
					break;
			
				//This option shutdown the program
				case 4:
					System.out.println("exiting...");
					//ends the switch statement 
					break;
			
				//it outputs an error message if the option input is not 1, 2, 3 or 4
				default:
					System.out.println("Please choose the option 1 to 4.");
					//ends the switch statement 
					break;
	
				}//end switch
			//it outputs an error message in case of non-integer input
			}catch (InputMismatchException ex) {
			System.out.printf("*****Input Mismatch Exception*****", ex);
			input.nextLine();
			}//end try & catch
		}//end while
		
		//closes the Scanner object
		input.close();
		
	}//end main	

}//end class
