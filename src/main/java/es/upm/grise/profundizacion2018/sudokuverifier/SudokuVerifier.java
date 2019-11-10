package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier 
{
	public int verify (String candidateSolution) throws Exception
    {
		int[][]  sudoku= new int[9][9];
		int posicion=0;
		final int longitudIdeal=81;
		int contador=0;
		int longitudSudoku=candidateSolution.length();
		if(longitudSudoku<longitudIdeal) {
			throw new Exception();
		}

		for(int j=0; j < 9; j++){
	        for(int k=0;k<9;k++) {
	    		char n=candidateSolution.charAt(posicion);
	    		if(!Character.isDigit(n) && n!='-') {
	    			throw new Exception();
	    		}
	    		if(n=='-') {
	    			int nn=candidateSolution.charAt(posicion+1);
	    			int o=Character.getNumericValue(nn);
		        	sudoku[j][k]=-o;
		        	posicion=posicion+2;
		        	contador++;
		        	continue;
	    		}
	    		int o=Character.getNumericValue(n);
	        	sudoku[j][k]=o;
	        	contador++;
	            posicion++;
	         }	
	    }
		if(contador<longitudIdeal) {
			throw new Exception();
		}
		
        if(isNegative(sudoku)) {
        	return -1;
        }

        if(isEqualSector(sudoku)) {
    		return -2;
    	}
      
        if(isEqualRaw(sudoku)) {
    		return -3;
    	}
    	if(isEqualColum(sudoku)) {
    		return -4;
    	}    	
        return 0;
    }

	private boolean isEqualColum(int[][] sudoku) {
		// TODO Auto-generated method stub
		for(int col = 0; col < 9; col++) {
			   for(int row = 0; row < 8; row++) {
			      for(int row2 = row + 1; row2 < 9; row2++) {
			         if(sudoku[row][col]==sudoku[row2][col])
			            return true;
			      }
			   }
		}
		return false;
	}

	private boolean isEqualRaw(int[][] sudoku) {
		// TODO Auto-generated method stub
		for(int row = 0; row < 9; row++) {
			   for(int col = 0; col < 8; col++) {
			      for(int col2 = col + 1; col2 < 9; col2++) {
			         if(sudoku[row][col]==sudoku[row][col2])
			            return true;
			      }
			   }
		}
		return false;
	}

	private boolean isEqualSector(int[][] sudoku) {
		// TODO Auto-generated method stub
		for(int row = 0; row < 9; row += 3) {
			   for(int col = 0; col < 9; col += 3) {
				   for(int pos = 0; pos < 8; pos++) {
					   for(int pos2 = pos + 1; pos2 < 9; pos2++)
				            if(sudoku[row + pos%3][col + pos/3]==sudoku[row + pos2%3][col + pos2/3])
				               return true;
				   }
			   }
		}
		return false;
	}

	private boolean isNegative(int[][] sudoku) {
		// TODO Auto-generated method stub
		for(int row = 0; row < 9; row++) {
			   for(int col = 0; col < 9; col++) {
			         if(sudoku[row][col]<0)
			            return true;
			   }
		}
		return false;
	}
}
