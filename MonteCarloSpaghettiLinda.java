import java.util.*;

public class MonteCarloSpaghettiLinda {
  public static void main(String args[]) {

    // Create a count to keep track of how many successful trials
    double sum = 0.0;

    // Create a count to keep track of the amount of iterations
    int numberOfIterations = 0;
    double simulations = 1000000.0;

    // Loop the entire process to find a probability
    while (numberOfIterations <= simulations) {

      // Create an instance of a random
      Random rd = new Random();
      int spaghetti = 100;

      // Create an array of size 3 and fill it with random values
      int[] myArray = new int[3];

      for (int i = 0; i < 2; i++) {
        myArray[i] = rd.nextInt(spaghetti);
        spaghetti -= myArray[i];
      }
      myArray[2] = spaghetti;

      // Using the triangle inequality rule determine if the 3 sides make a triangle
      if ((myArray[0] + myArray[1] > myArray[2]) && (myArray[0] + myArray[2] > myArray[1])
          && (myArray[1] + myArray[2] > myArray[0])) {
        sum += 1.0;
      }

      // Bubble sort the array to find biggest value
      // else {

      // // Bubble sort the array
      // int temp = 0;
      // for (int pass = 0; pass < 2; pass++) {
      // for (int i = 0; i < 2; i++) {
      // if (myArray[i] > myArray[i + 1]) {
      // temp = myArray[i];
      // myArray[i] = myArray[i + 1];
      // myArray[i + 1] = temp;
      // }
      // }
      // }

      // // Loop through array to "nibble" some of the spaghetti
      // int temp2 = myArray[2];
      // for (int x = 0; x <= 15; x++) {
      // // Minus .x from the length
      // myArray[2] = myArray[2] * (1 - (x / 100));

      // // Check condition again to see if it will make a triangle now
      // // If it does, add one to sum and break
      // if ((myArray[0] + myArray[1] > myArray[2]) && (myArray[0] + myArray[2] >
      // myArray[1])
      // && (myArray[1] + myArray[2] > myArray[0])) {
      // sum += 1.0;
      // break;
      // }

      // // If it's not true, reset the value of myArray[2]
      // myArray[2] = temp;
      // }
      // }

      // reset spaghetti and increase amount of iterations
      numberOfIterations++;
    }
    System.out.println("Probability = " + (sum / simulations) * 100 + "%");

  }
}
