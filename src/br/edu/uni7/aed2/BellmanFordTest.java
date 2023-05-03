package br.edu.uni7.aed2;

import java.util.Arrays;
import java.util.List;

import br.edu.uni7.aed2.graph.EdgeWeightedDigraph;
import br.edu.uni7.aed2.graph.algs.BellmanFord;
import br.edu.uni7.aed2.graph.algs.ShortestPath;

public class BellmanFordTest {
	public static void main(String[] args) {
		EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(6);

		digraph.addEdge(0, 1, 1);
		digraph.addEdge(0, 2, 3);
		digraph.addEdge(1, 2, 1);
		digraph.addEdge(1, 3, 3);
		digraph.addEdge(1, 4, 2);
		digraph.addEdge(2, 3, 2);
		digraph.addEdge(3, 5, 2);
		digraph.addEdge(4, 3, -3);
		digraph.addEdge(5, 4, 3);

		System.out.println(digraph);

		int source = 0;
		ShortestPath sp = new BellmanFord(digraph, 0);

		List<Integer> vertices = digraph.getVertices();
		for (Integer vertex : vertices) {
			System.out.println("A distancia de " + source + " para " + vertex + " é:" + sp.distTo(vertex) + " com path:"
					+ sp.pathTo(vertex));
		}
		
		System.out.println(Arrays.toString(sp.getDistTo()));
	}
}
