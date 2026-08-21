package dsa.dp;

import java.util.HashMap;

public class CanConstruct {
    static HashMap<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        startTime = System.nanoTime();
        map.clear();
        System.out.println(canConstructMemo("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        startTime = System.nanoTime();
        map.clear();
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "d", "te", "ska", "sk", "boar"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
        startTime = System.nanoTime();
        map.clear();
        System.out.println(canConstructMemo("skateboard", new String[]{"bo", "rd", "ate", "d", "te", "ska", "sk", "boar"}));
        System.out.println("Took:" + (System.nanoTime() - startTime) + "(ns)");
    }

    public static boolean canConstruct(String target, String[] sampleList) {
        if (target.isEmpty()) {
            return true;
        }
        for (String sample : sampleList) {
            if (target.startsWith(sample)) {
                String newTarget = target.replace(sample, "");
                boolean result = canConstruct(newTarget, sampleList);
                if (result) {
                    return true;
                }

            }
        }
        return false;
    }

    public static boolean canConstructMemo(String target, String[] sampleList) {
        if (map.containsKey(target)) {
            return true;
        }
        if (target.isEmpty()) {
            return true;
        }
        for (String sample : sampleList) {
            if (target.startsWith(sample)) {
                String newTarget = target.replace(sample, "");
                boolean result = canConstructMemo(newTarget, sampleList);
                if (result) {
                    map.put(newTarget, true);
                    return true;
                }

            }
        }
        map.put(target, true);
        return false;
    }
}
