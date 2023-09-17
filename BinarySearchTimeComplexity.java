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
                System.out.print(time + " ");
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

    static class ArrayGenerator {
        int[] arr;
        ArrayGenerator(int n) {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of array :-  ");
        int size = scanner.nextInt();

        scanner.close();

        ArrayGenerator array = new ArrayGenerator(size);
        Random random = new Random();
        int randNo = random.nextInt(size);

        binarySearch(array.arr, (size/2)+1);
        binarySearch(array.arr, randNo);
        binarySearch(array.arr, size - 1);
    }
}
