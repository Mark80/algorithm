
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

    static class Node {
        public int value;
        public  Node left;
        public  Node right;

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static void invert(Node tree) {
        Node l = tree.left;
        Node r = tree.right;

        tree.left = r;
        tree.right = l;

        if(tree.left != null) invert(tree.left);
        if(tree.right != null)invert(tree.right);

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

        Node tree = new Node(1,new Node(2,null,null),new Node(3,new Node(4,null,null),null));

        System.out.println(tree);
        invert(tree);
        System.out.println(tree);
    }

}
