package Java.P3SearchAlgorithm;

import static java.lang.Math.round;

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
    }

    static int binarySearch(int[] arr, int target) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int middleIndex = (startIndex + endIndex) / 2;
        while (middleIndex >= 0 && middleIndex < arr.length) {
            if (arr[middleIndex] < target) {
                startIndex = middleIndex + 1;
            }
            if (arr[middleIndex] > target) {
                endIndex = middleIndex - 1;
            }
            if (arr[middleIndex] == target) {
                return middleIndex;
            }
            middleIndex = (startIndex + endIndex) / 2;
        }
        return -1;
    }
}
