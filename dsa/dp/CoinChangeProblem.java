package dsa.dp;

import java.util.HashMap;

public class CoinChangeProblem {
    public static void main(String[] args) {
        System.out.println(countWays(4, new int[]{1, 2, 3}, 0, new HashMap<>()));
    }

    private static int countWays(int amount, int[] values, int index, HashMap<String, Integer> memo) {
        if (memo.containsKey(amount + "-" + index)) {
            return memo.get(amount + "-" + index);
        }
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || index >= values.length) {
            return 0;
        }
        int include = countWays(amount - values[index], values, index, memo); // if not allowed to repeat increase the index everytime
        int exclude = countWays(amount, values, index + 1, memo);
        memo.put(amount + "-" + index, include + exclude);
        return include + exclude;
    }
}
