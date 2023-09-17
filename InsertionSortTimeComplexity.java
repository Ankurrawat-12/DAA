
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
        int n;
        System.out.println("Enter length of array: ");
        Scanner obj = new Scanner(System.in);
        n = obj.nextInt();
        AverageCase avgArray = new AverageCase(n);
        BestCase bestArray = new BestCase(n);
        WorstCase worstArray = new WorstCase(n);
        insertionSort(bestArray.arr);
        insertionSort(avgArray.arr);
        insertionSort(worstArray.arr);
    }
}
