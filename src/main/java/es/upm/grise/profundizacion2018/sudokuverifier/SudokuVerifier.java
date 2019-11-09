package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier 
{
	public int verify (String candidateSolution) throws Exception
    {
		char [] numeros = new char [81];
		int [][] tablero = new int [9][9];
		
		if(candidateSolution.length() != 81 || candidateSolution == null)
			throw new Exception();
		
		
		//regla 1:
		if(!candidateSolution.matches("[1-9]+")){
			return -1;
		}
		
		
		
		//Montar el tablero
		for( int i = 0; i<candidateSolution.length(); i++) { 
			numeros[i]=candidateSolution.charAt(i);
		}
		for (int j =0; j<9;j++)
			for (int i = 0; i<9; i++) {
				tablero[j][i] = Character.getNumericValue(numeros[(j*9)+i]);
		}
		
		
		// regla 2:
		for(int row = 0; row < 9; row += 3)
		   for(int col = 0; col < 9; col += 3)
		      for(int pos = 0; pos < 8; pos++)
		         for(int pos2 = pos + 1; pos2 < 9; pos2++)
		            if(tablero[row + pos%3][col + pos/3]==tablero[row + pos2%3][col + pos2/3])
		               return -2;
		
		// regla 3:
		for(int row = 0; row < 9; row++)
		   for(int col = 0; col < 8; col++)
		      for(int col2 = col + 1; col2 < 9; col2++)
		         if(tablero[row][col]==tablero[row][col2]) { 
		        	 System.out.println(row);
		            return -3;
		         }
		         
		         

		// regla 4:
		for(int col = 0; col < 9; col++)
		   for(int row = 0; row < 8; row++)
		      for(int row2 = row + 1; row2 < 9; row2++)
		         if(tablero[row][col]==tablero[row2][col])
		            return -4;
			
		
		return 0;
    } 
	
}
