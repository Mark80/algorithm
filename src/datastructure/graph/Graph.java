package datastructure.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {

   private final Map<Node, LinkedList<Node>> adjacencyMap = new HashMap<>();

   public void insertEdge(Node x, Node y) {

       if(!adjacencyMap.containsKey(x)){
           adjacencyMap.put(x,null);}
       if(!adjacencyMap.containsKey(y)){
           adjacencyMap.put(y,null);}

       LinkedList<Node> edgeNodes = adjacencyMap.get(x);

       if(edgeNodes == null) {
           LinkedList<Node> adiajent = new LinkedList<>();
           adiajent.add(y);
           adjacencyMap.put(x, adiajent);
       }else{
           edgeNodes.add(y);
       }
   }


    public void printEdges() {
        for (Node node : adjacencyMap.keySet()) {
            System.out.print("The " + node.name + " has an edge towards: ");
            if (adjacencyMap.get(node) != null) {
                for (Node neighbor : adjacencyMap.get(node)) {
                    System.out.print(neighbor.name + " ");
                }
                System.out.println();
            }
            else {
                System.out.println("none");
            }
        }
    }

    public boolean hasEdge(Node start, Node end) {
        LinkedList<Node> nodes = adjacencyMap.get(start);
        return nodes != null && nodes.contains(end);
    }


}
