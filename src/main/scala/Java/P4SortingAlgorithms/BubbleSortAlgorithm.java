package Java.P4SortingAlgorithms;

import java.util.Arrays;

public class BubbleSortAlgorithm {

    public static void main(String[] args) {

        // compare elements and swap in every step
        // 1st pass:
        // the greatest element will be in the last position
        // [3, 1, 5, 4, 2] -> [1, 3, 5, 4, 2]
        // [1, 3, 5, 4, 2] -> [1, 3, 4, 5, 2]
        // [1, 3, 4, 5, 2] -> [1, 3, 4, 2, 5]
        // 2nd pass:
        // We ignore the comparison of the last element
        // the second-greatest element will be in the second-last position
        // [1, 3, 4, 2, 5] -> [1, 3, 2, 4, 5]
        // 3rd pass:
        // We ignore the comparison of the last two elements
        // all elements are now sorted
        // [1, 3, 2, 4, 5] -> [1, 2, 3, 4, 5]
        // The space complexity is constant as we are not creating
        // any clone or copies of the original array, O(1)
        // Also known as in-place sorting algorithm
        // The time complexity, best case -> O(N)
        // worst case -> O(N^2)
        int[] input = {3, 1, 8, 5, 4, 0, 2, 9, 7, 6};
        SimpleBubbleSortAsc(input);
        System.out.println(Arrays.toString(input));
        // The below will have a time complexity of O(N^2)
        // as the array is sorted in ascending order
        SimpleBubbleSortDesc(input);
        System.out.println(Arrays.toString(input));
        // Debug to check that the external loop only
        // runs once if no swapping takes place for i = 0
        SimpleBubbleSortDesc(input);
    }

    static void SimpleBubbleSortAsc(int[] arr) {
        SimpleBubbleSort(arr, true);
    }

    static void SimpleBubbleSortDesc(int[] arr) {
        SimpleBubbleSort(arr, false);
    }

    static void SimpleBubbleSort(int[] arr, boolean isAsc) {
        // if no swaps occur in the internal loop for i = 0
        // we will break as the array is already sorted
        boolean noSwaps = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (isAsc ? arr[j - 1] > arr[j] : arr[j - 1] < arr[j]) {
                    noSwaps = false;
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (noSwaps) {
                break;
            }
        }
    }
}
