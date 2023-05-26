package br.edu.uni7.aed2.hasing;

import java.util.Arrays;

import br.edu.uni7.aed2.huffman.util.Student;

public class HashTable {
	private String[] slots;
	private Student[] data;
	private int size;
	private int amount;

	public HashTable(int size) {
		this.size = size;
		this.slots = new String[size];
		this.data = new Student[size];
	}

	public void put(String key, Student student) {
		int hashValue = hashFunction(key);

		if (slots[hashValue] == null) {
			slots[hashValue] = key;
			data[hashValue] = student;
		} else {
			if (key.equals(slots[hashValue])) {
				data[hashValue] = student;
			} else {
				int next = rehash(hashValue);

				while (slots[next] != null && !key.equals(slots[next])) {
					next = rehash(hashValue);
				}

				if (slots[next] == null) {
					slots[next] = key;
					data[next] = student;
				} else {
					data[next] = student;
				}
			}
		}
	}

	private int rehash(int hashValue) {
		return (hashValue + 1) % size;
	}

	private int hashFunction(String key) {
		int result = 0;

		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);

			result += Character.getNumericValue(c) * (i + 1);
		}

		return result % this.size;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(data);
	}
	
	public static void main(String[] args) {
		HashTable table = new HashTable(13);
		
		Student s1 = new Student("123", "Thiago");
		Student s2 = new Student("321", "Andreia");
		Student s3 = new Student("432", "Victor");
		
		table.put(s1.getEnrollment(), s1);
		table.put(s2.getEnrollment(), s2);
		table.put(s3.getEnrollment(), s3);
		
		System.out.println(table);
	}
}
