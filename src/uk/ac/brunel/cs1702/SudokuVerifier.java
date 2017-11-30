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
	
	public int Row(String candidateSolution){
	{
/*    	String candidateSolution = "011345678011345678012345678012345678012345678012345678012345678012345678012345678";*/
    	    int[] intArray=new int[9];
    	    
    	    {
    		for (int j=0; j<9; j++) {
        		for (int i=0; i<9; i++) {
    			intArray[j] = Integer.parseInt(String.valueOf(candidateSolution.charAt(j)));
    		}
    		}
    	    
    	System.out.println(Arrays.toString(intArray));

/*		for (int j=0; j<intArray.length; j++) {			
			for (int k=0; k<intArray.length; k++) {
				if (k!=j && intArray[j] == intArray[k]) 		//checks if the numbers repeat{
                System.out.println("Duplicate element found"); 
        }
        }*/
        
    }
        System.out.println("Duplicate element not found"); 
    }
	return 0;
}

	
	
	
	
	
/*	public int Row(String candidateSolution) {
		int[] intArray = new int[9];
		for (int i=0; i<9; i++) {
			intArray[i] = Integer.parseInt(String.valueOf(candidateSolution.charAt(i))); // converts string to int array
		}
		for (int j=0; j<intArray.length; j++) {
			for (int k=0; k<intArray.length; k++) {
				if (k!=j && intArray[j] == intArray[k]) {
					return -3;
				}
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

