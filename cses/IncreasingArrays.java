package cses;

import java.util.Scanner;

public class IncreasingArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int[] inputArray = new int[count];
        for (int i = 0; i < count; i++) {
            inputArray[i] = scan.nextInt();
        }
        System.out.println(increasingArray(inputArray));
        scan.close();

    }

    private static long increasingArray(int[] input) {
        long result = 0;
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] > input[i + 1]) {
                int difference = input[i] - input[i + 1];
                input[i + 1] = input[i + 1] + difference;
                result = result + Math.abs(difference);
            }
        }
        return result;
    }
}
