package Huffman;

import java.util.*;
import java.io.*;

public class Huffman extends Tree {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your sentence: ");
		String sentence = in.nextLine();
		if (sentence.length() == 0) {
			System.out.println("No sentence provided!");
		} else {
			String binaryString = ""; // this stores the string of binary code
			for (int i = 0; i < sentence.length(); i++) { // go through the sentence
				int decimalValue = (int) sentence.charAt(i); // convert to decimal
				String binaryValue = Integer.toBinaryString(decimalValue); // convert to binary
				for (int j = 7; j > binaryValue.length(); j--) {
					binaryString += "0"; // this loop adds in those pesky leading zeroes
				}
				binaryString += binaryValue + " "; // add to the string of binary
			}
			System.out.println(binaryString); // print out the binary

			int[] fArray = new int[256]; // an array to store all the frequencies

			for (int i = 0; i < sentence.length(); i++) { // go through the sentence
				fArray[(int) sentence.charAt(i)]++; // increment the appropriate frequencies
			}

			PriorityQueue<Tree> PQ = new PriorityQueue<Tree>(); // make a priority queue to hold the forest of trees

			String tempArray[] = new String[256];
			Arrays.fill(tempArray, "0A");
			System.out.println("");
			for (int i = 0; i < fArray.length; i++) { // go through frequency array
				if (fArray[i] > 0) {
					System.out.println("'" + (char) i + "' appeared " + fArray[i] + ((fArray[i] == 1) ? " time" : " times"));

					Tree temp = new Tree();
					temp.frequency = fArray[i];
					Node n1 = new Node();
					n1.letter = (char) i;
					temp.root = n1;
					PQ.add(temp);

				}
			}
			// sorts the array in reverse order
			Arrays.sort(tempArray, Collections.reverseOrder());
			System.out.println("");
			// prints out the letter in order of frequency
			for (int i = 0; i < tempArray.length; i++) {
				String array[] = tempArray[i].split("", 2);
				if (Integer.parseInt(array[0]) > 0) {
					System.out.println("'" + array[1] + "' appeared " + Integer.parseInt(array[0])
							+ ((Integer.parseInt(array[0]) == 1) ? " time" : " times"));
				}
			}

			// combines the trees in the priority queue

			while (PQ.size() > 1) {
				Tree tempA = PQ.poll();
				Tree tempB = PQ.poll();
				Tree comboTree = new Tree();
				comboTree.frequency = tempA.frequency + tempB.frequency;
				Node node = new Node();
				node.leftChild = tempA.root;
				node.rightChild = tempB.root;
				comboTree.root = node;
				PQ.add(comboTree);

			}

			Tree HuffmanTree = PQ.poll(); // now there's only one tree left - get its codes

			// FILL THIS IN:
			String binaryString2 = "";
			for (int i = 0; i < fArray.length; i++) {// loops array to get codes
				if (fArray[i] > 0) {
					binaryString2 += "Char: " + ((char) i) + " Huffman code is: "; // stores codes of chars in string
					binaryString2 += HuffmanTree.getCode((char) i);
					binaryString2 += "\n";
				}
			}
			System.out.println("binaryString2: " + binaryString2);
			// get all the codes for the letters and print them out
			// call the getCode() method on the HuffmanTree Tree object for each letter in
			// the sentence
			String huffmanString = "";
			for (int i = 0; i < sentence.length(); i++) {
				huffmanString += HuffmanTree.getCode(sentence.charAt(i)) + " ";
			}
			System.out.println(huffmanString);
			int asciiRatio = (binaryString.replaceAll("\\s+", "").length());
			int huffmanRatio = (huffmanString.replaceAll("\\s+", "").length());
			double compress = ((double) huffmanRatio / asciiRatio);
			compress = compress * 100;

			System.out.println("Compressed size is: " + huffmanRatio + " / " + asciiRatio + " = " + (int) compress + " %");

			System.out.println("Would you like to compress a file? y/n");
			String answer = in.nextLine();
			if (answer.equalsIgnoreCase("y")) {
				System.out.println("First type into the file named 'Decompressed.txt'.");
				System.out.print("When ready press the 'enter' key: ");
				answer = in.nextLine();
				System.out.println("Compressing file...");
				sleep(750);
				compressor(HuffmanTree);
				System.out.println("New file 'Compressed.txt' created. Done!");
			} else {
				System.out.println("Ok. Done!");
			}
		}
		in.close();
	}

	public static void compressor(Tree HuffmanTree) throws Exception {
		File file = new File("Decompressed.txt");
		FileInputStream fis = new FileInputStream(file);
		StringBuilder data = new StringBuilder();
		int ch;
		while ((ch = fis.read()) != -1) {
			data.append((char) ch);
		}
		fis.close();
		String huffmanString = "";
		for (int i = 0; i < data.length(); i++) {
			huffmanString += HuffmanTree.getCode(data.charAt(i)) + " ";
		}
		byte[] buffer = huffmanString.getBytes("utf-8");
		file = new File("Compressed.txt");
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(buffer, 0, buffer.length);
		fos.flush();
		fos.close();
	}

	public static void sleep(long milis) {
		try {
			Thread.sleep(milis);
		} catch (Exception e) {
		}
	}
}