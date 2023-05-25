package br.edu.uni7.aed2.huffman;

public class Node {
	private Character character;
	
	private int frequency;
	
	private Node left;
	
	private Node right;
	
	private String path;

	public Node() {
		this(null, 0);
	}

	public Node(Character character, int frequency) {
		super();
		this.character = character;
		this.frequency = frequency;
		this.path = "";
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "{ char : " + character + ", frequency : " + frequency + "}";
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	public String getPath() {
		return path;
	}
	
	public String buildPath() {
		if (left != null) {
			left.setPath(this.path + "0");
			left.buildPath();
		}
		
		if (right != null) {
			right.setPath(this.path + "1");
			right.buildPath();
		}
		
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
}
