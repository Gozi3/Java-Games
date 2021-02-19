package Google_HashCode.hashCodePractice;

import java.io.*;
import java.util.*;
/*
	R represents rows
	C represents columns
	So picture[R][C] means the cell in the R-th row and the
	C-th column of the picture
*/

public class hashCodePractice {

	public static int answerSize = 0;
	// public static int frame = 1;

	public static void main(String args[]) throws IOException {
		Scanner input = new Scanner(System.in);
		Scanner scan = new Scanner(new File(input.nextLine()));
		int N = scan.nextInt();
		int M = scan.nextInt();
		scan.nextLine();
		String picture[][] = new String[N][M];
		for (int i = 0; i < N; i++) {
			picture[i] = scan.nextLine().split("");
		}
		System.out.println("******************************");
		printArray(picture);
		System.out.println("******************************");
		String duplicate[][] = cloneArray(picture);
		String answer[] = new String[N * M];
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (picture[i][j].equals("#") && duplicate[i][j].equals("#")) {
					if (count == 2) {
						if (i != N - 1 && i != N - 2) {
							if (checkSquare(picture, duplicate, i + 1, j - 1, answer)) {
								count = 0;
							} else {
								paintLine(picture, i, j - 2, i, j, answer);
								count = 0;
							}
						} else {
							paintLine(picture, i, j - 2, i, j, answer);
							count = 0;
						}

					} else {
						if (M - 1 == j) {
							paintLine(picture, i, j - count, i, j, answer);
							count = 0;
						} else {
							count++;
						}
					}
				} else {
					if (count > 0) {
						paintLine(picture, i, j - count, i, j - 1, answer);
						count = 0;
					}
					if (duplicate[i][j].equals(".")) {
						picture[i][j] = "#";
					}

				}
				// System.out.println("Frame: " + frame);
				// frame++;
				// printArray(picture);
				// System.out.println("******************************");
			}
		}

		printArray(picture);
		System.out.println("******************************");
		printAnswer(answer, answerSize);
		input.close();
		scan.close();
	}

	// makes a duplicate array
	public static String[][] cloneArray(String[][] picture) {
		String clone[][] = new String[picture.length][picture[0].length];
		for (int i = 0; i < picture.length; i++) {
			System.arraycopy(picture[i], 0, clone[i], 0, picture[i].length);
		}
		return clone;
	}

	// checks if a square (3x3) can be painted
	public static boolean checkSquare(String picture[][], String duplicate[][], int R, int C, String answer[]) {
		int missing = 6;
		if (picture[R][C].equals("#")) {
			missing--;
		}
		if (picture[R][C - 1].equals("#")) {
			missing--;
		}
		if (picture[R][C + 1].equals("#")) {
			missing--;
		}
		if (picture[R + 1][C - 1].equals("#")) {
			missing--;
		}
		if (picture[R + 1][C].equals("#")) {
			missing--;
		}
		if (picture[R + 1][C + 1].equals("#")) {
			missing--;
		}
		if (missing == 0) {
			paintSquare(picture, R, C, 1, answer);
			return true;
		}
		/*
		 * ....#.. ..###.. ..#.#.. ..###.. ..#....
		 */
		// R = 2 C = 3
		else if (missing == 1) {
			paintSquare(picture, R, C, 1, answer);
			if (duplicate[R][C].equals(".")) {
				eraseCell(picture, R, C, answer);
			}
			if (duplicate[R][C - 1].equals(".")) {
				eraseCell(picture, R, C - 1, answer);
			}
			if (duplicate[R][C + 1].equals(".")) {
				eraseCell(picture, R, C + 1, answer);
			}
			if (duplicate[R + 1][C - 1].equals(".")) {
				eraseCell(picture, R + 1, C - 1, answer);
			}
			if (duplicate[R + 1][C].equals(".")) {
				eraseCell(picture, R + 1, C, answer);
			}
			if (duplicate[R + 1][C + 1].equals("")) {
				eraseCell(picture, R + 1, C + 1, answer);
			}
			return true;
		} else {
			return false;
		}
	}

	// paints a square
	public static void paintSquare(String picture[][], int R, int C, int S, String answer[]) {
		for (int i = 0; i < (2 * S + 1); i++) {
			for (int j = 0; j < (2 * S + 1); j++) {
				picture[(R - 1) + i][(C - 1) + j] = ".";
			}
		}
		answer[answerSize] = "PAINT_SQUARE " + R + " " + C + " " + S;
		answerSize++;
	}

	// paints a line
	public static void paintLine(String picture[][], int R1, int C1, int R2, int C2, String answer[]) {
		if (R1 == R2) {
			for (int i = 0; i <= C2 - C1; i++) {
				picture[R1][C1 + i] = ".";
			}
		} else if (C1 == C2) {
			for (int i = 0; i < C2 - C1; i++) {
				picture[R1 + i][C1] = ".";
			}
		}
		answer[answerSize] = "PAINT_LINE " + R1 + " " + C1 + " " + R2 + " " + C2;
		answerSize++;
	}

	// erases a cell
	public static void eraseCell(String picture[][], int R, int C, String answer[]) {
		picture[R][C] = "#";
		answer[answerSize] = "ERASE_CELL " + R + " " + C;
		answerSize++;
	}

	// prints the array given
	public static void printArray(String array[][]) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println("");
		}
	}

	// working on this - will try and see if it can join two line commands together
	// to make one instruction instead of multiple :D
	public static void paintLineCombiner(String answer[]) {

	}

	// prints out all the commands and the number of commands at the end
	public static void printAnswer(String answer[], int answerSize) {
		for (int i = 0; i < answer.length; i++) {
			if (answer[i] == null) {
				break;
			} else {
				System.out.println(answer[i]);
			}
		}
		System.out.println(answerSize);
	}
}
