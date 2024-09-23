package Java.P2ArraysAndArrayLists;

import java.util.Arrays;
import java.util.Scanner;

public class L1Arrays {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Q: Store 5 roll numbers?
        // data_type[] variable_name = new data_type[size];

        // Declaration of array reference variable:
        int[] rollNumbers;

        // Initialization of array, new int array object will be created in heap
        // It will be pointed to by the array reference variable `rollNumbers`
        // System.out.print("Enter length of array: ");
        // rollNumbers = new int[in.nextInt()];
        rollNumbers = new int[7];

        // Assignment of value to the array object
        for (int i = 0; i < rollNumbers.length; i++) {
            // System.out.print("Enter value of element " + i + " : ");
            // rollNumbers[i] = in.nextInt();
            rollNumbers[i] = i * 2;
        }

        // Printing the assigned values
        for (int i = 0; i < rollNumbers.length; i++) {
            System.out.println(rollNumbers[i]);
        }
        // Using for-each loop
        for (int rollNumber : rollNumbers) {
            System.out.print(rollNumber * 5 + " ");
        }
        // Go to next line in console
        System.out.println();
        // Using in built `Arrays.toString(arr)` method to print
        System.out.println(Arrays.toString(rollNumbers));

        // Keyword `new` is used for object creation and object creation in heap
        // Declaration of array, initialized as 0:
        int[] rollNumbers2 = new int[5];
        System.out.println(Arrays.toString(rollNumbers2));

        // Left is the reference variable and right is the object
        // Left happens at compile time and right happens at runtime
        // That is why it is dynamic memory allocation
        // Heap objects are not continuous (may or may not be continuous)
        // Declaration and initialization of array:
        int[] rollNumbers3 = {11, 22, 33, 44, 55};
        System.out.println(Arrays.toString(rollNumbers3));

        // Array of objects (not primitives) like Strings are actually array of 
        // reference variables in the heap memory, these reference variables are 
        // pointing to the actual object in the heap memory
        // Initially they all point to null
        String[] names = new String[5];
        names[1] = "Abhishek";
        System.out.println(Arrays.toString(names));

        // Let's see how methods work with Arrays
        // Remember, in Java there is only pass by value, so when a method is 
        // called on an array reference variable. Its value is copied and passed 
        // to the method, because the value being copied is itself a reference to the
        // actual object, that object is modified. Reassigning a new object inside 
        // the method will not affect the original reference variable
        change(rollNumbers);
        System.out.println(Arrays.toString(rollNumbers));
    }

    static void change(int[] arr) {
        arr[0] = 99;
    }
}
