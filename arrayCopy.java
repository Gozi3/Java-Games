public class arrayCopy
{
	public static void main (String args[])
	{
		int arr1[] = {0,1,2,3,4,5,6,7,8,9};
		int arr2[] = {0,0,0,0,0,0,0,0,0,0,10,11,12,13,14,15};
		System.arraycopy(arr1,0,arr2,0,10);
		
		System.out.print("The elements in arr2 are : \n0");
		for(int i = 1; i<arr2.length;i++)
		{
			System.out.print(", " + arr2[i]);
		}
		System.out.print(". \nFinished!");
	}
}