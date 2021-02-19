/*
	Asks the user to enter a four-digit number.

	If the user does not enter a four-digit number, an error message should print and the program should terminate.

	If the user enters a four-digit number, the program should determine and display the number of thousands, hundreds, tens, and single digits in a four digit number.

	For example: 1000 is composed of 1 thousand, 0 hundreds, 0 tens and 0 digits.
	4792 is composed of 4 thousand, 7 hundreds, 9 tens and 2 digits.
*/

import java.util.*;

public class fourDigitSplitter{
	@SuppressWarnings("resource")
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		boolean valid = false;
		while(!valid){
			System.out.print("Enter a four-digit number: ");
			String num = scan.nextLine();
			if(num.length() != 4){
				System.out.println("Psych! That's the wrong number.");
			}
			else{
				valid = true;
				System.out.println(num + " is composed of " + num.substring(0,1) + " thousand, " + num.substring(1,2) + " hundreds, " + num.substring(2,3) + " tens, " + num.substring(3,4) + " digits.");
			}
		}		
	}
}            