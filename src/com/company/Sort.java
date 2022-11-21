package com.company;
import java.util.Arrays;
public class Sort {

    public void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int hole = i; //hole is the index which will help us iterate backwards through the array to sort
            int currVal = arr[i]; //currVal is the current value in the array we're evaluating
            while (hole > 0 && currVal < arr[hole-1]){ //if value at hole index is less than the value before,
                arr[hole] = arr[hole-1];                 //the value before the hole index is copied to the hole index value
                hole--; //hole index is decremented by 1, so the value to the left is now compared in the next while loop
            }
            arr[hole] = currVal; //whenever the value at the hole is greater than the value before, we found the right
        }                        //position for the current value and will place the value at the index we found
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 1, 11, 3,423, 34, 342, 44, 25, 2, 4, 5, 6, 33};
        Sort srt = new Sort();
        srt.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
