package dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowSumTabulation {

    public static void main(String[] args) {
        System.out.println(howSum(Arrays.asList(7, 14), 300));
        System.out.println(howSum(Arrays.asList(5, 3, 4, 7), 7));
        System.out.println(howSum(Arrays.asList(2, 5, 3, 4, 7), 7));
        System.out.println(howSum(Arrays.asList(2, 3, 5), 8));
    }

    public static Object howSum(List<Integer> sampleList, Integer targetSum) {
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
                        tabulationArray[i + current] = newList;
                    }
                }
            }

        }
        return tabulationArray[targetSum];
    }

}