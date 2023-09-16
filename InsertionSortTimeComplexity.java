
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
        System.out.println("Time : " + time);

    }

    static void bestCase (int size , int arr[]){
        for(int i = 0; i<size; i++ ){
            arr[i] = i;
        } 
    }

    static void worstCase(int size , int arr[]){
        for (int i = size - 1; i >= 0; i--) {
            arr[i] = size - i;
        }
    }

    static void averageCase(int arr[], int size){
        Random rand = new Random();
        for(int i=0; i<size; i++){
            arr[i] = rand.nextInt(size);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int size = sc.nextInt();
        sc.close();
        int [] arr = new int[size];

        System.out.println("Worst case");
        worstCase(size, arr);
        // printArr(arr);
        insertionSort(arr);
        // printArr(arr);
        
        System.out.println("Best case");
        bestCase(size, arr);
        // printArr(arr);
        insertionSort(arr);
        // printArr(arr);
        
        System.out.println("Average case");
        averageCase(arr, size);
        // printArr(arr);
        insertionSort(arr);
        // printArr(arr);
        
    }
}
