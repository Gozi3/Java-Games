//using Scanner instead of JOptionPane to keep everything in the terminal window
import java.util.Scanner;

public class Hangman{
	public static void main(String[] args){
		//6 words for testing
		String[] words = {"january", "february", "march", "april", "may", "june" };
		//choose a word from the array as 'the' word this round
		String word = words[(int) (Math.random() * words.length)];
		//Set turn count to 0
		int count = 0;
		//Create another String of ***s the same length as the chosen word
		StringBuffer strBuff=new StringBuffer();
		String asterisk;
		for(int i=0;i<word.length();i++){
			strBuff.append('*');
		}
		asterisk=strBuff.toString();
		//declare Scanner
		Scanner scan = new Scanner(System.in);
		//while the user has not used all their turns (7) and they have also not guessed the word
		while (count < 7 && !asterisk.equals(word)) {
			System.out.println("Guess any letter in the word");
			//print the *****s
			System.out.println(asterisk);
			//ask for guess
			String guess = scan.next();
			//new blank String. This will contain the new set of ***s after the turn
			String wordProgress = "";
			//loop through the word and add in any correct guesses to the wordProgress String. Any place that doesnt match gets a *
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == guess.charAt(0)) {
					wordProgress=wordProgress+guess.charAt(0);
				} else if (asterisk.charAt(i) != '*') {
					wordProgress=wordProgress + word.charAt(i);
				} else {
					wordProgress =wordProgress+ "*";
				}
			}
			/*Here we check if the word has 'progressed' since the last turn.
			We are going to check the asterisks vs the progress each turn.
			If they stay the same, no progress has been mad and we up the turn counter by 1
			If they are different, we update the asterisk String to match wordProgress and move on
			*/
			if (asterisk.equals(wordProgress)) {
				count++;
			} else {
				asterisk = wordProgress;
			}
			if (asterisk.equals(word)) {
				System.out.println("Correct! You win! The word was " + word);
			}
		}
		if(count==7){
			System.out.println("Uh oh! No turns left!");
		}
		System.out.println("Play again soon!");
	}
}