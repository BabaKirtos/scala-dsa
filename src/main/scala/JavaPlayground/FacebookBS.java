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
        // O(2log n) ~ O(log n)
        int[] input = {2, 5, 5, 5, 7, 7, 7, 7, 8, 8, 9, 10, 12};
        System.out.println(Arrays.toString(facebookBS(input, 7)));
    }

    public static int findOccurrenceIndex(int[] arr, int target, boolean isFirst) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                // save the mid-value
                ans = mid;
                // force to check left or right
                // till condition is violated
                if (isFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

    public static int[] facebookBS(int[] arr, int target) {
        int[] temp = new int[2];
        temp[0] = findOccurrenceIndex(arr, target, true);
        temp[1] = findOccurrenceIndex(arr, target, false);
        return temp[0] - temp[1] == 1 ? new int[]{-1, -1} : temp;
    }
}
