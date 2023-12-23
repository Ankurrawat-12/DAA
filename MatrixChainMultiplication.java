import java.util.Arrays;
public class MatrixChainMultiplication {
    public static void matrixChainMultiplication(int[] p) {
        int n = p.length - 1;
        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];
        for (int length = 2; length <= n; length++) {
            for (int i = 1; i <= n - length + 1; i++) {
                int j = i + length - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        s[i][j] = k;
                    }
                }
            }
        }
        printOptimalParentheses(s, 1, n);
    }
    public static void printOptimalParentheses(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimalParentheses(s, i, s[i][j]);
            printOptimalParentheses(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
    public static void runExperiment(int[] matrixDimensions) {
        long startTime = System.currentTimeMillis();
        matrixChainMultiplication(matrixDimensions);
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime - startTime) / 1000.0;
        System.out.println("Matrix Dimensions: " + Arrays.toString(matrixDimensions));
        System.out.println("Time taken: " + String.format("%.6f", elapsedTime) + "\n");
    }
    public static void main(String[] args) {
        runExperiment(new int[]{30, 35, 15, 5, 10, 20, 25});
        runExperiment(new int[]{10, 20, 30, 40, 30});
        runExperiment(new int[]{5, 10, 3, 12, 5, 50, 6});
    }
}
