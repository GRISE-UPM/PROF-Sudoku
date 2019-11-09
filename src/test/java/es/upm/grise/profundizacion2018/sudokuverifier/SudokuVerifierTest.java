package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SudokuVerifierTest {
	
	SudokuVerifier sudokuVerifier = new SudokuVerifier();
	
	/** ================ TESTS REGLA 1 ================ **/
	@Test
	
	/** Evalua la regla 1 con un null */
	public void rule1_fails_null() {
		String sudokuNull = null;
		assertEquals(-1,sudokuVerifier.verify(sudokuNull));						
    }
	
	@Test
	/** Evalua la regla 1 con longitud 81 pero con un 0*/
	public void rule1_fails_zeroValue() {
		String sudokuZeroValue = 
				"023456789"+ //Contiene 0
				"123456789"+
				"123456789"+
				"123456789"+
				"123456789"+
				"123456789"+
				"123456789"+
				"123456789"+
				"123456789";
		assertEquals(-1,sudokuVerifier.verify(sudokuZeroValue));						
    }
    
	@Test
	/** Evalua la regla 1 con un tamaño > 81*/
	public void rule1_fails_size() {
		String sudokuBigSize = 
				"123456789"+
				"123456789"+
				"123456789"+
				"123456789"+
				"123456789"+
				"123456789"+
				"123456789"+
				"123456789"+
				"123456789"+
				"123456789";
		assertEquals(-1,sudokuVerifier.verify(sudokuBigSize));						
    }
	
	@Test
	/** Evalua la regla 1 con un tamaño = 81 pero con letras metidas en algunas posiciones */
	public void rule1_fails_nonNumeric() {
		String sudokuNonNumeric = 
				"123456789"+
				"123456789"+
				"123456789"+
				"12TEST789"+ //Contiene letras
				"12TEST789"+ //Contiene letras
				"123456789"+
				"123456789"+
				"123456789"+
				"123456789";
		assertEquals(-1,sudokuVerifier.verify(sudokuNonNumeric));						
    }
	
	/** ================ TEST REGLA 2 ================ **/
	@Test
	/** Evalua la regla 2 con la primera submatriz con numero repetido*/
	public void rule2_fails_repeatingNumberSubmatrix() {
		String sudokuSubmatrixError = 
				"123456789"+
				"234567891"+
				"345678912"+
				"912345678"+
				"567891234"+
				"456789123"+
				"789123456"+
				"678912345"+
				"891234567";
		assertEquals(-2,sudokuVerifier.verify(sudokuSubmatrixError));						
    }
	
	/** ================ TEST REGLA 3 ================ **/
	
	@Test
	/** Evalua la regla 3 con numeros repetidos*/
	public void rule3_fails_repeatingNumberRow() {
		String sudokuRepeatingNumbersRow = 
				"123456789"+
				"234567891"+
				"345678912"+ 
				"456789123"+
				"567891234"+
				"678912345"+
				"789123456"+
				"891234567"+
				"992345678"; //9 Se repite
		assertEquals(-3,sudokuVerifier.verify(sudokuRepeatingNumbersRow));						
    }
	
	/** ================ TEST REGLA 4 ================ **/
	@Test
	/** Evalua la regla 4 con columnas con numeros repetidos*/
	public void rule4_fails_repeatingNumberCol() {
		String sudokuRepeatingNumbersCol = 
				"123456789"+
				"234567891"+
				"345678912"+ 
				"456789123"+
				"567891234"+
				"678912345"+
				"789123456"+
				"981234567"+ //9 se repite en la primera columna para esta fila y la de abajo
				"912345678"; 
		assertEquals(-4,sudokuVerifier.verify(sudokuRepeatingNumbersCol));						
    }
	
	/** ================ TEST SUDOKU OK ================ **/
	
	@Test
	/** Evalua un sudoku que esta bien */
	public void sudokuOK() {
		String sudokuOK = 
				"975218463"+
				"486359721"+
				"123467598"+ 
				"791845632"+
				"562731849"+
				"348692175"+
				"659124387"+
				"237586914"+
				"814973256"; 
		assertEquals(0,sudokuVerifier.verify(sudokuOK));						
    }
}
