package leetcode.dsa;

import java.util.*;

public class ClimbingStairs {
    private static final HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(9));
        System.out.println(climbStairs(7));
        System.out.println(climbStairs(53));
    }

    private static int climbStairs(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 1 || n == 0) {
            return 1;
        }
        int output = climbStairs(n - 1) + climbStairs(n - 2);
        memo.put(n, output);
        return output;
    }
}
