package dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestSumTabulation {

    public static void main(String[] args) {
        System.out.println(bestSum(Arrays.asList(7, 14), 300));
        System.out.println(bestSum(Arrays.asList(5, 3, 4, 7), 7));
        System.out.println(bestSum(Arrays.asList(2, 5, 3, 4, 7), 7));
        System.out.println(bestSum(Arrays.asList(2, 3, 5), 8));
    }

    public static Object bestSum(List<Integer> sampleList, Integer targetSum) {
        List[] tabulationArray = new ArrayList[targetSum + 1];
        for (int sample : sampleList) {
            tabulationArray[sample] = new ArrayList<>(List.of(sample));
        }
        for (int i = 1; i < tabulationArray.length; i++) {
            if (tabulationArray[i] != null) {
                for (int current : sampleList) {
                    if (i + current < tabulationArray.length) {
                        ArrayList<Integer> newList = new ArrayList<>();
                        newList.addAll(tabulationArray[i]);
                        newList.add(current);
                        if (tabulationArray[i + current] == null) {
                            tabulationArray[i + current] = newList;
                        } else if (tabulationArray[i + current].size() > newList.size())
                            tabulationArray[i + current] = newList;

                    }
                }
            }

        }
        return tabulationArray[targetSum];
    }

}