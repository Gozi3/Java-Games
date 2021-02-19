public class pseudoCode {
	public static void main(String args[]) {
		int[] data = { 12, 223, 232, 434, 1433, 0, -34, 14, 43, 544 };
		int smallest = data[0];

		for (int i = 0; i < data.length; i++) {
			if (data[i] < smallest) {
				smallest = data[i];
			}
		}
	}
}
/*
 * 1. Create an array (data) 2. Create a variable (smallest) that stores the
 * smallest number and another one that stores its position in the array. 3.
 * Loop through the array (linearly). 4. If the number in the array at the
 * position i is smaller than smallest, store it as the new smallest and store
 * its position as the new indexOfSmallest.
 */