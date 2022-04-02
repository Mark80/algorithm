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
        while (storage[index] < parent(index - 1)) {
            swap(index, (index -1) / 2);
            index = (index -1) / 2;
        }

    }

    private int parent(int index) {
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
        while ( getLeftChild(current) < size) {
            int min = getMinChild(current);
            if (storage[current] > storage[min]) {
                swap(current, min);
                current = min;
            }
        }
    }

    public int getMinChild(int current) {
        int min = current;
        int leftChild = getLeftChild(current);
        int rightChild = getRightChild(current);
        if (rightChild <= size - 1) {
            if (storage[leftChild] > storage[rightChild]) {
                min = rightChild;
            } else {
                min = leftChild;
            }
        } else if (leftChild < size - 1) {
            min = leftChild;
        }
        return min;
    }

    private int getRightChild(int current) {
        return (2 * current) + 2;
    }

    private int getLeftChild(int current) {
        return (2 * current) + 1;
    }

    private void swap(int index1, int index2) {
        int tmp = storage[index2];
        storage[index2] = storage[index1];
        storage[index1] = tmp;
    }


    @Override
    public String toString() {
        return "Heap{" +
                "storage=" + Arrays.toString(Arrays.copyOfRange(storage, 0, size)) +
                '}';
    }
}
