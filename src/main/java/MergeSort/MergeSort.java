package MergeSort;

import java.util.Arrays;

public class MergeSort {
    public static int[] merge(int[] array1, int[] array2) {
        /*
        * int[] array1 = {1, 3, 7, 8};
        int[] array2 = {2, 4, 5, 6};
        * */
        int[] combined = new int[array1.length + array2.length]; // combined [8]
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            /**
             combined
             * i=0, j=0 -> 1 < 2 -> [1]
             * i=1, j=0 -> 3 < 2 -> [1,2]
             * i=1, j=1 -> 3 < 4 -> [1,2,3]
             * i=2, j=1 -> 7 < 4 -> [1,2,3,4]
             * i=2, j=2 -> 7 < 5 -> [1,2,3,4,5]
             * i=2, j=3 -> 7 < 6 -> [1,2,3,4,5,6]
             * as per while loop condition while loop will break here
             * */
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                index++;
                i++;
            } else {
                combined[index] = array2[j];
                index++;
                j++;
            }
        }
        /**
         * From above out last value of i was 2
         * so combined array will add 7, 8
         * combined = [1,2,3,4,5,6,7,8]
         */
        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }
        /**
         * From above out last value of j was 3
         * as j don't have any other data to add final
         * combined = [1,2,3,4,5,6,7,8]
         */
        while (j < array2.length) {
            combined[index] = array2[j];
            index++;
            j++;
        }
        return combined;
    }

    /**
     * Merge Sort
     * */
    public static int[] mergeSort(int[] arr){
        if(arr.length == 1) return arr;
        int midIndex = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,midIndex);
        int[] right = Arrays.copyOfRange(arr,midIndex,arr.length);
        return merge(left,right);
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 8, 2, 4, 5, 6};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
}
