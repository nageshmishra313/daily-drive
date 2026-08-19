package dsa.dp;

import java.util.*;

public class CanSumTabulation {
    static Map<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(canSum(Arrays.asList(5, 5), 300));
        System.out.println("Took : " + (System.nanoTime() - startTime) + "(ns)");
        startTime = System.nanoTime();
        System.out.println(canSumUsingTabulation(Arrays.asList(5, 5), 300));
        System.out.println("Took : " + (System.nanoTime() - startTime) + "(ns)");
    }

    private static boolean canSum(List<Integer> list, int i) {
        if (map.containsKey(i)) {
            return map.get(i);
        }
        if (i == 0) {
            return true;
        }
        if (i < 0) {
            return false;
        }
        for (Integer current : list) {
            int currentSum = i - current;
            boolean result = canSum(list, currentSum);
            if (result) {
                map.put(currentSum, result);
                return true;
            }
        }
        return false;
    }

    private static boolean canSumUsingTabulation(List<Integer> list, int i) {
        boolean[] table = new boolean[i + 1];
        Arrays.fill(table, false);

        for (Integer currentListValue : list) {
            table[currentListValue + 1] = true;
        }
        table[0] = true;
        for (int current = 0; current < table.length; current++) {
            if (table[current]) {
                for (Integer value : list) {
                    if (current + value < table.length)
                        table[current + value] = true;
                }
            }
        }
        return table[i];
    }

}
