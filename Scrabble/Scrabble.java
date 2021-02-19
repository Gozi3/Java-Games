package Scrabble;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Scrabble {
    public static void main(String args[]) throws IOException {
        Scanner scan = new Scanner(System.in);
        Scanner read = new Scanner(new File("C:/Users/Nosa/Google Drive/Coding_Folder/Java/Scrabble/Dictionary.txt"));
        System.out.println("Enter your letters: ");
        String in = scan.nextLine();
        System.out.println("\nHere are the top suggestions: \n");
        ArrayList<String> d = new ArrayList<String>();
        while (read.hasNextLine()) {
            d.add(read.nextLine());
        }
        String[] dictionary = d.toArray(new String[d.size()]);
        char dict[][] = new char[dictionary.length][];
        for (int i = 0; i < dict.length; i++) {
            dict[i] = dictionary[i].toCharArray();
            Arrays.sort(dict[i]);
        }
        char[] input = in.toCharArray();
        Arrays.sort(input);
        char[] temp = in.toCharArray();
        Arrays.sort(temp);
        ArrayList<String> suggestions = new ArrayList<String>(dict.length);
        for (int x = dict.length - 1; x > -1; x--) {
            input = Arrays.copyOf(temp, temp.length);
            if (dict[x].length <= input.length) {
                if (isInDict(input, dict[x])) {
                    suggestions.add(dictionary[x]);
                }
            }
        }
        String[] suggested = suggestions.toArray(new String[suggestions.size()]);
        mergeSort(suggested);
        int len = (suggested.length < 10) ? suggested.length : 10;
        for (int i = 0; i < len; i++) {
            System.out.println(suggested[i]);
        }
        scan.close();
        read.close();
    }

    public static boolean isInDict(char[] input, char[] dict) {
        for (int y = (dict.length) - 1; y > -1; y--) {
            if (!isLetterInWord(input, dict[y])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLetterInWord(char[] input, char dict) {
        for (int z = input.length - 1; z > -1; z--) {
            if (dict == input[z]) {
                input[z] = '*';
                return true;
            }
        }
        return false;
    }

    public static void mergeSort(String[] inputArray) {
        int size = inputArray.length;// size of the array
        if (size < 2) {
            return;
        } // if the array is 1 its already sorted
        int mid = size / 2;// gets the halfway point to split the array in half
        int leftSize = mid;// size of the left array
        int rightSize = size - mid;// size of the right array
        String[] left = new String[leftSize];// creates the left array
        String[] right = new String[rightSize];// creates the right array
        for (int i = 0; i < mid; i++) {// fills the left array with the values of the left side of the array
            left[i] = inputArray[i];

        }
        for (int i = mid; i < size; i++) {// fills the right array with the values of the right side of the array
            right[i - mid] = inputArray[i];
        }
        mergeSort(left);// repeatedly divides the left array into smaller halves and sorts it
        mergeSort(right);// repeatedly divides the right array into smaller halves and sorts it
        merge(left, right, inputArray);// combines the sorted halves into the original array
    }

    public static void merge(String[] left, String[] right, String[] array) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0;// leftIndex
        int j = 0;// rightIndex
        int k = 0;// tempIndex
        while (i < leftSize && j < rightSize) {
            if (left[i].length() >= right[j].length()) {
                array[k] = left[i];
                i++;
                k++;
            } else {
                array[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < leftSize) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}