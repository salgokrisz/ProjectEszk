
package cluedo.view.board.component;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * This class is a JButton with a plus function that it knows its place on the
 * game board.
 */
public class PositionedButton extends JButton{
    private final int row;
    private final int column;
    private final ImageIcon basicIconImage;
    private final Color basicBackgroundColor;

    public PositionedButton(int row, int column, ImageIcon basicIconImage, Color basicBackgroundColor) {
        this.row = row;
        this.column = column;
        this.basicBackgroundColor=basicBackgroundColor;
        this.basicIconImage=basicIconImage;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public ImageIcon getBasicIconImage() {
        return basicIconImage;
    }

    public Color getBasicBackgroundColor() {
        return basicBackgroundColor;
    }
    
}
