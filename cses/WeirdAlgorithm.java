package cses;

import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Example: Read an integer and print it
        if (scan.hasNextInt()) {
            int n = scan.nextInt();
            printWierdAlgorithm(n);
        }

        scan.close();
    }

    private static void printWierdAlgorithm(long number) {
        while (number > 0) {
            System.out.print(number + " ");
            if (number == 1) {
                break;
            }
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = number * 3 + 1;
            }
        }
    }
}
