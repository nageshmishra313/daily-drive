package dsa.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllConstruct {
    static HashMap<String, List<List<String>>> map = new HashMap<>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(allConstruct("hello", new String[]{"cat", "dog", "mouse"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        map.clear();
        startTime = System.nanoTime();
        System.out.println(allConstructMemo("hello", new String[]{"cat", "dog", "mouse"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        map.clear();
        startTime = System.nanoTime();
        System.out.println(allConstruct("", new String[]{"cat", "dog", "mouse"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        map.clear();
        startTime = System.nanoTime();
        System.out.println(allConstructMemo("", new String[]{"cat", "dog", "mouse"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        map.clear();
        startTime = System.nanoTime();
        System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        startTime = System.nanoTime();
        map.clear();
        System.out.println(allConstructMemo("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        startTime = System.nanoTime();
        map.clear();
        System.out.println(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "d", "te", "ska", "sk", "boar"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        startTime = System.nanoTime();
        map.clear();
        System.out.println(allConstructMemo("skateboard", new String[]{"bo", "rd", "ate", "d", "te", "ska", "sk", "boar"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
    }

    public static List<List<String>> allConstruct(String target, String[] sampleList) {
        if (target.isEmpty()) {
            return new ArrayList<>(List.of(new ArrayList<>()));
        }
        List<List<String>> result = new ArrayList<>();
        for (String sample : sampleList) {
            if (target.startsWith(sample)) {
                String current = target.substring(sample.length());
                List<List<String>> currentResult = allConstruct(current, sampleList);
                for (List<String> res : currentResult) {
                    res.add(0, sample);
                    result.add(res);
                }
            }
        }
        return result;
    }

    public static List<List<String>> allConstructMemo(String target, String[] sampleList) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target.isEmpty()) {
            return new ArrayList<>(List.of(new ArrayList<String>()));
        }
        List<List<String>> result = new ArrayList<>();
        for (String word : sampleList) {
            if (target.startsWith(word)) {
                String currentWord = target.substring(word.length());
                List<List<String>> newPrefixResult = allConstructMemo(currentWord, sampleList);
                newPrefixResult.forEach(newPrefixResultString -> {
                    newPrefixResultString.add(0, word);
                    result.add(new ArrayList<>(newPrefixResultString));
                });
            }
        }
        map.put(target, result);
        return result;
    }
}
