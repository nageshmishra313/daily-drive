package leetcode;

import java.io.*;
import java.util.*;

public class ChemicalWeight {
    public static int calculateWeight(String formula) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        int output = 0;
        int currentMultiplier = 1;
        int currentOutput = 0;
        while (index < formula.length()) {
            if (formula.charAt(index) == 'C' || formula.charAt(index) == 'H' || formula.charAt(index) == 'O') {
                stack.push(formula.charAt(index++));
                currentMultiplier = 1;
            } else if (formula.charAt(index) >= '1' && formula.charAt(index) <= '9') {
                int current = switch (stack.pop()) {
                    case 'C' -> 12;
                    case 'H' -> 1;
                    case 'O' -> 8;
                    default -> 0;
                };
                output = output + current * currentMultiplier;
            } else if (formula.charAt(index) == '(') {
                stack.push('(');

            } else if (formula.charAt(index) == ')') {
                currentMultiplier = 1;
                currentOutput = 0;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char current = stack.pop();
                    if (current == 'C') {
                        currentOutput = currentOutput + 12 * currentMultiplier;
                    } else if (current == 'H') {
                        currentOutput = currentOutput + currentMultiplier;
                        currentMultiplier = 1;
                    } else if (current == 'O') {
                        currentOutput = currentOutput + 8 * currentMultiplier;
                        currentMultiplier = 1;
                    } else if (current >= '1' && current <= '9') {
                        currentMultiplier = Integer.parseInt("" + current);
                    }
                }
                stack.pop();
                if (stack.peek() > '1' && stack.peek() < '9') {
                    output = output + currentOutput * Integer.parseInt("" + stack.pop());
                }

            }

        }
        currentMultiplier = 1;
        while (!stack.isEmpty()) {
            char current = stack.pop();
            if (current == ')') {
            }
            if (current == 'C') {
                output = output + 12 * currentMultiplier;
            } else if (current == 'H') {
                output = output + currentMultiplier;
                currentMultiplier = 1;
            } else if (current == 'O') {
                output = output + 8 * currentMultiplier;
                currentMultiplier = 1;
            } else if (current >= '1' && current <= '9') {
                currentMultiplier = Integer.parseInt("" + current);
                System.out.println(currentMultiplier);
            }
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(ChemicalWeight.calculateWeight("CH(CH)O4"));
    }
}