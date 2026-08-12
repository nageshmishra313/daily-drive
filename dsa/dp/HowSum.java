package dsa.dp;

import java.util.*;

public class HowSum {
    private static final HashMap<Integer, List<Integer>> memo = new HashMap<>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(howSum(Arrays.asList(7, 14), 300));
        System.out.println(howSum(Arrays.asList(5, 3, 4, 7), 7));
        System.out.println(howSum(Arrays.asList(2, 5, 3, 4, 7), 7));
        System.out.println(howSum(Arrays.asList(2, 3, 5), 8));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        startTime = System.nanoTime();
        System.out.println(howSumMemo(Arrays.asList(7, 14), 300));
        memo.clear();
        System.out.println(howSumMemo(Arrays.asList(5, 3, 4, 7), 7));
        memo.clear();
        System.out.println(howSumMemo(Arrays.asList(2, 5, 3, 4, 7), 7));
        memo.clear();
        System.out.println(howSumMemo(Arrays.asList(2, 3, 5), 8));
        memo.clear();
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");

    }

    public static List<Integer> howSum(List<Integer> sampleList, Integer targetSum) {
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0 || sampleList.isEmpty()) {
            return null;
        }
        for (Integer integer : sampleList) {
            Integer remainder = targetSum - integer;
            List<Integer> remainderResult = howSum(sampleList, remainder);
            if (remainderResult != null) {
                remainderResult.add(integer);
                return remainderResult;
            }
        }
        return null;
    }

    public static List<Integer> howSumMemo(List<Integer> sampleList, Integer targetSum) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0 || sampleList.isEmpty()) {
            return null;
        }
        for (Integer integer : sampleList) {
            Integer remainder = targetSum - integer;
            List<Integer> remainderResult = howSumMemo(sampleList, remainder);
            if (remainderResult != null) {
                remainderResult.add(integer);
                memo.put(targetSum, remainderResult);
                return remainderResult;
            }
        }
        memo.put(targetSum, null);
        return null;
    }
}