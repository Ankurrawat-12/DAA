import java.util.Random;
import java.util.Scanner;

public class QuickSortTimeComplexity {

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static class BestCase {
        int[] arr;

        BestCase(int n) {
            arr = new int[n];
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(n);
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
        int[] arr;

        AverageCase(int n) {
            arr = new int[n];
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(n);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int n = sc.nextInt();
        AverageCase avgArray = new AverageCase(n);
        BestCase bestArray = new BestCase(n);
        WorstCase worstArray = new WorstCase(n);

        // Best case
        long start = System.currentTimeMillis();
        quickSort(bestArray.arr, 0, n - 1);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.print( time + " ");

        // Average case
        start = System.currentTimeMillis();
        quickSort(avgArray.arr, 0, n - 1);
        end = System.currentTimeMillis();
        time = end - start;
        System.out.print(time + " ");

        // Worst case
        start = System.currentTimeMillis();
        quickSort(worstArray.arr, 0, n - 1);
        end = System.currentTimeMillis();
        time = end - start;
        System.out.print(time + " ");

        sc.close();
    }
}

