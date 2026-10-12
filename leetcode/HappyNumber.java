package leetcode;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(21));
        System.out.println(new HappyNumber().isHappy(27));
        System.out.println(new HappyNumber().isHappy(99));
    }
        public boolean isHappy(int n) {
            if (n == 1 || n == 7) {
                return true;
            } else if (n < 10) {
                return false;
            } else {
                int current = 0;
                do {
                    int remainder = n % 10;
                    current = current + remainder * remainder;
                    n = n / 10;
                } while (n > 0);
                return isHappy(current);
            }

        }
}
