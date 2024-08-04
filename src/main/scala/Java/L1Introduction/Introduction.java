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

        // while loop
        int count = 1;
        while (count != 6) {
            System.out.println("while loop count: " + count);
            count++;
        }

        // for loop
        for (int forCount = 0; forCount <= 10; forCount += 2) {
            System.out.println("for loop count: " + forCount);
        }

        // if else-if else statements
        int salary = 34000;
        if (salary < 10000) {
            salary += 3000;
        } else if (salary >= 10000 && salary < 40000) {
            salary += 2000;
        } else {
            salary += 1000;
        }
        System.out.println(salary);

        // do while loop
        // used when we want to run the loop atleast once
        int n = 5;
        do {
            System.out.println(n);
            n--;
        } while (n != 0);

        // find largest of 3 numbers
        System.out.println("Enter 3 numbers:");

        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int n3 = input.nextInt();

        int max = n1;

        if (n2 > max) {
            max = n2;
        }
        if (n3 > max) {
            max = n3;
        }
        System.out.println("Max number is: " + max);

        // take a char input and tell if it is upper or lower case
        System.out.println("Enter a character:");

        char ch = input.next().trim().charAt(0);

        if (ch >= 'a' && ch <= 'z') {
            System.out.println("Its lower case");
        } else {
            System.out.println("Its upper case");
        }
    }
}
