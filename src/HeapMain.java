import datastructure.tree.Heap;

public class HeapMain {

    public static void main(String[] args) {
        Heap heap = new Heap(5);

        heap.insert(1);
        heap.insert(4);
        heap.insert(5);
        heap.insert(3);
        heap.insert(2);

        System.out.println(heap);

        heap.deleteMinimum();
        heap.deleteMinimum();
        System.out.println(heap);


    }

}
