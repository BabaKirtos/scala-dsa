package Java.P4SortingAlgorithms;

public class L3InsertionSortAlgorithm {

    public static void main(String[] args) {
        
        // For every index:
        // Put that index at the correct index of LHS
        // After i = 0, index 0 and index 1 will be sorted
        // After i = 1, index 0, 1 and 2 will be sorted
        // [5, 3, 4, 1, 2] -> [3, 5, 4, 1, 2], i = 0
        // [3, 5, 4, 1, 2] -> [3, 4, 5, 1, 2], i = 1
        // [3, 4, 5, 1, 2] -> [1, 3, 4, 5, 2], i = 2
        // [1, 3, 4, 5, 2] -> [1, 2, 3, 4, 5], i = 3
        // We start from the left 2 index and keep moving right

        int[] input = {3, 1, 8, 5, 4, 0, 2, 9, 7, 6};
        
    }
}
