/**
	* Project: Tic Tac Toe / X's and O's Game
	* @author Godstime Osarobo
	* Date:  August, 2015
	* Program Name:  TicTacToe.java
*/

/* example of what it should look like
		 X | O | O
		-----------
		 O | X | O
		-----------
		 O | O | X
*/
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	/**
	 * The main method.
	 *
	 * @param String[] args
	 * @return void
	 */
	@SuppressWarnings({ "resource" })
	public static void main(String args[]) {
		String[][] gameGrid = new String[3][3];
		Scanner scan = new Scanner(System.in);
		new Random();
		int counter = 0, counter1 = 0; // checks whether game is at beginning or not //checks how many times you've
										// placed a piece in an invalid place
		boolean play = true; // checks if the user wants to play the game again
		boolean pickValid = true;// checks whether the users choice is valid or not
		boolean inputInvalid = true;// checks if the position to place the piece is valid or not.
		boolean player = true; // decides who's turn it is. Player 1 = true. Player 2 = false.
		String pick = new String(" "); // selects the player's piece
		String input = new String(" "); // placement/instruction/done choice for player 1 AND player 2
		String piece1 = new String(" ");
		String piece2 = new String(" ");
		sleep(500);
		System.out.println("Welcome to Tic-Tac-Toe! **Java Edition**");
		sleep(1000);
		// Player X or O start
		System.out.println("\nPlayer 1, would you like to be X or O?");
		pick = scan.nextLine();

		do {
			if (pick.equalsIgnoreCase("x")) {
				piece1 = "X";
				piece2 = "O";
				sleep(750);
				typedString(30, "\nPlayer 1, you are Xs.");
				sleep(500);
				typedString(30, "Player 2, you are Os.");
				sleep(750);
				System.out.println("\nThe game will now begin...");
				pickValid = true;
			} else if (pick.equalsIgnoreCase("o")) {
				piece1 = "O";
				piece2 = "X";
				sleep(500);
				typedString(30, "\nPlayer 1, you are Os.");
				sleep(500);
				typedString(30, "Player 2, you are Xs.");
				sleep(750);
				System.out.println("\nThe game will now begin...");
				pickValid = true;

			} else {
				sleep(500);
				System.out.println("\nThat is not a valid answer.");
				sleep(500);
				typedString(25, "Please choose again: X or O?");
				pick = scan.nextLine();
				pickValid = false;
			}

		} while (pickValid == false);
		// Player X or O end
		sleep(2000);
		typedString(25, "\nCreating new Tic-Tac-Toe grid...");
		blankGrid(gameGrid);
		sleep(1000);
		typedString(25, "Finding instructions to game...");
		sleep(1000);
		// Game start
		while (play) {
			while (!input.equalsIgnoreCase("done")) {
				if (counter == 0) {
					System.out.println("\nGame has started!");
					sleep(1000);
					typedString(50, "\nFor instructions on how to play type help.\n");
				}
				// help
				else if (input.equalsIgnoreCase("help")) {
					gameInstructions();
					input = " ";
					if (player) {
						player = false;
					} else {
						player = true;
					}
				}

				else {

					// player 1's go
					if (player) {
						sleep(750);
						System.out.println("Player 1's turn. Choose a place to put your " + piece1 + ".");
						chooseGrid(gameGrid);
						input = scan.nextLine();
						if (input.equalsIgnoreCase("done") || input.equalsIgnoreCase("help")) {
							player = false;
						} else {
							inputInvalid = true;
							while (inputInvalid == true) {
								for (int row = 0; row < gameGrid.length; row++) {
									for (int column = 0; column < gameGrid[row].length; column++) {
										if (input.equals(gameGrid[row][column])) {
											if (input.equalsIgnoreCase("X") || input.equalsIgnoreCase("O")) {

											} else {
												inputInvalid = false;
											}
										}
									}
								}
								if (inputInvalid == false) {
									choiceInputter(gameGrid, input, player, piece1, piece2);
									if (checkWin(gameGrid, piece1, piece2)) {
										input = "done";
									} else if (checkDraw(gameGrid, piece1, piece2)) {
										input = "done";
									}
									player = false;
								} else {
									if (counter1 > 2) {
										System.out.println(input + " is not a valid place!");
										sleep(500);
										typedString(25,
												"Remember you can always type 'help' if you don't know what to do.");
										sleep(500);
										typedString(25, "Please enter a valid place: ");
										chooseGrid(gameGrid);
										input = scan.nextLine();
										counter1 = 0;
									} else {
										System.out.println(input + " is not a valid place!");
										sleep(500);
										typedString(25, "Please enter a valid place: ");
										chooseGrid(gameGrid);
										input = scan.nextLine();
										counter1++;
									}
								}
							}
						}
						sleep(750);
					}
					// player 2's go
					else if (!player) {
						sleep(750);
						System.out.println("Player 2's turn. Choose a place to put your " + piece2 + ".");
						chooseGrid(gameGrid);
						input = scan.nextLine();
						if (input.equalsIgnoreCase("done") || input.equalsIgnoreCase("help")) {
							player = true;
						} else {
							inputInvalid = true;
							while (inputInvalid == true) {
								for (int row = 0; row < gameGrid.length; row++) {
									for (int column = 0; column < gameGrid[row].length; column++) {
										if (input.equals(gameGrid[row][column])) {
											if (input.equalsIgnoreCase("X") || input.equalsIgnoreCase("O")) {

											} else {
												inputInvalid = false;
											}
										}
									}
								}
								if (inputInvalid == false) {
									choiceInputter(gameGrid, input, player, piece1, piece2);
									if (checkWin(gameGrid, piece1, piece2)) {
										input = "done";
									} else if (checkDraw(gameGrid, piece1, piece2)) {
										input = "done";
									}
									player = true;
								} else {
									if (counter1 > 2) {
										System.out.println(input + " is not a valid place!");
										sleep(500);
										typedString(25,
												"Remember you can always type 'help' if you don't know what to do.");
										sleep(500);
										typedString(25, "Please enter a valid place: ");
										chooseGrid(gameGrid);
										input = scan.nextLine();
										counter1 = 0;
									} else {
										System.out.println(input + " is not a valid place!");
										sleep(500);
										typedString(25, "Please enter a valid place: ");
										chooseGrid(gameGrid);
										input = scan.nextLine();
										counter1++;
									}
								}
							}
						}
						sleep(750);
					}
					displayGrid(gameGrid);
				}

				sleep(1000);
				counter++;
			}
			boolean again = true;
			while (again) {
				System.out.println("Do you wanna play again? Yes/No ");
				input = scan.nextLine();
				if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
					again = false;
					if (input.equalsIgnoreCase("yes")) {
						System.out.println("");
						System.out.println("Yay!");
						sleep(250);
						typedString(25, "\nThe game will begin again shortly.");
						sleep(1000);
						play = true;
						counter = 0;
						input = " ";
						if (player) {
							player = false;
						} else {
							player = true;
						}
					} else {
						System.out.println("");
						System.out.println("Awh...");
						sleep(500);
						typedString(25, "\nTill next time.");
						sleep(250);
						System.out.println("Bye!");
						play = false;
					}
				} else {
					again = true;
					typedString(25, "That is not a valid answer!");
					sleep(250);
				}
			}
		}
	}

	// Game end
	/**
	 * blankGrid: creates a blank Tic-Tac-Toe array template.
	 *
	 * @param String[][]grid
	 * @return void
	 */
	public static void blankGrid(String[][] grid) {
		sleep(500);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = " ";
			}
		}
	}

	/**
	 * displayGrid: Prints the current game grid at the end of the turn.
	 *
	 * @param String[][] grid
	 * @return void
	 */
	public static void displayGrid(String[][] grid) {
		sleep(500);
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				// not the last column and not X or O
				if (column < grid[row].length - 1) {
					if ((!grid[row][column].equalsIgnoreCase("X")) && (!grid[row][column].equalsIgnoreCase("O"))) {
						grid[row][column] = " ";
						System.out.print(" " + grid[row][column] + " |");
					} else {
						System.out.print(" " + grid[row][column] + " |");
					}
				} else {
					if ((!grid[row][column].equalsIgnoreCase("X")) && (!grid[row][column].equalsIgnoreCase("O"))) {
						grid[row][column] = " ";
						System.out.print(" " + " " + " \n");
					} else {
						System.out.print(" " + grid[row][column] + " \n");
					}
				}
			}
			if (row < grid.length - 1) {
				System.out.println("-----------");
			} else {

			}
		}
	}

	/**
	 * chooseGrid: Prints the game grid with number locations for the Player to
	 * pick.
	 *
	 * @param String[]][] grid
	 * @return void
	 */
	public static void chooseGrid(String[][] grid) {
		sleep(500);
		int location = 1;
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				// not the last column and not X or O
				if (column < grid[row].length - 1) {
					if ((!grid[row][column].equalsIgnoreCase("X")) && (!grid[row][column].equalsIgnoreCase("O"))) {
						grid[row][column] = Integer.toString(location);
						System.out.print(" " + grid[row][column] + " |");
					} else {
						System.out.print(" " + grid[row][column] + " |");
					}
					location++;
				} else {
					if ((!grid[row][column].equalsIgnoreCase("X")) && (!grid[row][column].equalsIgnoreCase("O"))) {
						grid[row][column] = Integer.toString(location);
						System.out.print(" " + grid[row][column] + " \n");
					} else {
						System.out.print(" " + grid[row][column] + " \n");
					}
					location++;
				}
			}
			if (row < grid.length - 1) {
				System.out.println("-----------");
			} else {

			}
		}
	}

	/**
	 * gameInstructions: Prints the game instructions if the Player inputs help
	 *
	 * @param
	 * @return void
	 */
	public static void gameInstructions() {
		String instruct = new String("To pick the place you want your piece to go, type the number at the location.");
		String instruct1 = new String("Unfortunately, your actions can not be undone.");
		String instruct2 = new String("This game is multi-player.");
		String instruct3 = new String("Remember, its 'done' to end the game.");
		sleep(500);
		typedString(50, "\nInstructions: ");
		sleep(750);
		typedString(50, instruct);
		sleep(250);
		typedString(50, instruct1);
		sleep(250);
		typedString(50, instruct2);
		sleep(500);
		typedString(50, instruct3);
		sleep(750);
		typedString(30, "Have fun! :D\n");
	}

	/**
	 * sleep: makes the console wait depending on the amount of milliseconds chosen
	 *
	 * @param long millis
	 * @return void
	 */
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception ee) {
		}
	}

	/**
	 * typedString: Prints a string as if it was being typed out. Time for normal
	 * writing is: 25 Time for long writing is: 50
	 *
	 * @param long time String sentence
	 * @return void
	 */
	public static void typedString(long time, String sentence) {
		for (int i = 0; i < sentence.length(); i++) {
			System.out.print(sentence.charAt(i));
			sleep(time);
		}
		System.out.println("");
	}

	/**
	 * checkDraw: Checks to see if whether the match is a draw
	 *
	 * @param String[], String, String, String
	 * @return boolean
	 */
	public static boolean checkDraw(String[][] grid, String piece1, String piece2) {
		boolean draw = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!(grid[i][j].equals(piece1) || grid[i][j].equals(piece2))) {
					draw = false;
				}
			}
		}
		if (draw) {
			System.out.println("It's a draw. No one wins!");
			displayGrid(grid);
			blankGrid(grid);
			return draw;
		} else {
			return draw;
		}
	}

	/**
	 * checkWin: Checks to see if either players have won
	 *
	 * @param String[], String, String, String
	 * @return boolean
	 */
	public static boolean checkWin(String[][] grid, String piece1, String piece2) {
		boolean win = false;
		if ((grid[0][0].equals(piece1) && grid[0][1].equals(piece1) && grid[0][2].equals(piece1))
				|| (grid[0][0].equals(piece1) && grid[1][1].equals(piece1) && grid[2][2].equals(piece1))
				|| (grid[0][0].equals(piece1) && grid[1][0].equals(piece1) && grid[2][0].equals(piece1))
				|| (grid[0][1].equals(piece1) && grid[1][1].equals(piece1) && grid[2][1].equals(piece1))
				|| (grid[1][0].equals(piece1) && grid[1][1].equals(piece1) && grid[1][2].equals(piece1))
				|| (grid[2][0].equals(piece1) && grid[2][1].equals(piece1) && grid[2][2].equals(piece1))
				|| (grid[2][0].equals(piece1) && grid[1][1].equals(piece1) && grid[0][2].equals(piece1))
				|| (grid[0][2].equals(piece1) && grid[1][2].equals(piece1) && grid[2][2].equals(piece1))) {
			System.out.println("Player 1 wins!");
			win = true;
		} else if ((grid[0][0].equals(piece2) && grid[0][1].equals(piece2) && grid[0][2].equals(piece2))
				|| (grid[0][0].equals(piece2) && grid[1][1].equals(piece2) && grid[2][2].equals(piece2))
				|| (grid[0][0].equals(piece2) && grid[1][0].equals(piece2) && grid[2][0].equals(piece2))
				|| (grid[0][1].equals(piece2) && grid[1][1].equals(piece2) && grid[2][1].equals(piece2))
				|| (grid[1][0].equals(piece2) && grid[1][1].equals(piece2) && grid[1][2].equals(piece2))
				|| (grid[2][0].equals(piece2) && grid[2][1].equals(piece2) && grid[2][2].equals(piece2))
				|| (grid[2][0].equals(piece2) && grid[1][1].equals(piece2) && grid[0][2].equals(piece2))
				|| (grid[0][2].equals(piece2) && grid[1][2].equals(piece2) && grid[2][2].equals(piece2))) {
			System.out.println("Player 2 wins!");
			win = true;
		}
		if (win) {
			displayGrid(grid);
			blankGrid(grid);
			return win;
		} else {
			return win;
		}
	}

	/**
	 * choiceInputter: Inputs the player's choice into the grid/array
	 *
	 * @param String[][] String boolean String String
	 * @return void
	 */
	public static void choiceInputter(String[][] grid, String choice, boolean player, String piece1, String piece2) {
		if (player) {
			for (int row = 0; row < grid.length; row++) {
				for (int column = 0; column < grid[row].length; column++) {
					if (grid[row][column].equalsIgnoreCase(choice)) {
						System.out.println("Placing piece...");
						sleep(150);
						grid[row][column] = piece1;
					}
				}
			}
		} else {
			for (int row = 0; row < grid.length; row++) {
				for (int column = 0; column < grid[row].length; column++) {
					if (grid[row][column].equalsIgnoreCase(choice)) {
						System.out.println("Placing piece...");
						grid[row][column] = piece2;
					}
				}
			}
		}

	}

}
