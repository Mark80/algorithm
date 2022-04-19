import datastructure.graph.Graph;
import datastructure.graph.Node;

public class GraphMain {

    public static void main(String[] args) {
        Graph graph = new Graph();
        Node a = new Node(0, "A");
        Node b = new Node(1, "B");
        Node c = new Node(2, "C");
        Node d = new Node(3, "D");
        Node e = new Node(4, "E");

        graph.insertEdge(a,b);
        graph.insertEdge(b,c);
        graph.insertEdge(b,d);
        graph.insertEdge(c,e);
        graph.insertEdge(b,a);

        graph.printEdges();

        System.out.println(graph.hasEdge(a,b));
        System.out.println(graph.hasEdge(d,a));

    }

}
