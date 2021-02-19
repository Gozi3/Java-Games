import java.util.*;

public class reverseStringChecker
{
	@SuppressWarnings("resource")
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);//creates the scanner
		System.out.println("Do you want to check if two Strings are the same reversed?");//asks the user if they would like to compare two strings
		System.out.println("Enter 0 for 'Yes' or enter any other number for 'No':");//tells them to enter 0 for yes and any other number for no
		int input = scan.nextInt();//scans in the their answer
		while(input == 0){//keeps looping until the user says no (enters a number other than 0)
			boolean isSameReversed = true;
			scan.nextLine();//you have to put this here cause when you use nextInt() the first nextLine() after doesn't work
			System.out.println("Please enter the first String to be comapred:");//asks for the first String
			String s1 = scan.nextLine();//stores the first String;
			System.out.println("Please enter the second String to be comapred:");//asks for the second String
			String s2 = scan.nextLine();//stores the second String;
			if(s1.length() == s2.length()){//if the two Strings are the same length
				for(int i = 0;i<s1.length();i++){//loops through the String
					//this is a bit hard to understand but basically... it checks if the nth position and the the nth position from the back is equal.
					//e.g star and rats: s1.charAt(0) == s2.charAt(3), s1.charAt(1) == s2.charAt(2) etc..
					if(s1.charAt(i) != s2.charAt(s2.length()-1-i)){//If they're not
						isSameReversed = false;//because it's not
						System.out.println("The two Strings are not the same reversed.");//tell the user its not
						break;// and stops checking.. which takes it out of the for loop -> to line 27
					}
				}
				if(isSameReversed){//if isSameReversed is still true...
					System.out.println("The two Strings are the same reversed.");//tell the user it is
				}
			}
			else{//if they're not
				System.out.println("The reverse of the second String cannot be the same as the first String because they have different lengths.");//tell the user its not
			}
			System.out.println("");
			System.out.println("Do you want to check if two Strings are the same reversed again?");//asks the user if they would like to compare two strings
			System.out.println("Enter 0 for 'Yes' or enter any other number for 'No':");//tells them to enter 0 for yes and any other number for no
			input = scan.nextInt();//scans in the their answer

		}

	}
}