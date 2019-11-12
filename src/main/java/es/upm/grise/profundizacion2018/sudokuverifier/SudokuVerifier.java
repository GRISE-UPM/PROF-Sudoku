package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier 
{
	public int verify (String candidateSolution)
    {
		/* R5: Additional.
		 	Se ha creado esta regla para en caso de pasar una solución null
		  		 o que la longitud no sea 81 se devuelva el resultado -5  */
        if (candidateSolution == null || candidateSolution.length() != 81) {  	
        	return -5;
        }
        
        
        /* R1: A cell in a Sudoku game can only store positive digits, i.e. 1…9. */
        if (!candidateSolution.matches("[1-9]+")) {
        	return -1;
        }
        
        
      /* R2: All digits appear only once in a sub-grid, i.e. they cannot repeat. */
        String subgrid;
        for (int i = 0; i < 81; i+=27) { 
        	for (int j = 0; j < 9; j+=3) {
        		subgrid = "";
        		for (int k = 0; k < 27; k+=9) {
        		subgrid += candidateSolution.charAt(i+j+k+0);
        		subgrid += candidateSolution.charAt(i+j+k+1);
        		subgrid += candidateSolution.charAt(i+j+k+2);
        		}
        		for (int k = 1; k < 10; k++) {
        			if(!subgrid.contains(String.valueOf(k))){
        				return -2;
        			}
        		}
			}
        }
        

        /* R3: A digit can appear only once in the rows of the global grid. */
        String row;
		for (int i = 0; i < 81; i+=9) {
			row = candidateSolution.substring(i, i+9);
			for (int j = 1; j < 10; j++) {
				if(!row.contains(String.valueOf(j))){
					return -3;
				}
			}
		}
		
		
		/* R4: A digit can appear only once in the columns of the global grid. */
		String column;
		for (int i = 0; i < 9; i++) {
			column = "";
			for (int j = 0; j < 81; j+=9)
			column += candidateSolution.charAt(i+j);
			for (int k = 1; k < 10; k++) {
				if(!column.contains(String.valueOf(k))){
					return -4;
				}
			}
		}
		
		
		/* All rules ok */
        return 0;
    }
}
