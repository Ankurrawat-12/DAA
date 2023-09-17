import java.util.Random;
import java.util.Scanner;

public class LinearSearchTimeComplexity {

    static void printArr(int arr[]){
        for(int i = 0 ; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }  
        System.out.println("");  
    }

    static void linearSearch(int arr[],int key){
        long start = System.currentTimeMillis();
        for(int i=0 ; i<arr.length; i++){
            if(arr[i] == key){
                long end = System.currentTimeMillis();
                long time = end - start;
                System.out.print(time + " ");
                arr[i] = 0;
                return ;
            }
        }
    }

    static void bestCase(int arr[],int key){
        arr[0] = key;
    }

    static void averageCase(int arr[], int key){
        int n = arr.length;
        Random random = new Random();
        int randNo = random.nextInt(n);

        arr[randNo] = key;
    }

    static void worstCase(int arr[],int key){
        arr[arr.length - 1] = key;
    }

    static class BestCase {
        int[] array;
        BestCase(int[] arr, int key) {
            array = arr;
            array[0] = key;
        }
    }

    static class WorstCase {
        int[] array;
        WorstCase(int[] arr, int key) {
            array = arr;
            array[arr.length / 2] = key;
        }
    }

    static class AverageCase {
        int[] array;
        AverageCase(int[] arr, int key) {
            Random random = new Random();
            int randomIndex = random.nextInt(arr.length);
            array = arr;
            array[randomIndex] = key;
        }
    }

    static class ArrayGenerator {
        int[] arr;
        ArrayGenerator(int n) {
            arr = new int[n];
            for (int i = 1; i < n; i++) {
                arr[i] = i;
            }
        }
    }

    public static void main(String[] args) {
        int key = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of array :-  ");
        int size = scanner.nextInt();

        scanner.close();

        ArrayGenerator array = new ArrayGenerator(size);
        BestCase bestCase = new BestCase(array.arr, key);
        AverageCase averageCase = new AverageCase(array.arr, key);
        WorstCase worstCase = new WorstCase(array.arr, key);

        linearSearch(bestCase.array, key);
        linearSearch(averageCase.array, key);
        linearSearch(worstCase.array, key);
    }
}