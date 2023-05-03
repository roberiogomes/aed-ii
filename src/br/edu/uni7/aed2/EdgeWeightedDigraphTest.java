package br.edu.uni7.aed2;

import br.edu.uni7.aed2.graph.DirectedEdge;
import br.edu.uni7.aed2.graph.EdgeWeightedDigraph;

public class EdgeWeightedDigraphTest {
	public static void main(String[] args) {
		EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(8);

		DirectedEdge edge = new DirectedEdge(4, 5, 0.35);
		edge = new DirectedEdge(5, 4, 0.35);
		digraph.addEdge(edge);
		
		edge = new DirectedEdge(4, 7, 0.37);
		digraph.addEdge(edge);
		
		edge = new DirectedEdge(5, 7, 0.28);
		digraph.addEdge(edge);
		
		edge = new DirectedEdge(7, 5, 0.28);
		digraph.addEdge(edge);
		
		edge = new DirectedEdge(5, 1, 0.32);
		digraph.addEdge(edge);
		
		edge = new DirectedEdge(0, 4, 0.38);
		digraph.addEdge(edge);
		
		edge = new DirectedEdge(0, 2, 0.26);
		digraph.addEdge(edge);
		
		edge = new DirectedEdge(7, 3, 0.39);
		digraph.addEdge(edge);
		
		edge = new DirectedEdge(1, 3, 0.29);
		digraph.addEdge(edge);
		
		edge = new DirectedEdge(2, 7, 0.34);
		digraph.addEdge(edge);
		
		edge = new DirectedEdge(6, 2, 0.40);
		digraph.addEdge(edge);
		
		edge = new DirectedEdge(3, 6, 0.52);
		digraph.addEdge(edge);
		
		edge = new DirectedEdge(6, 0, 0.58);
		digraph.addEdge(edge);
		
		edge = new DirectedEdge(6, 4, 0.93);
		digraph.addEdge(edge);
		
		System.out.println(digraph);
	}
}
