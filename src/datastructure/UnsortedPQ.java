package datastructure;

public class UnsortedPQ {

    private int indexMinimum = 0;
    private int indexLast = -1;
    private int[] storage = new int[2];


    public void insert(int value) {
        indexLast++;
        if (indexLast > storage.length - 1) {
            doubleStorageSize();
        }
        storage[indexLast] = value;
        if (value < storage[indexMinimum]) {
            indexMinimum = indexLast;
        }
    }

    private void doubleStorageSize() {
        int[] newStorage = new int[storage.length * 2];
        System.arraycopy(storage, 0, newStorage, 0, storage.length);
        storage = newStorage;
    }

    public int minimum() {
        return storage[indexMinimum];
    }

    public void deleteMinimum() {
        storage[indexMinimum] = storage[indexLast];
        indexLast--;
    }

    @Override
    public String toString() {
        StringBuilder arr = new StringBuilder();
        for (int i = 0; i <= indexLast; i++) {
            arr.append(storage[i]).append(" ");
        }

        return "UnsortedPQ{" +
                "storage=" + arr +
                '}';
    }
}
