public class fibRecursive
{
	public static void main(String args[])
	{
		System.out.println(fibonacci(1));
	}
	public static int fibonacci(int n)
	{
		if(n < 3)
		{
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
}