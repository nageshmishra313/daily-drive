package leetcode.dsa;

import java.util.*;

class CoinChange {

    private final static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        coinChange(new int[]{1, 3, 4}, 4);
        coinChange(new int[]{3}, 2);

    }

    public static int coinChange(int[] coins, int amount) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int output = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int include = coinChange(coins, amount - coins[i]);
            if (include >= 0) {
                output = Math.min(output, include + 1);
            }

        }
        int result = (output == Integer.MAX_VALUE) ? -1 : output;
        memo.put(amount, result);
        return result;
    }
}
