package es.upm.grise.profundizacion2018.sudokuverifier;

import java.util.Arrays;

public class SudokuVerifier 
{
	public int verify (String candidateSolution)
    {
		String regex = "[1-9]+";
        
        if (candidateSolution.length()!=81 || !candidateSolution.matches(regex)) {
        	return -1; // Si la longitud no es 81 es que algun valor es vacio
        }
        
		int[][] sudoku = new int[9][9];
		for (int i=0;i<9;i++) { 
		    for (int j=0;j<9;j++) {
		        sudoku[i][j] = Character.getNumericValue(candidateSolution.charAt(i*9+j));
		    }
		}
		
		   for (int i = 0; i < 9; i++) {
		        int[] square = new int[9];
		        for (int j = 0; j < 9; j ++) {
		            square[j] = sudoku[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
		        }
		        if (!(validate(square))) return -2;
		    }
		   
		   for (int i = 0; i < 9; i++) {
		        int[] row = new int[9];
		        for (int j = 0; j < 9; j ++) {
		        	row[j] = sudoku[j][i];
		        }
		        if (!(validate(row))) return -3;
		    }
		  
		   for (int i = 0; i < 9; i++) {
		        int[] column = new int[9];
		        for (int j = 0; j < 9; j ++) {
		        	column[j] = sudoku[i][j];
		        }
		        if (!(validate(column))) return -4;
		    }

		   return 0;
	    }
	
	private boolean validate(int[] check) {
	    int i = 0;
	    Arrays.sort(check);
	    for (int number : check) {
	        if (number != ++i)
	            return false;
	    }
	    return true;
	}
}
