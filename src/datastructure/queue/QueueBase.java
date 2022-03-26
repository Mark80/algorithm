package datastructure.queue;

public abstract class QueueBase {

     int indexMinimum = 0;
     int indexLast = -1;
     int[] storage = new int[1];

    abstract void insert(int value);
    abstract int minimum();
    abstract void deleteMinimum();


    void doubleStorageSize() {
        int[] newStorage = new int[storage.length * 2];
        System.arraycopy(storage, 0, newStorage, 0, storage.length);
        storage = newStorage;
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
