package datastructure.queue;

public class SortedPQ extends QueueBase{


    public void insert(int value) {
        indexLast++;
        if(indexLast >= storage.length - 1){
            doubleStorageSize();
        }
        int index = findIndexWhereInsert(value);
        System.arraycopy(storage, index, storage, index + 1, indexLast - index);
        storage[index] = value;
    }

    private int findIndexWhereInsert(int value) {
        int index = 0;
        while (value < storage[index] && index < indexLast){
            index++;
        }
        return index;
    }

    public int minimum() {
        return storage[indexLast];
    }

    public void deleteMinimum() {
          indexLast--;
    }
}
