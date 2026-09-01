package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{4, 2, 1, 3}));
        System.out.println(minimumAbsDifference(new int[]{1, 3, 6, 10, 15}));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(arr);
        long maxDiff = arr[arr.length - 1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            long currentDiff = arr[i + 1] - arr[i];
            if (currentDiff < maxDiff) {
                maxDiff = currentDiff;
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == maxDiff) {
                List<Integer> currentEntry = new ArrayList<>();
                currentEntry.add(arr[i]);
                currentEntry.add(arr[i + 1]);
                output.add(currentEntry);
            }
        }
        return output;
    }
}
