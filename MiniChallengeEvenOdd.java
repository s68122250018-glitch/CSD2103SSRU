import java.util.Scanner;

public class MiniChallengeEvenOdd {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] numbers = new int[10];

        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < numbers.length; i++) {

            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();

            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even count = " + evenCount);
        System.out.println("Odd count = " + oddCount);

        input.close();
    }
}