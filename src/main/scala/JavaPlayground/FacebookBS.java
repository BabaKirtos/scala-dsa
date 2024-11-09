package JavaPlayground;

import java.util.Arrays;

public class FacebookBS {

    public static void main(String[] args) {
        // Q4:
        // Find the position of the first and last repeated elements in a
        // sorted array, input = [2, 5, 5, 5, 7, 7, 7, 7, 8, 8, 9, 10, 12], 
        // target = 8, ans = [8,9]
        // target = 11, ans = [-1, -1]
        // return [-1, -1] if target is not found
        // We can do this -> ans = [floor + 1, ceil - 1]
        // This would mean running binary search twice
        // O(2log n) ~ O(log n)
        int[] input = {2, 5, 5, 5, 7, 7, 7, 7, 8, 8, 9, 10, 12};
        System.out.println(Arrays.toString(facebookBS(input, 10)));
    }

    public static int firstOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        // first occurrence index
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (target == arr[mid] || target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        // last occurrence index
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (target == arr[mid] || target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    public static int[] facebookBS(int[] arr, int target) {
        int[] temp = new int[2];
        temp[0] = firstOccurrence(arr, target);
        temp[1] = lastOccurrence(arr, target);
        return temp[0] - temp[1] == 1 ? new int[]{-1, -1} : temp;
    }
}
