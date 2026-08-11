package dsa.dp.day1;

import java.util.HashMap;

public class GridTraveller {
    static HashMap<String, Long> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("0-0", 0L);
        map.put("0-1", 0L);
        map.put("1-0", 0L);
        map.put("1-1", 1L);
        map.put("2-1", 1L);
        map.put("1-2", 1L);
        map.put("2-2", 2L);
        System.out.println(travelWaysMemo(2, 2));
    }

    public static long travelWays(long n, long m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        return travelWays(n - 1, m) + travelWays(n, m - 1);
    }


    public static long travelWaysMemo(long n, long m) {
        String key = n + "-" + m;
        String reverseKey = m + "-" + n;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (map.containsKey(reverseKey)) {
            return map.get(reverseKey);
        }
        long keyResultRight = travelWays(n - 1, m);
        long keyResultDown = travelWays(n, m - 1);

        map.put(key, keyResultRight + keyResultDown);
        map.put(reverseKey, keyResultRight + keyResultDown);

        return keyResultRight + keyResultDown;
    }
}
