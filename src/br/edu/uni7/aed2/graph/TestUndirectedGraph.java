package br.edu.uni7.aed2.graph;

public class TestUndirectedGraph {
	public static void main(String[] args) {
		UndirectedGraphAsMatrix graph = new UndirectedGraphAsMatrix(13);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(0, 6);
		
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		
		graph.addEdge(7, 8);
		
		graph.addEdge(9, 10);
		graph.addEdge(9, 11);
		graph.addEdge(9, 12);
		
		graph.addEdge(11, 12);
		
		System.out.println("NumberOfEdges : " + graph.getNumberOfEdges());
		System.out.println("NumberOfVertices : " + graph.getNumberOfVertices());
		System.out.println("Adj(0) : " + graph.getAdjacents(0));
		
		System.out.println(graph.toString());
	}
}
