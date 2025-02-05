package QuickSorts;

import java.util.Arrays;

public class QuickSorts {
    // Method to swap two elements in array
    public static void swap(int[] arr, int swapFromIndex, int swapToIndex){
        int temp = arr[swapFromIndex];
        arr[swapFromIndex] = arr[swapToIndex];
        arr[swapToIndex] = temp;
    }

    // Pivot
    public static int pivot(int[] arr, int pivotIndex, int endIndex){
        int swapIndex = pivotIndex;
        for(int i = pivotIndex + 1; i <= endIndex; i++){
            if(arr[i] < arr[pivotIndex]){
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }
        swap(arr, pivotIndex, swapIndex);
        return swapIndex;
    }

    // Quick sort helper
    public static void quickSortHelper(int[] arr, int left, int right){
        if(left < right){
            int pivotIndex = pivot(arr, left, right);
            quickSortHelper(arr, left, pivotIndex-1);
            quickSortHelper(arr,pivotIndex+1, right);
        }
    }

    //Quick sort
    public static void quickSort(int[] arr){
        quickSortHelper(arr, 0, arr.length-1);
    }
    public static void main(String[] args){
        int[] arr = {4,6,1,7,3,2,5};
        /**
        int returnedIndex = pivot(arr,0,6);
        System.out.println("Returned Index : "+ returnedIndex);
        System.out.println(Arrays.toString(arr));
         */
        quickSort(arr);
        System.out.println("[+] After Quick Sort : "+ Arrays.toString(arr));
    }
}
