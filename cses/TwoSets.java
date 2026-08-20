package cses;

public class TwoSets {
    public static void main(String[] args) {
        System.out.println(output(7));
        System.out.println(output(5));
    }

    public static String output(int n) {
        if ((n * (n + 1) / 2 % 2) == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
