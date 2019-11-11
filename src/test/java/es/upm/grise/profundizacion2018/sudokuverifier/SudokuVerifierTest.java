package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SudokuVerifierTest {

	private SudokuVerifier v = new SudokuVerifier();

	// Test correct
	@Test
	public void test1() {
		assertEquals(0, v.verify("745128369369475812812639457296741583431852796587963241924517638678394125153286974"));
	}

	// Test null
	@Test
	public void test2() {
		assertEquals(-1, v.verify(null));
	}

	// Test not 81 length
	@Test
	public void test3() {
		assertEquals(-1, v.verify("74541924517638678394125153286974"));
	}

	// Test with non digit characters
	@Test
	public void test4() {
		assertEquals(-1, v.verify("74512836dfwcq75812812639457296741583431852796587963241924517638678394125153286974"),
				0);
	}

	// Test with 0s
	@Test
	public void test5() {
		assertEquals(-1, v.verify("745128369369475802812639457296741583431852796587963241924517638678394125153286974"),
				0);
	}

	// Test wrong sub-grid
	@Test
	public void test6() {
		assertEquals(-2, v.verify("745128369379475812812639457296741583431852796587963241924517638678394125153286974"));
	}

	// Test wrong row
	@Test
	public void test7() {
		assertEquals(-3, v.verify("745728369369415812812639457296741583431852796587963241924517638678394125153286974"));
	}

	// Test wrong colum
	@Test
	public void test8() {
		assertEquals(-4, v.verify("745128369369475812812639457296741583431852796785963241924517638678394125153286974"));
	}
}
