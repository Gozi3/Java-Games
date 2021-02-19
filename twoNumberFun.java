/*
	A program that achieves each of the following:
	(i)   Asks the user to enter two integer values. 
	(ii)  Reads in the two numbers from the keyboard. 
	(iii) Determines which is the smaller number and which is the bigger numbers.
	(iv) Determines if the numbers are both odd, both even or one is odd and one is even.
	(iv) Prints out all of the numbers between the smaller and larger number (including the smaller and larger number).
*/

import java.util.*;

public class twoNumberFun{
	@SuppressWarnings("resource")
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter two integer numbers: ");
		int first = scan.nextInt();
		int second = scan.nextInt();
		int sn = first;//sn = smaller number
		int ln = second;//ln = larger number
		if(sn>ln){
			sn = ln;
			ln = first;
		}
		System.out.println("Larger Number : " + ln);
		System.out.println("Smaller Number : " + sn);
		if(first%2 == 0){
			if(second%2 == 0){
				System.out.println("Both are even.");
			}
			else{
				System.out.println("One is odd and one is even.");
			}
		}
		else{
			if(second%2 != 0){
				System.out.println("Both are odd.");
			}
			else{
				System.out.println("One is odd and one is even.");
			}
		}
		for(int i = sn;i<=ln;i++){
			System.out.print(i + " ");
		}
	}
}