/*
	Check if the first String contains the letter ‘e’. 
	If it does print a message to display the first position of the letter ‘e’ in the String.
*/
	import java.util.*;

public class letterChecker{
	@SuppressWarnings("resource")
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s1 = scan.nextLine();
		char letter = 'e';
		int position = 0;
		for(int i = s1.length()-1;i>=0;i--){
			if(s1.charAt(i) == letter){
				position = i;
			}
		}
		System.out.println(position);
	}
}