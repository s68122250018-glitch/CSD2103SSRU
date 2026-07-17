import java.util.Scanner;

public class ScoreArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] scores = new int[5];
        int total = 0;

        for (int i = 0; i < scores.length; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            scores[i] = input.nextInt();

            total += scores[i];
        }

        double average = (double) total / scores.length;

        System.out.println("Total score = " + total);
        System.out.println("Average score = " + average);

        input.close();
    }
}