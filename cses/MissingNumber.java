package cses;

import java.util.Arrays;
import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long number;
        long[] values;
        number = Integer.parseInt(scan.nextLine());
        values = Arrays.stream(scan.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        missingNumber(number, values);
        scan.close();
    }

    private static void missingNumber(long number, long[] values) {
        long total = number * (number + 1) / 2;
        long valuesTotal = Arrays.stream(values).sum();
        System.out.println(total - valuesTotal);
    }
}
