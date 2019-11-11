package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier 
{
	public int verify (String candidateSolution)
    {
		if(candidateSolution==null || !candidateSolution.matches("[1-9]+")){
			return -1;
		}
		char integers[]= candidateSolution.toCharArray();
		if(integers.length!=81) {
			return -1;
		}
		int [][] sudoku = new int[9][9];
		int x=0;
		for(int i = 0; i<9; i++) {
		    for(int j = 0; j<9; j++){
		    	sudoku[i][j] = Character.getNumericValue(integers[x]);
		        x++;
		    }
		}
		for(int i = 0; i<9; i++) {
		    for(int j = 0; j<9; j++) {
		    	if(isInBox(i, j,sudoku[i][j],sudoku)) return -2;
		    	if(isInRow(i, j,sudoku[i][j],sudoku)) return -3;
		    	if(isInCol(i, j,sudoku[i][j],sudoku)) return -4;
		    }
		}
		
        return 0;
    }
	// we check if a possible number is already in a col
		private boolean isInRow(int row,int col, int number, int[][]board) {
			for (int i = 0; i < 9; i++)
				if (board[row][i] == number && col!=i)
					return true;
			
			return false;
		}
		
		// we check if a possible number is already in a row
		private boolean isInCol(int row,int col,int number, int[][]board) {
			for (int i = 0; i < 9; i++)
				if (board[i][col] == number && row!=i)
				return true;
			
			return false;
		}
		
		// we check if a possible number is in its 3x3 box
		private boolean isInBox(int row, int col, int number, int[][]board) {
			int r = row - row % 3;
			int c = col - col % 3;
			for (int i = r; i < r + 3; i++)
				for (int j = c; j < c + 3; j++) {
					if (board[i][j] == number && (i!=row || col!=j)) 
					return true;
					}
			
			return false;
		}
}
