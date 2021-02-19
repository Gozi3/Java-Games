public class CS143_1B
{
	public static void main(String args[])
	{
		int x = 0;
		int array[] = new int[11];
		int i = 0;
		for(x = 0;x<=100; x++)
		{
			int y = x*x;
			if(y <= 100)
			{
				array[i] = x;
				i++;
			}

		}
		for(int j = 0;j<array.length; j++)
		{
			System.out.println(array[j]);
		}
//***********************************************************************//

	}

}