import datastructure.graph.Graph;
import datastructure.graph.Node;

public class GraphMain {

    public static void main(String[] args) {
        Graph graph = new Graph();
        Node _1 = new Node(0, "1");
        Node _2 = new Node(1, "2");
        Node _3 = new Node(2, "3");
        Node _4 = new Node(3, "4");
        Node _5 = new Node(4, "5");
        Node _6 = new Node(4, "6");


        graph.insertEdge(_1,_2,false);
        graph.insertEdge(_1,_5,false);
        graph.insertEdge(_1,_6,false);
        graph.insertEdge(_2,_3,false);
        graph.insertEdge(_2,_4,false);
        graph.insertEdge(_3,_5,false);

        //graph.breadthFirst(_1);
        graph.breadthFirst(_2);
        System.out.println(graph.findPath(_2, _5));

    }

}
