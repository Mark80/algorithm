package datastructure.sorting;

import java.util.Arrays;

public class SortAlg {


    public static void main(String[] args) {

        int[] arr = new int[]{3, 4, 5, 6, 7, 2, 8, 9, 10, 11};

        int low = 0;
        int middle = (arr.length - 1) / 2;
        int high = arr.length - 1;
        print(merge(arr, low, middle, high));

        int[] arr2 = new int[]{2, 6, 4, 1, 2, 8, 5, 3, 78, 12};
        print(arr2);
        mergeSort(arr2, 0, arr2.length - 1);
        print(arr2);


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


    static void fillArray(int[] a, int[] input, int low, int high) {
        for (int i = 0; i <= high - low; i++) {
            a[i] = input[low + i];
        }
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
        int[] a = new int[middle - low + 1];
        int[] b = new int[high - middle];
        fillArray(a, arr, low, middle);
        fillArray(b, arr, middle + 1, high);

        int index_a = 0;
        int index_b = 0;
        int new_index = low;

        while (index_a < a.length && index_b < b.length) {
            if (a[index_a] < b[index_b]) {
                arr[new_index] = a[index_a];
                index_a++;
            } else {
                arr[new_index] = b[index_b];
                index_b++;
            }
            new_index++;
        }

        new_index = fillTheRest(index_a, a, arr, new_index);
        fillTheRest(index_b, b, arr, new_index);

        return arr;

    }

    private static int fillTheRest(int index_a, int[] a, int[] r, int new_index) {
        for (int i = index_a; i < a.length; i++) {
            r[new_index] = a[i];
            new_index++;
        }

        return new_index;
    }

}
