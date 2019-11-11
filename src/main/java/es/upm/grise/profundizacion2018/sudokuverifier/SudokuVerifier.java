package es.upm.grise.profundizacion2018.sudokuverifier;

import java.util.Arrays;

public class SudokuVerifier {

	public int verify(String candidateSolution) {

		if (candidateSolution == null || candidateSolution.length() != 81)
			return -1;

		char[] chars = candidateSolution.toCharArray();

		for (char c : chars) {
			if (!Character.isDigit(c) || c == '0')
				return -1;
		}

		// Sub-Grid
		int i = 0;
		int j = 0;
		while (i < chars.length - 20) {
			char[] subGrid = concatenate(Arrays.copyOfRange(chars, i, i + 3), Arrays.copyOfRange(chars, i + 9, i + 12),
					Arrays.copyOfRange(chars, i + 18, i + 21));
			if (hasDuplicates(subGrid))
				return -2;
			if (j == 2) {
				j = 0;
				i = i + 21;
			}
			i = i + 3;
			j++;
		}

		// Row
		i = 0;
		while (i < chars.length - 1) {
			char[] row = Arrays.copyOfRange(chars, i, i + 9);
			if (hasDuplicates(row))
				return -3;
			i = i + 9;
		}

		// Colum
		i = 0;
		while (i < 9) {
			char[] colum = new char[9];
			for (j = 0; j < colum.length - 1; j++) {
				colum[j] = chars[i + 9 * j];
			}
			if (hasDuplicates(colum))
				return -4;
			i++;
		}

		return 0;
	}

	private boolean hasDuplicates(char[] c) {
		for (int i = 0; i < c.length; i++) {
			for (int j = i + 1; j < c.length; j++) {
				if (c[i] == c[j]) {
					return true;
				}
			}
		}
		return false;
	}

	private char[] concatenate(char[] a, char[] b, char[] c) {
		char[] result = new char[9];
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			result[count++] = a[i];
		}
		for (int i = 0; i < c.length; i++) {
			result[count++] = b[i];
		}
		for (int i = 0; i < c.length; i++) {
			result[count++] = c[i];
		}
		return result;
	}
}
