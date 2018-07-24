import java.awt.event.*;  // Uses AWT's Event Handlers
import javax.swing.*;     // Uses Swing's Container/Components

class InputListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the source object that fired the event
		JTextField source = (JTextField)e.getSource();
		// Scan JTextFileds for all rows and columns, and match with the source object
		boolean found = false;
		for (int row = 0; row < Consts.GRID_SIZE && !found; ++row) {
			for (int col = 0; col < Consts.GRID_SIZE && !found; ++col) {
				if (Consts.tfCells[row][col] == source) {
					found = true;  // break the inner/outer loops
				}
			}
		}
	}
}