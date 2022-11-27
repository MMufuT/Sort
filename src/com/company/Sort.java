package com.company;
import java.util.Arrays;
public class Sort {

    //Time Complexity: O(n^2)
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int hole = i; //hole is the index which will help us iterate backwards through the array to sort
            int currVal = arr[i]; //currVal is the current value in the array we're evaluating
            while (hole > 0 && currVal > arr[hole-1]){ //if value at hole index is less than the value before,
                arr[hole] = arr[hole-1];                 //the value before the hole index is copied to the hole index value
                hole--; //hole index is decremented by 1, so the value to the left is now compared in the next while loop
            }
            arr[hole] = currVal; //whenever the value at the hole is greater than the value before, we found the right
        }                        //position for the current value and will place the value at the index we found
    }

    public void merge(int[] left, int[] right, int[] main){
        int i = 0; //left array index
        int j = 0; //right array index
        int k = 0; //main array index
        int nL = left.length;
        int nR = right.length;
        while (i < nL && j < nR) { //while loop to compare elements in left and right sub arrays
            if (left[i] >= right[j]) {
                main[k] = left[i];
                i++;
                k++;
            }
            else{
                main[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < nL){ //in case there are remaining elements in left sub array (right sub array is fully indexed)
            main[k] = left[i];
            i++;
            k++;
        }
        while (j < nR){ //in case there are remaining elements in right sub array (left sub array is fully indexed)
            main[k] = right[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int[] arr){
        int arrL = arr.length;
        int mid  = arrL/2;
        if (arrL < 2)
            return;
        int[] left = new int[mid];
        int[] right = new int[arrL-mid];
        for (int i = 0; i < mid; i++)
            left[i] = arr[i];
        int j = 0;
        for (int i = mid; i < arrL; i++) {
            right[j] = arr[i];
            j++;
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    public void bubbleSort(int[] arr){

    }

    public static void main(String[] args) {
        int[] arr = {1000, 6, 1, 11, 3,423, 34, 342, 44, 25, 2, 4, 5, 6, 33};
        Sort srt = new Sort();

        srt.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
