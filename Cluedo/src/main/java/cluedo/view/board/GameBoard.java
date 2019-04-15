
package cluedo.view.board;

import cluedo.view.AbstractBaseWindow;
import cluedo.view.FieldEnum;
import cluedo.view.board.component.PositionedButton;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 * This class is responsible for the appearance of the whole game board. It
 * contains the field buttons and the clue paper and the cards of the player.
 */
public class GameBoard extends AbstractBaseWindow{
    private JPanel jpBase;
    private FieldEnum[][] fieldMatrix=new FieldEnum[4][10];
    private List<JPanel> roomLabelList=new ArrayList<>();
CluePaperPanel cluePaperPanel=new CluePaperPanel();
    public GameBoard(){
        jpBase=new JPanel();
        jpBase.setLayout(new BoxLayout(jpBase, BoxLayout.Y_AXIS));
        JScrollPane jscrollBase=new JScrollPane();
        fieldMatrix[0][0]=FieldEnum.ROOM;
        fieldMatrix[0][1]=FieldEnum.ROOM;
        fieldMatrix[0][2]=FieldEnum.ROOM;
        fieldMatrix[0][3]=FieldEnum.ROOM;
        fieldMatrix[0][4]=FieldEnum.ENTRY;
        fieldMatrix[0][5]=FieldEnum.FIELD;
        fieldMatrix[0][6]=FieldEnum.ROOM;
        fieldMatrix[0][7]=FieldEnum.ROOM;
        fieldMatrix[0][8]=FieldEnum.ROOM;
        fieldMatrix[0][9]=FieldEnum.FIELD;
        fieldMatrix[1][0]=FieldEnum.ROOM;
        fieldMatrix[1][1]=FieldEnum.ROOM;
        fieldMatrix[1][2]=FieldEnum.ROOM;
        fieldMatrix[1][3]=FieldEnum.ROOM;
        fieldMatrix[1][4]=FieldEnum.INTRIC;
        fieldMatrix[1][5]=FieldEnum.INTRIC;
        fieldMatrix[1][6]=FieldEnum.ROOM;
        fieldMatrix[1][7]=FieldEnum.ROOM;
        fieldMatrix[1][8]=FieldEnum.ROOM;
        fieldMatrix[1][9]=FieldEnum.ENTRY;
        fieldMatrix[2][0]=FieldEnum.ROOM;
        fieldMatrix[2][1]=FieldEnum.ROOM;
        fieldMatrix[2][2]=FieldEnum.ROOM;
        fieldMatrix[2][3]=FieldEnum.ROOM;
        fieldMatrix[2][4]=FieldEnum.FIELD;
        fieldMatrix[2][5]=FieldEnum.INTRIC;
        fieldMatrix[2][6]=FieldEnum.ROOM;
        fieldMatrix[2][7]=FieldEnum.ROOM;
        fieldMatrix[2][8]=FieldEnum.ROOM;
        fieldMatrix[2][9]=FieldEnum.ENTRY;
        fieldMatrix[3][0]=FieldEnum.FIELD;
        fieldMatrix[3][1]=FieldEnum.FIELD;
        fieldMatrix[3][2]=FieldEnum.FIELD;
        fieldMatrix[3][3]=FieldEnum.FIELD;
        fieldMatrix[3][4]=FieldEnum.FIELD;
        fieldMatrix[3][5]=FieldEnum.INTRIC;
        fieldMatrix[3][6]=FieldEnum.FIELD;
        fieldMatrix[3][7]=FieldEnum.INTRIC;
        fieldMatrix[3][8]=FieldEnum.INTRIC;
        fieldMatrix[3][9]=FieldEnum.FIELD;
        jscrollBase.setViewportView(jpBase);

     JPanel jpBoard=new JPanel(new FlowLayout(FlowLayout.LEADING,0,0));
     jpBoard.setSize(10*53, 4*53);
     jpBoard.setPreferredSize(new Dimension(10*53, 4*53));
     jpBoard.setMaximumSize(new Dimension(10*53, 4*53));
        processComponents(jpBoard);
        jpBase.add(jpBoard);
        jpBase.setBackground(new Color(180, 0,0));
        
        jpBase.add(cluePaperPanel);
        Container cp=getContentPane();
        cp.add(jpBase);
    }
    private void addButtonToBoard(JPanel jpBoard, int row, int column){
        PositionedButton button=new PositionedButton(row,column);
        button.setPreferredSize(new Dimension(53,53));
        jpBoard.add(button);
    }
    private void processComponents(JPanel jpBoard){
        JPanel label=new JPanel();
        label.setSize(4*53, 3*53);
        for(int i=0; i<4; ++i){
            addButtonToBoard(jpBoard, 0, i);
        }
        roomLabelList.add(label);
        addButtonToBoard(jpBoard,0,4);
        
        addButtonToBoard(jpBoard,0,5);
        
    
        label=new JPanel();
        label.setSize(3*53, 3*53);
        for(int i=0; i<3; ++i){
            addButtonToBoard(jpBoard, 0, i+6);
        }
        label.setPreferredSize(new Dimension(3*53, 3*53));
        roomLabelList.add(label);
        addButtonToBoard(jpBoard,0,9);
        for(int i=0; i<4; ++i){
            addButtonToBoard(jpBoard, 1, i);
        }
        addButtonToBoard(jpBoard,1,4);
        addButtonToBoard(jpBoard,1,5);
        for(int i=0; i<3;++i){
            addButtonToBoard(jpBoard, 1, i+6);
        }
        addButtonToBoard(jpBoard,1,9);
        for(int i=0; i<4;++i){
            addButtonToBoard(jpBoard, 2, i);
        }
        addButtonToBoard(jpBoard,2,4);
        addButtonToBoard(jpBoard,2,5);
         for(int i=0; i<3;++i){
            addButtonToBoard(jpBoard, 2, i+6);
        }
        addButtonToBoard(jpBoard,2,9);
        addButtonToBoard(jpBoard,3,0);
        addButtonToBoard(jpBoard,3,1);
        addButtonToBoard(jpBoard,3,2);
        addButtonToBoard(jpBoard,3,3);
        addButtonToBoard(jpBoard,3,4);
        addButtonToBoard(jpBoard,3,5);
        addButtonToBoard(jpBoard,3,6);
        addButtonToBoard(jpBoard,3,7);
        addButtonToBoard(jpBoard,3,8);
        addButtonToBoard(jpBoard,3,9);
        
    }
     @Override
    protected void resetStringsOnWindow(){
        super.resetStringsOnWindow();
        cluePaperPanel.resetStrings();
    }
}
