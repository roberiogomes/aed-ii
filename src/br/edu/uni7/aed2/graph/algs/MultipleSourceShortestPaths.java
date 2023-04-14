package br.edu.uni7.aed2.graph.algs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.uni7.aed2.graph.DigraphAsMatrix;
import br.edu.uni7.aed2.graph.Graph;

public class MultipleSourceShortestPaths {
	private Searcher[] searchs;
	
	public MultipleSourceShortestPaths(Graph graph, List<Integer> sources) {
		this.searchs = new BreadthFirstSearch[sources.size()];
		
		for (int i = 0; i < searchs.length; i++) {
			searchs[i] = new BreadthFirstSearch(graph, sources.get(i));
		}

		int vertices = graph.getNumberOfVertices();
		for (int vertice = 0; vertice < vertices; vertice++) {

			int index = -1;
			int distance = Integer.MAX_VALUE;

			for (int j = 0; j < searchs.length; j++) {
				Searcher searcher = searchs[j];

				if (searcher.getDistanceTo(vertice) > 0 && searcher.getDistanceTo(vertice) < distance) {
					distance = searcher.getDistanceTo(vertice);

					index = j;
				}
			}

			if (index >= 0) {
				Searcher searcher = searchs[index];

				Iterable<Integer> path = searcher.pathTo(vertice);

				System.out.println(
						"Shortest path to " + vertice + " is: " + path + " starting from: " + sources.get(index));
			}
		}

		for (int i = 0; i < searchs.length; i++) {
			System.out.println(sources.get(i) + " : " + Arrays.toString(searchs[i].distTo));
		}
	}

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

		List<Integer> sources = new ArrayList<>();
		sources.add(0);
		sources.add(7);
		sources.add(10);

		MultipleSourceShortestPaths m = new MultipleSourceShortestPaths(graph, sources);
	}
}
