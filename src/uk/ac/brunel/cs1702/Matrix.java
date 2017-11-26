package uk.ac.brunel.cs1702;

public class Matrix {

	private int [][] matrix= new int[0][0];
	/**
	 * Constructor to create a matrix of size rows by cols and to initialise
	 * each element with the value of initialValue
	 * 
	 * @param rows:
	 *            an integer value indicating the number of rows
	 * @param cols:
	 *            an integer value indicating the number of columns
	 * @param initialValue:
	 *            each element of the matrix is initialised to this value
	 */
	public Matrix(int rows, int cols, int initialValue) {	
		this.matrix = new int[rows][cols];		//constructor for a new matrix
		for (int i = 0; i < rows; i++){		//rows
			for (int j = 0; j < cols;j++){		//columns
				this.matrix[i][j] = initialValue;	
			}
		}
		
	}
	/**
	 * Constructor to create a matrix of size equivalent to the size of int[][]
	 * initialData and to initialise each element with the values in
	 * initialData.
	 * 
	 * @param initialData:
	 *            An array of array of integers (int[][]) whose size determines
	 *            the size of the matrix. The array is cloned into the Matrix
	 *            object.
	 */
	public Matrix(int[][] initialData) {
		this.matrix = new int [initialData.length][initialData[0].length];	//getting the rows and cols of initial data into a matrix
		this.matrix = initialData;
			}
	/**
	 * @return Returns the number of rows of the Matrix object.
	 */
	public int getRows() {
			return this.matrix.length; //returning rows
	}

	/**
	 * @return Returns the number of columns of the Matrix object.
	 */
	public int getCols() {
			return this.matrix[0].length;	//returning columns
	}

	/**
	 * @param i:
	 *            data element row index starting from 0
	 * @param j:
	 *            data element column index starting from 0
	 * @return: Returns the element at row i and column j of the Matrix object
	 */
	public int getData(int i, int j) {
		return this.matrix[i][j];		//returning data
	}	

	/**
	 * @return Returns a 2-dimensional array of integers (int[][]) where the
	 *         matrix elements are stored
	 */
	public int[][] getData() {
		return this.matrix;
	}

	/**
	 * @param matrix:
	 *            Matrix object to be added to the caller matrix
	 * @return Returns a new matrix object which is the sum of self and the
	 *         parameter matrix. Returns null if dimensions do not match.
	 */
	public Matrix add(Matrix matrix) {
		int[][] sum = new int[matrix.getRows()][matrix.getCols()];
		if (this.getCols() != matrix.getCols() || this.getRows() != matrix.getRows()) {		//if the dimensions are not the same it (!=) returns null
		return null;
		}
		for (int i = 0; i < matrix.getRows(); i++) {
			for (int j = 0; j < matrix.getCols(); j++) {
				sum[i][j] = this.matrix[i][j] + matrix.matrix[i][j];		//adds two matrixes
			}
		}
		return new Matrix(sum);
	}

	/**
	 * @param matrix:
	 *            Matrix object to be subtracted from the caller matrix
	 * @return Returns a new Matrix object which is the difference of self and
	 *         the parameter matrix. Returns null if dimensions do not match.
	 */
	public Matrix sub(Matrix matrix) {
		int[][] sum = new int[matrix.getRows()][matrix.getCols()];
		if (this.getCols() != matrix.getCols() || this.getRows() != matrix.getRows()) {		//returns null if the dimensions do not match
			return null;
		}
		for (int i = 0; i < matrix.getRows(); i++) {
			for (int j = 0; j < matrix.getCols(); j++) {
				sum[i][j] = this.matrix[i][j] - matrix.matrix[i][j];	//matrix object - caller matrix		
			}
		}
		return new Matrix(sum);
	
	}

	/**
	 * @return Returns the transpose of the matrix as a new Matrix object
	 */
	public Matrix transpose() {
		int[][] tran = new int[this.getCols()][this.getRows()];
		for (int i = 0; i < this.getRows(); i++)
			for (int j = 0; j < this.getCols(); j++)
				tran[j][i] = this.matrix[i][j];			//switches rows and cols
	return new Matrix(tran);
	}

	/**
	 * @param matrix:
	 *            Matrix object to be concatenated to the caller matrix.
	 * @return: Returns the concatenation of the two matrices as a new Matrix
	 *          object. Returns null if the number of columns does not match.
	 */
	public Matrix concat(Matrix matrix) {
		int[][] conc = new int[matrix.getRows()+this.getRows()][matrix.getCols()];
		if (this.getCols() != matrix.getCols()) {			//returns null if cols and rows dont match
		return null;
		}
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				conc[i][j] = this.matrix[i][j];
			}
			}
		for (int i = 0; i < matrix.getRows(); i++) {
			for (int j = 0; j < matrix.getCols(); j++) {
				conc[this.getRows() + i][j] = matrix.matrix[i][j];
			}
		}
		return new Matrix(conc);

	}

	/**
	 * @param row:
	 *            row index starting from 1
	 * @return: Returns an array (int[]) containing the requested row. Returns null if the row does not exist.
	 */
	public int[] getRow(int row) {
		if (row<=0 || row > this.getRows()) {
		return null;
		}
		row--;
		int[] row1 = new int [this.getCols()];
		for (int i = 0; i < this.getCols(); i++) {
			row1[i] = this.matrix[row][i];
		}
		return row1;
	}

	/**
	 * @param col:
	 *            column index starting from 1
	 * @return : Returns an array (int[]) containing the requested column. Returns null if the row does not exist.
	 */
	public int[] getCol(int col) {
		if (col <= 0 || col > this.getCols()) {
		return null;
		}
		col--;
		int[] col1 = new int[this.getRows()];
		for (int i = 0; i < this.getRows(); i++) {
			col1[i] = this.matrix[i][col];
		}
		return col1;
	}
	
	/**
	 * @return : Returns a String representation of the Matrix.
	 */
	public String toString(){
		String result ="";
	    String ls = System.getProperty("line.separator");
		
		for (int i = 0; i < this.getRows(); i++){
			for (int j = 0; j < this.getCols(); j++)
				result = result.concat(Integer.toString(this.getData(i,j)) + " ");
			result = result.concat(ls);
		}
		return result;		
	}
	
	public static void main(String[] args){
		int[][] dataA = {{2, 2},{3, 3}};
		int[][] dataB = {{1, 1},{1, 1}};
		
		Matrix matrixA = new Matrix(dataA);
		Matrix matrixB = new Matrix(dataB);
		
		System.out.println("A+B");
		System.out.println(matrixA.add(matrixB).toString());
		System.out.println("A-B");
		System.out.println(matrixA.sub(matrixB).toString());
		System.out.println("transpose(A)");
		System.out.println(matrixA.transpose().toString());
		System.out.println("A concat B");
		System.out.println(matrixA.concat(matrixB).toString());
		System.out.println("B concat A");
		System.out.println(matrixB.concat(matrixA).toString());
		System.out.println("(A concat B) + (B concat A)");
		System.out.println(matrixA.concat(matrixB).add(matrixB.concat(matrixA)).toString());
		System.out.println("A+B-B");
		System.out.println(matrixA.add(matrixB).sub(matrixB).toString());
	}
}