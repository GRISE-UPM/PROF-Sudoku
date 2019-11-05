package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {
	
	SudokuVerifier v = new SudokuVerifier();
    
	@Test
	public void test_correcto() throws Exception {
		String s = "859612437"
				 + "723854169"
				 + "164379528"
				 + "986147352"
				 + "375268914"
				 + "241593786"
				 + "432981675"
				 + "617425893"
				 + "598736241";
    	assertEquals("Correcto", 0, v.verify(s), 0);
    }
	
	@Test
	public void test_cero() throws Exception {
		String s = "000000000"
				 + "723854169"
				 + "164379528"
				 + "986147352"
				 + "375268914"
				 + "241593786"
				 + "432981675"
				 + "617425893"
				 + "598736241";
    	assertEquals("Error: sólo dígitos positivos", -1, v.verify(s), 0);
    }
	
	@Test
	public void test_grid_repe() throws Exception {
		String s = "859612437"
				 + "753854169"
				 + "164379528"
				 + "986147352"
				 + "375268914"
				 + "241593786"
				 + "432981675"
				 + "617425893"
				 + "598736241";
    	assertEquals("Error: dígito repetido en grid", -2, v.verify(s), 0);
    }
	
	@Test
	public void test_row_repe() throws Exception {
		String s = "459612437"
				 + "723854169"
				 + "168379528"
				 + "986147352"
				 + "375268914"
				 + "241593786"
				 + "432981675"
				 + "617425893"
				 + "598736241";
    	assertEquals("Error: dígito repetido en row", -3, v.verify(s), 0);
    }
	
	@Test
	public void test_col_repe() throws Exception {
		String s = "859612437"
				 + "723854169"
				 + "164379528"
				 + "986147352"
				 + "375268914"
				 + "241593786"
				 + "432981675"
				 + "817425893"
				 + "596736241";
    	assertEquals("Error: dígito repetido en col", -4, v.verify(s), 0);
    }
	
	
	
	//Excepción
		@Test
		public void test_null() throws Exception {
	    	assertEquals("Error: null en la entrada", 0, v.verify(null), 0);
	    }
		
	//Excepción
	@Test
	public void test_distinto_tamano() throws Exception {
		String s = "859";
    	assertEquals("Error: no se han introducido 81 dígitos", 0, v.verify(s), 0);
    }
	
}
