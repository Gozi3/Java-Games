import java.util.*;

public class primeBounds {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    for (int i = 0; i < n; i++) {
      int lowerB = scan.nextInt();
      int upperB = scan.nextInt();
      long start = System.currentTimeMillis();
      System.out.println("Number of Primes in between bounds: " + fasterWay(lowerB, upperB));
      long fTime = System.currentTimeMillis() - start;
      System.out.println("Fast Algorithm Time: " + fTime + "ms");
      // start = System.currentTimeMillis();
      // System.out.println("Number of Primes in between bounds: " + slowWay(lowerB,
      // upperB));
      // long sTime = System.currentTimeMillis() - start;
      // System.out.println("Slow Algorithm Time: " + sTime + "ms");
    }
    scan.close();
  }

  private static int fasterWay(int lowerB, int upperB) {
    boolean prime[] = createPrimeArray(upperB);

    int i = lowerB;
    int numPrimes = 0;
    if (upperB < 3) {
      return numPrimes;
    } else {
      if (lowerB < 3) {
        i = 3;
        numPrimes++;
      } else if (i % 2 == 0) {
        i++;
      }
      while (i < upperB) {
        if (prime[i] == true) {
          numPrimes++;
        }
        i += 2;
      }
      return numPrimes;
    }
  }

  private static boolean[] createPrimeArray(int upperB) {
    boolean prime[] = new boolean[upperB];
    if (upperB < 3) {
      Arrays.fill(prime, false);
      return prime;
    } else {
      Arrays.fill(prime, true);
    }

    // 0,1 are not prime numbers
    prime[0] = false;
    prime[1] = false;

    // 2 is a prime number
    prime[2] = true;

    int i = 2;
    // loop to the upper bound
    while (i < upperB) {

      // prime[i] = true;
      // starting from the next multiple from the prime
      int x = i + i;
      // start marking numbers all the multiples of x as false
      while (x < upperB) {
        prime[x] = false;
        x += i;
      }
      // next
      i++;
      // if its not a prime keep skipping until we hit one
      while (i < upperB && prime[i] == false) {
        i++;
      }
      // System.out.println("Prime Map: " + Arrays.toString(prime));
    }
    return prime;
  }
  // private static int slowWay(int lowerB, int upperB) {
  // int i = lowerB;
  // int numPrimes = 0;
  // if (upperB < 3) {
  // return numPrimes;
  // } else {
  // if (lowerB < 3) {
  // i = 3;
  // numPrimes++;
  // } else if (i % 2 == 0) {
  // i++;
  // }
  // while (i < upperB) {
  // if (isPrime(i)) {
  // numPrimes++;
  // }
  // i += 2;
  // }
  // return numPrimes;
  // }
  // }

  // private static boolean isPrime(int number) {
  // for (int i = 2; i < number / 2; i++) {
  // if (number % i == 0) {
  // return false;
  // }
  // }
  // return true;
  // }
}