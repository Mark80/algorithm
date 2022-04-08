package datastructure.queue;

public class UnsortedPQ extends QueueBase {

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

    public int minimum() {
        return storage[indexMinimum];
    }

    public int dequeue(){
        int min = minimum();
        deleteMinimum();
        return min;
    }

    public void deleteMinimum() {
        if(indexLast < 0) throw new IllegalStateException("Delete on empty queue");
        storage[indexMinimum] = storage[indexLast];
        indexLast--;
        setNewMinimum();
    }

    private void setNewMinimum() {
        int value = storage[0];
        indexMinimum = 0;
        for (int i = 0; i <= indexLast; i++) {
            if (storage[i] < value) {
                indexMinimum = i;
                value = storage[i];
            }
        }
    }

}
