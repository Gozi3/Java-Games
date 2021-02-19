import java.util.*;

public class Stub {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        int items = myscanner.nextInt();
        myscanner.nextLine();
        String[] contents = new String[items];
        for (int i = 0; i < items; i++) {
            contents[i] = myscanner.nextLine();
        }
        int size = 99991;
        HashSolution mysolution = new HashSolution();
        String[] hashtable = mysolution.fill(size, contents);
        HashTable mytable = new HashTable(hashtable);

        HashSolution mysolution2 = new HashSolution(); // prevents cheating by using memory
        for (int i = 0; i < items; i++) {
            int rand = (int) (Math.random() * items);
            String temp = contents[i];
            contents[i] = contents[rand];
            contents[rand] = temp;
        }
        for (int i = 0; i < items; i++) {
            int slot = mysolution2.find(size, mytable, contents[i]);
            if (!hashtable[slot].equals(contents[i])) {
                System.out.println("error!");
            }
        }
        System.out.println(mytable.getTotal());
        myscanner.close();
    }
}

class HashTable {
    private String[] hashTable;
    private int total = 0;

    public HashTable(String[] input) {
        hashTable = input;
    }

    public boolean check(int slot, String check) {
        if (hashTable[slot].equals(check)) {
            return true;
        } else {
            total++;
            return false;
        }
    }

    public int getTotal() {
        return total;
    }
}

class HashSolution {
    // HashTable mytable = new HashTable();
    public int find(int size, HashTable mytable, String word) {

        // fill this in so as to minimize collisions
        // takes in the HashTable object and the word to be found
        // the only thing you can do with the HashTable object is call "check"
        // this method should return the slot in the hashtable where the word is
        return hash(word);
    }

    public int hash(String s) {
        int hash = 0;
        int a = 30;
        int b = 99991;
        if (s == null) {
            return 0;
        }
        try {
            for (int i = 0; i < s.length(); i++) {
                hash = (a * hash + s.charAt(i)) % b;
            }
        } catch (java.lang.NullPointerException e) {
            System.out.println(s);
        }
        return hash;
    }

    public String[] fill(int size, String[] array) {

        // takes in the size of the hashtable, and the array of Strings to be placed in
        // the hashtable
        // this should add all the words into the hashtable using some system
        // then it should return the hashtable array
        String[] hashtable = new String[size];
        // Fills all the blanks with empty strings
        for (int i = 0; i < size; i++) {
            hashtable[i] = "";
        }

        // loops through the array
        for (int i = 0; i < array.length; i++) {

            // uses the hash number as the index for the word to be put in the hashtable
            hashtable[hash(array[i])] = array[i];
        }

        return hashtable;

    }
}
