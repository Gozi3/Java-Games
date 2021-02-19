package CTC2014;

import java.io.*;
import java.util.*;

public class SumPreciseValuesGen {

	public static double[] pV = new double[40];
	public static double[] pV2 = new double[40];

	public static void main(String[] args) throws Exception {
		// reads in the file with the precise values
		Scanner read = new Scanner(new File("preciseValues.txt"));
		int num = 0;
		while (read.hasNextLine()) {
			pV[num] = Double.parseDouble(read.nextLine());
			num++;
		}
		int counter = 0;
		for (int i = 39; i > -1; i--) {
			pV2[counter] = pV[i];
			counter++;
		}
		System.out.println("Pv:" + Arrays.toString(pV) + "\n\nPv2:" + Arrays.toString(pV2) + "\n");

		double[] sum = new double[40];
		for (int i = 0; i < 40; i++) {
			sum[i] = Math.abs(pV[i] + pV2[i]);
			System.out.println(sum[i]);
		}

		read.close();
	}
}