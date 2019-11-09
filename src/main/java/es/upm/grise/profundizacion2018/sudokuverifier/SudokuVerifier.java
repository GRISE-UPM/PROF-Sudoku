package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier 
{
	public int verify (String candidateSolution)
    {
		
		// Regla 1
		if (candidateSolution==null || candidateSolution.length()!=81 || 
				!candidateSolution.matches("[1-9]+"))
        return -1;
        
        for (int i = 0; i < 9; i++) {
			int row_id=(int)i%9;
			
			//Regla 2
			if (detectRepeat(this.getSubGrid(i, candidateSolution))) return -2;
			//Regla 3
			if (detectRepeat(candidateSolution.substring(row_id*9, (row_id+1)*9))) return -3;
			//Regla 4
			if (detectRepeat(this.getColumn(i, candidateSolution))) return -4;
		}
        
        
        
        
        return 0;
    }
	
	private String getColumn(int index, String candidateSolution) {
		if (index>9 || index <0) return null;
		String column="";
		for (int i = 0; i < 9; i++) {
			column+=candidateSolution.charAt((i*9)+index);
		}
		
		return column;
	}
	
	private String getSubGrid(int index, String candidateSolution) {
		
		if (index>9 || index <0) return null;
		String subgrid="";
		for (int i = 0; i < 3; i++) {
			String column=this.getColumn((index%3 * 3) + i, candidateSolution);
			subgrid+=column.substring(((int)index/3) * 3, (((int)(index/3)) * 3)+3);
		}
		
		return subgrid;
	}
	private boolean detectRepeat(String substring) {
		
		// Solo hace falta que recorra la primera mitad
		for (int i = 0; i < 9; i++) {
			char actual=substring.charAt(i);
			
			int j=i+1;
			//Los anteriores ya se han comprobado
			for (; j < substring.length() && actual!=substring.charAt(j) ; j++);
			
			if (j<substring.length()) return true;
		}
		
		return false;
	}
}
