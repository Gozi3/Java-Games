package DiscountConditons;

import javax.swing.JOptionPane;
// import java.util.Scanner;

/**
 * discountConditions
 */
public class discountConditions {

    public static void main(String[] args) {
        /*
         * Scanner scan = new Scanner(System.in);
         *
         * // Ask whether the customer is a Co-op Member
         * System.out.print("Are you a Co-op member? (T/F) "); // boolean member =
         * scan.nextLine() == "T"; String memberInput = scan.nextLine(); boolean member
         * = false; if (memberInput == "T") { // If the user is a member member = true;
         * // Make member true }
         *
         * // Find out whether shopping is on Weekends or Weekdays
         * System.out.print("Enter if your shopping is on 'weekend' or 'weekday'? ");
         * String days = scan.nextLine(); // Stores users input as a String
         *
         * // Ask for the total cost of the customer's shopping
         * System.out.print("Enter the total cost of your shopping: $"); double cost =
         * scan.nextDouble(); // Store the users input as a double (decimal value)
         *
         * double discount = discountCalc(member, days, cost);
         * System.out.println("Discount Applied is " + discount); scan.close();
         */
        String member = JOptionPane.showInputDialog(null, "Are you a Co-op member? (true/false)");
        System.out.println("Member: " + member);
        String days = JOptionPane.showInputDialog(null, "Enter if your shopping is on 'weekend' or 'weekday'? ");
        System.out.println("Days: " + days);
        double cost = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the total cost of your shopping: $"));
        System.out.println("Cost: " + cost);
        Discount discount = new Discount(member, days, cost);
        JOptionPane.showMessageDialog(null, "Discount Applied is " + discount.computeDiscount());
    }
}