package dsa.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CanSum {
    private static final HashMap<Integer, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(canSum(Arrays.asList(7, 14), 300));
        System.out.println("Took : " + (System.nanoTime() - startTime) + "(ns)");
        memo.clear();
        startTime = System.nanoTime();
        System.out.println(canSumMemo(Arrays.asList(7, 14), 300));
        System.out.println("Took : " + (System.nanoTime() - startTime) + "(ns)");

    }

    public static boolean canSum(List<Integer> sampleList, Integer targetSum) {
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        boolean result = false;
        for (Integer integer : sampleList) {
            Integer remainder = targetSum - integer;
            if (canSum(sampleList, remainder)) {
                result = true;
                break;
            }
        }
        return result;
    }
    public static boolean canSumMemo(List<Integer> sampleList, Integer targetSum) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        boolean result = false;
        for (Integer integer : sampleList) {
            Integer remainder = targetSum - integer;
            if (canSumMemo(sampleList, remainder)) {
                result = true;
                break;
            }
        }
        memo.put(targetSum, result);
        return result;
    }

}
