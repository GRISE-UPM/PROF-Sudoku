package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {
    public SudokuVerifier tester = new SudokuVerifier();
    
    
    @Test 
    public void casesNoSpecified() {
    	//length != 81
    	assertEquals("Error en la prueba para más de 81 carácteres",-42,tester.verify("123" + "456" + "789" +
																  					  "123" + "456" + "789" +
																					  "123" + "456" + "789" + 
																					  "123" + "456" + "789" +
																					  "123" + "456" + "789" +
																					  "123" + "456" + "789" +
																					  "123" + "456" + "789" +
																					  "123" + "456" + "789" +
																					  "123" + "456" + "789" +
																					  "23"));
    	
    	//candidateSolution = null
    	assertEquals("Error en la prueba para valores nulos",-42,tester.verify(null));
    	
    }
    
	@Test
	public void basicStructureOfSudoku() {
    		assertEquals("Error en prueba para valores inválidos",-1,tester.verify("012" + "345" + "678" + 
										    									   "901" + "234" + "567" + 
										    									   "8a0" + "123" + "4-6" + 
										    									   "789" + "011" + "345" + 
										    									   "678" + "901" + "234" + 
										    									   "567" + "890" + "123" + 
										    									   "456" + "789" + "012" + 
										    									   "345" + "678" + "901" +
										    									   "234" + "567" + "891" )); 		
    }
	
	@Test
	public void subGridChecker() {
		assertEquals("Prueba para subgrids",-2,tester.verify("536" + "478" + "912" +
									  						 "672" + "195" + "348" +
															 "198" + "342" + "567" +
															 "859" + "761" + "423" +
															 "426" + "853" + "791" +
															 "713" + "924" + "856" + 
															 "961" + "537" + "284" + 
															 "287" + "419" + "635" + 
															 "345" + "286" + "179"	));
	}
	
	@Test
	public void rowChecker() {
		assertEquals("Prueba para las filas",-3,tester.verify("534" + "678" + "912" +
									  						  "672" + "195" + "348" +
															  "198" + "342" + "567" +
															  "859" + "761" + "421" +
															  "426" + "853" + "791" + 
															  "713" + "924" + "856" + 
															  "961" + "537" + "284" + 
															  "287" + "419" + "635" +
															  "345" + "286" + "179"	));
		
		//534678912672195348198342567859761423426853791713924856961537284287419635345286179
	}
	
	
	@Test
	public void columnChecker() {
		assertEquals("Prueba para las columnas",-4,tester.verify("534" + "678" + "912" +
									  							 "672" + "195" + "348" +
									  							 "198" + "342" + "567" + 
																 "859" + "761" + "423" +
																 "426" + "853" + "791" + 
																 "713" + "924" + "856" +
																 "961" + "537" + "824" +
																 "287" + "419" + "635" + 
																 "345" + "286" + "179" ));
		
	}
	
	
	
	@Test 
	public void correctSudoku() {
		assertEquals("Prueba para un sudoku bien resuelto",0,tester.verify("534" + "678" + "912" +
																		   "672" + "195" + "348" +
																		   "198" + "342" + "567" +
																		   "859" + "761" + "423" +
																		   "426" + "853" + "791" +
																		   "713" + "924" + "856" +
																		   "961" + "537" + "284" +
																		   "287" + "419" + "635" +
																		   "345" + "286" + "179"	));
		
	}
}
