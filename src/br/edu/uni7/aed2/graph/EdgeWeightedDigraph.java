package br.edu.uni7.aed2.graph;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {
	private int v;
	private int e;
	public static final Integer INFINITY = Integer.MAX_VALUE / 2;

	private List<DirectedEdge>[] adj;

	public EdgeWeightedDigraph(int v) {
		this.v = v;
		this.e = 0;

		adj = new ArrayList[v];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
	}

	public List<Integer> getVertices() {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < v; i++) {
			result.add(i);
		}

		return result;
	}

	public void addEdge(int v, int w, double weight) {
		addEdge(new DirectedEdge(v, w, weight));
	}

	public void addEdge(DirectedEdge edge) {
		int v = edge.from();

		adj[v].add(edge);
		e++;
	}

	public Iterable<DirectedEdge> adj(int v) {
		return adj[v];
	}

	public int getNumberOfVertices() {
		return v;
	}

	public int getNumberOfEdges() {
		return e;
	}

	public Iterable<DirectedEdge> edges() {
		List<DirectedEdge> result = new ArrayList<>();

		for (int i = 0; i < getNumberOfVertices(); i++) {
			result.addAll(adj[i]);
		}

		return result;
	}

	public Iterable<DirectedEdge> predecessors(int v) {
		List<DirectedEdge> result = new ArrayList<>();

		for (DirectedEdge edge : edges()) {
			if (edge.to() == v) {
				result.add(edge);
			}
		}

		return result;
	}

	public boolean containsEdge(int v, int w) {
		boolean result = false;

		List<DirectedEdge> edges = adj[v];

		for (DirectedEdge edge : edges) {
			if (edge.to() == w) {
				result = true;
				break;
			}
		}

		return result;
	}

	public double getWeight(int v, int w) {
		double result = 0.0;

		DirectedEdge edge = getEdge(v, w);
		if (edge != null) {
			result = edge.weight();
		}

		return result;
	}

	public DirectedEdge getEdge(int v, int w) {
		DirectedEdge result = null;
		
		List<DirectedEdge> edges = adj[v];

		for (DirectedEdge edge : edges) {
			if (edge.to() == w) {
				result = edge;
				break;
			}
		}
		
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append(edges());

		return builder.toString();
	}
}
