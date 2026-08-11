package dsa.dp.day1;

import java.util.HashMap;

public class Fibonacci {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(fibo(50L));
        System.out.println("Took : " + (System.nanoTime() - startTime) + "(ns)");
        startTime = System.nanoTime();
        System.out.println(fiboDSA(50L));
        System.out.println("Took : " + (System.nanoTime() - startTime) + "(ns)");
    }

    public static long fiboDSA(long n) {
        long result = 0;
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 0L);
        map.put(1L, 1L);
        for (long i = 2; i <= n; i++) {
            result = map.get(i - 1L) + map.get(i - 2L);
            map.put(i, result);
        }
        return result;
    }

    public static long fibo(long n) {
        if (n <= 2) return 1;
        return fibo(n - 1) + fibo(n - 2);
    }
}