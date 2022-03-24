import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main2 {

    static class SearchTree<T extends Comparable<T>> {
        private T value;
        private SearchTree<T> left;
        private SearchTree<T> right;
        private SearchTree<T> parent;

        public static <T extends Comparable<T>> SearchTree<T> createFrom(List<T> list) {
            if (Objects.isNull(list)) return null;
            SearchTree<T> tree = new SearchTree<>();
            for (T t : list) {
                tree.insert(t);
            }
            return tree;
        }

        SearchTree() {
            this.left = null;
            this.right = null;
            this.parent = null;
            this.value = null;
        }

        SearchTree(T value) {
            this.left = null;
            this.right = null;
            this.parent = null;
            this.value = value;
        }

        private SearchTree(T value, SearchTree<T> parent) {
            this.left = null;
            this.right = null;
            this.parent = parent;
            this.value = value;
        }

        public void insert(T value) {
            if (this.value == null) this.value = value;
            if (this.value.compareTo(value) > 0) {
                if (this.left == null) {
                    this.left = new SearchTree<>(value, this);
                } else {
                    this.left.insert(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new SearchTree<>(value, this);
                } else {
                    this.right.insert(value);
                }
            }

        }

        public void delete(T value) {
            SearchTree<T> nodeToDelete = searchNode(value);
            if(nodeToDelete.parent == null) return;
            SearchTree<T> newRoot = nodeToDelete.right == null ? null : nodeToDelete.right.nodeMinimum();
            if (newRoot != null) {
                nodeToDelete.value = newRoot.value;
                if (newRoot.parent.left == null) {
                    newRoot.parent.right = null;
                } else {
                    newRoot.parent.left = null;
                }
            } else {
                SearchTree<T> parent = nodeToDelete.parent;
                if (parent.value.compareTo(nodeToDelete.value) > 0)
                    parent.left = null;
                else
                    parent.right = null;
            }
        }

        public SearchTree<T> nodeMinimum() {
            if (this.left == null) {
                return this;
            } else {
                return this.left.nodeMinimum();
            }
        }

        public SearchTree<T> nodeMaximum() {
            if (this.right == null) {
                return this;
            } else {
                return this.right.nodeMaximum();
            }
        }

        public SearchTree<T> successor(T value) {
            SearchTree<T> node = searchNode(value);
            if (node == null) {
                return null;
            } else {
                if (node.right != null) {
                    return node.right.nodeMinimum();
                } else {
                    return null;
                }
            }
        }

        public T minimum() {
            SearchTree<T> min = nodeMinimum();
            if (min != null) {
                return min.value;
            } else {
                return null;
            }
        }

        public T maximum() {
            if (this.right == null) {
                return value;
            } else {
                return this.right.maximum();
            }
        }

        public SearchTree<T> searchNode(T value) {
            SearchTree<T> node = null;
            if (this.value.equals(value)) {
                node = this;
            } else {
                if (this.value.compareTo(value) > 0 && this.left != null) {
                    node = this.left.searchNode(value);
                }
                if (this.value.compareTo(value) < 0 && this.right != null) {
                    node = this.right.searchNode(value);
                }
            }
            return node;
        }

        public boolean exist(T value) {
            SearchTree<T> node = searchNode(value);
            System.out.println(node);
            return node != null && node.value.equals(value);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SearchTree<?> node = (SearchTree<?>) o;
            return Objects.equals(value, node.value) && Objects.equals(left, node.left) && Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, left, right);
        }
    }

    static <T extends Comparable<T>> List<T> sort(List<T> toSort) {
        List<T> toFill = new ArrayList<>();
        fillList(toFill, SearchTree.createFrom(toSort));
        return toFill;
    }

    //static  <T extends Comparable<T>> List<T> sort(List<T> toSort)

    private static <T extends Comparable<T>> void fillList(List<T> toFill, SearchTree<T> tree) {
        if (Objects.isNull(tree) || Objects.isNull(tree.value)) return;
        if (tree.left == null) {
            toFill.add(tree.value);
        } else {
            fillList(toFill, tree.left);
            toFill.add(tree.value);
        }
        if (tree.right != null) {
            fillList(toFill, tree.right);
        }
    }

    public static void main(String[] args) {

        long t = System.currentTimeMillis();
        int[] input = new int[900_000_000];
        input[899_999_999] = 10;
        System.out.println(binarySearch(input, 10));
        System.out.println(System.currentTimeMillis() - t);

        SearchTree<Integer> searchTree = new SearchTree<>(3);

        searchTree.insert(5);
        searchTree.insert(4);
        searchTree.insert(6);
        searchTree.insert(8);
        searchTree.insert(12);

        System.out.println();
        System.out.println();

        System.out.println(searchTree.exist(4));
        System.out.println(searchTree.exist(6));
        System.out.println(searchTree.exist(3));
        System.out.println(searchTree.exist(8));
        System.out.println(searchTree.exist(13));

        System.out.println();
        System.out.println();

        System.out.println(searchTree.minimum());
        System.out.println(searchTree.maximum());
        System.out.println(searchTree);
        System.out.println(searchTree.searchNode(8));

        List<Integer> toFill = new ArrayList<>();
        fillList(toFill, searchTree);
        System.out.println(toFill);

        System.out.println(">>> " + searchTree.successor(6).value);
        System.out.println(">>> " + searchTree.successor(8).value);

        System.out.println(searchTree);
        searchTree.delete(8);
        System.out.println(searchTree);
        searchTree.delete(3);
        System.out.println(searchTree);

        System.out.println();

        SearchTree<Integer> searchTree2 = new SearchTree<>(5);
        searchTree2.insert(3);
        System.out.println(searchTree2);
        searchTree2.delete(5);
        System.out.println(searchTree2);



        List<Integer> toBeSort = new ArrayList<>();
        toBeSort.add(2);
        toBeSort.add(9);
        toBeSort.add(12);
        toBeSort.add(1);
        toBeSort.add(4);
        toBeSort.add(7);

        System.out.println(sort(toBeSort));
        System.out.println(sort(new ArrayList<Integer>()));


    }


    static int binarySearch(int[] input, int elem) {

        if (input.length == 0) return -1;

        int min = 0;
        int max = input.length - 1;

        while (min <= max) {
            int middle = (max + min) >>> 1;
            int pivot = input[middle];
            if (pivot > elem) {
                max = middle - 1;
            } else if (pivot < elem) {
                min = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


}
