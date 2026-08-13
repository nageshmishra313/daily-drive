package dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BestSum {
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(bestSum(8, Arrays.asList(2, 3, 5)));
        map.clear();
        System.out.println(bestSum(7, Arrays.asList(2, 3, 4, 5, 6, 9)));
        map.clear();
        System.out.println(bestSum(8, Arrays.asList(1, 4, 4)));
        map.clear();
        System.out.println(bestSum(100, Arrays.asList(1, 2, 5, 25)));
    }

    public static ArrayList<Integer> bestSum(Integer target, List<Integer> sampleList) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target == 0) {
            return new ArrayList<>();
        }
        if (target < 0) {
            return null;
        }
        ArrayList<Integer> smallestList = null;

        for (Integer current : sampleList) {
            Integer remainder = target - current;
            ArrayList<Integer> list = bestSum(remainder, sampleList);
            if (list != null) {
                ArrayList<Integer> combination = new ArrayList<>(list);
                combination.add(current);
                if (smallestList == null || combination.size() < smallestList.size()) {
                    smallestList = combination;
                }
            }
        }
        map.put(target, smallestList);
        return smallestList;
    }
}
