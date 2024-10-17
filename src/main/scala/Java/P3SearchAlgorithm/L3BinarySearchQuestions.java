package Java.P3SearchAlgorithm;

public class L3BinarySearchQuestions {

    public static void main(String[] args) {

        // Ceiling of the target - smallest element of the array which
        // is greater than or equal to the target number
        // if ceiling target is 20, answer is index of 21 ie 8
        int[] q1Input = {-3, 2, 4, 7, 10, 13, 16, 18, 21, 28};

        // Find ceil
        System.out.println(ceilOrFloorBS(q1Input, 24)); // 9
        System.out.println(ceilOrFloorBS(q1Input, 15)); // 6
        System.out.println(ceilOrFloorBS(q1Input, -1)); // 1
        System.out.println(ceilOrFloorBS(q1Input, 12)); // 5
        System.out.println(ceilOrFloorBS(q1Input, 28)); // 9
        System.out.println(ceilOrFloorBS(q1Input, -3)); // 0
        System.out.println(ceilOrFloorBS(q1Input, 3)); // 2
        System.out.println(ceilOrFloorBS(q1Input, 30)); // -1
        System.out.println(ceilOrFloorBS(q1Input, -5)); // -1

        // Find floor
        System.out.println(ceilOrFloorBS(q1Input, 24, false)); // 8
        System.out.println(ceilOrFloorBS(q1Input, 15, false)); // 5
        System.out.println(ceilOrFloorBS(q1Input, -1, false)); // 0
        System.out.println(ceilOrFloorBS(q1Input, 12, false)); // 4
        System.out.println(ceilOrFloorBS(q1Input, 28, false)); // 9
        System.out.println(ceilOrFloorBS(q1Input, -3, false)); // 0
        System.out.println(ceilOrFloorBS(q1Input, 3, false)); // 1
        System.out.println(ceilOrFloorBS(q1Input, 30, false)); // -1
        System.out.println(ceilOrFloorBS(q1Input, -5, false)); // -1
    }

    // Instead of having default parameters we use function overloading
    // https://stackoverflow.com/questions/997482/does-java-support-default-parameter-values
    static int ceilOrFloorBS(int[] arr, int target) {
        return ceilOrFloorBS(arr, target, true);
    }

    static int ceilOrFloorBS(int[] arr, int target, boolean isCeil) {
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
        if (inBetween(0, arr.length - 1, start, end)) {
            return isCeil ? start : end;
        } else {
            return -1;
        }
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
