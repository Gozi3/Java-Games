import java.util.Scanner;

public class FizzBuzzWoof {

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		int n;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();

		for (int i = 1; i <= n; i++) {
			if (i != n) {
				if (i == 1) {
					System.out.print(i + ",");
				} else if (((i % 3) == 0) && ((i % 5) == 0) && ((i % 7) == 0)) {
					System.out.print(" FizzBuzzWoof,");
				} else if (((i % 5) == 0) && ((i % 7) == 0)) {
					System.out.print(" BuzzWoof,");
				} else if (((i % 3) == 0) && ((i % 7) == 0)) {
					System.out.print(" FizzWoof,");
				} else if (((i % 3) == 0) && ((i % 5) == 0)) {
					System.out.print(" FizzBuzz,");
				} else if (((i % 7) == 0)) {
					System.out.print(" Woof,");
				} else if (((i % 5) == 0)) {
					System.out.print(" Buzz,");
				} else if (((i % 3) == 0)) {
					System.out.print(" Fizz,");
				} else {
					System.out.print(" " + i + ",");
				}
			} else {
				if (((i % 3) == 0) && ((i % 5) == 0) && ((i % 7) == 0)) {
					System.out.print(" FizzBuzzWoof");
				} else if (((i % 5) == 0) && ((i % 7) == 0)) {
					System.out.print(" BuzzWoof");
				} else if (((i % 3) == 0) && ((i % 7) == 0)) {
					System.out.print(" FizzWoof");
				} else if (((i % 3) == 0) && ((i % 5) == 0)) {
					System.out.print(" FizzBuzz");
				} else if (((i % 7) == 0)) {
					System.out.print(" Woof");
				} else if (((i % 5) == 0)) {
					System.out.print(" Buzz");
				} else if (((i % 3) == 0)) {
					System.out.print(" Fizz");
				} else {
					System.out.print(" " + i);
				}
			}
		}
	}
}