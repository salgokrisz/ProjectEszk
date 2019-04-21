package cluedo.logic.controller;

import cluedo.logic.cards.Card;
import cluedo.logic.cards.parser.CardParser;
import cluedo.logic.factories.PlayerFactory;
import cluedo.logic.factories.RoomFactory;
import cluedo.logic.fields.Field;
import cluedo.logic.fields.FieldType;
import cluedo.logic.fields.StartField;
import cluedo.logic.map.GameMap;
import cluedo.logic.player.Player;
import cluedo.logic.room.Point;
import cluedo.logic.room.Room;
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
    private final GameMap map;
    //private final Map<String, Room> roomMap;//commented out because pmd
    public GameController(){
        actualGamePhase=GamePhase.INITIAL;
        map=new GameMap("maps/basicmap.txt");
        RoomFactory rf=new RoomFactory(map.getGameMap());
        //roomMap=rf.generateRooms();//commented out because pmd
    }
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }


    public int getNumberOfComputerPlayers() {
        return numberOfComputerPlayers;
    }

    public void setNumberOfComputerPlayers(int numberOfComputerPlayers) {
        this.numberOfComputerPlayers = numberOfComputerPlayers;
    }
    public void registerGameBoardListener(GameBoardListener gameBoardListener){
        this.gameBoardListener=gameBoardListener;
    }
    private int findHumanPlayer(){
        int i=0;
        while(i<players.size() && players.get(i).getIsComputer()){
            i+=1;
        }
        return i;
    }
 
    public void initializePlayers(List<String> playerInformations) {
        PlayerFactory pf = new PlayerFactory();
        players = pf.createPlayers(playerInformations);
        humanPlayerIndex=findHumanPlayer();
        findAndSetStartingFieldsOfThePlayers();
    }

    public List<Player> rollDicesForDecidingStarterPlayer(List<Player> playerList, int humanPlayerRoll) {
        
        for (int i = 0; i < playerList.size(); ++i) {
            int roll=humanPlayerRoll;
            if(playerList.get(i).getIsComputer()){
                roll=Tools.randomizeNumber(6) + 1;
            }
            droppedNumbersForDecidingStart.put(playerList.get(i), roll);
        }
        int maximumIndex = chooseMaximumNumber(droppedNumbersForDecidingStart);
        return findPlayersWithMaxNumber(maximumIndex, droppedNumbersForDecidingStart);
    }

    public void sortPlayers(int humanPlayerRoll) {
        List<Player> playersWithMaxNumber=players;
        boolean diceButtonShouldBePressed=false;
        do {
            if(diceButtonShouldBePressed){
                fireShowWhatToDo("Actions.RollDiceStartAgain");
            }else{
            playersWithMaxNumber = rollDicesForDecidingStarterPlayer(playersWithMaxNumber,humanPlayerRoll);
            }
            diceButtonShouldBePressed=playersWithMaxNumber.size()>1 && playersWithMaxNumber.contains(players.get(humanPlayerIndex));
        } while (playersWithMaxNumber.size() > 1);
        Player starterPlayer = playersWithMaxNumber.get(0);
        Map<Integer, Player> serialNumbers = new TreeMap<>();
        serialNumbers.put(0, starterPlayer);
        int starterIndex = findPlayerIndex(starterPlayer);
        assert starterIndex >= 0 && starterIndex < players.size() : "Players must contain starter player.";
        determinateSerialNumbers(starterIndex,serialNumbers);       
        players.clear();
        Set<Integer> keys = serialNumbers.keySet();
        for (Integer k : keys) {
            players.add(serialNumbers.get(k));
        }
        humanPlayerIndex=findHumanPlayer();
        fireShowInformation(LanguageStrings.getString("JOptionPane.InformationAboutStarterPlayer")+players.get(0).toString());
        actualGamePhase=GamePhase.ROLL;
    }
    
    private void determinateSerialNumbers(int starterIndex,Map<Integer,Player> serialNumbers){
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
        while (placeCounter != players.size() - 1) {
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
        if(playerName == null){
            return false;
        }else{
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

    public void initializeSuspectCards(){
        List<List<Card>> cards=CardParser.parse();
        List<Card> suspectCards=new LinkedList<>();
        for(int i=0; i<3; ++i){
            List<Card> parts=cards.get(i);
            Card killer=chooseKillerCard(parts);
            parts.remove(killer);
            fillUpSupsectCardWithCards(parts, suspectCards);
        }
        Collections.shuffle(suspectCards);
        int remainingCardNumber=suspectCards.size()%numberOfPlayers;
        int cardNumberToShare=suspectCards.size()-remainingCardNumber;
        int playerCounter=0;
        for(int i=0; i<cardNumberToShare; ++i){ 
            players.get(playerCounter).drawSuspectCard(suspectCards.remove(0));
            if(playerCounter==players.size()-1){
                playerCounter=0;
            }else{
                playerCounter+=1;
            }
        }
        fireShowOwnedSuspectCards();
    }
    private void fireShowOwnedSuspectCards(){
        
        gameBoardListener.showAllSuspectCardInformations(players.get(humanPlayerIndex));
    }
    private void fireShowWhatToDo(String message){
        gameBoardListener.showWhatToDo(message);
    }
    public void initializeGame() {
        initializeSuspectCards();
        fireShowWhatToDo(LanguageStrings.getString("Actions.RollDiceStart"));
    }

    private void fillUpSupsectCardWithCards(List<Card> cards, List<Card> suspectCards) {
        Collections.shuffle(cards);
        suspectCards.addAll(cards);
    }
    public void fireShowInformation(String message){
        gameBoardListener.showInformation(message);
    }
    public void rollDice() {
        int droppedNumber;
        if(GamePhase.INITIAL==actualGamePhase){
            droppedNumber=Tools.randomizeNumber(6)+1;
            fireShowInformation(LanguageStrings.getString("JOptionPane.DroppedNumber")+droppedNumber);
            sortPlayers(droppedNumber);
        }else{
            droppedNumber=Tools.randomizeNumber(6)+1;
            int roledNumberTwo=Tools.randomizeNumber(6)+1;
            if(roledNumberTwo==1){
                System.out.println("Needs Inrics!!!"); // It needs to delete after the intrics will be implemented into the if statement. Now it just because of the Pmd.
                //intrics
            }else{
                droppedNumber+=roledNumberTwo;
            }
        }
    }
    
    private void findAndSetStartingFieldsOfThePlayers(){
        for (int i = 0; i<players.size();i++){
            List<List<Field>> fieldMap = map.getGameMap();
            for(int j = 0; j<fieldMap.size();j++){
                for(int k = 0; k<fieldMap.get(j).size();k++){
                    if(fieldMap.get(j).get(k).getType().equals(FieldType.START)){
                        StartField field = (StartField)fieldMap.get(j).get(k);
                        if(players.get(i).getRole().getClass().equals(field.getBelongsTo())){
                            players.get(i).setStartField(new Point(field.getX(),field.getY()));
                        }
                    }                    
                }
            }
        }
    }
}