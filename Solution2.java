import java.util.Scanner;

public class Solution2
{
	@SuppressWarnings("resource")
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int r = 0, option = 0;
		float pi = 3.14159f;
		System.out.println("Please enter the radius of the circle: ");
		r = scan.nextInt();
		System.out.println("Please enter 1 to calculate the area of the circle or 2 to calculate the circumference of the circle: ");
		option = scan.nextInt();
		int d = 2*r;

		if(option == 1)
		{
			System.out.println("The area of the circle is " + (pi*(r*r)) + ".");

		}
		else
		{
			System.out.println("The circumference of the circle is " + pi*d + ".");
		}

	}
}