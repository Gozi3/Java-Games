import java.util.Scanner;

public class Solution1
{
	@SuppressWarnings("resource")
	public static void main(String args[])
	{
		int input = 0, count = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an integer number: ");
		input = scan.nextInt();
		if((input%2) == 0)
		{
			System.out.println(input + " is an even number.");
			if(input == 2)
			{
				System.out.println(input + " is a prime number as it is only divisible by 1 and " + input + ".");
			}
			else
			{
				System.out.println(input + " is not a prime number. It is divisible by 2.");
			}

		}
		else
		{
			System.out.println(input + " is an odd number.");
			for(int i = 3; i<input; i++)
			{
				if((input%i)==0)
				{
					count  = i;
				}
			}
			if(count == 0)
			{
				System.out.println(input + " is a prime number as it is only divisible by 1 and " + input + ".");

			}
			else
			{
				System.out.println(input + " is not a prime number. It is divisible by " + count + ".");
			}
		}
	}
}