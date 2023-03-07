package br.edu.uni7.aed2;

public class HugeInteger {
	private final int[] number;

	public HugeInteger(String n) {
		this.number = new int[n.length()];

		for (int i = 0, j = number.length - 1; i < number.length; i++, j--) {
			char c = n.charAt(j);

			number[i] = Character.digit(c, 10);
		}
	}

	public HugeInteger(int[] n) {
		this.number = revert(n);
	}

	/**
	 * Realiza a subtração (números naturais)
	 * 
	 * @param other O segundo operando da subtração
	 * @return Um novo HugeNumber resultado da subtração
	 */
	public HugeInteger minus(HugeInteger other) {
		int[] result = new int[this.number.length];
		
		int vemUm = 0;
		for (int i = 0; i < other.number.length; i++) {
			int a = this.number[i];
			int b = other.number[i];
			
			if ((a + vemUm) >= b) {
				result[i] = (a + vemUm) - b;
				vemUm = 0;
			} else {
				result[i] = (a + vemUm) - b + 10;
				vemUm = -1;
			}
		}
		
		for (int i = other.number.length; i < result.length; i++) {
			int a = this.number[i];
			
			if ((a + vemUm) >= 0) {
				result[i] = (a + vemUm);
				vemUm = 0;
			} else {
				result[i] = (a + vemUm) + 10;
				vemUm = -1;
			}
		}
		
		result = revert(result);

		return new HugeInteger(result);
	}

	/**
	 * Compara o número passado com o número atual
	 * 
	 * @param other O outro número
	 * @return -1 caso o número atual seja maior, 0 caso os números sejam iguais e
	 *         +1 caso o número passado seja maior.
	 */
	public int compare(HugeInteger other) {
		int result = 0;
		
		if (this.number.length > other.number.length) {
			result = -1;
		} else if (this.number.length < other.number.length) {
			result = +1;
		} else {
			for (int i = this.number.length - 1; i >= 0; i--) {
				int a = this.number[i];
				int b = other.number[i];
				
				if (a > b) {
					result = -1;
				} else if (a < b) {
					result = +1;
				} 
			}
		}
		
		return result;
	}

	public HugeInteger plus(HugeInteger other) {
		int[] max = null;
		int[] min = null;

		if (this.number.length > other.number.length) {
			max = this.number;
			min = other.number;
		} else {
			max = other.number;
			min = this.number;
		}

		int[] result = new int[max.length + 1];

		int vaiUm = 0;
		for (int i = 0; i < min.length; i++) {
			if ((max[i] + min[i] + vaiUm) >= 10) {
				result[i] = (max[i] + min[i] + vaiUm) - 10;
				vaiUm = 1;
			} else {
				result[i] = (max[i] + min[i] + vaiUm);
				vaiUm = 0;
			}
		}

		for (int i = min.length; i < max.length; i++) {
			if ((max[i] + vaiUm) >= 10) {
				result[i] = max[i] + vaiUm - 10;
				vaiUm = 1;
			} else {
				result[i] = max[i] + vaiUm;
				vaiUm = 0;
			}
		}

		result[result.length - 1] = vaiUm;

		result = revert(result);

		return new HugeInteger(result);
	}

	private int[] revert(int[] array) {
		int[] result = new int[array.length];

		for (int i = 0, j = array.length - 1; i < result.length; i++, j--) {
			result[i] = array[j];
		}

		return result;
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();

		int[] copy = revert(number);

		int i = 0;
		if (copy[0] == 0 && copy.length > 1) {
			i = 1;
		}

		for (; i < copy.length; i++) {
			int n = copy[i];
			buffer.append(n);
		}

		return buffer.toString();
	}
}
