import java.util.*;// I want to scan stuff
public class forever_and_ever{
	@SuppressWarnings("resource")
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);// I can now scan stuff

		System.out.print("Please enter a String: ");// give me something to use
		String input = scan.nextLine();// got it

		String array[] = input.split(""); // split all the characters into an array
		Arrays.sort(array);// sort the array of characters in ascending order

		String hashmap[] = new String[array.length];// make an array to pick AND NO IT'S NOT REALLY A HASHMAP
		Arrays.fill(hashmap, "");// I dont want null errors
		int index = 0;// so I dont get lost in my hashmap array
		// loop through the hashmap array
		for(int i = 0;i<array.length-1;i++){
			if(i+1 == array.length-1 && (array[i].equals(array[i+1]))){// if it's the second last character int the array and its the same as the last one
				// basically it makes a string that joins all the instances of that character
				hashmap[index] +=array[i];
				hashmap[index] +=array[i+1];
			}
			else if(i+1 == array.length-1 && !(array[i].equals(array[i+1]))){// if it's the second last character int the array and its not the same as the last one
				// see above
				hashmap[index] +=array[i];
				index++;
				hashmap[index] +=array[i+1];
			}
			else if(!(array[i].equals(array[i+1]))){// if the current character is no the same as the next character finish this string and move on to the next index
				// see above
				hashmap[index] +=array[i];
				index++;
			}
			else{
				// see above
				hashmap[index] +=array[i];
			}
		}
		for(int i = 0;i<hashmap.length;i++){
			for(int j = 0;j<hashmap.length-1;j++){
				if(hashmap[j].length()<hashmap[j+1].length()){
					String temp = hashmap[j];
					hashmap[j] = hashmap[j+1];
					hashmap[j+1] = temp;
				}
			}
		}
		String answer = "";
		for(int i = 0;i<index+1;i++){
			answer += hashmap[i].charAt(0);
		}
		System.out.println(answer);
	}
}