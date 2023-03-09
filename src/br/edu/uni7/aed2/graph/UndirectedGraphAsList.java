package br.edu.uni7.aed2.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphAsList extends Graph {
	private List<Integer>[] adjacents;

	public UndirectedGraphAsList(int numberOfVertices) {
		super(numberOfVertices);

		this.adjacents = new ArrayList[numberOfVertices];

		for (int i = 0; i < adjacents.length; i++) {
			adjacents[i] = new ArrayList();
		}
	}

	public void addEdge(int v, int w) {
		adjacents[v].add(w);
		adjacents[w].add(v);

		numberOfEdges++;
	}

	public Iterable<Integer> getAdjacents(int v) {
		return adjacents[v];
	}
}
