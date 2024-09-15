package Java.P1Introduction;

import java.util.Scanner;

public class L2Methods {

    public static void main(String[] args) {
        // Q: Take input of 2 numbers and prints the sum as output
        // To avoid initializing Scanner instance everytime
        Scanner in = new Scanner(System.in);
        System.out.println("The sum is: " + sum(in));
        System.out.println("The sum is: " + sum(in));
        System.out.println("The sum is: " + sum(in));
    }

    // methods -> access modifier, return type name() {
    // body
    // return statement
    // }
    static int sum(Scanner in) {
        System.out.println(in.hashCode());
        // Interestingly you cannot print/access the uninitialized variables
        int num1, num2, sum;
        System.out.print("Enter the 1st number: ");
        num1 = in.nextInt();
        System.out.print("Enter the 2nd number: ");
        num2 = in.nextInt();
        sum = num1 + num2;
        return sum;
    }
}
