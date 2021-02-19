import java.math.*;
import java.util.*;

public class Ackermann {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the first number for the Ackermann function: ");
        int maxM = scan.nextInt();
        System.out.print("Enter the second number for the Ackermann function: ");
        int maxN = scan.nextInt();

        System.out.println(
                "\nThe Ackermann Function will now print out the Ackermann numbers up to the stated numbers... \n");

        System.out.println("The Ackermann Number of m: " + maxM + " and n: " + maxN + " is:");
        System.out.println(Ack(BigInteger.valueOf(maxM), BigInteger.valueOf(maxN)).toString());
        scan.close();
    }

    public static BigInteger Ack(BigInteger m, BigInteger n) {
        if (m.equals(BigInteger.ZERO)) {
            return n.add(BigInteger.ONE);
        } else if (n.equals(BigInteger.ZERO)) {
            return Ack(m.subtract(BigInteger.ONE), BigInteger.ONE);
        } else {
            return Ack(m.subtract(BigInteger.ONE), Ack(m, n.subtract(BigInteger.ONE)));
        }
    }
}