package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier {
	final static int VALID_SUDOKU = 0;
	final static int VIOLATION_RULE_1 = -1;
	final static int VIOLATION_RULE_2 = -2;
	final static int VIOLATION_RULE_3 = -3;
	final static int VIOLATION_RULE_4 = -4;
	
	final static String REGEX_NUMBERS_1TO9 = "[1-9]{9}";
	final static String REGEX_NUMBERS_NOT_REPEATING = "^(?:([1-9])(?!.*\\1))*$";
	
	public int verify (String candidateSolution){

		if ((candidateSolution == null) || (candidateSolution.length()!=81))
			return VIOLATION_RULE_1;
		
		/** Comprobamos las filas primero */
		for (int i=0; i<81; i+=9) {
			String subRow = candidateSolution.substring(i, i+9);
				
			if (!subRow.matches(REGEX_NUMBERS_1TO9)) 
				return VIOLATION_RULE_1;
		
			
			if (!subRow.matches(REGEX_NUMBERS_NOT_REPEATING)) 
				return VIOLATION_RULE_3;
		}
		
		/** Comprobamos las columnas */
		for (int i=0; i<9; i++) {
			String subCol = ""+ candidateSolution.charAt(i)+candidateSolution.charAt(i+9)+candidateSolution.charAt(i+18)+
					candidateSolution.charAt(i+27)+candidateSolution.charAt(i+36)+candidateSolution.charAt(i+45)+
					candidateSolution.charAt(i+54)+candidateSolution.charAt(i+63)+candidateSolution.charAt(i+72);
			
			if (!subCol.matches(REGEX_NUMBERS_NOT_REPEATING))
				return VIOLATION_RULE_4;
		}
		
		/** Comprobamos las submatrices */
		String subMatrix1 = ""+ 
				candidateSolution.charAt(0)+candidateSolution.charAt(1)+candidateSolution.charAt(2)+
				candidateSolution.charAt(9)+candidateSolution.charAt(10)+candidateSolution.charAt(11)+
				candidateSolution.charAt(18)+candidateSolution.charAt(19)+candidateSolution.charAt(20);
		
		String subMatrix2 = ""+ 
				candidateSolution.charAt(3)+candidateSolution.charAt(4)+candidateSolution.charAt(5)+
				candidateSolution.charAt(12)+candidateSolution.charAt(13)+candidateSolution.charAt(14)+
				candidateSolution.charAt(21)+candidateSolution.charAt(22)+candidateSolution.charAt(23);
		
		String subMatrix3 = ""+ 
				candidateSolution.charAt(6)+candidateSolution.charAt(7)+candidateSolution.charAt(8)+
				candidateSolution.charAt(15)+candidateSolution.charAt(16)+candidateSolution.charAt(17)+
				candidateSolution.charAt(24)+candidateSolution.charAt(25)+candidateSolution.charAt(26);
		
		String subMatrix4 = ""+ 
				candidateSolution.charAt(27)+candidateSolution.charAt(28)+candidateSolution.charAt(29)+
				candidateSolution.charAt(36)+candidateSolution.charAt(37)+candidateSolution.charAt(38)+
				candidateSolution.charAt(45)+candidateSolution.charAt(46)+candidateSolution.charAt(47);
			
		String subMatrix5 = ""+ 
				candidateSolution.charAt(30)+candidateSolution.charAt(31)+candidateSolution.charAt(32)+
				candidateSolution.charAt(39)+candidateSolution.charAt(40)+candidateSolution.charAt(41)+
				candidateSolution.charAt(48)+candidateSolution.charAt(49)+candidateSolution.charAt(50);
		
		String subMatrix6 = ""+ 
				candidateSolution.charAt(33)+candidateSolution.charAt(34)+candidateSolution.charAt(35)+
				candidateSolution.charAt(42)+candidateSolution.charAt(43)+candidateSolution.charAt(44)+
				candidateSolution.charAt(51)+candidateSolution.charAt(52)+candidateSolution.charAt(53);
		
		String subMatrix7 = ""+ 
				candidateSolution.charAt(54)+candidateSolution.charAt(55)+candidateSolution.charAt(56)+
				candidateSolution.charAt(63)+candidateSolution.charAt(64)+candidateSolution.charAt(65)+
				candidateSolution.charAt(72)+candidateSolution.charAt(73)+candidateSolution.charAt(74);
		
		String subMatrix8 = ""+ 
				candidateSolution.charAt(57)+candidateSolution.charAt(58)+candidateSolution.charAt(59)+
				candidateSolution.charAt(66)+candidateSolution.charAt(67)+candidateSolution.charAt(68)+
				candidateSolution.charAt(75)+candidateSolution.charAt(76)+candidateSolution.charAt(77);

		String subMatrix9 = ""+
				candidateSolution.charAt(60)+candidateSolution.charAt(61)+candidateSolution.charAt(62)+
				candidateSolution.charAt(69)+candidateSolution.charAt(70)+candidateSolution.charAt(71)+
				candidateSolution.charAt(78)+candidateSolution.charAt(79)+candidateSolution.charAt(80);
			
		if (!subMatrix1.matches(REGEX_NUMBERS_NOT_REPEATING) || !subMatrix2.matches(REGEX_NUMBERS_NOT_REPEATING) || !subMatrix3.matches(REGEX_NUMBERS_NOT_REPEATING)||
			!subMatrix4.matches(REGEX_NUMBERS_NOT_REPEATING) || !subMatrix5.matches(REGEX_NUMBERS_NOT_REPEATING) || !subMatrix6.matches(REGEX_NUMBERS_NOT_REPEATING)||
			!subMatrix7.matches(REGEX_NUMBERS_NOT_REPEATING) || !subMatrix8.matches(REGEX_NUMBERS_NOT_REPEATING) || !subMatrix9.matches(REGEX_NUMBERS_NOT_REPEATING))
			return VIOLATION_RULE_2;
		
        return 0;
    }
}
