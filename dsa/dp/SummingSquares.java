package dsa.dp;

import java.util.ArrayList;
import java.util.HashMap;

public class SummingSquares {
    public static void main(String[] args) {
        System.out.println(minPerfectSquareSum(17, 1, new ArrayList<>(), new HashMap<String, ArrayList<Integer>>()));
        System.out.println(minPerfectSquareSum(101, 1, new ArrayList<>(), new HashMap<String, ArrayList<Integer>>()));

    }

    private static ArrayList<Integer> minPerfectSquareSum(int value, int currentNumber, ArrayList<Integer> list, HashMap<String, ArrayList<Integer>> memo) {
        if (memo.containsKey(value + "-" + currentNumber)) {
            return memo.get(value + "-" + currentNumber);
        }
        if (value < 0) {
            return null;
        }
        if (value == 0) {
            return list;
        }
        int square = currentNumber * currentNumber;
        int nextSquare = (currentNumber + 1) * (currentNumber + 1);
        int valueAfterSubtractingSquare = value - square;
        int valueAfterSubtractingNextSquare = value - nextSquare;
        ArrayList<Integer> listOfCurrentSquare = new ArrayList<>(list);
        listOfCurrentSquare.add(square);
        ArrayList<Integer> listOfNextSquare = new ArrayList<>(list);
        listOfNextSquare.add(nextSquare);
        ArrayList<Integer> output1 = minPerfectSquareSum(valueAfterSubtractingSquare, currentNumber, listOfCurrentSquare, memo);
        ArrayList<Integer> output2 = minPerfectSquareSum(valueAfterSubtractingNextSquare, currentNumber + 1, listOfNextSquare, memo);
        if (output1 == null) {
            memo.put(valueAfterSubtractingSquare + "-" + currentNumber, output2);
            return output2;
        }

        if (output2 == null) {
            memo.put(valueAfterSubtractingNextSquare + "-" + currentNumber + 1, output1);
            return output1;
        }
        ArrayList<Integer> output = output1.size() <= output2.size() ? output1 : output2;
        memo.put(value + "-" + currentNumber, output);
        return output;
    }
}
