import datastructure.queue.SortedPQ;
import datastructure.queue.UnsortedPQ;

public class MainQueue {

    public static void main(String[] args) {
        UnsortedPQ queue = new UnsortedPQ();
        queue.insert(2);
        queue.insert(23);
        queue.insert(1);
        queue.insert(7);
        queue.insert(12);
        queue.insert(9);

        System.out.println(queue);
        System.out.println(queue.minimum());
        queue.deleteMinimum();
        System.out.println(queue);
        System.out.println(queue.minimum());
        queue.deleteMinimum();
        System.out.println(queue.minimum());

        queue.insert(9233);
        System.out.println(queue);
//
//        UnsortedPQ queue2 = new UnsortedPQ();
//        queue2.insert(2);
//        queue2.deleteMinimum();
//        queue2.deleteMinimum();

        SortedPQ sortedPQ = new SortedPQ();

        sortedPQ.insert(2);
        sortedPQ.insert(3);
        sortedPQ.insert(7);
        sortedPQ.insert(4);
        sortedPQ.insert(6);
        sortedPQ.insert(1);
        System.out.println(sortedPQ);
        System.out.println(sortedPQ.minimum());
        sortedPQ.deleteMinimum();
        System.out.println(sortedPQ);
        sortedPQ.insert(1);
        System.out.println(sortedPQ);

        UnsortedPQ queue2 = new UnsortedPQ();
        queue2.insert(5);
        queue2.deleteMinimum();
        System.out.println(queue2.isEmpty());
    }

}
