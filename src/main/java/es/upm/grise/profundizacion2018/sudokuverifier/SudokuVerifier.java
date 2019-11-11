package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier 
{
	public int verify (String candidateSolution)
    {
        //Failure #1: shape of solution is incorrect (either is empty or doesn't match expected length)
		if (candidateSolution == null || candidateSolution.length() != 81) {
        	throw new RuntimeException("Candidate Solution length is incorrect");
        }
		
		//global_grid stores the complete sudoku from input string. char_counter determines the character being read from candidateSolution. number_counter determines the number count so far (it can differ from the char count being read from the solution!)
		int[][] global_grid = new int [9][9];
		int char_counter = 0;
		int number_counter = 0;
		
		//traverse input string and store numerical values in global sudoku grid --> while reading the input, we can check valid character constraints (only digits and positive numbers are valid)
		for (int col = 0; col < 9; col++) {
			for (int row = 0; row < 9; row++) {
				char read_input = candidateSolution.charAt(char_counter);
				
				//Failure #2: solution contains invalid characters (symbols or letters)
				if (!Character.isDigit(read_input) && read_input != '-') {
					throw new RuntimeException("Solution contains an invalid character");
				}
				
				//Check whether rule #1 is met or not: solution doesn't contain negative numbers
				if (read_input == '-') {
					/*char_counter ++;
					read_input = candidateSolution.charAt(char_counter);
					int number = Character.getNumericValue(read_input);
					global_grid[col][row] = -number;*/
					return -1;
				}
				
				//No failure found: keep on reading input
				int number = Character.getNumericValue(read_input);
				global_grid[col][row] = number;
				char_counter++;
				number_counter++;
				
			}
		}
		
		//Check the rest of the sudoku constraints (Rules #2, #3 and #4)
		
		if (!validateSubGrids(global_grid)) {
			return -2;
		}
		if(!validateRows(global_grid)) {
			return -3;
		}
		if(!validateColumns(global_grid)) {
			return -4;
		}
        
		//When everything is correct, return 0
		return 0;
    }
	
	/*Verify that the same digit isn't repeated in the same row*/
	private boolean validateRows(int[][] global_grid) {
		for(int row = 0; row < 9; row++) {
			   for(int column = 0; column < 8; column++) {
			      for(int next_column = column + 1; next_column < 9; next_column++) {
			         if(global_grid[row][column]==global_grid[row][next_column])
			            return false;
			      }
			   }
		}
		return true;
	}
	
	/*Verify that the same digit isn't repeated in the same column*/
	private boolean validateColumns(int[][] global_grid) {
		for(int col = 0; col < 9; col++) {
			for(int row = 0; row < 8; row++)  {
				for (int next_row = row + 1; next_row < 9; next_row++) {
					 if(global_grid[row][col]==global_grid[next_row][col])
				            return false;
				}
			}
		}
		return true;
	}
	
	/*Verify that the same digit isn't in the same grid*/
	private boolean validateSubGrids(int[][] global_grid) {
		for(int row = 0; row < 9; row += 3) {
			   for(int col = 0; col < 9; col += 3) {
				   for(int pos = 0; pos < 8; pos++) {
					   for(int next_pos = pos + 1; next_pos < 9; next_pos++)
				            if(global_grid[row + pos%3][col + pos/3]==global_grid[row + next_pos%3][col + next_pos/3])
				               return false;
				   }
			   }
		}
		return true;
	}
}
