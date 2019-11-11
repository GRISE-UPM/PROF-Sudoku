package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier 
{
	public int verify (String candidateSolution)throws Exception
    {
	 // Se comprueba que no sea null
		if(candidateSolution== null) {
			throw new Exception("String nulo");
		}
		
	//Se comprueba la longitud
		if (candidateSolution.length()!=81) {
			throw new Exception("Longitud erronea");
		} 
		
	//Solo números
		//for(int i = 0; i<81;i++) {
			//if (!Character.isDigit(candidateSolution.charAt(i))) {
				//throw new Exception("Contiene datos distintos a números");
			//}
	//}
		
   	 //Pasamos a un array int el String
   	 int [][] solucion = new int [9][9];
   	 for (int i =0; i<9;i++) {
   		for (int j =0; j<9;j++) {
      		solucion[i][j]= Character.getNumericValue(candidateSolution.charAt(i*9+j));
      	 } 
   	 }

   	 
     // R1: En caso de tener valores que no están comprendidos entre el 1 y el 9
   	 if ( !candidateSolution.matches("[1-9]+")) {
       	return -1;
       }
	 // R2: Repetidos en el sector
			for(int i = 0; i< 9; i += 3) {
				   for(int j = 0; j < 9; j += 3) {
					   for(int k = 0; k < 8; k++) {
						   for(int l = k + 1; l < 9; l++) {
					            if(solucion[i + k%3][j + k/3]==solucion[i + l%3][j + l/3]) {
					               return -2;
					       }
					   }
				   }
			   }
			}
   	 
	  //R3: Misma fila
		for(int i = 0; i < 9; i++) {
			   for(int j = 0; j < 8; j++) {
			      for(int k = j + 1; k < 9; k++) {
			         if(solucion[i][j]==solucion[i][k])
			            return -3;
			     }
			 }
		}
		
   	 //R4: Misma columna
 		for(int i = 0; i < 9; i++) {
 			   for(int j = 0; j < 8; j++) {
 			      for(int k = j + 1; k < 9; k++) {
 			         if(solucion[j][i]==solucion[k][i]) {
 			            return -4;
 			           }
 			         }
 			      }
 			   }

   	        return 0;
   	        
      	 } 
   	 }
   	 

	
