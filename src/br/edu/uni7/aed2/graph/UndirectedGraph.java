package br.edu.uni7.aed2.graph;

import java.util.HashSet;
import java.util.Set;

public abstract class UndirectedGraph extends Graph {

	public UndirectedGraph(int numberOfVertices) {
		super(numberOfVertices);
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
