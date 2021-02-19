/*
	A program that achieves the following: 
	(i)  Asks the user to enter an interger number and stores that number in a variable called noOfStars
	(ii)  Uses one or more loops to print rows of stars to the screen.
		  The number of stars on the last line and the number of lines of stars is the same as the value of noOfStars.
		  For example, if noofStars is 6 then the following would print:

		  * 
		  ** 
		  *** 
		  **** 
		  ***** 
		  ******

*/

import java.util.*;

public class halfStarTree{
	@SuppressWarnings("resource")
	public static void main(String args[]){
		Scanner scan = new Scanner (System.in);
		System.out.print("Enter an integer number: ");
		int noOfStars = scan.nextInt();
		for(int i =0;i<noOfStars;i++){
			for(int j = 0;j<i;j++){
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}