import datastructure.tree.SearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainSearchTree {

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
