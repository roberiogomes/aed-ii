package br.edu.uni7.aed2.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UndirectedGraphAsMatrix extends UndirectedGraph{
	protected boolean[][] matrix;

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
		
		Collections.sort(result);

		return result;
	}
}
