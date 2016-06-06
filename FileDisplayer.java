import java.util.*;
import java.io.*;

public class FileDisplayer{

	public static void main(String[] args) throws Exception{
		System.out.println("\nWelcome to File Displayer! **Java Edition**");
		System.out.println("\nThe aim of this program is to display a text file of your choice.\n\nps. Make sure the text file is in the same folder as the is program");
		Scanner scan = new Scanner(System.in);
		String input = "";
		while(!input.equalsIgnoreCase("quit")){
			System.out.print("\nEnter the name of the text file to be printed: ");input = scan.nextLine();
			String name = input;
			System.out.print("\nEnter the extenion of the text file to be printed: ");input = scan.nextLine();
			String extension = input;
			System.out.println("\n");
			printFile(name,extension);
			System.out.println("\nWould you like to 'quit', or 'continue'?");
			input = scan.nextLine();
		}
	}

	public static void printFile(String name, String extension) throws Exception{
		Scanner read = new Scanner(System.in);
		String file = "";
		boolean check = true;
		try{
			file = name + "." + extension;
			read = new Scanner(new File(file));
		}
		catch(Exception e){
			System.out.println("Yeah... that's not a file.");
			check = false;
		}
		if(check){
			while(read.hasNextLine()){
				System.out.println(read.nextLine());
			}
		}
		
	}
}