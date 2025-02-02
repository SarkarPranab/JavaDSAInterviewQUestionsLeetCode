package Graph;

public class Main {
    public static void main(String args[]){
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A","B");
        graph.addEdge("A","C");
        graph.addEdge("B","C");

        System.out.println("*-*-*-*Test addEdge*-*-*-*");
        graph.printGraph();
        System.out.println("*-*-*-*Test removeEdge*-*-*-*");
//        graph.removeEdge("A","B");
//        graph.printGraph();
        System.out.println("*-*-*-*Test removeVertext*-*-*-*");
        graph.removeVertex("D");
        graph.printGraph();
    }
}
