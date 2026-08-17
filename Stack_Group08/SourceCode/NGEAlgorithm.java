import java.util.Stack;

public class NGEAlgorithm {

    private long operationA;
    private long operationB;

    // ==============================
    // Algorithm A: Brute Force
    // ==============================
    public int[] bruteForceNGE(int[] heights) {

        operationA = 0;

        int n = heights.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            result[i] = -1;

            for (int j = i + 1; j < n; j++) {

                // เปรียบเทียบความสูง = 1 Operation
                operationA++;

                if (heights[j] > heights[i]) {
                    result[i] = heights[j];
                    break;
                }
            }
        }

        return result;
    }

    // ==============================
    // Algorithm B: Monotonic Stack
    // ==============================
    public int[] monotonicStackNGE(int[] heights) {

        operationB = 0;

        int n = heights.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            result[i] = -1;

            while (!stack.isEmpty()) {

                // เปรียบเทียบความสูง = 1 Operation
                operationB++;

                if (heights[i] > heights[stack.peek()]) {

                    // Pop = 1 Operation
                    int index = stack.pop();
                    operationB++;

                    result[index] = heights[i];

                } else {
                    break;
                }
            }

            // Push = 1 Operation
            stack.push(i);
            operationB++;
        }

        return result;
    }

    // ==============================
    // Largest Rectangle in Histogram
    // ==============================
    public int largestRectangle(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currentHeight;

            if (i == heights.length) {
                currentHeight = 0;
            } else {
                currentHeight = heights[i];
            }

            while (!stack.isEmpty()
                    && currentHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                int area = height * width;

                if (area > maxArea) {
                    maxArea = area;
                }
            }

            stack.push(i);
        }

        return maxArea;
    }

    // ==============================
    // Get Operation Count
    // ==============================
    public long getOperationA() {
        return operationA;
    }

    public long getOperationB() {
        return operationB;
    }
}