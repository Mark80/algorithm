package test;

import datastructure.graph.Graph;
import datastructure.graph.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    @Test
    public void test(){

        Graph graph = new Graph();
        Node a = new Node(0, "a");
        Node b = new Node(1, "b");
        Node c = new Node(2, "c");
        Node d = new Node(3, "d");
        Node e = new Node(4, "e");


        graph.insertEdge(a,b,false);
        graph.insertEdge(a,c,false);
        graph.insertEdge(d,e,false);

        graph.initGraph();
        graph.breadthFirst(a);

        assertEquals(2,graph.connectedComponent());
    }

}
