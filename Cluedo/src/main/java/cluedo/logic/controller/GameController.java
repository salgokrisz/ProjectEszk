package cluedo.logic.controller;

import cluedo.logic.cards.Card;
import cluedo.logic.parsers.CardParser;
import cluedo.logic.factories.PlayerFactory;
import cluedo.logic.factories.RoomFactory;
import cluedo.logic.fields.EntranceField;
import cluedo.logic.fields.Field;
import cluedo.logic.fields.FieldType;
import cluedo.logic.intrics.Intrics;
import cluedo.logic.intrics.IntricsType;
import cluedo.logic.parsers.IntricsParser;
import cluedo.logic.map.GameMap;
import cluedo.logic.player.Ai;
import cluedo.logic.player.Player;
import cluedo.logic.player.role.Role;
import cluedo.logic.room.EndRoom;
import cluedo.logic.room.Point;
import cluedo.logic.room.Room;
import cluedo.logic.room.SecretCorridoredRoom;
import cluedo.tools.Tools;
import cluedo.tools.languagestring.LanguageStrings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * This class is responsible for controlling the game.
 */
public class GameController {

    private int humanPlayerIndex;
    private int numberOfPlayers;
    private int numberOfComputerPlayers;
    private List<Player> players;
    private GameBoardListener gameBoardListener;
    private GamePhase actualGamePhase;
    Map<Player, Integer> droppedNumbersForDecidingStart = new HashMap<>();
    private List<Intrics> intricCards = new LinkedList<>();
    private final GameMap map;
    private final List<List<Field>> fieldMap;
    private final Map<String, Room> roomMap;//commented out because pmd
    private int actualPlayerIndex;
    private List<Card> allMurderCards = new ArrayList<>();
    private List<Card> allMurderWeaponCards = new ArrayList<>();
    private List<Card> allMurderRoomCards = new ArrayList<>();
    private static final String OPTION_PANE_DROPPED_NUMBER_CONST = "JOptionPane.DroppedNumber";
    private int playerNumberWhoTriedToShowInThisRound;
    private static int drawnNumberOfClockCards;
    private Player playerWhoHasToProve; 
    private Card showedCard;

    public GameController() {
        actualGamePhase = GamePhase.INITIAL;
        map = new GameMap("/maps/basicmap.txt");
        fieldMap = map.getMap();
        RoomFactory rf = new RoomFactory(map.getMap());//commented out because pmd
        roomMap = rf.generateRooms();//commented out because pmd
        actualPlayerIndex = 0;
        playerNumberWhoTriedToShowInThisRound=0;
        drawnNumberOfClockCards=0;
    }

    
    public Player getPlayerWhoHasToProve() {
        return playerWhoHasToProve;
    }

    public Card getShowedCard() {
        return showedCard;
    }

    public void setShowedCard(Card showedCard) {
        this.showedCard = showedCard;
    }

    
    
    public List<Player> getPlayers() {
        return players;
    }

    
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getMapHeight() {
        return map.getRows();
    }

    public List<List<Field>> getFieldMap() {
        return map.getMap();
    }

    public Map<String, Room> getRoomMap() {
        Map<String, Room> copy = new HashMap<>();
        Set<String> keys = roomMap.keySet();
        for (String k : keys) {
            copy.put(k, (Room) roomMap.get(k).cloneObject());
        }
        return copy;
    }

    public Room getRoomForName(String roomName) {
        return roomMap.get(roomName);
    }

    public int getNumberOfComputerPlayers() {
        return numberOfComputerPlayers;
    }

    public void setNumberOfComputerPlayers(int numberOfComputerPlayers) {
        this.numberOfComputerPlayers = numberOfComputerPlayers;
    }

    public void registerGameBoardListener(GameBoardListener gameBoardListener) {
        this.gameBoardListener = gameBoardListener;
    }

    private int findHumanPlayer() {
        int i = 0;
        while (i < players.size() && players.get(i).getIsComputer()) {
            i += 1;
        }
        return i;
    }

    public void initializePlayers(List<String> playerInformations) {
        PlayerFactory pf = new PlayerFactory();
        players = pf.createPlayers (playerInformations, map.getMap());
        for (Player p : players) {
            Point startFieldLocation = p.getStartFieldLocation();
            fieldMap.get(startFieldLocation.getX()).get(startFieldLocation.getY()).modifyPlayerNumber(1, numberOfPlayers);
        }
        humanPlayerIndex = findHumanPlayer();
    }

    public List<Player> getListOfPlayersOnPosition(int x, int y) {
        Point positionToFind = new Point(x, y);
        List<Player> playersOnPosition = new ArrayList<>();
        for (Player p : players) {
            if (p.getPosition().equals(positionToFind)) {
                playersOnPosition.add(p);
            }
        }
        return playersOnPosition;
    }

    public void setActualGamePhase(GamePhase actualGamePhase) {
        this.actualGamePhase = actualGamePhase;
    }

    public List<Player> rollDicesForDecidingStarterPlayer(List<Player> playerList, int humanPlayerRoll) {

        for (int i = 0; i < playerList.size(); ++i) {
            int roll = humanPlayerRoll;
            if (playerList.get(i).getIsComputer()) {
                roll = Tools.randomizeNumber(6) + 1;
            }
            droppedNumbersForDecidingStart.put(playerList.get(i), roll);
        }
        int maximumIndex = chooseMaximumNumber(droppedNumbersForDecidingStart);
        return findPlayersWithMaxNumber(maximumIndex, droppedNumbersForDecidingStart);
    }

    public void sortPlayers(int humanPlayerRoll) {
        List<Player> playersWithMaxNumber = players;
        boolean diceButtonShouldBePressed = false;
        do {
            if (diceButtonShouldBePressed) {
                fireShowWhatToDo(LanguageStrings.getString("Actions.RollDiceStartAgain"));
                humanPlayerRoll = Tools.randomizeNumber(6) + 1;
                fireShowInformation(LanguageStrings.getString(OPTION_PANE_DROPPED_NUMBER_CONST) + humanPlayerRoll);
            }
            playersWithMaxNumber = rollDicesForDecidingStarterPlayer(playersWithMaxNumber, humanPlayerRoll);
            diceButtonShouldBePressed = playersWithMaxNumber.size() > 1 && playersWithMaxNumber.contains(players.get(humanPlayerIndex));
        } while (playersWithMaxNumber.size() > 1);
        Player starterPlayer = playersWithMaxNumber.get(0);
        int starterIndex = findPlayerIndex(starterPlayer);
        assert starterIndex >= 0 && starterIndex < players.size() : "Players must contain starter player.";
        Map<Integer, Player> serialNumbers = determinateSerialNumbers(starterIndex);
        players.clear();
        Set<Integer> keys = serialNumbers.keySet();
        for (Integer k : keys) {
            players.add(serialNumbers.get(k));
        }
        humanPlayerIndex = findHumanPlayer();
        actualPlayerIndex = 0;
        StringBuilder message = new StringBuilder(LanguageStrings.getString("JOptionPane.InformationAboutStarterPlayer"));
        if (humanPlayerIndex == actualPlayerIndex) {
            message.append(LanguageStrings.getString("JOptionPane.You"));
        } else {
            message.append(players.get(0).toString());
        }
        fireShowInformation(message.toString());
        actualGamePhase = GamePhase.ROLLORUSESECRETCORRIDOR;
        Player actualPlayer = getActualPlayer();
        if (!actualPlayer.getIsComputer()) {
            fireDisplayRollView(actualPlayer.getIsInRoom() && roomMap.get(actualPlayer.getActualRoomName()).getClass() == SecretCorridoredRoom.class);
        } else {
            fireDisplayComputerView();
            controlComputerPlayer();
        }
    }

    private void computerPlayerUsesSecretCorridor(Ai actualComputerPlayer) {
        actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.AiUsedSecretPassage"));
        actualComputerPlayer.appendToInformation(LanguageStrings.getString(((SecretCorridoredRoom) roomMap.get(actualComputerPlayer.getActualRoomName())).getToRoomName()));
        actualComputerPlayer.appendToInformation(System.lineSeparator());
        SecretCorridoredRoom actualRoom=(SecretCorridoredRoom)roomMap.get(actualComputerPlayer.getActualRoomName());
        enterRoom(roomMap.get(actualRoom.getToRoomName()), actualPlayerIndex, true);
    }

    private void computerPlayerEntersRoom(Ai actualComputerPlayer, Point destination) {
        actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.AiEnteredRoom"));
        Room room = searchForRoomAccordingToFieldPosition(destination.getX(), destination.getY());
        enterRoom(room, actualPlayerIndex, false);
        actualComputerPlayer.appendToInformation(LanguageStrings.getString(actualComputerPlayer.getActualRoomName()));
        actualComputerPlayer.appendToInformation(System.lineSeparator());
    }

    private void computerPlayerMovesToFieldOrIntricField(Ai actualComputerPlayer, Point destination, Field field) {
        moveToField(destination.getX(), destination.getY(), actualPlayerIndex);
        actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.AiMoved"));
        actualComputerPlayer.appendToInformation(Integer.toString(destination.getX() + 1));
        actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.SerialMark"));
        actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.Row"));
        actualComputerPlayer.appendToInformation(", ");
        actualComputerPlayer.appendToInformation(Integer.toString(destination.getY() + 1));
        actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.SerialMark"));
        actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.Column"));
        actualComputerPlayer.appendToInformation(System.lineSeparator());
        if (field.getType() == FieldType.INTRIC) {
            actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.AiDrawnIntricCard"));
            actualComputerPlayer.appendToInformation(System.lineSeparator());
        }
    }

    private void appendStarterInformationsAboutComputerPlayerRound(Ai actualComputerPlayer) {
        actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.InformationsAboutAi"));
        actualComputerPlayer.appendToInformation(actualComputerPlayer.toString());
        actualComputerPlayer.appendToInformation(System.lineSeparator());
    }

    private void controlComputerPlayer() {
        Ai actualComputerPlayer = (Ai) players.get(actualPlayerIndex);
        appendStarterInformationsAboutComputerPlayerRound(actualComputerPlayer);
        if (actualGamePhase == GamePhase.ROLLORUSESECRETCORRIDOR) {
            if (actualComputerPlayer.getIsInRoom() && roomMap.get(actualComputerPlayer.getActualRoomName()).getClass() == SecretCorridoredRoom.class && actualComputerPlayer.wantsToUseSecretCorridorFromRoom((SecretCorridoredRoom)roomMap.get(actualComputerPlayer.getActualRoomName()))) {
                computerPlayerUsesSecretCorridor(actualComputerPlayer);
            } else {
                int droppedNumber = rollDice();
                StringBuilder sb = new StringBuilder(LanguageStrings.getString(OPTION_PANE_DROPPED_NUMBER_CONST));
                sb.append(droppedNumber).append(System.lineSeparator());
                actualComputerPlayer.appendToInformation(sb.toString());
                actualGamePhase = GamePhase.MOVE;
                List<Point> availablePositionsToMove = ((Ai) players.get(actualPlayerIndex)).getAvailablePositionsToMove();
                
               Point destination= findAvailablePositionToMove(availablePositionsToMove,actualComputerPlayer);
               Field field=fieldMap.get(destination.getX()).get(destination.getY());
                checkFieldTypeAndCallRightMethod(field,actualComputerPlayer,destination);
            }
            if (players.get(actualPlayerIndex).getIsInRoom()) {
                computerPlayerSuspects(actualComputerPlayer);
            } else {
                nextPlayerIsComing();
            }
        }
    }
    
    private Point findAvailablePositionToMove(List<Point> availablePositionsToMove,Ai actualComputerPlayer) {
        Field field=null;
        Point destination=null;
        do {
            destination = availablePositionsToMove.get(Tools.randomizeNumber(availablePositionsToMove.size()));
            field = fieldMap.get(destination.getX()).get(destination.getY());
        } while (actualComputerPlayer.getPosition().equals(new Point(field.getX(), field.getY())) || field.getType() == FieldType.ROOM || field.getType() == FieldType.END || field.getType() == FieldType.SECRET);
        return destination;
    }
    
    private void checkFieldTypeAndCallRightMethod(Field field,Ai actualComputerPlayer,Point destination) {
        if (field.getType() == FieldType.ENTRANCE) {
            computerPlayerEntersRoom(actualComputerPlayer, destination);
        } else {
            computerPlayerMovesToFieldOrIntricField(actualComputerPlayer, destination, field);
        }
    }

    private Card computerPlayerDeterminesSuspectCardToShow(Ai playerWhoHasToProve, Card murder, Card murderWeapon, Card murderRoom) {
        List<Card> ownedSuspectCardsFromSuspectations = playerWhoHasToProve.determineOwnedSuspectCardsFromSuspects(murder, murderWeapon, murderRoom);
        Card cardToShow = null;
        if (!ownedSuspectCardsFromSuspectations.isEmpty()) {
            //todo this randomize is not ok for expert ai
            cardToShow = ownedSuspectCardsFromSuspectations.get(Tools.randomizeNumber(ownedSuspectCardsFromSuspectations.size()));
        }
        return cardToShow;
    }
    private void computerPlayerWaitsForProof(Player playerWhoHasToProve){
        Player actualPlayer=getActualPlayer();
        if (!playerWhoHasToProve.getIsComputer()) {
            fireShowInformationsAboutSuspectedCards(actualPlayer.getSuspectedMurderInActualRound(), actualPlayer.getSuspectedMurderWeaponInActualRound(), actualPlayer.getSuspectedMurderRoomInActualRound(), playerWhoHasToProve);
        } else {
            Card cardToShow = computerPlayerDeterminesSuspectCardToShow((Ai) playerWhoHasToProve,
                                                                        actualPlayer.getSuspectedMurderInActualRound(), 
                                                                        actualPlayer.getSuspectedMurderWeaponInActualRound(),
                                                                        actualPlayer.getSuspectedMurderRoomInActualRound());
       
            showCardForAi(cardToShow, playerWhoHasToProve);
        }
    }
    private void computerPlayerSuspects(Ai actualComputerPlayer) {
        actualGamePhase = GamePhase.SUSPECT;
        actualComputerPlayer.selectSuspect();
        for (Player p :players) {
            if (p.getIsComputer()) {
                Ai aiPlayer = (Ai)p;
                aiPlayer.addPlayerWhoSuspectedData(actualComputerPlayer); 
                aiPlayer.addSuspectedMurderData(actualComputerPlayer.getSuspectedMurderInActualRound());
                aiPlayer.addSuspectedWeaponData(actualComputerPlayer.getSuspectedMurderWeaponInActualRound());
                aiPlayer.addSuspectedRoomData(actualComputerPlayer.getSuspectedMurderRoomInActualRound());
            }
        }
        Player playerWhoHasToProve = determinePlayerWhoHasToProve(actualPlayerIndex);
        computerPlayerWaitsForProof(playerWhoHasToProve);
       
    }

    private Player determinePlayerWhoHasToProve(int playerIndex) {
        int righterIndex = 0;
        if (playerIndex != numberOfPlayers - 1) {
            righterIndex += 1;
        }
        playerWhoHasToProve = players.get(righterIndex);
        return players.get(righterIndex);
    }

    private void fireShowInformationsAboutSuspectedCards(Card murder, Card murderWeapon, Card murderRoom, Player playerWhoProves) {
        Player actualPlayer=getActualPlayer();
        if(actualPlayer.getIsComputer()){
            Ai actualComputerPlayer = (Ai) players.get(actualPlayerIndex);
            actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.AiSuspectsCards"));
            actualComputerPlayer.appendToInformation(System.lineSeparator());
            actualComputerPlayer.appendToInformation(murder.getNameForUI());
            actualComputerPlayer.appendToInformation(System.lineSeparator());
            actualComputerPlayer.appendToInformation(murderWeapon.getNameForUI());
            actualComputerPlayer.appendToInformation(System.lineSeparator());
            actualComputerPlayer.appendToInformation(murderRoom.getNameForUI());
            actualComputerPlayer.appendToInformation(System.lineSeparator());
        }
        fireShowSuspectedCardsView(murder, murderWeapon, murderRoom, playerWhoProves);
    }

    private void fireShowSuspectedCardsView(Card murder, Card murderWeapon, Card murderRoom, Player playerWhoProves) {
        gameBoardListener.showSuspectCardsView(murder, murderWeapon, murderRoom, playerWhoProves);
    }

    private void fireShowInformationsAboutComputerPlayer() {
        Ai actualComputerPlayer = (Ai) players.get(actualPlayerIndex);
        gameBoardListener.showInformation(actualComputerPlayer.getInformationsAboutMovement());
        actualComputerPlayer.resetInformationsAboutMovement();
        if (actualComputerPlayer.getSuspectedInThisRound()) {
           actualComputerPlayer.setSuspectedCardsToNull();
        }
    }

    public void nextPlayerIsComing() {
        
        if (getActualPlayer().getIsComputer()) {
            fireShowInformationsAboutComputerPlayer();
        }
        getActualPlayer().setSuspectedInThisRound(false);
        if(actualGamePhase!=GamePhase.ROLLORUSESECRETCORRIDOR){
                   actualGamePhase = GamePhase.ROLLORUSESECRETCORRIDOR;
                   changeActualPlayerIndex();
                   fireShowNextPlayerMessage();
        }
        Player actualPlayer = getActualPlayer();
        if (!actualPlayer.getIsComputer()) {
            fireDisplayRollView(actualPlayer.getIsInRoom() && roomMap.get(actualPlayer.getActualRoomName()).getClass() == SecretCorridoredRoom.class);
        } else {
            fireDisplayComputerView();
            controlComputerPlayer();
        }

    }

    private void fireDisplayRollView(boolean secretCorridoreIsAvailable) {
        playerNumberWhoTriedToShowInThisRound=0;
        gameBoardListener.displayRollView(secretCorridoreIsAvailable);
        if (actualGamePhase != GamePhase.INITIAL) {
            String message = LanguageStrings.getString("Actions.RollDice");
            if (secretCorridoreIsAvailable) {
                message = LanguageStrings.getString("Actions.RollDiceOrUseSecretPassage");
            }
            fireShowWhatToDo(message);
        }
    }

    public Map<Integer, Player> determinateSerialNumbers(int starterIndex) {
        Map<Integer, Player> serialNumbers = new TreeMap<>();
        serialNumbers.put(0, players.get(starterIndex));
        int placeCounter = 1;
        int i;
        boolean increase = false;
        if (starterIndex == 0) {
            i = players.size() - 1;
        } else if (starterIndex == players.size() - 1) {
            increase = true;
            i = 0;
        } else {
            i = starterIndex - 1;
        }
        while (placeCounter != players.size()) {
            serialNumbers.put(placeCounter, players.get(i));
            if (increase) {
                i += 1;
                if (i == players.size() - 1) {
                    increase = false;
                }
            } else {
                i -= 1;
                if (i == 0) {
                    increase = true;
                }
            }
            placeCounter += 1;
        }
        return serialNumbers;
    }

    public int findPlayerIndex(Player player) {
        int i = 0;
        while (i < players.size() && !players.get(i).equals(player)) {
            i += 1;
        }
        return i;
    }

    public List<Player> findPlayersWithMaxNumber(int maximumIndex, Map<Player, Integer> droppedNumbers) {
        Set<Player> keys = droppedNumbers.keySet();
        List<Player> playersWithSameNumber = new ArrayList<>();
        for (Player k : keys) {
            if (droppedNumbers.get(k) == maximumIndex) {
                playersWithSameNumber.add(k);
            }
        }
        return playersWithSameNumber;
    }

    public boolean isCorrectPlayerName(String playerName) {
        if (playerName == null) {
            return false;
        } else {
            return playerName.matches("^[A-Za-zÖöÜüÓóŐőÚúÁáÉéÍíŰű].*$");
        }
    }

    public int chooseMaximumNumber(Map<Player, Integer> droppedNumbers) {
        Set<Player> keys = droppedNumbers.keySet();
        Iterator<Player> iter = keys.iterator();
        int maximum = droppedNumbers.get(iter.next());
        while (iter.hasNext()) {
            int actualNumber = droppedNumbers.get(iter.next());
            if (actualNumber > maximum) {
                maximum = actualNumber;
            }
        }
        return maximum;
    }

    private Card chooseKillerCard(List<Card> suspectCards) {
        Collections.shuffle(suspectCards);
        return suspectCards.get(0);
    }

    private void setFinalCard(int index, Card killerCard) {
        switch (index) {
            case 0:
                ((EndRoom) roomMap.get(RoomFactory.ENDROOM_KEY)).setMurderer(killerCard);
                break;
            case 1:
                ((EndRoom) roomMap.get(RoomFactory.ENDROOM_KEY)).setMurderWeapon(killerCard);
                break;
            case 2:
                ((EndRoom) roomMap.get(RoomFactory.ENDROOM_KEY)).setMurderRoom(killerCard);
                break;
            default:
                break;
        }
    }

    public void initializeSuspectCards() {
        List<List<Card>> cards = CardParser.parse(getClass().getResourceAsStream("/cards/Cards.json"));
        List<Card> suspectCards = new LinkedList<>();
        for (int i = 0; i < 3; ++i) {
            List<Card> parts = cards.get(i);
            switch (i) {
                case 0:
                    allMurderCards.addAll(parts);
                    break;
                case 1:
                    allMurderWeaponCards.addAll(parts);
                    break;
                case 2:
                    allMurderRoomCards.addAll(parts);
                    break;
                default:
                    break;
            }
            Card killer = chooseKillerCard(parts);
            parts.remove(killer);
            setFinalCard(i, killer);
            fillUpSupsectCardWithCards(parts, suspectCards);
        }
        Collections.shuffle(suspectCards);
        int remainingCardNumber = suspectCards.size() % numberOfPlayers;
        int cardNumberToShare = suspectCards.size() - remainingCardNumber;
        int playerCounter = 0;
        for (int i = 0; i < cardNumberToShare; ++i) {
            players.get(playerCounter).drawSuspectCard(suspectCards.remove(0));
            if (playerCounter == players.size() - 1) {
                playerCounter = 0;
            } else {
                playerCounter += 1;
            }
        }
        ((EndRoom) roomMap.get(RoomFactory.ENDROOM_KEY)).setRemainingSuspectCards(suspectCards);
        fireShowOwnedSuspectCards();
    }

    public void initializeIntricCards() {
        IntricsParser ip = new IntricsParser();
        List<Intrics> intrics = ip.parseFile("cards/intrics/intrics.txt");
        Collections.shuffle(intrics);
        intricCards = intrics;
    }

    private void fireShowOwnedSuspectCards() {

        gameBoardListener.showAllSuspectCardInformations(players.get(humanPlayerIndex));
    }

    private void fireShowWhatToDo(String message) {
        gameBoardListener.showWhatToDo(message);
    }

    public void initializeGame() {
        initializeSuspectCards();
        initializeIntricCards(); //it is commented out becuse of pmd it will be needed later
        fireDisplayRollView(false);
        fireShowWhatToDo(LanguageStrings.getString("Actions.RollDiceStart"));
      
        int remainningCardsNum = ((EndRoom) roomMap.get(RoomFactory.ENDROOM_KEY)).getRemainingSuspectCardsNum();
        for (Player p: players) {
            if (p.getIsComputer()) {
                Ai ai = (Ai)p;
                ai.initializeAiDataManager (players,
                                            allMurderCards, 
                                            allMurderWeaponCards, 
                                            allMurderRoomCards,
                                            remainningCardsNum);
            }
        }
    }

    private void fillUpSupsectCardWithCards(List<Card> cards, List<Card> suspectCards) {
        Collections.shuffle(cards);
        suspectCards.addAll(cards);
    }

    public void fireShowInformation(String message) {
        gameBoardListener.showInformation(message);
    }

    public GamePhase getActualGamePhase() {
        return actualGamePhase;
    }

    public int rollDice() {
        int droppedNumber;
        if (GamePhase.INITIAL == actualGamePhase) {
            droppedNumber = Tools.randomizeNumber(6) + 1;
            fireShowInformation(LanguageStrings.getString(OPTION_PANE_DROPPED_NUMBER_CONST) + droppedNumber);
            sortPlayers(droppedNumber);
        } else {
            fireEnableRollDiceButton(false);
            droppedNumber = Tools.randomizeNumber(6) + 1;
            int roledNumberTwo = Tools.randomizeNumber(6) + 1;
            if (roledNumberTwo == 1) {
                Intrics drawnCard = drawIntricCard();
                if (!players.get(actualPlayerIndex).getIsComputer()) {
                    fireShowInformation(LanguageStrings.getString("Actions.DroppedIntric"));
                    fireShowDrawnIntricCardInfo(drawnCard);
                }
                //intrics
            } else {
                droppedNumber += roledNumberTwo;
            }
            if (!players.get(actualPlayerIndex).getIsComputer()) {
                fireShowInformation(LanguageStrings.getString(OPTION_PANE_DROPPED_NUMBER_CONST) + droppedNumber);
            }
            actualGamePhase = GamePhase.MOVE;
            players.get(actualPlayerIndex).setDroppedNumber(droppedNumber);
            List<Point> availablePositions = chooseAvailableFieldsInARadius(droppedNumber);
            if (!players.get(actualPlayerIndex).getIsComputer()) {
                fireDisplayMoveView(availablePositions);
            } else {
                ((Ai) players.get(actualPlayerIndex)).setAvailablePositionsToMove(availablePositions);
            }
        }
        return droppedNumber;
    }

    public void fireDisplayMoveView(List<Point> availablePositions) {
        gameBoardListener.displayMoveView(availablePositions);
    }

    private void fireShowDrawnIntricCardInfo(Intrics drawnCard) {
        gameBoardListener.showDrawnIntricCardInfo(drawnCard);
    }

    private void fireEnableRollDiceButton(boolean isEnabled) {
        gameBoardListener.enableRollDiceButton(isEnabled);
    }

    public Role findPuppetWhoHasThisStartField(int row, int column) {
        Point position = new Point(row, column);
        int i = 0;
        while (i < players.size() && !players.get(i).getStartFieldLocation().equals(position)) {
            i += 1;
        }
        Role role = null;
        if (i < players.size()) {
            role = players.get(i).getRole();
        }
        return role;
    }

    public Intrics drawIntricCard() {
        Intrics intric = intricCards.remove(0);
        if(intric.getType()!=IntricsType.CLOCK){
        players.get(actualPlayerIndex).addIntricCard(intric);
        }else{
            intric.effect(this);
            
        }
        return intric;
    }
    public void fireRefreshNumberOfDrawnClockCards(){
        gameBoardListener.refreshNumberOfDrawnClockCards();
    }
    public int playerNumberOnField(Field field) {
        int playerNumber = 0;
        Point fieldPosition = new Point(field.getX(), field.getY());
        for (Player p : players) {
            if (p.getPosition().equals(fieldPosition)) {
                playerNumber += 1;
            }
        }
        return playerNumber;
    }

    public boolean isFreeToMoveInRoom(Point newPosition, Room room) {
        Field field = fieldMap.get(newPosition.getX()).get(newPosition.getY());
        if (room.getClass() == SecretCorridoredRoom.class && ((SecretCorridoredRoom) room).getSecretFieldPosition().equals(newPosition)) {
            return false;
        }
        return field.getType() != FieldType.ENTRANCE && playerNumberOnField(field) == 0;
    }

    public Point findFreePositionInRoom(Room room) {
        List<Point> points = room.getCoordinates();
        boolean isGood;
        Point newPosition;
        do {
            int index = Tools.randomizeNumber(points.size());
            newPosition = points.get(index);
            isGood = isFreeToMoveInRoom(newPosition, room);
            if (!isGood) {
                points.remove(index);
            }
        } while (!isGood);
        return newPosition;
    }

    public Room searchForRoomAccordingToFieldPosition(int row, int column) {
        EntranceField entryField = (EntranceField) fieldMap.get(row).get(column);
        return roomMap.get(entryField.getRoomName());

    }

    public Player getHumanPlayer() {
        return players.get(humanPlayerIndex);
    }

    public void enterRoom(Room room, int playerIndex, boolean usedSecretPassage) {
        Point newPosition = findFreePositionInRoom(room);
        if (usedSecretPassage) {
            actualGamePhase = GamePhase.MOVE;
        }
        players.get(playerIndex).setIsInRoom(true);
        players.get(playerIndex).setActualRoomName(room.getName());
        moveToField(newPosition.getX(), newPosition.getY(), playerIndex);

    }

    private void fireShowMovementOfPlayer(Point oldPosition, Player player) {
        gameBoardListener.showMovement(oldPosition, player);
    }

    public int getActualPlayerIndex() {
        return actualPlayerIndex;
    }

    public void moveToField(int x, int y, int playerIndex) {
        Player player = players.get(playerIndex);
        Point oldPosition = player.getPosition();
        fieldMap.get(oldPosition.getX()).get(oldPosition.getY()).modifyPlayerNumber(-1, numberOfPlayers);
        Field field = fieldMap.get(x).get(y);
        field.modifyPlayerNumber(1, numberOfPlayers);
        Point newPosition = new Point(x, y);
        player.setPosition(newPosition);
        if (fieldMap.get(x).get(y).getType() != FieldType.ROOM) {
            player.setIsInRoom(false);
            player.setActualRoomName("");
        }
        fireShowMovementOfPlayer(oldPosition, player);
        Player actualPlayer = players.get(actualPlayerIndex);
        if (field.getType() == FieldType.INTRIC) {
            Intrics intricCard = drawIntricCard();
            if (!actualPlayer.getIsComputer()) {
                fireShowDrawnIntricCardInfo(intricCard);
            }
        }
        fireReEnableFieldButtons();
        if (!actualPlayer.getIsComputer()) {
            if (actualPlayer.getIsInRoom() && !actualPlayer.getSuspectedInThisRound()) {
                actualGamePhase = GamePhase.SUSPECT;
                fireShowSuspectView();
                //TODO wait for turn again intric card
            } else {
                //TODO wait for turn again intric card
                nextPlayerIsComing();
            }
        }
    }

    public Player getActualPlayer() {
        return players.get(actualPlayerIndex);
    }

    private void fireReEnableFieldButtons() {
        gameBoardListener.enableFieldButtons(true);
    }

    private void fireShowSuspectView() {
        gameBoardListener.showSuspectView();
    }

    private void fireDisplayComputerView() {
        gameBoardListener.displayComputerView();
    }

    private void fireShowNextPlayerMessage() {
        StringBuilder message = new StringBuilder(LanguageStrings.getString("JOptionPane.NextPlayer"));

        if (actualPlayerIndex == humanPlayerIndex) {
            message.append(LanguageStrings.getString("JOptionPane.You"));
        } else {
            message.append(players.get(actualPlayerIndex).toString()).append(System.lineSeparator());
        }
        gameBoardListener.showInformation(message.toString());
    }

    public void changeActualPlayerIndex() {
        if (actualPlayerIndex == numberOfPlayers - 1) {
            actualPlayerIndex = 0;
        } else {
            actualPlayerIndex += 1;
        }
    }

    public Room findSecretPassageToRoom(int playerIndex) {
        Room actualRoom = roomMap.get(players.get(playerIndex).getActualRoomName());
        Room toRoom = null;
        if (actualRoom.getClass() == SecretCorridoredRoom.class) {
            toRoom = roomMap.get(((SecretCorridoredRoom) actualRoom).getToRoomName());
        }
        return toRoom;
    }

    public List<Point> chooseAvailableFieldsInARadius(int droppedNumber) {
        Point actualPlayerPosition = players.get(actualPlayerIndex).getPosition();
        List<Point> availablePointsOfFields = new ArrayList<>();
        availablePointsOfFields.add(actualPlayerPosition);
        int actRow = actualPlayerPosition.getX();
        int actColumn = actualPlayerPosition.getY();
        Player actualPlayer = getActualPlayer();
        int differenceCounter = 0;
        boolean reachedOneEndPoint = false;
        for (int i = 0; i <= 2 * droppedNumber; ++i) {
            int rowToConsider;
            if (!reachedOneEndPoint) {
                rowToConsider = actRow - differenceCounter;
            } else {
                rowToConsider = actRow + differenceCounter;
            }            
            int fieldNumberToExamine = droppedNumber - differenceCounter;
            if (rowToConsider >= 0 && rowToConsider < map.getRows()) {
                iterateOverExaminableFields(fieldNumberToExamine,rowToConsider,actColumn,actualPlayer,availablePointsOfFields,actRow);
            }
            if (differenceCounter == droppedNumber) {
                differenceCounter = 0;
                reachedOneEndPoint = true;
            }
            differenceCounter += 1;
        }
        return availablePointsOfFields;
    }
    
    private void iterateOverExaminableFields(int fieldNumberToExamine,int rowToConsider,int actColumn,Player actualPlayer,List<Point> availablePointsOfFields,int actRow) {
        for (int j = 0; j <= fieldNumberToExamine; ++j) {
            int rowSizeInFieldMap = fieldMap.get(rowToConsider).size();
            int leftColumn = actColumn - j;
            int rightColumn = actColumn + j;
            checkIfLeftColumnGreaterNullAndLesserRowSizeInFieldMap(leftColumn,rowToConsider,rowSizeInFieldMap,actualPlayer,availablePointsOfFields,actColumn,actRow,fieldNumberToExamine);
            if (rightColumn >= 0 && rightColumn < rowSizeInFieldMap) {
                Field field = fieldMap.get(rowToConsider).get(rightColumn);
                boolean oneOfTheNeighboursIsRoom = oneOfTheNeighboursIsRoom(field);
                Point actPosition = new Point(field.getX(), field.getY());
                if ((field.getType() == FieldType.ENTRANCE || !fieldIsRoom(field)) && (!oneOfTheNeighboursIsRoom || oneOfTheNeighboursIsRoom && (actualPlayer.getPosition().equals(actPosition) || containsPathAndNoRoomFieldOrItIsAnEntranceField(availablePointsOfFields, field, actColumn, actRow, fieldNumberToExamine)))) {
                    availablePointsOfFields.add(actPosition);
                }
            }
        }
    }
    
    private void checkIfLeftColumnGreaterNullAndLesserRowSizeInFieldMap(int leftColumn,int rowToConsider,int rowSizeInFieldMap,Player actualPlayer,List<Point> availablePointsOfFields,int actColumn,int actRow,int fieldNumberToExamine) {
        if (leftColumn >= 0 && leftColumn < rowSizeInFieldMap) {
            Field field = fieldMap.get(rowToConsider).get(leftColumn);
            boolean oneOfTheNeighboursIsRoom = oneOfTheNeighboursIsRoom(field);
            Point actPosition = new Point(field.getX(), field.getY());
            if (!oneOfTheNeighboursIsRoom || oneOfTheNeighboursIsRoom && (actualPlayer.getPosition().equals(actPosition) || containsPathAndNoRoomFieldOrItIsAnEntranceField(availablePointsOfFields, field, actColumn, actRow, fieldNumberToExamine))) {
                availablePointsOfFields.add(actPosition);
            }
        }
    }

    private boolean willBeSuitableField(int row, int newColumn, int limit) {
        int rows = map.getRows();
        boolean suitable = false;
        if (row >= 0 && row < rows && newColumn >= 0 && newColumn <= limit && newColumn < fieldMap.get(row).size()) {
                Field field = fieldMap.get(row).get(newColumn);
                suitable = field.getType() == FieldType.FIELD || field.getType() == FieldType.INTRIC || field.getType() == FieldType.START;
        }
        return suitable;
    }

    private boolean containsPathAndNoRoomFieldOrItIsAnEntranceField(List<Point> availablePointsOfFields, Field field, int actColumn, int actRow, int fieldNumberToExamine) {
        boolean answer = false;
        if ((availablePointsOfFields.contains(new Point(field.getX(), field.getY() - 1)) || willBeSuitableField(actRow, actColumn + 1, actColumn + fieldNumberToExamine) || willBeSuitableField(actRow, actColumn - 1, actColumn - fieldNumberToExamine)) && goodPosition(field.getX(), field.getY() - 1)) {  
                    Field neighborField = fieldMap.get(field.getX()).get(field.getY() - 1);
                    answer = neighborField.getType() == FieldType.ENTRANCE || !fieldIsRoom(neighborField);            
        }
        if (availablePointsOfFields.contains(new Point(field.getX(), field.getY() + 1)) &&!answer && goodPosition(field.getX(), field.getY() + 1)) {            
                    Field neighborField = fieldMap.get(field.getX()).get(field.getY() + 1);
                    answer = neighborField.getType() == FieldType.ENTRANCE || !fieldIsRoom(neighborField);            
        }
        if (availablePointsOfFields.contains(new Point(field.getX() + 1, field.getY())) && !answer && goodPosition(field.getX() + 1, field.getY())) {          
                    Field neighborField = fieldMap.get(field.getX() + 1).get(field.getY());
                    answer = neighborField.getType() == FieldType.ENTRANCE || !fieldIsRoom(neighborField);            
        }
        if (availablePointsOfFields.contains(new Point(field.getX() - 1, field.getY())) && !answer && goodPosition(field.getX() - 1, field.getY())) {
                    Field neighborField = fieldMap.get(field.getX() - 1).get(field.getY());
                    answer = neighborField.getType() == FieldType.ENTRANCE || !fieldIsRoom(neighborField);         
        }
        return answer;
    }

    private boolean goodPosition(int row, int column) {
        return 0 <= row && row < map.getRows() && column >= 0 && column < fieldMap.get(row).size();
    }

    public boolean fieldIsRoom(Field field) {
        return field.getType() == FieldType.END || field.getType() == FieldType.ENTRANCE || field.getType() == FieldType.ROOM || field.getType() == FieldType.SECRET;
    }

    public boolean oneOfTheNeighboursIsRoom(Field field) {
        int leftColumn = field.getY() - 1;
        int rightColumn = field.getY() + 1;
        int belowRow = field.getX() + 1;
        int upperRow = field.getX() - 1;
        boolean isRoom = false;
        if (goodPosition(field.getX(), leftColumn)) {       
                isRoom = fieldIsRoom(fieldMap.get(field.getX()).get(leftColumn));            
        }
        if (goodPosition(field.getX(), rightColumn) && !isRoom) {    
                isRoom = fieldIsRoom(fieldMap.get(field.getX()).get(rightColumn));            
        }
        if (goodPosition(belowRow, field.getY()) && !isRoom) {          
                isRoom = fieldIsRoom(fieldMap.get(belowRow).get(field.getY()));            
        }
        if (goodPosition(upperRow, field.getY()) && !isRoom) {         
                isRoom = fieldIsRoom(fieldMap.get(upperRow).get(field.getY()));            
        }
        return isRoom;
    }

    public void playerUsesSpecialAbility(Player player) {
        player.getRole().useSpecialAbility();
    }

    public void changeTypeOfField(int row, int column, FieldType fieldType) {
        fieldMap.get(row).get(column).setType(fieldType);
    }

    public void showCardForAi(Card provedCard,Player playerWhoShowed) {
        Ai actualComputerPlayer = (Ai) getActualPlayer();
        if (provedCard != null) {
            for (Player p :players) {
                if (p.getIsComputer() && !((Ai)p).equals(actualComputerPlayer)) {
                    ((Ai)p).addPlayerWhoShowedForOtherPlayerData (playerWhoShowed);
                }
            }
            if(!provedCard.getImageName().equals("....")){
            actualComputerPlayer.addToAlreadyKnownCards(playerWhoShowed, provedCard);
            }
            nextPlayerIsComing();
        } else {
            if(playerNumberWhoTriedToShowInThisRound==numberOfPlayers-1){
                for (Player p :players) {
                    if (p.getIsComputer()) {
                        ((Ai)p).addPlayerWhoTiredToProveData (playerWhoShowed);
                        ((Ai)p).setNobodyProvedData();
                    }
                }
                actualComputerPlayer.setSureAttributesForSolvingTheClue();
                nextPlayerIsComing();
            }else{
                for (Player p :players) {
                    if (p.getIsComputer()) {
                        ((Ai)p).addPlayerWhoTiredToProveData (playerWhoShowed);
                    }
                }
                playerNumberWhoTriedToShowInThisRound+=1;
                int indexOfPreviousPlayer=findPlayerIndex(playerWhoShowed);
                tryToProve(indexOfPreviousPlayer);
            }
        }
        
    }

    public void fireRemoveAiSuspectCardWindow() {
        gameBoardListener.removeAiSuspectCardWindow();
    }
    private void humanPlayerWaitsForProof(Player playerToProve){
        Player actualPlayer=getActualPlayer();
        if(playerToProve.getIsComputer()){
            Card cardToShow = computerPlayerDeterminesSuspectCardToShow((Ai) playerToProve, actualPlayer.getSuspectedMurderInActualRound(), actualPlayer.getSuspectedMurderWeaponInActualRound(), actualPlayer.getSuspectedMurderRoomInActualRound());
            fireDisplayShowProofCardView(cardToShow, playerToProve);
        }else{
            fireShowInformationsAboutSuspectedCards(actualPlayer.getSuspectedMurderInActualRound(), actualPlayer.getSuspectedMurderWeaponInActualRound(), actualPlayer.getSuspectedMurderRoomInActualRound(), playerToProve);
        }
    }
    public void humanPlayerSuspectCards(String selectedGuestKey, String selectedWeaponKey, String selectedRoomKey) {
        Player playerToProve=determinePlayerWhoHasToProve(actualPlayerIndex);
        
        Card murder=getMurderSuspectCardFromAllAccordingToCardKey(selectedGuestKey, allMurderCards);
        Card murderWeapon=getMurderSuspectCardFromAllAccordingToCardKey(LanguageStrings.getString(selectedWeaponKey), allMurderWeaponCards);
        Card murderRoom=getMurderSuspectCardFromAllAccordingToCardKey(LanguageStrings.getString(selectedRoomKey), allMurderRoomCards);
        Player actualPlayer=getActualPlayer();
        actualPlayer.setSuspectedCardsInActualRound(murder, murderWeapon, murderRoom);
        humanPlayerWaitsForProof(playerToProve);
       
    }
    private void tryToProve(int indexOfPreviousPlayer){
        Player playerWhoWantsToProve= determinePlayerWhoHasToProve(indexOfPreviousPlayer);
        Player actualPlayer=getActualPlayer();
        if(actualPlayer.getIsComputer()){
            humanPlayerWaitsForProof(playerWhoWantsToProve);           
        }else{
            computerPlayerWaitsForProof(playerWhoWantsToProve);
        }
    }
    public void fireDisplayShowProofCardView(Card cardToShow, Player playerWhoShowed){
        playerNumberWhoTriedToShowInThisRound+=1;
        if(cardToShow==null && playerNumberWhoTriedToShowInThisRound<numberOfPlayers-1){
            fireShowInformation(playerWhoShowed.toString()+LanguageStrings.getString("Suspect.WasUnableToProve"));
            int indexOfPreviousPlayer=findPlayerIndex(playerWhoShowed);
            tryToProve(indexOfPreviousPlayer);
        }else{
        gameBoardListener.showProofCardView(cardToShow, playerWhoShowed);
        }
    }
    private Card getMurderSuspectCardFromAllAccordingToCardKey(String selectedCardText, List<Card> suspectCards) {
        int i=0;
        Card card=null;
        while(i<suspectCards.size() && !suspectCards.get(i).getNameForUI().equals(selectedCardText)){
            i+=1;
        }
        if(i<suspectCards.size()){
            card=suspectCards.get(i);
        }
        return card;
    }

    public static int getDrawnNumberOfClockCards() {
        return drawnNumberOfClockCards;
    }
    
    public static void AddOneToClock(){
        drawnNumberOfClockCards++;
    }

    public Room findRoomForPosition(Point point) {
       Set<String> keys=roomMap.keySet();
       Iterator<String> iter=keys.iterator();
       boolean found=false;
       Room room=null;
       while(!found && iter.hasNext()){
           Room actRoom=roomMap.get(iter.next());
           found=actRoom.hasCoordinate(point);
           if(found){
               room=actRoom;
           }
       }
       return room;
    }

    public void setActualPlayer(Player player) {
        players.add(actualPlayerIndex, player);
    }

}
