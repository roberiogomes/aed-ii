package br.edu.uni7.aed2.graph.algs;

import br.edu.uni7.aed2.graph.Graph;

public class ConnectedComponents {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public ConnectedComponents(Graph graph) {
		marked = new boolean[graph.getNumberOfVertices()];
		id = new int[graph.getNumberOfVertices()];
		for (int v = 0; v < id.length; v++) {
			if (!marked[v]) {
				dfs(graph, v);
				count++;
			}
		}
	}

	private void dfs(Graph graph, int v) {
		marked[v] = true;
		
		id[v] = count;
		for (Integer w : graph.getAdjacents(v)) {
			if (!marked[w]) {
				dfs(graph, w);
			}
		}
	}
	
	public int count() {
		return count;
	}
	
	public int id(int v) {
		return id[v];
	}
	
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
}
