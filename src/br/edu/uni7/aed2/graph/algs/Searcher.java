package br.edu.uni7.aed2.graph.algs;

import java.util.Stack;

import br.edu.uni7.aed2.graph.Graph;

public abstract class Searcher {

	protected Graph graph;
	protected boolean[] marked;
	protected int[] edgeTo;
	protected int source;

	public Searcher(Graph graph, int source) {
		this.graph = graph;
		this.source = source;
		this.marked = new boolean[graph.getNumberOfVertices()];
		this.edgeTo = new int[graph.getNumberOfVertices()];
		for (int i = 0; i < edgeTo.length; i++) {
			edgeTo[i] = Integer.MIN_VALUE;
		}
	}

	public Iterable<Integer> pathTo(int v) {
		Stack<Integer> path = new Stack<>();
		
		if (!hasPathTo(v)) {
			return null;
		}
		
		for (int x = v; x != source; x = edgeTo[x]) {
			path.push(x);
		}
		
		path.push(source);
		
		return path;
	}

	public boolean hasPathTo(int w) {
		return marked[w];
	}

	public boolean isMarked(int w) {
		return marked[w];
	}

}