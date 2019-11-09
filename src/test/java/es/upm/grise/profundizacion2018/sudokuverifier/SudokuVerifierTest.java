package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class SudokuVerifierTest {
    
SudokuVerifier objeto;
	
	@Before
	public void setup() {
		objeto = new SudokuVerifier();
	}
	
	
	@Test //Se ha insertado el numero '0' al principio de la solucion.
	public void testHayUnCero() throws Exception {
		String solucion = "045892367"
		 				+ "627134958"
		 				+ "893567124"
		 				+ "259413876"
		 				+ "376958241"
		 				+ "418276593"
		 				+ "964385712"
		 				+ "731629485"
		 				+ "582741639";
		assertEquals(objeto.verify(solucion),-1,0);
	}
	
	
	@Test //Se ha insertado la letra 'a' al principio de la solucion.
	public void testHayUnaLetra() throws Exception {
		String solucion = "a45892367"
 						+ "627134958"
 						+ "893567124"
 						+ "259413876"
 						+ "376958241"
 						+ "418276593"
 						+ "964385712"
 						+ "731629485"
 						+ "582741639";
		assertEquals(objeto.verify(solucion),-1,0);
	}
	
	
	@Test //Se ha insertado el signo '-' al principio de la solucion.
	public void testHayUnSigno() throws Exception {
		String solucion = "-45892367"
 						+ "627134958"
 						+ "893567124"
 						+ "259413876"
 						+ "376958241"
 						+ "418276593"
 						+ "964385712"
 						+ "731629485"
 						+ "582741639";
		assertEquals(objeto.verify(solucion),-1,0);
	}
	
	
	@Test(expected = Exception.class) //solucion inicializada a null.
	public void testNull() throws Exception {
		String solucion = null;
		objeto.verify(solucion);
	}
	
	
	@Test(expected = Exception.class) //Se ha quitado una fila entera.
	public void testTamanoDistinto() throws Exception {
		String solucion = "-45892367"
						+ "627134958"
						+ "893567124"
						+ "259413876"
						+ "376958241"
						+ "418276593"

						+ "731629485"
						+ "582741639";
		objeto.verify(solucion);
	} 
	
	
	@Test //Se repite el numero '2' de la primera fila.
	public void testFilaRepetida() throws Exception {
		String solucion = "125892367"
		 				+ "647134958"
		 				+ "893567124"
		 				+ "259413876"
		 				+ "376958241"
		 				+ "418276593"
		 				+ "964385712"
		 				+ "731629485"
		 				+ "582741639";
		assertEquals(objeto.verify(solucion),-3,0);
	}
	
	
	@Test //Se repite el numero '1' en la primera columna.
	public void testColumnaRepetida() throws Exception {
		String solucion = "145892367"
 						+ "627134958"
 						+ "893567124"
 						+ "159413876"
 						+ "376958241"
 						+ "428276593"
 						+ "964385712"
 						+ "731629485"
 						+ "582741639";
		assertEquals(objeto.verify(solucion),-3,0);
	}
	
	@Test //Se repite el numero '1' en el segundo sub-grid (centro-arriba).
	public void testGridRepetido() throws Exception {
		String solucion = "145192367"
		 				+ "627134958"
		 				+ "893567124"
		 				+ "259413876"
		 				+ "376958241"
		 				+ "418276593"
		 				+ "964385712"
		 				+ "731629485"
		 				+ "582741639";
		assertEquals(objeto.verify(solucion),-2,0);
	}
	
	
	@Test //solucion correcta introducida
	public void testCorrecto() throws Exception {
		String solucion = "145892367"
				 		+ "627134958"
				 		+ "893567124"
				 		+ "259413876"
				 		+ "376958241"
				 		+ "418276593"
				 		+ "964385712"
				 		+ "731629485"
				 		+ "582741639";

		assertEquals(objeto.verify(solucion),0,0);
	}
}
