package br.edu.uni7.aed2.graph.algs;

import java.util.HashMap;
import java.util.Map;

public class Stock {
	public static final String[] NAMES = { "iPhone 11", "Macbook Air", "Notebook Lenovo", "Carregador 100W", "Phone BT Baseus",
			"Alexa V2", "Mopi", "Teclado BT ABNT", "Pendrive 128G" };

	private Map<String, Integer> products = new HashMap<>();

	public Stock() {
		init();
	}

	private void init() {
		int size = (int) (Math.random() * 7) + 3;

		for (int i = 0; i < size; i++) {
			int index = (int) (Math.random() * NAMES.length);
			int quantity = (int) (Math.random() * 10) + 1;
			
			addProduct(NAMES[index], quantity);
		}
	}

	public void addProduct(String name, int amount) {
		if (!products.containsKey(name)) {
			products.put(name, amount);
		} else {
			int value = products.get(name);
			products.put(name, value + amount);
		}

	}

	public boolean contains(String name) {
		return products.containsKey(name);
	}

	public void removeProduct(String name) {
		if (products.containsKey(name)) {
			int value = products.get(name);

			if (value == 1) {
				products.remove(name);
			} else {
				value--;
				products.put(name, value);
			}
		} else {
			throw new IllegalArgumentException("Product not available:" + name);
		}
	}
	
	@Override
	public String toString() {
		return products.toString();
	}
}