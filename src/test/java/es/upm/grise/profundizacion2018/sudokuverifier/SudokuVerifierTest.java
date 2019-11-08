package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.*;
import org.junit.Test;

public class SudokuVerifierTest {

	SudokuVerifier prueba = new SudokuVerifier();

	
	@Test
	public void falloR1Tamaño() {
		String sudoku = "478";
		assertEquals(-1, prueba.verify(sudoku));
    }
	
	@Test
	public void falloR1Letras() {
		String sudoku = "A00000000"+"000000000"+"000000000"+
				"000000000"+"0000A0000"+"000000000"+
				"000000000"+"000000000"+"000000000";
		assertEquals(-1, prueba.verify(sudoku));
    }
	
	
	
	
	
	
	// la fila de en medio tiene dos 1s
	@Test
	public void falloR3() {
		String sudoku = "123456789"+"123456789"+"123456789"+
				"123456789"+"123456781"+"123456789"+
				"123456789"+"123456789"+"123456789";
		assertEquals(-3, prueba.verify(sudoku));
    }
	
	// la fila de en medio colapsa con la primera en la 5ta columna (al menos)
	@Test
	public void falloR4() {
		String sudoku = "123456789"+"234567891"+"345678912"+
				"456789123"+"912354678"+"567891234"+
				"678912345"+"789123456"+"891234567";
		assertEquals(-4, prueba.verify(sudoku));
    }
	
	// error subgrip
	@Test
	public void falloR2() {
		String sudoku = "123456789"+"234567891"+"345678912"+
				"456789123"+"912345678"+"567891234"+
				"678912345"+"789123456"+"891234567";
		assertEquals(-2, prueba.verify(sudoku));
    }
	
	
	
	
	@Test
	public void pruebaCorrecta() {
		String sudoku = "123456789"+"789123456"+"456789123"+
						"312645978"+"978312645"+"645978312"+
						"231564897"+"897231564"+"564897231";
		assertEquals(0, prueba.verify(sudoku));
    }


	 
}