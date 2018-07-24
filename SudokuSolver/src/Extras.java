import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Extras {
	
	public static InputListener listener= new InputListener();
	
	public static void puzzle(int[][] puzzle) {
		for (int r= 0; r < Consts.GRID_SIZE; r++) {
			for (int c= 0; c < Consts.GRID_SIZE; c++) {
				JTextField tfc= Consts.tfCells[r][c];
				
				if (puzzle[r][c] == 0) {
					Consts.masks[r][c]= true;
					tfc.setEditable(true);
					tfc.setText("");
					tfc.setBackground(Sudoku.checkered(r, c, Consts.OPEN_CELL_BGCOLORD,
							Consts.OPEN_CELL_BGCOLORL));
					tfc.addActionListener(listener);
				}
				else {
					Consts.masks[r][c]= false;
					tfc.setEditable(false);
					tfc.setText(Consts.puzzle1[r][c] + "");
					tfc.setBackground(Sudoku.checkered(r, c, Consts.SOLVED_CELL_BGCOLORD,
							Consts.SOLVED_CELL_BGCOLORL));
					tfc.setForeground(Consts.SOLVED_CELL_TEXT);
				}
			}
		}
	}
	
	public static void createMenuItems(JMenu jm, JMenuItem jmi, int[][] i,
			String s) {
		jmi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				puzzle(i);
				System.out.println(s);
			}
		});
		jm.add(jmi);
	}
	
	public static JMenu addExtraMenu() {
		JMenu extra= new JMenu("Extras");
		JMenuItem extraItem1= new JMenuItem("Set Board to Puzzle 1");
		JMenuItem extraItem2= new JMenuItem("Set Board to Puzzle 2");
		JMenuItem extraItem3= new JMenuItem("Set Board to Puzzle 3");
		JMenuItem extraItem4= new JMenuItem("Set Board to Puzzle 4");
		JMenuItem extraItem5= new JMenuItem("Set Board to Puzzle 5");
		JMenuItem extraItem6= new JMenuItem("Set Board to Puzzle 6");
		JMenuItem extraItem7= new JMenuItem("Set Board to Puzzle 7");
		JMenuItem extraItem8= new JMenuItem("Set Board to Puzzle 8");
		JMenuItem extraItem9= new JMenuItem("Set Board to Puzzle 9");
		JMenuItem extraItem10= new JMenuItem("Set Board to Puzzle 10");
		
		createMenuItems(extra, extraItem1, Consts.puzzle1, "Board -> Puzzle 1");
		createMenuItems(extra, extraItem2, Consts.puzzle2, "Board -> Puzzle 2");
		createMenuItems(extra, extraItem3, Consts.puzzle3, "Board -> Puzzle 3");
		createMenuItems(extra, extraItem4, Consts.puzzle4, "Board -> Puzzle 4");
		createMenuItems(extra, extraItem5, Consts.puzzle5, "Board -> Puzzle 5");
		createMenuItems(extra, extraItem6, Consts.puzzle6, "Board -> Puzzle 6");
		createMenuItems(extra, extraItem7, Consts.puzzle7, "Board -> Puzzle 7");
		createMenuItems(extra, extraItem8, Consts.puzzle8, "Board -> Puzzle 8");
		createMenuItems(extra, extraItem9, Consts.puzzle9, "Board -> Puzzle 9");
		createMenuItems(extra, extraItem10, Consts.puzzle10, "Board -> Puzzle 10");

		return extra;
	}
}
