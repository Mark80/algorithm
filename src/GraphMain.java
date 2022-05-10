import datastructure.graph.Graph;
import datastructure.graph.Node;

public class GraphMain {

    public static void main(String[] args) {
//        Graph graph = new Graph();
//        Node _1 = new Node(0, "1");
//        Node _2 = new Node(1, "2");
//        Node _3 = new Node(2, "3");
//        Node _4 = new Node(3, "4");
//        Node _5 = new Node(4, "5");
//        Node _6 = new Node(4, "6");
//
//
//        graph.insertEdge(_1,_2,false);
//        graph.insertEdge(_1,_5,false);
//        graph.insertEdge(_1,_6,false);
//        graph.insertEdge(_2,_3,false);
//        graph.insertEdge(_2,_4,false);
//        graph.insertEdge(_3,_5,false);
//
//        //graph.breadthFirst(_1);
//        graph.breadthFirst(_2);
//        System.out.println(graph.findPath(_2, _5));
//
//
//        Graph graph_2 = new Graph();
//        Node p = new Node(0, "p");
//        Node x = new Node(1, "x");
//        Node y = new Node(2, "y");
//        Node r = new Node(3, "r");
//
//        graph_2.insertEdge(p,x,false);
//        graph_2.insertEdge(p,y,false);
//        graph_2.insertEdge(x,y,false);
//        graph_2.insertEdge(x,r,false);
//        graph_2.insertEdge(y,r,false);
//
//
//        graph_2.breadthFirst(p);
//
//        System.out.println(graph_2.findCurrentPath(p,r));


        Graph graph_3 = new Graph();
        Node a = new Node(0, "a");
        Node b = new Node(1, "b");
        Node c = new Node(2, "c");
        Node d = new Node(3, "d");

        graph_3.insertEdge(a,b,true);
        graph_3.insertEdge(b,c,true);
        graph_3.insertEdge(c,d,true);
        graph_3.insertEdge(d,a,true);



    }

}
