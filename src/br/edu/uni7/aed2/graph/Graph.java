package br.edu.uni7.aed2.graph;

public abstract class Graph {
	protected int numberOfEdges;
	protected int numberOfVertices;

	public Graph(int numberOfVertices) {
		this.numberOfEdges = 0;
		this.numberOfVertices = numberOfVertices;
	}

	abstract public void addEdge(int v, int w);

	abstract public Iterable<Integer> getAdjacents(int v);

	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public int getNumberOfEdges() {
		return numberOfEdges;
	}
}
