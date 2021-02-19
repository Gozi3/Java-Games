package CTC2014;

import java.io.*;
import java.util.*;

public class Rearranger {
	public static ArrayList<String> results = new ArrayList<String>();
	public static String[] arranged;
	public static double[] sPV = new double[20];
	public static double[] pV = new double[40];

	public static void main(String[] args) throws Exception {
		Scanner read = new Scanner(new File("Results.txt"));
		while (read.hasNextLine()) {
			results.add(read.nextLine());
		}
		read.close();

		Scanner readPV = new Scanner(new File("preciseValues.txt"));
		int num = 0;
		while (readPV.hasNextLine()) {
			pV[num] = Double.parseDouble(readPV.nextLine());
			num++;
		}
		readPV.close();

		Scanner readSPV = new Scanner(new File("sumPreciseValues.txt"));
		num = 0;
		while (readSPV.hasNextLine()) {
			sPV[num] = Double.parseDouble(readSPV.nextLine());
			num++;
		}
		readSPV.close();
		arranged = new String[results.size()];
		int counter = 1;
		for (int i = 0; i < results.size(); i++) {
			if (counter == 1) {
				arranged[i] = results.get(i) + "\n";
			}
			// store the actual values of the left scale
			else if (counter == 2) {
				String line = results.get(i);
				String subSection = line.substring(5, line.length() - 1);
				String result = "LS: [" + arranger(arrNumExtractor(subSection)) + "]\n";
				arranged[i] = result;
			}
			// store the actual values of the right scale
			else if (counter == 3) {
				String line = results.get(i);
				String subSection = line.substring(5, line.length() - 1);
				String result = "RS: [" + arranger(arrNumExtractor(subSection)) + "]\n";
				arranged[i] = result;
			} else {
				arranged[i] = results.get(i) + "\n";
				counter = 0;
			}
			counter++;
		}

		FileOutputStream fos = new FileOutputStream(new File("RearrangedResults.txt"));
		byte buffer[][] = new byte[arranged.length][];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = arranged[i].getBytes("utf-8");
		}
		for (int i = 0; i < buffer.length; i++) {
			fos.write(buffer[i], 0, buffer[i].length);
		}
		fos.flush();
		fos.close();
	}

	// gets the numbers from the string
	public static double[] arrNumExtractor(String subSection) {
		String[] split = subSection.split(", ");
		double[] result = new double[split.length];
		for (int i = 0; i < split.length; i++) {
			result[i] = Double.parseDouble(split[i]);
		}
		return result;
	}

	// returns the real ball values of these numbers
	public static String arranger(double[] array) {
		String result = "";
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < 20; j++) {
				if (array[i] == sPV[j]) {
					result += pV[j] + ", " + pV[39 - j] + ", ";
				}
			}
		}
		result = result.substring(0, result.length() - 2);
		return result;
	}
}