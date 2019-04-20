
package cluedo.view.board.component;

import javax.swing.JButton;

/**
 * This class is a JButton with a plus function that it knows its place on the
 * game board.
 */
public class PositionedButton extends JButton{
    private final int row;
    private final int column;

    public PositionedButton(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    
}
