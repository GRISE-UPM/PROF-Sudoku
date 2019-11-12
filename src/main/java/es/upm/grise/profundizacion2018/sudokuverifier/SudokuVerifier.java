package es.upm.grise.profundizacion2018.sudokuverifier;

import java.util.ArrayList;
import java.util.List;

public class SudokuVerifier 
{
	public int verify (String candidateSolution)
    {
		
		// Comprobamos que hay 81 numeros
        if (candidateSolution.length() != 81)
        	return -5;
        
        // Transformamos la entrada a una matriz 9x9 para trabajar mas comodamente
        int [][] matriz = new int[9][9];
        char car = '0';
        for (int i = 0; i < 81; i++) {
        	car = candidateSolution.charAt(i);
        	if (car <= 48 || car > 57) // Si no es un numero positivo (1...9)
        		return -1;
        	matriz[i/9][i%9] = car - 48; // Pasamos de char a int
        }
        
        // Nos recorremos la matriz
        List<List<Integer>> grids = new ArrayList<List<Integer>>();
        for (int i = 0; i < 9; i++) {
        	grids.add(new ArrayList<Integer>());
        }
        List<Integer> fila = null;
        List<Integer> columna = null;
        int grid = 0;
        for (int i = 0; i < 9; i++) {
        	fila = new ArrayList<Integer>();
        	columna = new ArrayList<Integer>();
        	for (int j = 0; j < 9; j++) {
        		
        		// Comprobamos que un mismo numero no se repite en un sub-grid
        		grid = (i/3)*3 + j/3;
        		if (grids.get(grid).contains(matriz[i][j]))
        			return -2;
        		else grids.get(grid).add(matriz[i][j]);
        		
        		// Comprobamos que un mismo numero no se repite en una fila
        		if (fila.contains(matriz[i][j]))
        			return -3;
        		else fila.add(matriz[i][j]);
        		
        		// Comprobamos que un mismo numero no se repite en una columna
        		if (columna.contains(matriz[j][i]))
        			return -4;
        		else columna.add(matriz[j][i]);
        	}
        }
                
        return 0;
    }
}
