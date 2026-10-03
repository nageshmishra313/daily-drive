package leetcode;

import java.util.Stack;

public class RemoveAdjacent {
    public static void main(String[] args) {
        System.out.println(new RemoveAdjacent().removeDuplicates("abcd", 2));
        System.out.println(new RemoveAdjacent().removeDuplicates("deeedbbcccbdaa", 3));

    }

    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek()[0] == s.charAt(i)) {
                stack.peek()[1] = stack.peek()[1] + 1;
                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[]{s.charAt(i), 1});
            }
        }
        String output = "";
        for (int[] entry : stack) {
            char character = (char) entry[0];
            int count = entry[1];
            for (int j = 0; j < count; j++)
                output = output + "" + character;
        }
        return output;
    }
}