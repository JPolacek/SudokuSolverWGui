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
	
	public static JMenu addExtraMenu() {
		JMenu extra= new JMenu("Extras");
		JMenuItem extraItem1= new JMenuItem("Set Board to Puzzle 1");
		JMenuItem extraItem2= new JMenuItem("Set Board to Puzzle 2");
		JMenuItem extraItem3= new JMenuItem("Set Board to Puzzle 3");
		
		extraItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				puzzle(Consts.puzzle1);
				System.out.println("Board -> Puzzle 1");
			}
		});
		extra.add(extraItem1);
		
		extraItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				puzzle(Consts.puzzle2);
				System.out.println("Board -> Puzzle 2");
			}
		});
		extra.add(extraItem2);
		
		extraItem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				puzzle(Consts.puzzle3);
				System.out.println("Board -> Puzzle 3");
			}
		});
		extra.add(extraItem3);
		
		return extra;
	}
}
