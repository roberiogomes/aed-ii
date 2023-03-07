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
		
		HugeInteger n5 = new HugeInteger("123");
		HugeInteger n6 = new HugeInteger("23");
		
		System.out.println(n5.compare(n6));
		
		HugeInteger n7 = new HugeInteger("23");
		HugeInteger n8 = new HugeInteger("123");
		
		System.out.println(n7.compare(n8));
		
		HugeInteger n9 = new HugeInteger("23");
		HugeInteger n10 = new HugeInteger("12");
		
		System.out.println(n9.compare(n10));
		
		HugeInteger n11 = new HugeInteger("23");
		HugeInteger n12 = new HugeInteger("23");
		
		System.out.println(n11.compare(n12));
		
		HugeInteger n13 = new HugeInteger("12");
		HugeInteger n14 = new HugeInteger("23");
		
		System.out.println(n13.compare(n14));

	}
}
