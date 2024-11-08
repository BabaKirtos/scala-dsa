package JavaPlayground;

public class RefactorBSQ {

    public static void main(String[] args) {

        // Q1:
        // Ceiling of the target - smallest element of the array which
        // is greater than or equal to the target number
        // if ceiling target is 20, answer is index of 21 ie 8
        int[] q1Input = {-3, 2, 4, 7, 10, 13, 16, 18, 21, 28};

        // Simple BS
        System.out.println(simpleBS(q1Input, -1)); // -1
        System.out.println(simpleBS(q1Input, -2)); // -1
        System.out.println(simpleBS(q1Input, -3)); // 0
        System.out.println(simpleBS(q1Input, 2)); // 1
        System.out.println(simpleBS(q1Input, 4)); // 2
        System.out.println(simpleBS(q1Input, 7)); // 3
        System.out.println(simpleBS(q1Input, 10)); // 4
        System.out.println(simpleBS(q1Input, 11)); // -1
        System.out.println(simpleBS(q1Input, 13)); // 5
        System.out.println(simpleBS(q1Input, 16)); // 6
        System.out.println(simpleBS(q1Input, 18)); // 7
        System.out.println(simpleBS(q1Input, 21)); // 8
        System.out.println(simpleBS(q1Input, 28)); // 9
        System.out.println(simpleBS(q1Input, 30)); // -1
        System.out.println(simpleBS(q1Input, 33)); // -1
        System.out.println();

        // Find ceil
        System.out.println(ceilOrFloorBS(q1Input, 24, true)); // 9
        System.out.println(ceilOrFloorBS(q1Input, 15, true)); // 6
        System.out.println(ceilOrFloorBS(q1Input, -1, true)); // 1
        System.out.println(ceilOrFloorBS(q1Input, 12, true)); // 5
        System.out.println(ceilOrFloorBS(q1Input, 28, true)); // 9
        System.out.println(ceilOrFloorBS(q1Input, -3, true)); // 0
        System.out.println(ceilOrFloorBS(q1Input, 3, true)); // 2
        System.out.println(ceilOrFloorBS(q1Input, 30, true)); // -1
        System.out.println(ceilOrFloorBS(q1Input, -5, true)); // 0
        System.out.println();

        // Find floor
        System.out.println(ceilOrFloorBS(q1Input, 24, false)); // 8
        System.out.println(ceilOrFloorBS(q1Input, 15, false)); // 5
        System.out.println(ceilOrFloorBS(q1Input, -1, false)); // 0
        System.out.println(ceilOrFloorBS(q1Input, 12, false)); // 4
        System.out.println(ceilOrFloorBS(q1Input, 28, false)); // 9
        System.out.println(ceilOrFloorBS(q1Input, -3, false)); // 0
        System.out.println(ceilOrFloorBS(q1Input, 3, false)); // 1
        System.out.println(ceilOrFloorBS(q1Input, 30, false)); // 9
        System.out.println(ceilOrFloorBS(q1Input, -5, false)); // -1
        System.out.println();

        // Q2:
        // In an ascending sorted array of chars, return the smallest char,
        // which is larger than the target (ciel). Note: The chars wrap around meaning
        // if target = 'z' and letters = ['a', 'b'], then the answer is 'a'
        char[] input = {'a', 'c', 'e', 'f', 'i', 'm'};

        // test ceil and floor char
        System.out.println(ceilOrFloorCharBS(input, 'b', true)); // c
        System.out.println(ceilOrFloorCharBS(input, 'b', false)); // a
        System.out.println(ceilOrFloorCharBS(input, 'g', true)); // i
        System.out.println(ceilOrFloorCharBS(input, 'g', false)); // f
        System.out.println(ceilOrFloorCharBS(input, 'n', true)); // a
        System.out.println(ceilOrFloorCharBS(input, 'n', false)); // m
        System.out.println(ceilOrFloorCharBS(input, 'z', true)); // a
        System.out.println(ceilOrFloorCharBS(input, 'z', false)); // m
        System.out.println();

        // Absolute ceil, meaning if target is 'a' answer is 'c'
        System.out.println(absoluteCeilOrFloorCharBS(input, 'a', true)); // c
        System.out.println(absoluteCeilOrFloorCharBS(input, 'c', true)); // e
        System.out.println(absoluteCeilOrFloorCharBS(input, 'e', true)); // f
        System.out.println(absoluteCeilOrFloorCharBS(input, 'f', true)); // i
        System.out.println(absoluteCeilOrFloorCharBS(input, 'i', true)); // m
        System.out.println(absoluteCeilOrFloorCharBS(input, 'm', true)); // a
        System.out.println(absoluteCeilOrFloorCharBS(input, 'n', true)); // a
        System.out.println(absoluteCeilOrFloorCharBS(input, 'z', true)); // a
        System.out.println();

        // Absolute floor, meaning if target is 'a' answer is 'm'
        System.out.println(absoluteCeilOrFloorCharBS(input, 'a', false)); // m
        System.out.println(absoluteCeilOrFloorCharBS(input, 'c', false)); // a
        System.out.println(absoluteCeilOrFloorCharBS(input, 'e', false)); // c
        System.out.println(absoluteCeilOrFloorCharBS(input, 'f', false)); // e
        System.out.println(absoluteCeilOrFloorCharBS(input, 'i', false)); // f
        System.out.println(absoluteCeilOrFloorCharBS(input, 'm', false)); // i
        System.out.println(absoluteCeilOrFloorCharBS(input, 'n', false)); // m
        System.out.println(absoluteCeilOrFloorCharBS(input, 'z', false)); // m
        System.out.println();

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
        if ((isCeil && target > arr[arr.length - 1]) || (!isCeil && target < arr[0])) {
            return -1;
        } else {
            return isCeil ? start : end;
        }
    }

    static char ceilOrFloorCharBS(char[] in, char target, boolean isCeil) {
        // Handle wrap around logic
        if (target > in[in.length - 1] && isCeil) return in[0];
        if (target < in[0] && !isCeil) return in[in.length - 1];
        // Convert to int array and reuse ceiOrFloorBS method
        int[] arr = charToIntArray(in);
        int index = ceilOrFloorBS(arr, target, isCeil);
        return in[index];
    }

    static char absoluteCeilOrFloorCharBS(char[] in, char target, boolean isCeil) {
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

    public static boolean inBetween(int start, int end, int... targets) {
        for (int target : targets) {
            if ((target < start) || (target > end)) {
                return false;
            }
        }
        return true;
    }
}


