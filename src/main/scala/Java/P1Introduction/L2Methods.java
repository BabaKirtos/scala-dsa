package Java.P1Introduction;

import java.util.Arrays;
import java.util.Scanner;

public class L2Methods {

    public static void main(String[] args) {

        // Q: Take input of 2 numbers and prints the sum as output
        // To avoid initializing Scanner instance everytime
        Scanner in = new Scanner(System.in);
        System.out.println("The sum is: " + sum(in));

        // System.out.print("Enter your name: ");
        // String name = in.next();
        String name = "Abhishek";
        System.out.println(greet(name));

        // This is not going to work!
        // No pass by reference in Java!
        // Only pass by value in Java!
        int n1 = 5, n2 = 7;
        swap(n1, n2);
        System.out.println(n1 + " " + n2);

        // Let's see if we can change an Array
        // The below will work!
        // The copy of arr is passed which itself is a reference
        // Therefore the reference of the object is passed
        // But it is still call by value as we are passing a copy of arr
        // Reassigning a new array in the called function will not change
        // the original reference arr, but you can modify its content because
        // they both are pointing to the same Array objects
        int[] arr = {1, 3, 5, 8, 6, 4};
        System.out.println("arr -> " + Arrays.toString(arr));
        System.out.println("arr hashCode -> " + Arrays.hashCode(arr));
        System.out.println("arr identity hashCode -> " + System.identityHashCode(arr));
        change(arr);
        System.out.println("Modified arr -> " + Arrays.toString(arr));
        // It was expected that the below hashCode would not change, but it does
        // This is because the Array's hashCode method is based on the contents of the object
        // If the contents are modified, the hashCode changes
        // To check the reference hashCode we need to use System.identityHashCode() method
        System.out.println("arr hashCode (not the same as before) -> " + Arrays.hashCode(arr));
        System.out.println("arr identity hashCode (same as before) -> " + System.identityHashCode(arr));
    }

    // methods -> access modifier, return type name() {
    // body
    // return statement
    // }
    static int sum(Scanner in) {
        // Same instance of Scanner is reused
        System.out.println(in.hashCode());
        // Interestingly you cannot print/access the uninitialized variables
        int num1 = 6, num2 = 5, sum;
        // System.out.print("Enter the 1st number: ");
        // num1 = in.nextInt();
        // System.out.print("Enter the 2nd number: ");
        // num2 = in.nextInt();
        sum = num1 + num2;
        return sum;
    }

    static String greet(String name) {
        return "Hi! " + name;
    }

    static void swap(int n1, int n2) {
        int temp = n1;
        n1 = n2;
        n2 = temp;
    }

    static void change(int[] nums) {
        System.out.println("nums hashCode (same as arr) - > " + Arrays.hashCode(nums));
        System.out.println("nums identity hashCode (same as arr) - > " + System.identityHashCode(nums));
        nums[0] = 99;
        // reassigning nums to a new array would not affect arr
        nums = new int[]{1, 2, 3, 4, 5};
        // It will have a new hashCode but arr would still have the older one
        System.out.println("new nums -> " + Arrays.toString(nums));
        System.out.println("reassigned nums hashCode -> " + Arrays.hashCode(nums));
        System.out.println("reassigned nums identity hashCode -> " + System.identityHashCode(nums));
    }
}
