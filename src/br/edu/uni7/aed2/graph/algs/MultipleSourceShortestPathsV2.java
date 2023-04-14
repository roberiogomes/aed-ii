package br.edu.uni7.aed2.graph.algs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.uni7.aed2.graph.DigraphAsMatrix;
import br.edu.uni7.aed2.graph.Graph;

public class MultipleSourceShortestPathsV2 {
	private Map<Integer, Searcher> searchers;

	private List<Integer>[] orderedSourcesCache;

	private Map<Integer, Stock> stocks = new HashMap<>();

	private Orders orders;

	private Graph graph;

	private List<Integer> sources;

	class MyComparator implements Comparator<Integer> {
		private Integer vertex;

		public MyComparator(Integer vertex) {
			this.vertex = vertex;
		}

		@Override
		public int compare(Integer node1, Integer node2) {
			return searchers.get(node1).getDistanceTo(vertex) - searchers.get(node2).getDistanceTo(vertex);
		}
	}

	public MultipleSourceShortestPathsV2(Graph graph, List<Integer> sources, Map<Integer, Stock> stocks,
			Orders orders) {
		this.graph = graph;
		this.sources = sources;
		this.stocks = stocks;
		this.orders = orders;

		createOrderedSourcesCache();
		createSearchers();
		prepareOrderedSourcesCache();

		System.out.println();

		final List<Item> items = orders.getItems();
		for (Item item : items) {
			final String productName = item.getName();
			final int destination = item.getDestination();

			System.out.println(productName + ", " + destination);

			boolean found = false;
			while (!found) {
				for (Integer source : orderedSourcesCache[destination]) {
					final Stock stock = stocks.get(source);

					if (stock.contains(productName)) {
						System.out.println(productName + " found in " + source);

						Iterable<Integer> path = searchers.get(source).pathTo(destination);
						System.out.println("Path to " + destination + ": " + path);

						found = true;
						break;
					} else {
						System.out.println(productName + " NOT found in " + source);
					}
				}

				break;
			}

			if (!found) {
				System.out.println("There is no Stock for: " + productName);
			}

			System.out.println();
		}
	}

	private void prepareOrderedSourcesCache() {
		final int vertices = graph.getNumberOfVertices();
		for (int vertex = 0; vertex < vertices; vertex++) {
			final List<Integer> startingPoints = orderedSourcesCache[vertex];

			for (int i = startingPoints.size() - 1; i >= 0; i--) {
				final Integer startingPoint = startingPoints.get(i);

				if (!searchers.get(startingPoint).hasPathTo(vertex)) {
					startingPoints.remove(i);
				}
			}

			Collections.sort(startingPoints, new MyComparator(vertex));
		}
	}

	private void createSearchers() {
		this.searchers = new HashMap<>();
		for (Integer source : sources) {
			this.searchers.put(source, new BreadthFirstSearch(graph, source));
		}
	}

	private void createOrderedSourcesCache() {
		this.orderedSourcesCache = new ArrayList[graph.getNumberOfVertices()];
		for (int i = 0; i < orderedSourcesCache.length; i++) {
			this.orderedSourcesCache[i] = new ArrayList<>();

			for (Integer source : sources) {
				this.orderedSourcesCache[i].add(source);
			}
		}
	}

	static private Orders createOrders(int numberOfVertices, List<Integer> sources) {
		return new Orders(numberOfVertices, sources);
	}

	static private Map<Integer, Stock> createStocks(List<Integer> sources) {
		final Map<Integer, Stock> stocks = new HashMap<>();

		for (Integer source : sources) {
			stocks.put(source, new Stock());
		}

		return stocks;
	}

	public static void main(String[] args) {
		Graph graph = new DigraphAsMatrix(13);

		graph.addEdge(0, 1);
		graph.addEdge(0, 5);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		graph.addEdge(3, 5);

		graph.addEdge(4, 3);
		graph.addEdge(4, 2);
		graph.addEdge(5, 4);

		graph.addEdge(6, 0);
		graph.addEdge(6, 4);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);

		graph.addEdge(7, 6);
		graph.addEdge(7, 9);

		graph.addEdge(8, 6);
		graph.addEdge(9, 10);
		graph.addEdge(9, 11);

		graph.addEdge(10, 12);
		graph.addEdge(11, 4);

		graph.addEdge(11, 12);
		graph.addEdge(12, 9);

		List<Integer> sources = new ArrayList<>();
		sources.add(0);
		sources.add(7);
		sources.add(10);

		MultipleSourceShortestPathsV2 m = new MultipleSourceShortestPathsV2(graph, sources, createStocks(sources),
				createOrders(graph.getNumberOfVertices(), sources));
	}
}
