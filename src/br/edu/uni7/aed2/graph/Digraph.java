package br.edu.uni7.aed2.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Digraph extends Graph {

	public Digraph(int numberOfVertices) {
		super(numberOfVertices);
	}
	
	public String toString() {
		List<String> result = new ArrayList();

		for (int v = 0; v < numberOfVertices; v++) {
			Iterable<Integer> adj = getAdjacents(v);

			for (Integer w : adj) {
				result.add(v + "->" + w);
			}
		}
		
		Collections.sort(result);

		return result.toString();
	}
}
