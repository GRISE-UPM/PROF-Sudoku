package es.upm.grise.profundizacion2018.sudokuverifier;

import java.util.regex.Pattern;

/**
 * A class to verify that a Sudoku is correct.
 */
public class SudokuVerifier {

	/**
	 * A patern used to verify that a string contains only digits from 1 to 9.
	 */
	private static final Pattern ONLY_NUMBERS = Pattern.compile("^[1-9]{81}$");

	/**
	 * Given a Sudoku as a String verifies that it is correct.
	 *
	 * @param candidateSolution The Sudoku to check.
	 * @return An exit status with several meanings.
	 */
	public int verify (final String candidateSolution) {

		// En los casos no especificados he decidido devolver -69 
		if (candidateSolution == null || candidateSolution.length() != 81 ) {
			return -69;
		}

		// Compruebo que solo contiene números
		if (!ONLY_NUMBERS.matcher(candidateSolution).matches()) {
			return -1;
		}

		// Cuadrado 3x3
		String subChar;
		for (int i = 1; i <= 9; i++) {
			subChar = "";
			for (int j = 0; j <= 2; j++) {
				subChar += "" + candidateSolution.charAt(j*9) + candidateSolution.charAt(j*9+1) + candidateSolution.charAt(j*9+2);
			}
			if (!subChar.contains(String.valueOf(i))) {
				return -2;
			}
		}

		// Filas
		for (int i = 0; i < 9; i++) {
			subChar = candidateSolution.substring(i * 9, (i + 1) * 9);
			for (int j = 1; j <= 9; j++) {
				if (!subChar.contains(String.valueOf(j))) {
					return -3;
				}
			}
		}

		// Columnas
		for (int i = 1; i <= 9; i++) {
			for (int j = 0; j < 9; j++) {
				subChar = "" + candidateSolution.charAt(j) + candidateSolution.charAt(j+9) + candidateSolution.charAt(j+18)+ candidateSolution.charAt(j+27) + candidateSolution.charAt(j+36) + candidateSolution.charAt(j+45) + candidateSolution.charAt(j+54) + candidateSolution.charAt(j+63) + candidateSolution.charAt(j+72);
				if (!subChar.contains(String.valueOf(i))) {
					return -4;
				}
			}
		}

		return 0;
	}

}
