package es.upm.grise.profundizacion2018.sudokuverifier;

/**
 * 
 * @author Fernando
 *
 */
public class SudokuVerifier {

	public int verify(String candidateSolution) {

		if (candidateSolution == null || candidateSolution.isEmpty() || candidateSolution.length() != 81)
			throw new IllegalArgumentException("Not valid input string length or format"); // Parse the total string

		int[][] sudoku = new int[9][9];

		// Parse the board R1
		for (int i = 0; i < candidateSolution.length(); i++) {
			int j = i / 9;
			int k = i % 9;
			int result;

			try {
				result = Integer.parseInt(candidateSolution.substring(i, i + 1));
			} catch (NumberFormatException ne) {
				return -1; // Not a valid integer from 0 to 9
			}

			sudoku[j][k] = result;
		}

		// Test the 9 subgrids R2
		for (int grid = 0; grid < 9; grid++) {

			int i = (grid / 3) * 3;
			int j = (grid % 3) * 3;

			int result = 0;

			// Test 1 grid
			for (int x = i; x < i + 3; x++) {
				for (int y = j; y < j + 3; y++) {
					result += sudoku[x][y];
				}
			}

			// Sum i, i=1 to 9
			if (result != 9 * 10 / 2) {
				return -2; // Not a valid grid
			}

		}

		// Test the rows R3
		for (int row = 0; row < 9; row++) {
			int result = 0;

			for (int i = 0; i < 9; i++) {
				result += sudoku[row][i];
			}

			// Sum i, i=1 to 9
			if (result != 9 * 10 / 2) {
				return -3; // Not a valid row
			}

		}

		// Test the cols R4
		for (int col = 0; col < 9; col++) {
			int result = 0;

			for (int i = 0; i < 9; i++) {
				result += sudoku[i][col];
			}

			// Sum i, i=1 to 9
			if (result != 9 * 10 / 2) {
				return -4; // Not a valid col
			}

		}

		return 0; // No errors
	}
}
