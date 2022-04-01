package datastructure.tree;

import java.util.Arrays;

public class Heap {

    int[] storage;
    int size = 0;

    public Heap(int n) {
        storage = new int[n];
    }

    public void insert(int value) {
        storage[size++] = value;

        int index = size - 1;
        while (storage[index] < parent(index)) {
            swap(index, index / 2);
            index = index / 2;
        }

    }

    private void swap(int index1, int index2) {
        int tmp = storage[index2];
        storage[index2] = storage[index1];
        storage[index1] = tmp;
    }

    private Integer parent(int index) {
        return storage[index / 2];
    }

    public void deleteMinimum() {
        storage[0] = storage[size - 1];
        storage[size - 1] = 0;
        size--;
        moveDown();
    }

    private void moveDown() {
        int current = 0;
        while (current < size - 1) {
            int min = getMinIndex(current);
            if (storage[current] > storage[min]) {
                swap(current, min);
                current = min;
            }

        }
    }

    private int getMinIndex(int current) {
        int min;
        if (current + 1 == size - 1 || storage[current + 1] < storage[current + 2]) {
            min = current + 1;
        } else {
            min = current + 2;
        }
        return min;
    }


    @Override
    public String toString() {
        return "Heap{" +
                "storage=" + Arrays.toString(Arrays.copyOfRange(storage, 0, size)) +
                '}';
    }
}
