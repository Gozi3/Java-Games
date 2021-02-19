/*
	Write a program that asks the user to enter 10 integers. 
	The program should output the largest number, the smallest number and the average of all numbers. 
*/
	import java.util.*;

	public class largestNumber{
		@SuppressWarnings("resource")
		public static void main(String args[]){
			Scanner scan = new Scanner(System.in);
			int temp,largestNumber,smallestNumber,average;
			System.out.print("Enter 10 integers: ");
			temp = scan.nextInt();
			largestNumber = temp;
			smallestNumber = temp;
			average = temp;
			for(int i = 0;i<9;i++){
				temp = scan.nextInt();
				average += temp;
				if(temp>largestNumber){
					largestNumber = temp;
				}
				if(temp<smallestNumber){
					smallestNumber = temp;
				}
			}
			System.out.println("The largest number is : " +  largestNumber);
			System.out.println("The smallest number is : " + smallestNumber);
			System.out.println("The average number is : " + average/10);
		}
	}