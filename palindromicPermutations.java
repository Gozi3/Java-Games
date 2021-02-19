import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * palindromicPermutations
 */
public class palindromicPermutations {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter number strings to check:");
    int n = scan.nextInt();
    scan.nextLine();
    for (int i = 0; i < n; i++) {
      String sA = scan.nextLine().toLowerCase();
      sA.replaceAll("\\s+", "");
      ArrayList<Character> cA = new ArrayList<Character>();
      for (char c : sA.toCharArray()) {
        cA.add(c);
      }
      Collections.sort(cA);
      System.out.print(cA.toString());
      for (int j = 0; j < cA.size() - 1; j++) {
        if (cA.get(j) == cA.get(j + 1)) {
          cA.remove(j);
          System.out.println(cA.toString());
          cA.remove(j);
          System.out.println(cA.toString());
          j -= 1;
        }
      }
      if (1 == cA.size() || 0 == cA.size()) {
        System.out.println(true);
      } else {
        System.out.println(false);
      }
      System.out.print(cA.toString());

    }
    scan.close();
  }
}