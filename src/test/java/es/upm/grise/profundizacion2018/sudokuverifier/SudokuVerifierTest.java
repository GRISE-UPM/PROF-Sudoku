package es.upm.grise.profundizacion2018.sudokuverifier;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Fernando
 *
 */
public class SudokuVerifierTest {

	private static SudokuVerifier sv;

	@BeforeClass
	public static void setUpClass() {
		sv = new SudokuVerifier();
	}

	@Test
	public void TestCorrectSolution() {
		String valid_solution = "974132865635897241812645793126489357598713624743526189259378416467251938381964572";
		assertEquals(0, sv.verify(valid_solution));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TestStringDifferentLength() {
		String invalid_solution = "97413286563589724181264579312648935759871362474352618";
		sv.verify(invalid_solution);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TestStringNull() {
		String invalid_solution = null;
		sv.verify(invalid_solution);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TestStringEmpty() {
		String invalid_solution = "";
		sv.verify(invalid_solution);
	}
	
	// Test a cell with a non integer value (voids R1)
	@Test
	public void TestR1NonIntegerParseableChars() {
		String invalid_solution = "a74132865635897241812645793126489357598713624743526189259378416467251938381964572";
		assertEquals(-1, sv.verify(invalid_solution));
	}
		
	@Test
	public void TestR2InvalidOnlySubgridRule() {
		String invalid_solution = "123456789234567891345678912456789123567891234678912345789123456891234567912345678";
		assertEquals(-2, sv.verify(invalid_solution));
	}
	
	@Test
	public void TestR3InvalidOnlyRowsRule() {
		String invalid_solution = "934132865675897241812645793126489357598713624743526189259378416467251938381964572";
		assertEquals(-3, sv.verify(invalid_solution));
	}
	
	@Test
	public void TestR4InvalidOnlyColsRule() {
		String invalid_solution = "974132865365897241812645793126489357598713624743526189259378416467251938381964572";
		assertEquals(-4, sv.verify(invalid_solution));
	}
	
}
