import java.util.*;

public class Mode{
	@SuppressWarnings("resource")
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("How many numbers do you want to find the Mode of? ");
		int n = scan.nextInt();
		int array[] = new int[n];
		System.out.println("Enter " + n + " numbers: ");
		for(int i = 0;i<n;i++){
			array[i] = scan.nextInt();
		}
		System.out.println("The Mode if these numbers is: " + modeFinder(array));
	}

	public static int modeFinder(int array[]){
		Arrays.sort(array);
		int count = 0;
		int current = array[0];
		int maxCount = 0;
		int mode = array[0];
		for(int i = 0;i<array.length;i++){
			if(current == array[i]){
				count++;
			}
			else{
				if(count>maxCount){
					maxCount = count;
					mode = current;
				}
				count = 0;
				current = array[i];
				i--;
			}
		}
		if(count>maxCount){
					maxCount = count;
					mode = current;
				}
		return mode;
	}
}