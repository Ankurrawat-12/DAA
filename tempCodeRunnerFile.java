public class LongestCommonSubsequence {
    public static char[] longestCommonSubsequence(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] lcsTable = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    lcsTable[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lcsTable[i][j] = lcsTable[i - 1][j - 1] + 1;
                } else {
                    lcsTable[i][j] = Math.max(lcsTable[i - 1][j], lcsTable[i][j - 1]);
                }
            }
        }
        char[] lcs = new char[lcsTable[m][n]];
        int i = m, j = n, index = lcs.length - 1;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs[index] = X.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (lcsTable[i - 1][j] > lcsTable[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return lcs;
    }
    public static void main(String[] args) {
        String XBest = "ANKURRAWAT";
        String YBest = "AKRRAT";
        String XWorst = "OCALMMEOCA";
        String YWorst = "XYZ";
        String XAverage = "ANKJ";
        String YAverage = "XLKQYJ";
        long startBest = System.currentTimeMillis();
        char[] resultBest = longestCommonSubsequence(XBest, YBest);
        long endBest = System.currentTimeMillis();
        String timeBest = String.format("%.6f", (endBest - startBest) / 1000.0);
        String resultStringBest = resultBest.length == 0 ? "Non common subsequence" : new String(resultBest);
        System.out.println("Best Case:");
        System.out.println("Longest Common Subsequence: " + resultStringBest);
        System.out.println("Time taken: " + timeBest + "\n");
        long startWorst = System.currentTimeMillis();
        char[] resultWorst = longestCommonSubsequence(XWorst, YWorst);
        long endWorst = System.currentTimeMillis();
        String timeWorst = String.format("%.6f", (endWorst - startWorst) / 1000.0);
        String resultStringWorst = resultWorst.length == 0 ? "Non common subsequence" : new String(resultWorst);
        System.out.println("Worst Case:");
        System.out.println("Longest Common Subsequence: " + resultStringWorst);
        System.out.println("Time taken: " + timeWorst + "\n");
        long startAverage = System.currentTimeMillis();
        char[] resultAverage = longestCommonSubsequence(XAverage, YAverage);
        long endAverage = System.currentTimeMillis();
        String timeAverage = String.format("%.6f", (endAverage - startAverage) / 1000.0);
        String resultStringAverage = resultAverage.length == 0 ? "Non common subsequence" : new String(resultAverage);
        System.out.println("Average Case:");
        System.out.println("Longest Common Subsequence: " + resultStringAverage);
        System.out.println("Time taken: " + timeAverage + "\n");
    }
}
