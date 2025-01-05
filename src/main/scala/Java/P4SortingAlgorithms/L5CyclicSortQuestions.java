package Java.P4SortingAlgorithms;

import static Java.P2ArraysAndArrayLists.L2ArrayLists.swapIndex;

public class L5CyclicSortQuestions {

    public static void main(String[] args) {

        // Find the missing number if numbers are in range 0 to N
        // Amazon question, space complexity = O(1), time complexity = O(N)
        int[] input = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(findMissingNumber(input));
        int[] newInput = {3, 4, 2, 1, 0};
        System.out.println(findMissingNumber(newInput));
    }

    static int findMissingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                swapIndex(arr, i, correct);
            } else {
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j) {
                return j;
            }
        }
        return arr.length;
    }
}
