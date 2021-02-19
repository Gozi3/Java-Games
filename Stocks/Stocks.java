package Stocks;

import java.io.*;
import java.util.*;

public class Stocks {
	static double hDraw, lDraw, hAbsPerc, lAbsPerc;

	public static void main(String[] args) throws Exception {
		Scanner read = new Scanner(new File("StockData.txt")); // reads in file
		String original[] = read.nextLine().split("\t"); // splits the line into an array using tabs
		String date[] = new String[881]; // stores all the dates
		double data[][] = new double[881][original.length - 1]; // stores all the numbers
		int i = 0;
		while (read.hasNextLine()) { // while there are still lines to be read store them into the appropriate arrays
			String arr[] = read.nextLine().split("\t"); // splits the line at tabs, into an array
			date[i] = arr[0]; // the first values are dates

			// and the rest are numbers
			for (int x = 0; x < arr.length - 1; x++) {
				data[i][x] = Double.parseDouble(arr[x + 1]);
			}
			i++; // increment
		}
		read.close();
		double arrHD[] = new double[original.length - 1]; // stores the highest drawdowns of each company
		double arrLD[] = new double[original.length - 1]; // stores the lowest drawdowns of each company
		double arrHPerc[] = new double[original.length - 1]; // stores the highest absolute percentage of each company
		double arrLPerc[] = new double[original.length - 1]; // stores the lowest absolute percentage of each company
		String whenHD[] = new String[original.length - 1]; // stores when the highest drawdowns of each company occured
		String whenLD[] = new String[original.length - 1]; // stores when the lowest drawdowns of each company occured
		double peak, trough; // self-explanatory

		// loops vertically first rather than the conventional horizontal first
		for (int j = 0; j < original.length - 1; j++) {
			// reset the values
			peak = data[0][j];
			trough = data[0][j];
			hDraw = 0;
			hAbsPerc = 0;
			lDraw = 1000000000;
			lAbsPerc = 100.0;

			String startDate = date[880];

			for (i = 880; i >= 0; i--) {
				// if we found another peak
				if (data[i][j] >= peak) {
					peak = data[i][j];
				}
				// look for the next trough
				else if (data[i][j] < trough) {

				}
				// if we've reached the end of the peak
				else {
					double draw = peak - trough; // drawdown equals difference between the peak and the trough
					double absPerc = (draw) / trough; // calculates the abosolute percentage of the drawdown
					// if this drawdown is higher store it
					if (hDraw < draw) {
						hDraw = draw;
						hAbsPerc = absPerc;
						whenHD[j] = startDate + " to " + date[i];
					}
					// if this drawdown is lower store it
					if (lDraw > draw) {
						lDraw = draw;
						lAbsPerc = absPerc;
						whenLD[j] = startDate + " to " + date[i];
					}
					// make this the new starting point
					peak = data[i][j];
					trough = data[i][j];
					startDate = date[i];
				}
			}
			// add it to the array of highest and lowest drawdowns
			arrHD[j] = hDraw;
			arrLD[j] = lDraw;
			arrHPerc[j] = hAbsPerc;
			arrLPerc[j] = lAbsPerc;
		}

		// print out what we know
		for (i = 0; i < original.length - 1; i++) {
			System.out.println(original[i + 1] + " HD: " + arrHD[i]); // the company name followed by their highest drawdown
			System.out.println(original[i + 1] + " LD: " + arrLD[i]); // the company name followed by their lowest drawdown
		}
		double bigDraw = arrHD[0];
		double smallDraw = arrLD[0];
		int hPosition = 0;
		int lPosition = 0;
		for (int y = 0; y < arrHD.length; y++) {
			if (arrHD[y] > bigDraw) {
				bigDraw = arrHD[y];
				hPosition = y;
			}
			if (arrLD[y] < smallDraw) {
				smallDraw = arrLD[y];
				lPosition = y;
			}
		}
		System.out.println("\n" + original[hPosition + 1] + " has the highest drawdown at " + arrHPerc[hPosition]
				+ "% from " + whenHD[hPosition]);
		System.out.println(original[lPosition + 1] + " has the lowest drawdown at " + arrLPerc[lPosition] + "% from "
				+ whenLD[lPosition] + "\n");
	}
}

// For some reason the low drawdowns are all 0.0