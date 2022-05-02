package datastructure.graph;

import java.util.*;

enum Status {
    PROCESSED,
    DISCOVERED,
    UNDISCOVERED
}

public class Graph {

    private final Map<Node, LinkedList<Node>> adjacencyMap = new HashMap<>();
    Map<Node, Node> parents = new HashMap<>();


    public void insertEdge(Node x, Node y, boolean direct) {

        if (!adjacencyMap.containsKey(x)) {
            adjacencyMap.put(x, null);
        }
        if (!adjacencyMap.containsKey(y)) {
            adjacencyMap.put(y, null);
        }

        LinkedList<Node> edgeNodes = getNodes(x);

        if (edgeNodes == null) {
            LinkedList<Node> adiajent = new LinkedList<>();
            adiajent.add(y);
            adjacencyMap.put(x, adiajent);

        } else {
            edgeNodes.add(y);
        }

        if (!direct) {
            insertEdge(y, x, true);
        }
    }


    public void printEdges() {
        for (Node node : adjacencyMap.keySet()) {
            System.out.print("The " + node.name + " has an edge towards: ");
            if (getNodes(node) != null) {
                for (Node neighbor : getNodes(node)) {
                    System.out.print(neighbor.name + " ");
                }
                System.out.println();
            } else {
                System.out.println("none");
            }
        }
    }

    public boolean hasEdge(Node start, Node end) {
        LinkedList<Node> nodes = getNodes(start);
        return nodes != null && nodes.contains(end);
    }

    public void deepFirst(Node start) {
        Map<Node, Status> status = new HashMap<>();
        for (Node node : adjacencyMap.keySet()) {
            status.put(node, Status.UNDISCOVERED);
        }

        for (Node node : adjacencyMap.keySet()) {
            parents.put(node, null);
        }

        Stack<Node> stack = new Stack<>();
        stack.push(start);
        status.put(start, Status.DISCOVERED);


        while(!stack.isEmpty()){
            Node currentNode = stack.pop();
            processFirstVertex(currentNode);
            status.put(start, Status.PROCESSED);
            List<Node> adjacency = new LinkedList<>(getNodes(currentNode));

            for(Node neighbor: adjacency) {
                if(status.get(neighbor) == Status.UNDISCOVERED){
                    parents.put(neighbor, currentNode);
                    status.put(neighbor, Status.DISCOVERED);
                    stack.push(neighbor);
                }
            }
        }
    }

    public void breadthFirst(Node start) {
        Map<Node, Status> status = new HashMap<>();
        for (Node node : adjacencyMap.keySet()) {
            status.put(node, Status.UNDISCOVERED);
        }

        for (Node node : adjacencyMap.keySet()) {
            parents.put(node, null);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        status.put(start, Status.DISCOVERED);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            processFirstVertex(currentNode);
            Queue<Node> adjacency = new LinkedList<>(getNodes(currentNode));
            status.put(currentNode, Status.PROCESSED);

            while (!adjacency.isEmpty()) {
                Node neighbor = adjacency.poll();
                if (status.get(neighbor) == Status.DISCOVERED) {
                    processEdge(currentNode, neighbor);
                }
                if (status.get(neighbor) == Status.UNDISCOVERED) {
                    status.put(neighbor, Status.DISCOVERED);
                    queue.add(neighbor);
                    parents.put(neighbor, currentNode);
                }
            }
            processLastVertex(currentNode);
        }
    }

    public LinkedList<Node> getNodes(Node start) {
        return adjacencyMap.get(start);
    }

    private void processFirstVertex(Node node) {
        //System.out.println("Processed vertex " + node);

    }

    private void processEdge(Node a, Node b) {

    }

    private void processLastVertex(Node node) {

    }

    public List<Node> findPath(Node start, Node end) {
        this.breadthFirst(start);
        List<Node> path = new LinkedList<>();
        path.add(end);

        Node parent = parents.get(end);
        while (!parent.equals(start)) {
            path.add(parent);
            parent = parents.get(parent);
        }
        path.add(parent);
        Collections.reverse(path);
        return path;
    }


}
