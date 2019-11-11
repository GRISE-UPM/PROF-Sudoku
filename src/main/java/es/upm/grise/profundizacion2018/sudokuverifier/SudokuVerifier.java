package es.upm.grise.profundizacion2018.sudokuverifier;


public class SudokuVerifier 
{
	public static int verify (String candidateSolution)
    {

		// -1 Input invalido
		// Validacion de longitud de candidateSolution
		if( candidateSolution.length() != 81 ) {
			return -1;
		}
		
		char number;
		char[][] rows = new char[9][9];
		int row_counter = 1;
		int row_position = 0;
		char[][] columns = new char[9][9];
		int column_counter = 1;
		int column_position = 0;
		
		// Validacion de caracteres en candidateSolution
		char valid_numbers[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		for (int i = 0; i < candidateSolution.length(); i++){
		    number = candidateSolution.charAt(i);
		    // Para cada caracter
		    	for (int j=0; j < valid_numbers.length; j++) {
		    		// Comprueba si dicho caracter es valido
		    		if ( number == valid_numbers[j] ) {
		    			break;
		    		}
		    		// Si no es valido devuelve -1
		    		if (j == 8) {
		    			return -1;
		    		}
		    	}
		    	
		    	// -3 Filas
		    	row_counter = (int) ((i+0.5)/9);
		    	// Se genera un array de 9x9 con el input
			    rows[row_counter][row_position] = number;
			    // Se comprueba la no repeticion de un mismo numero en cada fila
			    for (int j=0; j < row_position; j++) {
			    	if (rows[row_counter][j] == number)
			    		return -3;
			    }
			    row_position ++;
			    if (row_position % 9 == 0) 
			    	row_position = 0;
			    
			    // -4 Columnas
			    column_position = (int) ((i+0.5)/9);
			    // Se genera un array de 9x9 con el input
			    columns[column_counter][column_position] = number;
			    // Se comprueba la no repeticion de un mismo numero en cada columna
			    for (int j=0; j < column_position; j++) {
			    	if (columns[column_counter][j] == number)
			    		return -4;
			    }
			    column_counter ++;
			    if (column_counter % 9 == 0) 
			    	column_counter = 0;
		}

		
		// -2 Subgrids
		int[][] subgrids = new int[9][9];
		int subgrid_counter = 0;
		int subgrid_row_count = 0;
		int subgrid_column_count = 0;
		int subgrid_position;
		
		// Para cada subgrid
		for (int k = 0; k < 9; k++) {
			subgrid_position = 0;
			// Se itera en filas y en columnas
			for (int i=3*subgrid_row_count; i<(3*(subgrid_row_count+1)); i++) {
				for(int j=3*subgrid_column_count; j<(3*(subgrid_column_count+1)); j++) {
					// Se genera un array 9x9 con todos los numeros presentes en cada subgrid
					subgrids[subgrid_counter][subgrid_position] = rows[i][j];
					for (int l=0; l < subgrid_position; l++) {
						// Se comprueba la no repeticion de un mismo numero dentro del subgrid
				    	if (subgrids[subgrid_counter][l] == rows[i][j])
				    		return -2;
					}
					subgrid_position ++;
				}
				
			}
			subgrid_counter ++;
			subgrid_column_count ++;
			if( subgrid_column_count % 3 == 0 ) {
				subgrid_column_count = 0;
				subgrid_row_count ++;
				
			}
		}

		return 0;
    }
	
}





