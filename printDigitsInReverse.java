/*
	Write a Java program that determines and prints the digits in a five digit number one-per-line in reverse order.
	The progam should initialise a variable to store a five-digit number (that is, you do not need to ask the user to enter the number).
	For example, for the number 27453, the program should print:  
	The digits in the number 27453 in reverse order are:  
	3
	5
	4
	7
	2
*/

import java.util.Scanner;

public class printDigitsInReverse
{
	@SuppressWarnings({ "resource" })
	public static void main (String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a 5-digit number");
		String num = sc.nextLine();
		for (int x=num.length()-1; x>=0; x--)
		{
			System.out.println(num.charAt(x));
		}
	}
}