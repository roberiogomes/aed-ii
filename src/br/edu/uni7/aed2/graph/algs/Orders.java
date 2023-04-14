package br.edu.uni7.aed2.graph.algs;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	private List<Item> items = new ArrayList<>();

	public Orders(int numberOfVertices, List<Integer> sources) {
		int i = 0;
		while (i < 10) {
			int vertex = (int) (Math.random() * numberOfVertices);
			if (!sources.contains(vertex)) {
				int index = (int) (Math.random() * Stock.NAMES.length);
				items.add(new Item(Stock.NAMES[index], vertex));

				i++;
			}
		}
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
