import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        if (scan.hasNextLine()) {
            String input = scan.nextLine();
            System.out.println(repetitions(input));
        }
        scan.close();
    }

    private static int repetitions(String input) {
        int maxResult = 1;
        int currentResult = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                currentResult++;
            } else {
                currentResult = 1;
            }
            maxResult = Math.max(maxResult, currentResult);
        }
        return maxResult;
    }
}
