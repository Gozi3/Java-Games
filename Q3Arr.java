import java.util.*;

public class Q3Arr
{
 static int[] array2 = {0,2,3,4,5,6,7,8,9};
 public static void main (String args[])
 {
  int x = 100;
  int array[] = new int [x];
  int array1[] = new int [x];

  Random rn = new Random();
  int s = 100;
  for(int i=0; i<s; i++)
  {
      array1[i]= 1 + rn.nextInt(200);
  }

  makeIntArray(array, x);
  printArray(array);
  findMax(array1);
  dotProduct(array, array1);
  findMax1();


 }
 public static void makeIntArray(int array [], int inVal)
 {
  Random rn = new Random();
  for(int i=0; i<inVal; i++)
  {
      array[i]= 1 + rn.nextInt(200);
  }

 }
 public static void printArray(int array [])
 {
  for(int i = 0; i <array.length; i++)
  {
   System.out.print(array[i] + " ");
  }

 }
 public static void dotProduct(int array1[], int array[])
 {

    int dotP = 0;
    for(int i = 0; i<array.length;i++)
    {
      dotP += (array[i]*array1[i]);
    }
    System.out.println("Dot product is: " + dotP);
  }
  public static void findMax(int array1 [])
 {
  int temp = array1[0];
  for(int i = 0; i<array1.length; i++)
  {
   if(array1[i] > temp)
   {
    temp = array1[i];
   }

  }
  System.out.println("");
  System.out.println("Highest value in array created in main method is: " + temp);
 }
 public static void findMax1()
 {
  int temp = array2[0];
  for(int i = 0; i<array2.length; i++)
  {
   if(array2[i] > temp)
   {
    temp = array2[i];
   }
  }
 }


}