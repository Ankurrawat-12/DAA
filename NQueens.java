public class NQueens {
    public static boolean isSafe(int[][] board, int row, int col, int n) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    public static boolean solveNQueensUtil(int[][] board, int col, int n) {
        if (col >= n) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 1;
                if (solveNQueensUtil(board, col + 1, n)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }
    public static void solveNQueens(int n) {
        int[][] board = new int[n][n];
        if (!solveNQueensUtil(board, 0, n)) {
            System.out.println("Solution does not exist");
            return;
        }
}
    public static void main(String[] args) {
        int[] queens = {4, 6, 8, 16};
        double[] times = new double[queens.length];
        for (int i = 0; i < queens.length; i++) {
            long startTime = System.currentTimeMillis();
            solveNQueens(queens[i]);
            long endTime = System.currentTimeMillis();
            times[i] = (endTime - startTime) / 1000.0;
        }
        System.out.println("Number of queens         Time taken");
        for (int i = 0; i < queens.length; i++) {
            System.out.printf("%d                          %.6f%n", queens[i], times[i]);
        }
    }
}