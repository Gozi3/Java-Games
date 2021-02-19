import java.util.*;

public class stick {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter how many times you want to carry out the process: ");
		int run = scan.nextInt();
		int temp = run;
		double total = (double) run;
		int yes = 0;
		double arraySticks[] = new double[run * 3];
		int count = 0;
		while (run > 0) {
			double stickMain = 1000;
			double stick[] = new double[3];
			double random1 = Math.random();
			stick[0] = stickMain * random1;
			arraySticks[count] = stick[0];
			count++;
			stick[1] = stickMain - stick[0];
			arraySticks[count] = stick[1];
			count++;
			if (stick[0] > stick[1]) {
				double random2 = Math.random();
				stick[2] = stick[0] * random2;
				arraySticks[count] = stick[2];
				count++;
			} else {
				double random2 = Math.random();
				stick[2] = stick[1] * random2;
				arraySticks[count] = stick[2];
				count++;
			}
			if (isTriangle(stick[0], stick[1], stick[2])) {
				yes++;
			}
			run--;
		}

		double prob = yes / total;
		System.out.println("Normal Answer: " + prob);
		System.out.println("Advanced Answer: " + advQ(arraySticks, temp));

	}

	public static boolean isTriangle(double a, double b, double c) {
		if (a + b > c) {
			if (b + c > a) {
				if (a + c > b) {
					return true;
				}
			}
		}
		return false;
	}

	public static double advQ(double arraySticks[], int run) {
		double total = (double) run;
		int yes = 0;
		while (run > 0) {
			double stick[] = new double[3];
			int random = (int) (Math.random() * 100);
			stick[0] = arraySticks[random];
			random = (int) (Math.random() * 100);
			stick[1] = arraySticks[random];
			random = (int) (Math.random() * 100);
			stick[2] = arraySticks[random];
			if (isTriangle(stick[0], stick[1], stick[2])) {
				yes++;
			}
			run--;
		}
		double prob = yes / total;
		return prob;
	}
}