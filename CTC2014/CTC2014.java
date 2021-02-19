package CTC2014;

import java.util.*;
import java.io.*;

public class CTC2014 {

	// lST = left Scale Total
	// rST = right Scale Total
	// tD = total Difference
	// lD = lowest Difference
	public static double lST = 0.0, rST = 0.0, tD = Math.abs(lST - rST), lD = 1000.0;
	public static double[] pV = new double[20];

	public static void main(String args[]) throws Exception {
		// reads in the file with the precise values
		Scanner read = new Scanner(new File("SumPreciseValues.txt"));
		int num = 0;
		while (read.hasNextLine()) {
			pV[num] = Double.parseDouble(read.nextLine());
			num++;
		}

		String result = "";
		Long lS = 1l;
		Long rS = 1l;
		Long maxV = 1048576l;
		Long x = 1l;
		while (lS < maxV) {
			if (!IsPowerOfTwo(lS)) {
				while (rS < maxV) {
					if ((lS & rS) == 0) {
						lST = scaleWeight(Long.toBinaryString(lS));
						rST = scaleWeight(Long.toBinaryString(rS));
						tD = Math.abs(lST - rST);
						// if a lower difference has been found, record it
						if (tD < lD) {
							lD = tD;
							result = "Left Scale:" + lS.toString() + " Right Scale:" + rS.toString() + " Lowest Difference:" + lD;
							System.out.println("\n" + result + "\nLS: " + answer(Long.toBinaryString(lS)) + "\nRS: "
									+ answer(Long.toBinaryString(rS)));
						}
					}
					rS += x;
					// x *= 2;
				}
			}
			// x = 1l;
			rS = 1l;
			lS += 1l;
			System.out.println("LEVEL UP [" + lS.toString() + "]!");
		}
		read.close();
	}

	// makes sure the binary number has leading zeroes to match the array
	public static String formatTo40Digit(String bString) {
		int len = bString.length();
		String result = bString;
		for (int i = 0; i < 20 - len; i++) {
			result = 0 + result;
		}
		return result;
	}

	// outputs the weight of all the balls put together on a side
	public static double scaleWeight(String scale) {
		String binScale = formatTo40Digit(scale);
		char[] binArray = binScale.toCharArray();
		double result = 0.0;
		for (int i = 0; i < 20; i++) {
			if (binArray[i] == '1') {
				result += pV[i];
			}
		}
		return result;
	}

	// displays the ball weights on each side
	public static String answer(String scale) {
		String binScale = formatTo40Digit(scale);
		char[] binArray = binScale.toCharArray();
		ArrayList<Double> result = new ArrayList<Double>();
		for (int i = 0; i < 20; i++) {
			if (binArray[i] == '1') {
				result.add(pV[i]);
			}
		}
		return Arrays.toString(result.toArray());
	}

	// determines whether a number is a Power of Two
	public static boolean IsPowerOfTwo(long x) {
		return (x & (x - 1)) == 0;
	}
}