package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SudokuVerifierTest {
    //Sudoku bien hecho
	@Test
	public void test() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(0,sudoku.verify("812753649943682175675491283154237896369845721287169534521974368438526917796318452"));
		
    }
	//Sudoku vacio
	@Test
	public void test2() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(-1,sudoku.verify(null));
		
    }
	//Sudoku con caracter alfanumérico
	@Test
	public void test3() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(-1,sudoku.verify("81a753649943682175675491283154237896369845721287169534521974368438526917796318452"));
		
    }
	//Sudoku con mas de 81 caracteres
	@Test
	public void test4() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(-1,sudoku.verify("8198953649943682175675491283154237896369845721287169534521974368438526917796318452"));
		
    }
	//Sudoku con error en fila
	@Test
	public void test5() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(-3,sudoku.verify("812853649943682175675491283154237896369845721287169534521974368438526917796318452"));
		
    }
	//Sudoku con error en columna
	@Test
	public void test6() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(-4,sudoku.verify("182753649943682175675491283154237896369845721287169534521974368438526917796318452"));
		
    }
	//Sudoku con error en grid
	@Test
	public void test7() {
		SudokuVerifier sudoku = new SudokuVerifier();
		assertEquals(-2,sudoku.verify("812753649843682175675491283154237896369845721287169534521974368438526917796318452"));
		
    }
}
