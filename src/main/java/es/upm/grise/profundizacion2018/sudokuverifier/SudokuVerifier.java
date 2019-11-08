package es.upm.grise.profundizacion2018.sudokuverifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SudokuVerifier 
{
	public int verify (String candidateSolution)
    {
		//(se ha preferido hacer en este orden porque es mas facil detectar las dos primeras)
		// si se desea cambiar solo habria que cambiar el orden de los bucles
		//de este modo el orden de deteccion es: cantidad corredcta y numeros, filas, columnas, y por ultimo subgrip
		
		
		
		///R1
		if (!candidateSolution.matches("[1-9]+") || candidateSolution.length() != 81) {
			return -1;
		}
		
		//R3 filas
		for(int i=0;i<9;i++) {
			String fila=candidateSolution.substring(i*9, i*9+9);
			System.out.println(fila);
			if (duplicados(fila)==true)
				return -3;
		}
		
		//R4 columnas
		for (int j=0;j<9;j++) {
			String columna="";
			for (int i=0;i<9;i++) {
				columna+=candidateSolution.charAt(i*9+j);
			}
			if (duplicados(columna)==true)
				return -4;
		}		
		
	

		
		//R2  sub-grids     
		for (int j=0;j<9;j++) {
			String grid="";
			int repe=j%3;
			int filas =(int) j/3;
			for (int i=0;i<3;i++) {
				grid+=candidateSolution.substring(9*i+9*filas+repe*3,9*i+filas*9+repe*3+3);
			}
			if (duplicados(grid)==true)
				return -2;
		}
		

		
		return 0;
    }
	
	//metodo de apoyo para detectar duplicados en una cadena de 9 numeros
	public boolean duplicados(String cadena) {
		boolean dups=false;
	    char[] chars = cadena.toCharArray();
	    
	    HashSet<Character> h = new HashSet<Character>(); 
	    //Print duplicate characters

	    
	    for (char c : chars) { 
	    	if (h.add(c) == false) { 
	    		return true;
	    	}
	    }


	    return false;
	}
}
