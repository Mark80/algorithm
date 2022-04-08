import datastructure.tree.Heap;

public class HeapMain {

    public static void main(String[] args) {
        Heap heap = new Heap(8);

        heap.insert(1);
        heap.insert(4);
        heap.insert(5);
        heap.insert(3);
        heap.insert(7);
        heap.insert(6);
        heap.insert(2);
        heap.insert(9);

        System.out.println(heap);
        System.out.println(heap.heapCompare(4, 8,0));

        heap.deleteMinimum();
        //heap.deleteMinimum();
        System.out.println(heap);


    }

}
