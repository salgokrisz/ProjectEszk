
package cluedo.view.board;

import cluedo.logic.cards.Card;
import cluedo.logic.controller.GameBoardListener;
import cluedo.logic.controller.GameController;
import cluedo.logic.factories.RoomFactory;
import cluedo.logic.fields.Field;
import cluedo.logic.fields.FieldType;
import cluedo.logic.fields.RoomField;
import cluedo.logic.fields.StartField;
import cluedo.logic.player.Player;
import cluedo.logic.role.Role;
import cluedo.logic.room.Room;
import cluedo.logic.room.SecretCorridoredRoom;
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
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 * This class is responsible for the appearance of the whole game board. It
 * contains the field buttons and the clue paper and the cards of the player.
 */
public class GameBoard extends AbstractBaseWindow implements GameBoardListener{
    private JPanel jpBase;
    private FieldEnum[][] fieldMatrix=new FieldEnum[4][10];
    //private List<JPanel> roomLabelList=new ArrayList<>();//Commented out because PMD says it havent been used.
    private final GameController gameController;
    private JTabbedPane tabbedPane;
    private JButton cardButton;
    private JButton diceButton;
CluePaperPanel cluePaperPanel;
    public GameBoard(GameController gameController){
        jpBase=new JPanel();
        cluePaperPanel=new CluePaperPanel();
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
        this.gameController=gameController;
        JPanel  panelForGameBoard=new JPanel(new BorderLayout());
     JPanel jpBoard=new JPanel(new FlowLayout(FlowLayout.LEADING,0,0));
     
        processComponents(jpBoard);
        jscrollBase.setPreferredSize(jpBoard.getSize());
        jscrollBase.setViewportView(jpBoard);
        tabbedPane = new JTabbedPane();
        panelForGameBoard.add(jscrollBase, CENTER);
        JPanel panelForButtons=new JPanel();
        panelForButtons.setLayout(new BoxLayout(panelForButtons, BoxLayout.X_AXIS));
        cardButton=new JButton(LanguageStrings.getString("GameBoard.MyCards"));
        diceButton=new JButton();
        cardButton.setBackground(new Color(255, 30, 21));
        diceButton.setBackground(new Color(255, 30, 21));
        diceButton.setIcon(new ImageIcon(getClass().getResource("/board/dice.png")));
        panelForButtons.add(cardButton);
        JPanel dummyPanel=new JPanel();
        dummyPanel.setPreferredSize(new Dimension(10, 10));
        dummyPanel.setBackground(new Color(180, 0,0));
        panelForButtons.add(dummyPanel);
        diceButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            gameController.rollDice();
        });
        panelForButtons.add(diceButton);
        panelForButtons.setBackground(new Color(180, 0,0));
        panelForGameBoard.add(panelForButtons, SOUTH);
        tabbedPane.addTab(LanguageStrings.getString("GameBoard.Board"), panelForGameBoard);
        JPanel dummyPanelForCluePaper=new JPanel(new BorderLayout());
        dummyPanel=new JPanel();
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
        
        registerGameBoardListener();
    }
    private void registerGameBoardListener(){
        this.gameController.registerGameBoardListener(this);
    }
    private void addButtonToBoard(JPanel jpBoard, int row, int column, Color color, ImageIcon icon, boolean enabled){
        PositionedButton button=new PositionedButton(row,column);
        button.setPreferredSize(new Dimension(53,53));
        if(color!=null){
            button.setBackground(color);
        }
        if(icon!=null){
            button.setIcon(icon);
        }
        button.setEnabled(enabled);
        jpBoard.add(button);
    }
   
    private void processComponents(JPanel jpBoard){
        List<List<Field>> map=gameController.getFieldMap();
        int maxWidth=map.get(0).size();
        jpBoard.setBackground(new Color(180, 0,0));
        for(int i=0; i<map.size(); ++i){
            List<Field> row=map.get(i);
            for(int j=0; j<row.size(); ++j){
                Color color=null;
                ImageIcon icon=null;
                boolean enabled=true;
                if (row.get(j).getType()==FieldType.ROOM || row.get(j).getType()==FieldType.END){        
                    String roomKey;
                    if(row.get(j).getType()==FieldType.ROOM){
                       roomKey=((RoomField)row.get(j)).getRoomName();
                    }else{
                        roomKey=RoomFactory.ENDROOM_KEY;
                    }
                    Room room=gameController.getRoomForName(roomKey);
                    if(room.getClass()==SecretCorridoredRoom.class && !((SecretCorridoredRoom)room).getWasSetSecretEntranceImage()){
                        icon=new ImageIcon(getClass().getResource("/board/secret_corridor.png"));
                        ((SecretCorridoredRoom)room).setWasSetSecretEntranceImage(true);
                    }else{
                       color=room.getColor();
                       enabled=false;
                    }
                    ;
                }else if(row.get(j).getType()==FieldType.INTRIC){
                    icon=new ImageIcon(getClass().getResource("/board/intric_field.png"));
                }else if(row.get(j).getType()==FieldType.ENTRANCE){
                    icon=new ImageIcon(getClass().getResource("/board/entrance.png"));
                }else if(row.get(j).getType()==FieldType.START){
                    Role standsHere=gameController.findPuppetWhoStandsHere(i, j);
                    if(standsHere==null){
                    color=findColorAccordingToRole(((StartField)row.get(j)).getBelongsTo());
                    }else{
                        icon=standsHere.getPuppetImage();
                    }
                }else{
                    icon=new ImageIcon(getClass().getResource("/board/field.png"));
                }
            addButtonToBoard(jpBoard, i, j, color, icon, enabled);
            
            }

            if(maxWidth<row.size()){
                maxWidth=row.size();
            }
        }
        int height=gameController.getMapHeight();
        jpBoard.setSize(maxWidth*53, height*53);
     jpBoard.setPreferredSize(new Dimension(maxWidth*53, height*53));
     jpBoard.setMaximumSize(new Dimension(maxWidth*53, height*53));
    }
    private Color findColorAccordingToRole(String roleInString){
        Color color;
        switch(roleInString){
            case "Mustard":
                color=new Color(255,94,0);
                break;
            case "Scarlet":
                color=new Color(255, 0, 0);
                break;
            case "Peacock":
                color=new Color(0,0,255);
                break;
            case "Green":
                color=new Color(0,255,0);
                break;
            case "Plum":
                color=new Color(148,44,124);
                break;
            default:
                color=new Color(255,255,255);
        }
        return color;
    }
    @Override
    public void showWhatToDo(String message){
        JOptionPane.showMessageDialog(this, message, LanguageStrings.getString("JOptionPane.ToDo"), JOptionPane.INFORMATION_MESSAGE);
    }
    @Override
    public void showAllSuspectCardInformations(Player player){
       StringBuilder sb=new StringBuilder();
       List<Card> suspectCards=player.getSuspectCards();
       for(Card c: suspectCards){
           sb.append(c.getNameForUI()).append(System.lineSeparator());
       }
       cluePaperPanel.markOwnedSuspectCards(player.getSuspectCards());
       Object[] options={"Ok"};
        JOptionPane.showOptionDialog(this, sb.toString(), LanguageStrings.getString("JOptionPane.SuspectCardTitle"), JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }
     @Override
    protected void resetStringsOnWindow(){
        super.resetStringsOnWindow();
        cluePaperPanel.resetStrings();
        tabbedPane.setTitleAt(0, LanguageStrings.getString("GameBoard.Board"));
        tabbedPane.setTitleAt(1, LanguageStrings.getString("GameBoard.CluePaper"));
        cardButton.setText(LanguageStrings.getString("GameBoard.MyCards"));
    }
    @Override
    public void showInformation(String message){
        Object[] options={"Ok"};
        JOptionPane.showOptionDialog(this, message, LanguageStrings.getString("JOptionPane.InformationTitle"), JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }
    
    public FieldEnum[][] getFieldMatrix() { //Added because Pmd said that this variable is unused.
        return fieldMatrix;
    }
}