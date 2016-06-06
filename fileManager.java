/**
	* Project: File Manager
	  @author Godstime Osarobo
	* Date:  February, 2016
	* Program Name:  fileManager.java
*/

/*	example of what it should look like

		 Display Folders
		             # # # # # # #
		             #  Folders  #
		# # # # # # #-# # # # # #-# # # # # # #
		#  Name:                    #  Size:  #
		#                           #         #
		#  A                        #   1     #
		#  folder(1)                #   2     #
		#  folder(2)                #   3     #
		#  folder(3)                #   4     #
		#  folder(4)                #   5     #
		#  folder(5)                #   6     #
		#  folder(6)                #   7     #
		#  folder(7)                #   8     #
		#  folder(8)                #   9     #
		#  ABCDEFGHIJKLMNOPQRST(9)  #   100   #
		#                           #         #
		# # # # # # # # # # # # # # # # # # # # 
		
		Display Files
		                # # # # # #
		                #  Files  #
		# # # # # # # # # # # # # # # # # # # # # # # #
		#  Name:                      #  Type:        #
		#                             #               #
		#  a.x                        #  X File       #
		#  a(1).txt                   #  TEXT File    #
		#  a(2).txt                   #  TEXT File    #
		#  a(3).txt                   #  TEXT File    #
		#  a(4).txt                   #  TEXT File    #
		#  a(5).exe                   #  APPLICATION  #
		#  ABCDEFGHIJKLMNO(99).pqrst  #  PQRST File   #
		#                             #               #
		# # # # # # # # # # # # # # # # # # # # # # # # 

*/

/* Thoughts:
	Have the program running in a loop with the user inputting data.
	Create a Help/Instruction method that explains how to use the program to the user.
	Name, extension and type separation in folder. So folder[] -> folder[][][]
	Switch statement to make '.txt' as a type TEXT File etc.
	Multiple folders -> create a fileManager String[][][][] and add folder[][][]s.
	Make Compare method that sends null positions to the end.
	Make the folder[][][] to have a maximum of 100 files.
	Make the fileManager[][][][] to have a maximum of 10 folders.
	Have the option to sort either the folders or the files in ascending or descending order.
	Create and delete, files and folders.
	Add in the fancy typedString feature you used in TicTacToe.java.
	Create fail safes for instances of which users input the wrong type of information
	Optional: Store the last two commands. You can then use this to check if the Folder/File Manager is sorted and therefore doesn't need sorting.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

@SuppressWarnings("unused")
public class fileManager{
	//Global Variables needed to make the File Manager
		//The 1st[] stores which Folder index the Name/Extension/Type is associated with
		//The 2nd[] stores which File index the Name/Extension/Type is associated with
	public static String fileNames[][] = new String[10][100];//Holds the Name of the File in the numbered Folder
	public static String folderNames[] = new String[10];//Holds the Name of the Folder in the File Manager
	public static String fileExtensions[][] = new String[10][100];//Holds the Extension of the File in the numbered Folder
	public static String fileTypes[][] = new String[10][100];//Holds the Type of the File in the numbered Folder
	public static int fileManagerSize = 0;//Holds the number of Folders in the File Manager
	public static int folderSize[] = new int[10];//Holds the number of Files in the numbered Folder
	public static String commands[] = {"create folder", "create file", "delete folder", "delete file", "rename folder", "rename file", "display folders", "display files", "sort", "empty", "exit", "help"};//Holds all the Commands that the user can use to be checked by validEntryChecker
	public static String input = "";
	public static Scanner scan = new Scanner(System.in);

	public static void main(String args[]){
		//Start of Intro
		System.out.print("                                           ");
		typedString(25,"**File Manager**");
		System.out.print("\n                                             ");
		sleep(250);
		typedString(25, "Java Edition");
		System.out.println("\n\n");
		sleep(500);
		//End of Intro

		//Reminds user to press the 'Enter Key' to enter their answer.
		System.out.println("Quick Info:");
		sleep(250);
		typedString(25,"Remember to press the Enter Key at the end of your answer");
		System.out.println("\n");
		sleep(500);
		System.out.println("Program Description:");
		sleep(250);
		typedString(30,"In this program you can create folders and files (with extensions e.g .txt).");
		System.out.println("");
		sleep(250);
		typedString(30,"You can also delete them, rename them and display them.\n");
		System.out.println("");
		sleep(250);
		typedString(30,"The maximum number of folders allowed is 10.\n");
		System.out.println("");
		sleep(250);
		typedString(30,"The maximum number of files in a folder allowed is 100.\n");
		System.out.println("");
		sleep(250);
		help();
		emptyFileManager();
		boolean run = true;
		int count = 0;
		//starts the loop that runs the program
		while(run){
			System.out.print("Type what you want to do next: ");
			input = scan.nextLine();
			input = validEntryChecker(input,commands, false);
			if(input.equalsIgnoreCase("create folder")){
				createFolder();
			}
			else if(input.equalsIgnoreCase("create file")){
				createFile();
			}
			else if(input.equalsIgnoreCase("delete folder")){
				deleteFolder();
			}
			else if(input.equalsIgnoreCase("delete file")){
				deleteFile();
			}
			else if(input.equalsIgnoreCase("rename folder")){
				renameFolder();
			}
			else if(input.equalsIgnoreCase("rename file")){
				renameFile();
			}
			else if(input.equalsIgnoreCase("display folders")){
				printFolders();
			}
			else if(input.equalsIgnoreCase("display files")){				
				printFiles();
			}
			else if(input.equalsIgnoreCase("sort")){
				commandSort();
			}
			else if(input.equalsIgnoreCase("empty")){
				emptyFileManager();
			}
			else if(input.equalsIgnoreCase("exit")){
				System.out.println("Exiting...");
				sleep(500);
				run = false;
			}
			else if(input.equalsIgnoreCase("help")){
				help();
			}
		}
	}

	/**
		* help: Lists out all the instructions for this program
		  @param void
		  @return void
	*/
	public static void help(){
		System.out.println("");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n");
		sleep(500);
		System.out.print(spaceCalc(51, "Instructions:",2));System.out.println("Instructions:");
		System.out.println("");
		sleep(750);
		System.out.print(spaceCalc(51, "To create a folder: type 'create folder'", 2));typedString(20,"To create a folder: "); sleep(250); typedString(50, "type 'create folder'");
		System.out.println("\n");
		sleep(700);
		System.out.print(spaceCalc(51, "To create a file: type 'create file'", 2));typedString(20,"To create a file: "); sleep(250); typedString(50, "type 'create file'");
		System.out.println("\n");
		sleep(700);
		System.out.print(spaceCalc(51, "To delete a folder: type 'delete folder'", 2));typedString(20,"To delete a folder: "); sleep(250); typedString(50, "type 'delete folder'");
		System.out.println("\n");
		sleep(700);
		System.out.print(spaceCalc(51, "To delete a file: type 'delete file'", 2));typedString(20,"To delete a file: "); sleep(250); typedString(50, "type 'delete file'");
		System.out.println("\n");
		sleep(700);
		System.out.print(spaceCalc(51, "To rename a folder: type 'rename folder'", 2));typedString(20,"To rename a folder: "); sleep(250); typedString(50, "type 'rename folder'");
		System.out.println("\n");
		sleep(700);
		System.out.print(spaceCalc(51, "To rename a file: type 'rename file'", 2));typedString(20,"To rename a file: "); sleep(250); typedString(50, "type 'rename file'");
		System.out.println("\n");
		sleep(700);
		System.out.print(spaceCalc(51, "To sort any part of the file manager: type 'sort'", 2));typedString(20,"To sort any part of the file manager: "); sleep(250); typedString(50, "type 'sort'");
		System.out.println("\n");
		sleep(700);
		System.out.print(spaceCalc(51, "To display all the folders:  type 'display folders'", 2));typedString(20,"To display all the folders:  "); sleep(250); typedString(50, "type 'display folders'");
		System.out.println("\n");
		sleep(700);
		System.out.print(spaceCalc(51, "To display all the files in a folder: type 'display files'", 2));typedString(20,"To display all the files in a folder: "); sleep(250); typedString(50, "type 'display files'");
		sleep(700);
		System.out.println("\n");
		System.out.print(spaceCalc(51, "To empty the entire file manager: type 'empty'", 2));typedString(20,"To empty the entire file manager: "); sleep(250); typedString(50, "type 'empty'");
		sleep(700);
		System.out.println("\n");
		System.out.print(spaceCalc(51, "To exit the program: type 'exit'", 2));typedString(20,"To exit the program: "); sleep(250); typedString(50, "type 'exit'");
		sleep(750);
		System.out.println("\n");
		System.out.print(spaceCalc(51, "You can always type 'help' to display the instructions.", 2));typedString(20,"You can always "); sleep(250); typedString(50, "type 'help'"); sleep(250); typedString(20," to display the instructions."); 
		System.out.println("\n");
		typedString(15,"******************************************************************************************************");
		System.out.println("\n\n");
	}

	/**
		* emptyFileManager: Empties the file Manager
		  @param void
		  @return void
	*/
	public static void emptyFileManager(){
		sleep(700);
		for(int i = 0;i<10;i++){
			for(int j = 0;j<100;j++){
				fileNames[i][j] = null;
			}
		}
		for(int i = 0;i<10;i++){
			folderNames[i] = null;
		}
		for(int i = 0;i<10;i++){
			for(int j = 0;j<100;j++){
				fileExtensions[i][j] = null;
			}
		}		
		for(int i = 0;i<10;i++){
			for(int j = 0;j<100;j++){
				fileTypes[i][j] = null;
			}
		}
		fileManagerSize = 0;
		for(int i = 0;i<10;i++){
			folderSize[i] = 0;
		}
	}
	/**
		* correctNames: Makes sure there are no files with the same name
		  @param String[] folder, int size
		  @return void
	*/
	public static void correctNames(String folder[], int size){
		int count = 1;
		for(int i = 0;i < size;i++){
			for(int j = 0;j < i;j++){
				if(folder[j].equals(folder[i])){
					count = 1;
					folder[i] += "(" + count + ")";
					for(int k = 0;k<i;k++){
						if(folder[k].equals(folder[i])){
							int temp = 0;
							for(int z = folder[i].length()-1;z>-1;z--){
								if(folder[i].charAt(z) == '('){
									break;
								}
								else{
									temp++;
								}
							}
							count = Integer.parseInt(folder[i].substring(folder[i].length()-(temp),folder[i].length()-1));
							count++;
							folder[i] = folder[i].substring(0,folder[i].length()-temp-1) + "(" + count + ")";
						}
					}
				}
			}
		}
	}

	/**
		* createFolder: Creates a Folder that can have File
		  @param void
		  @return void
	*/
	public static void createFolder(){
		System.out.println("");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n");
		sleep(500);
		System.out.print("                                              ");System.out.println("Folder Creator:");
		System.out.println("");
		sleep(750);
		
		if(fileManagerSize == 1){
			typedString(25, ("You currently have " + fileManagerSize + " folder."));
		}
		else{
			typedString(25, ("You currently have " + fileManagerSize + " folders."));
		}

		System.out.println("\n");
		if(fileManagerSize == 9){
			System.out.println("That is the maximum number of folders allowed.");
			sleep(250);
			typedString(25, "To create more folders, delete some existing ones.");
			System.out.println("\n");
			sleep(500);
			typedString(15,"******************************************************************************************************");
			System.out.println("\n\n");
			return;
		}
		else{
			System.out.print("Please, enter a name for your folder: ");
			input = scan.nextLine();
			nameChecker(input,1,16);
			folderNames[fileManagerSize] = input;
			fileManagerSize++;
		}
		System.out.println("\nDone!");
		System.out.println("\n");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n\n");
		correctNames(folderNames, fileManagerSize);
		return;
	}

	/**
		* createFile: Creates a File
		  @param void
		  @return void
	*/
	public static void createFile(){//check if there's a folder
		System.out.println("");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n");
		sleep(500);
		System.out.print(spaceCalc(51, "File Creator:",2));System.out.println("File Creator:");
		System.out.println("");
		sleep(750);
		if(fileManagerSize == 0){
			System.out.println("You have not made a folder yet!");
			sleep(250);
			typedString(25, "To create a file, first make a folder.");
			System.out.println("\n");
			sleep(500);
			typedString(15,"******************************************************************************************************");
			System.out.println("\n\n");
			return;
		}
		printFolders();
		System.out.print("Please, enter the name of the folder you want the file to go in: ");
		input = scan.nextLine();
		validEntryChecker(input, folderNames, true);
		int location = 0;
		for(int i = 0;i<fileManagerSize;i++){
			if(input.equals(folderNames[i])){
				location = i;
				break;
			}
		}
		if(fileManagerSize == 1){
			typedString(25, ("You currently have " + folderSize[location] + " file."));
		}
		else{
			typedString(25, ("You currently have " + folderSize[location] + " files."));
		}
		System.out.println("\n");
		if(folderSize[location] == 100){
			System.out.println("That is the maximum number of files allowed!\n");
			sleep(250);
			typedString(25, "To create more files, delete some existing ones.");
			System.out.println("\n");
			sleep(500);
			typedString(15,"******************************************************************************************************");
			System.out.println("\n\n");
			return;
		}

		System.out.print("Please, enter a name for your file: ");
		input = scan.nextLine();
		input = nameChecker(input,1,10);
		fileNames[location][folderSize[location]] = input;
		System.out.println("");
		System.out.println("Please, enter a name for your file extension");
		input = scan.nextLine();
		input = nameChecker(input,1,4);
		fileExtensions[location][folderSize[location]] = input.toLowerCase();
		fileTypes[location][folderSize[location]] = typeSelector(fileExtensions[location][folderSize[location]]);
		folderSize[location]++;
		System.out.println("\nDone!");
		System.out.println("\n");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n\n");
		correctNames(fileNames[location], folderSize[location]);
		return;
	}

	/**
		* deleteFolder: Deletes a Folder in the File Manager
		  @param void
		  @return void
	*/
	public static void deleteFolder(){
		System.out.println("");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n");
		sleep(500);
		System.out.print(spaceCalc(51, "Folder Deleter:",2));System.out.println("Folder Deleter:");
		System.out.println("");
		sleep(750);
		printFolders();
		System.out.print("Please, enter the name of the folder you want to delete: ");
		input = scan.nextLine();
		input = validEntryChecker(input, folderNames, true);
		int location = 0;
		for(int i = 0;i<fileManagerSize;i++){
			if(input.equals(folderNames[i])){
				location = i;
				break;
			}
		}
		folderNames[location] = "null";
		System.out.println("\nDone!");
		System.out.println("\n");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n\n");
		correctNames(folderNames, fileManagerSize);
		fileManagerSort("null");
		return;
	}

	/**
		* deleteFile: Deletes a File from a Folder
		  @param void
		  @return void
	*/
	public static void deleteFile(){
		System.out.println("");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n");
		sleep(500);
		System.out.print(spaceCalc(51, "File Deleter:",2));System.out.println("File Deleter:");
		System.out.println("");
		sleep(750);
		printFolders();
		System.out.print("Please, enter the name of the folder that your file is in: ");
		input = scan.nextLine();
		input = validEntryChecker(input, folderNames, true);
		int location = 0;
		for(int i = 0;i<fileManagerSize;i++){
			if(input.equals(folderNames[i])){
				location = i;
				break;
			}
		}
		int location2 = 0;
		System.out.println("");
		printFiles(location);
		System.out.print("Please, enter the name of the file that you want to delete: ");
		input = scan.nextLine();
		input = validEntryChecker(input, fileNames[location], true);
		for(int j = 0;j<folderSize[location];j++){
			if(input.equals(fileNames[location][j])){
				location2 = j;
				break;
			}
		}
		fileNames[location][location2] = "null";
		fileExtensions[location][location2] = "null";
		fileTypes[location][location2] = "null";
		folderSize[location]--;
		System.out.println("\nDone!");
		System.out.println("\n");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n\n");
		correctNames(fileNames[location], folderSize[location]);
		folderSort(location, "null");
		return;		
	}

	/**
		* renameFolder: Renames a Folder in the File Manager
		  @param void
		  @return void
	*/
	public static void renameFolder(){
		System.out.println("");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n");
		sleep(500);
		System.out.print(spaceCalc(51, "Folder Renamer:",2));System.out.println("Folder Renamer:");
		System.out.println("");
		sleep(750);
		printFolders();
		System.out.print("Please, enter the name of the folder you want to rename: ");
		input = scan.nextLine();
		input = validEntryChecker(input, folderNames, true);
		int location = 0;
		for(int i = 0;i<fileManagerSize;i++){
			if(input.equals(folderNames[i])){
				location = i;
				break;
			}
		}
		System.out.println("");
		System.out.print("Please, enter a name for your folder: ");
		input = scan.nextLine();
		input = nameChecker(input,1,20);
		folderNames[location] = input;
		System.out.println("\nDone!");
		System.out.println("\n");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n\n");
		correctNames(folderNames, fileManagerSize);
		return;
	}

	/**
		* renameFile: renames a File in a specific Folder
		  @param void
		  @return void
	*/
	public static void renameFile(){
		System.out.println("");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n");
		sleep(500);
		System.out.print(spaceCalc(51, "File Renamer:",2));System.out.println("File Renamer:");
		System.out.println("");
		sleep(750);
		printFolders();
		System.out.print("Please, enter the name of the folder that your file is in: ");
		input = scan.nextLine();
		input = validEntryChecker(input, folderNames, true);
		int location = 0;
		for(int i = 0;i<fileManagerSize;i++){
			if(input.equals(folderNames[i])){
				location = i;
				break;
			}
		}
		int location2 = 0;
		System.out.println("");
		printFiles(location);
		System.out.print("Please, enter the name of the file that you want to rename: ");
		input = scan.nextLine();
		input = validEntryChecker(input, fileNames[location], true);
		for(int j = 0;j<folderSize[location];j++){
			if(input.equals(fileNames[location][j])){
				location2 = j;
				break;
			}
		}
		System.out.println("");
		System.out.print("Please, enter a name for your file: ");
		input = scan.nextLine();
		input = nameChecker(input,1,15);
		fileNames[location][location2] = input;
		System.out.println("");
		System.out.print("Please enter an extension name for your file: ");
		input = scan.nextLine();
		input = nameChecker(input,1,4);
		fileExtensions[location][location2] = input;
		fileTypes[location][location2] = typeSelector(fileExtensions[location][location2]);
		System.out.println("\nDone!");
		System.out.println("\n");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n\n");
		correctNames(fileNames[location], folderSize[location]);
		return;
	}
	/**
		* printFolders: Displays all the Folders in the File Manager
		 @param void
		 @return void
	*/
	/*  Display Folders
		             # # # # # # #
		             #  Folders  #
		# # # # # # #-# # # # # #-# # # # # # #
		#  Name:                    #  Size:  #
		#                           #         #
		#  A                        #   1     #
		#  folder(1)                #   2     #
		#  folder(2)                #   3     #
		#  folder(3)                #   4     #
		#  folder(4)                #   5     #
		#  folder(5)                #   6     #
		#  folder(6)                #   7     #
		#  folder(7)                #   8     #
		#  folder(8)                #   9     #
		#  ABCDEFGHIJKLMNOPQRST(9)  #   100   #
		#                           #         #
		# # # # # # # # # # # # # # # # # # # # 
	*/ 
	public static void printFolders(){
		System.out.println("");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n");
		sleep(500);
		System.out.print(spaceCalc(51, "Folder Display:",2));System.out.println("Folder Display:");
		System.out.println("");
		sleep(750);
		System.out.print(spaceCalc(51, "# # # # # # #", 2));System.out.println("# # # # # # #");
		System.out.print(spaceCalc(51, "#  Folders  #", 2));System.out.println("#  Folders  #");
		System.out.print(spaceCalc(51, "# # # # # # #-# # # # # #-# # # # # # #", 2));System.out.println("# # # # # # #-# # # # # #-# # # # # # #");
		System.out.print(spaceCalc(51, "#  Name:                    #  Size:  #", 2));System.out.println("#  Name:                    #  Size:  #");
		System.out.print(spaceCalc(51, "#                           #         #", 2));System.out.println("#                           #         #");
		for(int i = 0;i<10;i++){
			if(folderNames[i] == null){
				break;		
			}				
			else{
				String info = "#  " + folderNames[i] + spaceCalc(23,folderNames[i],1) + "  #   " + folderSize[i] + spaceCalc(4,Integer.toString(folderSize[i]),1) + "  #";			
				System.out.print(spaceCalc(51, info, 2));System.out.println(info);
			}				
		}					
        System.out.print(spaceCalc(51, "#                           #         #", 2));System.out.println("#                           #         #");
        System.out.print(spaceCalc(51, "# # # # # # # # # # # # # # # # # # # #", 2));System.out.println("# # # # # # # # # # # # # # # # # # # #");
        System.out.println("\n");
        sleep(700);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n\n");
	}

	/**
		* printFiles: Displays all the Files in a specific Folder
		  @param void
		  @return void
	*/
	/*  Display Files
		                # # # # # #
		                #  Files  #
		# # # # # # # # # # # # # # # # # # # # # # # #
		#  Name:                      #  Type:        #
		#                             #               #
		#  a.x                        #  X File       #
		#  a(1).txt                   #  TEXT File    #
		#  a(2).txt                   #  TEXT File    #
		#  a(3).txt                   #  TEXT File    #
		#  a(4).doc                   #  TEXT File    #
		#  a(5).exe                   #  APPLICATION  #
		#  ABCDEFGHIJKLMNO(99).pqrst  #  PQRST File   #
		#                             #               #
		# # # # # # # # # # # # # # # # # # # # # # # # 
	*/ 
	public static void printFiles(){
		System.out.println("");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n");
		sleep(500);
		System.out.print(spaceCalc(51, "File Display:",2));System.out.println("File Display:");
		System.out.println("");
		sleep(750);
		if(fileManagerSize == 0){
			System.out.println("You have not made a folder yet!");
			sleep(250);
			typedString(25, "To display file, first make a folder.");
			System.out.println("\n");
			sleep(500);
			typedString(15,"******************************************************************************************************");
			System.out.println("\n\n");
			return;
		}
		printFolders();
		System.out.print("Please, enter the name of the folder you want to display: ");
		input = scan.nextLine();
		validEntryChecker(input, folderNames, true);
		int location = 0;
		for(int i = 0;i<fileManagerSize;i++){
			if(input.equals(folderNames[i])){
				location = i;
				break;
			}
		}
		System.out.print(spaceCalc(51, "# # # # # #", 2));System.out.println("# # # # # #");
		System.out.print(spaceCalc(51, "#  Files  #", 2));System.out.println("#  Files  #");
		System.out.print(spaceCalc(51, "# # # # # # # # # # # # # # # # # # # # # # # #", 2));System.out.println("# # # # # # # # # # # # # # # # # # # # # # # #");
		System.out.print(spaceCalc(51, "#  Name:                      #  Type:        #", 2));System.out.println("#  Name:                      #  Type:        #");
		System.out.print(spaceCalc(51, "#                             #               #", 2));System.out.println("#                             #               #");
		for(int i = 0;i<100;i++){
			if(fileNames[location][i] == null){
				break;		
			}				
			else{
				String info = "#  " + fileNames[location][i] + "." + fileExtensions[location][i] + spaceCalc(25,fileNames[location][i] + "." + fileExtensions[location][i],1) + "  #  " + fileTypes[location][i] + spaceCalc(11, fileTypes[location][i],1) + "  #";			
				System.out.print(spaceCalc(51, info, 2));System.out.println(info);
			}				
		}					
        System.out.print(spaceCalc(51, "#                             #               #", 2));System.out.println("#                             #               #");
        System.out.print(spaceCalc(51, "# # # # # # # # # # # # # # # # # # # # # # # #", 2));System.out.println("# # # # # # # # # # # # # # # # # # # # # # # #");
        System.out.println("\n");
        sleep(700);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n\n");
	}

	/**
		* printFiles: Displays all the Files in a specific Folder
		  @param int location
		  @return void
	*/
	public static void printFiles(int location){
		System.out.print(spaceCalc(51, "# # # # # #", 2));System.out.println("# # # # # #");
		System.out.print(spaceCalc(51, "#  Files  #", 2));System.out.println("#  Files  #");
		System.out.print(spaceCalc(51, "# # # # # # # # # # # # # # # # # # # # # # # #", 2));System.out.println("# # # # # # # # # # # # # # # # # # # # # # # #");
		System.out.print(spaceCalc(51, "#  Name:                      #  Type:        #", 2));System.out.println("#  Name:                      #  Type:        #");
		System.out.print(spaceCalc(51, "#                             #               #", 2));System.out.println("#                             #               #");
		for(int i = 0;i<100;i++){
			if(fileNames[location][i] == null){
				break;		
			}				
			else{
				String info = "#  " + fileNames[location][i] + "." + fileExtensions[location][i] + spaceCalc(25,fileNames[location][i] + "." + fileExtensions[location][i],1) + "  #  " + fileTypes[location][i] + spaceCalc(11, fileTypes[location][i],1) + "  #";			
				System.out.print(spaceCalc(51, info, 2));System.out.println(info);
			}				
		}					
        System.out.print(spaceCalc(51, "#                             #               #", 2));System.out.println("#                             #               #");
        System.out.print(spaceCalc(51, "# # # # # # # # # # # # # # # # # # # # # # # #", 2));System.out.println("# # # # # # # # # # # # # # # # # # # # # # # #");
        System.out.println("\n");
        sleep(700);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n\n");
	}

	/**
		* commandSort: Selects the sort the user wants
		  @param void
		  @return void
	*/
	public static void commandSort(){
		System.out.println("");
		sleep(500);
		typedString(15,"******************************************************************************************************");
		System.out.println("\n");
		sleep(500);
		System.out.print("                                             ");System.out.println("Sort Chooser:");
		System.out.println("");
		sleep(750);
		System.out.println("To sort the file names in a folder, type 'files'");
		System.out.println("To sort the folder names, type 'folders'");
		System.out.println("To sort the entire file manager, type 'everything'");
		sleep(500);
		System.out.println("\n");
		System.out.print("Pick an option: ");
		input = scan.nextLine();
		String answers[] = {"files", "folders", "everything"};
		input = validEntryChecker(input, answers, false);
		if(input.equalsIgnoreCase("files")){
			printFolders();
			sleep(250);
			System.out.print("Type the name of the folder you want to sort: ");
			input = scan.nextLine();
			input = validEntryChecker(input,folderNames, true);
			int location = 0;
			for(int i =0;i<10;i++){
				if(input.equals(folderNames[i])){
					location = i;
					break;
				}
			}
			if(folderSize[location] == 0){
				System.out.println();
				System.out.println("There are no files in this folder!");
				sleep(250);
				typedString(25, "To sort files, there have to be files to sort.");
				System.out.println("\n");
				sleep(500);
				typedString(15,"******************************************************************************************************");
				System.out.println("\n\n");
				return;
			}
			System.out.print("Do you want the files to be sorted in 'ascending' or 'descending' order? ");
			input = scan.nextLine();
			String order[] = {"ascending", "descending"};
			input = validEntryChecker(input, order, false);
			folderSort(location, input);
			if(input.equalsIgnoreCase("descending")){
				folderSort(location, "null");
			}
		}
		else if(input.equalsIgnoreCase("folders")){
			if(fileManagerSize == 0){
				System.out.println();
				System.out.println("There are no folders in this file manager!");
				sleep(250);
				typedString(25, "To sort folders, there have to be folders to sort.");
				System.out.println("\n");
				sleep(500);
				typedString(15,"******************************************************************************************************");
				System.out.println("\n\n");
				return;
			}
			System.out.print("Do you want the folder to be sorted in 'ascending' or 'descending' order? ");
			input = scan.nextLine();
			String order[] = {"ascending", "descending"};
			input = validEntryChecker(input, order, false);
			fileManagerSort(input);
			if(input.equalsIgnoreCase("descending")){
				fileManagerSort("null");
			}
		}
		else{
			System.out.print("Do you want everything to be sorted in 'ascending' or 'descending' order? ");
			input = scan.nextLine();
			String order[] = {"ascending", "descending"};
			input = validEntryChecker(input, order, false);
			systemSort(input);
			if(input.equalsIgnoreCase("descending")){
				systemSort("null");
			}
		}
		System.out.println("Done!");
		sleep(500);
		System.out.println("\n");
		typedString(15,"******************************************************************************************************");
		System.out.println("\n\n");
		return;
	}
	/**
		* systemSort: Sorts the entire File Manager System using merge sort
		  @param String order
		  @return void
	*/
	public static void systemSort(String order){
		String folderKey[][] = new String[10][100];
	 	for(int i = 0;i<10;i++){
	 		for(int j = 0;j<100;j++){
	 			folderKey[i][j] = folderNames[i] + " " + fileNames[i][j] + " " + fileExtensions[i][j] + " " + fileTypes[i][j];
	 		}
	 	}
	 	for(int i = 0;i<10;i++){
	 		sorter(folderKey[i], order);
	 	}
	 	for(int i = 0;i<100;i++){		
	 		for(int j = 0;j<100;j++){
	 			String array[] = folderKey[i][j].split(" ");
	 			folderNames[i] = array[0];
		 		fileNames[i][j] = array[1];
		 		fileExtensions[i][j] = array[2];
		 		fileTypes[i][j] = array[3];		 		
		 	}
		 	nullsToNull(fileNames[i]);
		 	nullsToNull(fileExtensions[i]);
		 	nullsToNull(fileTypes[i]);
	 	}
	 	nullsToNull(folderNames);
	}

	/**
		* fileManagerSort: Sorts the Folders in the File Manager using merge sort
		  @param String order
		  @return void
	*/
	public static void fileManagerSort(String order){
		String folderKey[] = new String[10];
	 	for(int i = 0;i<10;i++){
	 		folderKey[i] = folderNames[i] + " " + i;
	 	}
	 	sorter(folderKey, order);
	 	for(int i = 0;i<10;i++){
	 		String array[] = folderKey[i].split(" ");
	 		folderNames[i] = array[0];
	 		String tempFolder[][] = new String[10][100];
	 		for(int j = 0;j<100;j++){
	 			tempFolder[i][j] = fileNames[i][j];
	 			fileNames[i][j] = fileNames[Integer.parseInt(array[1])][j];
	 			fileNames[Integer.parseInt(array[1])][j] = tempFolder[i][j];
	 			tempFolder[i][j] = fileExtensions[i][j];
	 			fileExtensions[i][j] = fileExtensions[Integer.parseInt(array[1])][j];
	 			fileExtensions[Integer.parseInt(array[1])][j] = tempFolder[i][j];
	 			tempFolder[i][j] = fileTypes[i][j];
	 			fileTypes[i][j] = fileTypes[Integer.parseInt(array[1])][j];
	 			fileTypes[Integer.parseInt(array[1])][j] = tempFolder[i][j];
	 		}	 		
	 	}
	 	nullsToNull(folderNames);
	}

	/**
		* folderSort: Sorts the Folder at a given location using merge sort
		  @param int location, String order
		  @return void
	*/
	public static void folderSort(int location, String order){
		int loc = location;
	 	String folderKey[] = new String[100];
	 	for(int i = 0;i<100;i++){
	 		folderKey[i] = fileNames[loc][i] + " " + fileExtensions[loc][i] + " " + fileTypes[loc][i];
	 	}
	 	sorter(folderKey, order);
	 	for(int i = 0;i<100;i++){
	 		String array[] = folderKey[i].split(" ");
	 		fileNames[loc][i] = array[0];
	 		fileExtensions[loc][i] = array[1];
	 		fileTypes[loc][i] = array[2];
	 		if(fileNames[loc][i].equals("null")){
	 			fileNames[loc][i] = null;
	 		}
	 		if(fileExtensions[loc][i].equals("null")){
	 			fileExtensions[loc][i] = null;
	 		}
	 		if(fileTypes[loc][i].equals("null")){
	 			fileTypes[loc][i] = null;
	 		}
	 	}
	 	nullsToNull(fileNames[location]);
	 	nullsToNull(fileExtensions[location]);
	 	nullsToNull(fileTypes[location]);
	}

	/**
		* sorter: Splits the arrays recursively and calls on the merger method to sort them
		  @param String[] folderKey, String order
		  @return void
	*/
	public static void sorter(String folderKey[], String order){
		int size = folderKey.length;//size of the folder
        if (size < 2){//if the folder only has 1 Document, its already sorted
            return;
        }
        int mid = size / 2;//gets the halfway point to split the folder in half
        int leftSize = mid;//size of the left folder
        int rightSize = size - mid;//size of the right folder
        String left[] = new String[leftSize];//creates the left folder
        String right[] = new String[rightSize];//creates the right folder
        for (int i = 0; i < mid; i++) {//fills the left folder with the values of the left side of the folder
            left[i] = folderKey[i];

        }
        for (int i = mid; i < size; i++) {//fills the right folder with the values of the right side of the folder
            right[i - mid] = folderKey[i];
        }
        
        sorter(left,order);//repeatedly divides the left folder into smaller halves and sorts it              
        sorter(right,order);//repeatedly divides the right folder into smaller halves and sorts it
        if(order.equalsIgnoreCase("ascending")){
        	mergerAsc(left, right, folderKey);//combines the sorted halves into the original folder
        }
        else if(order.equalsIgnoreCase("null")){
        	mergerNull(left, right, folderKey);
        }
        else{
        	mergerDesc(left, right, folderKey);//combines the sorted halves into the original folder
        }
        

        //gives a display of what is ACTUALLY going on
        //System.out.println("sorter (left): " + Arrays.toString(left));
        //System.out.println("sorter (right): " + Arrays.toString(right));  
        //System.out.println("folder: " + Arrays.toString(folderKey));
	}

	/**
		* mergerAsc: Sorts the split arrays in ascending order and merges them
		  @param String left[], String right[], String folder[]
		  @return void
	*/
	public static void mergerAsc(String left[], String right[], String folder[]){
		int leftSize = left.length;
        int rightSize = right.length;
        int iLeft = 0;//leftIndex
        int iRight = 0;//rightIndex
        int iFolder = 0;//folderIndex
        
        while (iLeft < leftSize && iRight < rightSize) {
            if (right[iRight].compareTo(left[iLeft]) > 0) {//sorts lexicographically in ascending order
                folder[iFolder] = left[iLeft];
                iLeft++;
                iFolder++;
            } else {
                folder[iFolder] = right[iRight];
                iRight++;
                iFolder++;
            }
        }
        while (iLeft < leftSize) {
            folder[iFolder] = left[iLeft];
            iLeft++;
            iFolder++;
        }
        while (iRight < rightSize) {
            folder[iFolder] = right[iRight];
            iRight++;
            iFolder++;
        }
	}

	/**
		* mergerDesc: Sorts the split arrays in descending order and merges them
		  @param String left[], String right[], String folder[]
		  @return void
	*/
	public static void mergerDesc(String left[], String right[], String folder[]){
		int leftSize = left.length;
        int rightSize = right.length;
        int iLeft = 0;//leftIndex
        int iRight = 0;//rightIndex
        int iFolder = 0;//folderIndex
        
        while (iLeft < leftSize && iRight < rightSize) {
            if (right[iRight].compareTo(left[iLeft]) < 0) {//sorts lexicographically in descending order
                folder[iFolder] = left[iLeft];
                iLeft++;
                iFolder++;
            } else {
                folder[iFolder] = right[iRight];
                iRight++;
                iFolder++;
            }
        }
        while (iLeft < leftSize) {
            folder[iFolder] = left[iLeft];
            iLeft++;
            iFolder++;
        }
        while (iRight < rightSize) {
            folder[iFolder] = right[iRight];
            iRight++;
            iFolder++;
        }
	}

	/**
		* mergerNull: Sorts the split arrays by choosing nulls over anything and merges them
		  @param String left[], String right[], String folder[]
		  @return void
	*/
	public static void mergerNull(String left[], String right[], String folder[]){
		int leftSize = left.length;
        int rightSize = right.length;
        int iLeft = 0;//leftIndex
        int iRight = 0;//rightIndex
        int iFolder = 0;//folderIndex
        
        while (iLeft < leftSize && iRight < rightSize) {
            if(left[iLeft].equals("null")){//picks nulls over anything
                folder[iFolder] = right[iRight];
                iRight++;
                iFolder++;
            }
            else{
                folder[iFolder] = left[iLeft];
                iLeft++;
                iFolder++;
            }
        }
        while (iLeft < leftSize) {
            folder[iFolder] = left[iLeft];
            iLeft++;
            iFolder++;
        }
        while (iRight < rightSize) {
            folder[iFolder] = right[iRight];
            iRight++;
            iFolder++;
        }
	}

	/**
		* sleep: Makes the console wait depending on the amount of milliseconds chosen
		  @param long millis
		  @return void
	*/
	public static void sleep(long millis) {
				try
				{
					Thread.sleep(millis);
				}
				catch(Exception e) {}
	}

	/**
		* typedString: Prints a string as if it was being typed out.
		* Time for normal writing is: 25
		* Time for long writing is: 50
		  @param long time String sentence
		  @return void
	*/
	public static void typedString(long time, String sentence) {
		for(int i = 0;i<sentence.length();i++){
			System.out.print(sentence.charAt(i));
			sleep(time);
		}
	}

	/**
		* typeSelector: Selects the type for a File using switch statements, depending the name of the File's extension
		  @param String extension
		  @return String
	*/
	public static String typeSelector(String extension){
		String type = extension.toUpperCase();
		switch(type){
			case "EXE":
				return "APPLICATION";
			case "MP3":
			case "WAV":
			case "OGG":
			case "FLAC":
			case "AIFF":
			case "VOX":
			case "RAW" :
			case "WMA":
			case "AAC":
			case "ATRAC":
				return "AUDIO";
			case "FLV":
			case "MKV":
			case "AVI":
			case "MOV":
			case "WMV":
			case "MP4":
			case "MPEG":
			case "MPG":
			case "M4V":
				return "VIDEO";
			case "JPEG":
			case "JPG":
			case "PNG":
			case "BMP":
			case "GIF":
			case "TIF":
			case "TIFF":
			case "JIF":
				return "IMAGE";
			case "DOC":
			case "DOCM":
			case "DOCX":
			case "DOT":
			case "DOTM":
			case "DOTX":
			case "EPUB":
			case "ODT":
			case "PAGES":
			case "PDF":
			case "POT":
			case "POTX":
			case "PPS":
			case "PPSX":
			case "PPT":
			case "PPTM":
			case "PPTX":
			case "PUB":
			case "PWI":
			case "RTF":
			case "XPS":
				return "DOCUMENT";
			case "TXT":
				return "TEXT File";
			default:
				return type + " File";

		}
	}
	/**
		* validEntryChecker: Checks if the user's input is valid.
		  @param String entry, String[] answers, boolean caseSensitive
		  @return String
	*/
	public static String validEntryChecker(String entry, String[] answers, boolean caseSensitive) {
		sleep(250);
		boolean valid = false;
		int counter = 0;
		if(caseSensitive){
			while(!valid){
				for(int i = 0;i<answers.length;i++){
					if(entry.equals(answers[i])){
						valid = true;
					}
				}
				if(!valid){
					if(counter == 2){
						System.out.println("That is an Invalid Answer!\n");
						System.out.print("Remember your options are: [");
						for(int z = 0;z<answers.length;z++){
							if(answers[z].equals(null)){
								break;
							}
							else{
								if(answers[z+1].equals(null)){
									System.out.print(answers[z]);
								}
								else{
									System.out.print(answers[z] + ", ");
								}								
							}
						}
						System.out.print("]\n");
						typedString(25, "Please try again: ");
						entry = scan.nextLine();
						counter = 0;
					}
					else{
						System.out.println("That is an Invalid Answer!\n");
						typedString(25, "Please try again: ");
						entry = scan.nextLine();
						counter++;
					}
					
				}			
			}
		}
		else{
			while(!valid){
				for(int i = 0;i<answers.length;i++){
					if(entry.equalsIgnoreCase(answers[i])){
						valid = true;
					}
				}
				if(!valid){
					if(counter == 2){
						System.out.println("That is an Invalid Answer!\n");
						System.out.println("Remember your options are: " + Arrays.toString(answers));
						typedString(25, "Please try again: ");
						entry = scan.nextLine();
						counter = 0;
					}
					else{
						System.out.println("That is an Invalid Answer!\n");
						typedString(25, "Please try again: ");
						entry = scan.nextLine();
						counter++;
					}
					
				}			
			}
		}
		return entry;
	}

	/**
		* nameChecker: Checks if the user's input for a name is not empty or more than 10.
		  @param String entry
		  @return String
	*/
		public static String nameChecker(String entry, int start, int end) {
		boolean valid = false;
		while(!valid){
			if(!(entry.equals("")) || !(entry.equals("null")) || !(entry.length() > end)){
				valid =true;
			}
			if(!valid){
				System.out.println("Names cannot be 'null' and must have " + start + " - " + end + " characters!\n");
				typedString(25, "Please try again: ");
				entry = scan.nextLine();
			}			
		}
		return entry;
	}

	/**
		* spaceCalc: Calculates how much space needed to format the String into position
		  @param int space, String length, int divider
		  @return String
	*/
	public static String spaceCalc(int length, String text,int divider){
		int spaceLength = length - text.length()/divider;
		StringBuilder space = new StringBuilder(length);
		for(int i = 0;i<spaceLength;i++){
			space.append(" ");
		}
		return space.toString();
	}
	/**
		* nullsToNull: All File Names/Extensions/Types or Folders names called "null" are made null
		  @param String array[]
		  @return void
	*/
	public static void nullsToNull(String array[]) {
		for(int i = 0;i<array.length;i++){
			if(array[i].equals("null")){
				array[i] = null;
			}
		}	
	}
}