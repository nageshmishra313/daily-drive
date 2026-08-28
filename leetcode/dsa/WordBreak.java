package leetcode.dsa;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        return output(s, wordDict, 0, new HashMap<>());

    }

    private static boolean output(String s, List<String> wordDict, int index, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index == s.length()) {
            return true;
        }
        if (index > s.length()) {
            return false;
        }

        for (String word : wordDict) {
            int wordLength = word.length();
            if (index + wordLength <= s.length()) {
                String sub = s.substring(index, index + wordLength);
                if (word.equals(sub)) {
                    boolean possible = output(s, wordDict, index + wordLength, memo);
                    if (possible) {
                        memo.put(index, true);
                        return true;
                    }
                }
            }
        }
        memo.put(index, false);
        return false;
    }
}
