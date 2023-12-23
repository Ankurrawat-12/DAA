import java.util.ArrayList;
import java.util.List;
public class StringMatchingAlgorithms {
    public static class NaiveStringMatchingResult {
        public List<Integer> occurrences;
        public String elapsedTime;
        public NaiveStringMatchingResult(List<Integer> occurrences, String elapsedTime) {
            this.occurrences = occurrences;
            this.elapsedTime = elapsedTime;
        }
    }
    public static NaiveStringMatchingResult naiveStringMatching(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <= n - m; i++) {
            if (text.substring(i, i + m).equals(pattern)) {
                occurrences.add(i);
            }
        }
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime - startTime) / 1000.0;
        return new NaiveStringMatchingResult(occurrences, String.format("%.6f", elapsedTime));
    }
    public static class RabinKarpResult {
        public List<Integer> occurrences;
        public String elapsedTime;
        public RabinKarpResult(List<Integer> occurrences, String elapsedTime) {
            this.occurrences = occurrences;
            this.elapsedTime = elapsedTime;
        }
    }
    public static RabinKarpResult rabinKarp(String text, String pattern, int d, int q) {
        List<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        long startTime = System.currentTimeMillis();
        int hPattern = 0;
        int hWindow = 0;
        for (int i = 0; i < m; i++) {
            hPattern = (hPattern * d + pattern.charAt(i)) % q;
            hWindow = (hWindow * d + text.charAt(i)) % q;
        }
        for (int i = 0; i <= n - m; i++) {
            if (hPattern == hWindow && text.substring(i, i + m).equals(pattern)) {
                occurrences.add(i);
            }
            if (i < n - m) {
                hWindow = (d * (hWindow - text.charAt(i) * pow(d, m - 1)) + text.charAt(i + m)) % q;
                if (hWindow < 0) {
                    hWindow += q;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime - startTime) / 1000.0;
        return new RabinKarpResult(occurrences, String.format("%.6f", elapsedTime));
    }
    public static int[] computePrefixFunction(String pattern) {
        int m = pattern.length();
        int[] pi = new int[m];
        int k = 0;
        for (int q = 1; q < m; q++) {
            while (k > 0 && pattern.charAt(k) != pattern.charAt(q)) {
                k = pi[k - 1];
            }
            if (pattern.charAt(k) == pattern.charAt(q)) {
                k++;
            }
            pi[q] = k;
        }
        return pi;
    }
    public static class KnuthMorrisPrattResult {
        public List<Integer> occurrences;
        public String elapsedTime;
        public KnuthMorrisPrattResult(List<Integer> occurrences, String elapsedTime) {
            this.occurrences = occurrences;
            this.elapsedTime = elapsedTime;
        }
    }
    public static KnuthMorrisPrattResult knuthMorrisPratt(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        long startTime = System.currentTimeMillis();
        int[] pi = computePrefixFunction(pattern);
        int q = 0;
        for (int i = 0; i < n; i++) {
            while (q > 0 && pattern.charAt(q) != text.charAt(i)) {
                q = pi[q - 1];
            }
            if (pattern.charAt(q) == text.charAt(i)) {
                q++;
            }
            if (q == m) {
                occurrences.add(i - m + 1);
                q = pi[q - 1];
            }
        }
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime - startTime) / 1000.0;
        return new KnuthMorrisPrattResult(occurrences, String.format("%.6f", elapsedTime));
    }
    public static void main(String[] args) {
        String textBest = "TodayIsTheBestDayToCodeBecauseItIsRaining";
        String patternBest = "BestDayToCode";
        String textWorst = "RepetitionRepetitionRepetitionRepetitionRepetition";
        String patternWorst = "PatternPatternPattern";
        String textAverage = "FindingMeaningfulStringsForStringMatchingCanBeChallengingButItIsImportant";
        String patternAverage = "MeaningfulStringsForStringMatching";
        NaiveStringMatchingResult naiveResultBest = naiveStringMatching(textBest, patternBest);
        NaiveStringMatchingResult naiveResultWorst = naiveStringMatching(textWorst, patternWorst);
        NaiveStringMatchingResult naiveResultAverage = naiveStringMatching(textAverage, patternAverage);
        System.out.println("Naive String Matching:");
        System.out.println("Best Case - Occurrences: " + naiveResultBest.occurrences);
        System.out.println("Best Case - Time taken: " + naiveResultBest.elapsedTime + " seconds");
        System.out.println("Worst Case - Occurrences: " + naiveResultWorst.occurrences);
        System.out.println("Worst Case - Time taken: " + naiveResultWorst.elapsedTime + " seconds");
        System.out.println("Average Case - Occurrences: " + naiveResultAverage.occurrences);
        System.out.println("Average Case - Time taken: " + naiveResultAverage.elapsedTime + " seconds\n");
        RabinKarpResult rabinKarpResultBest = rabinKarp(textBest, patternBest, 256, 101);
        RabinKarpResult rabinKarpResultWorst = rabinKarp(textWorst, patternWorst, 256, 101);
        RabinKarpResult rabinKarpResultAverage = rabinKarp(textAverage, patternAverage, 256, 101);
        System.out.println("Rabin-Karp Algorithm:");
        System.out.println("Best Case - Occurrences: " + rabinKarpResultBest.occurrences);
        System.out.println("Best Case - Time taken: " + rabinKarpResultBest.elapsedTime + " seconds");
        System.out.println("Worst Case - Occurrences: " + rabinKarpResultWorst.occurrences);
        System.out.println("Worst Case - Time taken: " + rabinKarpResultWorst.elapsedTime + " seconds");
        System.out.println("Average Case - Occurrences: " + rabinKarpResultAverage.occurrences);
        System.out.println("Average Case - Time taken: " + rabinKarpResultAverage.elapsedTime + " seconds\n");
        KnuthMorrisPrattResult kmpResultBest = knuthMorrisPratt(textBest, patternBest);
        KnuthMorrisPrattResult kmpResultWorst = knuthMorrisPratt(textWorst, patternWorst);
        KnuthMorrisPrattResult kmpResultAverage = knuthMorrisPratt(textAverage, patternAverage);
        System.out.println("Knuth-Morris-Pratt Algorithm:");
        System.out.println("Best Case - Occurrences: " + kmpResultBest.occurrences);
        System.out.println("Best Case - Time taken: " + kmpResultBest.elapsedTime + " seconds");
        System.out.println("Worst Case - Occurrences: " + kmpResultWorst.occurrences);
        System.out.println("Worst Case - Time taken: " + kmpResultWorst.elapsedTime + " seconds");
        System.out.println("Average Case - Occurrences: " + kmpResultAverage.occurrences);
        System.out.println("Average Case - Time taken: " + kmpResultAverage.elapsedTime + " seconds");
    }
    private static int pow(int d, int e) {
        int result = 1;
        for (int i = 0; i < e; i++) {
            result *= d;
        }
        return result;
}
}
