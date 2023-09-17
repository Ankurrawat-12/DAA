
import java.util.Random;
import java.util.Scanner;

public class InsertionSortTimeComplexity {

    static void printArr(int arr[]){
        for(int i = 0 ; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }  
        System.out.println("");  
    }


    static void insertionSort( int arr[]){
        long start = System.currentTimeMillis();
        for(int i=1; i<arr.length; i++){
            int j = i -1 ;
            int temp = arr[i];
            while(j>=0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        long end = System.currentTimeMillis();
        long time = end - start;
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
        insertionSort(bestArray.arr);
        insertionSort(avgArray.arr);
        insertionSort(worstArray.arr);
    }
}
