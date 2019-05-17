package cluedo.view.board;

import cluedo.logic.cards.Card;
import cluedo.logic.controller.GameBoardListener;
import cluedo.logic.controller.GameController;
import cluedo.logic.controller.GamePhase;
import cluedo.logic.factories.RoomFactory;
import cluedo.logic.fields.Field;
import cluedo.logic.fields.FieldType;
import cluedo.logic.fields.RoomField;
import cluedo.logic.fields.StartField;
import cluedo.logic.player.Player;
import cluedo.logic.player.role.Role;
import cluedo.logic.room.Room;
import cluedo.logic.room.SecretCorridoredRoom;
import cluedo.tools.languagestring.LanguageStrings;
import cluedo.view.AbstractBaseWindow;
import cluedo.view.board.component.PositionedButton;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import cluedo.logic.intrics.Intrics;
import cluedo.logic.intrics.IntricsType;
import cluedo.logic.room.EndRoom;
import cluedo.logic.room.Point;
import cluedo.view.RoleChooserWindow;
import static java.awt.BorderLayout.NORTH;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * This class is responsible for the appearance of the whole game board. It
 * contains the field buttons and the clue paper and the cards of the player.
 */
public class GameBoard extends AbstractBaseWindow implements GameBoardListener {

    private boolean recognizeActions;
    private JPanel jpBase;
    private final GameController gameController;
    private JTabbedPane tabbedPane;
    private JButton suspectCardsButton;
    private JButton intricCardsButton;
    private JButton diceButton;
    private CluePaperPanel cluePaperPanel;
    private SuspectPaperPanel suspectPaperPanel;
    private List<List<PositionedButton>> buttonedMap = new ArrayList<>();
    private JPanel panelForCluePaper;
    private final JButton specialAbilityButton;
    private static final String GAMEBOARD_CLUEPAPER_CONST = "GameBoard.CluePaper";
    private static final String SURE_TO_MOVE_CONST = "JOptionPane.SureToMove";
    private static final String GAMEBOARD_DRAWNCLOCK_CONST = "GameBoard.DrawnClockCards";
    private boolean recognizeSecretPassageAction;
    private JButton finishedRoundButton;
    private AiSuspectCardWindow aiSuspectCardWindow;
    private JLabel jlToDo;
    private final JLabel jlClockInformations;

    public GameBoard(GameController gameController) {
        recognizeActions = true;
        jpBase = new JPanel();
        cluePaperPanel = new CluePaperPanel();
        jpBase.setLayout(new BorderLayout());
        JScrollPane jscrollBase = new JScrollPane();
        this.gameController = gameController;
        JPanel panelForGameBoard = new JPanel(new BorderLayout());
        JPanel jpBoard = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));

        processComponents(jpBoard);
        jscrollBase.setPreferredSize(jpBoard.getSize());
        setSize(new Dimension(1366, 770));
        jscrollBase.setViewportView(jpBoard);
        tabbedPane = new JTabbedPane();
        panelForGameBoard.add(jscrollBase, BorderLayout.CENTER);
        JPanel panelForButtons = new JPanel();
        panelForButtons.setLayout(new BoxLayout(panelForButtons, BoxLayout.X_AXIS));
        suspectCardsButton = new JButton(LanguageStrings.getString("GameBoard.MySuspectCards"));
        suspectCardsButton.addActionListener((ActionEvent evt)
                -> SwingUtilities.invokeLater(() -> {
                    CardWindow cardWindow = new CardWindow(gameController.getHumanPlayer(), "suspects");
                    cardWindow.setVisible(true);
                    openedWindowsSet.add(cardWindow);
                })
        );
        diceButton = new JButton();
        suspectCardsButton.setBackground(new Color(255, 30, 21));
        diceButton.setBackground(new Color(255, 30, 21));
        diceButton.setIcon(new ImageIcon(getClass().getResource("/board/dice.png")));
        panelForButtons.add(suspectCardsButton);
        intricCardsButton = new JButton(LanguageStrings.getString("GameBoard.MyIntricCards"));
        intricCardsButton.setBackground(new Color(255, 30, 21));
        intricCardsButton.addActionListener((ActionEvent evt)
                -> SwingUtilities.invokeLater(() -> {
                    CardWindow cardWindow = new CardWindow(gameController.getHumanPlayer(), "intrics");
                    if (cardWindow.hasCardToShow()) {
                        cardWindow.setVisible(true);
                        openedWindowsSet.add(cardWindow);
                    } else {
                        JOptionPane.showMessageDialog(this, LanguageStrings.getString("JOptionPane.NoIntricCards"), LanguageStrings.getString("JOptionPane.InformationTitle"), JOptionPane.INFORMATION_MESSAGE);
                    }
                })
        );
        panelForButtons.add(intricCardsButton);
        finishedRoundButton = new JButton(LanguageStrings.getString("GameBoard.EndRound"));
        finishedRoundButton.setBackground(new Color(255, 30, 21));
        finishedRoundButton.addActionListener((ActionEvent evt) -> gameController.nextPlayerIsComing());
        finishedRoundButton.setEnabled(false);
        diceButton.addActionListener((ActionEvent evt) -> gameController.rollDice());
        specialAbilityButton = new JButton(LanguageStrings.getString("GameBoard.MySpecialAbility"));
        specialAbilityButton.setBackground(new Color(255, 30, 21));
        specialAbilityButton.addActionListener((ActionEvent evt) -> {
            Object[] options;
            if (gameController.getHumanPlayer().isAbleToUseSpecialAbility()) {
                options = new Object[2];
                options[0] = "Ok";
                options[1] = LanguageStrings.getString("Actions.Use");
            } else {
                options = new Object[1];
                options[0] = "Ok";
            }
            Player actualPlayer = gameController.getActualPlayer();
            int chosenOption = RoleChooserWindow.jbRoleActionPerfromed(getClass(), actualPlayer.getRole().getRoleTypeInString(), options);
            if (options.length == 2 && chosenOption == 1) {
                gameController.playerUsesSpecialAbility(gameController.getHumanPlayer());
            }

        });
        panelForButtons.add(specialAbilityButton);
        panelForButtons.add(finishedRoundButton);
        JPanel dummyPanel = new JPanel();
        dummyPanel.setPreferredSize(new Dimension(10, 10));
        dummyPanel.setBackground(new Color(180, 0, 0));
        panelForButtons.add(dummyPanel);
        panelForButtons.add(diceButton);
        panelForButtons.setBackground(new Color(180, 0, 0));
        panelForGameBoard.add(panelForButtons, SOUTH);
        jlClockInformations = new JLabel(LanguageStrings.getString(GAMEBOARD_DRAWNCLOCK_CONST) + gameController.getDrawnNumberOfClockCards());
        tabbedPane.addTab(LanguageStrings.getString("GameBoard.Board"), panelForGameBoard);
        panelForCluePaper = new JPanel(new BorderLayout());
        dummyPanel = new JPanel();
        dummyPanel.setPreferredSize(new Dimension(300, 400));
        dummyPanel.setBackground(new Color(180, 0, 0));
        panelForCluePaper.add(dummyPanel, SOUTH);
        dummyPanel = new JPanel();
        dummyPanel.setPreferredSize(new Dimension(500, 400));
        dummyPanel.setBackground(new Color(180, 0, 0));
        panelForCluePaper.add(dummyPanel, WEST);
        dummyPanel = new JPanel();
        dummyPanel.setPreferredSize(new Dimension(500, 400));
        dummyPanel.setBackground(new Color(180, 0, 0));
        panelForCluePaper.add(dummyPanel, EAST);
        panelForCluePaper.add(cluePaperPanel, BorderLayout.CENTER);
        tabbedPane.addTab(LanguageStrings.getString(GAMEBOARD_CLUEPAPER_CONST), panelForCluePaper);
        jpBase.add(jlClockInformations, NORTH);
        jpBase.add(tabbedPane, BorderLayout.CENTER);
        jpBase.setBackground(new Color(180, 0, 0));
        Container cp = getContentPane();
        cp.add(jpBase);

        registerGameBoardListener();
    }

    @Override
    public void removeAiSuspectCardWindow() {
        aiSuspectCardWindow = null;
    }

    @Override
    public void showSuspectCardsView(Card murder, Card murderWeapon, Card murderRoom, Player playerWhoProves) {
        SwingUtilities.invokeLater(() -> {
            aiSuspectCardWindow = new AiSuspectCardWindow(playerWhoProves, gameController, murder, murderWeapon, murderRoom);
            aiSuspectCardWindow.setVisible(true);
            openedWindowsSet.add(aiSuspectCardWindow);
        });
    }

    @Override
    public void enableFieldButtons(boolean enabled) {
        List<List<Field>> fieldMap = gameController.getFieldMap();
        for (int i = 0; i < buttonedMap.size(); ++i) {
            List<PositionedButton> row = buttonedMap.get(i);
            for (int j = 0; j < row.size(); ++j) {

                Field field = fieldMap.get(i).get(j);
                PositionedButton button = buttonedMap.get(i).get(j);
                if (enabled) {
                    button.setEnabled(button.getIsEnabledToClickOn() || gameController.getListOfPlayersOnPosition(field.getX(), field.getY()).isEmpty());
                    recognizeActions = false;
                    recognizeSecretPassageAction = false;
                } else {
                    button.setEnabled(enabled);
                }
            }
        }
    }

    @Override
    public void displayMoveView(List<Point> availablePositions) {
        recognizeActions = true;
        recognizeSecretPassageAction = false;
        List<List<Field>> fieldMap = gameController.getFieldMap();
        for (int i = 0; i < buttonedMap.size(); ++i) {
            List<PositionedButton> row = buttonedMap.get(i);
            for (int j = 0; j < row.size(); ++j) {
                Point actPoint = new Point(i, j);
                Field field = fieldMap.get(i).get(j);
                boolean enabled = true;
                if (field.getType() == FieldType.ROOM || field.getType() == FieldType.SECRET || field.getType() == FieldType.END) {
                    enabled = false;
                }
                buttonedMap.get(i).get(j).setEnabled(enabled && availablePositions.contains(actPoint));
            }
        }
        showInformation(LanguageStrings.getString("Actions.ChooseFieldToMove"));
    }

    private void registerGameBoardListener() {
        this.gameController.registerGameBoardListener(this);
    }

    private PositionedButton createSecretCorridorButton(Room room, int row, int column) {
        gameController.changeTypeOfField(row, column, FieldType.SECRET);
        ImageIcon icon = new ImageIcon(getClass().getResource("/board/secret_corridor.png"));
        ((SecretCorridoredRoom) room).setWasSetSecretEntranceImage(true);
        ((SecretCorridoredRoom) room).setSecretFieldPosition(new Point(row, column));
        PositionedButton button = new PositionedButton(row, column, icon, null, true);
        button.setIcon(icon);
        button.addActionListener((ActionEvent evt) -> secretCorridorButtonActionPerformed());
        return button;
    }

    @Override
    public void showMovement(Point oldPosition, Player player) {
        Point newPosition = player.getPosition();
        PositionedButton button = buttonedMap.get(newPosition.getX()).get(newPosition.getY());
        button.setIcon(player.getRole().getPuppetImage());
        button.setEnabled(true);
        button = buttonedMap.get(oldPosition.getX()).get(oldPosition.getY());
        List<Player> playersOnPosition = gameController.getListOfPlayersOnPosition(button.getRow(), button.getColumn());
        if (playersOnPosition.isEmpty()) {
            if (button.getBasicIconImage() != null) {
                button.setBackground(null);
                button.setIcon(button.getBasicIconImage());
            } else if (button.getBasicBackgroundColor() != null) {
                button.setIcon(null);
                button.setBackground(button.getBasicBackgroundColor());
            }
        } else {
            button.setIcon(playersOnPosition.get(0).getRole().getPuppetImage());
        }
        button.setEnabled(button.getIsEnabledToClickOn());
    }

    @Override
    public void displayComputerView() {
        recognizeActions = false;
        diceButton.setEnabled(true);
        specialAbilityButton.setEnabled(false);
    }

    private void secretCorridorButtonActionPerformed() {
        if (recognizeActions || recognizeSecretPassageAction) {
            int answer = showConfirmation(LanguageStrings.getString(SURE_TO_MOVE_CONST), null);
            if (answer == JOptionPane.YES_OPTION) {
                diceButton.setEnabled(false);
                Room toRoom = gameController.findSecretPassageToRoom(gameController.getActualPlayerIndex());
                answer = showConfirmation(LanguageStrings.getString("JOptionPane.SureToUseSecretCorridor") + System.lineSeparator() + LanguageStrings.getString(toRoom.getName()), null);
                if (answer == JOptionPane.YES_OPTION) {
                    gameController.enterRoom(toRoom, gameController.getActualPlayerIndex(), true);
                }
            }
            if (recognizeSecretPassageAction) {
                recognizeSecretPassageAction = false;
            }
        }
    }

    private PositionedButton createRoomButton(Room room, int row, int column) {
        Color color = room.getColor();
        PositionedButton button = new PositionedButton(row, column, null, color, false);
        button.setBackground(color);
        button.setEnabled(false);
        return button;
    }

    private PositionedButton createIntricButton(int row, int column) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/board/intric_field.png"));
        PositionedButton button = new PositionedButton(row, column, icon, null, true);
        button.setIcon(icon);
        button.addActionListener((ActionEvent evt) -> intricButtonActionPerformed(evt));
        return button;
    }

    private void intricButtonActionPerformed(ActionEvent evt) {
        PositionedButton button = (PositionedButton) evt.getSource();
        Point position = new Point(button.getRow(), button.getColumn());
        if (!position.equals(gameController.getHumanPlayer().getPosition()) && recognizeActions) {
            int answer = showConfirmation(LanguageStrings.getString(SURE_TO_MOVE_CONST), null);
            if (answer == JOptionPane.YES_OPTION) {
                fieldButtonActionPerformed(evt);

            }
        }
    }

    private PositionedButton createEntranceButton(int row, int column) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/board/entrance.png"));
        PositionedButton button = new PositionedButton(row, column, icon, null, true);
        button.setIcon(icon);
        MouseListener mouseListener=new MouseListener(){
            public void mouseClicked(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
            @Override
            public void mousePressed(MouseEvent e){
                if(SwingUtilities.isLeftMouseButton(e)){
                    entranceButtonActionPerformed(e);
                }else if(SwingUtilities.isRightMouseButton(e)){
                    
                    PositionedButton button=(PositionedButton)e.getSource();
                    Room room=gameController.findRoomForPosition(new Point(button.getRow(), button.getColumn()));
                    assert room!=null: "Room cannot be null at this point.";
                    String message=LanguageStrings.getString("JOptionPane.RoomName")+LanguageStrings.getString(room.getName());
                    if(room.getClass()==EndRoom.class){
                        message+=System.lineSeparator()+LanguageStrings.getString("JOptionPane.RemainingCards")+((EndRoom)room).getRemainingSuspectCardsNum();
                    }
                    showInformation(message);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            } 
        };
        button.addMouseListener(mouseListener);
        return button;
    }

    private void entranceButtonActionPerformed(MouseEvent evt) {
        if (recognizeActions) {
            
            int answer = showConfirmation(LanguageStrings.getString(SURE_TO_MOVE_CONST), null);
            if (answer == JOptionPane.YES_OPTION) {
                PositionedButton button = (PositionedButton) evt.getSource();
                Room room = gameController.searchForRoomAccordingToFieldPosition(button.getRow(), button.getColumn());
                gameController.enterRoom(room, gameController.getActualPlayerIndex(), false);
            }
        }
    }

    private PositionedButton createStartButton(int row, int column, StartField field) {
        Role standsHere = gameController.findPuppetWhoHasThisStartField(row, column);
        ImageIcon icon = null;
        Color color = findColorAccordingToRole(field.getBelongsTo());
        PositionedButton button = new PositionedButton(row, column, null, color, true);
        if (standsHere != null) {
            icon = standsHere.getPuppetImage();
        }
        button.setBackground(color);
        button.setIcon(icon);
        button.addActionListener((ActionEvent evt) -> fieldButtonActionPerformed(evt));
        return button;
    }

    private void fieldButtonActionPerformed(ActionEvent evt) {
        if (recognizeActions) {
            PositionedButton button = (PositionedButton) evt.getSource();
            List<List<Field>> fieldMap = gameController.getFieldMap();
            Field field = fieldMap.get(button.getRow()).get(button.getColumn());
            int answer = JOptionPane.YES_OPTION;
            if (field.getType() != FieldType.INTRIC && field.getType() != FieldType.START) {
                answer = showConfirmation(LanguageStrings.getString(SURE_TO_MOVE_CONST), null);
            }

            if (answer == JOptionPane.YES_OPTION) {

                Point position = new Point(button.getRow(), button.getColumn());
                if (!position.equals(gameController.getHumanPlayer().getPosition())) {
                    gameController.moveToField(button.getRow(), button.getColumn(), gameController.getActualPlayerIndex());
                }
            }
        }
    }

    private PositionedButton createFieldButton(int row, int column) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/board/field.png"));
        PositionedButton button = new PositionedButton(row, column, icon, null, true);
        button.setIcon(icon);
        button.addActionListener((ActionEvent evt) -> fieldButtonActionPerformed(evt));
        return button;
    }

    private void processComponents(JPanel jpBoard) {
        List<List<Field>> map = gameController.getFieldMap();
        int maxWidth = map.get(0).size();
        jpBoard.setBackground(new Color(180, 0, 0));
        for (int i = 0; i < map.size(); ++i) {
            List<Field> row = map.get(i);
            buttonedMap.add(new ArrayList<>());
            for (int j = 0; j < row.size(); ++j) {
                List<PositionedButton> buttonRow = buttonedMap.get(i);
                PositionedButton button = null;
                if (row.get(j).getType() == FieldType.ROOM || row.get(j).getType() == FieldType.END) {
                    button = checkRoomClassAndIfHasImageAndCreateSecretCorridor(row, j, i);
                } else if (row.get(j).getType() == FieldType.INTRIC) {
                    button = createIntricButton(i, j);
                } else if (row.get(j).getType() == FieldType.ENTRANCE) {
                    button = createEntranceButton(i, j);
                } else if (row.get(j).getType() == FieldType.START) {
                    button = createStartButton(i, j, (StartField) row.get(j));

                } else {
                    button = createFieldButton(i, j);

                }
                button.setPreferredSize(new Dimension(53, 53));
                buttonRow.add(button);
                jpBoard.add(button);
            }
            checkIfMaxWidthLesserThanRowSize(maxWidth, row);
        }
        int height = gameController.getMapHeight();
        jpBoard.setSize(maxWidth * 53, height * 53);
        jpBoard.setPreferredSize(new Dimension(maxWidth * 53, height * 53));
        jpBoard.setMaximumSize(new Dimension(maxWidth * 53, height * 53));
    }

    private int checkIfMaxWidthLesserThanRowSize(int maxWidth, List<Field> row) {
        if (maxWidth < row.size()) {
            maxWidth = row.size();
        }
        return maxWidth;
    }

    @Override
    public void enableRollDiceButton(boolean enabled) {
        diceButton.setEnabled(enabled);
    }

    private void enableSpecialAbilityButtonIfItIsAvailable() {
        boolean enabled;
        if (gameController.getActualGamePhase() != GamePhase.INITIAL) {
            enabled = gameController.getHumanPlayer().getRole().getAbilityIsAvailable();
        } else {
            enabled = false;
        }
        specialAbilityButton.setEnabled(enabled);
    }

    @Override
    public void displayRollView(boolean isInSecretRoom) {
        enableSpecialAbilityButtonIfItIsAvailable();
        finishedRoundButton.setEnabled(false);
        recognizeActions = false;
        recognizeSecretPassageAction = isInSecretRoom;
        diceButton.setEnabled(true);
    }

    @Override
    public void showProofCardView(Card proofCard, Player playerWhoShowed) {
        Object[] options = {"Ok"};
        StringBuilder message = new StringBuilder();
        URL imageUrl = null;
        if (proofCard != null) {
            message.append(playerWhoShowed.toString()).append(LanguageStrings.getString("Suspect.ShownEvidenceCard")).append(System.lineSeparator()).append(proofCard.getNameForUI());
            imageUrl = getClass().getResource(proofCard.getImageName());
        } else {
            message.append(LanguageStrings.getString("Suspect.NobodyCouldShow"));
        }

        showOptionDialogWithImage(message.toString(), LanguageStrings.getString("Suspect.ShownEvidenceCard"), options, imageUrl, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
        resetCluePaperView();
    }

    private void resetCluePaperView() {
        panelForCluePaper = new JPanel(new BorderLayout());
        JPanel dummyPanel = new JPanel();
        dummyPanel.setPreferredSize(new Dimension(300, 400));
        dummyPanel.setBackground(new Color(180, 0, 0));
        panelForCluePaper.add(dummyPanel, SOUTH);
        dummyPanel = new JPanel();
        dummyPanel.setPreferredSize(new Dimension(500, 400));
        dummyPanel.setBackground(new Color(180, 0, 0));
        panelForCluePaper.add(dummyPanel, WEST);
        dummyPanel = new JPanel();
        dummyPanel.setPreferredSize(new Dimension(500, 400));
        dummyPanel.setBackground(new Color(180, 0, 0));
        panelForCluePaper.add(dummyPanel, EAST);
        cluePaperPanel.enableCheckBoxes(true, gameController.getActualPlayer());
        panelForCluePaper.add(cluePaperPanel, BorderLayout.CENTER);
        tabbedPane.removeTabAt(1);
        tabbedPane.addTab(LanguageStrings.getString(GAMEBOARD_CLUEPAPER_CONST), panelForCluePaper);
        jpBase.add(tabbedPane, BorderLayout.CENTER);
        jpBase.setBackground(new Color(180, 0, 0));
        Container cp = getContentPane();
        cp.add(jpBase);
        finishedRoundButton.setEnabled(true);
        suspectPaperPanel = null;
        showInformation(LanguageStrings.getString("Suspect.MarkInfos"));
    }

    @Override
    public void showSuspectView() {
        suspectPaperPanel = new SuspectPaperPanel(gameController);
        jlToDo = new JLabel();
        jlToDo.setFont(new java.awt.Font(FONT_TYPE, 1, 16));
        jlToDo.setText(LanguageStrings.getString("Actions.ChooseSuspects"));
        jlToDo.setBackground(new Color(180, 0, 0));
        panelForCluePaper = new JPanel(new BorderLayout());
        panelForCluePaper.setBackground(new Color(180, 0, 0));
        panelForCluePaper.add(cluePaperPanel, SOUTH);
        JPanel dummyPanel = new JPanel();
        dummyPanel.setPreferredSize(new Dimension(500, 400));
        dummyPanel.setBackground(new Color(180, 0, 0));
        panelForCluePaper.add(dummyPanel, WEST);
        dummyPanel = new JPanel();
        dummyPanel.setPreferredSize(new Dimension(400, 400));
        dummyPanel.setBackground(new Color(180, 0, 0));
        panelForCluePaper.add(dummyPanel, EAST);
        panelForCluePaper.add(jlToDo, NORTH);
        panelForCluePaper.add(suspectPaperPanel, BorderLayout.CENTER);
        tabbedPane.removeTabAt(1);
        tabbedPane.addTab(LanguageStrings.getString(GAMEBOARD_CLUEPAPER_CONST), panelForCluePaper);
        tabbedPane.setBackground(new Color(180, 0, 0));
        jpBase.add(tabbedPane, BorderLayout.CENTER);
        jpBase.setBackground(new Color(180, 0, 0));
        Container cp = getContentPane();
        cp.add(jpBase);
        showInformation(LanguageStrings.getString("Suspect.ChooseClueTab"));
    }

    @Override
    public void showDrawnIntricCardInfo(Intrics intricCard) {
        Object[] options = {"Ok"};
        URL url = getClass().getResource("/cards/intrics/basic_intric.png");
        String text = intricCard.toString();
        if (intricCard.getType() == IntricsType.CLOCK) {
            url = getClass().getResource("/cards/intrics/card_intric.png");
            text = "";
        }
        showOptionDialogWithImage(text, LanguageStrings.getString("JOptionPane.DrawnIntricCard"), options, url, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    private PositionedButton checkRoomClassAndIfHasImageAndCreateSecretCorridor(List<Field> row, int j, int i) {
        PositionedButton button;
        Room room = gameController.getRoomForName(checkRoomTypeAndGetRoomKey(row, j));
        if (room.getClass() == SecretCorridoredRoom.class && !((SecretCorridoredRoom) room).getWasSetSecretEntranceImage()) {
            button = createSecretCorridorButton(room, i, j);
        } else {
            button = createRoomButton(room, i, j);

        }
        return button;
    }

    private String checkRoomTypeAndGetRoomKey(List<Field> row, int j) {
        String roomKey;
        if (row.get(j).getType() == FieldType.ROOM) {
            roomKey = ((RoomField) row.get(j)).getRoomName();
        } else {
            roomKey = RoomFactory.ENDROOM_KEY;
        }
        return roomKey;

    }

    private Color findColorAccordingToRole(String roleInString) {
        Color color;
        switch (roleInString) {
            case "Mustard":
                color = new Color(255, 94, 0);
                break;
            case "Scarlet":
                color = new Color(255, 0, 0);
                break;
            case "Peacock":
                color = new Color(0, 0, 255);
                break;
            case "Green":
                color = new Color(0, 255, 0);
                break;
            case "Plum":
                color = new Color(148, 44, 124);
                break;
            default:
                color = new Color(255, 255, 255);
        }
        return color;
    }

    @Override
    public void showWhatToDo(String message) {
        JOptionPane.showMessageDialog(this, message, LanguageStrings.getString("JOptionPane.ToDo"), JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showAllSuspectCardInformations(Player player) {
        StringBuilder sb = new StringBuilder();
        List<Card> suspectCards = player.getSuspectCards();
        for (Card c : suspectCards) {
            sb.append(c.getNameForUI()).append(System.lineSeparator());
        }
        cluePaperPanel.markOwnedSuspectCards(player.getSuspectCards());
        Object[] options = {"Ok"};
        JOptionPane.showOptionDialog(this, sb.toString(), LanguageStrings.getString("JOptionPane.SuspectCardTitle"), JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }

    @Override
    public void refreshNumberOfDrawnClockCards() {
        jlClockInformations.setText(LanguageStrings.getString(GAMEBOARD_DRAWNCLOCK_CONST) + gameController.getDrawnNumberOfClockCards());
    }

    @Override
    protected void resetStringsOnWindow() {
        super.resetStringsOnWindow();
        cluePaperPanel.resetStrings();
        if (aiSuspectCardWindow != null) {
            aiSuspectCardWindow.resetStrings();
        }
        if (jlToDo != null) {
            jlToDo.setText(LanguageStrings.getString("Actions.ChooseSuspects"));
        }
        if (suspectPaperPanel != null) {
            suspectPaperPanel.resetStrings();
        }
        jlClockInformations.setText(LanguageStrings.getString(GAMEBOARD_DRAWNCLOCK_CONST) + gameController.getDrawnNumberOfClockCards());
        tabbedPane.setTitleAt(0, LanguageStrings.getString("GameBoard.Board"));
        tabbedPane.setTitleAt(1, LanguageStrings.getString(GAMEBOARD_CLUEPAPER_CONST));
        suspectCardsButton.setText(LanguageStrings.getString("GameBoard.MySuspectCards"));
        intricCardsButton.setText(LanguageStrings.getString("GameBoard.MyIntricCards"));
        finishedRoundButton.setText(LanguageStrings.getString("GameBoard.EndRound"));
        specialAbilityButton.setText(LanguageStrings.getString("GameBoard.MySpecialAbility"));
    }

    @Override
    public void showInformation(String message) {
        Object[] options = {"Ok"};
        JOptionPane.showOptionDialog(this, message, LanguageStrings.getString("JOptionPane.InformationTitle"), JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }
}
