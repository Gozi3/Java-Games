import java.util.Arrays;

public class mergeSort {

    public static void main(String[] args) {
        int array[] = {9,0,7,8,1,6,2,3,5,4};
        System.out.println("Before: " + Arrays.toString(array));
        mergeSorter(array);
        System.out.println("After: " + Arrays.toString(array));
    }

    public static void mergeSorter(int[] inputArray) {
        int size = inputArray.length;//size of the array
        if (size < 2)//if the array is 1 its already sorted
            return;
        int mid = size / 2;//gets the halfway point to split the array in half
        int leftSize = mid;//size of the left array
        int rightSize = size - mid;//size of the right array
        int[] left = new int[leftSize];//creates the left array
        int[] right = new int[rightSize];//creates the right array
        for (int i = 0; i < mid; i++) {//fills the left array with the values of the left side of the array
            left[i] = inputArray[i];

        }
        for (int i = mid; i < size; i++) {//fills the right array with the values of the right side of the array
            right[i - mid] = inputArray[i];
        }
        
        mergeSorter(left);//repeatedly divides the left array into smaller halves and sorts it              
        mergeSorter(right);//repeatedly divides the right array into smaller halves and sorts it
        merge(left, right, inputArray);//combines the sorted halves into the original array

        //gives a display of what is ACTUALLY going on
        System.out.println("mergeSort (left): " + Arrays.toString(left));
        System.out.println("mergeSort (right): " + Arrays.toString(right));  
        System.out.println("inputArray: " + Arrays.toString(inputArray));
    }

    public static void merge(int[] left, int[] right, int[] array) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0;//leftIndex
        int j = 0;//rightIndex
        int k = 0;//tempIndex
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
                k++;
            } else {
                array[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < leftSize) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}