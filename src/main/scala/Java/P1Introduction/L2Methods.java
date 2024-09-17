package Java.P1Introduction;

import java.util.Arrays;
import java.util.Scanner;

public class L2Methods {

    // Declared but uninitialized Global variable
    // Its value can be modified
    static int x;

    // Declared and initialized final Global variable
    // Its value can be used but not modified
    final static float pi = 3.14f;

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
        // But it is still call by value as we are passing a copy of `arr`
        // Reassigning a new array in the called function will not change
        // the original reference `arr`, but you can modify its content because
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

        // Scoping
        // Basically `num1` defined in the below method is out of scope for current method
        // Below code line will throw an error
        // System.out.println(num1);
        // let's check using a variable before it is initialized
        // System.out.println(newVariable);
        // int newVariable = 5;
        // The above 2 code lines also do not work

        // Shadowing
        // look up, look out, static int x will be in current scope
        // Interestingly, you can print/access uninitialized x
        // It won't allow to do the same for uninitialized variables
        // in current scope, throws compilation error for the below 2 lines
        // int y;
        // System.out.println(y);
        System.out.println(x);
        x = 10;
        System.out.println(x);
        System.out.println(pi);
        // As pi is a final variable it cannot be modified
        // The below code will throw an error
        // pi = 2;
        // `x` will also be available to all static methods below
        // So `x` is acting like a global variable
        // Shadowing is a concept of creating a variable with the same name
        // in the local scope
        int x = 40;
        System.out.println(x);
        // So the global x will be shadowed(hidden) and not accessible anymore

        // Variable Length Arguments
        fun(1, 2, 3, 4, 5, 6, 7);
        // Interestingly, named parameters are not allowed in Java
        // Need to follow the sequence of parameters
        // fun(...v = arr, singleValue = 0);
        fun(0, arr);

        // Method Overloading
        // Arguments need to be different
        System.out.println("The sum is: " + sum(in));
        System.out.println("The sum is: " + sum(2, 3));
        System.out.println("The sum is: " + sum(5, 4));

        // Questions
        // If a number is prime
        System.out.println(isPrime(5));
    }

    // methods -> access modifier, return type name() {
    // body
    // return statement
    // }
    static int sum(Scanner in) {
        // Same instance of Scanner is reused
        System.out.println("The hashCode of Scanner instance: " + in.hashCode());
        System.out.println("The identity hashCode of Scanner instance: " + System.identityHashCode(in));
        // Interestingly you cannot print/access the uninitialized variables
        int num1 = 6, num2 = 5, sum;
        // System.out.print("Enter the 1st number: ");
        // num1 = in.nextInt();
        // System.out.print("Enter the 2nd number: ");
        // num2 = in.nextInt();
        sum = num1 + num2;
        return sum;
    }

    // Overloaded method sum
    static int sum(int n1, int n2) {
        return n1 + n2;
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

    static void fun(int singleValue, int... v) {
        // Internally, `v` is an Array
        System.out.println(Arrays.toString(v));
        System.out.println(singleValue);
    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        return c * c > n;
    }
}
