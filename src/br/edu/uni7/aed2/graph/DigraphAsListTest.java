package br.edu.uni7.aed2.graph;

import br.edu.uni7.aed2.graph.algs.BreadthFirstSearch;
import br.edu.uni7.aed2.graph.algs.DepthFirstSearch;
import br.edu.uni7.aed2.graph.algs.Searcher;

public class DigraphAsListTest {
	public static void main(String[] args) {
		Graph graph = new DigraphAsMatrix(13);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 5);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		graph.addEdge(3, 5);
		
		graph.addEdge(4, 3);
		graph.addEdge(4, 2);
		graph.addEdge(5, 4);
		
		graph.addEdge(6, 0);
		graph.addEdge(6, 4);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		
		graph.addEdge(7, 6);
		graph.addEdge(7, 9);
		
		graph.addEdge(8, 6);
		graph.addEdge(9, 10);
		graph.addEdge(9, 11);
		
		graph.addEdge(10, 12);
		graph.addEdge(11, 4);
		
		graph.addEdge(11, 12);
		graph.addEdge(12, 9);
		
		System.out.println(graph);
		
		int source = 0;
		Searcher searcher = new DepthFirstSearch(graph, source);
//		Searcher searcher = new BreadthFirstSearch(graph, source);
		int numberOfVertices = graph.getNumberOfVertices();
		int w = 0;
		System.out.println("DepthFirstSearch");
		while (w < numberOfVertices) {
			if (searcher.hasPathTo(w)) {
				System.out.print("Path from " + source + " to " + w + ": ");
				Iterable<Integer> path = searcher.pathTo(w);
				for (Integer v : path) {
					System.out.print(v + ", ");
				}

				System.out.println();
			} else {
				System.out.println("There is no path from: " + source + " to " + w + " :(");
			}

			w++;
		}
	}
}
