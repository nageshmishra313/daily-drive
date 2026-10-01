package leetcode;

import java.util.Arrays;

public class EliminateMaximumMonsters {
    public static void main(String[] args) {
        System.out.println(new EliminateMaximumMonsters().eliminateMaximum(new int[]{1, 3, 4}, new int[]{1, 1, 1}));
        System.out.println(new EliminateMaximumMonsters().eliminateMaximum(new int[]{1,1,2,3}, new int[]{1,1,1,1}));
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] arrival = new int[dist.length];
        for (int i = 0; i < arrival.length; i++) {
            arrival[i] = (dist[i] + speed[i] - 1) / speed[i];
        }

        Arrays.sort(arrival);

        for (int i = 0; i < arrival.length; i++) {
            if (arrival[i] <= i) {
                return i;
            }
        }

        return arrival.length;
    }
}
