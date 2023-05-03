package br.edu.uni7.aed2.graph.algs;

import java.util.Arrays;

import br.edu.uni7.aed2.graph.Graph;

public class DepthFirstSearch extends Searcher {
	public DepthFirstSearch(Graph graph, int source) {
		super(graph, source);
		
		dfs(source);
	}

	private void dfs(int v) {
		marked[v] = true;
		
		System.out.println("Marked: " + Arrays.toString(marked));
		System.out.println("EdgeTo: " + Arrays.toString(edgeTo));
		System.out.println("DistTo: " + Arrays.toString(distTo));

		Iterable<Integer> adj = graph.getAdjacents(v);
		for (Integer w : adj) {
			if (!marked[w]) {
				dfs(w);
				
				edgeTo[w] = v;
				distTo[w] = distTo[v] + 1;
				System.out.println();
			}
		}
		
		
	}
}
