/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cluedo.view.board;

import cluedo.view.AbstractBaseWindow;
import cluedo.view.FieldEnum;
import cluedo.view.board.component.PositionedButton;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author Barby
 */
public class GameBoard extends AbstractBaseWindow{
    private JPanel jpBase;
    private FieldEnum[][] fieldMatrix=new FieldEnum[4][10];
    Set<String> roomPositions=new HashSet<>();
    private List<JPanel> roomLabelList=new ArrayList<>();
    private JLabel temporaryLabel;

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
     //   calculateJLabelSizes();

     JPanel jpBoard=new JPanel(new FlowLayout(FlowLayout.LEADING,0,0));
     jpBoard.setSize(10*53, 4*53);
     jpBoard.setPreferredSize(new Dimension(10*53, 4*53));
     jpBoard.setMaximumSize(new Dimension(10*53, 4*53));
        processComponents(jpBoard);
        jpBase.add(jpBoard);
        jpBase.setBackground(new Color(180, 0,0));
        CluePaperPanel cluePaperPanel=new CluePaperPanel();
        jpBase.add(cluePaperPanel);
        Container cp=getContentPane();
        cp.add(jpBase);
    }
    private void addButtonToBoard(JPanel jpBoard, int row, int column){
        PositionedButton button=new PositionedButton(row,column);
        button.setPreferredSize(new Dimension(53,53));
    /*    System.out.println("button.width: "+button.getSize().width);
        System.out.println("button.height: "+button.getSize().height);
        System.out.println("button.preferredSize.width: "+button.getPreferredSize().width);
        System.out.println("button.preferredSize.height: "+button.getPreferredSize().height);*/
        jpBoard.add(button);
    }
    private void processComponents(JPanel jpBoard){
        
      /*  System.out.println("jpBoard width: "+jpBoard.getSize().width);
        System.out.println("jpBoard height: "+jpBoard.getSize().height);
        System.out.println("jpBoard.preferredSize.width: "+jpBoard.getPreferredSize().width);
        System.out.println("jpBoard.preferredSize.height: "+jpBoard.getPreferredSize().height);
        System.out.println("jpBoard.maximumSize.width: "+jpBoard.getMaximumSize().width);
         System.out.println("jpBoard.maximumSize.height: "+jpBoard.getMaximumSize().height);*/
        JPanel label=new JPanel();
        label.setSize(4*53, 3*53);
        for(int i=0; i<4; ++i){
            addButtonToBoard(jpBoard, 0, i);
        }
    //   label.setPreferredSize(new Dimension(4*53, 3*53));
        roomLabelList.add(label);
     /*    System.out.println("label.width: "+label.getSize().width);
        System.out.println("label.height: "+label.getSize().height);
        System.out.println("label.preferredSize.width: "+label.getPreferredSize().width);
        System.out.println("label.preferredSize.height: "+label.getPreferredSize().height);*/
    //    jpBoard.add(label);
        addButtonToBoard(jpBoard,0,4);
        
        addButtonToBoard(jpBoard,0,5);
        
    
        label=new JPanel();
        label.setSize(3*53, 3*53);
        for(int i=0; i<3; ++i){
            addButtonToBoard(jpBoard, 0, i+6);
        }
        label.setPreferredSize(new Dimension(3*53, 3*53));
        roomLabelList.add(label);
       /* System.out.println("label.width: "+label.getSize().width);
        System.out.println("label.height: "+label.getSize().height);
        System.out.println("label.preferredSize.width: "+label.getPreferredSize().width);
        System.out.println("label.preferredSize.height: "+label.getPreferredSize().height);*/
      //  jpBoard.add(label);
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
    private void calculateJLabelSizes(){ //size of one jbutton is 53x53
        int j=0;
        int i=0;
       while ( i<fieldMatrix.length){
            int endWidthField=-1;
            int endHeightField=-1;
            while(j<fieldMatrix[i].length && fieldMatrix[i][j]!=FieldEnum.ROOM){ //find start positoin of room
                j+=1;
            }
            if(j<fieldMatrix[i].length && !roomPositions.contains(Integer.toString(i)+Integer.toString(j))){ //room was found
                roomPositions.add(Integer.toString(i)+Integer.toString(j));
                endWidthField=determineWidthOfRoom(i, j);
                endHeightField=determineHeightOfRoom(i, j);
            }
            if(endWidthField==-1){
                j+=1;
            }else{
                j=endWidthField;
            }
           i+=1;
        }
    }
    private int determineHeightOfRoom(int row, int column){
        int height=53;
        int i=row+1;
         while(i<fieldMatrix.length && fieldMatrix[i][column]==FieldEnum.ROOM){
             roomPositions.add(Integer.toString(i)+ Integer.toString(column));
             height+=53;
             i+=1;
         }
         int width=temporaryLabel.getSize().width;
         temporaryLabel.setSize(width, height);
//         roomLabelList.add(temporaryLabel);
         return i;
    }
    private int determineWidthOfRoom(int row, int column){
        
        int width=53;
         JPanel panel=new JPanel();
        int i=column+1;
            while(i<fieldMatrix[row].length && fieldMatrix[row][i]==FieldEnum.ROOM){
                roomPositions.add(Integer.toString(row)+ Integer.toString(i));
                width+=53;
                i+=1;
            }
            temporaryLabel=new JLabel();
            temporaryLabel.setSize(width, 0);
        return i;    
    }
}
