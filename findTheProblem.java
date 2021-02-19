/*Explain three potential run time problems that could occur with the code shown below. 
Suggest how you would modify the code shown below to prevent a program crash caused by any two potential problems? */
import java.util.*;

public class findTheProblem{

	@SuppressWarnings("resource")
	public static void main(String args[]){
		double num,result; 
		Scanner keyboard = new Scanner(System.in); 
		System.out.print("Enter number :"); 
		num = keyboard.nextDouble(); 
		result=Math.sqrt(num)/num; 
		System.out.println("Result:"+result);
	}
}
/*	
 	If someone enters a letter instead of a number.
 	If someone puts in a number thats bigger than what double's can hold.
	If the number put in is less than 0	since the square root of a negative number doesnt exist.
*/