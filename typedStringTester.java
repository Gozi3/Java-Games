/**
	* Project: String Typer
	* @author Godstime Osarobo
	* Date:  February, 2016
	* Program Name:  typedStringTester.java
*/
import java.util.*;

public class typedStringTester{
	@SuppressWarnings("resource")
	public static void main(String args[]){
		//Start of Intro
		typedString(25,"**Sentence Typer**");
		System.out.print("   ");
		typedString(50, "Java Edition");
		System.out.println("\n");
		sleep(500);
		//End of Intro

		Scanner scan = new Scanner(System.in);
		typedString(25,"Quick info:");
		typedString(50,"Remember to press the Enter Key at the end of your answer");
		System.out.println("\n");
		sleep(500);
		System.out.print("Enter a sentence to be typed out: ");
		String sentence = scan.nextLine();
		System.out.println("\n");
		System.out.print("Do you want it typed out 'fast' or 'slow' or do you want to put a 'specific' speed in miliseconds?  ");
		String speed = scan.nextLine();
		System.out.println("\n");
		boolean done = false;
		boolean again = true;
		while(again){
			while(!done){
				if(speed.equalsIgnoreCase("fast")){
					sleep(500);
					typedString(25, sentence);
					System.out.println("\n");
					done = true;
				}
				else if(speed.equalsIgnoreCase("slow")){
					sleep(500);
					typedString(50, sentence);
					System.out.println("\n");
					done = true;
				}
				else if(speed.equalsIgnoreCase("specific")){					
					System.out.print("Now enter the speed at which you want the sentence to be typed out at, in miliseconds: ");
					int num = scan.nextInt();
					scan.nextLine();
					System.out.println("");
					sleep(500);
					typedString(num, sentence);
					System.out.println("\n");
					done = true;

				}
				else{
					System.out.print("It seems you didnt enter a speed.\nPlease enter whether you want the speed to be 'fast','slow' or 'specific': ");
					speed = scan.nextLine();
					System.out.println("\n");
				}
			}
			boolean correct = false;
			while(!correct){
				sleep(500);
				System.out.println("Would you like another sentence typed out? 'yes' or 'no'");
				String decision = scan.nextLine();
				System.out.println("\n");
				if(decision.equalsIgnoreCase("yes")){
					correct = true;
					sleep(500);
					typedString(50, "Yaay! Let's go...");
					System.out.println("\n");
					sleep(500);
					System.out.print("Enter a sentence to be typed out: ");
					sentence = scan.nextLine();
					System.out.println("\n");
					System.out.print("Do you want it typed out 'fast' or 'slow' or do you want to put a 'specific' speed in miliseconds?  ");
					speed = scan.nextLine();
					System.out.println("\n");
					done = false;
					again = true;
				}
				else if(decision.equalsIgnoreCase("no")){
					again = false;
					correct = true;
					sleep(500);
					typedString(50, "Thank you for your time! Goodbye.");
				}
				else{
					sleep(500);
					System.out.println("You didn't enter 'yes' or 'no'!\n");
					correct = false;
				}
			}
		}
	}

	/**
		*sleep: makes the console wait depending on the amount of miliseconds chosen
		@param long milis
		@return void
	*/
	public static void sleep(long milis) {
				try
				{
					Thread.sleep(milis);
				}
				catch(Exception e) {}
	}

	/**
		*typedString: Prints a string as if it was being typed out.
		*Time for normal writing is: 25
		*Time for long writing is: 50
		@param long time String sentence
		@return void
	*/
	public static void typedString(long time, String sentence) {
		for(int i = 0;i<sentence.length();i++){
			System.out.print(sentence.charAt(i));
			sleep(time);
		}
		System.out.println("");
	}
}