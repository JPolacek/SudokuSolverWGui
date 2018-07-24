import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class Consts {
	public static final int GRID_SIZE= 9;    // Size of the board
	public static final int SUBGRID_SIZE= 3; // Size of the sub-grid
	public static final int TIMER_SIZE= 2;

	// Name-constants for UI control (sizes, colors and fonts)
	public static final int CELL_SIZE= 60;   // Cell width/height in pixels
	public static final int CANVAS_WIDTH = CELL_SIZE * GRID_SIZE;
	public static final int CANVAS_HEIGHT= CELL_SIZE * GRID_SIZE;
	public static final int TIMER_CANVAS_W= 400;
	public static final int TIMER_CANVAS_H= 300;
	
	// Board width/height in pixels
	public static final Color OPEN_CELL_BGCOLORL= new Color(225, 0, 0);
	public static final Color OPEN_CELL_BGCOLORD= new Color(175, 0, 0);
	public static final Color OPEN_CELL_TEXT_YES= new Color(0, 255, 0);  // RGB
	public static final Color OPEN_CELL_TEXT_NO= Color.RED;
	public static final Color CLOSED_CELL_BGCOLORL= new Color(245, 245, 245); // RGB
	public static final Color CLOSED_CELL_BGCOLORD= new Color(195, 195, 195); // RGB
	public static final Color SOLVED_CELL_BGCOLORL= new Color(0, 225, 0);
	public static final Color SOLVED_CELL_BGCOLORD= new Color(0, 175, 0);
	public static final Color CLOSED_CELL_TEXT= Color.BLACK;
	public static final Color SOLVED_CELL_TEXT= Color.WHITE;
	public static final Font FONT_NUMBERS= new Font("Monospaced", Font.BOLD, 20);
	// Border constants
	public static final Border CELL_LINE= BorderFactory.createLineBorder(Color.black, 1);
	public static final Border NONET_LINE= BorderFactory.createLineBorder(Color.black, 3);

	// Timer Delay Consts
	public static final int TIMER_DELAY= 1000;
	
	// The game board composes of 9x9 JTextFields,
	// each containing String "1" to "9", or empty String
	public static JTextField[][] tfCells = new JTextField[GRID_SIZE][GRID_SIZE];

	public static int[][] puzzle0=				// The Reset/Blank puzzle
		{{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	
	public static int[][] puzzle1=
		{{5, 3, 4, 6, 7, 8, 9, 1, 2},
				{6, 7, 2, 1, 9, 5, 3, 4, 8},
				{1, 9, 8, 3, 4, 2, 5, 6, 7},
				{8, 5, 9, 7, 6, 1, 4, 2, 3},
				{4, 2, 6, 8, 5, 3, 7, 9, 1},
				{7, 1, 3, 9, 2, 4, 8, 5, 6},
				{9, 6, 1, 5, 3, 7, 2, 8, 4},
				{2, 8, 7, 4, 1, 9, 6, 3, 5},
				{3, 4, 5, 2, 8, 6, 1, 7, 9}};
	
	public static int[][] puzzle2=
		{{5, 3, 0, 0, 7, 0, 0, 0, 0},
				{6, 0, 0, 1, 9, 5, 0, 0, 0},
				{1, 9, 0, 0, 0, 0, 0, 6, 0},
				{8, 0, 0, 0, 6, 0, 0, 0, 3},
				{4, 0, 0, 8, 0, 3, 0, 0, 1},
				{7, 0, 0, 0, 2, 0, 0, 0, 6},
				{0, 6, 0, 0, 0, 0, 2, 8, 0},
				{0, 0, 0, 4, 1, 9, 0, 0, 5},
				{0, 0, 0, 0, 8, 0, 0, 7, 9}};
	
	public static int[][] puzzle3=
		{{5, 0, 0, 0, 0, 4, 0, 3, 0},
				{0, 0, 1, 0, 0, 9, 4, 0, 0},
				{9, 0, 0, 5, 0, 0, 7, 0, 1},
				{0, 2, 0, 8, 3, 0, 1, 0, 0},
				{1, 6, 0, 9, 4, 2, 0, 7, 3},
				{0, 0, 7, 0, 1, 5, 0, 2, 0},
				{6, 0, 3, 0, 0, 1, 0, 0, 2},
				{0, 0, 2, 4, 0, 0, 3, 0, 0},
				{0, 1, 0, 2, 0, 0, 0, 0, 8}};	
	
	public static int[][] puzzle4=
		{{0, 5, 0, 0, 6, 8, 0, 9, 0},
				{0, 0, 9, 1, 0, 0, 5, 0, 6},
				{3, 0, 0, 9, 2, 0, 0, 0, 0},
				{0, 7, 0, 2, 9, 3, 0, 0, 5},
				{5, 0, 6, 0, 0, 0, 9, 0, 2},
				{9, 0, 0, 5, 8, 6, 0, 3, 0},
				{0, 0, 0, 0, 5, 7, 0, 0, 4},
				{7, 0, 3, 0, 0, 9, 1, 0, 0},
				{0, 4, 0, 3, 1, 0, 0, 6, 0}};
	
	
	public static boolean[][] masks=
		{{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true}};
}
