package br.edu.uni7.aed2.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DigraphAsList extends Digraph {
	private List<Integer>[] adjacents;

	public DigraphAsList(int numberOfVertices) {
		super(numberOfVertices);

		this.adjacents = new ArrayList[numberOfVertices];

		for (int i = 0; i < adjacents.length; i++) {
			adjacents[i] = new ArrayList();
		}
	}

	@Override
	public void addEdge(int v, int w) {
		adjacents[v].add(w);
	}

	@Override
	public Iterable<Integer> getAdjacents(int v) {
		List<Integer> result = adjacents[v];

		Collections.sort(result);

		return result;
	}
}
