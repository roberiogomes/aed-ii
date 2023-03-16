package br.edu.uni7.aed2.graph.algs;

import br.edu.uni7.aed2.graph.Graph;
import br.edu.uni7.aed2.graph.UndirectedGraphAsMatrix;

public class TesteCC {
	public static void main(String[] args) {
		Graph graph = new UndirectedGraphAsMatrix(13);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(0, 6);

		graph.addEdge(3, 4);
		graph.addEdge(3, 5);

		graph.addEdge(4, 5);
		graph.addEdge(4, 6);

		graph.addEdge(7, 8);

		graph.addEdge(9, 10);
		graph.addEdge(9, 11);
		graph.addEdge(9, 12);

		graph.addEdge(11, 12);
		
		ConnectedComponents cc = new ConnectedComponents(graph);
		
		for (int v = 0; v < graph.getNumberOfEdges(); v++) {
			System.out.println( v + " está em " + cc.id(v));
		}
		
		System.out.println(0 + " e " + 3 + " estão conectados? " + cc.connected(0, 3));
		System.out.println(0 + " e " + 8 + " estão conectados? " + cc.connected(0, 8));
		System.out.println(0 + " e " + 10 + " estão conectados? " + cc.connected(0, 10));
	}
}
