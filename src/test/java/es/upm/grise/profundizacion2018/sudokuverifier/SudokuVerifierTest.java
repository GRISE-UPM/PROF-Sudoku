package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.*;
import org.junit.Test;

public class SudokuVerifierTest {
    
	SudokuVerifier prueba = new SudokuVerifier();
	
	@Test
	public void pruebaCorrecta() {
		String sudoku = "735614892"+"842973561"+"961285374"+
						"286349157"+"413857926"+"579126438"+
						"157492683"+"694738215"+"328561749";
		assertEquals(0, prueba.verify(sudoku));
    }
	
	@Test
	public void pruebaIncorrectaFormato() {
		String sudoku = "000000000"+"842973561"+"961285374"+
						"286349157"+"413857926"+"579126438"+
						"157492683"+"694738215"+"328561749";
		assertEquals(-1, prueba.verify(sudoku));
    }
	
	@Test
	public void pruebaIncorrectaTamaño() {
		String sudoku = "000000000"+"842973561"+"961285374"+
						"286349157"+"413857926"+"579126438";
		assertEquals(-1, prueba.verify(sudoku));
    }
	
	@Test
	public void pruebaIncorrectaCuadricula() {
		String sudoku = "775614892"+"842973561"+"961285374"+
						"286349157"+"413857926"+"579126438"+
						"157492683"+"694738215"+"328561749";
		assertEquals(-2, prueba.verify(sudoku));
    }

	@Test
	public void pruebaIncorrectaFila() {
		String sudoku = "683614892"+"215973561"+"749285374"+
						"286349157"+"413857926"+"579126438"+
						"157492683"+"694738215"+"328561749";
		assertEquals(-3, prueba.verify(sudoku));
    }
	
	// No se puede hacer una prueba de columna, ya que va a fallar la fila
}
