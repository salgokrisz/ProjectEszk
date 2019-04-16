
package cluedo.view.board;

import cluedo.logic.controller.GameController;
import cluedo.tools.languagestring.LanguageStrings;
import cluedo.view.AbstractBaseWindow;
import cluedo.view.FieldEnum;
import cluedo.view.board.component.PositionedButton;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 * This class is responsible for the appearance of the whole game board. It
 * contains the field buttons and the clue paper and the cards of the player.
 */
public class GameBoard extends AbstractBaseWindow{
    private JPanel jpBase;
    private FieldEnum[][] fieldMatrix=new FieldEnum[4][10];
    private List<JPanel> roomLabelList=new ArrayList<>();
    private final GameController gameController;
CluePaperPanel cluePaperPanel=new CluePaperPanel();
    public GameBoard(GameController gameController){
        jpBase=new JPanel();
        //jpBase.setLayout(new BoxLayout(jpBase, BoxLayout.Y_AXIS));
        jpBase.setLayout(new BorderLayout());
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
     JPanel jpBoard=new JPanel(new FlowLayout(FlowLayout.LEADING,0,0));
     jpBoard.setSize(30*53, 30*53);
     jpBoard.setPreferredSize(new Dimension(30*53, 30*53));
     jpBoard.setMaximumSize(new Dimension(30*53, 30*53));
        processComponents(jpBoard);
        jscrollBase.setPreferredSize(jpBoard.getSize());
        jscrollBase.setViewportView(jpBoard);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab(LanguageStrings.getString("GameBoard.Board"), jscrollBase);
        JPanel dummyPanelForCluePaper=new JPanel(new BorderLayout());
        JPanel dummyPanel=new JPanel();
        dummyPanel.setPreferredSize(new Dimension(300, 400));
        dummyPanel.setBackground(new Color(180, 0,0));
        dummyPanelForCluePaper.add(dummyPanel, SOUTH);
        dummyPanel=new JPanel();
        dummyPanel.setPreferredSize(new Dimension(500, 400));
        dummyPanel.setBackground(new Color(180, 0,0));
        dummyPanelForCluePaper.add(dummyPanel, WEST);
        dummyPanel=new JPanel();
        dummyPanel.setPreferredSize(new Dimension(500, 400));
        dummyPanel.setBackground(new Color(180, 0,0));
        dummyPanelForCluePaper.add(dummyPanel, EAST);
        dummyPanelForCluePaper.add(cluePaperPanel, CENTER);
        tabbedPane.addTab(LanguageStrings.getString("GameBoard.CluePaper"), dummyPanelForCluePaper);
        jpBase.add(tabbedPane, CENTER);
        jpBase.setBackground(new Color(180, 0,0));
        Container cp=getContentPane();
        cp.add(jpBase);
        this.gameController=gameController;
    }
    private void addButtonToBoard(JPanel jpBoard, int row, int column){
        PositionedButton button=new PositionedButton(row,column);
        button.setPreferredSize(new Dimension(53,53));
        jpBoard.add(button);
    }
    private void processComponents(JPanel jpBoard){
        for(int i=0; i<30; ++i){
            for(int j=0; j<30; ++j){
            addButtonToBoard(jpBoard, i, j);
            }
        }  
    }
     @Override
    protected void resetStringsOnWindow(){
        super.resetStringsOnWindow();
        cluePaperPanel.resetStrings();
    }
}
