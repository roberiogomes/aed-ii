package br.edu.uni7.aed2.graph.algs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.edu.uni7.aed2.graph.DirectedEdge;
import br.edu.uni7.aed2.graph.EdgeWeightedDigraph;
import br.edu.uni7.aed2.heap.GenericBinHeap;

public class DijkstraV2 extends ShortestPath {

	public DijkstraV2(EdgeWeightedDigraph graph, int source) {
		super(graph, source);
	}

	@Override
	protected void execute() {
		GenericBinHeap<Integer, Comparator<Integer>> open = getOpen();
		List<Integer> closed = new ArrayList<>();
		
		while (!open.isEmpty()) {
			Integer v = open.delTop();
			closed.add(v);
			
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

	private GenericBinHeap<Integer, Comparator<Integer>> getOpen() {
		Comparator<Integer> comparator = new Comparator<Integer>() {
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
		};
		
		GenericBinHeap<Integer, Comparator<Integer>> open = new GenericBinHeap<>(comparator);
		
		List<Integer> vertices = graph.getVertices();
		for (Integer vertex : vertices) {
			open.insert(vertex);
		}
		
		return open;
	}
}
