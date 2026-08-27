package leetcode.dsa;

import java.util.*;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

    private static int rob(int[] nums) {
        return output(nums, 0, new HashMap<>());
    }

    private static int output(int[] nums, int index, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index >= nums.length) {
            return 0;
        }
        int include = nums[index] + output(nums, index + 2, memo);
        int exclude = output(nums, index + 1, memo);
        int max = include > exclude ? include : exclude;
        memo.put(index, max);
        return max;
    }
}