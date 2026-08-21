package dsa.dp;

import java.util.Arrays;
import java.util.HashMap;

public class CountConstructTabulation {
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "d", "te", "ska", "sk", "boar"}));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee"}));

    }

    public static int countConstruct(String target, String[] sampleList) {
        int[] tabulationArray = new int[target.length() + 1];
        Arrays.fill(tabulationArray, 0);
        tabulationArray[0] = 1;
        for (int i = 0; i < tabulationArray.length; i++) {
            for (String word : sampleList) {
                if (word.length() + i <= target.length() && target.startsWith(word, i)) {
                    tabulationArray[i + word.length()] = tabulationArray[i] + 1;
                }
            }
        }
        return tabulationArray[target.length()];
    }

}
