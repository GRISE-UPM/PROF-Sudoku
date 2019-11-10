package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SudokuVerifierTest {

	private SudokuVerifier sudokuVerifier;

	@Before
	public void setUp() {
		sudokuVerifier = new SudokuVerifier();
	}

	@Test(expected = NullPointerException.class)
	public void shouldNotAcceptNull() {

		sudokuVerifier.verify(null);
	}

	@Test(expected = RuntimeException.class)
	public void shouldNotAcceptIncorrectLength() {

		String sudoku = "123" + "456" + "789" +
				"123" + "456" + "789" +
				"123" + "456" + "789" +
				"123" + "456" + "789" +
				"123" + "456" + "789" +
				"123" + "456" + "789" +
				"123" + "456" + "789" +
				"123" + "456" + "789" +
				"123" + "456" + "789" +
				"123" + "456" + "789";

		sudokuVerifier.verify(sudoku);
	}

	@Test
	public void shouldNotAcceptInvalidCharacters() {

		String sudoku =  "a1b" + "678" + "945"
				+ "584" + "239" + "761"
				+ "967" + "145" + "328"
				+ "372" + "461" + "589"
				+ "691" + "583" + "274"
				+ "458" + "792" + "613"
				+ "836" + "924" + "157"
				+ "219" + "857" + "436"
				+ "745" + "316" + "892";

		int result = sudokuVerifier.verify(sudoku);

		assertEquals(-1, result);
	}

	@Test
	public void shouldReturnInvalidGrid() {

		String sudoku =  "123" + "678" + "945"
				+ "184" + "239" + "761"
				+ "967" + "145" + "328"
				+ "372" + "461" + "589"
				+ "691" + "583" + "274"
				+ "458" + "792" + "613"
				+ "836" + "924" + "157"
				+ "219" + "857" + "436"
				+ "745" + "316" + "892";

		int result = sudokuVerifier.verify(sudoku);

		assertEquals(-2, result);
	}

	@Test
	public void shouldReturnInvalidRow() {

		String sudoku =  "123" + "678" + "941"
				+ "584" + "239" + "765"
				+ "967" + "145" + "328"
				+ "372" + "461" + "589"
				+ "691" + "583" + "274"
				+ "458" + "792" + "613"
				+ "836" + "924" + "157"
				+ "219" + "857" + "436"
				+ "745" + "316" + "892";

		int result = sudokuVerifier.verify(sudoku);

		assertEquals(-3, result);
	}

	@Test
	public void shouldReturnInvalidColumn() {

		String sudoku =   "213" + "678" + "945"
				+ "584" + "239" + "761"
				+ "967" + "145" + "328"
				+ "372" + "461" + "589"
				+ "691" + "583" + "274"
				+ "458" + "792" + "613"
				+ "836" + "924" + "157"
				+ "219" + "857" + "436"
				+ "745" + "316" + "892";

		int result = sudokuVerifier.verify(sudoku);

		assertEquals(-4, result);
	}

	@Test
	public void shouldVerifyCorrectSudoku() {

		String sudoku =   "123" + "678" + "945"
				+ "584" + "239" + "761"
				+ "967" + "145" + "328"
				+ "372" + "461" + "589"
				+ "691" + "583" + "274"
				+ "458" + "792" + "613"
				+ "836" + "924" + "157"
				+ "219" + "857" + "436"
				+ "745" + "316" + "892";

		int result = sudokuVerifier.verify(sudoku);

		assertEquals(0, result);
	}
}
