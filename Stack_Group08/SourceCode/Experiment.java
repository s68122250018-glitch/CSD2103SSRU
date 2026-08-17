import java.util.Arrays;
import java.util.Random;

public class Experiment {

    public static void main(String[] args) {

        NGEAlgorithm algorithm = new NGEAlgorithm();

        int[] sizes = {
            10,
            100,
            1000,
            5000,
            10000
        };

        int numberOfRounds = 5;

        System.out.println("==============================================================");
        System.out.println("             NGE ALGORITHM EXPERIMENT");
        System.out.println("             5 ROUNDS PER DATA SIZE");
        System.out.println("==============================================================");

        System.out.println();

        for (int n : sizes) {

            // สร้างข้อมูลแบบสุ่ม
            int[] heights = generateRandomData(n);

            // ==============================
            // Warm-up
            // ==============================
            for (int i = 0; i < 3; i++) {
                algorithm.bruteForceNGE(heights);
                algorithm.monotonicStackNGE(heights);
            }

            long totalTimeA = 0;
            long totalTimeB = 0;

            long operationsA = 0;
            long operationsB = 0;

            int[] resultA = null;
            int[] resultB = null;

            // ==============================
            // ทดลอง 5 รอบ
            // ==============================
            for (int round = 1; round <= numberOfRounds; round++) {

                // Algorithm A
                long startA = System.nanoTime();

                resultA = algorithm.bruteForceNGE(heights);

                long endA = System.nanoTime();

                totalTimeA += (endA - startA);

                operationsA = algorithm.getOperationA();

                // Algorithm B
                long startB = System.nanoTime();

                resultB = algorithm.monotonicStackNGE(heights);

                long endB = System.nanoTime();

                totalTimeB += (endB - startB);

                operationsB = algorithm.getOperationB();
            }

            // ==============================
            // ค่าเฉลี่ยเวลา
            // ==============================
            long averageTimeA =
                    totalTimeA / numberOfRounds;

            long averageTimeB =
                    totalTimeB / numberOfRounds;

            // ==============================
            // ตรวจสอบผลลัพธ์
            // ==============================
            boolean sameResult =
                    Arrays.equals(resultA, resultB);

            // ==============================
            // แสดงผล
            // ==============================
            System.out.println("n = " + n);

            System.out.println(
                    "Algorithm A Average Time: "
                    + averageTimeA + " ns"
            );

            System.out.println(
                    "Algorithm A Operations: "
                    + operationsA
            );

            System.out.println(
                    "Algorithm B Average Time: "
                    + averageTimeB + " ns"
            );

            System.out.println(
                    "Algorithm B Operations: "
                    + operationsB
            );

            System.out.println(
                    "Result Comparison: "
                    + (sameResult ? "PASS" : "FAIL")
            );

            System.out.println();
        }

        System.out.println("==============================================================");
        System.out.println("Experiment completed.");
        System.out.println("==============================================================");
    }

    // ==========================================
    // สร้างข้อมูลสุ่ม
    // ==========================================
    private static int[] generateRandomData(int n) {

        Random random = new Random(42);

        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {

            heights[i] =
                    random.nextInt(1000) + 1;
        }

        return heights;
    }
}