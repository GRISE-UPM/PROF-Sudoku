package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {
    
	@Test	// Test correcto
	public void test_correcto() {
		assertEquals(0, SudokuVerifier.verify(	"123456789"+
												"456789123"+
												"789123456"+
												"234567891"+
												"567891234"+
												"891234567"+
												"345678912"+
												"678912345"+
												"912345678"));
    }
	
	@Test	// Falla por longitud del input
	public void test_longitud() {
		assertEquals(-1, SudokuVerifier.verify(	"123456789"+
												"456789123"+
												"789123456"+
												"234567891"+
												"567891234"+
												"891234567"+
												"345678912"+
												"678912345"+
												"9123456781"));
	}
	
	@Test	// Falla por caracter incorrecto en el input
	public void test_caracterIncorrecto() {
		assertEquals(-1, SudokuVerifier.verify(	"1234-6789"+
												"456789123"+
												"789123456"+
												"234567891"+
												"567891234"+
												"891234567"+
												"345678912"+
												"678912345"+
												"912345678"));
	}
	
	@Test	// Falla por subgrids
	public void test_subgrids() {
		assertEquals(-2, SudokuVerifier.verify(	"123456789"+
												"234567891"+
												"345678912"+
												"456789123"+
												"567891234"+
												"678912345"+
												"789123456"+
												"891234567"+
												"912345678"));
	}
	
	@Test	// Falla por filas
	public void test_filas() {
		assertEquals(-3, SudokuVerifier.verify(	"423456789"+
												"156789123"+
												"789123456"+
												"234567891"+
												"567891234"+
												"891234567"+
												"345678912"+
												"678912345"+
												"912345678"));
	}
	
	@Test	// Falla por columnas
	public void test_columnas() {
		assertEquals(-4, SudokuVerifier.verify(	"213456789"+
												"456789123"+
												"789123456"+
												"234567891"+
												"567891234"+
												"891234567"+
												"345678912"+
												"678912345"+
												"912345678"));
    }
	
	
	
}
