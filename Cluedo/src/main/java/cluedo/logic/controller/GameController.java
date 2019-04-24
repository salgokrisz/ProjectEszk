package cluedo.logic.controller;

import cluedo.logic.cards.Card;
import cluedo.logic.cards.parser.CardParser;
import cluedo.logic.factories.PlayerFactory;
import cluedo.logic.factories.RoomFactory;
import cluedo.logic.fields.EntranceField;
import cluedo.logic.fields.Field;
import cluedo.logic.fields.FieldType;
import cluedo.logic.intrics.Intrics;
import cluedo.logic.intrics.IntricsParser;
import cluedo.logic.map.GameMap;
import cluedo.logic.player.Ai;
import cluedo.logic.player.Player;
import cluedo.logic.role.Role;
import cluedo.logic.room.EndRoom;
import cluedo.logic.room.Point;
import cluedo.logic.room.Room;
import cluedo.logic.room.SecretCorridoredRoom;
import cluedo.tools.Tools;
import static cluedo.tools.Tools.LOG;
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
import java.util.logging.Level;

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
    private List<Card> allMurderCards=new ArrayList<Card>();
    private List<Card> allMurderWeaponCards=new ArrayList<Card>();
    private List<Card> allMurderRoomCards=new ArrayList<Card>();

    public GameController() {
        actualGamePhase = GamePhase.INITIAL;
        map = new GameMap("maps/basicmap.txt");
        fieldMap = map.getMap();
        RoomFactory rf = new RoomFactory(map.getMap());//commented out because pmd
        roomMap = rf.generateRooms();//commented out because pmd
        actualPlayerIndex = 0;
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
        players = pf.createPlayers(playerInformations, map.getMap());
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
                fireShowInformation(LanguageStrings.getString("JOptionPane.DroppedNumber") + humanPlayerRoll);
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
        StringBuilder message=new StringBuilder(LanguageStrings.getString("JOptionPane.InformationAboutStarterPlayer"));
        if(humanPlayerIndex==actualPlayerIndex){
            message.append(LanguageStrings.getString("JOptionPane.You"));
        }else{
          message.append(players.get(0).toString());  
        }
        fireShowInformation(message.toString());
        actualGamePhase = GamePhase.ROLL;
        if(!players.get(actualPlayerIndex).getIsComputer()){
        fireDisplayRollView();
        }else{
            controlComputerPlayer();
        }
    }
    private void controlComputerPlayer(){
        Ai actualComputerPlayer=(Ai)players.get(actualPlayerIndex);
                    actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.InformationsAboutAi"));
                    actualComputerPlayer.appendToInformation(actualComputerPlayer.toString());
                    actualComputerPlayer.appendToInformation(System.lineSeparator());
        if(actualGamePhase==GamePhase.ROLL){
            int droppedNumber=rollDice();
            StringBuilder sb=new StringBuilder(LanguageStrings.getString("JOptionPane.DroppedNumber"));
            sb.append(droppedNumber).append(System.lineSeparator());
            ((Ai)players.get(actualPlayerIndex)).appendToInformation(sb.toString());
            actualGamePhase=GamePhase.MOVE;
            List<Point> availablePositionsToMove=((Ai)players.get(actualPlayerIndex)).getAvailablePositionsToMove();
            Point destination;
            Field field;
            do{
            destination=availablePositionsToMove.get(Tools.randomizeNumber(availablePositionsToMove.size()));
            field=fieldMap.get(destination.getX()).get(destination.getY());
            }while(field.getType()==FieldType.ROOM); 
            if(field.getType()==FieldType.ENTRANCE){
                actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.AiEnteredRoom"));
                Room room=searchForRoomAccordingToFieldPosition(destination.getX(), destination.getY());
                enterRoom(room, actualPlayerIndex);
                actualComputerPlayer.appendToInformation(LanguageStrings.getString(actualComputerPlayer.getActualRoomName()));
                actualComputerPlayer.appendToInformation(System.lineSeparator());
            }else{
                moveToField(destination.getX(), destination.getY(), actualPlayerIndex);
                actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.AiMoved"));
                actualComputerPlayer.appendToInformation(Integer.toString(destination.getX()+1));
                actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.SerialMark"));
                actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.Row"));
                actualComputerPlayer.appendToInformation(", ");
                actualComputerPlayer.appendToInformation(Integer.toString(destination.getY()+1));
                actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.SerialMark"));
                actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.Column"));
                actualComputerPlayer.appendToInformation(System.lineSeparator());
                if(field.getType()==FieldType.INTRIC){
                    drawIntricCard();
                    actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.AiDrawnIntricCard"));
                    actualComputerPlayer.appendToInformation(System.lineSeparator());
                }
            }
            if(players.get(actualPlayerIndex).getIsInRoom()){
                actualGamePhase=GamePhase.SUSPECT;
                Card murder=actualComputerPlayer.selectSuspect(allMurderCards);
                Card murderWeapon=actualComputerPlayer.selectSuspect(allMurderCards);
                Card murderRoom=actualComputerPlayer.findMurderRoomAccordingToPosition(allMurderRoomCards);
                fireShowInformationsAboutSuspectedCards(murder, murderWeapon, murderRoom);
            }else{
                nextPlayerIsComing();
                
        }
    }
    }
    
    private void fireShowInformationsAboutSuspectedCards(Card murder, Card murderWeapon, Card murderRoom){
        Ai actualComputerPlayer=(Ai)players.get(actualPlayerIndex);
        actualComputerPlayer.appendToInformation(LanguageStrings.getString("Actions.AiSuspectsCards"));
        actualComputerPlayer.appendToInformation(System.lineSeparator());
        actualComputerPlayer.appendToInformation(murder.getNameForUI());
        actualComputerPlayer.appendToInformation(System.lineSeparator());
        actualComputerPlayer.appendToInformation(murderWeapon.getNameForUI());
        actualComputerPlayer.appendToInformation(System.lineSeparator());
        actualComputerPlayer.appendToInformation(murderRoom.getNameForUI());
        actualComputerPlayer.appendToInformation(System.lineSeparator());
        LOG.log(Level.INFO, "Suspected murder Card: "+murder.getNameForUI());
        LOG.log(Level.INFO, "Suspected murder weapon Card: "+murderWeapon.getNameForUI());
        LOG.log(Level.INFO, "Suspected murder room Card: "+murderRoom.getNameForUI());
    }
    private void fireShowInformationsAboutComputerPlayer(){
        Ai actualComputerPlayer=(Ai)players.get(actualPlayerIndex);
        gameBoardListener.showInformation(actualComputerPlayer.getInformationsAboutMovement());
        actualComputerPlayer.resetInformationsAboutMovement();
    }
    private void nextPlayerIsComing(){
        actualGamePhase=GamePhase.ROLL;
        if(players.get(actualPlayerIndex).getIsComputer()){
            fireShowInformationsAboutComputerPlayer();
        }
                changeActualPlayerIndex();
                fireShowNextPlayerMessage();
                if(!players.get(actualPlayerIndex).getIsComputer()){
                    fireDisplayRollView();
                }else{
                    fireDisplayComputerView();
                    controlComputerPlayer();
                }
            
    }
    private void fireDisplayRollView(){
        gameBoardListener.displayRollAndComputerView();
        if(actualGamePhase!=GamePhase.INITIAL){
        fireShowWhatToDo(LanguageStrings.getString("Actions.RollDice"));
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
        List<List<Card>>cards = CardParser.parse();
        List<Card> suspectCards = new LinkedList<>();
        for (int i = 0; i < 3; ++i) {
            List<Card> parts = cards.get(i);
            switch(i){
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
        ((EndRoom) roomMap.get(RoomFactory.ENDROOM_KEY)).setRemainingCards(suspectCards);
        fireShowOwnedSuspectCards();
    }

    public List<Intrics> initializeIntricCards() {
        IntricsParser ip = new IntricsParser();
        List<Intrics> intrics = ip.parseFile("cards/intrics/intrics.txt");
        Collections.shuffle(intrics);
        return intrics;
    }

    private void fireShowOwnedSuspectCards() {

        gameBoardListener.showAllSuspectCardInformations(players.get(humanPlayerIndex));
    }

    private void fireShowWhatToDo(String message) {
        gameBoardListener.showWhatToDo(message);
    }

    public void initializeGame() {
        initializeSuspectCards();
        intricCards = initializeIntricCards(); //it is commented out becuse of pmd it will be needed later
        fireDisplayRollView();
        fireShowWhatToDo(LanguageStrings.getString("Actions.RollDiceStart"));
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
            fireShowInformation(LanguageStrings.getString("JOptionPane.DroppedNumber") + droppedNumber);
            sortPlayers(droppedNumber);
        } else {
            fireEnableRollDiceButton(false);
            droppedNumber = Tools.randomizeNumber(6) + 1;
            int roledNumberTwo = Tools.randomizeNumber(6) + 1;
            if (roledNumberTwo == 1) {
                Intrics drawnCard=drawIntricCard();
                if(!players.get(actualPlayerIndex).getIsComputer()){
                    fireShowInformation(LanguageStrings.getString("Actions.DroppedIntric"));
                fireShowDrawnIntricCardInfo(drawnCard);
                }
                //intrics
            } else {
                droppedNumber += roledNumberTwo;
            }
            if(!players.get(actualPlayerIndex).getIsComputer()){
            fireShowInformation(LanguageStrings.getString("JOptionPane.DroppedNumber") + droppedNumber);
            }
            actualGamePhase=GamePhase.MOVE;
                List<Point> availablePositions=chooseAvailableFieldsInARadius(droppedNumber);
            if(!players.get(actualPlayerIndex).getIsComputer()){
                fireDisplayMoveView(availablePositions);
            }else{
                ((Ai)players.get(actualPlayerIndex)).setAvailablePositionsToMove(availablePositions);
            }
        }
        return droppedNumber;
    }
    private void fireDisplayMoveView(List<Point> availablePositions){
        gameBoardListener.displayMoveView(availablePositions);
    }
    private void fireShowDrawnIntricCardInfo(Intrics drawnCard){
        gameBoardListener.showDrawnIntricCardInfo(drawnCard);
    }
    private void fireEnableRollDiceButton(boolean isEnabled){
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
        players.get(actualPlayerIndex).addIntricCard(intric);
        return intric;
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

    public void enterRoom(Room room, int playerIndex) {
        Point newPosition = findFreePositionInRoom(room);
        moveToField(newPosition.getX(), newPosition.getY(), playerIndex);
        players.get(playerIndex).setIsInRoom(true);
        players.get(playerIndex).setActualRoomName(room.getName());
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
        Field field=fieldMap.get(x).get(y);
        field.modifyPlayerNumber(1, numberOfPlayers);
        Point newPosition = new Point(x, y);
        player.setPosition(newPosition);
        if (fieldMap.get(x).get(y).getType() != FieldType.ROOM) {
            player.setIsInRoom(false);
            player.setActualRoomName("");
        }
        fireShowMovementOfPlayer(oldPosition, player);
        Player actualPlayer=players.get(actualPlayerIndex);
        if(field.getType()==FieldType.INTRIC && !actualPlayer.getIsComputer()){
            Intrics intricCard = drawIntricCard();
            fireShowDrawnIntricCardInfo(intricCard);
        }
        fireReEnableFieldButtons();
        if(!actualPlayer.getIsComputer()){
        if(actualPlayer.getIsInRoom() && !actualPlayer.getSuspectedInThisRound()){
            actualGamePhase=GamePhase.SUSPECT;
                fireShowSuspectView();
        }else{
            nextPlayerIsComing();
        }
        }
    }
    public Player getActualPlayer(){
        return players.get(actualPlayerIndex);
    }
    private void fireReEnableFieldButtons(){
        gameBoardListener.enableFieldButtons(true);
    }
    private void fireShowSuspectView(){
        gameBoardListener.showSuspectView();
    }
    private void fireDisplayComputerView(){
        gameBoardListener.displayRollAndComputerView();
    }
    private void fireShowNextPlayerMessage(){
        StringBuilder message=new StringBuilder(LanguageStrings.getString("JOptionPane.NextPlayer"));
        
        if(actualPlayerIndex==humanPlayerIndex){
            message.append(LanguageStrings.getString("JOptionPane.You"));
        }else{
            message.append(players.get(actualPlayerIndex).toString()).append(System.lineSeparator());
        }
        gameBoardListener.showInformation(message.toString());
    }
    public void changeActualPlayerIndex(){
        if(actualPlayerIndex==numberOfPlayers-1){
            actualPlayerIndex=0;
        }else{
            actualPlayerIndex+=1;
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
        Point actualPlayerPosition=players.get(actualPlayerIndex).getPosition();
        List<Point> availablePointsOfFields=new ArrayList<>();
        availablePointsOfFields.add(actualPlayerPosition);
        int minRow=actualPlayerPosition.getX()-droppedNumber;
        int maxRow=actualPlayerPosition.getX()+droppedNumber;
        int minColumn=actualPlayerPosition.getY()-droppedNumber;
        int maxColumn=actualPlayerPosition.getY()+droppedNumber;
        for(int i=minRow; i<maxRow; ++i){
            if(i>=0 && i<fieldMap.size()){
            for(int j=minColumn; j<maxColumn; ++j){
                if(j>=0 && j<fieldMap.get(i).size()){
                    availablePointsOfFields.add(new Point(fieldMap.get(i).get(j).getX(), fieldMap.get(i).get(j).getY()));
                }
            }
            }
        }
        return availablePointsOfFields;
    }

    public void playerUsesSpecialAbility(Player player) {
        player.getRole().useSpecialAbility();
    }
}
