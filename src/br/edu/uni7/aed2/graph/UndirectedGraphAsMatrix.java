package br.edu.uni7.aed2.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UndirectedGraphAsMatrix extends Graph{
	private boolean[][] matrix;

	public UndirectedGraphAsMatrix(int numberOfVertices) {
		super(numberOfVertices);
		
		this.matrix = new boolean[numberOfVertices][numberOfVertices];
	}

	public void addEdge(int v, int w) {
		matrix[v][w] = true;
		matrix[w][v] = true;

		numberOfEdges++;
	}

	public Iterable<Integer> getAdjacents(int v) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[v][i]) {
				result.add(i);
			}
		}

		return result;
	}
}
