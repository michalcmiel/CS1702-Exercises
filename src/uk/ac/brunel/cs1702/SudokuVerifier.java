package uk.ac.brunel.cs1702;
import java.util.*;
public class SudokuVerifier {
	
	public int verify(String candidateSolution){
		if (candidateSolution.length()!=81){
			return -5;
		}
		return 0;

	}
	
	public int positiveInt(String candidateSolution){
		for (int j=0; j<candidateSolution.length(); j++)
		{
			int value = candidateSolution.charAt(j);
			if (value<0)
			{
				return -1;
			}
		}
		return 0;
	}
	
	public int row(String candidateSolution) {
		for (int i=0; i<9; i++) {
			for (int j=i + 1; j<9; j++) {
				int value = candidateSolution.charAt(i);
				int value1 = candidateSolution.charAt(j);
				if (value == value1)
					return -5;
			}
		}
		return 0;
	}

	
	
/*	public int Row(String candidateSolution) 
	{
		for (int i=0; i<9; i++) 
		{
			int initial = i*9;
			for (int j=0; j<9; j++) 
			{
				initial++;
				String[] Array = new String [candidateSolution.charAt(j)];
				for (int k=0; k<Array.length; k++) {
					for (int l=0; l<Array.length; l++) {
						 if (Array[k].equals(Array[l]) && k != l) {
							 return -3;
						 }
						 return 0;
					}
				}
			}
		}
		return 0;
						 
		
	}
*/
	
	
/*	public int subpositive (String candidateSolution){
		int rows;
		int cols;
		for (int i = 0; i<9; i++)
		{
			int initial = i;
			for(int j=0; j<9; j++){
				System.out.print(initial);
				initial +=9;
			}
		}
			
		return 0;
		
	}
	*/
	
	public static void main(String[] args){
		
		String candidateSolution = "";
		Random r = new Random();
		for (int i=0; i<81; i++)
		{
			int n = r.nextInt(8)+1;
			candidateSolution+=Integer.toString(n);
		}
		System.out.println(candidateSolution);
		System.out.println(candidateSolution.length());
		System.out.println(candidateSolution.charAt(0));
/*		System.out.println(row(candidateSolution));*/
		}
		
	}

