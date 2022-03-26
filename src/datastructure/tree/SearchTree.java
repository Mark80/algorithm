package datastructure.tree;

import java.util.List;
import java.util.Objects;

public class SearchTree<T extends Comparable<T>> {
    public T value;
    public SearchTree<T> left;
    public SearchTree<T> right;
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

    public SearchTree(T value) {
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
        if (nodeToDelete.parent == null) return;
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
