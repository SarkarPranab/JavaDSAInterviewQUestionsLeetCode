package BasicSorts;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public static void BubbleSort(int Array[]){
        for (int i = Array.length-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(Array[j]>Array[j+1]){
                    int temp = Array[j];
                    Array[j] = Array[j+1];
                    Array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {4,2,6,5,1,3};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
