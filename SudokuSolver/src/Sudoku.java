import java.awt.*;        // Uses AWT's Layout Managers
import java.awt.event.*;  // Uses AWT's Event Handlers
import javax.swing.*;     // Uses Swing's Container/Components


/**
 * The Sudoku game.
 * To solve the number puzzle, each row, each column, and each of the
 * nine 3×3 sub-grids shall contain all of the digits from 1 to 9
 */
public class Sudoku extends JFrame {


	/**
	 * The generated serial long UID
	 */
	private static final long serialVersionUID = 508027310142442977L;

	/**
	 * Constructor to setup the GUI Components
	 */
	public Sudoku() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(Consts.GRID_SIZE, Consts.GRID_SIZE));  // 9x9 GridLayout

		System.setProperty("apple.laf.useScreenMenuBar", "true");
		JMenuBar menuBar= new JMenuBar();
		JMenu solve= new JMenu("Solve");
		JMenuItem item= new JMenuItem("Solve The Board");
		JMenuItem lockItem= new JMenuItem("Lock In Initial Board");

		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solver();
				System.out.println("Solved");
			}
		});
		solve.add(item);

		lockItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lockIn();
				System.out.println("Locked");
			}
		});
		solve.add(lockItem);


		JMenu reset= new JMenu("Reset");
		JMenuItem resetItem= new JMenuItem("Reset The Board");

		resetItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Extras.puzzle(Consts.puzzle0);
				System.out.println("Reset");
			}
		});
		reset.add(resetItem);


		menuBar.add(solve);
		menuBar.add(reset);
		menuBar.add(Extras.addExtraMenu());
		setJMenuBar(menuBar);

		// Allocate a common listener as the ActionEvent listener for all the
		//  JTextFields
		InputListener listener= new InputListener();

		// Construct 9x9 JTextFields and add to the content-pane
		for (int row= 0; row < Consts.GRID_SIZE; row++) {
			for (int col= 0; col < Consts.GRID_SIZE; col++) {
				Consts.tfCells[row][col] = new JTextField(); // Allocate element of array
				JTextField tfc= Consts.tfCells[row][col];
				tfc.setBorder(Consts.CELL_LINE);
				cp.add(tfc);            // ContentPane adds JTextField
				if (Consts.masks[row][col]) {
					tfc.setText("");     // set to empty string
					tfc.setEditable(true);
					tfc.setBackground(checkered(row, col, Consts.OPEN_CELL_BGCOLORD,
							Consts.OPEN_CELL_BGCOLORL));
					tfc.setForeground(Consts.CLOSED_CELL_TEXT);
					// Add ActionEvent listener to process the input
					tfc.addActionListener(listener);

				} else {
					tfc.setText(Consts.puzzle1[row][col] + "");
					tfc.setEditable(false);
					tfc.setBackground(checkered(row, col, Consts.CLOSED_CELL_BGCOLORD,
							Consts.CLOSED_CELL_BGCOLORL));
					tfc.setForeground(Consts.CLOSED_CELL_TEXT);
				}
				// Beautify all the cells
				tfc.setHorizontalAlignment(JTextField.CENTER);
				tfc.setFont(Consts.FONT_NUMBERS);
			}
		}

		// Set the size of the content-pane and pack all the components
		//  under this container.
		cp.setPreferredSize(new Dimension(Consts.CANVAS_WIDTH, Consts.CANVAS_HEIGHT));
		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Handle window closing
		setTitle("Sudoku");
		setVisible(true);
	}

	public static void lockIn() {
		for (int row= 0; row < Consts.GRID_SIZE; row++) {
			for (int col= 0; col < Consts.GRID_SIZE; col++) {
				JTextField tfc= Consts.tfCells[row][col];
				//				Cell c= new Cell(tfc, row, col);
				//				System.out.println("C num guess: " + c.numberGuess);
				String val= tfc.getText();
				if (val.equals("")) {
					Consts.puzzle1[row][col]= 0;
					tfc.setText("");     // set to empty string
					tfc.setEditable(true);
					tfc.setBackground(checkered(row, col, Consts.OPEN_CELL_BGCOLORD,
							Consts.OPEN_CELL_BGCOLORL));
				} 
				else {
					Consts.puzzle1[row][col]= Integer.parseInt(val);
					Consts.masks[row][col]= false;
					tfc.setText(Consts.puzzle1[row][col] + "");
					tfc.setEditable(false);
					tfc.setBackground(checkered(row, col, Consts.CLOSED_CELL_BGCOLORD,
							Consts.CLOSED_CELL_BGCOLORL));
					tfc.setForeground(Consts.CLOSED_CELL_TEXT);
				}
				// Beautify all the cells
				tfc.setHorizontalAlignment(JTextField.CENTER);
				tfc.setFont(Consts.FONT_NUMBERS);
			}
		}
	}		

	public static void solver() {
		if (Solve.solve(0,0,Consts.puzzle1)) System.out.println("Solving...");
		else System.out.println("NONE");
	}

	public static Color checkered(int r, int c, Color d, Color l) {
		if ((3 <= r && r <= 5) || (3 <= c && c<= 5)) {
			if ((3 <= r && r <= 5) && (3 <= c && c <= 5)) {
				return d;
			}
			else return l;
		}
		else return d;
	}


	/** The entry main() entry method */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Sudoku());
	}

}

