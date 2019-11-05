package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier 
{
	public int verify (String candidateSolution) throws Exception
    {
		//Asumo que hay que lanzar una excepción si hay errores distintos a las R
		if(candidateSolution == null || candidateSolution.length() != 81){
			throw new Exception();
		}
		
		if(!candidateSolution.matches("[1-9]+")){
			return -1;
		}
		
		
		for(int i = 0; i < 9; i++){
			
			//Para el subgrid tengo que hacer tres posibles casos según sea la row
			String subGrid = "";
			if(i < 3){
				subGrid = "" + candidateSolution.charAt(i*3)+candidateSolution.charAt(i*3+1)+candidateSolution.charAt(i*3+2)+
						candidateSolution.charAt(i*3+9)+candidateSolution.charAt(i*3+10)+candidateSolution.charAt(i*3+11)+
						candidateSolution.charAt(i*3+18)+candidateSolution.charAt(i*3+19)+candidateSolution.charAt(i*3+20);
			}
			else if(i < 6){
				subGrid = "" + candidateSolution.charAt(i*3+18)+candidateSolution.charAt(i*3+18+1)+candidateSolution.charAt(i*3+18+2)+
						candidateSolution.charAt(i*3+18+9)+candidateSolution.charAt(i*3+18+10)+candidateSolution.charAt(i*3+18+11)+
						candidateSolution.charAt(i*3+18+18)+candidateSolution.charAt(i*3+18+19)+candidateSolution.charAt(i*3+18+20);
			}
			else{
				subGrid = "" + candidateSolution.charAt(i*3+36)+candidateSolution.charAt(i*3+36+1)+candidateSolution.charAt(i*3+36+2)+
						candidateSolution.charAt(i*3+36+9)+candidateSolution.charAt(i*3+36+10)+candidateSolution.charAt(i*3+36+11)+
						candidateSolution.charAt(i*3+36+18)+candidateSolution.charAt(i*3+36+19)+candidateSolution.charAt(i*3+36+20);
			}
			
			if(!containAllDigits(subGrid)){
				return -2;
			}				
			
			String subRow = candidateSolution.substring(i*9, i*9+9);
			if(!containAllDigits(subRow)){
				return -3;
			}
			
			String subCol = "" + candidateSolution.charAt(i)+candidateSolution.charAt(i+9*1)+candidateSolution.charAt(i+9*2)+
					candidateSolution.charAt(i+9*3)+candidateSolution.charAt(i+9*4)+candidateSolution.charAt(i+9*5)+
					candidateSolution.charAt(i+9*6)+candidateSolution.charAt(i+9*7)+candidateSolution.charAt(i+9*8);
			if(!containAllDigits(subCol)){
				return -4;
			}
		}
		return 0;
    }
	
	//No se considerarán test para todas las ramas de este método por asumirse trivial su comprobación
	public static boolean containAllDigits(String s) 
	{ 
	    if(s.contains("1") && s.contains("2") && s.contains("3") &&
	    		s.contains("4") && s.contains("5") && s.contains("6") && 
	    		s.contains("7") && s.contains("8") && s.contains("9")){
	    	return true;
	    }
	    else return false;
	}
}
