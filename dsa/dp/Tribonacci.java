package dsa.dp;

import java.util.HashMap;
import java.util.Map;

public class Tribonacci {

    public static void main(String[] args) {
        System.out.println(output(7, new HashMap<>()));
        System.out.println(output(9, new HashMap<>()));
        System.out.println(output(31, new HashMap<>()));
    }

    private static int output(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 0 || n < 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int output = output(n - 1, memo) + output(n - 2, memo) + output(n - 3, memo);
        memo.put(n, output);
        return output;

    }
}
