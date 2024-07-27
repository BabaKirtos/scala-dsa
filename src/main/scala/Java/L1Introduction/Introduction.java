package Java.L1Introduction;

public class Introduction {

    public static void main(String[] args) {

        // In the below statement, a is the reference variable and 10 is the object
        // a is stored in stack, whereas object 10 is stored in heap memory
        String name = "Baba";
        // When we reassign a to another value like 20, object 10 is cleared from
        // the heap memory by the garbage collector
        name = "Abhishek";

        System.out.println("Hi, my name is: " + name);
    }
}
