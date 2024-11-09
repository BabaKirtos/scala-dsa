package Java.P3SearchAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class L3BinarySearchQuestions {

    public static void main(String[] args) {

        int[] q1Input = {-3, 2, 4, 7, 10, 13, 16, 18, 21, 28};
        // Create a target array for testing
        int[] simpleTarget = prependAppendArray(new int[]{-1, -2}, q1Input, new int[]{30, 33});
        // test using our custom int test function
        int[] simpleResult = algoTestInt(q1Input, simpleTarget, L3BinarySearchQuestions::simpleBS);
        // Print the result array
        // [-1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1]
        System.out.println(Arrays.toString(simpleResult));

        // Q1:
        // Ceiling of the target - smallest element of the array which
        // is greater than or equal to the target number
        // if ceiling target is 20, answer is index of 21 i.e., 8
        // Find the ceil
        // Create a target array for testing
        int[] q1Target = {24, 15, -1, 12, 28, -3, 3, 30, -5};
        // Get the result array
        int[] q1CeilResult = algoTestInt(q1Input, q1Target, L3BinarySearchQuestions::ceilIntBS);
        // Print result array
        // [9, 6, 1, 5, 9, 0, 2, -1, 0]
        System.out.println(Arrays.toString(q1CeilResult));

        // Find the floor
        // Get the result array
        int[] q1FloorResult = algoTestInt(q1Input, q1Target, L3BinarySearchQuestions::floorIntBS);
        // Print result array
        // [8, 5, 0, 4, 9, 0, 1, 9, -1]
        System.out.println(Arrays.toString(q1FloorResult));

        // Testing absolute ceil and floor
        // Get the result array
        int[] q1AbsoluteCeilResult = algoTestInt(q1Input, q1Target, L3BinarySearchQuestions::absoluteCeilIntBS);
        // [9, 6, 1, 5, 10, 1, 2, -1, 0]
        System.out.println(Arrays.toString(q1AbsoluteCeilResult));
        // Get the result array
        int[] q1AbsoluteFloorResult = algoTestInt(q1Input, q1Target, L3BinarySearchQuestions::absoluteFloorIntBS);
        // [8, 5, 0, 4, 9, 0, 1, 9, -1]
        System.out.println(Arrays.toString(q1AbsoluteFloorResult));

        // Q2:
        // In an ascending sorted array of chars, return the smallest char,
        // which is larger than the target (ceil).
        // Note: The chars wrap around meaning
        // if target = 'z' and letters = ['a', 'b'], then the answer is 'a'
        char[] q2Input = {'a', 'c', 'e', 'f', 'i', 'm'};
        char[] q2Target = {'b', 'g', 'n', 'z'};
        // Test using our custom char test function
        char[] q2CeilResult = algoTestChar(q2Input, q2Target, L3BinarySearchQuestions::ceilCharBS);
        // [c, i, a, a]
        System.out.println(Arrays.toString(q2CeilResult));
        // Test using our custom char test function
        char[] q2FloorResult = algoTestChar(q2Input, q2Target, L3BinarySearchQuestions::floorCharBS);
        // [a, f, m, m]
        System.out.println(Arrays.toString(q2FloorResult));

        // Q3:
        // Absolute ceil, meaning if target is 'a' answer is 'c'
        char[] q3Input = {'a', 'c', 'e', 'f', 'i', 'm'};
        char[] q3Target = {'a', 'c', 'e', 'f', 'i', 'm', 'n', 'z'};
        char[] q3CeilResult = algoTestChar(q3Input, q3Target, L3BinarySearchQuestions::wrapCeilCharBS);
        // [c, e, f, i, m, a, a, a]
        System.out.println(Arrays.toString(q3CeilResult));
        // Absolute floor, meaning if target is 'a' answer is 'm'
        char[] q3FloorResult = algoTestChar(q3Input, q3Target, L3BinarySearchQuestions::wrapFloorCharBS);
        // [m, a, c, e, f, i, m, m]
        System.out.println(Arrays.toString(q3FloorResult));

        // Q4:
        // Find the position of the first and last repeated elements in a
        // sorted array, input = [5,5,5,7,7,7,7,8,8,9,10], target = 8, ans = [7,8]
        // return [-1, -1] if target is not found
        // We can do this -> ans = [floor + 1, ceil - 1]
        // This would mean running binary search twice
        // O(2log n) ~ O(log n)
        int[] q4Input = {2, 5, 5, 5, 7, 7, 7, 7, 8, 8, 9, 10, 12};
        int[] q4Target = prependAppendArray(new int[]{3, 6}, getUniqueElementsIntArray(q4Input), new int[]{11, 13});
        int[][] q4Result = algoTestIntArray(q4Input, q4Target, L3BinarySearchQuestions::firstLastOccurrence);
        System.out.println(Arrays.deepToString(q4Result));
    }

    // To test our algorithms, we will use functional interfaces
    // TODO: Convert to generic functional interface

    // int interface
    @FunctionalInterface
    interface IntArrayToIntFunction {
        int apply(int[] arr, int target);
    }

    // char interface
    @FunctionalInterface
    interface CharArrayToCharFunction {
        char apply(char[] arr, char target);
    }

    // int array interface
    @FunctionalInterface
    interface IntArrayToIntArrayFunction {
        int[] apply(int[] arr, int target);
    }

    // To test our algorithms we create a method which takes an Array of the
    // target elements, calls the algo function on each element of the target
    // array and returns the result array
    static int[] algoTestInt(int[] inputArr, int[] targetArr, IntArrayToIntFunction function) {
        int[] result = new int[targetArr.length];
        for (int i = 0; i < targetArr.length; i++) {
            result[i] = function.apply(inputArr, targetArr[i]);
        }
        return result;
    }

    static char[] algoTestChar(char[] inputArr, char[] targetArr, CharArrayToCharFunction function) {
        char[] result = new char[targetArr.length];
        for (int i = 0; i < targetArr.length; i++) {
            result[i] = function.apply(inputArr, targetArr[i]);
        }
        return result;
    }

    static int[][] algoTestIntArray(int[] inputArr, int[] targetArr, IntArrayToIntArrayFunction function) {
        int[][] result = new int[targetArr.length][2];
        for (int i = 0; i < targetArr.length; i++) {
            result[i] = function.apply(inputArr, targetArr[i]);
        }
        return result;
    }

    // the below function takes 2 int arrays, the starting array is prepended
    // to the target array, and the ending array is appended to the target array
    static int[] prependAppendArray(int[] starting, int[] target, int[] ending) {
        int totalLength = starting.length + target.length + ending.length;
        int[] result = new int[totalLength];
        System.arraycopy(starting, 0, result, 0, starting.length);
        System.arraycopy(target, 0, result, starting.length, target.length);
        System.arraycopy(ending, 0, result, starting.length + target.length, ending.length);
        return result;
    }

    static int simpleBS(int[] arr, int target) {
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

    // Instead of having default parameters, we use function overloading
    // https://stackoverflow.com/questions/997482/does-java-support-default-parameter-values
    static int ceilIntBS(int[] arr, int target) {
        return ceilOrFloorIntBS(arr, target, true);
    }

    static int floorIntBS(int[] arr, int target) {
        return ceilOrFloorIntBS(arr, target, false);
    }

    static int ceilOrFloorIntBS(int[] arr, int target, boolean isCeil) {
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
        if ((isCeil && target > arr[arr.length - 1]) || (!isCeil && target < arr[0])) {
            return -1;
        } else {
            return isCeil ? start : end;
        }
    }

    static int absoluteCeilIntBS(int[] arr, int target) {
        return absoluteCeilOrFloorIntBS(arr, target, true);
    }

    static int absoluteFloorIntBS(int[] arr, int target) {
        return absoluteCeilOrFloorIntBS(arr, target, false);
    }

    static int absoluteCeilOrFloorIntBS(int[] arr, int target, boolean isCeil) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (isCeil) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        if ((isCeil && target > arr[arr.length - 1]) || (!isCeil && target < arr[0])) {
            return -1;
        } else {
            return isCeil ? start : end;
        }
    }

    static int[] firstLastOccurrence(int[] arr, int target) {
        // [floor + 1, ceil - 1]
        int first = absoluteFloorIntBS(arr, target);
        int last = absoluteCeilIntBS(arr, target);
        if ((first + 1) - (last - 1) >= 1) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first + 1, last - 1};
        }
    }

    static char ceilCharBS(char[] in, char target) {
        return ceilOrFloorCharBS(in, target, true);
    }

    static char floorCharBS(char[] in, char target) {
        return ceilOrFloorCharBS(in, target, false);
    }

    static char ceilOrFloorCharBS(char[] in, char target, boolean isCeil) {
        // Handle wrap around logic
        if (target > in[in.length - 1] && isCeil) return in[0];
        if (target < in[0] && !isCeil) return in[in.length - 1];
        // Convert to int array and reuse ceiOrFloorBS method
        int[] arr = charToIntArray(in);
        int index = ceilOrFloorIntBS(arr, target, isCeil);
        return in[index];
    }

    static char wrapCeilCharBS(char[] in, char target) {
        return wrapCeilOrFloorCharBS(in, target, true);
    }

    static char wrapFloorCharBS(char[] in, char target) {
        return wrapCeilOrFloorCharBS(in, target, false);
    }

    static char wrapCeilOrFloorCharBS(char[] in, char target, boolean isCeil) {
        int start = 0;
        int end = in.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (isCeil) {
                if (target < in[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > in[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        // Return the appropriate character based on whether it's a ceil or floor search
        if (isCeil) {
            return (start < in.length) ? in[start] : in[0];
        } else {
            return (end >= 0) ? in[end] : in[in.length - 1];
        }
    }

    public static int[] charToIntArray(char[] input) {
        int[] temp = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            temp[i] = input[i];
        }
        return temp;
    }

    public static int[] getUniqueElementsIntArray(int[] sortedIntArray) {
        if (sortedIntArray.length == 0) {
            return new int[0];
        }
        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.add(sortedIntArray[0]);
        for (int i = 1; i < sortedIntArray.length; i++) {
            if (sortedIntArray[i] != sortedIntArray[i - 1]) {
                tempList.add(sortedIntArray[i]);
            }
        }
        int[] tempArray = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            tempArray[i] = tempList.get(i);
        }
        return tempArray;
    }

    public static boolean inBetween(int start, int end, int... targets) {
        for (int target : targets) {
            if ((target < start) || (target > end)) {
                return false;
            }
        }
        return true;
    }
}
