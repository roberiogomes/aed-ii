package br.edu.uni7.aed2.graph;

import java.util.HashSet;
import java.util.Set;

public abstract class Graph {
	protected int numberOfEdges;
	protected int numberOfVertices;

	public Graph(int numberOfVertices) {
		this.numberOfEdges = 0;
		this.numberOfVertices = numberOfVertices;
	}

	abstract public void addEdge(int v, int w);

	abstract public Iterable<Integer> getAdjacents(int v);

	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public int getNumberOfEdges() {
		return numberOfEdges;
	}

	public String toString() {
		Set<String> result = new HashSet<String>();

		for (int v = 0; v < numberOfVertices; v++) {
			Iterable<Integer> adj = getAdjacents(v);

			for (Integer w : adj) {
				int min = Math.min(v, w);
				int max = Math.max(v, w);

				result.add(min + "-" + max);
			}
		}

		return result.toString();
	}
}
