package cses;

import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            int n = scan.nextInt();
            permutations(n);
        }
        scan.close();
    }

    private static void permutations(int number) {
        if (number == 2 || number == 3) {
            System.out.println("NO SOLUTION");
            return;
        }
        for (int i = 2; i <= number; i = i + 2) {
            System.out.print(i + " ");
        }
        for (int i = 1; i <= number; i = i + 2) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
