import java.util.Scanner;

public class ScoreResult {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter midterm score: ");
        double midterm = input.nextDouble();

        System.out.print("Enter final score: ");
        double finalScore = input.nextDouble();

        double total = midterm + finalScore;

        System.out.println("Total score = " + total);

        if (total >= 50) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        input.close();
    }
}
