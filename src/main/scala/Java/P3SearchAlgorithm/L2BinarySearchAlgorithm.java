package Java.P3SearchAlgorithm;

import static Java.P2ArraysAndArrayLists.L2ArrayLists.immutableReverse;

public class L2BinarySearchAlgorithm {

    public static void main(String[] args) {

        // It works for sorted Arrays
        int[] input = {2, 4, 6, 9, 11, 13, 15, 17, 20, 25, 34, 39, 41};

        // In binary search we take the middle element of the sorted Array
        // For an Array with length 13 we take index 6
        // System.out.println(input[input.length / 2]);
        // If our target is 34 and the middle element value is 15
        // Then our target lies on the right hand side of the middle value
        // We again get the value of the middle element between index 7 to 12 ie 9
        // algo to find middle index = (start + end) / 2
        // System.out.println(input[(7 + 12) / 2]);
        // We get the value 25 at index 9
        // We again find the middle element - (10 + 12) / 2 = 11
        // System.out.println(input[(10 + 12) / 2]);
        // We get the value 39 at index 11
        // We again find the middle element - (10 + 10) / 2 = 20
        // We find our target, 34
        // System.out.println(input[(10 + 10) / 2]);
        // Take note that when target is greater, we add 1 to start before
        // finding the next middle index, and when it is less, we subtract
        // 1 from end before finding the next middle index
        System.out.println(binarySearch(input, 2)); // 0
        System.out.println(binarySearch(input, 4)); // 1
        System.out.println(binarySearch(input, 6)); // 2
        System.out.println(binarySearch(input, 9)); // 3
        System.out.println(binarySearch(input, 11)); // 4
        System.out.println(binarySearch(input, 13)); // 5
        System.out.println(binarySearch(input, 15)); // 6
        System.out.println(binarySearch(input, 17)); // 7
        System.out.println(binarySearch(input, 20)); // 8
        System.out.println(binarySearch(input, 25)); // 9
        System.out.println(binarySearch(input, 34)); // 10
        System.out.println(binarySearch(input, 39)); // 11
        System.out.println(binarySearch(input, 41)); // 12
        System.out.println(binarySearch(input, 99)); // -1
        System.out.println(binarySearch(input, -99));// -1

        // Test order agnostic binary search
        // Ascending
        System.out.println(orderAgnosticBinarySearch(input, 2)); // 0
        System.out.println(orderAgnosticBinarySearch(input, 4)); // 1
        System.out.println(orderAgnosticBinarySearch(input, 6)); // 2
        System.out.println(orderAgnosticBinarySearch(input, 9)); // 3
        System.out.println(orderAgnosticBinarySearch(input, 11)); // 4
        System.out.println(orderAgnosticBinarySearch(input, 13)); // 5
        System.out.println(orderAgnosticBinarySearch(input, 15)); // 6
        System.out.println(orderAgnosticBinarySearch(input, 17)); // 7
        System.out.println(orderAgnosticBinarySearch(input, 20)); // 8
        System.out.println(orderAgnosticBinarySearch(input, 25)); // 9
        System.out.println(orderAgnosticBinarySearch(input, 34)); // 10
        System.out.println(orderAgnosticBinarySearch(input, 39)); // 11
        System.out.println(orderAgnosticBinarySearch(input, 41)); // 12
        System.out.println(orderAgnosticBinarySearch(input, 99)); // -1
        System.out.println(orderAgnosticBinarySearch(input, -99));// -1
        
        // Descending
        int[] reversedInput = immutableReverse(input);
        System.out.println(orderAgnosticBinarySearch(reversedInput, 2)); // 0
        System.out.println(orderAgnosticBinarySearch(reversedInput, 4)); // 1
        System.out.println(orderAgnosticBinarySearch(reversedInput, 6)); // 2
        System.out.println(orderAgnosticBinarySearch(reversedInput, 9)); // 3
        System.out.println(orderAgnosticBinarySearch(reversedInput, 11)); // 4
        System.out.println(orderAgnosticBinarySearch(reversedInput, 13)); // 5
        System.out.println(orderAgnosticBinarySearch(reversedInput, 15)); // 6
        System.out.println(orderAgnosticBinarySearch(reversedInput, 17)); // 7
        System.out.println(orderAgnosticBinarySearch(reversedInput, 20)); // 8
        System.out.println(orderAgnosticBinarySearch(reversedInput, 25)); // 9
        System.out.println(orderAgnosticBinarySearch(reversedInput, 34)); // 10
        System.out.println(orderAgnosticBinarySearch(reversedInput, 39)); // 11
        System.out.println(orderAgnosticBinarySearch(reversedInput, 41)); // 12
        System.out.println(orderAgnosticBinarySearch(reversedInput, 99)); // -1
        System.out.println(orderAgnosticBinarySearch(reversedInput, -99));// -1
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // Order agnostic binary search algorithm
    public static int orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            // use ternary operator to check order and apply condition
            if (isAsc ? target > arr[mid] : target < arr[mid]) {
                start = mid + 1;
            } else if (isAsc ? target < arr[mid] : target > arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
