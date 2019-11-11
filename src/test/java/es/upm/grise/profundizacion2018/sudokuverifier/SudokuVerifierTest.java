package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SudokuVerifierTest {
	public SudokuVerifier sudoku= new SudokuVerifier();
	
	//Test for expected length
	@Test(expected = RuntimeException.class)
	public void test_failure1() {
    		String solution = "1234567891";
    		sudoku.verify(solution);
    }
	
	//Test for correct characters (only digits!)
	@Test(expected = RuntimeException.class)
	public void test_failure2() {
    		String solution = "a23456789123456789123456789123456789123456789123456789123456789123456789123456789";
    		sudoku.verify(solution);
    }
	
	//Test for non-negative numbers
	@Test
	public void test_R1() {
    		String solution = "-12345678912345678912345678912345678912345678912345678912345678912345678912345678";
    		assertEquals(-1, sudoku.verify(solution));
    }
	
	//Test for subgrid validation
	@Test
	public void test_R2() {
    		String solution = "123456789425456789123456789123456789123456789123456789123456789123456789123456789";
    		assertEquals(-2, sudoku.verify(solution));
    }
	//Test for row validation
	@Test
	public void test_R3() {
	    	String solution = "735614872842973561961285394286349157413857926579126438157492683694738215328561749";
	    	assertEquals(-3, sudoku.verify(solution));
	   }
		
	//Test for column validation
	@Test
	public void test_R4() {
	    	String solution = "735614892842973561961285374286349157143857926579126438157492683694738215328561749";
	    	assertEquals(-4, sudoku.verify(solution));
	   }
	//Test for correct sudoku
	@Test
	public void test_correctSudoku() {
	    	String solution = "735614892842973561961285374286349157413857926579126438157492683694738215328561749";
	    	assertEquals(0, sudoku.verify(solution));
	   }
	
}
