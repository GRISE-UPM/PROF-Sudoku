package es.upm.grise.profundizacion2018.sudokuverifier;

import java.util.Arrays;

public class SudokuVerifier 
{
    final int valid_solution = 0;

    // Rules:
    // R1: A cell in a Sudoku game can only store positive digits, i.e. 1…9.
    final int violation_rule_1 = -1;
    // R2: All digits appear only once in a sub-grid, i.e. they cannot repeat.
    final int violation_rule_2 = -2;
    // R3: A digit can appear only once in the rows of the global grid.
    final int violation_rule_3 = -3;
    // R4:  A digit can appear only once in the columns of the global grid.
    final int violation_rule_4 = -4;

    // declare sudoku grid
    int[][] grid = new int[9][9];

	public int verify (String candidateSolution)
    {
        // si es null o tamaño diferente de 9x9
        if( (candidateSolution == null) || (candidateSolution.length() != 81) )
        {
            return violation_rule_1;
        }
        // si tiene el formato correcto
        else
        {
            // pasamos el string a una matriz
            for( int i = 0; i < 9; i++ )
            {
                for( int j = 0; j < 9; j++ )
                {
                    // get number from the string
                    char c = candidateSolution.charAt(i*9+j);
                    String s = String.valueOf(c);

                    // check if is a valid number
                    if( isPositiveNumber(s) ) {
                        grid[i][j] = Character.getNumericValue(c);
                    }
                    else {
                        return violation_rule_1;
                    }
                }
            }
            // validar matriz
            return checkSudokuStatus( grid );
        }
    }

    private static boolean isPositiveNumber(String strNum) {
        double d;

        try
        {
            d = Double.parseDouble(strNum);
        }
        catch (NumberFormatException | NullPointerException nfe)
        {
            return false;
        }

        return (d>0);
    }

    private int checkSudokuStatus(int[][] grid) {
        for (int i = 0; i < 9; i++)
        {
            int[] row = new int[9];
            int[] square = new int[9];
            int[] column = grid[i].clone();

            for (int j = 0; j < 9; j ++)
            {
                row[j] = grid[j][i];
                square[j] = grid[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }

            if (!validate(square)) {
                return violation_rule_2;
            }
            else if (!validate(row)) {
                return violation_rule_3;
            }
            else if (!validate(column)) {
                return violation_rule_4;
            }
        }
        return valid_solution;
    }

    private boolean validate(int[] check)
    {
        int i = 0;

        Arrays.sort(check);

        for (int number : check)
        {
            if (number != ++i)
            {
                return false;
            }
        }
        return true;
    }
}
