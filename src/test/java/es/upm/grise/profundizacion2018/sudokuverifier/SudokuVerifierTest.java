package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SudokuVerifierTest {
    
	public SudokuVerifier prueba =new SudokuVerifier();
	
	//longitud erronea
	@Test(expected = Exception.class)
	public void test() throws Exception{
		String ejemplo = "1";
		prueba.verify(ejemplo);
	}
	//longitud erronea
	@Test(expected = Exception.class)
	public void tes() throws Exception{
		String ejemplo = null;
		prueba.verify(ejemplo);
	}
	
	//sudoku correcto
	@Test(expected = Exception.class)
	public void test2() throws Exception{
		String ejemplo = "154693287632578941897124653519847326243965718768312495486759132975231864321486579";
		assertEquals(0, prueba.verify(ejemplo),0);
		
	}
	
	//Incumple R1
	@Test(expected = Exception.class)
	public void test1() throws Exception{
		String ejemplo = "1234a67891234a67891234a67891234a67891234a67891234a67891234a67891234a67891234a6789";
		assertEquals(-1, prueba.verify(ejemplo),0);
	}
	//Repetidos sector
	@Test(expected = Exception.class)
	public void test3() throws Exception{
		String ejemplo = "154693287132578941897124653519847326243965718768312495486759132975231864321486579";
		assertEquals(-2, prueba.verify(ejemplo),0);
		
	}
	//Repetidos fila
	@Test(expected = Exception.class)
	public void test5() throws Exception{
		String ejemplo = "154653287632978941897124653519847326243965718768312495486759132975231864321486579";
		assertEquals(-3, prueba.verify(ejemplo),0);
		
	}
	//Repetidos columna
	@Test(expected = Exception.class)
	public void test6() throws Exception{
		String ejemplo = "514693287632578941897124653519847326243965718768312495486759132975231864321486579";
		assertEquals(-4, prueba.verify(ejemplo),0);
		
	}
	
}
