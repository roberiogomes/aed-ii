package br.edu.uni7.aed2.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UndirectedGraphAsMatrix {
	private int numberOfVertices;
	private boolean[][] matrix;
	private int numberOfEdges;
	
	public UndirectedGraphAsMatrix(int numberOfVertices) {
		this.numberOfEdges = 0;
		this.numberOfVertices = numberOfVertices;
		this.matrix = new boolean[numberOfVertices][numberOfVertices];
	}
	
	public void addEdge(int v, int w) {
		matrix[v][w] = true;
		matrix[w][v] = true;

		numberOfEdges++;
	}
	
	public Iterable<Integer> getAdjacents(int v){
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[v][i]) {
				result.add(i);
			}
		}
		
		return result;
	}
	
	public int getNumberOfVertices() {
		return numberOfVertices;
	}
	
	public int getNumberOfEdges() {
		return numberOfEdges;
	}
	
	@Override
	public String toString() {
		Set<String> result = new HashSet<String>();
		
		for (int v = 0; v < matrix.length; v++) {
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
