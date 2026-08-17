import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        NGEAlgorithm algorithm = new NGEAlgorithm();

        int n;

        // ==============================
        // รับจำนวนอาคาร
        // ==============================
        while (true) {

            System.out.print("Enter number of buildings: ");

            if (!scanner.hasNextInt()) {
                System.out.println(
                        "Invalid input. Please enter an integer.");
                scanner.next();
                continue;
            }

            n = scanner.nextInt();

            if (n <= 0) {
                System.out.println(
                        "Number of buildings must be greater than 0.");
                continue;
            }

            break;
        }

        // ==============================
        // รับความสูงของอาคาร
        // ==============================
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {

            while (true) {

                System.out.print(
                        "Enter height of building "
                        + (i + 1) + ": ");

                if (!scanner.hasNextInt()) {
                    System.out.println(
                            "Invalid input. Please enter an integer.");
                    scanner.next();
                    continue;
                }

                int height = scanner.nextInt();

                if (height < 0) {
                    System.out.println(
                            "Height must not be negative.");
                    continue;
                }

                heights[i] = height;
                break;
            }
        }

        // ==============================
        // แสดง Input
        // ==============================
        System.out.println();
        System.out.println(
                "Input: " + Arrays.toString(heights));

        // ==============================
        // Algorithm A: Brute Force
        // ==============================
        long startA = System.nanoTime();

        int[] resultA =
                algorithm.bruteForceNGE(heights);

        long endA = System.nanoTime();

        long timeA = endA - startA;
        long operationsA =
                algorithm.getOperationA();

        // ==============================
        // Algorithm B: Monotonic Stack
        // ==============================
        long startB = System.nanoTime();

        int[] resultB =
                algorithm.monotonicStackNGE(heights);

        long endB = System.nanoTime();

        long timeB = endB - startB;
        long operationsB =
                algorithm.getOperationB();

        // ==============================
        // Largest Rectangle
        // ==============================
        int largestRectangle =
                algorithm.largestRectangle(heights);

        // ==============================
        // แสดงผล Algorithm A
        // ==============================
        System.out.println();
        System.out.println(
                "Algorithm A: Brute Force");

        System.out.println(
                "Result: " + Arrays.toString(resultA));

        System.out.println(
                "Time: " + timeA + " ns");

        System.out.println(
                "Operations: " + operationsA);

        // ==============================
        // แสดงผล Algorithm B
        // ==============================
        System.out.println();
        System.out.println(
                "Algorithm B: Monotonic Stack");

        System.out.println(
                "Result: " + Arrays.toString(resultB));

        System.out.println(
                "Time: " + timeB + " ns");

        System.out.println(
                "Operations: " + operationsB);

        // ==============================
        // Largest Rectangle
        // ==============================
        System.out.println();
        System.out.println(
                "Largest Rectangle: "
                + largestRectangle);

        // ==============================
        // เปรียบเทียบผลลัพธ์
        // ==============================
        System.out.println();

        if (Arrays.equals(resultA, resultB)) {

            System.out.println(
                    "Result comparison: PASS");

        } else {

            System.out.println(
                    "Result comparison: FAIL");
        }

        scanner.close();
    }
}