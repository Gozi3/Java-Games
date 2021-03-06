
/**
	* Project: Rock, Paper, Scissors Game
	* @author Godstime Osarobo
	* Date:  February, 2015
	* Program Name:  RockPaperScissors.java
*/
import java.util.Scanner;

public class RockPaperScissors {
	/**
	 * The main method.
	 *
	 * @param String[] args
	 * @return void
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String user = new String(" ");
		String computer = new String(" ");
		double computerChoice = 0;
		boolean play = true;
		System.out.println("Welcome to Rock, Paper, Scissors! **Java Edition**");
		sleep(1000);
		while (play) {
			game(user, computerChoice, computer, scan);
			do {
				typedString(25, "Would you like to play again? Yes/No\n");
				user = scan.nextLine();
			} while (!booleanChecker(user));
			if (user.equalsIgnoreCase("Yes")) {
				play = true;
				System.out.println("");
				System.out.println("Yay!");
				sleep(250);
				typedString(25, "\nThe game will begin again shortly.\n");
				sleep(1000);
			} else {
				play = false;
				System.out.println("");
				System.out.println("Awh...");
				sleep(500);
				typedString(25, "\nTill next time.");
				sleep(250);
				System.out.println("\nBye!");
			}
		}
	}

	/**
	 * The game method.
	 *
	 * @param String user, double ComputerChoice, String computer, Scanner scan
	 * @return void
	 */
	public static void game(String user, double computerChoice, String computer, Scanner scan) {
		do {
			typedString(25, "\nDo you choose rock, paper or scissors?\n");
			user = scan.nextLine();
		} while (!choiceChecker(user));
		computerChoice = Math.random();
		if (computerChoice < 0.34) {
			computer = "rock";
		} else if (computerChoice <= 0.67) {
			computer = "paper";
		} else {
			computer = "scissors";
		}
	}

	public static void gameInstructions() {
		String instruct = new String("To pick the place you want your piece to go type the number at the location.");
		String instruct1 = new String("Unfortunately, your actions can not be undone.");
		String instruct2 = new String("This game is multi-player.");
		String instruct3 = new String("Remember its 'done' to end the game.");
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

	/*
	 * sleep: makes the console wait depending on the amount of milliseconds chosen
	 *
	 * @param long millis
	 *
	 * @return void
	 */
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception ee) {
		}
	}

	/**
	 * typedString: Prints a string as if it was being typed live. Time for normal
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
	}

	/**
	 * The booleanChecker method.
	 *
	 * @param String input
	 * @return boolean
	 */
	public static boolean booleanChecker(String input) {
		if ((input.equalsIgnoreCase("yes")) || (input.equalsIgnoreCase("no"))) {
			return true;

		} else {
			System.out.println("Invalid Answer!");
			return false;

		}
	}

	/**
	 * The choiceChecker method.
	 *
	 * @param String input
	 * @return boolean
	 */
	public static boolean choiceChecker(String input) {
		if ((input.equalsIgnoreCase("rock")) || (input.equalsIgnoreCase("paper"))
				|| (input.equalsIgnoreCase("scissors"))) {
			return true;

		} else {
			System.out.println("Invalid Answer!");
			return false;
		}
	}
}
