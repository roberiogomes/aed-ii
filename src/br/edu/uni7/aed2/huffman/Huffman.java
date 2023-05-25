package br.edu.uni7.aed2.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Huffman {
	private String text;
	private Map<Character, Integer> charMap;
	private Map<Character, String> encodingTable;

	public Huffman(String text) {
		this.text = text;
		charMap = new HashMap<>();
		encodingTable = new HashMap<>();
	}

	public String encode() {
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);

			if (!charMap.containsKey(c)) {
				charMap.put(c, 0);
			}

			int frequency = charMap.get(c);
			charMap.put(c, frequency + 1);
		}

		List<Node> nodes = new ArrayList<>();
		for (Character character : charMap.keySet()) {
			int frequency = charMap.get(character);

			nodes.add(new Node(character, frequency));
		}

		while (nodes.size() > 1) {
			Collections.sort(nodes, new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					int result = 0;
					
					if (o1.getFrequency() == o2.getFrequency()) {
						if (o1.getCharacter() != null && o2.getCharacter() != null) {
							result = o1.getCharacter().compareTo(o2.getCharacter());	
						}
					} else {
						result = o1.getFrequency() - o2.getFrequency();
					}
					
					return result;
				}
			});
			
			System.out.println(nodes);

			Node n1 = nodes.remove(0);
			Node n2 = nodes.remove(0);

			Node n = new Node();
			n.setCharacter('*');
			n.setFrequency(n1.getFrequency() + n2.getFrequency());
			n.setLeft(n1);
			n.setRight(n2);

			nodes.add(n);
		}

		Node root = nodes.get(0);
		root.buildPath();
		buildPaths(root, encodingTable);

		System.out.println(encodingTable);
		
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			
			String s = encodingTable.get(c);
			builder.append(s);
		}

		return builder.toString();
	}

	public void buildPaths(Node parent, Map<Character, String> encodingTable) {
		Node left = parent.getLeft();
		if (left != null) {
			Character c = left.getCharacter();
			String path = left.getPath();

			encodingTable.put(c, path);

			buildPaths(left, encodingTable);
		}

		Node right = parent.getRight();
		if (right != null) {
			Character c = right.getCharacter();
			String path = right.getPath();

			encodingTable.put(c, path);

			buildPaths(right, encodingTable);
		}
	}

	public static void main(String[] args) {
		Huffman huffman = new Huffman("abracadabra");

		String encoded = huffman.encode();
		
		System.out.println(encoded);
	}

}
