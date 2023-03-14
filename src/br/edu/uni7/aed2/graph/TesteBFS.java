package br.edu.uni7.aed2.graph;

import br.edu.uni7.aed2.graph.algs.BreadthFirstSearch;
import br.edu.uni7.aed2.graph.algs.Searcher;

public class TesteBFS {
	public static void main(String[] args) {
		Graph graph = new UndirectedGraphAsMatrix(6);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		
		graph.addEdge(1, 2);
		
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		
		int source = 0;
		Searcher searcher = new BreadthFirstSearch(graph, source);
		int numberOfVertices = graph.getNumberOfVertices();
		int w = 0;
		System.out.println("BreadthFirstSearch");
		while (w < numberOfVertices) {
			if (searcher.hasPathTo(w)) {
				System.out.print("Path from " + source + " to " + w + ": ");
				Iterable<Integer> path = searcher.pathTo(w);
				for (Integer v : path) {
					System.out.print(v + ", ");
				}
				
				System.out.println();
			}

			w++;
		}
		
		
	}
}
