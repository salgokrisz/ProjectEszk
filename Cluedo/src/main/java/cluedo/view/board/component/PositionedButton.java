
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
    private final boolean isEnabledToClickOn;

    public PositionedButton(int row, int column, ImageIcon basicIconImage, Color basicBackgroundColor, boolean isEnabledToClickOn) {
        this.row = row;
        this.column = column;
        this.basicBackgroundColor=basicBackgroundColor;
        this.basicIconImage=basicIconImage;
        this.isEnabledToClickOn=isEnabledToClickOn;
    }

    public boolean getIsEnabledToClickOn() {
        return isEnabledToClickOn;
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
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder("row: ");
        sb.append(row).append(", column: ").append(column);
        return sb.toString();
    }
}
