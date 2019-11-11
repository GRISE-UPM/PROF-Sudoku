package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SudokuVerifierTest {

	SudokuVerifier sudokuVerifier = new SudokuVerifier();

	@Test
	public void sudoku_null()
	{
		String sudoku = null;

		assertEquals( -1, sudokuVerifier.verify(sudoku) );
    }

	@Test
	public void sudoku_char_in_string()
	{
		String sudoku = "a23456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789";

		assertEquals( -1, sudokuVerifier.verify(sudoku) );
	}

	@Test
	public void sudoku_negative_number()
	{
		String sudoku = "-123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789";

		assertEquals( -1, sudokuVerifier.verify(sudoku) );
	}

	@Test
	public void sudoku_no_valid_number()
	{
		String sudoku = "023456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789";

		assertEquals( -1, sudokuVerifier.verify(sudoku) );
	}

	@Test
	public void sudoku_size_smaller_than_81()
	{
		String sudoku = "12345" +
						"12345" +
						"12345" +
						"12345" +
						"12345";

		assertEquals( -1, sudokuVerifier.verify(sudoku) );
	}

	@Test
	public void sudoku_size_bigger_than_81()
	{
		String sudoku = "123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789" +
						"123456789";

		assertEquals( -1, sudokuVerifier.verify(sudoku) );
	}

	@Test
	public void sudoku_repeated_number_in_subgrid()
	{
		String sudoku = "123456789"+
						"234567891"+
						"345678912"+
						"456789123"+
						"567891234"+
						"678912345"+
						"789123456"+
						"891234567"+
						"912345678";

		assertEquals( -2, sudokuVerifier.verify(sudoku) );
	}

	@Test
	public void sudoku_repeated_number_in_row()
	{
		String sudoku = "123123123"+
						"456456456"+
						"789789789"+
						"123123123"+
						"456456456"+
						"789789789"+
						"123123123"+
						"456456456"+
						"789789789";

		assertEquals( -3, sudokuVerifier.verify(sudoku) );
	}

	@Test
	public void sudoku_repeated_number_in_column()
	{
		String sudoku = "975218563"+
						"486359721"+
						"123467698"+
						"791845632"+
						"562731849"+
						"348692175"+
						"659124387"+
						"237586914"+
						"814973256";

		assertEquals( -4, sudokuVerifier.verify(sudoku) );
	}

	@Test
	public void sudoku_valid()
	{
		String sudoku = "975218463"+
						"486359721"+
						"123467598"+
						"791845632"+
						"562731849"+
						"348692175"+
						"659124387"+
						"237586914"+
						"814973256";

		assertEquals( 0, sudokuVerifier.verify(sudoku) );
	}
}
