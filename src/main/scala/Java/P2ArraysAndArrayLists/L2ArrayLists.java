package Java.P2ArraysAndArrayLists;

import java.util.ArrayList;
import java.util.Arrays;

public class L2ArrayLists {

    public static void main(String[] args) {
        // syntax
        // We cannot use primitives as generics
        // We need to provide wrapper objects
        ArrayList<Integer> list = new ArrayList<>(5);
        // the ArrayList has an overridden `toString()` method
        // it is called internally, we will look into it in OOP 
        System.out.println(list);

        // the `add(int n)` method returns a boolean
        list.add(12);
        System.out.println(list.add(13));

        // add multiple elements to the ArrayList
        // We initialize an Array with Integer objects
        // Convert that to a list because the `addAll` method 
        // requires a collection and won't work with [] type
        // Interestingly, Arrays are not part of the Java Collection
        // framework, they are built-in language feature, part of core Java
        Integer[] otherList = new Integer[]{1, 2, 3, 4, 5};
        list.addAll(Arrays.asList(otherList));
        System.out.println(list);
        // We can also alternatively use
        list.addAll(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1));
        System.out.println(list);

        // Multidimensional ArrayList
        // Initializing an empty ArrayList
        ArrayList<ArrayList<Integer>> arr2D = new ArrayList<>();
        // Adding 5 ArrayList objects in it
        for (int i = 0; i < 5; i++) {
            arr2D.add(new ArrayList<>());
        }
        // Adding 5 Integer objects to each ArrayList
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr2D.get(i).add((i + 1) * (j + 1));
            }
        }
        System.out.println(arr2D);

        // swap method
        int[] sampleArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(sampleArr));
        swapIndex(sampleArr, 3, 6);
        System.out.println(Arrays.toString(sampleArr));
        swapIndex(sampleArr, 2, 7);
        System.out.println(Arrays.toString(sampleArr));

        // max method
        System.out.println(max(sampleArr));

        // reverse method
        reverse(sampleArr);
        System.out.println(Arrays.toString(sampleArr));
    }

    static void swapIndex(int[] arr, int index1, int index2) {
        int temp;
        temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    static int max(int[] arr) {
        int max = -1;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            swapIndex(arr, start, end);
            start++;
            end--;
        }
    }
}
