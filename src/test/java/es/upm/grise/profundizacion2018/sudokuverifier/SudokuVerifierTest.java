package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SudokuVerifierTest {
	SudokuVerifier prueba = new SudokuVerifier();
	
	@Test
	public void rule1_size() {
		String candidateSolution = "12345678";
		assertEquals(-1, prueba.verify(candidateSolution));
    }
	
	@Test
	public void rule1_literal() {
		String candidateSolution = "123456789"+"123456789"+"123456789"+ "ABCDEFGHI"+
				"123456789"+"123456789"+"123456789"+"123456789"+"123456789";
		assertEquals(-1, prueba.verify(candidateSolution));
    }
	
	@Test
	public void rule1_zero() {
		String candidateSolution = "123450789"+"123456789"+"123456789"+
				"123456789"+"123456789"+"123456789"+
				"123456789"+"123456789"+"123456789";
		assertEquals(-1, prueba.verify(candidateSolution));
    }
	
	
	
	@Test
	public void rule2() {
		String candidateSolution = "154873296"+"386592714"+"729641835"+ "863725149"+"975314628"+"412968357"+
				"631457982"+"598236471"+/*-->*/"247189566";
		assertEquals(-2, prueba.verify(candidateSolution));
    }
	
	
	@Test
	public void rule3() {
		String candidateSolution = "154873296"+"386592714"+"729641835"+ /*-->*/"873725149"+/*-->*/"965314628"+"412968357"+
				"631457982"+"598236471"+/*-->*/"247189563";
		assertEquals(-3, prueba.verify(candidateSolution));
    }
	
	@Test
	public void rule_4() {
		String candidateSolution = /*-->*/ "514873296"+"386592714"+"729641835"+ "863725149"+"975314628"+"412968357"+
				"631457982"+"598236471"+"247189563";
		assertEquals(-4, prueba.verify(candidateSolution));
    }
	
	
	@Test
	public void correct() {
		String candidateSolution = "154873296"+"386592714"+"729641835"+ "863725149"+"975314628"+"412968357"+
				"631457982"+"598236471"+"247189563";
		assertEquals(0, prueba.verify(candidateSolution));
    }
}
