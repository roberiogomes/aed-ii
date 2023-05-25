package br.edu.uni7.aed2.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenericBinHeap<T, C extends Comparator<T>> {
	private int currentSize;
	private List<T> heapList;
	private Comparator<T> comparator;

	public GenericBinHeap(Comparator<T> comparator) {
		this.comparator = comparator;
		this.currentSize = 0;
		this.heapList = new ArrayList<>();
		this.heapList.add(null);
	}
	
	public GenericBinHeap(T items[], Comparator<T> comparator) {
		this(comparator);

		buildHeap(items);
	}

	private void buildHeap(T[] items) {
		int i = items.length / 2;
		this.currentSize = items.length;
		
		for (T item : items) {
			heapList.add(item);
		}
		
		while (i > 0) {
			percDown(i);
			i--;
		}
	}

	public void insert(T k) {
		heapList.add(k);
		currentSize++;

		percUp(currentSize);
	}

	public T delTop() {
		T result = heapList.get(1);
		heapList.set(1, heapList.get(currentSize));
		heapList.remove(currentSize);
		currentSize--;
		percDown(1);

		return result;
	}

	private void percDown(int i) {
		while ((i * 2) <= currentSize) {
			Integer mc = minChild(i);

			// heapList.get(i) > heapList.get(mc)
			if (comparator.compare(heapList.get(i), heapList.get(mc)) > 0) {
				T tmp = heapList.get(i);
				heapList.set(i, heapList.get(mc));
				heapList.set(mc, tmp);
			} else {
				break;
			}

			i = mc;
		}
	}

	private Integer minChild(int i) {
		if (i * 2 + 1 > currentSize) {
			return i * 2;
		} else {
			if (comparator.compare(heapList.get(i * 2),  heapList.get(i * 2 + 1)) < 0) {
				return i * 2;
			} else {
				return i * 2 + 1;
			}
		}
	}

	private void percUp(int index) {
		while (index / 2 > 0) {
			if (comparator.compare(heapList.get(index), heapList.get(index / 2)) < 0) {
				T tmp = heapList.get(index / 2);
				heapList.set(index / 2, heapList.get(index));
				heapList.set(index, tmp);
			} else {
				break;
			}

			index = index / 2;
		}
	}

	public T findMin() {
		return heapList.get(1);
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public int size() {
		return currentSize;
	}

	@Override
	public String toString() {
		return heapList.toString();
	}
}
