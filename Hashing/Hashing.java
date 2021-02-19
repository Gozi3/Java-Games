package Hashing;

import java.io.*;
import java.util.*;
import java.math.*;

public class Hashing {
    static BigInteger arrSize = new BigInteger(Integer.toString(216555));
    static BigInteger size = new BigInteger("433099");// arrSize.nextProbablePrime().multiply(new
                                                      // BigInteger("2"));//this is the size of the hash table - a prime
                                                      // number is best
    static String[] hashTable = new String[size.intValue()];// create the hash table
    static String[] array = new String[216555]; // make sure your String array is big enough to hold all the data

    public static void main(String[] args) throws Exception {
        File testFile = new File("Dictionary.txt");// this is where the file to be sorted is loaded from
        getContents(testFile);// fill the hash table so that every slot contains a space
        // loads up the file
        System.out.println("Which type of open addressing would you like to use?");
        System.out.println("1) Linear Probing");
        System.out.println("2) Quadratic Probing");
        System.out.println("3) Double Hashing");
        Scanner in = new Scanner(System.in);
        int strategy = in.nextInt();// the user enters a number for the hashing strategy they want to use
        double start = System.currentTimeMillis();
        switch (strategy) {
        case 1:
            fillLinearProbing();
            break;
        case 2:
            fillQuadraticProbing();
            break;
        case 3:
            fillDoubleHash();
            break;
        }
        in.nextLine();
        double end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");
        System.out.print("\nEnter a word to find: ");
        String word = in.nextLine();
        while (!word.equals("quit")) {
            find(word, strategy);
            System.out.print("\nEnter a word to find: ");
            word = in.nextLine();// the user is asked to enter words to search for until they enter the word
                                 // 'quit'
        }
        in.close();
    }

    // this method takes in a word to look for and the strategy by which it has been
    // placed in the hash table
    public static void find(String word, int strategy) {
        BigInteger probes = new BigInteger(Integer.toString(1));
        BigInteger index = new BigInteger(Integer.toString(getHashKey(word)));
        // calculate the hash key for the word
        System.out.println();
        while (hashTable[index.intValue()] != null && !hashTable[index.intValue()].equals(word)) {
            System.out
                    .println("Checking slot " + index.toString() + "...collision with " + hashTable[index.intValue()]);
            // as long as you do not stumble across either the word or a blank keep
            // searching
            if (strategy == 1) {
                // depending on the strategy go up in linear jumps, quadratic jumps or the
                // double hash jump
                index = index.add(new BigInteger("1"));
                probes = probes.add(new BigInteger("1"));
                index = index.mod(size);
                // always mod the index size so it doesn't go out of bounds
            } else if (strategy == 2) {
                index = index.add(probes.multiply(probes));
                probes.add(new BigInteger("1"));
                index = index.mod(size);
            } else if (strategy == 3) {
                index = index.add(new BigInteger(Integer.toString(getDoubleHashKey(word))));
                probes = probes.add(new BigInteger("1"));
                index = index.mod(size);
            }
        }
        if (hashTable[index.intValue()] == null) {
            System.out.println("NOT IN HASHTABLE");
            // if you've found a space then the word cannot be in the hash table
        } else {
            System.out.println("The word " + word + " was found in slot " + index + " of the hashtable");
        }
        System.out.println("Number of hash table probes: " + probes);
        // print out the total number of attempts to find the correct slot
    }

    public static int getHashKey(String word) {
        // this is the primary hash key function - it should return a number which is a
        // slot in the hash table
        // for words, a good strategy is to raise each character to successive powers of
        // the alphabet size
        // assume that the alphabet is ASCII characters - a total of 256 possibilities
        // each successive character value should be raised to successive powers of 256
        // the whole thing is added together and then moduloed to create a hash table
        // index
        BigInteger key = new BigInteger("0");
        for (int i = 0; i < word.length(); i++) {
            int temp = (int) (word.charAt(i)) - 96;
            key = key.add(new BigInteger(Integer.toString(temp)).multiply(new BigInteger(Integer.toString(31)).pow(i)));
        }
        key = key.mod(size);
        return key.intValue();

    }

    public static int getDoubleHashKey(String word) {
        // this method should be different to the primary hash function
        // it should return a different number for words which generated the same
        // primary hash key value
        // for example, you could just add up all of the letters in the word
        BigInteger key = new BigInteger("0");
        for (int i = 0; i < word.length(); i++) {
            int temp = (int) (word.charAt(i)) - 96;
            key = key.add(
                    new BigInteger(Integer.toString(temp)).multiply(new BigInteger(Integer.toString(27)).mod(size)));
        }
        return key.intValue();
    }

    public static void fillLinearProbing() {
        BigInteger totalcollisions = new BigInteger("0");
        // this variable stores the total number of collisions that have occurred for
        // every word
        for (int i = 0; i < array.length; i++) {
            // go through all words
            BigInteger collisions = new BigInteger("0");
            BigInteger index = new BigInteger(Integer.toString(getHashKey(array[i])));// generate a hash key
            while (hashTable[index.intValue()] != null) {
                // if that slot is already filled move onto the next slot and increment the
                // collisions
                collisions = collisions.add(new BigInteger("1"));
                index = index.add(new BigInteger("1"));
                index = index.mod(size);
                // make sure you don't go off the edge of the hash table
            }
            hashTable[index.intValue()] = array[i];
            if (i % 100 == 0) {
                System.out.println(array[i] + " was placed in slot " + index.toString() + " of the hash table after "
                        + collisions.toString() + " collisions");
            }
            totalcollisions = totalcollisions.add(collisions);
            // print out the information for the last 1,000 words only, otherwise it takes
            // quite long and gets annoying
        }
        System.out.println("The total number of collisions was " + totalcollisions.toString());
    }

    public static void fillQuadraticProbing() {
        BigInteger totalcollisions = new BigInteger("0");
        for (int i = 0; i < array.length; i++) {
            BigInteger collisions = new BigInteger("0");
            BigInteger index = new BigInteger(Integer.toString(getHashKey(array[i])));
            BigInteger queries = new BigInteger("1");
            while (hashTable[index.intValue()] != null) {
                collisions = collisions.add(new BigInteger("1"));
                index = index.add(queries.multiply(queries));
                index = index.mod(size);
                queries = queries.add(index);
            }
            hashTable[index.intValue()] = array[i];
            if (i % 100 == 0) {
                System.out.println(array[i] + " was placed in slot " + index.toString() + " of the hash table after "
                        + collisions.toString() + " collisions");
            }
            totalcollisions = totalcollisions.add(collisions);
        }
        System.out.println("The total number of collisions was " + totalcollisions);
    }

    public static void fillDoubleHash() {
        BigInteger totalcollisions = new BigInteger("0");
        for (int i = 0; i < array.length; i++) {
            BigInteger collisions = new BigInteger("0");
            BigInteger index = new BigInteger(Integer.toString(getHashKey(array[i])));
            BigInteger doubleHash = new BigInteger(Integer.toString(getDoubleHashKey(array[i])));
            while (hashTable[index.intValue()] != null) {
                collisions = collisions.add(new BigInteger("1"));
                index = index.add(doubleHash);
                index = index.mod(size);
            }
            hashTable[index.intValue()] = array[i];
            if (i % 100 == 0) {
                System.out.println(array[i] + " was placed in slot " + index.toString() + " of the hash table after "
                        + collisions.toString() + " collisions");
            }
            totalcollisions = totalcollisions.add(collisions);
        }
        System.out.println("The total number of collisions was " + totalcollisions.toString());
    }

    /**
     * Fetch the entire contents of a text file, and return it in a String. This
     * style of implementation does not throw Exceptions to the caller.
     *
     * @param aFile is a file which already exists and can be read.
     */
    public static String getContents(File aFile) throws Exception {
        StringBuilder contents = new StringBuilder();
        String NL = System.getProperty("line.separator");
        Scanner read = new Scanner(aFile);
        int i = 0;
        while (read.hasNextLine()) {
            array[i] = read.nextLine();
            i++;
            contents.append(NL);
        }
        read.close();
        return contents.toString();
    }

    public static void setContents(File aFile) throws Exception {
        FileWriter output = new FileWriter(aFile, true);
        // declared here only to make visible to finally clause; generic referencee
        // buffering
        // FileWriter always assumes default encoding is OK!
        int i = 0;
        while (array[i] != null) {
            output.write(array[i]);
            output.write(System.getProperty("line.separator"));
            i++;
        }
        output.close();
    }
}
// 1763702 -#> 41
// 1763876 -#> 31
// 1831893 -#> 29
// 1846111 -#> 37
// 1858722 -#> 30
// 1900071 -#> 59