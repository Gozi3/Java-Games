package Google_HashCode.hashCodeSolution;

//---------------------------//
//Team name - A Team Of Sorts//
//---------------------------//

// Imports & Packages
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// Class Declaration

public class hashCodeSolution {

    // Global Variables
    public static int T;// creates the variable that store the number of turns
    public static int D;// creates the variable that store the number of drones
    public static int product[];// creates the variable that stores the product info
    public static int warehouse[][];// creates the variable that stores the warehouse info
    public static Drone drone[];// creates the variable that stores the drone objects
    public static String command[];// creates the variable that stores the commands Load/Unload/Deliver/Wait
    public static String dStartLoc;// creates the variable that stores the drones starting location, which is the
                                   // location of the first warehouse
    public static int R;// creates the variable that stores the number of rows in the simulation
    public static int C;// creates the variable that stores the number of columns in the simulation
    // Methods Declaration

    public static void main(String args[]) throws IOException {
        // Scanners
        Scanner input = new Scanner(System.in);// keyboard scanner
        Scanner scan = new Scanner(new File(input.nextLine()));// file scanner

        // Simulation
        R = scan.nextInt();// rows
        C = scan.nextInt();// columns
        // Drones/Turns
        D = scan.nextInt();// number of drones
        T = scan.nextInt();// simulation deadline/ the number of turns
        int maxDWeight = scan.nextInt();// drone weight
        // Products
        int P = scan.nextInt();// number of product types
        // product[type] = product weight
        product = new int[P];
        // stores the weights of the products
        for (int i = 0; i < P; i++) {
            product[i] = scan.nextInt();
        }

        // Warehouses
        int W = scan.nextInt();// stores number of warehouses
        warehouse = new int[W][P];// stores a known no. of product items of each product type in the specified
                                  // warehouse e.g. warehouse[warehouse no.][product type] = no. of items
        String whLocation[] = new String[W];// stores warehouse locations of warehouse[i]
        for (int i = 0; i < W; i++) {
            scan.nextLine();
            whLocation[i] = scan.nextLine();// stores the locations of warehouse at warehouse[warehouse number] = row +
                                            // " " + column
            for (int j = 0; j < P; j++) {
                warehouse[i][j] = scan.nextInt();// number of items of THAT(j) type of product in THAT(i) warehouse
            }
        }
        dStartLoc = whLocation[0];

        // Orders
        int O = scan.nextInt();// stores the number of orders
        int order[][] = new int[O][P];// stores order[order number][product type] = no. of items;
        String orderLoc[] = new String[O];// stores the orders location
        for (int i = 0; i < O; i++) {
            scan.nextLine();
            orderLoc[i] = scan.nextLine();// stores the orders location
            Arrays.fill(order[i], 0);
            int I = scan.nextInt();// stores the number of items in the order

            for (int j = 0; j < I; j++) {
                int nP = scan.nextInt();// stores the next product type to assign the next product item quantity to
                order[i][nP]++;// stores the number of items of each product type
            }
        }

        // create drones
        drone = new Drone[D];
        for (int i = 0; i < D; i++) {
            drone[i] = new Drone(maxDWeight);
        }
        // Command
        command = new String[D * T];// makes the size of the command array equal to the maximum possible number of
                                    // commands allowed
        int Q = 0;

        // Actual Simulation
        while (T > 0) {
            for (int i = 0; i < O; i++) {
                for (int j = 0; j < order[i].length; j++) {
                    int count = 0;
                    int index = 0;
                    while (order[i][j] != 0) {
                        T -= drone[count].Load(Q, order[i][j], i, whLocation, index);
                        if (T <= 0) {
                            break;
                        }

                        T -= drone[count].Deliver(order[i], orderLoc[i]);
                        if (T <= 0) {
                            break;
                        }
                        System.out.println(T + " count: " + count);
                        count++;
                    }
                    if (T <= 0) {
                        break;
                    }
                    System.out.println("We made it!");
                }
            }
        }
        input.close();
    }

    // prints out all the commands and the number of commands at the end
    public static void printAnswer(String answer[], int answerSize) {
        System.out.println(answerSize);
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == null) {
                break;
            } else {
                System.out.println(answer[i]);
            }
        }
    }
}