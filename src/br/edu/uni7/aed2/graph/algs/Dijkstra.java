package br.edu.uni7.aed2.graph.algs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.edu.uni7.aed2.graph.DirectedEdge;
import br.edu.uni7.aed2.graph.EdgeWeightedDigraph;

public class Dijkstra extends ShortestPath {

	public Dijkstra(EdgeWeightedDigraph graph, int source) {
		super(graph, source);
	}

	@Override
	protected void execute() {
		List<Integer> open = graph.getVertices();
		List<Integer> closed = new ArrayList<>();
		
		while (!open.isEmpty()) {
			Integer v = getVertexByMinDistance(open);
			closed.add(v);
			open.remove(v);
			
			Iterable<DirectedEdge> neighbors = graph.adj(v);
			for(DirectedEdge edge: neighbors) {
				if (!closed.contains(edge.to())) {
					if (distTo[v] + edge.weight() < distTo[edge.to()]) {
						distTo[edge.to()] = distTo[v] + edge.weight();
						edgeTo[edge.to()] = edge;
					}
				}
			}
		}
	}

	private int getVertexByMinDistance(List<Integer> open) {
		Collections.sort(open, new Comparator<Integer>() {
			@Override
			public int compare(Integer v1, Integer v2) {
				int result = 0;
				if (distTo[v1] < distTo[v2]) {
					result = -1;
				} else if (distTo[v1] > distTo[v2]) {
					result = +1;
				}
				return result;
			}
		});
		
		return open.get(0);
	}
}
