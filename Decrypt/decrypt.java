package Decrypt;

import java.io.*;
import java.util.*;
import java.text.*;

public class decrypt {
    /**
     * @param
     * @throws IOException input error handler
     */
    public static void main(String[] args) throws IOException {// stops file io error
        DecimalFormat df = new DecimalFormat("#.##");
        Scanner files[] = new Scanner[10];// creates an array of scanners
        String[] lang = { "Mystery", "Danish", "English", "Finnish", "French", "German", "Icelandic", "Polish",
                "Spanish", "Swedish" };// Stores the names of all the text language files and mystery.txt
        String file = "";// creates variable that will store the location of the file
        for (int i = 0; i < 10; i++) {// loops through the scanner array
            file = lang[i];// stores file as the name of the text file to be read
            files[i] = new Scanner(new File(file + ".txt"));// makes the scanner read from the specified txt file
        }
        int count = 0;// counter...
        double freq[][] = new double[10][51];// stores the frequencies of all the languages (freq[language][character] =
                                             // frequency)
        for (int i = 0; i < 10; i++) {
            count = 0;
            while (files[i].hasNextLine()) {// as long as the is something to be read from (language).txt
                // take the array at the first position (which is always the number) and get the
                // percentage of that number relative to the word count
                String[] array = files[i].nextLine().split(" ");// create a mini array that splits the string at spaces
                freq[i][count] = Double.parseDouble(array[0]);// see above
                count++;
            }
        }
        double simArray[] = new double[10];// stores the similarity of frequencies for each language
        double diff = 0.0;// will store the differences
        for (int i = 0; i < 10; i++) {
            diff = 100.0;// assume the languages are exactly the same
            for (int j = 0; j < freq[i].length; j++) {
                // loops through both frequncy arrays backwards (see reason at line:39)
                diff -= Math.abs(freq[i][j] - freq[0][j]);
                // stores the sum of all the differences between the characters and takes it
                // away from 100 to find the similarity
            }
            simArray[i] = diff;// stores it into the similarity array
            System.out.println(lang[i] + ": " + df.format(simArray[i]));// prints the similarity of each language
        }
        double bigNum = simArray[1];// store the biggest number in the simArray
        double smallNum = simArray[1];// store the biggest number in the simArray
        int bwhereAt = 1;
        int swhereAt = 1;
        for (int i = 1; i < simArray.length; i++) {
            if (simArray[i] > bigNum) {// stores the number and its location if the number is bigger than bigNum
                bigNum = simArray[i];
                bwhereAt = i;
            }
            if (simArray[i] < smallNum) {// stores the number and its location if the number is smaller than smallNum
                smallNum = simArray[i];
                swhereAt = i;
            }
        }
        System.out.println("\n'" + lang[bwhereAt] + "' is the most similar language to the Encryted text.");
        System.out.println("\n'" + lang[swhereAt] + "' is the least similar language to the Encryted text.");

        // The answer is supposed to be French but for some reason French is the least
        // similar as you can see, and I don't know why.
    }
}
