package br.edu.uni7.aed2;

public class TesteHugeIntegerMinus {
	public static void main(String[] args) {
		HugeInteger n1 = new HugeInteger("123");
		HugeInteger n2 = new HugeInteger("23");
		System.out.println(n1.minus(n2));
		
		HugeInteger n3 = new HugeInteger("23");
		HugeInteger n4 = new HugeInteger("23");
		System.out.println(n3.minus(n4));
		
		HugeInteger n5 = new HugeInteger("45");
		HugeInteger n6 = new HugeInteger("23");
		System.out.println(n5.minus(n6));
		
		HugeInteger n7 = new HugeInteger("23");
		HugeInteger n8 = new HugeInteger("19");
		System.out.println(n7.minus(n8));
		
		HugeInteger n9 = new HugeInteger("113");
		HugeInteger n10 = new HugeInteger("19");
		System.out.println(n9.minus(n10));
		
		HugeInteger n11 = new HugeInteger("1003");
		HugeInteger n12 = new HugeInteger("19");
		System.out.println(n11.minus(n12));
		
		HugeInteger n13 = new HugeInteger("2");
		HugeInteger n14 = new HugeInteger("2");
		System.out.println("Resultado: " + n13.minus(n14));
	}
}
