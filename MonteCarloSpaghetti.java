import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MonteCarloSpaghetti {
  public static void main(String[] args) {
    // Scan in inputs
    Scanner scan = new Scanner(System.in);
    double nibbles = scan.nextInt();

    double simulations = 1000000;
    double triangleCounter = 0;
    for (int i = 0; i < simulations; i++) {
      Random r = new Random();
      double length = 100;
      double[] sides = new double[3];
      sides[0] = r.nextDouble() * length + 1;
      sides[1] = r.nextDouble() * length + 1;
      Arrays.sort(sides);
      double temp = sides[0];
      sides[0] = sides[1];
      sides[1] = temp;
      sides[2] = length - sides[1];
      sides[1] = sides[0] - sides[1];
      System.out.println(Arrays.toString(sides));

      if (triangleChecker(sides)) {
        triangleCounter++;
        // System.out.println("Triangle Counter: " + triangleCounter);
      } else {
        sides[1] *= nibbles;
        if (triangleChecker(sides)) {
          triangleCounter++;
        }
      }

    }
    System.out.println((int) ((triangleCounter / simulations) * 100));
    scan.close();
  }

  public static boolean triangleChecker(double[] sides) {
    return sides[0] < (sides[1] + sides[2]) && sides[1] < (sides[0] + sides[2]) && sides[2] < (sides[0] + sides[1]);
  }
}