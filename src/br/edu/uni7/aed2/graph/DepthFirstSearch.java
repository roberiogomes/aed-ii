package br.edu.uni7.aed2.graph;

public class DepthFirstSearch {
	private Graph graph;

	private boolean[] marked;
	
	private int[] edgeTo;

	public DepthFirstSearch(Graph graph, int source) {
		this.graph = graph;
		this.marked = new boolean[graph.getNumberOfVertices()];
		this.edgeTo = new int[graph.getNumberOfVertices()];
		for (int i = 0; i < edgeTo.length; i++) {
			edgeTo[i] = Integer.MIN_VALUE;
		}

		dfs(source);
	}

	private void dfs(int v) {
		marked[v] = true;

		Iterable<Integer> adj = graph.getAdjacents(v);
		for (Integer w : adj) {
			if (!marked[w]) {
				dfs(w);
				
				edgeTo[w] = v;
			}
		}
	}

	public boolean hasPathTo(int w) {
		return marked[w];
	}

	public boolean isMarked(int w) {
		return marked[w];
	}
}
