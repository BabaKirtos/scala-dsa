package Java.P3SearchAlgorithm;

import java.util.Arrays;

public class L1LinearSearchAlgorithm {

    public static void main(String[] args) {

        // Find if an element exits in an Array, return its index
        int[] arr = {12, 45, 23, 65, 76, 99, 87, 54};
        System.out.println(linearSearchInt(arr, 43));
        System.out.println(linearSearchInt(arr, 87));

        // Search in Strings
        String name = "Abhishek";
        System.out.println(linearSearchString(name, 'a'));
        System.out.println(linearSearchString(name, 'k'));

        // Search in range
        System.out.println(linearSearchIntInRange(arr, 12, 2, arr.length));
        System.out.println(linearSearchIntInRange(arr, 99, 3, arr.length - 1));

        // Search min number
        System.out.println(linearSearchIntMin(arr));

        // Search 2D array
        int[][] arr2D = {
                {1, 2},
                {3, 4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(linearSearchInt2DArray(arr2D, 6)));
        System.out.println(Arrays.toString(linearSearchInt2DArray(arr2D, 10)));

        // Find even number of digits
        int[] input = {1234, 425, 26743, 63335, 76, 5499, 687, 4};
        System.out.println(evenDigits(input));

        // max sum of 2D Array
        System.out.println(Arrays.toString(maxSum2DArray(arr2D)));
    }

    // linear search will have O(n) time complexity, where n is the size of Array
    static int linearSearchInt(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int linearSearchIntInRange(int[] arr, int target, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int linearSearchIntMin(int[] arr) {
        int min = -1;
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }

    static int evenDigits(int[] arr) {
        int result = 0;
        for (int j : arr) {
            if (getDigits(j) % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    static int getDigits(int input) {
        // int digits = 0;
        // while (input > 0) {
        //     digits++;
        //     input /= 10;
        // }
        // return digits;

        // optimized solution, will be covered later
        return (int) (Math.log10(input) + 1);
    }

    static int[] linearSearchInt2DArray(int[][] arr2D, int target) {
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                if (arr2D[i][j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static int[] maxSum2DArray(int[][] arr2D) {
        int row = -1;
        int totalSum = -1;
        for (int i = 0; i < arr2D.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < arr2D[i].length; j++) {
                rowSum += arr2D[i][j];
            }
            if (rowSum > totalSum) {
                row = i + 1;
                totalSum = rowSum;
            }
        }
        return new int[]{row, totalSum};
    }

    static int linearSearchString(String str, char target) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                return i;
            }
        }
        return -1;
    }
}
