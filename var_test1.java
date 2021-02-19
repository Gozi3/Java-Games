public class var_test1
{
	public static void main (String args[])
	{
		int num1 = 10, num2 = 20;

		num1 += num2;
		System.out.println("Num1: " + num1);

		num1 -=num2;
		System.out.println("Num1: " + num1);

		num1*=num2;
		System.out.println("Num1: " + num1);

		num1/=num2;
		System.out.println("Num1: " + num1);
	}

}