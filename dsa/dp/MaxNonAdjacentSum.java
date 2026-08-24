package dsa.dp;

import java.util.HashMap;

public class MaxNonAdjacentSum {
    public static void main(String[] args) {
        System.out.println(nonAdjacentSum(new int[]{2, 4, 5, 12, 7}, 0, new HashMap<>()));
        System.out.println(nonAdjacentSum(new int[]{7, 5, 5, 12}, 0, new HashMap<>()));
    }

    private static int nonAdjacentSum(int[] values, int index, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index >= values.length) {
            return 0;
        }
        int output = Math.max(values[index] + nonAdjacentSum(values, index + 2, memo), nonAdjacentSum(values, index + 1, memo));
        memo.put(index, output);
        return output;
    }

}
