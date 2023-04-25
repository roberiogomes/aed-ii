package br.edu.uni7.aed2.graph.algs;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	private int size;
	private int numberOfVertices;
	private List<Integer> sources;
	private List<Item> items = new ArrayList<>();

	public Orders(int size, int numberOfVertices, List<Integer> sources) {
		this.size = size;
		this.numberOfVertices = numberOfVertices;
		this.sources = sources;

		init();
	}

	private void init() {
		int i = 0;

		while (i < size) {
			int vertex = (int) (Math.random() * this.numberOfVertices);
			if (isNotASource(vertex)) {
				int index = (int) (Math.random() * Stock.NAMES.length);
				items.add(new Item(Stock.NAMES[index], vertex));

				i++;
			}
		}
	}

	private boolean isNotASource(int vertex) {
		return !sources.contains(vertex);
	}

	public List<Item> getItems() {
		return items;
	}
}

class Item {
	private String name;
	private int destination;

	public Item(String name, int destination) {
		this.name = name;
		this.destination = destination;
	}

	public String getName() {
		return name;
	}

	public int getDestination() {
		return destination;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}
}
