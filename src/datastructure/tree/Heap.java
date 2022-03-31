package datastructure.tree;

import java.util.Arrays;

public class Heap {

    int[] storage;
    int size = 0;

    public Heap(int n ){
        storage = new int[n];
    }

    public void insert(int value) {
        storage[size++] = value;

        int index = size - 1;
        while(storage[index] < parent(index)){
            swap(value,index);
            index = index / 2;
        }

    }

    private void swap(int value, int index){
        int tmp = storage[index / 2];
        storage[index / 2] = value;
        storage[index] = tmp;
    }

    private Integer parent(int index) {
        return storage[index / 2];
    }


    @Override
    public String toString() {
        return "Heap{" +
                "storage=" + Arrays.toString(storage) +
                '}';
    }
}
