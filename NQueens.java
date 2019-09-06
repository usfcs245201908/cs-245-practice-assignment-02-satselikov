/**
 * 
 * NQueens.java 9/5/2019
 * 
 * @author Stephen Tselikov
 *
 */

//Nqueens 
//table 1 - <<constructor>>, boolean placeNQueens(), void printToConsole()
public class NQueens {
	// initialize variables
	int n;

	// constructor NQueens
	public NQueens(int n) {
		this.n = n;

		// printToConsole(board);
	}

	// placeNQueen
	public boolean placeNQueens() {
		// initialize board and variables
		int[][] board = new int[n][n];
		int i;
		int j;

		// initialize board with 0
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				board[i][j] = 0;
			}
		}

		// check if the board has a correct size
		// anything less than 1 throws exception stating no solution
		if (n < 1) {
			throw new IllegalArgumentException("Number cannot be less than 1.");
		}
		if (solveNQrec(board, 0) == false) {
			System.out.print("There is no solution.");
			return false;
		}
		printToConsole(board);
		return true;
	}

	// recursion
	// call function within itself
	// call OK_toplace here
	boolean solveNQrec(int b[][], int column) {
		if (column >= n)
			return true;
		for (int i = 0; i < n; i++) {
			if (OK_toplace(b, i, column)) {
				b[i][column] = 1;
				if (solveNQrec(b, column + 1) == true)
					return true;
				b[i][column] = 0;
			}
		}
		return false;
	}

	// check if it is ok to place the queens into certain row/column
	// if the place in the 2d array is a 1, then queen cannot be placed
	// checks horizontal left, upper diag on left, and lower diag left
	// places queen
	boolean OK_toplace(int b[][], int row, int column) {
		int i;
		int j;
		for (i = 0; i < column; i++)
			if (b[row][i] == 1)
				return false;

		for (i = row, j = column; i >= 0 && j >= 0; i--, j--)
			if (b[i][j] == 1)
				return false;

		for (i = row, j = column; j >= 0 && i < n; i++, j--)
			if (b[i][j] == 1)
				return false;

		return true;
	}

	// print method loops through the rows and columns, if it equals 1, then there
	// is a queen, if not then there is a _
	public static void printToConsole(int[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] == 1) {
					System.out.print("Q ");
				} else {
					System.out.print("_ ");
				}
			}
			System.out.println();
		}
		System.out.println("");
	}
}
