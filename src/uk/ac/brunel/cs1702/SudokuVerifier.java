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
			int val = candidateSolution.charAt(j);
			if (val<0)
			{
				return -1;
			}
		}
		return 0;
	}
	
	public int subpositive (String candidateSolution){
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
	}
}
