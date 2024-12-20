package Java.P4SortingAlgorithms;

import java.util.Arrays;

import static Java.P2ArraysAndArrayLists.L2ArrayLists.swapIndex;

public class L2SelectionSortAlgorithm {

    public static void main(String[] args) {

        // Pick the max element and put it in the right index
        // [4, 5, 1, 2, 3]
        // 5 will be swapped with 3 i.e.,
        // index 1 will be swapped with index 4
        // [4, 3, 1, 2, 5]
        // repeat the steps except for last position
        // [2, 3, 1, 4, 5]
        // [2, 1, 3, 4, 5]
        // [1, 2, 3, 4, 5]

        int[] input = {3, 1, 8, 5, 4, 0, 2, 9, 7, 6};
        selectionSort(input);
        System.out.println(Arrays.toString(input));
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxIndex = findMaxIndex(Arrays.copyOfRange(arr, 0, arr.length - i));
            swapIndex(arr, maxIndex, arr.length - 1 - i);
        }
    }

    static int findMaxIndex(int[] arr) {
        if (arr.length > 0) {
            int maxIndex = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            return maxIndex;
        } else {
            return -1;
        }
    }
}
