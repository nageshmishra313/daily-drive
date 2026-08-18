package dsa.dp;

public class FibonacciTabulation {
    public static void main(String[] args) {
        System.out.println(fiboTabulation(8));
        System.out.println(fiboTabulation(50));
    }

    public static long fiboTabulation(int n) {
        long[] array = new long[n + 1];
        array[1] = 1;
        for (int i = 0; i < n; i++) {
            array[i + 1] = array[i + 1] + array[i];
            if (i + 2 <= n) {
                array[i + 2] += array[i];
            }
        }
        return array[n];
    }

}