import java.util.*;
import java.io.*;

public class X_X {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to File Displayer! **Java Edition**");
		System.out.println(
				"\nThe aim of this program is to display a text file of your choice.\n\nps. Make sure the text file is in the same folder as the is program\n\nTo exit the program type 'quit'.");
		Scanner scan = new Scanner(System.in);
		String input = "";
		while (!input.equalsIgnoreCase("quit")) {
			System.out.print("\nEnter the name of the text file to be printed: ");
			input = scan.nextLine();
			String name = input;
			System.out.print("\nEnter the extension of the text file to be printed: ");
			input = scan.nextLine();
			String extension = input;
			printFile(name, extension);
		}
	}

	public static void printFile(String name, String extension) throws Exception {
		String file = name + "." + extension;
		System.out.println(file);
		Scanner read = new Scanner(new File(file));
		while (read.hasNextLine()) {
			System.out.println(read.nextLine());
		}
	}
}