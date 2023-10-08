import java.util.Random;
import java.util.Scanner;

public class MergeSortTimeComplexity {
    
    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void merge(int arr[],int s,int e){
        int mid = (s+e)/2;
    
        int len1 = mid - s +1;
        int len2 = e- mid;

        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];
        int ind = s;
        for(int i=0;i<len1;i++){
            arr1[i] = arr[ind++];
        }
        ind = mid+1;
        for(int i=0;i<len2;i++){
            arr2[i] = arr[ind++];
        }

        int index1=0;
        int index2=0;
        ind = s;

        while(index1 < len1 && index2<len2){
            if(arr1[index1] > arr2[index2]){
                arr[ind++] = arr2[index2++];
            }
            else{
                arr[ind++] = arr1[index1++];
            }
        }

        while (index1<len1)
        {
            arr[ind++] = arr1[index1++];
        }
        while (index2<len2)
        {
            arr[ind++] = arr2[index2++];
        }
    }

    static void mergeSort(int arr[] ,int s, int e){
        if(s >= e){
            return;
        }  

        int mid = (s+e)/2;

        mergeSort(arr, s, mid);

        mergeSort(arr, mid+1, e);

        merge(arr,s,e);

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
        // int[] arr = {1,2,3,4,5,6,7,8,9,10};

        // mergeSort(arr, 0, 9);
        // print(arr);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int n = sc.nextInt();
        AverageCase avgArray = new AverageCase(n);
        BestCase bestArray = new BestCase(n);
        WorstCase worstArray = new WorstCase(n);
        
        //Best case
        long start = System.currentTimeMillis();
        mergeSort(bestArray.arr, 0, n-1);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.print(time + " ");

        // Average case
        start = System.currentTimeMillis();
        mergeSort(avgArray.arr, 0, n-1);
        end = System.currentTimeMillis();
        time = end - start;
        System.out.print(time + " ");

        // worst case
        start = System.currentTimeMillis();
        mergeSort(worstArray.arr, 0, n-1);
        end = System.currentTimeMillis();
        time = end - start;
        System.out.print(time + " ");

        sc.close();
        // print(bestArray.arr);


        // print(arr);
    }

}
