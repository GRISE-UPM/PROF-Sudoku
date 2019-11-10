package es.upm.grise.profundizacion2018.sudokuverifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SudokuVerifier {

	// Valores de retorno de segun reglas.
	public final static int R0 = 0;
	public final static int R1 = -1;
	public final static int R2 = -2;
	public final static int R3 = -3;
	public final static int R4 = -4;

	public int verify (String candidateSolution) {

		// Verificamos que no sea nulo
		Objects.requireNonNull(candidateSolution);

		// Verificamos el tamaño
		if (candidateSolution.length() != 81) {
			throw new RuntimeException("Longitud del string incorrecta");
		}

		// Construimos la expresion regular para los grupos a leer
		Pattern pattern = Pattern.compile("([1-9]{9})");
		Matcher matcher = pattern.matcher(candidateSolution);

		int[][] board = new int[9][9];

		// Poblamos el tablero
		for (int row = 0; row < board.length; row++) {

			// Si no hace match alguna vez es que hay caracteres no validos
			if(!matcher.find()) {
				return R1;
			}

			// Obtenemos el grupo asociado al find y rellenamos celdas con ese grupo (fila)
			String group = matcher.group();
			for (int col = 0; col < board[row].length; col++) {

				board[row][col] = Character.getNumericValue(group.charAt(col));
			}
		}

		// Verificamos el resto de las condiciones

		if(!validGrids(board)) {
			return R2;
		}

		if(!validRows(board)) {
			return R3;
		}

		if(!validColumns(board)) {
			return R4;
		}

		return R0;
	}

	/**
	 * Metodo auxiliar para verificar todas las grids del sudoku
	 * @param board
	 * @return
	 */
	private boolean validGrids(int[][] board) {

		for (int row = 0; row < board.length; row+=3) {

			for (int col = 0; col < board[0].length; col+=3) {

				if (!validSubGrid(board, row, col)) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Metodo auxiliar para verificar si una grid concreta es valida
	 * @param board
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean validSubGrid(int[][] board, int row, int col) {

		List<Integer> auxGrid = new ArrayList<Integer>();

		int rowLimit = row+3;
		int colLimit = col+3;

		for (int i = row; i < rowLimit; i++) {

			for (int j=col; j < colLimit; j++) {

				int value = board[i][j];

				if (auxGrid.contains(value)) {

					return false;
				}
				auxGrid.add(value);
			}
		}

		return true;
	}

	/**
	 * Metodo auxiliar para verificar si todas las filas son validas
	 * @param board
	 * @return
	 */
	private boolean validRows(int[][] board) {

		List<Integer> auxRow = new ArrayList<Integer>();

		for (int row = 0; row < board.length; row++) {

			for (int col = 0; col < board[0].length; col++) {

				int value = board[row][col];

				if (auxRow.contains(value)) {

					return false;
				}
				auxRow.add(value);
			}

			auxRow.clear();
		}

		return true;
	}

	/**
	 * Metodo auxiliar para verificar si todas las columnas son validas
	 * @param board
	 * @return
	 */
	private boolean validColumns(int[][] board) {

		List<Integer> auxCol = new ArrayList<Integer>();

		for (int col = 0; col < board[0].length; col++) {

			for (int row = 0; row < board.length; row++) {

				int value = board[row][col];

				if (auxCol.contains(value)) {

					return false;
				}
				auxCol.add(value);
			}

			auxCol.clear();
		}

		return true;
	}
}
