/*
	Java Program that achieves the following: 
	(i) Asks the user to enter a String representing a typical Irish 12-Digit mobile phone number composed of a:
		3 digit international code, 2 digit operator code, and seven digit number. For example 353874123122

	(ii) Checks that exactly 12 digits have been entered. 
		 The program should prompt the user to enter exactly 12 digits and not progress until they have done so.

	(iii) The program should print the 12 digit number, the international code, the operator code, the seven-digit number and the complete number formatted.
*/
import java.util.*;

public class phoneNumberFormat{
	@SuppressWarnings("resource")
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String number = new String("");
		boolean has12Digits = false;//assumes there arent going to be 12 digits (cause we're pessimistic like that)
		while(!has12Digits){//as long as its not a 12 digit number keep asking the user
			System.out.print("Enter in a 12-Digit number: ");
			number = scan.nextLine();
			if(number.length() == 12){//if it has the 12 digits
				has12Digits = true;//then its a 12 digit number
			}
			else{
				System.out.println("Psych! That's the wrong number.");//tell the user its not
			}
		}
		System.out.println("This is you number: " + number);
		System.out.println("This is you're international code: " + number.substring(0,3));
		System.out.println("This is you're operator code: " + number.substring(3,5));
		System.out.println("This is you're number code: " + number.substring(5));
		System.out.println("+" + number.substring(0,3) + " " + number.substring(3,5) + " " + number.substring(5));
	}
} 