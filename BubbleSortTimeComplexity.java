import java.util.Random;
import java.util.Scanner;

class BubbleSortTimeComplexity {
    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void bubbleSort(int arr[]) {
        long begin = System.currentTimeMillis();
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
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
        int n;
        System.out.println("Enter length of array: ");
        Scanner obj = new Scanner(System.in);
        n = obj.nextInt();
        AverageCase avgArray = new AverageCase(n);
        BestCase bestArray = new BestCase(n);
        WorstCase worstArray = new WorstCase(n);
        bubbleSort(bestArray.arr);
        bubbleSort(avgArray.arr);
        bubbleSort(worstArray.arr);
    }
}
