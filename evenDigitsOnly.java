import java.util.*;

public class evenDigitsOnly {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        System.out.println(evenOnly(input));
        scan.close();
    }

    public static boolean evenOnly(int n) {
        String num = Integer.toString(n);
        String array[] = num.split("");
        for (int i = 0; i < array.length; i++) {
            if (Integer.parseInt(array[i]) % 2 != 0) {
                return false;
            } else {

            }
        }
        return true;
    }
}
