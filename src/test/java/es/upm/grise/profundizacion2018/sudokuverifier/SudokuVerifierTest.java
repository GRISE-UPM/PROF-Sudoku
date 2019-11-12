package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests that the SudokuVerifier class is correct.
 */
public class SudokuVerifierTest {

	/**
	 * The verifier instance.
	 */
	public SudokuVerifier tester = new SudokuVerifier();

	@Test
	public void unknownChecker() {
		final String msg = "Prueba para un Sudoku incorrecto en los casos no especificados";
		String input = "";
		input += "534" + "678" + "912";
		input += "672" + "195" + "348";
		input += "198" + "342" + "567";
		input += "859" + "761" + "423";
		input += "426" + "853" + "791";
		input += "713" + "924" + "856";
		input += "961" + "537" + "284";
		input += "287" + "419" + "635";
		input += "345" + "286" + "179";

		input += "534" + "678" + "912";

		assertEquals(msg, -69, tester.verify(null));
		assertEquals(msg, -69, tester.verify(""));
		assertEquals(msg, -69, tester.verify(input));
	}

	@Test
	public void digitsChecker() {
		final String msg = "Prueba para un Sudoku con caracteres ilegales";
		String input = "";
		input += "-34" + "678" + "912";
		input += "672" + "195" + "348";
		input += "198" + "342" + "567";
		input += "859" + "761" + "423";
		input += "426" + "853" + "791";
		input += "713" + "924" + "856";
		input += "961" + "537" + "284";
		input += "287" + "419" + "635";
		input += "345" + "286" + "179";
		assertEquals(msg, -1, tester.verify(input));
	}

	@Test
	public void squareChecker() {
		final String msg = "Prueba para un Sudoku con uno más cuadrados de 3x3 incorrectos";
		String input = "";
		input += "634" + "978" + "512";
		input += "672" + "195" + "348";
		input += "198" + "342" + "567";
		input += "859" + "761" + "423";
		input += "426" + "853" + "791";
		input += "713" + "924" + "856";
		input += "961" + "537" + "284";
		input += "287" + "419" + "635";
		input += "345" + "286" + "179";
		assertEquals(msg, -2, tester.verify(input));
	}

	@Test
	public void rowChecker() {
		final String msg = "Prueba para un Sudoku con una o más filas incorrectas";
		String input = "";
		input += "134" + "678" + "912";
		input += "572" + "195" + "348";
		input += "698" + "342" + "567";
		input += "859" + "761" + "423";
		input += "426" + "853" + "791";
		input += "713" + "924" + "856";
		input += "961" + "537" + "284";
		input += "287" + "419" + "635";
		input += "345" + "286" + "179";
		assertEquals(msg, -3, tester.verify(input));
	}

	@Test
	public void columnChecker() {
		final String msg = "Prueba para un Sudoku con una o más columnas incorrectas";
		String input = "";
		input += "453" + "678" + "912";
		input += "672" + "195" + "348";
		input += "198" + "342" + "567";
		input += "859" + "761" + "423";
		input += "426" + "853" + "791";
		input += "713" + "924" + "856";
		input += "961" + "537" + "284";
		input += "287" + "419" + "635";
		input += "345" + "286" + "179";
		assertEquals(msg, -4, tester.verify(input));
	}

	@Test
	public void correctSudoku() {
		final String msg = "Prueba para un Sudoku correcto";
		String input = "";
		input += "534" + "678" + "912";
		input += "672" + "195" + "348";
		input += "198" + "342" + "567";
		input += "859" + "761" + "423";
		input += "426" + "853" + "791";
		input += "713" + "924" + "856";
		input += "961" + "537" + "284";
		input += "287" + "419" + "635";
		input += "345" + "286" + "179";
		assertEquals(msg, 0, tester.verify(input));
	}

}
