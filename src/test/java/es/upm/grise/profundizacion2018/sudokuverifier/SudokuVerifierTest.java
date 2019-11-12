package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SudokuVerifierTest {
    
	@Test
	public void test1_menos81caracteres() {
    		SudokuVerifier o = new SudokuVerifier();
    		assertEquals(-5, o.verify("123"), 0);
    }
	
	@Test
	public void test2_correcto() {
    		SudokuVerifier o = new SudokuVerifier();
    		assertEquals(0, o.verify("316578492529134768487629531263415987974863125851792643138947256692351874745286319"), 0);
    }
	
	
	@Test
	public void test3_regla1() {
    		SudokuVerifier o = new SudokuVerifier();
    		assertEquals(-1, o.verify("31657a492529134768487629531263415987974863125851792643138947256692351874745286319"), 0);
    }
	
	@Test
	public void test4_regla2() {
    		SudokuVerifier o = new SudokuVerifier();
    		assertEquals(-2, o.verify("316578492539134768487629531263415987974863125851792643138947256692351874745286319"), 0);
    }
	
	@Test
	public void test5_regla3() {
    		SudokuVerifier o = new SudokuVerifier();
    		assertEquals(-3, o.verify("316378492529134768487629531263415987974863125851792643138947256692351874745286319"), 0);
    }
	
	@Test
	public void test6_regla4() {
    		SudokuVerifier o = new SudokuVerifier();
    		assertEquals(-4, o.verify("316578492529134768487629531363415987974863125851792643138947256692351874745286319"), 0);
    }
}
