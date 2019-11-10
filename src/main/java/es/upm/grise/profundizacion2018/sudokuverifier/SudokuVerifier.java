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
		for(int columna = 0; columna < 9; columna++) {
			   for(int fila = 0; fila < 8; fila++) {
			      for(int fila2 = fila + 1; fila2 < 9; fila2++) {
			         if(sudoku[fila][columna]==sudoku[fila2][columna])
			            return true;
			      }
			   }
		}
		return false;
	}

	private boolean isEqualRaw(int[][] sudoku) {
		// TODO Auto-generated method stub
		for(int fila = 0; fila < 9; fila++) {
			   for(int columna = 0; columna < 8; columna++) {
			      for(int columna2 = columna + 1; columna2 < 9; columna2++) {
			         if(sudoku[fila][columna]==sudoku[fila][columna2])
			            return true;
			      }
			   }
		}
		return false;
	}

	private boolean isEqualSector(int[][] sudoku) {
		// TODO Auto-generated method stub
		for(int fila = 0; fila < 9; fila += 3) {
			   for(int columna = 0; columna < 9; columna += 3) {
				   for(int pos = 0; pos < 8; pos++) {
					   for(int pos2 = pos + 1; pos2 < 9; pos2++)
				            if(sudoku[fila + pos%3][columna + pos/3]==sudoku[fila + pos2%3][columna + pos2/3])
				               return true;
				   }
			   }
		}
		return false;
	}

	private boolean isNegative(int[][] sudoku) {
		// TODO Auto-generated method stub
		for(int fila = 0; fila < 9; fila++) {
			   for(int columna = 0; columna < 9; columna++) {
			         if(sudoku[fila][columna]<0)
			            return true;
			   }
		}
		return false;
	}
}
