import java.util.Scanner;

public class cPlusCPlus2Java {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n;
    System.out.printf("How many numbers would you like to enter?\n");
    n = scan.nextInt();
    int array[] = new int[n];
    for (int i = 0; i != n; i++) {
      System.out.printf("Enter number %d: ", i + 1);
      array[i] = scan.nextInt();
    }
    scan.close();
  }
}