import datastructure.UnsortedPQ;

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

    }

}
