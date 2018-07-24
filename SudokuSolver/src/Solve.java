import javax.swing.JTextField;

public class Solve {
	
	public static boolean isValid(int r, int c, int val, int[][] puzzle) {
		for (int k = 0; k < 9; ++k)  // row
			if (val == puzzle[k][c])
				return false;

		for (int k = 0; k < 9; ++k) // col
			if (val == puzzle[r][k])
				return false;

		int boxRowOffset = (r / 3)*3;
		int boxColOffset = (c / 3)*3;
		for (int k = 0; k < 3; ++k) // box
			for (int m = 0; m < 3; ++m)
				if (val == puzzle[boxRowOffset+k][boxColOffset+m])
					return false;

		return true; // no violations, so it's legal
	}	
	
	public static boolean solve(int r, int c, int[][] puzzle) {		
		if (r == 9) {
			r = 0;
			if (++c == 9) 
				return true; 
		}
		
		JTextField tfc= Consts.tfCells[r][c];
		
		if (puzzle[r][c] != 0)  // skip filled cells
			return solve(r+1, c, puzzle);

		for (int val = 1; val <= 9; ++val) {
			if (isValid(r, c, val, puzzle)) {
				puzzle[r][c] = val; 
				
				Consts.masks[r][c]= false;
				tfc.setText(puzzle[r][c] + "");
				tfc.setEditable(false);
				tfc.setBackground(Sudoku.checkered(r, c, Consts.SOLVED_CELL_BGCOLORD,
						Consts.SOLVED_CELL_BGCOLORL));
				tfc.setForeground(Consts.SOLVED_CELL_TEXT);
				
				if (solve(r+1, c, puzzle)) return true;
			}
		}
		puzzle[r][c] = 0; // reset on backtrack
		return false;
	}
}
