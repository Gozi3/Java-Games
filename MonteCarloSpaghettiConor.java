import java.util.Random;
import java.util.Scanner;

public class MonteCarloSpaghettiConor {
  public static void main(String[] args) {
    // Scan in inputs
    Scanner scan = new Scanner(System.in);

    int simulations = 1000000;
    int triangleCounter = 0;
    for (int i = 0; i < simulations; i++) {
      Random r = new Random();
      int length = 100;
      /* ---------/--------/--- */
      double a = r.nextDouble() * length;
      double b = r.nextDouble() * length;
      if (a > b) {
        double t = a;
        a = b;
        b = t;
      }
      double[] sides = { a, b - a, length - b };
      if (sides[0] < (sides[1] + sides[2]) && sides[1] < (sides[0] + sides[2]) && sides[2] < (sides[0] + sides[1])) {
        triangleCounter++;
      }

    }
    System.out.println(Math.round(100.0 * triangleCounter / simulations));
    scan.close();
  }
}