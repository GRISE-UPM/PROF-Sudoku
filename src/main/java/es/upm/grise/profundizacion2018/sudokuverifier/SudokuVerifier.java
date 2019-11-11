package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier 

// Solución implementada sin métodos auxiliares de optimización por si acaso incumpliera esta parte del enunciado:
 // "You should implement the functionality with a single API method with the following signature:"

{
	public int verify (String candidateSolution)
    {
		
		String subChar;
		
		// Casos no especificados se ha decidido devolver -42 
		if(candidateSolution == null || candidateSolution.length() != 81 ) {
			return -42;
		}
		
		//valores no válidos dentro de la string
        if(  !candidateSolution.matches("[1-9]+")) {
        	return -1;
        }
        
        
        //subGrid
        for(int i = 1 ; i <= 9 ; i++) {
        	subChar = "";
        	for(int j = 0; j <= 2 ; j++) {
        		subChar += "" + candidateSolution.charAt(j*9) + candidateSolution.charAt(j*9+1) + candidateSolution.charAt(j*9+2);
        	}
        	//System.out.println(subChar);
        	if(!subChar.contains(String.valueOf(i))) {
    			return -2;
    		}
        }
     
        
        //rows
        for(int i = 0; i < 9; i++) {
        	subChar = candidateSolution.substring(i*9,9*(i+1));
        	for(int j = 1; j <= 9; j++) {
        		if(!subChar.contains(String.valueOf(j))) {
        			return -3;
        		}
        	}
        }
        
        //columnas
        for(int i = 1 ; i <= 9 ; i++) {
        	for(int j = 0; j < 9 ; j++) {
        		subChar = "" + candidateSolution.charAt(j) + candidateSolution.charAt(j+9) + candidateSolution.charAt(j+18)+ candidateSolution.charAt(j+27) + candidateSolution.charAt(j+36) + candidateSolution.charAt(j+45) + candidateSolution.charAt(j+54) + candidateSolution.charAt(j+63) + candidateSolution.charAt(j+72);
        		if(!subChar.contains(String.valueOf(i))) {
        			return -4;
        		}
        	}
        }

        return 0;
    }
}
