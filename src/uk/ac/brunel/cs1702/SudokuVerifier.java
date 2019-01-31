package uk.ac.brunel.cs1702;
import java.util.*;
public class SudokuVerifier {
	////SUDOKU VERIFIER

	public static boolean checkLength(String candidateSolution){
		if (candidateSolution.length()!=81){			//returns false if length is not equal to 81
			return false;
		}
		return true;
	}

	public static boolean check1(String candidateSolution){
		if (candidateSolution.matches("[1-9]*")){	//returns true if the numbers are from 1-9
			return true;
		}
		return false;
	}

	public static boolean check3(int[][] intArray){
		for (int j=0; j<9 ; j++) {
			int sum = 0;
			for (int k=0; k<9; k++) {
				sum = sum+intArray[j][k];
			}
			if (sum != 45){			
				return false;			//returns false if the sum doesnt add up to 45
			}
		}
		return true; 
	}

	public static boolean check4(int[][] intArray){
		for (int j=0; j<9 ; j++) {
			int sum = 0;
			for (int k=0; k<9; k++) {
				sum = sum+intArray[k][j];
			}
			if (sum != 45){
				return false;
			}
		}
		return true; 
	}

	public int verify(String candidateSolution){
		if (checkLength(candidateSolution)==false){
		return -5;
		}
		
		if (check1(candidateSolution)==false){
			return -1;
		}
		
		int[][] intArray = new int[9][9];
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				intArray[i][j] = Character.getNumericValue(candidateSolution.charAt(j+(i*9)));		//makes a 2d array from the string. i gets multiplied by 9 each time the loop runs
		}
		}
		if (check3(intArray)==false){
			return -3;
		}
		if (check4(intArray)==false){
			return -4;
		} 
		return 0;
	}
	
	public static void main(String[] args) {

		String candidateSolution = "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
		int[][] intArray = new int[9][9];
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				intArray[i][j] = Character.getNumericValue(candidateSolution.charAt(j+(i*9)));
			}
		}
			{
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				
				System.out.print(intArray[i][j]+" ");
			}
			System.out.println();
		}
		if (check1(candidateSolution)==false){
			System.out.println("rule 1 ");
		}else System.out.println("good");
			}
	}
}



