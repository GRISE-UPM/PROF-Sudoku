package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.fail;
import org.junit.Test;

public class SudokuVerifierTest {
    
	 public SudokuVerifier sudoku=new SudokuVerifier();
	    
		@Test
		public void test_longitudNoMin() {
			String str="1234556";
			Exception excepcion=assertThrows(Exception.class,()->sudoku.verify(str));
			assertEquals(null, excepcion.getMessage());
	    }
			
		@Test
		public void test_longitudNoNumeric() {
			String str="123455a6";
			Exception excepcion=assertThrows(Exception.class,()->sudoku.verify(str));
			assertEquals(null, excepcion.getMessage());
	    }
		
		@Test
		public void test_longitudNoPositive() throws Exception {
			String str="11234567895112345678911234567891123456789112345678911234-567891123456789112345678-9";
			int result=-1;
			assertEquals(result, sudoku.verify(str));
	    }
		@Test
		public void test_longitudNoGrid() throws Exception {
			String str="123456789456123456783782123891123456789112345678911234567891123456789812345678949";
			int result=-2;
			assertEquals(result, sudoku.verify(str));
	    }
		@Test
		public void test_longitudNoRaw() throws Exception {
			String str="963174259178325648254689731821437596496852317735961824589713462317246985642598173";
			int result=-3;
			assertEquals(result, sudoku.verify(str));
	    }
		@Test
		public void test_longitudNoColum() throws Exception {
			String str="963174258178325649254689731821437596496852317735961824985713462317246985642598173";
			int result=-4;
			assertEquals(result, sudoku.verify(str));
	    }
		@Test
		public void test_ok() throws Exception {
			String str="963174258178325649254689731821437596496852317735961824589713462317246985642598173";
			int result=0;
			assertEquals(result, sudoku.verify(str));
	    }
}
