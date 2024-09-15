package Java.P1Introduction;

import java.util.Scanner;

public class L1Introduction {

    public static void main(String[] args) {

        // In the below statement, a is the reference variable and 10 is the object
        // `a` is stored in stack, whereas object 10 is stored in heap memory
        String name = "Baba";
        // When we reassign `a` to another value like 20, object 10 is cleared from
        // the heap memory by the garbage collector
        name = "Abhishek";
        System.out.println("Hi, my name is: " + name);

        // To get input from the console
        System.out.println("Please enter your roll number:");
        Scanner input = new Scanner(System.in);
        // int rollNumber = input.nextInt();
        int rollNumber = 43;
        System.out.println("Your roll number is: " + rollNumber);

        // automatic type promotion
        byte a = 40;
        byte b = 50;
        byte c = 100;

        // a, b and c are automatically upgraded to int
        int d = a * b / c;
        System.out.println(d);

        // ascii value of s will be printed
        // Java uses Unicode
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

        // int n1 = input.nextInt();
        // int n2 = input.nextInt();
        // int n3 = input.nextInt();
        int n1 = 34;
        int n2 = 98;
        int n3 = 5;

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

        // char ch = input.next().trim().charAt(0);
        char ch = 'T';

        if (ch >= 'a' && ch <= 'z') {
            System.out.println("Its lower case");
        } else {
            System.out.println("Its upper case");
        }

        // find the nth fibonacci number => 0,1,1,2,3,5,8
        System.out.println("Enter the n for fibonacci number:");
        // int nFib = input.nextInt();
        int nFib = 9;
        int previous = 0;
        int current = 1;
        int counter = 2;
        while (counter <= nFib) {
            int temp = current;
            current += previous;
            previous = temp;
            counter++;
        }
        if (nFib == 0) {
            System.out.println(previous);
        } else {
            System.out.println(current);
        }

        // find occurence of a given digit in a number
        // ex - 13453256353 - 3 occurs 4 time
        int mainNum = 1345325353;
        int targetNum = 3;
        int occurence = 0;
        while (mainNum != 0) {
            if (mainNum % 10 == targetNum) {
                occurence += 1;
                mainNum /= 10;
            } else {
                mainNum /= 10;
            }
        }
        System.out.println("Target occured " + occurence + " times");

        // reverse a given number
        int toReverse = 34523986;
        int reversed = 0;
        while (toReverse != 0) {
            reversed = (reversed * 10) + (toReverse % 10);
            toReverse /= 10;
        }
        System.out.println("Reversed number is " + reversed);

        // build a calculator app
        // the app should terminate when user enters x
        while (true) {
            int ans = -1;
            System.out.println("Enter an operator (enter x to quit):");
            char op = input.next().trim().charAt(0);
            if (op == '+' || op == '-' || op == '*' || op == '/' || op == '%') {
                // input operands
                System.out.println("Enter operands:");
                int op1 = input.nextInt();
                int op2 = input.nextInt();
                if (op == '+') {
                    ans = op1 + op2;
                } else if (op == '-') {
                    ans = op1 - op2;
                } else if (op == '*') {
                    ans = op1 * op2;
                } else if (op == '/') {
                    if (op2 == 0) {
                        System.out.println("Cannot divide by zero!");
                    } else {
                        ans = op1 / op2;
                    }
                } else if (op == '%') {
                    ans = op1 % op2;
                }
                System.out.println("Answer is: " + ans);
            } else if (op == 'x') {
                System.out.println("Thank you for using the calculator app..");
                break;
            } else {
                System.out.println("Unsupported operator.. retry");
            }
        }

        // `equals` checks value of the argument string object against this object
        // by 'this' object we mean the object on which the method is called
        // `==` checks the reference of the object, which can give true or false
        // based on if both the variables are pointing to the same object or not
        // String ex = "baba";
        // String ex1 = "baba";
        // System.out.println(ex == ex1); // can be true or false
        // System.out.println(ex.equals(ex1)); // will always be true

        // switch statements
        // It maybe more efficient than if-else-if ladder
        // https://stackoverflow.com/questions/10287700/difference-between-jvms-lookupswitch-and-tableswitch
        System.out.println("Enter a fruit:");
        String fruit = input.next();
        // switch (fruit) {
        //     case "Mango":
        //         System.out.println("It's yellow");
        //         break;
        //     case "Apple":
        //         System.out.println("It's red");
        //         break;
        //     case "Orange":
        //         System.out.println("It's orange");
        //         break;
        //     default:
        //         System.out.println("Please enter a valid fruit!");
        // }

        // A better switch
        switch (fruit) {
            case "Mango" -> System.out.println("It's yellow");
            case "Banana" -> System.out.println("It's yellow");
            case "Apple" -> System.out.println("It's red");
            case "Orange" -> System.out.println("It's an orange");
            default -> System.out.println("Please enter a valid fruit!");
        }
    }
}
