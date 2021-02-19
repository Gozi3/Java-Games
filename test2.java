import java.util.Scanner;

public class test2 {

    @SuppressWarnings({ "resource" })
    public static void main(String args[]) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner scan = new Scanner(System.in);
        String num = new String(" ");
        int x;
        int y;
        String z;
        num = scan.nextLine();
        x = Integer.parseInt(num.substring(0, 1));
        y = Integer.parseInt(num.substring(1));
        for (int i = 1; i < num.length() + 1; i++) {
            z = num.substring(i, i + 1);
            for (int a = 0; a < z.length() + 1; i++) {
                Integer.parseInt(z.substring(a, a + 1));

            }
        }
        System.out.print(x + " " + y);
    }
}