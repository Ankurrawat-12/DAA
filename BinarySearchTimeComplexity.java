import java.util.Random;
import java.util.Scanner;

public class BinarySearchTimeComplexity {

    static void printArr(int arr[]){
        for(int i = 0 ; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }  
        System.out.println("");  
    }

    static void binarySearch(int arr[], int key){
        int s = 0;
        int e = arr.length - 1;
        long start = System.currentTimeMillis();
        while(s <= e){
            int mid = s + (e-s)/2;

            if(arr[mid] == key){
                long end = System.currentTimeMillis();
                long time = end - start;
                System.out.println("Time : " + time);
                // System.out.println(mid);
                
                return ;
            }
            else if(arr[mid] > key){
                e = mid - 1 ;
            }
            else{
                s = mid +1 ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array ");
        int size = sc.nextInt();
        int [] arr = new int[size];
        for(int i = 0; i<size; i++){
            arr[i] = i+1;
        }
        Random random = new Random();
        int randNo = random.nextInt(size);

        System.out.println("Best case : ");
        // printArr(arr);
        binarySearch(arr, (size/2)+1);

        System.out.println("Average case : ");
        // printArr(arr);
        binarySearch(arr, randNo);

        System.out.println("worst case : ");
        // printArr(arr);
        binarySearch(arr, 1);
        

        sc.close();
    }
}
