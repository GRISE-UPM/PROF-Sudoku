package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

public class SudokuVerifierTest {
    
	private SudokuVerifier sudoku;
	
	@Before
	public void before() {
		sudoku = new SudokuVerifier();
	}
	
	
	@Test
	public void test_R5a() {
    	String solucion = null;
    	assertEquals(-5, sudoku.verify(solucion));
    }
	
	@Test
	public void test_R5b() {
		String solucion = "123456789" + "987654321";
		assertEquals(-5, sudoku.verify(solucion));
    }
	
	@Test
	public void test_R1() {
		String solucion = "28A936475" + "45927863A" + "673A54829" //Los 1 se cambian por A
						+ "542369A87" + "3968A7542" + "8A7542396"
						+ "A24693758" + "7684259A3" + "93578A264";
		assertEquals(-1, sudoku.verify(solucion));
	}
	
	@Test
	public void test_R2() {
		String solucion = "281936475" + "459278631" + "673154829"
						+ "542369187" + "396817542" + "817542396"
						+ "124693758" + "764825913" + "935781264"; //En el segundo 48 y deberia ser 84
		assertEquals(-2, sudoku.verify(solucion));
    }
	
	@Test
	public void test_R3() {
		String solucion = "281936475" + "459278631" + "673154829"
						+ "542369182" + "396817547" + "817542396" //En el primero y segundo, ultimos digitos 2 y 7 al reves
						+ "124693758" + "768425913" + "935781264";
		assertEquals(-3, sudoku.verify(solucion));
    }
	
	@Test
	public void test_R4() {
		String solucion = "281936475" + "459278631" + "673154829"
						+ "542369187" + "396817542" + "817542396"
						+ "124693758" + "768425913" + "935718264"; //En el ultimo se cambian 81 por 18
		assertEquals(-4, sudoku.verify(solucion));
    }
	
	@Test
	public void test_ok() {
		String solucion = "281936475" + "459278631" + "673154829"
						+ "542369187" + "396817542" + "817542396"
						+ "124693758" + "768425913" + "935781264";
		assertEquals(0, sudoku.verify(solucion));
    }
}