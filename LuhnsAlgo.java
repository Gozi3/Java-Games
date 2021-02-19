import java.util.*;

public class LuhnsAlgo {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in); // Scanner for user to input stuff
        String ccNo; // variable to hold the credit card number
        ccNo = scan.nextLine(); // asks user for cerdit card number
        // checks if the number is valid according to the Luhn formula using the check
        // sum method
        if (checkSum(ccNo)) {
            System.out.println("Credit Card Number Valid");
        } else {
            System.out.println("Credit Card Number Invalid");
        }
        scan.close();
    }

    // This is checksum formula
    public static boolean checkSum(String ccNo) {
        int check; // stores the current number we're on
        int sum = 0; // stores the sum of the numbers
        String checkNo = ""; // builds up the new credit card number
        boolean second = true; // tells us whether we're on the next second digit or naah
        // loops through the ccNo from the right to the left (so... backwards)
        for (int i = ccNo.length() - 1; i >= 0; i--) {
            // *sigh* basically, gets the current char in the string, "ccNo.charAt(i)"
            // then changes it into a string, String.valueOf()
            // so it can be parsed into an int, Integer.parseInt()
            check = Integer.parseInt(String.valueOf(ccNo.charAt(i)));
            if (second) { // if we're on a second digit
                check *= 2; // double the value of the current number
                if (check > 9) { // if its a 2-digit number

                    check -= 9; // subtract 9 (same thing as adding the two digits to each other)
                }
                // adds the new number to the new credit card number
                checkNo = Integer.toString(check) + checkNo;
                // adds number to the sum to get the total
                sum += check;
                // changes second to the opposite cause the next number isnt another second
                // digit
                second = false;
            } else {
                checkNo = Integer.toString(check) + checkNo; // same as above
                sum += check; // same as above
                second = true; // same as above
            }
        }
        System.out.println("Check No.: " + checkNo);
        System.out.println("Sum: " + sum);
        System.out.println("x = " + (10 - ((sum) % 10)));
        if (((sum) % 10) == 0) { // if the sum mod 10 is 0
            return true;
        } else { // if it's not
            return false;
        }
    }
}
