package java_challenge;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = scanner.nextInt();
        System.out.println("The number is even? " + isEven(num));
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
