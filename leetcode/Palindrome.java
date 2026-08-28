package leetcode;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String xString = String.valueOf(x);
        int i = 0;
        int j = xString.length() - 1;
        while (i < j) {
            if (xString.charAt(i) != xString.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }

        }
        return true;
    }
}