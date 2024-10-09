package Java.P3SearchAlgorithm;

import static java.lang.Math.round;

public class L2BinarySearchAlgorithm {

    public static void main(String[] args) {

        // It works for sorted Arrays
        int[] input = {2, 4, 6, 9, 11, 13, 15, 17, 20, 25, 34, 39, 41};

        // In binary search we take the middle element of the sorted Array
        // For an Array with length 13 we take index 6
        System.out.println(input[input.length / 2]);
        // If our target is 34 and the middle element value is 15
        // Then our target lies on the right hand side of the middle value
        // We again get the value of the middle element between index 6 to 12 ie 9
        // algo to find middle element = (start + end) / 2
        System.out.println(input[(6 + 12) / 2]);
        // We get the value 25 at index 8
        // We again find the middle element - (8 + 12) / 2 = 10
        // We find our target
        System.out.println(input[(8 + 12) / 2]);
        System.out.println(binarySearch(input, 34));
        System.out.println(binarySearch(input, 2));
        System.out.println(binarySearch(input, 41));
        System.out.println(binarySearch(input, 99));
    }
    
    static int binarySearch(int[] arr, int target) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int middleIndex = (startIndex + endIndex) / 2;
        while (middleIndex != 0 || middleIndex != arr.length - 1){
            if (arr[middleIndex] < target) {
                System.out.println(" < " + middleIndex + " " + arr[middleIndex]);
                startIndex = middleIndex;
            }
            if (arr[middleIndex] > target) {
                System.out.println(" > " + middleIndex + " " + arr[middleIndex]);
                endIndex = middleIndex;
            }
            if (arr[middleIndex] == target) {
                System.out.println(" = " + middleIndex + " " + arr[middleIndex]);
                return middleIndex;
            }
            System.out.println(" start " + startIndex + " end " + endIndex);
            middleIndex = (startIndex + endIndex) / 2;
            if (startIndex == arr.length - 2) {
                middleIndex += 1;
            }
        }
        return -1;
    }
}
