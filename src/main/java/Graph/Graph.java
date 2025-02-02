package Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    public HashMap<String, ArrayList<String>> adjList = new HashMap<String, ArrayList<String>>();

    //   Method to print Graph
    public void printGraph() {
        System.out.println(adjList);
    }

    //    Method to add vertex
    public boolean addVertex(String value) {
        if (adjList.get(value) == null) {
            adjList.put(value, new ArrayList<>());
            return true;
        }
        return false;
    }

//    Method to add Edges
    public boolean addEdge(String vertex_01, String vertex_02){
        if(adjList.get(vertex_01) != null && adjList.get(vertex_02) != null){
            adjList.get(vertex_01).add(vertex_02);
            adjList.get(vertex_02).add(vertex_01);
            return true;
        }
        return false;
    }

//    Method to remove edge
    public boolean removeEdge(String vertex_01, String vertex_02){
        if(adjList.get(vertex_01) != null && adjList.get(vertex_02) != null){
            adjList.get(vertex_01).remove(vertex_02);
            adjList.get(vertex_02).remove(vertex_01);
            return true;
        }
        return false;
    }

//    Method to Remove Vertex
    public boolean removeVertex(String vertex){
        if(adjList.get(vertex) == null)
            return false;
        for(String otherVertex : adjList.get(vertex)){
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }
}
