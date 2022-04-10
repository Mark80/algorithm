package datastructure.sorting;

import datastructure.queue.UnsortedPQ;

import java.util.Arrays;

public class SortAlg {

    public static void main(String[] args) {
        int[] arr2 = new int[]{2, 6, 14, 1, 2, 3, 63, 2, 7, 74, 8, 5, 3, 78, 12};
        print(arr2);
        mergeSort(arr2, 0, arr2.length - 1);
        print(arr2);

        int[] arr = new int[]{2, 6, 14, 1, 5,3,6,4};
        print(quicksort(arr, 0 , 7));
    }

    static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static int[] insertionSort(int[] input) {
        if (input.length == 0) return input;
        for (int i = 1; i < input.length; i++) {
            int current = i;
            while (current > 0 && input[current] < input[current - 1]) {
                swap(input, current, current - 1);
                current--;
            }

        }
        return input;
    }

    private static void swap(int[] storage, int index1, int index2) {
        int tmp = storage[index2];
        storage[index2] = storage[index1];
        storage[index1] = tmp;
    }


    static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }

    static int[] merge(int[] arr, int low, int middle, int high) {
        UnsortedPQ lows = new UnsortedPQ();
        UnsortedPQ highs = new UnsortedPQ();

        for (int i = low; i <= middle; i++) { lows.insert(arr[i]);}
        for (int i = middle + 1 ; i <= high; i++) { highs.insert(arr[i]);}

        int newIndex = low;

        while (!lows.isEmpty() && !highs.isEmpty()) {
            if (lows.minimum() < highs.minimum()) {
                arr[newIndex] = lows.dequeue();
            } else {
                arr[newIndex] = highs.dequeue();
            }
            newIndex++;
        }

        while(!lows.isEmpty()){arr[newIndex++] = lows.dequeue();}
        while(!highs.isEmpty()){arr[newIndex++] = highs.dequeue();}

        return arr;
    }

    static int[] quicksort(int[] arr, int low, int high){
        if(high - low > 0) {
            int pivot = partition(arr, low, high);
            quicksort(arr, low, pivot -1);
            quicksort(arr, pivot + 1, high);
        }
        return arr;
    }


    static int partition(int[] arr, int low, int high) {
        int finalPivotIndex = low;

        for (int i = low; i < high; i++) {
            if(arr[high] > arr[i]){
                swap(arr, finalPivotIndex, i);
                finalPivotIndex++;
            }
        }

        swap(arr, finalPivotIndex, high);

        return finalPivotIndex;

    }

}
