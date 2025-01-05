package Java.P4SortingAlgorithms;

import java.util.Arrays;

import static Java.P2ArraysAndArrayLists.L2ArrayLists.swapIndex;

public class L4CyclicSortAlgorithm {
    
    public static void main(String[] args) {
        
        // When given array contains numbers in range 1 to N, use cyclic sort
        // The above point is very important
        // Most MAANG companies ask ques for a cyclic sort pattern
        // Sample questions are like, given numbers 1 to N find:
        // Missing number, duplicate number, etc.
        // We know that for a sorted array:
        // index = value - 1
        // Cyclic sort uses only one pass
        // Note that no numbers are missing between 1 to N
        int[] input = {3, 5, 2, 1, 4};
        cyclicSort(input);
        System.out.println(Arrays.toString(input));
    }
    
    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            // find the correct index
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swapIndex(arr, i, correct);
            } else {
                i++;
            }
        }
    }
}
