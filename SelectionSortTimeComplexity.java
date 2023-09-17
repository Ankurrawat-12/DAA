import java.util.Random;
import java.util.Scanner;

class SelectionSortTimeComplexity {
    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void selectionSort(int arr[]) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.print(time + " ");
    }

    static class BestCase {
        int[] arr;
        BestCase(int n) {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
        }
    }

    static class WorstCase {
        int[] arr;
        WorstCase(int n) {
            arr = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                arr[i] = n - i;
            }
        }
    }

    static class AverageCase {
        private int[] arr;
        AverageCase(int n) {
            arr = new int[n];
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(n);
            }
        }
    }

    public static void main(String[] args) {
        int size;
        System.out.print("Enter length of array :- ");
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        scanner.close();
        AverageCase avgArray = new AverageCase(size);
        BestCase bestArray = new BestCase(size);
        WorstCase worstArray = new WorstCase(size);
        selectionSort(bestArray.arr);
        selectionSort(avgArray.arr);
        selectionSort(worstArray.arr);
    }
}