package Java.L1Introduction;

import java.util.Scanner;

public class Introduction {

    public static void main(String[] args) {

        // In the below statement, a is the reference variable and 10 is the object
        // a is stored in stack, whereas object 10 is stored in heap memory
        String name = "Baba";
        // When we reassign a to another value like 20, object 10 is cleared from
        // the heap memory by the garbage collector
        name = "Abhishek";
        System.out.println("Hi, my name is: " + name);

        // To get input from the console
        System.out.println("Please enter your roll number:");
        Scanner input = new Scanner(System.in);
        int rollNumber = input.nextInt();
        System.out.println("Your roll number is: " + rollNumber);

        // automatic type promotion
        byte a = 40;
        byte b = 50;
        byte c = 100;

        // a, b and c are automatically upgraded to int
        int d = a * b / c;
        System.out.println(d);

        // ascii value of s will be printed
        // Java uses unicode
        int someChar = 's';
        System.out.println(someChar);

        // if condition
        int someValue = 30;
        if (someValue > 25) {
            System.out.println("Value is greater than 25");
        }

        // while condition
        int count = 1;
        while (count <= 5) {
            System.out.println(count);
            count += 1;
        }
    }
}
