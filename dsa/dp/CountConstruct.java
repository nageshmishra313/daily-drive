package dsa.dp;

import java.util.HashMap;

public class CountConstruct {
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        startTime = System.nanoTime();
        map.clear();
        System.out.println(countConstructMemo("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        startTime = System.nanoTime();
        map.clear();
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "d", "te", "ska", "sk", "boar"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        startTime = System.nanoTime();
        map.clear();
        System.out.println(countConstructMemo("skateboard", new String[]{"bo", "rd", "ate", "d", "te", "ska", "sk", "boar"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        startTime = System.nanoTime();
        map.clear();
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        startTime = System.nanoTime();
        map.clear();
        System.out.println(countConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");

    }

    public static int countConstruct(String target, String[] sampleList) {
        if (target.isEmpty()) {
            return 1;
        }
        int count = 0;
        for (String sample : sampleList) {
            if (target.startsWith(sample)) {
                String newTarget = target.replaceFirst(sample, "");
                count = count + countConstruct(newTarget, sampleList);
            }
        }
        return count;
    }

    public static int countConstructMemo(String target, String[] sampleList) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target.isEmpty()) {
            return 1;
        }
        int count = 0;
        for (String sample : sampleList) {
            if (target.startsWith(sample)) {
                String newTarget = target.replaceFirst(sample, "");
                count = count + countConstructMemo(newTarget, sampleList);
                map.put(target, count);
            }
        }
        map.put(target, count);
        return count;
    }

}
