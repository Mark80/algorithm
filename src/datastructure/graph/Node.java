package datastructure.graph;

import java.util.Objects;

public class Node {

    public final int value;
    public final String name;

    public Node(int value, String name){
        this.value = value;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node edgeNode = (Node) o;
        return value == edgeNode.value && name == edgeNode.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, name);
    }
}
