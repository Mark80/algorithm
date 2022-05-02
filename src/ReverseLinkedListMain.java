
public class ReverseLinkedListMain {

    static class Dot {
        public int value;
        public Dot next;

        Dot(int value, Dot next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Dot{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }


    public static void main(String[] args) {
        Dot d = new Dot(1, new Dot(2, new Dot(3, new Dot(4, null))));

        System.out.println(d);

        Dot prev = null;
        Dot current = d;
        Dot next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        d = prev;

        System.out.println(d);
    }

}
