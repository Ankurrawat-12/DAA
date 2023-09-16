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
                System.out.println("time : " + time);
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

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array ");
        int size = sc.nextInt();
        int [] arr = new int[size];
        for(int i = 0; i<size; i++){
            arr[i] = i;
        }


        System.out.println("Best case : ");
        bestCase(arr, -1);
        // printArr(arr);
        linearSearch(arr, -1);

        System.out.println("Average case : ");
        averageCase(arr, -1);
        // printArr(arr);
        linearSearch(arr, -1);

        System.out.println("worst case : ");
        worstCase(arr, -1);
        // printArr(arr);
        linearSearch(arr, -1);
        
        sc.close();
        
    }
}
