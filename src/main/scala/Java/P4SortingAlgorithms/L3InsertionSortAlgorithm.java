package Java.P4SortingAlgorithms;

import java.util.Arrays;

import static Java.P2ArraysAndArrayLists.L2ArrayLists.swapIndex;

public class L3InsertionSortAlgorithm {

    public static void main(String[] args) {
        
        // For every index:
        // Put that index at the correct index of LHS
        // After i = 0, index 0 and index 1 will be sorted
        // After i = 1, index 0, 1 and 2 will be sorted
        // [5, 3, 4, 1, 2] -> [3, 5, 4, 1, 2], i = 0
        // [3, 5, 4, 1, 2] -> [3, 4, 5, 1, 2], i = 1
        // [3, 4, 5, 1, 2] -> [1, 3, 4, 5, 2], i = 2
        // [1, 3, 4, 5, 2] -> [1, 2, 3, 4, 5], i = 3
        // We start from the left 2 index and keep moving right
        // Once we find that the LHS element is sorted, we break
        // When i = 0, j = i + 1 = 1, 1st pass, we sort index 0 and 1
        // When i = 1, j = 2, 2nd pass, we sort index 0, 1 and 2
        // So i will go from 0 to n - 2
        // j will keep comparing to its left, and swap if left element is greater
        // If the left element is not greater, then we break
        // worst case complexity = O(N^2)
        // best case complexity = O(N)
        // We use insertion sort over bubble sort because
        // number of steps are reduced if array is sorted
        // number of swaps are reduced
        // it's stable and used for smaller values of N
        // works well on partially sorted data

        int[] input = {3, 1, 8, 5, 4, 0, 2, 9, 7, 6};
        insertionSort(input);
        System.out.println(Arrays.toString(input));
    }
    
    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swapIndex(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
}
