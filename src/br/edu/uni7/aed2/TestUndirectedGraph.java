package br.edu.uni7.aed2;

import java.util.Stack;

import br.edu.uni7.aed2.graph.Graph;
import br.edu.uni7.aed2.graph.UndirectedGraphAsMatrix;
import br.edu.uni7.aed2.graph.algs.DepthFirstSearch;
import br.edu.uni7.aed2.graph.algs.Searcher;

public class TestUndirectedGraph {
	public static void main(String[] args) {
		Graph graph = new UndirectedGraphAsMatrix(13);

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

		int source = 0;
		Searcher search = new DepthFirstSearch(graph, source);
		int numberOfVertices = graph.getNumberOfVertices();
		int w = 0;
		while (w < numberOfVertices) {
			if (search.hasPathTo(w)) {
				System.out.print("Path from " + source + " to " + w + ": ");
				Iterable<Integer> path = search.pathTo(w);
				for (Integer v : path) {
					System.out.print(v + ", ");
				}
				
				System.out.println();
			}

			w++;
		}
	}
}
