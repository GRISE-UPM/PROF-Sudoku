package es.upm.grise.profundizacion2018.sudokuverifier;


public class SudokuVerifier 
{
	
	public static void main(String[] args) {
		System.out.println(
		verify(	
				"417369825"+
				"632158947"+
				"958724316"+
				"825437169"+
				"791586432"+
				"346912758"+
				"289643571"+
				"573291684"+
				"164875293"
				)
		);
	}
	
	public static int verify (String candidateSolution)
    {
		//System.out.println(candidateSolution.length());
		
	//--------------------------------------------------------------------------
		// -1
		if( candidateSolution.length() != 81 ) {
			return -1;
		}
		char number;
		char valid_numbers[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		for (int i = 0; i < candidateSolution.length(); i++){
		    number = candidateSolution.charAt(i);
		    	for (int j=0; j < valid_numbers.length; j++) {
		    		if ( number == valid_numbers[j] ) {
		    			break;
		    		}
		    		if (j == 8) {
		    			return -1;
		    		}
		    	}
		}
	//--------------------------------------------------------------------------
		

	//--------------------------------------------------------------------------
		// -3 Filas
		char[][] rows = new char[9][9];
		int row_counter = 1;
		int row_position = 0;
		for (int i = 0; i < candidateSolution.length(); i++){
			row_counter = (int) ((i+0.5)/9);
		    number = candidateSolution.charAt(i);
		    rows[row_counter][row_position] = number;
		    for (int j=0; j < row_position; j++) {
		    	if (rows[row_counter][j] == number)
		    		return -3;
		    }
		    row_position ++;
		    if (row_position % 9 == 0) 
		    	row_position = 0;
		}
	//--------------------------------------------------------------------------
		
	//--------------------------------------------------------------------------
		// -4 Columnas
		char[][] columns = new char[9][9];
		int column_counter = 1;
		int column_position = 0;
		for (int i = 0; i < candidateSolution.length(); i++){
			column_position = (int) ((i+0.5)/9);
		    number = candidateSolution.charAt(i);
		    columns[column_counter][column_position] = number;
		    for (int j=0; j < column_position; j++) {
		    	if (columns[column_counter][j] == number)
		    		return -4;
		    }
		    column_counter ++;
		    if (column_counter % 9 == 0) 
		    	column_counter = 0;
		}
	//--------------------------------------------------------------------------
		
	//--------------------------------------------------------------------------
		// -2 Subgrids
		int[][] subgrids = new int[9][9];
		int subgrid_counter = 0;
		int subgrid_row_count = 0;
		int subgrid_column_count = 0;
		int subgrid_position;
		for (int k = 0; k < 9; k++) {
			subgrid_position = 0;
			for (int i=3*subgrid_row_count; i<(3*(subgrid_row_count+1)); i++) {
				for(int j=3*subgrid_column_count; j<(3*(subgrid_column_count+1)); j++) {
					subgrids[subgrid_counter][subgrid_position] = rows[i][j];
					//System.out.println("Subgrid_counter: " + subgrid_counter);
					//System.out.println("subgrid_row_count: " + subgrid_row_count);
					//System.out.println("subgrid_column_count: " + subgrid_column_count);
					//System.out.println("subgrid_position: " + subgrid_position);
					//System.out.println("Number: " + rows[i][j]);
					for (int l=0; l < subgrid_position; l++) {
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
		
	//--------------------------------------------------------------------------
		
		return 0;
    }
	
}





