package br.edu.uni7.aed2;
public class TesteHugeInteger {
	public static void main(String[] args) {
		HugeInteger n1 = new HugeInteger(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		HugeInteger n2 = new HugeInteger("-1");
		HugeInteger n3 = n1.plus(n2);

		System.out.println(n3);

		n1 = new HugeInteger("999");
		n2 = new HugeInteger("1");
		n3 = n1.plus(n2);

		System.out.println(n3);

		HugeInteger n4 = new HugeInteger(new int[] { 5, 4, 3, 3, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3 });

	}
}
